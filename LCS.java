//public class LCS {
//
//    public static int rec(String s1 , String s2 , int i , int j , int [][] dp){
//        if(i<0 || j<0){
//            return 0;
//        }
//        if (dp[i][j] !=-1){
//            return dp[i][j];
//        }
//        if(s1.charAt(i) == s2.charAt(j)){
//            return 1 + rec(s1 , s2 , i-1 , j-1 , dp);
//        }
//        return dp[i][j] = Math.max(rec(s1 , s2 , i-1,j , dp) , rec(s1 , s2 , i , j-1 , dp));
//    }
//    public static void main(String[] args) {
//        String s1 = "ABCDGH";
//        String s2 = "AEDFHR";
//        int [][] dp = new int[s1.length()][s2.length()];
//        for (int i=0;i<s1.length();i++){
//            for (int j=0;j<s2.length();j++){
//                dp[i][j] = -1;
//            }
//        }
//        System.out.println(rec(s1 , s2 , s1.length()-1 , s2.length()-1 , dp));
//    }
//}
//
//


public class LCS{
    public static int lcs(String s,String t,int i,int j){
        if(i==s.length()){
            return 0;
        }
        if(j==t.length()){
            return 0;
        }
        if(s.charAt(i)==t.charAt(j)){
            return 1+lcs(s,t,i+1,j+1);
        }
        return Math.max(lcs(s,t,i+1,j),lcs(s,t,i,j+1));
    }
    public static void main(String[] args) {
        System.out.println(lcs("GeeksforGeeks","Gks",0,0));
    }
}