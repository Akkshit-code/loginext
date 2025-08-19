import java.util.List;

public class Coinchange {

    public static int coin(List<Integer> coins ,int sum ,  int idx){
        if(idx == 0){
            if(sum % coins.get(idx)==0)
                return 1;
            else
                return 0;
        }
        int pick=0;
        if(sum>=coins.get(idx))
             pick = coin(coins ,sum-coins.get(idx), idx);
        int notpick = coin(coins ,sum, idx-1);
        return pick + notpick;
    }
    public static void main(String[] args) {
        List<Integer> coins = List.of(1,2,3);
        int n = coins.size();
        int sum=4;
        System.out.println(coin(coins,sum,n-1));
    }
}
