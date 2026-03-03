public class LCS_Insert_Delete {
        public void LCS(String X, String Y){
            int m = X.length();
            int n = Y.length();
        int dp[][] = new int[m+1][n+1];
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
                    dp[x][y] = 1+dp[x-1][y-1];
                else
                    dp[x][y] = Math.max(dp[x-1][y], dp[x][y-1]);
            }
        }
        System.out.println( "No. of Insertion : "+ (n - dp[m][n]));
        System.out.println( "No. of Deletion : "+ (m - dp[m][n]));
    }

    public static void main(String args[]){
        LCS_Insert_Delete obj = new LCS_Insert_Delete();
        obj.LCS("geeksforgeeks", "geeks");

    }
}
