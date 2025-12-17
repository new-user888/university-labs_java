package lab_1.task;

import org.ejml.simple.SimpleMatrix;

public class MatrixOperations {

    // 4: Sum of max in even rows + min in odd rows (0-based index)
    public static double sumMaxEvenRowsMinOddRows(SimpleMatrix m) {
        double sum = 0;
        for (int row = 0; row < m.numRows(); row++) {
            double val = m.get(row, 0);
            for (int col = 1; col < m.numCols(); col++) {
                if (row % 2 == 0) {
                    val = Math.max(val, m.get(row, col));
                } else {
                    val = Math.min(val, m.get(row, col));
                }
            }
            sum += val;
        }
        return sum;
    }

    // 9: Average of each column
    public static double[] avgCols(SimpleMatrix m) {
        double[] avgs = new double[m.numCols()];
        for (int col = 0; col < m.numCols(); col++) {
            double sum = 0;
            for (int row = 0; row < m.numRows(); row++) {
                sum += m.get(row, col);
            }
            avgs[col] = sum / m.numRows();
        }
        return avgs;
    }
}
