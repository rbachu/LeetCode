#include <stdio.h>
#include <stdlib.h>

typedef struct _Node {
    int name;
    struct _Node *next;
} Node;

Node *CreatList(Node *head)
{
    Node *node, *temp;
    int length;
    int i;

    printf("请输入需要建立的链表长度：");
    scanf("%d", &length);
    
    node = (Node *)malloc(sizeof(Node));
    (*head).next = node;
    (*node).name = 0;
    for (i = 1; i < length; i++) {
        temp = (Node *)malloc(sizeof(Node));
        (*temp).name = i;
        (*node).next = temp;
        node = temp;
    }

    printf("原始链表：\n");
    node = (*head).next;
    while (node != NULL) {
        printf("%d ", (*node).name);
        node = (*node).next;
    }
    printf("\n");

    return head;
}

Node *ReversalList(Node *head)
{
    Node *node, *temp, *local, *orf;
    int i;

    /* 首先将需要调换的节点保存到零时变量temp；
     * 将需要调换的节点的next指针指向最前面的那个节点；
     * 将最前面的那个节点的指针指向需要调换的节点的下一个节点；
     * 如此类推，直至反转完毕
     */
    local = (*head).next;
    while ((*local).next != NULL) {
        /* 取得需要调换的节点，存放到temp中 */
        temp = (*local).next;
        /* 取得当前链表的第一个节点，存放到orf */
        orf = (*head).next;
        /* 开始进行操作 */
        node = temp;
        /* 首先将local指向node的下一个节点 */
        (*local).next = (*node).next;
        /* 再将node指向当前链表的第一个节点orf */
        (*node).next = orf;
        /* 将head指向node */
        (*head).next = node;
    }

    printf("反转后的链表：\n");
    node = (*head).next;
    while (node != NULL) {
        printf("%d ", (*node).name);
        node = (*node).next;
    }
    printf("\n");

    return head;
}

int main()
{
    Node *head, *node, *temp;

    /* 开辟头接点 */
    head = (Node *)malloc(sizeof(Node));

    head = CreatList(head);
    head = ReversalList(head);

    /* 注意及时释放内存 */
    node = (*head).next;
    while (node != NULL) {
        temp = node;
        node = (*node).next;
        free(temp);
    }
    free(head);

    return 0;
}
