import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrix[][] = {
                {0, 1, 2},
                {1, 5, 3},
                {2, 5, 4},
        };
        int matrix2[][] = {
                {0, 1, 2},
                {1, 5, 3},
                {2, 5, 4},
        };

//        System.out.println("Print matrix size.");
//        printTask1(scanner.nextInt());
//
//        System.out.println("Print matrix size.");
//        printTask2(scanner.nextInt());
//
//        System.out.println(printIsMatrixSimmetric(matrix));
//
//        printTask4WinnerInfo(matrix);
//
//        printTask5WinnerInfo(matrix);
//
//        printTask6WinnerInfo(matrix);
//
//        merge2MatrixAndPrint(matrix,matrix2);
//
//        System.out.println("Enter matrix size");
//        printSpiral1(scanner.nextInt());

        System.out.println("Enter matrix size");
        printSpiral2(scanner.nextInt());
    }


    /**
     * printing given matrix
     *
     * @param matrix
     */
    private static void printMatrix(int[][] matrix) {
        for (int[] array : matrix) {
            for (int value : array) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    /**
     * task1
     * Create an n × n array and fill it according to the following rule:
     * - the numbers on the diagonal going from the upper right to the lower left corner are equal to 1;
     * - the other elements are 0;
     * - print matrix
     *
     * @param size
     */
    private static void printTask1(int size) {

        int[][] matrix = new int[size][size];

        for (int i = 0, j = size - 1; i < size; i++, j--) {
            matrix[i][j] = 1;
        }
        printMatrix(matrix);
    }

    /**
     * task2
     * Create an n × n array and fill it according to the following rule:
     * - the numbers on the diagonal going from the upper right to the lower left corner are equal to 1;
     * - numbers above this diagonal are equal to 0;
     * - the numbers below this diagonal are equal to 2
     *
     * @param size
     */
    private static void printTask2(int size) {

        int[][] matrix = new int[size][size];

        for (int i = 0, count = size - 1; i < size; i++, count--) {
            for (int j = size - 1; j >= count; j--) {
                if (j > count) {
                    matrix[i][j] = 2;
                } else matrix[i][j] = 1;
            }
        }
        printMatrix(matrix);
    }

    /**
     * task3
     * Check if the two-dimensional array is symmetrical about the main diagonal.
     * The main diagonal is the one that goes from the upper left corner of
     * the two-dimensional array to the lower right.
     *
     * @param matrix
     * @return true or false
     */
    private static boolean printIsMatrixSimmetric(int[][] matrix) {

        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == matrix[j][i]) {
                    count++;
                }
            }
        }
        return (count == matrix.length * matrix.length);
    }

    /**
     * task4
     * There are n athletes competing in hammer throw.
     * Each of them made m throws. The winner is the athlete who has the maximum result for all throws.
     * print athlete number and his score
     *
     * @param matrix
     */
    private static void printTask4WinnerInfo(int[][] matrix) {
        int athleteNum = matrix.length;
        int attempts = matrix[0].length;
        int winnerAthleteNum = 0;
        int bestSum = 0;
        int count;
        for (int i = 0; i < athleteNum; i++) {
            count = 0;
            for (int j = 0; j < attempts; j++) {
                count += matrix[i][j];
            }
            if (count > bestSum) {
                winnerAthleteNum = i;
                bestSum = count;
            }
        }
        System.out.println("Winner athlete number is " + (winnerAthleteNum + 1) + " score = " + bestSum);
    }

    /**
     * task5
     * There are n athletes competing in hammer throw. Each of them made m throws.
     * The winner of the competition is the athlete who has the best result in all throws.
     * Thus, the program must find the value of the maximum element in the given array,
     * as well as its indices (that is, the number of the athlete and the number of the attempt).
     * printing winner athlete number and best score
     *
     * @param matrix
     */
    private static void printTask5WinnerInfo(int[][] matrix) {
        int athleteNum = matrix.length;
        int attempts = matrix[0].length;
        int winnerAthleteNum = 0;
        int bestScore = 0;
        int count;
        for (int i = 0; i < athleteNum; i++) {
            count = 0;
            for (int j = 0; j < attempts; j++) {
                if (matrix[i][j] > count) {
                    count = matrix[i][j];
                }
            }
            if (count > bestScore) {
                winnerAthleteNum = i;
                bestScore = count;
            }
        }
        System.out.println("Winner athlete number is " + (winnerAthleteNum + 1) + " best score = " + bestScore);
    }

    /**
     * task6
     * There are n athletes competing in hammer throw.
     * Each of them made m throws. The athlete with the highest best throw wins.
     * If there are several of them, then the one with the best sum of results for all attempts wins.
     * If there are several of them, the athlete with the minimum number is considered the winner.
     * Determine the number of the winner of the competition
     * Print winner athlete number
     *
     * @param matrix
     */
    private static void printTask6WinnerInfo(int[][] matrix) {
        int athleteNum = matrix.length;
        int attempts = matrix[0].length;
        int winnerAthleteNum = 0;
        int bestSum = 0;
        int bestScore = 0;
        int sumCount;
        int bestScoreCount;
        for (int i = 0; i < athleteNum; i++) {
            sumCount = 0;
            bestScoreCount = 0;
            for (int j = 0; j < attempts; j++) {
                sumCount += matrix[i][j];
                if (bestScoreCount < matrix[i][j]) {
                    bestScoreCount = matrix[i][j];
                }
            }
            if (bestScoreCount >= bestScore) {
                if (bestScoreCount > bestScore) {
                    bestScore = bestScoreCount;
                    winnerAthleteNum = i;
                    bestSum = sumCount;
                } else if (sumCount > bestSum) {
                    winnerAthleteNum = i;
                    bestSum = sumCount;
                }
            }
        }
        System.out.println("Winner athlete number is " + (winnerAthleteNum + 1));
    }

    /**
     * task8
     * merging 2 given matrix and printing new matrix
     *
     * @param matrix
     * @param matrix2
     */
    private static void merge2MatrixAndPrint(int[][] matrix, int[][] matrix2) {
        int[][] newMatrix = new int[matrix.length * 2][matrix[0].length];
        for (int i = 0; i < newMatrix.length; i++) {
            if (i < matrix.length) {
                for (int j = 0; j < matrix.length; j++) {
                    newMatrix[i][j] = matrix[i][j];
                }
            } else for (int j = 0; j < matrix.length; j++) {
                newMatrix[i][j] = matrix2[i - matrix2.length][j];
            }
        }
        printMatrix(newMatrix);
    }

    /**
     * task9
     * create matrix with input size and fill it like this
     *  1111111
     *  0000001
     *  1111101
     *  1000101
     *  1011101
     *  1000001
     *  1111111
     *  printing matrix
     * @param N
     */
    private static void printSpiral1(int N) {

        int[][] matrix = new int[N][N];
        int count = 0;
        int count1 = 0;
        for (int j = 0; j < N / 3; j++) {

            for (int i = count1; i < N - count; i++) {                 //up-horizontal
                matrix[count][i] = 1;
            }
            for (int i = count; i < N - count; i++) {                  //right-vertical
                matrix[i][N - 1 - count] = 1;
            }
            for (int i = N - 1 - count; i >= count; i--) {             //down-horizontal
                matrix[N - 1 - count][i] = 1;
            }
            for (int i = N - 1 - count; i > 1 + count; i--) {          //left-vertical
                matrix[i][count] = 1;
            }
            count += 2;
            if (count1 == 0) count1 += 1;
            else count1 += 2;
        }

        printMatrix(matrix);
    }

    /**
     * task10
     * create matrix with input size and fill it like this
     * 0  1  2
     * 7  8  3
     * 6  5  4
     * printing matrix
     * @param N
     */
    private static void printSpiral2(int N) {
        int matrix[][] = new int[N][N];
        int count = 0;
        int num = 0;

        for (int j = 0; j <= N / 3 * 2; j++) {

            for (int i = count; i < N - count; i++) {                 //up-horizontal
                matrix[count][i] = num;
                num++;
            }
            for (int i = 1 + count; i < N - count; i++) {             //right-vertical
                matrix[i][N - 1 - count] = num;
                num++;
            }
            for (int i = N - 2 - count; i > -1 + count; i--) {         //down-horizontal
                matrix[N - 1 - count][i] = num;
                num++;
            }
            for (int i = N - 2 - count; i > count; i--) {               //left-vertical
                matrix[i][count] = num;
                num++;
            }
            count++;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j] + " \t");
            }
            System.out.println();
        }
    }
}
