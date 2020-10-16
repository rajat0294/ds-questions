package src.continuous.median;

import java.util.*;

// Do not edit the class below except for
// the insert method. Feel free to add new
// properties and methods to the class.
class Program {
    static class ContinuousMedianHandler {
        double median = 0;
        PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(Collections.reverseOrder());

        PriorityQueue<Integer> minHeap=new PriorityQueue<Integer>();

        public void insert(int number) {
            // Write your code here.
            if(maxHeap.size()==0){
                maxHeap.add(number);
                return;
            }
            if(minHeap.size()==0){
                if(number>maxHeap.peek()){
                    minHeap.add(number);
                }else{
                    int temp=maxHeap.poll();
                    minHeap.add(temp);
                    maxHeap.add(number);
                }
                return;
            }


            if(minHeap.size()==maxHeap.size()){
                if(number<minHeap.peek()){
                    maxHeap.add(number);
                }else{
                    int temp=minHeap.poll();
                    maxHeap.add(temp);
                    minHeap.add(number);
                }
            }else{
                if(number>maxHeap.peek()){
                    minHeap.add(number);
                }else{
                    int temp=maxHeap.poll();
                    minHeap.add(temp);
                    maxHeap.add(number);
                }
            }
        }

        public double getMedian() {
            if(minHeap.size()==maxHeap.size()){
                median=(minHeap.peek()+maxHeap.peek())/2.0;
            }else{
                median=maxHeap.peek();
            }
            return median;
        }
    }
}

