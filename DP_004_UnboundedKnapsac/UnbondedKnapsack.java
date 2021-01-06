// difference between 0/1 and unbounded knapsack is - 0/1 knapsack we cant include same item
// twice, and cant include fraction of the item.
// on the other hand Unbounded knapsack we can include a item more than once, 
//So when we include an item on the bag we do not remove from the array as we can further include it in future
//But if we exclude once then we cant include ever.

// Choce Diagram:-
 //                                           Item
     //                                     /     \
     //                                    /       \
     //              weights[item]<=capacity       weights[item]>capacity
     //                         /   \                   n-1 
     //                        /     \
     //                 INCLUDE       EXCLUDE
     //                     /            \
     //                    /              \
     //   capacity-weights[item]           n-1
     //         
class UnboundedKnapsack{
    public static int maxOf(int a, int b) {
        if (a > b)
            return a;
        else
            return b;
    }

    public static int solutionUnboundedKnapsack(int weights[], int valuation[], int capacity, int n) {
        int[][] matrix = new int[n + 1][capacity + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (i == 0 || j == 0) {
                    matrix[i][j] = 0;
                } else if (weights[i - 1] <= j) {
                    matrix[i][j] = maxOf(matrix[i - 1][j], matrix[i][j - weights[i - 1]]+ valuation[i - 1]);
                } else {
                    matrix[i][j] = matrix[i - 1][j];
                }
            }
        }
        return matrix[n][capacity];
    }

    public static void main(String[] args) {
        int weights[] = { 10, 20, 30 };
        int valuation[] = { 60, 100, 120 };
        int capacity = 50;
        int n = weights.length;
        int output = solutionUnboundedKnapsack(weights, valuation, capacity, n);
        System.out.println(output);
        }
    }
