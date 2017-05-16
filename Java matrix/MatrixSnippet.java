import java.util.Random;


public class MatrixSnippet {
	
	/**
	 * This method will fill a matrix with random numbers between max and min.
	 * @param matrix Matrix to fill
	 * @param max The maximum value of the interval.
	 * @param min The minimum value of the interval.
	 */
	public static void fillMatrix(int[][] matrix,int max,int min){
		Random random = new Random();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = random.nextInt(max - min) + min;
			}
		}
	}
	
	/**
	 * Method to print the matrix elements, row by row.
	 * @param matrix Matrix to be printed. The i=> rows; The j=> columns
	 */
	public static void printMatrix(int[][] matrix){
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]+"  ");
			}
			System.out.println("");
		}
	}
	
	/**
	 * This method will sum the matrix elements.
	 * @param matrix Matrix to be sum.
	 * @return The value of sum of all matrix elements.
	 */
	public static int matrixSum(int[][] matrix){
		int total=0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				total+=matrix[i][j];
			}
		}
		return total;
	}

	public static void main(String args[]){
		int[][] matrix = new int[5][5];
		fillMatrix(matrix, 10, 1);
		printMatrix(matrix);
		
	}
}
