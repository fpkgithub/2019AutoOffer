package swordoffer.Dp;

public class 最长公共子串 {


    public static String getMaxSubString(String str1, String str2) {
        String res = "";

        if (str1 == null || str2 == null)
            return res;

        int lenA = str1.length();
        int lenB = str2.length();

        int[][] dp = new int[lenA + 1][lenB + 1];
        int max = -1;

        int start = -1;
        for (int i = 0; i < lenA; i++) {
            for (int j = 0; j < lenB; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {

                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    if (dp[i + 1][j + 1] > max) {
                        max = dp[i + 1][j + 1];
                        start = i + 1 - max;
                    }
                }
            }
        }
        //System.out.println(max);
        res = str1.substring(start, start + max);
        return res;
    }


    public static void main(String[] args) {


        //        String str1 = "ablmnopvtrt";
        //        String str2 = "abcsamnopvtvqrstuvw";
        String str1 = "ujlzfqqscymxyooumhfwuokwvjnkboqwbsjktburxsazwrjltmmnuxsigpvsusgpztxodwfhagyzxpocvmladimtzfwwgkbarhmjthuubccwzvkgadrnpcr";
        String str2 = "qmuwdtbmltlciaxogzjjktzyegefnkezoouvhbxxtnnctihybsnchumrxysynyhciezgbwjzljuhpgiiuwouyevymbhwsopcyhyhswhmdpdqajvpgitqxczkfegrqhgxlvykbhymnjjpgufdxccjacnfzxmejzrkywwazfiyuwmfbifhllebzojlqlqgpamzwawpgjaatgnrfpmlmgvsnlhufmvzrjwhmdwhxxiksqbwqgkakivvahjntcswdyllwjtwdyspae";
        System.out.println(getMaxSubString(str1, str2));//输出:mnopvt
    }
}
