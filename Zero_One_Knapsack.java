import java.util.List;

public class Zero_One_Knapsack {

    public static int Knapsack(int idx , int W , List<Integer> profit , List<Integer> weight, int [][] dp){
        if(dp[idx][W]!=-1){
            return dp[idx][W] ;
        }
        if (idx == 0) {
            if(weight.get(0)<=W){
                return profit.get(0);
            }
            else {
                return 0;
            }
        };
        int pick = 0;
        if(W >=weight.get(idx))
         pick = profit.get(idx) + Knapsack(idx-1 , W - weight.get(idx) , profit , weight , dp);
        int notpick = Knapsack(idx-1 , W , profit, weight , dp);

        return dp[idx][W] = Math.max(pick,notpick);
    }
    public static void main(String[] args) {
        List<Integer> profit = List.of(1,2,3);
        List<Integer> weight = List.of(4,5,1);
        int Wt = 4;
        int n = profit.size();
        int [][] dp = new int[n+1][Wt+1];
//        for (int i=0;i<=n;i++){
//            for (int j=0;j<=W;j++){
//                dp[i][j] = -1;
//            }
//        }

        int [] prev = new int[Wt+1];
        int [] curr = new int[Wt+1];
        // Tabulation
        for (int i=0;i<=Wt;i++){
                curr[i] = 0;
                if(weight.get(0)<=i){
                    prev[i] = profit.get(0);
                }
                else {
                    prev[i] = 0;
                }
        }

        //

        for (int idx = 1;idx<n;idx++){
            for (int W=0;W <= Wt;W++){
                int pick = 0;
                if(W >=weight.get(idx))
                    pick = profit.get(idx) + prev[W- weight.get(idx)];
                int notpick = prev[W] ;

                dp[idx][W] = Math.max(pick,notpick);
            }
            prev = curr;
        }
        System.out.println(prev[Wt]);
    }
}
