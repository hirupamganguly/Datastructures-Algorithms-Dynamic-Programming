class LongestCommonSubSequence{
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
//          0   a   b   c   o   p   m
//          \   \   \   \   \   \   \
//  0->     0   0   0   0   0   0   0   
//  a->     0   1   1   1   1   1   1
//  b->     0   1   2   2   2   2   2   
//  c->     0   1   2   3   3   3   3
//  v->     0   1   2   3   3   3   3
//  d->     0   1   2   3   3   3   3
//  n->     0   1   2   3   3   3   3
//  m->     0   1   2   3   3   3   4
//  t->     0   1   2   3   3   3   4

        return matrix[n][m];
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        int reus = lCsubSequence(text1, text2);
        return reus;
    }
    public static void main(String[] args) {
        String s1 = "abcvdnmt";
        String s2 = "abcopm";
        System.out.println( longestCommonSubsequence(s1, s2));
    }
}