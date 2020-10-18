package basic.paintHouse;

import java.util.Scanner;

public class PaintHouse {
    //paint houses with only three colors i.e Red,Green,Blue

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();

        int[][] costs=new int[n][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                costs[i][j]=scanner.nextInt();
            }
        }
        System.out.println(paintHouse(costs));
      /*  int[][] costs=new int[][]{
                {1,5,7},{5,8,4},{3,2,9},{1,2,4}
        };
        System.out.println(paintHouse(costs))*/;

    }

    public static int paintHouse(int[][] costs){
     int[][] dp=new int[costs.length][3];
     for(int j=0;j<costs[0].length;j++){
         dp[0][j]=costs[0][j];
     }
     for(int i=1;i<costs.length;i++){
         for (int j=0;j<costs[0].length;j++){
             //find minimum in ith row
             int min=dp[i-1][0];
             for(int k=1;k<costs[0].length;k++){
                 if(j!=k) {
                     min = Math.min(dp[i - 1][k], min);
                 }
             }
             dp[i][j]=min+costs[i][j];
         }
     }
     int finalResult=dp[costs.length-1][0];
     for(int k=1;k<costs[0].length;k++){
         finalResult=Math.min(dp[costs.length-1][k],finalResult);
        }
     return finalResult;
    }

    public static int paintHouseManyColors(int[][] costs,int totalColors){
        int[][] dp=new int[costs.length][totalColors];
        for(int j=0;j<costs[0].length;j++){
            dp[0][j]=costs[0][j];
        }
        for(int i=1;i<costs.length;i++){
            for (int j=0;j<costs[0].length;j++){
                //find minimum in ith row
                int min=dp[i-1][0];
                for(int k=1;k<totalColors;k++){
                    if(j!=k) {
                        min = Math.min(dp[i - 1][k], min);
                    }
                }
                dp[i][j]=min+costs[i][j];
            }
        }
        int finalResult=dp[costs.length-1][0];
        for(int k=1;k<costs[0].length;k++){
            finalResult=Math.min(dp[costs.length-1][k],finalResult);
        }
        return finalResult;
    }

}
