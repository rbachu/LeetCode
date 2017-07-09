public final class Solution {
    int target = -1;

    public int majorityElement(int[] num) {
        if (num.length == 1) {
            return num[0];
        }

        sort(num, 0, num.length - 1);

        return target;
    }

    private void exch(int[] num, int first, int second) {
        int temp = num[first];
        num[first] = num[second];
        num[second] = temp;
    }

    private void sort(int[] num, int low, int high) {
        if (high <= low) {
            return;
        }

        int left = low;
        int right = high;
        int i = low + 1;
        int cmp = num[low];

        while (i <= right) {
            if (num[i] < cmp) {
                exch(num, left++, i++);
            } else if (num[i] > cmp) {
                exch(num, i, right--);
            } else {
                i++;
            }
        }

        if (right - left >= num.length / 2) {
            target = num[right];
            return;
        }

        sort(num, low, left - 1);
        sort(num, right + 1, high);
    }
}
