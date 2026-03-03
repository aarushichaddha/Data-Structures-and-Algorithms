public class Longest_Repeating_Subsequence {
        public String LRS(String s1){
        
        String s2 = s1;
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
                if(s1.charAt(x-1)==s2.charAt(y-1) && x!=y)
                    dp[x][y] = 1+dp[x-1][y-1];
                else
                    dp[x][y] = Math.max(dp[x-1][y], dp[x][y-1]);
            }
        }
        int x = m;
        int y = n;

        StringBuilder sb = new StringBuilder();

        while(x>0 && y>0){
            if(s1.charAt(x-1) == s2.charAt(y-1) && x!=y){
                sb.append(s1.charAt(x-1));
                x--;
                y--;
            }
            else if(dp[x-1][y] > dp[x][y-1]){
                x--;
            }
            else{
                y--;
            }
        }

        return sb.reverse().toString();
    }

    public static void main(String args[]){
        Longest_Repeating_Subsequence obj = new Longest_Repeating_Subsequence();
        String result = obj.LRS("aab");
        System.out.println(result);

    }
}
