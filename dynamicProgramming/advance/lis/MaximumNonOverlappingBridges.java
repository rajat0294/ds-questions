package advance.lis;

import java.io.*;
import java.util.*;

public class MaximumNonOverlappingBridges {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        Bridge[] bridges=new Bridge[n];
        for(int i=0;i<n;i++){
            bridges[i]=new Bridge(scanner.nextInt(),scanner.nextInt());
        }
        System.out.println(getMaxNonOverlappingBridges(bridges));
    }


    static class Bridge implements Comparable<Bridge>{
        int n;
        int s;

        public Bridge(int n, int s) {
            this.n = n;
            this.s = s;
        }

        public int getN() {
            return n;
        }

        public void setN(int n) {
            this.n = n;
        }

        public int getS() {
            return s;
        }

        public void setS(int s) {
            this.s = s;
        }

        public int compareTo(Bridge o){
            if(this.n!=o.n){
                return this.n-o.n;
            }else{
                return this.s-o.s;
            }
        }
    }

    private static int getMaxNonOverlappingBridges(Bridge[] bridges){
        Arrays.sort(bridges);
        int dp[]=new int[bridges.length];
        for(int i=0;i<bridges.length;i++){
            int max=1;
            for(int j=0;j<i;j++){
                if( bridges[i].getS()>=bridges[j].getS() && dp[j]+1>max){
                    max=dp[j]+1;
                }
            }
            dp[i]=max;
        }
        int max=1;
        for(int k=0;k<bridges.length;k++){
            max=Math.max(dp[k],max);
        }
        return max;
    }

}