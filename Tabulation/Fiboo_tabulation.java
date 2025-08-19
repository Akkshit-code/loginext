package Tabulation;

public class Fiboo_tabulation {
    public static void main(String[] args) {
        int n = 10;
        int prev1 = 1;
        int prev2 = 1;
        int current = 0;
        for(int i=3;i<=n;i++){
            current = prev1+prev2;
            prev1 = prev2;
            prev2 = current;
        }
        System.out.println(current);

    }
}
