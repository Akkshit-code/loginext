import java.util.* ;
public class cp11 {
    private static int turtleGame(int l, int r){
        int count=0 ;
        double max= 0 ;
        int i=1 ;
        while(max<= r){
            max=Math.pow(2,i);
            if(max<=r){
                count++ ;
            }
            i++ ;
        }
        return count ;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in) ;
        int t = sc.nextInt();
        while (t-->0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            System.out.println(turtleGame(l, r));

        }

    }
}