public class CountSubsetSum {
    public int subsetSum(int nums[], int sum){
        int n = nums.length;
        int dp[][] = new int[n+1][sum+1];

        for(int y=0;y<=sum;y++){
            dp[0][y] = 0;
        }

        for(int x=0;x<=n;x++){
            dp[x][0] = 1;
        }

        for(int x=1;x<=n;x++){
            for(int y=1;y<=sum;y++){
                if(nums[x-1]<=y){
                    dp[x][y] = dp[x-1][y-nums[x-1]] + dp[x-1][y];
                }

                else{
                    dp[x][y] = dp[x-1][y];
                }
            }
        }

        return dp[n][sum];
    }

        public static void main(String args[]){
        CountSubsetSum obj = new CountSubsetSum();
        int nums[] = {1, 2, 3, 3};
        int sum = 6;
        System.out.println(obj.subsetSum(nums, sum));
    }
}
