public class MaxCoinChange {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int dp[][] = new int[n+1][amount+1];

        for(int y=0;y<=amount;y++){
            dp[0][y] = 0;
        }

        for(int x=0;x<=n;x++){
            dp[x][0] = 1;
        }

        for(int x=1;x<=n;x++){
            for(int y=1;y<=amount;y++){
                if(coins[x-1]<=y){
                    dp[x][y] = dp[x][y-coins[x-1]] + dp[x-1][y];
                }

                else{
                    dp[x][y] = dp[x-1][y];
                }
            }
        }

        return dp[n][amount];
    }

    public static void main(String args[]){
        MaxCoinChange obj = new MaxCoinChange();
        int coins[] = {1,2,3};
        int amount = 4;
        System.out.println(obj.change(amount,coins));

    }
}
