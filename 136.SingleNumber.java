import java.util.Arrays;

public final class Solution {
    public int singleNumber(int[] arr) {
        int result = 0;

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i = i + 2) {
            try {
                if (arr[i] != arr[i + 1]) {
                    result = arr[i];
                    break;
                }
            } catch (ArrayIndexOutOfBoundsException a) {
                result = arr[arr.length - 1];
            }
        }

        return result;
    }
}
