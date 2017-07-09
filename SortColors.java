import java.util.ArrayList;
import java.util.List;

public final class Solution {
    public void sortColors(int[] arr) {
        List<Integer> list = new ArrayList<Integer>();
        int length = arr.length;

        for (int i = 0; i < length; i++) {
            if (arr[i] == 0) {
                list.add(arr[i]);
            }
        }

        for (int i = 0; i < length; i++) {
            if (arr[i] == 1) {
                list.add(arr[i]);
            }
        }

        for (int i = 0; i < length; i++) {
            if (arr[i] == 2) {
                list.add(arr[i]);
            }
        }

        for (int i = 0; i < length; i++) {
            arr[i] = list.get(i);
        }
    }
}
