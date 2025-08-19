import java.util.ArrayList;
import java.util.List;

public class cp12 {

    public static int choose(int[] arr) {
        int n = arr.length;
        int i=0;
        List<Integer> list = new ArrayList<>();
        int j=i;
        int min = Integer.MIN_VALUE;
        while(i<j ){
            min = arr[i];
            while(j<n) {
                min = Math.max(arr[j], min);
                j++;
            }
            list.add(min);
            i++;
        }
        return list.get(0)-1;
    }

    public static void main(String[] args) {
        int[] arr = {2,4,1,7};
        int result = choose(arr);
        System.out.println("Result: " + result);
    }
}
