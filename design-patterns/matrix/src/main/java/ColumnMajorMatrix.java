import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ColumnMajorMatrix implements Iterable<Integer> {
    private final int rowSize;
    private final List<List<Integer>> values = new ArrayList<>();

    public ColumnMajorMatrix(int rowSize) {
        this.rowSize = rowSize;
    }

    public void addRow(Integer... rowValues) {
        if (rowValues.length != rowSize) {
            throw new IllegalArgumentException("The number of values passing does not match row size of the matrix.");
        }

        values.add(Arrays.asList(rowValues));
    }

    @Override
    public Iterator<Integer> iterator() {
        return new ColumnMajorMatrixIterator();
    }

    private class ColumnMajorMatrixIterator implements Iterator<Integer> {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Integer next() {
            return null;
        }
    }
}
