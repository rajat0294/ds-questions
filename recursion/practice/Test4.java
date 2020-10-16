package practice;


import java.util.ArrayList;
import java.util.Arrays;

class Test4 {
    public static int[] quickSort(int[] array) {
        // Write your code here
        quickSort(array,0,array.length-1);
        return array;
    }
    public static void quickSort(int[] array,int start,int end){
        if(start<end){
            int pivot=getPivotIndex(array,start,end);
            quickSort(array,start,pivot-1);
            quickSort(array,pivot+1,end);
        }
    }
    public static int getPivotIndex(int[] array,int start,int end){
        int pivot=end;
        int startIdx=start;
        int endIdx=end-1;
        while(startIdx<=endIdx){

            if(array[startIdx]>array[pivot] && array[endIdx]<array[pivot]){
                int temp=array[endIdx];
                array[endIdx]=array[startIdx];
                array[startIdx]=temp;
            }
            if(array[startIdx]<=array[pivot]){
                startIdx++;
            }
            if(array[endIdx]>=array[pivot]){
                endIdx--;
            }
        }
        int temp=array[pivot];
        array[pivot]=array[endIdx+1];
        array[endIdx+1]=temp;
        return endIdx+1;
    }

    public static void main(String[] args) {
        int[] array=quickSort(new int[]{8, 5, 2, 9, 5, 6, 3});
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }
}
