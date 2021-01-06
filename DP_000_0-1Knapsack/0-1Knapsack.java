class knapsack{
    public static int maxOf(int a, int b){
        if(a>b) return a;
        else return b;
    }
    public static int solutionKnapsack(int weights[], int valuation[], int capacity, int n){
        int matrix[][]=new int[n+1][capacity+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=capacity;j++){
                //Base case of the resursive solution will be the initialization step of matrix
                if(i==0 || j==0) matrix[i][j]=0;

                //Now convert resursive to TopDown:
                //  choice Diagram:
                //                                       Item
                //                                     /     \
                //                                    /       \
                //              weights[item]<=capacity       weights[item]>capacity
                //                         /   \                   n-1 
                //                        /     \
                //                 INCLUDE       EXCLUDE
                //                     /            \
                //                    /              \
                //   capacity-weights[item]           n-1
                //         n-1

                else if(weights[i-1]<=j){ //weights[item]<=capacity
                    matrix[i][j]= maxOf(  matrix[i-1][j],     matrix[i-1][j-weights[i-1]]+valuation[i-1]);
                            // max of       EXCLUDE             INCLUDE
                }
                else{ //weights[item]>capacity
                    matrix[i][j]=matrix[i-1][j];
                }
                
            }
        }
        System.out.println(matrix[n][capacity]); 
        return matrix[n][capacity];
    }
    public static void main(String[] args) {
        int weights[]={10, 20, 30};
        int valuation[]={60, 100, 120};
        int capacity=50;
        int n=weights.length;
        int output=solutionKnapsack(weights,valuation,capacity,n);
    }
}
