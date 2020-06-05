package practice;

// { Driver Code Starts

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

class Test2 {


    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for(int t=0;t<testCases;t++){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            System.out.print("()");
            new solve().printAllSubsets(arr,n);
            System.out.println();
        }
    }
}// } Driver Code Ends


class solve{

    public static void printAllSubsets(int arr[], int n){
        // your code here
        Arrays.sort(arr);
        LinkedHashSet<String> result=new LinkedHashSet<String>();
        combinations(arr,0,"",result);
        for (String c : result) {
            System.out.print(c);
        }
    }

    static void combinations(int[] arr,int index,String ansf, LinkedHashSet<String> result)
    {
        if (index == arr.length ) {
            if(!ansf.trim().equalsIgnoreCase("")) {
                result.add("(" + ansf.trim() + ")");
            }
            return;
        }
        for (int i =index; i < arr.length; i++) {
            combinations(arr, i+1, ansf, result);
            combinations(arr, i+1, ansf + " " + arr[i], result);
        }
    }
}