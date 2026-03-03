class Parenthesization_recursive{
    int solve(String s, int i, int j, boolean isTrue){
        if(i>j)
            return 0;
        if(i==j){
            if(isTrue)
                return s.charAt(i) == 'T'? 1 : 0;
            else
                return s.charAt(i) == 'F'? 1 : 0;
        }
        int ans = 0;
        for(int k=i+1; k<j; k+=2){
            int lT = solve(s,i,k-1,true);
            int rT = solve(s,k+1,j,true);
            int lF = solve(s,i,k-1,false);
            int rF = solve(s,k+1,j,false);

            if(s.charAt(k) == '&'){
                if(isTrue)
                    ans +=lT * rT;
                else
                    ans += lF * rF + rF * lT + rT *lF;
            }

            else if(s.charAt(k) == '|'){
                if(isTrue)
                    ans += lT * rT + rF * lT + rT *lF;
                else
                    ans += lF* rF;
            }

            else if(s.charAt(k) == '^'){
                if(isTrue)
                    ans += lT * rF + lF * rT;
                else
                    ans += lT * rT + lF * rF; 
            }
        }
        return ans;
    }


    public static void main(String args[]){
        Parenthesization_recursive obj = new Parenthesization_recursive();
        String s = "T|T&F^T";
        System.out.println(obj.solve(s, 0, s.length()-1, true));
    }
}