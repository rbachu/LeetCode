#include <stdio.h>

int main()
{
    int a[6] = {5, 4, 3, 6, 2, 1};
    int temp = 0;
    int i = 0,
        j = 0,
        k = 0;

    /* 朴素地实现插入排序 */
    for (i = 1; i < 6; i++) {
        temp = a[i];
        /* 在已排好序的序列中遍历一遍，
         * 注意是从后向前扫描，
         * 找到待插入元素应该插入的位置；
         * 在这里使用j = i，
         * 以及a[j - 1] > a[i]的思路，
         * 其实是为了保证接下来的元素间覆盖不出问题，
         * 实际上的思路并不通常，
         * 这样是不可取的
         */
        j = i;
        while (a[j - 1] > a[i] && j > 0) {
            j--;
        }
        for (k = i; k > j; k--) {
            a[k] = a[k - 1];
        }
        a[j] = temp;
    }
    
    for (i = 0; i < 6; i++) {
        printf("%d ", a[i]);
    }
    printf("\n");

    return 0;
}
