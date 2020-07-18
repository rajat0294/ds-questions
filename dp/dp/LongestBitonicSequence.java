package dp;

public class LongestBitonicSequence {

    public static int longestBitonicSequence(int[] arr){
        int[] longestIncreasingDp=longestIncreasingSequenceTabulated(arr);
        int[] longestDecreasingDp=longestDecreasingSequenceFromRightTabulated(arr);
        int maxBitoniclength=0;
        for(int i=0;i<arr.length;i++){
            int lengthAti=longestIncreasingDp[i]+longestDecreasingDp[i]-1;
            if(lengthAti>maxBitoniclength){
                maxBitoniclength=lengthAti;
            }
        }

        return maxBitoniclength;
    }

    public static int[] longestIncreasingSequenceTabulated(int[] arr){
        int[] dp = new int[arr.length];
        dp[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    if(dp[i]<dp[j]){
                        dp[i]=dp[j];
                    }
                }
            }
            dp[i]=dp[i]+1;
        }
        return dp;
    }

    public static int[] longestDecreasingSequenceFromRightTabulated(int[] arr){
        int[] dp=new int[arr.length];
        dp[arr.length-1]=1;
        for(int i=arr.length-2;i>=0;i--){
            for(int j=arr.length-1;j>i;j--){
                if(arr[j]<arr[i]){
                    if(dp[i]<dp[j]){
                        dp[i]=dp[j];
                    }
                }
            }
            dp[i]=dp[i]+1;
        }
        return dp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80, 1};
        System.out.println(longestBitonicSequence(arr));
    }

}


