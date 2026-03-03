public class Palin_Partitioning_recursive {

    public int solve(String s, int i, int j) {

        if (i >= j)
            return 0;

        if (isPalindrome(s, i, j))
            return 0;

        int ans = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int temp = 1 + solve(s, i, k) + solve(s, k + 1, j);
            ans = Math.min(ans, temp);
        }

        return ans;
    }

    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String args[]) {
        Palin_Partitioning_recursive obj = new Palin_Partitioning_recursive();
        String s = "ababbbabbababa";
        int result = obj.solve(s, 0, s.length() - 1);
        System.out.println(result);
    }
}

