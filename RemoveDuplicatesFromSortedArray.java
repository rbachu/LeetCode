/*
 * 原题链接：https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * 2015.04.15
 *
 * 主要知识点：数组
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        /* 测试 */
    }
}

/*
 * 注意Java中不存在类似C/C++中那样的数组结束符'\0'，
 * 所以是根据Arrays.length来判断可访问的数组长度的，
 * 因此我们只需要把不重复的数组元素向前移动同时缩短相应的数组长度即可，
 * 尽管多余的数组元素仍然存在于数组中，
 * 但是并不会被访问到。
 */
class Solution {
    public int removeDuplicates(int[] array) {
        if(array == null){
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
