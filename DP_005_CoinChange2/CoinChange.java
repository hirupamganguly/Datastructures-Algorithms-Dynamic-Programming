public class CoinChange {
    public static int minOf(int a, int b){
        if(a>b) return b;
        else return a;
    }
    public static int minNoOfCoins(int ar[], int amount) {
        int n = ar.length;
        int[][] matrix = new int[n + 1][amount + 1];
        for (int i = 0; i < n + 1; i++) {  
            for (int j = 0; j < amount + 1; j++) {
                if (i == 0)
                matrix[i][j] = Integer.MAX_VALUE - 1;
                if(i==1 && j>0) {
                    if(j%ar[0]==0) 
                    matrix[i][j]=j/ar[0];
                    else
                     matrix[i][j]=Integer.MAX_VALUE - 1;
                }
   
    //  0->  INF  INF  INF  INF  INF  INF  INF  INF  INF  INF  INF  INF  INF  INF  INF  INF
    //  3->    0  INF  INF    1  INF  INF    2  INF  INF    3  INF  INF    4  INF  INF    5
    //  4->    0    0    0    0    0    0    0    0    0    0    0    0    0    0    0    0
    //  5->    0    0    0    0    0    0    0    0    0    0    0    0    0    0    0    0
    //  7->    0    0    0    0    0    0    0    0    0    0    0    0    0    0    0    0
    //

                if (i>1&&ar[i - 1] <= j) {
                    matrix[i][j] = minOf(matrix[i][j - ar[i - 1]] + 1, matrix[i - 1][j]);
                }
                else if(i>1&&ar[i - 1] > j){
                    matrix[i][j]=matrix[i-1][j];
                }
            }
        }
        

    //   0->    INF  INF  INF  INF  INF  INF  INF  INF  INF  INF  INF  INF  INF  INF  INF  INF
    //   3->    0    INF  INF    1  INF  INF    2  INF  INF    3  INF  INF    4  INF  INF    5
    //   4->    0    INF  INF    1    1  INF    2    2    2    3    3    3    3    4    4    4
    //   5->    0    INF  INF    1    1    1    2    2    2    2    2    3    3    3    3    3
    //   7->    0    INF  INF    1    1    1    2    1    2    2    2    2    2    3    2    3

        return matrix[n][amount];     
    }
    public static int change(int amount, int[] coins) {
        
        if (coins.length == 0 && amount > 0)//Edge case according to the Problem
            return -1;
        else if (coins.length == 0 && amount <= 0)//Edge case according to the Problem
            return -1;
        int result = minNoOfCoins(coins, amount);
        if(result==Integer.MAX_VALUE-1 ||result==Integer.MAX_VALUE-1 ) return -1;
        return result;
    }
    public static void main(String[] args) {
        int arr[] = {3,4,5,7};
        int amount =15;
        int result= change(amount, arr);
        System.out.println("");
        System.out.println(result);
        
    }
}