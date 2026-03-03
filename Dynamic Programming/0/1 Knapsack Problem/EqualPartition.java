public class EqualPartition {
    public boolean partition(int nums[]){
        int n = nums.length;
        int sum=0;
        for(int x=0;x<n;x++){
            sum+=nums[x];
        }

        if(sum%2!=0)
            return false;
        else
            return subset(nums, sum/2);

    }

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
        EqualPartition obj = new EqualPartition();
        int nums[] = {1, 5, 11, 5};
        System.out.println(obj.partition(nums));
    }
}
