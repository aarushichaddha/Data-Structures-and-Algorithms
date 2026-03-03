public class Longest_Common_Substring {
        public int LCS(String X, String Y, int m, int n){
        int dp[][] = new int[m+1][n+1];
        int maxLen = 0;
        for(int x=0;x<m+1;x++){
            for(int y=0;y<n+1;y++){
                if(x==0 || y==0)
                dp[x][y] = 0;
            }
        }
        for(int x=1;x<m+1;x++){
            for(int y=1;y<n+1;y++)
            {
                if(X.charAt(x-1)==Y.charAt(y-1))
                {
                    dp[x][y] = 1+dp[x-1][y-1];
                    maxLen = Math.max(maxLen, dp[x][y]);
                }
                else
                    dp[x][y] = 0;
            }
        }
        return maxLen;
    }

    public static void main(String args[]){
        Longest_Common_Substring obj = new Longest_Common_Substring();
        int result = obj.LCS("GeeksforGeeks", "GeeksQuiz",13,9);
        System.out.println(result);

    }
}
