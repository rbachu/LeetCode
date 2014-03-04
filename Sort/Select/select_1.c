#include <stdio.h>

int main()
{
    int a[6] = {5, 4, 2, 3, 1, 6};
    int min = 0;
    int i = 0,
        j = 0,
        k = 0;

    /* 朴素地实现了选择排序，
     * 但并不准确，
     * 应该是从未排序序列中选择一个最小的数据，
     * 接到已排序数列的最后，
     * 更像是一个“插入”操作
     */
    for (i = 0; i < 6; i++) {
        min = a[i];
        /* 记录下最小元素的位置 */
        for (j = i; j < 6; j++) {
            if (a[j] < min) {
                min = a[j];
                k = j;
            }
        }
        /* 移动元素是效率并不高的 */
        for (j = k; j > i; j--) {
            a[j] = a[j - 1];
        }
        a[i] = min;
    }

    for (i = 0; i < 6; i++) {
        printf("%d ", a[i]);
    }
    printf("\n");

    return 0;
}
