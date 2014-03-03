#include <stdio.h>

int main()
{
    int a[6] = {1, 3, 5, 4, 6, 2};
    int temp = 0;
    int i = 0,
        j = 0;

    for (j = 1; j < 6; j++) {
        temp = a[j];
        i = j - 1;
        while (i >= 0 && a[i] > temp) {
            a[i + 1] = a[i];
            i = i - 1;
        }
        a[i + 1] = temp;
    }

    for (i = 0; i < 6; i++) {
        printf("%d ", a[i]);
    }
    printf("\n");

    return 0;
}

