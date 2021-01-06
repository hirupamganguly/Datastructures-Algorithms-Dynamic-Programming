class PrintShortestSuperSeq{
    public static int maxOf(int a, int b) {
        if (a > b)
            return a;
        else
            return b;
    }
    public static String lCsubSequence(String s1, String s2) {
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

int leng=matrix[n][m];
int totalLength=str1.length+str2.length-leng;
char[] charArray= new char[totalLength];
        int j=charArray.length-1;
        while(n>0 && m>0){
            if (str1[n - 1] == str2[m - 1]) {
                charArray[j]=str1[n - 1];
                j--;
                n--;
                m--;
            } else {
               if(matrix[n-1][m]<matrix[n][m-1]){ 
                charArray[j]=str2[m - 1];
                m--;
                j--;
                }
                else if(matrix[n-1][m]==matrix[n][m-1]){
                    charArray[j]=str2[m - 1];
                    m--;
                    j--;
                }
               else{
                   charArray[j]=str1[n - 1];
                   n--;
                   j--;
                }
            }
        }    
        while(n>0||m>0){
            if(n>0){
                charArray[j]=str1[n - 1];
                n--;
                j--;
            }
            else{
                charArray[j]=str2[m - 1];
                   m--;
                   j--;
            }  
        }
        String containerString=new String(charArray);
        // System.out.println(containerString); 
        return containerString;
    }
    public static String shortestSupersequence(String text1, String text2) {
        String reus;
        if(text1.length()<text2.length()){
            reus = lCsubSequence(text1, text2);
        }
        else{
            reus = lCsubSequence(text2, text1);
        }
        // String reus = lCsubSequence(text1, text2);
        // int outPut=text1.length()+text2.length()-reus;
        return reus;
    }
    public static void main(String[] args) {
        String s1 = "cab";
        String s2 = "ac";
        System.out.println( shortestSupersequence(s1, s2));
    }
}