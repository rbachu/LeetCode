import java.util.HashMap;

final class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
public final class Solution {
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
