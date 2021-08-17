package algorithm;

import algorithm.LinkList.ReverseList;

/**
 * @Author: DonaldCen
 * @Date: 2021/8/10 15:00
 * @Desc: 链表反转
 * 例如：输入 1->2->3->4->5
 * 输出 5->4->3->2->1
 */
public class LeetCode01 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode listNode = get2(node1);
        System.out.println(listNode);
    }

    /**
     * 使用迭代的方法
     */
    public static ListNode get1(ListNode head){
        ListNode pre = null,next = null;
        ListNode cur = head;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 使用递归的方式
     */
    public static ListNode get2(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode listNode = get2(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;
    }
}
