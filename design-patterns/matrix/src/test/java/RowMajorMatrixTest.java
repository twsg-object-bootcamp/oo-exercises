import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class RowMajorMatrixTest {
    @Test
    public void shouldSupportNativeForEachLoop() {
        RowMajorMatrix matrix = new RowMajorMatrix(3);
        matrix.addRow(1, 2, 3);
        matrix.addRow(4, 5, 6);

        int sum = 0;
        for (int i: matrix) {
            sum += i;
        }

        assertThat(sum, equalTo(21));
    }

    @Test
    public void shouldIterateOverEachElementRowByRow() {
        RowMajorMatrix matrix = new RowMajorMatrix(3);
        matrix.addRow(1, 2, 3);
        matrix.addRow(4, 5, 6);

        List<Integer> values = new ArrayList<>();
        for (int i: matrix) {
            values.add(i);
        }

        assertThat(values, contains(1, 2, 3, 4, 5, 6));
    }
}