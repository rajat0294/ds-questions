package src.heapSort;

import java.util.*;

class Program {
    public static int[] heapSort(int[] array) {
        // Write your code here.
        MinHeap minHeap=new MinHeap(array);
        minHeap.buildHeap();
        return minHeap.array;
    }

    public static class MinHeap{
        int[] array;
        int size;

        public MinHeap(int[] array){
            this.array=array;
            this.size=array.length;
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
            if(left<size && this.array[left]<this.array[i]){
                smallest=left;
            }

            if(right<size && this.array[right]<this.array[smallest]){
                smallest=right;
            }

            if(smallest!=i){
                int temp=this.array[i];
                this.array[i]=this.array[smallest];
                this.array[smallest]=temp;
                minHeapify(smallest);
            }

        }
    }
}
