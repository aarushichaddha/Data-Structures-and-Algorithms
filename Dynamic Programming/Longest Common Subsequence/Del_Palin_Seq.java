public class Del_Palin_Seq {
    public int LCS(String s1){
        
        StringBuilder sb = new StringBuilder(s1);
        String s2 = sb.reverse().toString();

        int m = s1.length();
        int n = s2.length();

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
                if(s1.charAt(x-1)==s2.charAt(y-1))
                    dp[x][y] = 1+dp[x-1][y-1];
                else
                    dp[x][y] = Math.max(dp[x-1][y], dp[x][y-1]);
            }
        }
        return m - dp[m][n];
    }

    public static void main(String args[]){
        Del_Palin_Seq obj = new Del_Palin_Seq();
        int result = obj.LCS("aebcbda");
        System.out.println(result);

    }
}
