package practice;

import java.util.*;

class Test5 {
    public static int quickselect(int[] array, int k) {
        // Write your code here.
        return getPivotPosition(array,0,array.length-1,k-1);
    }

    public static int getPivotPosition(int[] array,int start,int end,int k){
        while(true){
            if(start > end){
                throw new RuntimeException("You made an error");
            }
            int pivot=start;
            int i=start+1;
            int j=end;

            while(i<=j){
                if(array[i]>array[pivot] && array[j]<array[pivot]){
                    int temp=array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }
                if(array[i]<=array[pivot]){
                    i++;
                }
                if(array[j]>=array[pivot]){
                    j--;
                }

            }

            int temp=array[j];
            array[j]=array[pivot];
            array[pivot]=temp;

            if(j==k){
                return array[j];
            }else if(j<k){
                start=j+1;
            }else{
                end=j-1;
            }
        }
    }

    public static void main(String[] args) {
      int answer=quickselect(new int[]{8, 5, 2, 9, 7, 6, 3},3);
        System.out.println(answer);

    }
}

