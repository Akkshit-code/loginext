public class HouseRobber {
    static int calls = 0;

    public static int house(int [] house , int ind , int []dp){
        calls++;
        if (ind == house.length-1){
            return house[ind];
        }
        if(ind>=house.length){
            return 0;
        }
        if (dp[ind]!=-1){
            return dp[ind];
        }

        int pick = house[ind]+house(house,ind+2,dp);
        int notpick = house(house , ind+1,dp);
        return dp[ind] = Math.max(pick,notpick);
    }
    public static void main(String[] args) {
        int n = 4;
        int [] house = new int[n];
        house[0] = 9;
        house[1] = 1;
        house[2] = 3;
        house[3] = 8;
        int [] dp = new int[n];
        for (int i=0;i<n;i++){
            dp[i] = -1;
        }
        System.out.println(house(house,0,dp));
        System.out.println(calls);
    }
}
