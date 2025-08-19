import java.util.List;

public class FrogJump {

    public static int rec(int idx , List<Integer> heights , int k ,int [] dp) {
        if(idx == 0){
            return 0;
        }
        if (dp[idx]!=-1){
            return dp[idx];
        }
        int minCost = 10000;
        for (int j = 1 ; j<=k ; j++) {
            if (idx - j >= 0) {
                int jump = Math.abs(heights.get(idx) - heights.get(idx - j)) + rec(idx - j, heights, k , dp);
                minCost = Math.min(minCost, jump);
            }
        }

        return dp[idx] = minCost;
    }
    public static void main(String[] args) {
        List<Integer> heights = List.of(10 , 30 , 40 , 50 , 20);
        int k = 3;
        int n = heights.size();
        int [] dp = new int[n];
        for (int i=0; i<n;i++){
            dp[i] = -1;
        }
        System.out.println(rec(n-1 , heights , k , dp));
    }
}
