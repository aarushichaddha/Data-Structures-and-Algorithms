class LCS_Recursive{
    public int LCS(String X, String Y, int m, int n){
        if(m==0 || n==0)
            return 0;
        if(X.charAt(m-1)==Y.charAt(n-1))
            return 1+LCS(X,Y,m-1,n-1);
        else
            return Math.max(LCS(X,Y,m,n-1), LCS(X,Y,m-1,n));
    }

    public static void main(String args[]){
        LCS_Recursive obj = new LCS_Recursive();
        int result = obj.LCS("abcdgh", "abedfhr",6,7);
        System.out.println(result);

    }
}