#ifndef __STACK_H__
#define __STACK_H__

/* 使用typedef，可以保证接口的一致，
 * 比如可以把long改成其他类型什么的
 */
typedef unsigned long Item;

class Stack {
    private:
        enum {MAX = 10};
        Item items[MAX];
        int top;
    public:
        /* 构造函数 */
        Stack();
        /* 判断函数 */
        bool is_empty() const;
        bool is_full() const;
        /* 压栈操作 */
        bool push(const Item &item);
        /* 出栈操作 */
        bool pop(Item &item);
};

#endif
