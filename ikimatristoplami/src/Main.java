public class Main {
    public static void main(String[] args) {
                int[][] matrix1 = {{2, 3, 4}, {5, 4, 3}};
                int[][] matrix2 = {{6, 2, 7}, {2, 9, 8}};
                int rows = matrix1.length;
                int columns = matrix1[1].length;
                int[][] result = new int[rows][columns];

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        result[i][j] = matrix1[i][j] + matrix2[i][j];
                    }
                }
                System.out.println("Matrix 1: ");
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        System.out.print(matrix1[i][j] + " ");
                    }
                    System.out.println();
                }

                System.out.println("Matrix 2: ");
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        System.out.print(matrix2[i][j] + " ");
                    }
                    System.out.println();
                }

                System.out.println("Result: ");
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        System.out.print(result[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        }




