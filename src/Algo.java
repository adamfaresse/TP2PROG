package src;

import java.util.Arrays;

public class Algo {
    private String firstword;
    private String secondword;
    public Algo(String firstword , String secondword){
        this.firstword = firstword;
        this.secondword = secondword;
    }
    int calculate() {
        int[][] dp = new int[firstword.length() + 1][secondword.length() + 1];

        for (int i = 0; i <= firstword.length(); i++) {
            for (int j = 0; j <= secondword.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                }
                else if (j == 0) {
                    dp[i][j] = i;
                }
                else {
                    dp[i][j] = min(dp[i - 1][j - 1]
                                    + costOfSubstitution(firstword.charAt(i - 1), secondword.charAt(j - 1)),
                            dp[i - 1][j] + 1,
                            dp[i][j - 1] + 1);
                }
            }
        }

        return dp[firstword.length()][secondword.length()];
    }
    public static int costOfSubstitution(char a, char b) {
        return a == b ? 0 : 1;
    }

    public static int min(int... numbers) {
        return Arrays.stream(numbers)
                .min().orElse(Integer.MAX_VALUE);
    }
}
