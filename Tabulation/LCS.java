//package Tabulation;
//
//public class LCS {
//
//    public static void main(String[] args) {
//        String s1 = "ABCDGH";
//        String s2 = "AEDFHR";
//        int m = s1.length();
//        int n = s2.length();
//
//        int[][] dp = new int[m + 1][n + 1];
//
//        for (int i = 0; i <= m; i++) {
//            dp[i][0] = 0;
//        }
//        for (int j = 0; j <= n; j++) {
//            dp[0][j] = 0;
//        }
//
//        for (int i = 1; i <= m; i++) {
//            for (int j = 1; j <= n; j++) {
//                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
//                    dp[i][j] = 1 + dp[i - 1][j - 1];
//                } else {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                }
//            }
//        }
//        System.out.println(dp[m][n]);
//    }
//}




// Space optimisation in tabulation


package Tabulation;

public class LCS {

    public static void main(String[] args) {
        String s1 = "ABCDGH";
        String s2 = "AEDFHR";
        int m = s1.length();
        int n = s2.length();

        int[] prev = new int[m+1];
        int[] current = new int[n+1];

        for (int i = 0; i <= m; i++) {
            prev[i] = 0;
        }


        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    current[j] = 1 + prev[j - 1];
                } else {
                    current[j] = Math.max(prev[j], current[j - 1]);
                }
                prev = current;
            }
        }
        System.out.println(prev[n]);
    }
}

