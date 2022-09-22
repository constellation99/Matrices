import java.util.*;

/*
 * Tests the methods contained within RowReduction and Determinant.
 */
public class Tester {
    public static void main(String[] args) {
        // Testing RowReduction class
        // rowReduce test 1
        // square matrix with full rank (invertible)
        double[][] testMatrix = {{1, 2, 3},
                                 {5, 5, 5},
                                 {3, 7, 4}};
        
        RowReduction myTest = new RowReduction();

        myTest.rowReduce(testMatrix);

        myTest.printMyMatrix();

        double[][] solvedMatrix = {{1, 0, 0},
                                   {0, 1, 0},
                                   {0, 0, 1}};

        boolean correctMatrix = true;

        for (int i = 0; i < testMatrix.length; i++) {
            for (int j = 0; j < testMatrix[0].length; j++) {
                if (myTest.getMyMatrix()[i][j] != solvedMatrix[i][j]) {
                    correctMatrix = false;
                    break;
                }
            }

            if (correctMatrix == false) {
                System.out.println("rowReduce test 1 failed.");
                break;
            }
        }

        if (correctMatrix == true) {
            System.out.println("rowReduce test 1 passed.");
        }

        System.out.println();

        // rowReduce test 2
        // wide matrix
        double[][] testMatrix2 = {{1, 2, 3, 7, 0},
                                  {5, 4, 6, 6, 0},
                                  {3, 7, 4, 9, 0},
                                  {2, 2, 2, 4, 0}};
        
        RowReduction myTest2 = new RowReduction();

        myTest2.rowReduce(testMatrix2);

        myTest2.printMyMatrix();

        double[][] solvedMatrix2 = {{1, 0, 0, 0, 0},
                                    {0, 1, 0, 0, 0},
                                    {0, 0, 1, 0, 0},
                                    {0, 0, 0, 1, 0}};

        correctMatrix = true;
                                
        for (int i = 0; i < testMatrix2.length; i++) {
            for (int j = 0; j < testMatrix2[0].length; j++) {
                if (myTest2.getMyMatrix()[i][j] != solvedMatrix2[i][j]) {
                    correctMatrix = false;
                    break;
                }
            }

            if (correctMatrix == false) {
                System.out.println("rowReduce test 2 failed.");
                break;
            }
        }

        if (correctMatrix == true) {
            System.out.println("rowReduce test 2 passed.");
        }

        System.out.println();

        // rowReduce test 3
        // matrix with two free variables
        double[][] testMatrix3 = {{1, 1, 1},
                                  {2, 2, 2},
                                  {3, 3, 3}};
        
        RowReduction myTest3 = new RowReduction();

        myTest3.rowReduce(testMatrix3);

        myTest3.printMyMatrix();

        double[][] solvedMatrix3 = {{1, 1, 1},
                                    {0, 0, 0},
                                    {0, 0, 0}};

        correctMatrix = true;

        for (int i = 0; i < testMatrix3.length; i++) {
            for (int j = 0; j < testMatrix3[0].length; j++) {
                if (myTest3.getMyMatrix()[i][j] != solvedMatrix3[i][j]) {
                    correctMatrix = false;
                    break;
                }
            }

            if (correctMatrix == false) {
                System.out.println("rowReduce test 3 failed.");
                break;
            }
        }

        if (correctMatrix == true) {
            System.out.println("rowReduce test 3 passed.");
        }

        System.out.println();

        // rowReduce test 4
        // tall matrix
        double[][] testMatrix4 = {{1, 2, 2},
                                  {5, 5, 5},
                                  {2, 2, 4},
                                  {1, 2, 3}};
        
        RowReduction myTest4 = new RowReduction();

        myTest4.rowReduce(testMatrix4);

        myTest4.printMyMatrix();

        double[][] solvedMatrix4 = {{1, 0, 0},
                                    {0, 1, 0},
                                    {0, 0, 1},
                                    {0, 0, 0}};

        correctMatrix = true;

        for (int i = 0; i < testMatrix4.length; i++) {
            for (int j = 0; j < testMatrix4[0].length; j++) {
                if (myTest4.getMyMatrix()[i][j] != solvedMatrix4[i][j]) {
                    correctMatrix = false;
                    break;
                }
            }

            if (correctMatrix == false) {
                System.out.println("rowReduce test 4 failed.");
                break;
            }
        }

        if (correctMatrix == true) {
            System.out.println("rowReduce test 4 passed.");
        }

        System.out.println();

        // rowReduce test 5
        // matrix with one free variable
        double[][] testMatrix5 = {{1, 1, 1},
                                  {1, 1, 1},
                                  {3, 7, 4}};
        
        RowReduction myTest5 = new RowReduction();

        myTest5.rowReduce(testMatrix5);

        myTest5.printMyMatrix();
        
        double[][] solvedMatrix5 = {{1, 0, 0.75},
                                    {0, 1, 0.25},
                                    {0, 0, 0}};

        correctMatrix = true;

        for (int i = 0; i < testMatrix5.length; i++) {
            for (int j = 0; j < testMatrix5[0].length; j++) {
                if (myTest5.getMyMatrix()[i][j] != solvedMatrix5[i][j]) {
                    correctMatrix = false;
                    break;
                }
            }

            if (correctMatrix == false) {
                System.out.println("rowReduce test 5 failed.");
                break;
            }
        }

        if (correctMatrix == true) {
            System.out.println("rowReduce test 5 passed.");
        }

        System.out.println();

        // rowReduce test 6
        // matrix with negative values
        double[][] testMatrix6 = {{-1, 2, 4},
                                 {5, 8, -5},
                                 {-3, -17, -9}};
        
        RowReduction myTest6 = new RowReduction();

        myTest6.rowReduce(testMatrix6);

        myTest6.printMyMatrix();

        double[][] solvedMatrix6 = {{1, 0, 0},
                                   {0, 1, 0},
                                   {0, 0, 1}};

        correctMatrix = true;

        for (int i = 0; i < testMatrix6.length; i++) {
            for (int j = 0; j < testMatrix6[0].length; j++) {
                if (myTest6.getMyMatrix()[i][j] != solvedMatrix6[i][j]) {
                    correctMatrix = false;
                    break;
                }
            }

            if (correctMatrix == false) {
                System.out.println("rowReduce test 6 failed.");
                break;
            }
        }

        if (correctMatrix == true) {
            System.out.println("rowReduce test 6 passed.");
        }

        System.out.println();

        // rowReduce test 7
        // null matrix
        double[][] testMatrix7 = null;
        
        RowReduction myTest7 = new RowReduction();

        myTest7.rowReduce(testMatrix7);

        if (myTest7.getMyMatrix() != null) {
            System.out.println("rowReduce test 7 failed.");
        }
        else {
            System.out.println("rowReduce test 7 passed.");
        }

        System.out.println();


        // Testing Determinant class
        // computeDeterminant test 1
        // with invertible matrix
        Determinant testDet = new Determinant();

        double myDet = testDet.computeDeterminant(testMatrix);

        System.out.println("Determinant = " + myDet);

        if (myDet == 35.0) {
            System.out.println("Determinant test 1 passed.");
        }
        else {
            System.out.println("Determinant test 1 failed.");
        }

        System.out.println();

        // computeDeterminant test 2
        // with non-square matrix
        Determinant testDet2 = new Determinant();

        double myDet2 = testDet2.computeDeterminant(testMatrix2);

        System.out.println("Determinant = " + myDet2);

        if (myDet2 == 0) {
            System.out.println("Determinant test 2 passed.");
        }
        else {
            System.out.println("Determinant test 2 failed.");
        }

        System.out.println();

        // computeDeterminant test 3
        // with matrix that is square, but not invertible
        Determinant testDet3 = new Determinant();

        double myDet3 = testDet3.computeDeterminant(testMatrix3);

        System.out.println("Determinant = " + myDet3);

        if (myDet3 == 0) {
            System.out.println("Determinant test 3 passed.");
        }
        else {
            System.out.println("Determinant test 3 failed.");
        }

        System.out.println();

        // computeDeterminant test 4
        // with empty matrix
        double[][] testMatrix8 = new double[0][0];

        Determinant testDet4 = new Determinant();

        double myDet4 = testDet4.computeDeterminant(testMatrix8);

        System.out.println("Determinant = " + myDet4);

        if (myDet4 == 0) {
            System.out.println("Determinant test 4 passed.");
        }
        else {
            System.out.println("Determinant test 4 failed.");
        }
    }
}