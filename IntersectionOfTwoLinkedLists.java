/*
 * 原题链接：https://leetcode.com/problems/intersection-of-two-linked-lists/
 * 2015.04.16
 *
 * 主要知识点：无
 */

import java.util.HashMap;

public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        /* 测试 */
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

/*
 * 我这么想还是复杂了，时间复杂度和空间复杂度均为O(n)；
 * 参考下列链接可以实现时间复杂度为O(n)，空间复杂度为O(1)的解决方案：
 * https://leetcode.com/discuss/31067/share-my-simple-java-solution-o-n-time-o-1-space
 */
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<Integer, ListNode> map = new HashMap<Integer, ListNode>();
        ListNode pointA = headA;
        ListNode pointB = headB;

        if (pointA == null || pointB == null) {
            return null;
        }

        while (pointA != null && pointB != null) {
            if (map.containsKey(pointA.val)) {
                return pointA;
            } else {
                map.put(pointA.val, pointA);
                pointA = pointA.next;
            }

            if (map.containsKey(pointB.val)) {
                return pointB;
            } else {
                map.put(pointB.val, pointB);
                pointB = pointB.next;
            }
        }

        while (pointA != null) {
            if (map.containsKey(pointA.val)) {
                return pointA;
            } else {
                pointA = pointA.next;
            }
        }

        while (pointB != null) {
            if (map.containsKey(pointB.val)) {
                return pointB;
            } else {
                pointB = pointB.next;
            }
        }

        return null;
    }
}
