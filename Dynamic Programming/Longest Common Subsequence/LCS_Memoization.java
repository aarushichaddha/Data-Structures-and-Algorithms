import java.util.Arrays;

class LCS_Memoization{
    static int dp[][] = new int[1001][1001];
    public int LCS(String X, String Y, int m, int n){
        if(m==0 || n==0)
            return 0;
        if(dp[m][n]!=-1)
            return dp[m][n];
        if(X.charAt(m-1)==Y.charAt(n-1))
            return dp[m][n] = 1+LCS(X,Y,m-1,n-1);
        else
            return dp[m][n] = Math.max(LCS(X,Y,m,n-1), LCS(X,Y,m-1,n));
    }

    public static void main(String args[]){
        LCS_Memoization obj = new LCS_Memoization();
        for (int i = 0; i < 1001; i++) {
            Arrays.fill(dp[i], -1);
        }
        int result = obj.LCS("abcdgh", "abedfhr",6,7);
        System.out.println(result);

    }
}