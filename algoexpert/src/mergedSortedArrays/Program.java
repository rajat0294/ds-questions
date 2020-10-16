package src.mergedSortedArrays;

import java.util.*;

class Program {
    public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {
        // Write your code here.
        MinHeap minHeap=new MinHeap(arrays.size());
        int[] arrayIndexes=new int[arrays.size()];
        List<Integer> l=new ArrayList<Integer>();
        int totalEle=0;
        for(int i=0;i<arrays.size();i++){
            minHeap.insert(arrays.get(i).get(0),i);
            totalEle+=arrays.get(i).size();
        }
        while(l.size()<totalEle){
            MinHeapNode node=minHeap.getMin();
            if(node!=null){
                l.add(node.value);
                arrayIndexes[node.arrayIndex]++;
                if(arrayIndexes[node.arrayIndex]<arrays.get(node.arrayIndex).size()){
                    minHeap.insert(arrays.get(node.arrayIndex).get(arrayIndexes[node.arrayIndex]),node.arrayIndex);
                }
            }
        }
        return l;
    }

    public static class MinHeapNode{
        int arrayIndex;
        int value;
        public MinHeapNode(int value,int arrayIndex){
            this.value=value;
            this.arrayIndex=arrayIndex;
        }
    }

    public static class MinHeap{
        int size;
        int capacity;
        MinHeapNode[] array;

        public MinHeap(int capacity){
            this.array=new MinHeapNode[capacity];
            this.capacity=capacity;
        }

        public void buildHeap(){
            for(int i=(size-2)/2;i>=0;i--){
                minHeapify(i);
            }
        }

        public void minHeapify(int i){
            int left=2*i+1;
            int right=2*i+2;

            int smallest=i;
            if(left<size && array[left].value<array[i].value){
                smallest=left;
            }

            if(right<size && array[right].value<array[smallest].value){
                smallest=right;
            }

            if(smallest!=i){
                MinHeapNode temp=this.array[i];
                this.array[i]=this.array[smallest];
                this.array[smallest]=temp;
                minHeapify(smallest);
            }
        }

        public MinHeapNode getMin(){
            if(size==0){
                return null;
            }
            if(size==1){
                MinHeapNode result=array[0];
                size--;
                return result;
            }
            MinHeapNode temp=array[0];
            array[0]=array[size-1];
            array[size-1]=temp;
            size=size-1;
            return temp;
        }

        public void insert(int number,int arrayIndex){
            if(this.size<this.capacity){
                array[this.size]=new MinHeapNode(number,arrayIndex);
                this.size++;
                buildHeap();
            }
        }
    }

}