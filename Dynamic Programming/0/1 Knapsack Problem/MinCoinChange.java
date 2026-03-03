public class MinCoinChange {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int INF = (int)1e9;

        int dp[][] = new int[n+1][amount+1];

         for(int y=1;y<=amount;y++){
            dp[0][y] = INF;
        }

        for(int x=0;x<=n;x++){
            dp[x][0] = 0;
        }

        for(int x=1;x<=n;x++){
            for(int y=1;y<=amount;y++){
                if(coins[x-1]<=y){
                    dp[x][y] = Math.min(1+dp[x][y-coins[x-1]], dp[x-1][y]);
                }
                else{
                    dp[x][y] = dp[x-1][y];
                }
            }
        }

        return dp[n][amount]>=INF?-1:dp[n][amount];
    }

        public static void main(String args[]){
        MinCoinChange obj = new MinCoinChange();
        int coins[] = {25, 10, 5};
        int amount = 30;
        System.out.println(obj.coinChange(coins,amount));

    }
}
