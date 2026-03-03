import java.util.Arrays;

public class Palin_Partitioning_memoization {
    int dp[][] = new int[1001][1001];

    public Palin_Partitioning_memoization() {
        for (int i = 0; i < 1001; i++)
            Arrays.fill(dp[i], -1);
    }

    public int solve(String s, int i, int j) {

        if (i >= j)
            return 0;

        if (isPalindrome(s, i, j))
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int ans = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int left, right;

            if (dp[i][k] != -1)
                left = dp[i][k];
            else
                left = solve(s, i, k);

            if (dp[k + 1][j] != -1)
                right = dp[k + 1][j];
            else
                right = solve(s, k + 1, j);

            int temp = 1 + left + right;
            ans = Math.min(ans, temp);
        }

        return dp[i][j] = ans;
    }

    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String args[]) {
        Palin_Partitioning_memoization obj = new Palin_Partitioning_memoization();
        String s = "ababbbabbababa";
        System.out.println(obj.solve(s, 0, s.length() - 1));
    }
}
