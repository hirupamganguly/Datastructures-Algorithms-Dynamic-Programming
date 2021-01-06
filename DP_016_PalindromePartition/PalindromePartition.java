class Solution {
    private static boolean isPal(char[] s,int i, int j) {
        if(i==j) return true;
        if(i>j) return true;
        while(i<j){
            if(s[i]!=s[j])
                return false;
                i++;
                j--;
        }
        return true;
    }
   public static int minCut(String str) {
        if (str.length() == 0) {
                return 0;
            }
        if(isPal(str.toCharArray(),0,str.length()-1)) return 0;
            int isPal[][] = new int[str.length()][str.length()];
            for (int i = 1; i < str.length(); i++) {
                int min = i;
                int temp=0;
                for (int j = 0; j <= i; j++) {
                    if (str.charAt(i) == str.charAt(j) && (i <= j + 1 || isPal[i - 1][j + 1]>0)) {
                        if(j!=j)
                        isPal[i][j] =Math.min(min, isPal[j][j]) ;
                        else isPal[i][j]=min;
                        min = Math.min(min,  j == 0 ? 0 : 1 + isPal[j-1][j-1]);
                        temp=j;
                    }
                }
                isPal[i][temp]=min;
            }
            for(int i=0;i<str.length();i++){
                for(int j=0;j<str.length();j++){
                    System.out.print("  "+isPal[i][j]);
                }
                System.out.println("");
            }

            return isPal[str.length()-1][str.length()-1];
    }
    public static void main(String[] args) {
        String s="abcdehghedc";
        System.out.println(minCut(s));
    }
}