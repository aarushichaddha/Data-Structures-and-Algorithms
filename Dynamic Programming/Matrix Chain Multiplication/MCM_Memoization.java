import java.util.Arrays;
public class MCM_Memoization {
    int dp[][] = new int[1001][1001];

    public MCM_Memoization() {
        for (int i = 0; i < 1001; i++)
            Arrays.fill(dp[i], -1); 
    }

        public int solve(int arr[], int i, int j){

        int ans = Integer.MAX_VALUE;
        if(i>=j)
            return 0;

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        for(int k = i; k<j; k++){
            int tmpans = solve(arr, i, k) + solve(arr, k+1, j) + arr[i-1]*arr[k]*arr[j];

            ans = Math.min(ans, tmpans);
        }

        dp[i][j] = ans;
        return dp[i][j];

    }

    public static void main(String args[]){
        MCM_Recursive obj = new MCM_Recursive();
        int arr[] = {1, 2, 3, 4};
        int result = obj.solve(arr, 1,arr.length-1);
        System.out.println(result);
    }
}
