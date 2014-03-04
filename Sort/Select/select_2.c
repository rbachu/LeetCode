#include <stdio.h>

int main()
{
    int a[6] = {1, 3, 5, 6, 4, 2};
    int min = 0,
        temp = 0;
    int i = 0,
        j = 0;
    
    /* 参考维基百科上的实现，
     * 正宗的选择排序
     */
    for (i = 0; i < 6 - 1; i++) {
        min = i;
        /* 简化了select_1.c中记录最小元素位置的操作 */
        for (j = i + 1; j < 6; j++) {
            if (a[min] > a[j]) {
                min = j;
            }
        }
        /* 直接两个元素之间的交换，
         * 而不用移动其他的元素
         */
        if (min != i) {
            temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }
    }

    for (i = 0; i < 6; i++) {
        printf("%d ", a[i]);
    }
    printf("\n");

    return 0;
}
