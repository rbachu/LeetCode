#include <stdio.h>

int main()
{
    int a[6] = {1, 4, 5, 6, 2, 3};
    int temp = 0;
    int i = 0,
        j = 0;

    for (j = 0; j < 6 - 1; j++) {
        for (i = 0; i < 6 - j - 1; i++) {
            if (a[i] > a[i + 1]) {
                temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
            }
        }
    }

    for (i = 0; i < 6; i++) {
        printf("%d ", a[i]);
    }
    printf("\n");

    return 0;
}

