/* 
 * Calculates the determinant of a given matrix
 */
public class Determinant {
    private double determinant;

    // Constructor to initialize determinant
    public Determinant() {
        determinant = 0;
    }
    
    // Computes the determinant of a given matrix
    // using row reduction. The matrix must be square.
    public double computeDeterminant(double[][] inputMatrix) {
        // Checks if empty
        if (inputMatrix.length == 0) {
            determinant = 0;
            return 0;
        }
        // Checks if not square
        else if (inputMatrix.length != inputMatrix[0].length) {
            determinant = 0;
            return determinant;
        }
        
        RowReduction myMatrix = new RowReduction();
        myMatrix.rowReduce(inputMatrix);

        determinant = 1;
        for (int i = 0; i < myMatrix.getMyMatrix().length; i++) {
            determinant *= myMatrix.getMyMatrix()[i][i];
        }

        // Have to account for elementary row ops
        determinant *= myMatrix.getElementaryScalar();  

        return determinant;
    }

    // Returns true if the matrix is invertible, false if not.
    // Invertibility is based on a nonzero determinant.
    public boolean isInvertible(double[][] inputMatrix) {
        computeDeterminant(inputMatrix);
        if (determinant != 0) {
            System.out.println("Matrix is invertible.");
            return true;
        }
        System.out.println("Matrix is not invertible.");
        return false;
    }

    // Gets the value of determinant.
    public double getDeterminant() {
        return determinant;
    }
}
