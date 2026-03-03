public class Min_insertion_palin {
    public int LCS(String s1){
        StringBuilder sb = new StringBuilder(s1);
        String s2 = sb.reverse().toString();

        if(s1.equals(s2))
            return 0;
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
        return dp[m][n];
    }

    public static void main(String args[]){
        Min_insertion_palin obj = new Min_insertion_palin();
        int result = obj.LCS("ab");
        System.out.println(result);

    }
    
}

