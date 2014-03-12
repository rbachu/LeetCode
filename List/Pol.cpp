#include <iostream>

using namespace std;

/* 每一项的结构体 */
struct Node {
    char name;
    int mod;
    int power;
    int len;
    Node *next;
};

int CreateList(Node *head, int count)
{
    Node *node, *temp;
    int length = 0;
    int i = 0, j = 0;

    cout << "请输入要创建的多项式的名称（单个小写字母表示）：";
    cin >> head[count].name;
    cout << "请输入项数：";
    cin >> length;
    head[count].len = length;
    /* 开创第一项的节点，并将头接点指向该节点 */
    node = (Node *)new Node;
    head[count].next = node;
    cout << "请按照指数递减序列输入最减形式的多项式：" << endl;
    for (i = 0; i < length; i++) {
        cout << "请输入第" << i + 1 << "项的系数和指数（系数，指数）：";
        cin >> (*node).mod;
        cin >> (*node).power;
        /* 继续创建新节点 */
        temp = (Node *)new Node;
        (*node).next = temp;
        node = temp;
    }
    cout << "多项式" << head[count].name << "创建完毕！";
    count++;
    return count;
}

int SearchList(Node *head, int count, char call)
{
    int judge = 0;
    int i = 0;

    /* 开始检索 */
    for (i = 0, judge = -1; i < count; i++) {
        if (head[i].name != call) {
            continue;
        } else {
            judge = i;
            break;
        }
    }
    return judge;
}

void AddPol(Node *head, int count)
{
    Node *node_1, *node_2, head_3, *node_3, *temp;
    char name_1 = '0', name_2 = '0';
    int rc_1 = 0, rc_2 = 0;
    int add = 0;
    int i = 0, j = 0;

    cout << "请输入需要求和的第1个多项式的名称：";
    cin >> name_1;
    cout << "请输入需要求和的第2个多项式的名称：";
    cin >> name_2;
    rc_1 = SearchList(head, count, name_1);
    rc_2 = SearchList(head, count, name_2);
    if (rc_1 == -1 || rc_2 == -1) {
        cout << "输入的多项式不存在，请注意检查";
    } else {
         node_1 = head[rc_1].next;
         node_2 = head[rc_2].next;
         node_3 = (Node *)new Node;
         head_3.next = node_3;
         /* 最好不要进行指针直接的复制，还是新创节点好 */
         while ((*node_1).next != NULL || (*node_2).next != NULL) {
             if ((*node_1).power > (*node_2).power) {
                 (*node_3).mod = (*node_1).mod;
                 (*node_3).power = (*node_1).power;
                 temp = (Node *)new Node;
                 (*node_3).next = temp;
                 node_3 = temp;
                 node_1 = (*node_1).next;
             } else if ((*node_1).power < (*node_2).power) {
                 (*node_3).mod = (*node_2).mod;
                 (*node_3).power = (*node_2).power;
                 temp = (Node *)new Node;
                 (*node_3).next = temp;
                 node_3 = temp;
                 node_2 = (*node_2).next;
             } else {
                add = (*node_1).mod + (*node_2).mod;
                if (add != 0) {
                    (*node_3).mod = add;
                    (*node_3).power = (*node_1).power;
                    temp = (Node *)new Node;
                    (*node_3).next = temp;
                    node_3 = temp;
                    node_1 = (*node_1).next;
                    node_2 = (*node_2).next;
                } else {
                    node_1 = (*node_1).next;
                    node_2 = (*node_2).next;
                }
            }
        }
        /* 最后再把剩下没有比较的直接链接到node_3 */
        while ((*node_1).next != NULL) {
            (*node_3).mod = (*node_1).mod;
            (*node_3).power = (*node_1).power;
            temp = (Node *)new Node;
            (*node_3).next = temp;
            node_3 = temp;
            node_1 = (*node_1).next;
        }
        while ((*node_2).next != NULL) {
            (*node_3).mod = (*node_2).mod;
            (*node_3).power = (*node_2).power;
            temp = (Node *)new Node;
            (*node_3).next = temp;
            node_3 = temp;
            node_2 = (*node_2).next;
        }
        /* 输出相加得到的链表 */
        node_3 = head_3.next;
        if ((*node_3).next != NULL) {
            cout << (*node_3).mod << "x^(" << (*node_3).power << ")";
            node_3 = (*node_3).next;
        }
        while ((*node_3).next != NULL) {
            if ((*node_3).mod >= 0) {
                cout << " + " << (*node_3).mod << "x^(" << (*node_3).power << ")";
            } else {
                cout << " - " << -(*node_3).mod << "x^(" << (*node_3).power << ")";
            }
            node_3 = (*node_3).next;
        }
        /* 输出完毕之后，释放内存 */
        node_3 = head_3.next;
        while ((*node_3).next != NULL) {
            temp = (*node_3).next;
            delete node_3;
            node_3 = temp;
        }
    }
    cout << endl;
}

