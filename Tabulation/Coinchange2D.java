package Tabulation;

import java.util.List;

public class Coinchange2D {
    static int calls =0 ;
    private static  int changeCoins(List<Integer>coins, int sum , int idx, int[][]dp){
        calls++ ;
        if(dp[idx][sum]!=-1){
            return dp[idx][sum] ;
        }
        if(idx==0){
            if(sum % coins.get(idx)==0){
                return 1 ;
            }
            else {
                return 0 ;
            }
        }
        int pick= 0;
        if(sum >= coins.get(idx)){
            pick= changeCoins(coins, sum-coins.get(idx), idx,dp);
        }
        int not_pick= changeCoins(coins, sum, idx-1,dp) ;

        return dp[idx][sum]= pick +not_pick ;
    }

    public static void main(String[] args) {
        List<Integer> coins= List.of(1,2,3) ;
        int n = coins.size() ;
        int totalSum =4 ;
        // for Memoization
//        int[][] dp= new int[n+1][sum+1] ;
//        for(int i=0; i<=n ; i++){
//            for(int j=0; j<=sum; j++) {
//                dp[i][j]=-1;
//            }
//        }
//        System.out.println(changeCoins(coins, sum , n-1,dp));

        int []cur = new int[totalSum+1] ;
        int []prev= new int[totalSum+1] ;

        for(int i=0; i<=totalSum; i++){
            cur[i]=0 ;
            if(i% coins.get(0)==0){
                prev[i]= 1 ;
            }
            else{
                prev[i]= 0 ;
            }
        }
        for(int idx=1; idx< n; idx++){
            for(int sum=0; sum <= totalSum; sum++){
                int pick =0;
                if(sum>=coins.get(idx)){
                    pick = cur[sum-coins.get(idx)] ;
                }
                int not_pick= prev[sum] ;
                cur[sum] =pick +not_pick ;
            }
            prev= cur ;
        }
        //   System.out.println(coins, totalSum,n-1,dp );
        System.out.println(prev[totalSum]);
    }
}