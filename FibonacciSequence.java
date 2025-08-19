public class FibonacciSequence {
    static int calls = 0;

    private static int fiboo(int n,int []dp){
        calls++;
        if(n==0 || n==1){
            return 1;
        }
        // Overlapping Condition of DP
        if(dp[n]!=-1){
            return dp[n];
        }
        int result = fiboo(n-1,dp) + fiboo(n-2,dp);
        dp[n] = result;
        return result;
    }
    public static void main(String[] args) {
        int n = 1000;
        int [] dp = new int[n+1];
        for (int i=0;i<=n;i++){
            dp[i] = -1;
        }
        System.out.println(fiboo(n,dp));
        System.out.println("calls + "+ calls);

    }
}