void JanPol(Node *head, int count)
{
    Node *node_1, *node_2, head_3, *node_3, *temp;
    char name_1 = '0', name_2 = '0';
    int rc_1 = 0, rc_2 = 0;
    int jan = 0;
    int i = 0, j = 0;

    cout << "请输入需要求和的第1个多项式的名称：";
    cin >> name_1;
    cout << "请输入需要求和的第2个多项式的名称：";
    cin >> name_2;
    rc_1 = SearchList(head, count, name_1);
    rc_2 = SearchList(head, count, name_2);
    if (rc_1 == -1 || rc_2 == -1) {
        cout << "输入的多项式不存在，请注意检查";
    } else {
        node_1 = (head[rc_1]).next;
        node_2 = (head[rc_2]).next;
        node_3 = (Node *)new Node;
        head_3.next = node_3;
        /* 最好不要进行指针直接的复制，还是新创节点好 */
        while ((*node_1).next != NULL || (*node_2).next != NULL) {
            if ((*node_1).power > (*node_2).power) {
                (*node_3).mod = (*node_1).mod;
                (*node_3).power = (*node_1).power;
                temp = (Node *)new Node;
                (*node_3).next = temp;
                node_3 = temp;
                node_1 = (*node_1).next;
            } else if ((*node_1).power < (*node_2).power) {
                (*node_3).mod = (*node_2).mod;
                (*node_3).power = (*node_2).power;
                temp = (Node *)new Node;
                (*node_3).next = temp;
                node_3 = temp;
                node_2 = (*node_2).next;
            } else {
                jan = (*node_1).mod - (*node_2).mod;
                if (jan != 0) {
                    (*node_3).mod = jan;
                    (*node_3).power = (*node_1).power;
                    temp = (Node *)new Node;
                    (*node_3).next = temp;
                    node_3 = temp;
                    node_1 = (*node_1).next;
                    node_2 = (*node_2).next;
                } else {
                    node_1 = (*node_1).next;
                    node_2 = (*node_2).next;
                }
            }
        }
        /* 最后再把剩下没有比较的直接链接到node_3 */
        while ((*node_1).next != NULL) {
            (*node_3).mod = (*node_1).mod;
            (*node_3).power = (*node_1).power;
            temp = (Node *)new Node;
            (*node_3).next = temp;
            node_3 = temp;
            node_1 = (*node_1).next;
        }
        while ((*node_2).next != NULL) {
            (*node_3).mod = (*node_2).mod;
            (*node_3).power = (*node_2).power;
            temp = (Node *)new Node;
            (*node_3).next = temp;
            node_3 = temp;
            node_2 = (*node_2).next;
        }
        /* 输出相减得到的链表 */
        node_3 = head_3.next;
        if ((*node_3).next != NULL) {
            cout << (*node_3).mod << "x^(" << (*node_3).power << ")";
            node_3 = (*node_3).next;
        }
        while ((*node_3).next != NULL) {
            if ((*node_3).mod >= 0) {
                cout << " + " << (*node_3).mod << "x^(" << (*node_3).power << ")";
            } else {
                cout << " - " << -(*node_3).mod << "x^(" << (*node_3).power << ")";
            }
            node_3 = (*node_3).next;
        }
        /* 输出完毕之后，释放内存 */
        node_3 = head_3.next;
        while ((*node_3).next != NULL) {
            temp = (*node_3).next;
            delete node_3;
            node_3 = temp;
        }
    }
    cout << endl;
}

int  DeleteList(Node *head, int count, int rc)
{
    int i = 0;

    /* 开始覆盖操作 */
    for (i = rc; i < count - 1; i++) {
        head[i] = head[i + 1];
    }
    count--;

    return count;
}


int main()
{
    Node head[100], *node, *temp;
    char cmd = '0', call = '0', name_1 = '0', name_2 = '0';
    int count = 0, length = 0, rc_1 = 0, rc_2 = 0;
    int i = 0, j = 0;

    cout << "1. 建立多链表" << endl;
    cout << "2. 输出多链表" << endl;
    cout << "3. 求两个多项式之和（必须先创建），建立和式并输出" << endl;
    cout << "4. 求两个多项式之差（必须先创建），建立差式并输出" << endl;
    cout << "5. 删除多项式" << endl;
    cout << "6. 退出" << endl;

    /* 不考虑各种错误输入 */
    count = 0;
    cout << "请输入指令：";
    while (cin >> cmd) {
        if (cmd == '1') {
            count = CreateList(head, count);
            cout << endl << "请输入指令：";
        } else if (cmd == '2') {
            cout << "请输入需要输出的多项式名称：";
            cin >> call;
            /* 开始检索 */
            rc_1 = SearchList(head, count, call);
            if (rc_1 == -1) {
                cout << "不存在此多项式";
            } else {
                node = head[rc_1].next;
                /* 输出第一项 */
                if ((*node).next != NULL) {
                    cout << (*node).mod << "x^(" << (*node).power << ")";
                    node = (*node).next;
                }
                /* 输出剩余项 */
                while ((*node).next != NULL) {
                    if ((*node).mod >= 0) {
                        cout << " + " << (*node).mod << "x^(" << (*node).power << ")";
                    } else {
                        cout << " - " << -(*node).mod << "x^(" << (*node).power << ")";
                    }
                    node = (*node).next;
                }
            }
            cout << endl << "请输入指令：";
        } else if (cmd == '3') {
            AddPol(head, count);
            cout << "请输入指令：";
        } else if (cmd == '4') {
            JanPol(head, count);
            cout << "请输入指令：";
        } else if (cmd == '5') {
            cout << "请输入需要删除的多项式名称：";
            cin >> name_1;
            rc_1 = SearchList(head, count, name_1);
            if (rc_1 == 0) {
                cout << "不存在该链表，不需要删除" << endl;
            } else {
                count = DeleteList(head, count, rc_1);
                cout << "多项式" << name_1 << "删除完毕" << endl;
                cout << "请输入指令：";
            }
        } else if (cmd == '6') {
            for (i = 0; i < count; i++) {
                node = head[i].next;
                while (node != NULL) {
                    temp = (*node).next;
                    delete node;
                    node = temp;
                }
            }
            cout << "再见 :)" << endl;
            return 0;
        } else {
            cout << "您输入的指令有错误" << endl;
            cout << "请输入指令：";
        }
    }

    return 0;
}
