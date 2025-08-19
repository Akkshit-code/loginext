public class WaystoDecode {
    static int call = 0;

    public static int no_of_ways(String number , int idx , int []dp){
        call++;
        if (idx==0 || idx==-1){
            return 1;
        }
        if (number.charAt(idx)=='0'){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int not_combine = 0;

        if(number.charAt(idx)!='0'){
            not_combine = no_of_ways(number,idx-1,dp);
        }
        int combine=0;
        if (number.charAt(idx-1)=='1' || (number.charAt(idx-1)=='2' && number.charAt(idx)<='6')){
            combine = no_of_ways(number,idx-2,dp);
        }
        return dp[idx] = combine+not_combine;


    }
    public static void main(String[] args) {
        String number = "112";
        int [] dp = new int[number.length()];
        for (int i=0;i<number.length();i++){
            dp[i] = -1;
        }
        System.out.println(no_of_ways(number,number.length()-1,dp));
        System.out.println(call);
    }
}
