package practice;


// { Driver Code Starts

import java.io.IOException;
import java.util.Scanner;

class Test
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t=0; t<T; t++)
        {
            int N = sc.nextInt();
            int M = sc.nextInt();
            System.out.println(new BlackAndWhite().solve(N, M));
        }
    }
}// } Driver Code Ends
class BlackAndWhite
{
    static long count=0;
    static long solve(int N, int M)
    {
        boolean board[][]=new boolean[N][M];
        count=0;
        countWays(board,0);
        return (N*M)*((N*M)-1l)-count;
    }

    static void  countWays(boolean[][] board,int kpsf)
    {
        for (int i = 0; i < board.length * board[0].length; i++) {
            int row = i / board[0].length;
            int col = i % board[0].length;
            count=count+isKnightSafe(board,row,col);
            }
        System.out.println(count+">>>");
    }

    static long isKnightSafe(boolean[][]board,int row,int col)
    {
        int counter=0;
        int dirs[][]={{-2,1},{-2,-1},{1,2},{1,-2},{2,1},{2,-1},{-1,2},{-1,-2}};
        for(int i=0;i<dirs.length;i++)
        {
            int eqRow=row+dirs[i][0];
            int eqCol=col+dirs[i][1];
            if(eqRow<0 || eqRow>=board.length || eqCol<0 || eqCol>=board[0].length)
            {
                continue;
            }
                counter++;
        }
        return counter;
    }
}
