package com.learn.donald.algorithm.LinkList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: DonaldCen
 * @Date: 2021/11/2 13:55
 * @Desc:
 */
public class Solution {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return true;
            }
            slow = fast.next;
            fast = fast.next.next;
        }
        return false;
    }

    /*public static ListNode mergeTwoLists(ListNode l1,ListNode l2){
        if(l1 == null){
            return l2;
        } else if(l2 == null){
            return l1;
        } else if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }*/

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void mergeTwoListsTest() {
        ListNode node5 = new ListNode(55, null);
        ListNode node4 = new ListNode(44, node5);
        ListNode node3 = new ListNode(33, node4);

        ListNode node55 = new ListNode(66, null);
        ListNode node44 = new ListNode(35, node55);
        ListNode node33 = new ListNode(34, node44);

        ListNode total = mergeTwoLists(node3, node33);
        System.out.println(total);
    }

    public static void removeNthFromEndTest() {
        ListNode node5 = new ListNode(55, null);
        ListNode node4 = new ListNode(44, node5);
        ListNode node3 = new ListNode(33, node4);
        ListNode listNode = removeNthFromEnd(node3, 1);
        System.out.println(listNode);
    }

    public static void middleNodeTest() {
        ListNode node5 = new ListNode(55, null);
        ListNode node4 = new ListNode(44, node5);
        ListNode node3 = new ListNode(33, node4);
        ListNode listNode = middleNode3(node3);
        System.out.println(listNode);
    }

    public static void threeSumTest() {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(arr);
        System.out.println(lists);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 创建辅助头节点，head , fast 和 slow 都指向这个辅助头节点
        ListNode fast = new ListNode(0);
        fast.next = head;
        head = fast;
        ListNode slow = fast;

        // fast 指针先走 n + 1 个单位
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // fast 指针和 slow 指针一起移动，直到 fast 指向空后，slow 指针则指向倒数第 n + 1个节点。
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // 删除倒数第 n 个节点
        slow.next = slow.next.next;

        // 由于我们设置了辅助头节点，所以 head.next 才是链表的首元节点。
        return head.next;
    }

    public static ListNode middleNode(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        return list.get(list.size() / 2);
    }

    public static ListNode middleNode2(ListNode head) {
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        int k = 0;
        cur = head;
        while (k < n / 2) {
            k++;
            cur = cur.next;
        }
        return cur;
    }

    public static ListNode middleNode3(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int k = 0; k < nums.length; k++) {
            int i = k + 1;
            int j = nums.length - 1;
            if (nums[k] > 0) {
                break;
            }
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]) ;
                } else if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]) ;
                } else {
                    List<Integer> l1 = new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j]));
                    list.add(l1);
                    while (i < j && nums[i] == nums[++i]) ;
                    while (i < j && nums[j] == nums[--j]) ;
                }
            }
        }
        return list;
    }

    public static int majorityElement(int[] nums) {
        int a = nums[0];
        int count = 1;
        for(int i = 1;i < nums.length;i++){
            if(a == nums[i]){
                count++;
            } else if(--count == 0){
                a = nums[i];
                count = 1;
            }
        }
        return a;
    }

    public static int firstMissingPositive(int[] nums) {
        boolean has_1 = false;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1) has_1 = true;
            if(nums[i] <= 0) nums[i] = 1;
        }
        if(!has_1) return 1;

        for(int i = 0; i < nums.length; i++){
            if(Math.abs(nums[i]) > nums.length) continue;
            else{
                if(nums[Math.abs(nums[i])-1] > 0) nums[Math.abs(nums[i])-1] *= -1;
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                return i + 1;
            }
        }

        return nums.length + 1;

    }

    public static void firstMissingPositiveTest(){
        int[] arr = {1,2,0};
        int i = firstMissingPositive(arr);
        System.out.println(i);
    }

    public static void majorityElementTest(){
        int[] arr = {2,2,1,1,1,2,2,5,5,5,5,5,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,5};
        int i = majorityElement(arr);
        System.out.println(i);
    }


    public static void main(String[] args) {
        firstMissingPositiveTest();
    }
}
