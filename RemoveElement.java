import java.util.ArrayList;
import java.util.List;

public final class Solution {
    public int removeElement(int[] arr, int elem) {
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }

        while (list.remove((Integer) elem));
        
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return list.size();
    }
}
