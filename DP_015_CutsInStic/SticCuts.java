import java.util.Arrays;
class Solution {
    int[][] matrix;
    int len, m;
    public int minCost(int n, int[] cuts) {
        len = n;
        m = cuts.length;
        Arrays.sort(cuts);
        matrix = new int[m + 1][m + 1];
         for(int i=0;i<m+1;i++){
            for(int j=0;j<m+1;j++){
                matrix[i][j]=-1;
            }
        }
        return mcm(cuts, 0, m);  // whole stick; m means ending at the tail of stick; 
    } 
    private int mcm(int[] cuts, int i, int j) {
        if (matrix[i][j] >=0) return matrix[i][j];
        if (i >= j) return 0;  // if not need to cut anymore;
        int cost = (j == m ? len : cuts[j]) - (i == 0 ? 0 : cuts[i - 1]);
        matrix[i][j] = Integer.MAX_VALUE;
        for(int k = i; k < j; k++) {  // find the best cut, for each at cut point cuts[i];
            matrix[i][j] = Math.min(matrix[i][j], mcm(cuts, i, k) + mcm(cuts, k + 1, j) + cost);
        }
        return matrix[i][j];
    }
}
class SticCuts{
    public static void main(String[] args) {
        int[] nums={5,6,1,4,2};
        int n= 9;
        Solution obj= new Solution();
        System.out.println(obj.minCost(n, nums));
    }
}