import java.util.List;
import java.util.function.BiFunction;

public class main {
    public int max(List<Integer> arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.size(); i++) {
            if (max < arr.get(i))
                max = arr.get(i);
        }
        return max;
    }

    public int min(List<Integer> arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.size(); i++) {
            if (min > arr.get(i))
                min = arr.get(i);
        }
        return min;
    }

    public int length(List<Integer> arr) {
        int count = 0;
        for (int i = 0; i < arr.size(); i++) {
            count++;
        }
        return count;
    }

    public int reduce(List<Integer> arr, BiFunction<Integer, Integer, Integer> reducer) {
        int acc = arr.get(0);

        for (int i = 0; i < arr.size(); i++) {
            acc = reducer.apply(acc, arr.get(i));
        }

        return acc;
    }
}
