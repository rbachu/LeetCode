#include "stack.h"

/* 注意，类中的成员函数可以直接访问类中的私有变量 */

/* 构造函数 */
Stack::Stack() {
    /* 创造一个空栈 */
    top = 0;
}

/* 判断是否为空栈 */
bool Stack::is_empty() const {
    return top == 0;
}

/* 判断是否为栈满 */
bool Stack::is_full() const {
    return top == MAX;
}

/* 压栈操作 */
bool Stack::push(const Item &item) {
    if (top < MAX) {
        items[top++] = item;
        return true;
    } else {
        return false;
    }
}

/* 出栈操作 */
bool Stack::pop(Item &item) {
    if (top > 0) {
        item = items[--top];
        return true;
    } else {
        return false;
    }
}



