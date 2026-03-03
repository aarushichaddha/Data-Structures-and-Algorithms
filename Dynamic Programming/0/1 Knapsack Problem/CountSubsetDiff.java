// Count the number of subset with the given differece OR Target Sum
class CountSubsetDiff{
    public int subset(int nums[], int diff){
        int sum=0;
        int n = nums.length;
        for(int x=0;x<n;x++){
            sum+=nums[x];
        }

        int arr_sum1 = (diff+sum)/2;

        return countSubset(nums, arr_sum1);
    }

    public int countSubset(int nums[], int sum){

        int n = nums.length;
        int dp[][] = new int[n+1][sum+1];
        for(int x=0;x<n+1;x++)
            dp[x][0] = 1;

        for(int x=1;x<n+1;x++){
            for(int y=1;y<sum+1;y++){
                if(nums[x-1]<=y){
                    dp[x][y] = dp[x-1][y] + dp[x-1][y-nums[x-1]];
                }
                else{
                    dp[x][y] = dp[x-1][y];
                }
            }
        }

        return dp[n][sum];
    }

    public static void main(String args[]){
        CountSubsetDiff obj = new CountSubsetDiff();
        int nums[] = {1,1,2,3};
        int diff=1;
        int result = obj.subset(nums, diff);
        System.out.println(result);
    }

}