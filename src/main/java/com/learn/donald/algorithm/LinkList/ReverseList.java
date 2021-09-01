package com.learn.donald.algorithm.LinkList;

/**
 * @Description
 * @Author <a href="mailto:cenyingqiang@wxchina.com">yingqiang.Cen</a>
 * @Date 2021/8/4
 * @Version 1.0.0
 */
public class ReverseList {
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
        ListNode node5 = new ListNode(5,null);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);

        /*ListNode recursion = recursion(node1);
        System.out.println(recursion);*/

        /*ListNode r1 = r1(node1);
        System.out.println(r1);*/

        ListNode r2 = r2(node1);
        System.out.println(r2);
    }

    public static ListNode r1(ListNode head){
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

    public static ListNode r2(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode listNode = r2(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;
    }

    /**
     * 做法：相当于把 当前元素指向下一个 断开，改为 指向 前一个
     */
    public static ListNode iteration(ListNode head){
        ListNode prev = null;//前一个节点的值
        ListNode next = null;//后一个节点的值
        ListNode cur = head;//相当于for循环里面的i
        while (cur != null ){
            next = cur.next; //把下一个值保存一下
            cur.next = prev;//将后一个节点指向前一个节点
            prev = cur;//保存之前的值
            cur = next;//i++
        }
        return prev;
    }

    public static ListNode recursion(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode last = recursion(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
