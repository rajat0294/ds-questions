package dp;

public class PalindromicSubsequenceProblem {

    public static int countPalindromicSubsequence(String inputString) {

        boolean[][] dp = new boolean[inputString.length()][inputString.length()];
        for (int i = 0; i < inputString.length(); i++) {
            for (int j = 0; j < inputString.length(); j++) {
                if (j < i) {
                    dp[i][j] = false;
                } else if (i == j) {
                    dp[i][j] = true;
                }
            }
        }

        int count = 0;
        for (int i = inputString.length(); i >0; i--) {
            for (int j = 0; j < inputString.length(); j++) {
                if (i < j) {
                    if (inputString.charAt(i) == inputString.charAt(j)) {
                        if(i+1 < j-1) {
                            dp[i][j] = dp[i + 1][j - 1];
                        }else{
                            dp[i][j]=true;
                        }
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }

        for (int i = 0; i < inputString.length(); i++) {
            for (int j = 0; j < inputString.length(); j++) {
                if (dp[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPalindromicSubsequence("aba"));
    }

}
