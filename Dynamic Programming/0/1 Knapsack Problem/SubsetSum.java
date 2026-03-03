public class SubsetSum {
    public boolean subset(int nums[], int sum){
        int n = nums.length;
        boolean dp[][] = new boolean[n+1][sum+1];

        for(int y=0;y<=sum;y++){
            dp[0][y] = false;
        }

        for(int x=0;x<=n;x++){
            dp[x][0] = true;
        }

        for(int x=1;x<=n;x++){
            for(int y=1;y<=sum;y++){
                if(nums[x-1]<=y){
                    dp[x][y] = dp[x-1][y-nums[x-1]] || dp[x-1][y];
                }
                else{
                    dp[x][y] = dp[x-1][y];
                }
            }
        }

        return dp[n][sum];
    }

    public static void main(String args[]){
        SubsetSum obj = new SubsetSum();
        int nums[] = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        System.out.println(obj.subset(nums, sum));
    }
}
