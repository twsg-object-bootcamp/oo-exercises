import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class RowMajorMatrix implements Iterable<Integer> {
    private final int rowSize;
    private final List<List<Integer>> values = new ArrayList<>();

    public RowMajorMatrix(int rowSize) {
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
        return new RowMajorMatrixIterator();
    }

    private class RowMajorMatrixIterator implements Iterator<Integer> {
        private int currentPos = 0;

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
