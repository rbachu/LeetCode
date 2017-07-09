public final class Solution {
    public int removeDuplicates(int[] array) {
        if (array == null) {
            return 0;
        }

        int j = 0;
        int len = array.length;

        for(int i = 1; i < array.length; i++){
            if(array[j] == array[i]){
                len--;
            } else {
                j++;
                array[j] = array[i];
            }
        }

        return len;
    }
}
