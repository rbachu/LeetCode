#include <stdio.h>

int main()
{
    int a[6] = {5, 2, 3, 6, 2, 1};
    int temp = 0;
    int i = 0,
        j = 0,
        k = 0;

    /* 朴素地实现插入排序 */
    for (i = 0; i < 6; i++) {
        temp = a[i];
        j = 0;
        /* 在已排好序的序列中遍历一遍，
         * 找到待插入元素应该插入的位置 
         */
        while (a[j] <= a[i] && j <= i) {
            j++;
        }
        /* 如果遍历过后没有找到比待插入元素大的元素，
         * 则进入下一次遍历；
         * 否则进行插入，
         * 具体表现为数组元素前后之间的覆盖行为
         */
        if (j >= i) {
            continue;
        } else {
            for (k = i; k > j; k--) {
                a[k] = a[k - 1];
            }
            /* 记住把待插入元素赋值到相应位置上 */
            a[j] = temp;
        }
    }
    
    for (i = 0; i < 6; i++) {
        printf("%d ", a[i]);
    }
    printf("\n");

    return 0;
}
