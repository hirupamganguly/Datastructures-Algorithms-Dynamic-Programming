class MkingPalindrome{
    public static int maxOf(int a, int b) {
        if (a > b)
            return a;
        else
            return b;
    }
    public static int lCsubSequence(String s1, String s2) {
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
        return matrix[n][m];
    }
    public static int longestCommonSubsequence(String text1) {
        char ch[]=text1.toCharArray();  
        String rev="";  
        for(int i=ch.length-1;i>=0;i--){  
        rev+=ch[i];  
        } 
        if(text1.equals(rev)){
           return 0;
        }
        else {
        int reus = lCsubSequence(text1, rev);
        return text1.length()-reus;
        }
    }
    public static void main(String[] args) {
        String s1 = "cbbd";
        
        System.out.println( longestCommonSubsequence(s1));
    }
}







 