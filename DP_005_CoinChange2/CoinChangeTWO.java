class CoinChangeTWO{
    public static int unboundedCountSubsetSum(int[] ar, int sum) {
        int n = ar.length;
        if (ar.length == 0)
            return 1; // Another edge case according to the Problem- is no item present in the array
        int[][] matrix = new int[n + 1][sum + 1];
        matrix[0][0] = 1;

        for (int i = 1; i < n + 1; i++) {
            matrix[i][0] = 1;
            for (int j = 0; j < sum + 1; j++) {
                if (ar[i - 1] <= j) {
                    matrix[i][j] = matrix[i][j - ar[i - 1]] + matrix[i - 1][j];// MOD
                } else {
                    matrix[i][j] = matrix[i - 1][j];
                }
            }
        }
        return matrix[n][sum];
    }
    public static int change(int amount, int[] coins) {
        
        if (coins.length == 0 && amount > 0)//Edge case according to the Problem
            return 0;
        else if (coins.length == 0 && amount <= 0)//Edge case according to the Problem
            return 1;
        int result = unboundedCountSubsetSum(coins, amount);
        return result;
    }
    // public static void main(String[] args) {
    //     int[] arr = {1,3,5};
    //     int s = 10;
    //     int result = change(s, arr);
    //     System.out.println(result);
    // }
}