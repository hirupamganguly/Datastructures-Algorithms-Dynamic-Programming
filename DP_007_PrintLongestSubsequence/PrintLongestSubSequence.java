class PrintLongestSubSequence{
    public static int maxOf(int a, int b) {
        if (a > b)
            return a;
        else
            return b;
    }
    public static String lCsubSequence(String s1, String s2) { //MOD int -> String
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();

        int n = str1.length;
        int m = str2.length;
        int[][] matrix = new int[n + 1][m + 1];
        matrix[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1[i - 1] == str2[j - 1]) {
                    matrix[i][j] = 1 + matrix[i - 1][j - 1];
                } else {
                    matrix[i][j] = maxOf(matrix[i - 1][j], matrix[i][j - 1]);
                    //matrix[i][j]=0; is for LONGEST COMMOMN SUBSTRING
                }
            }
        }

        char[] charArray= new char[matrix[n][m]];
        int j=charArray.length-1;
        while(n>0 && m>0){
            if (str1[n - 1] == str2[m - 1]) {
                charArray[j]=str1[n - 1];
                j--;
                n--;
                m--;
            } else {
               if(matrix[n-1][m]<matrix[n][m-1])    m--;
               else n--;
            }
        }

        
        String containerString=new String(charArray);
        return containerString;
    }
    public static String printinglongestCommonSubsequence(String text1, String text2) {
        String outPut= lCsubSequence(text1, text2);
        return outPut;
    
    }
    public static void main(String[] args) {
        String s1 = "acbcf";
        String s2 = "abcdaf";
        System.out.println( printinglongestCommonSubsequence(s1, s2));
    }
}