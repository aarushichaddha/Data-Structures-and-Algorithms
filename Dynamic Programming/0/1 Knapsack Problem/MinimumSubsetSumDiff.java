public class MinimumSubsetSumDiff {

    public int minDifference(int arr[]) {
        int n = arr.length;
        int sum = 0;
        
        for(int x=0;x<n;x++)
        sum+=arr[x];
        
        boolean dp[][] = new boolean[n+1][sum+1];
        
        for(int y=0;y<=sum;y++){
            dp[0][y] = false;
        }
        
        for(int x=0;x<=n;x++){
            dp[x][0] = true;
        }
        
        for(int x=1;x<=n;x++){
            for(int y=1;y<=sum;y++){
                if(arr[x-1]<=y){
                    dp[x][y] = dp[x-1][y-arr[x-1]] || dp[x-1][y];
                }
                else{
                    dp[x][y] = dp[x-1][y];
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        boolean range[] = new boolean[sum+1/2];
        for(int x=0;x<sum+1/2;x++)
        {
            range[x] = dp[n][x];
            if(range[x]==true){
                min = Math.min(min, Math.abs(sum-2*x));
            }
        }
        
        return min;
    }

        public static void main(String args[]){
        MinimumSubsetSumDiff obj = new MinimumSubsetSumDiff();
        int nums[] = {1, 6, 11, 5};
        System.out.println(obj.minDifference(nums));
    }
}