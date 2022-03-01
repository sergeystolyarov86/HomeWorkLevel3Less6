import java.util.ArrayList;
import java.util.List;

public class TestApp {


   int[] method1(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int val : arr) {
            list.add(val);
        }
        if (!list.contains(4)) {
            throw new RuntimeException();
        }
        int index = list.lastIndexOf(4);

        int[] result = new int[list.size() - index - 1];
        int j = 0;
        for (int i = index + 1; i < list.size(); i++) {
            result[j] = list.get(i);
            j++;
        }
        return result;
    }

    boolean method2(int[] arr) {
        int countOne = 0;
        int countFour = 0;
        for (int j : arr) {
            if(j!=1 && j!=4) return false;
            if (j == 1) countOne++;
            if (j == 4) countFour++;
        }
        return countFour > 0 && countOne > 0;
    }
}

