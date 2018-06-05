// Minimum multiplication operations for chained matrix multiplication
// used for Algorithm Design & Analysis homework

public class MinMult {
    void run() {
        int n = 5;
        // replace the dimensions array elements with appropriate values as needed, the values here were used for the homework
        final int[] d = {10, 4, 5, 20, 2, 50};
        int[][] p = new int[n - 1][n];
        int[][] m = new int[n][n];
        int j;
        int temp;
        int min;
        int minK;

        for(int i = 1; i <= n; i++)
            m[i - 1][i - 1] = 0;
        
        for(int diagonal = 1; diagonal <= n - 1; diagonal++)
            for(int i = 1; i <= n - diagonal; i++) {
                j = i + diagonal;
                min = m[i - 1][i - 1] + m[i][j - 1] + d[i - 1] * d[i] * d[j];
                minK = i;
                for(int k = i + 1; k <= j - 1; k++) {
                    temp = m[i - 1][k - 1] + m[k][j - 1] + d[i - 1] * d[k] * d[j];
                    if(temp < min) {
                        min = temp;
                        minK = k;
                    }
                }

                m[i - 1][j - 1] = min;
                p[i - 1][j - 1] = minK;
            }

        System.out.println("Matrix M");
        for(int i = 0; i < n; i++) {
            for(j = 0; j < n; j++)
                System.out.printf("%4d ", m[i][j]);
            System.out.println();
        }

        System.out.println("\nMatrix P");
        for(int i = 0; i < n - 1; i++) {
            for(j = 0; j < n; j++)
                System.out.printf("%4d ", p[i][j]);
            System.out.println();
        }

        System.out.print("Optimal order: ");
        order(1, n, p);
    }

    private void order(int i, int j, int[][] p) {
        int k;

        if(i == j)
            System.out.print("A" + i);
        else {
            k = p[i - 1][j - 1];
            System.out.print("(");
            order(i, k, p);
            order(k + 1, j, p);
            System.out.print(")");
        }
    }

    public static void main(String[] args) {
        MinMult program = new MinMult();
        program.run();
    }
}