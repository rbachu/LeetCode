#include <stdio.h>

int main()
{
    int a[6] = {5, 2, 3, 6, 2, 1};
    int temp = 0;
    int i = 0,
        j = 0,
        k = 0;

    for (i = 0; i < 6; i++) {
        temp = a[i];
        j = 0;
        while (a[j] <= a[i] && j <= i) {
            j++;
        }
        if (j >= i) {
            continue;
        } else {
            for (k = i; k > j; k--) {
                a[k] = a[k - 1];
            }
            a[j] = temp;
        }
    }
    
    for (i = 0; i < 6; i++) {
        printf("%d ", a[i]);
    }
    printf("\n");

    return 0;
}
