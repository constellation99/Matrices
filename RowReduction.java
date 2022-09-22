/*
 * Row reduces a given matrix to its reduced row echelon form.
 */
public class RowReduction {
    private double[][] myMatrix;
    private double elementaryScalar;

    // Constructor that initializes elementaryScalar and myMatrix.
    public RowReduction() {
        this.elementaryScalar = 1;
    }

    // Deep copies a 2D array of doubles to myMatrix.
    public void matrixCopy(double[][] inputMatrix) {
        int rows = inputMatrix.length;
        int cols = inputMatrix[0].length;

        myMatrix = new double[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                myMatrix[r][c] = inputMatrix[r][c];
            }
        }
    }

    // Row reduces a given matrix to its reduced row echelon form
    // following Gaussian elimination principles.
    public double[][] rowReduce(double[][] inputMatrix) {  
        // Checks if matrix is null.
        if (inputMatrix == null) {
            System.out.println("Matrix is null.");
            return inputMatrix;
        }

        matrixCopy(inputMatrix);

        // Forward phase
        for (int i = 0; i < myMatrix.length; i++) { 
            if (findLeadingEntryIndex(myMatrix[i]) != -1) {  // checks that the LE is not 0
                for (int k = i + 1; k < myMatrix.length; k++) {
                    addRows(myMatrix[i], myMatrix[k]);
                }
            }
        }

        // Backward phase
        for (int i = myMatrix.length - 1; i > 0; i--) { 
            if (findLeadingEntryIndex(myMatrix[i]) != -1) {
                for (int k = i - 1; k >= 0; k--) {
                    addRows(myMatrix[i], myMatrix[k]);
                }
            }
        }

        // Pivots each row
        for (int i = 0; i < myMatrix.length; i++) {
            pivotRow(myMatrix[i]);
        }

        // If necessary, shifts rows such that the leading entries are
        // oriented to the right and downwards, and any rows of zero
        // are located at the bottom.
        for (int i = 0; i < myMatrix.length - 1; i++) {
            // shifts rows of 0 to bottom
            if (findLeadingEntryIndex(myMatrix[i]) == -1) {
                for (int k = i; k < myMatrix.length - 1; k++) {
                    swapRows(k, k + 1);
                }
            }
            for (int k = 1; k < myMatrix.length - i; k++) {
                // only swaps rows with nonzero LE's
                if (findLeadingEntryIndex(myMatrix[i]) > findLeadingEntryIndex(myMatrix[i + k])
                        && findLeadingEntryIndex(myMatrix[i]) != -1
                        && findLeadingEntryIndex(myMatrix[k + i]) != -1) {
                    swapRows(i, i + k);
                }
            }
        }

        return myMatrix;
    }

    // Finds the location of the leading entry (first nonzero entry).
    // Returns -1 if it does not exist (i.e. row of zeros).
    public int findLeadingEntryIndex(double[] row) {   
        for (int i = 0; i < row.length; i++) {
            if (row[i] != 0) {
                return i;
            }
        }
        return -1; 
    }

    // Scales and adds two rows together.
    // row1 is added to row2, and row2 is replaced with the result.
    public void addRows(double[] row1, double[] row2) {
        int index = findLeadingEntryIndex(row1);

        double leadingEntry1 = row1[index];   
        double leadingEntry2 = row2[index];

        double scalar = leadingEntry2 / leadingEntry1;

        scalar *= -1; 

        for (int i = 0; i < row1.length; i++) {
            row2[i] = (row1[i] * scalar) + row2[i];
        }
    }

    // Divides through a row by its leading entry
    // in order to make the leading entry 1 (if it
    // is non-zero and not already 1).
    public void pivotRow(double[] row) {
        int leadingEntryIndex = findLeadingEntryIndex(row);

        if (leadingEntryIndex != -1) { 
            double leadingEntry = row[leadingEntryIndex];

            if (leadingEntry != 1) {  

                for (int i = 0; i < row.length; i++) {
                    row[i] /= leadingEntry;  // divides the row by the value of the leading entry
                }

                elementaryScalar *= leadingEntry;
            }
        }
    }

    // Swaps two rows.
    public void swapRows(int rowIndex1, int rowIndex2) {
        double[] tempRow = myMatrix[rowIndex1];

        myMatrix[rowIndex1] = myMatrix[rowIndex2];
        myMatrix[rowIndex2] = tempRow;

        elementaryScalar *= -1;
    }

    // Gets myMatrix.
    public double[][] getMyMatrix() {
        return this.myMatrix;
    }

    // Gets scalar from elementary row ops.
    public double getElementaryScalar() {
        return elementaryScalar;
    }

    // Prints the values of myMatrix.
    public void printMyMatrix() {
        // Uses a nested for loop to go through each value in
        // the matrix and print them out. 
        for (int i = 0; i < myMatrix.length; i++) {
            for (int j = 0; j < myMatrix[0].length; j++) {
                System.out.print(myMatrix[i][j]);
                System.out.print(" ");
            }

            System.out.println();
        }
    }
}
