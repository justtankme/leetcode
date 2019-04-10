package com.test;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 示例：
 * 
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
 * 
 * @author duanzhiwei {@link https://leetcode-cn.com/problems/add-two-numbers/}
 */
public class AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 定义一个值为0的链表头
        ListNode first = new ListNode(0);
        // 定义链表指针，默认指向表头
        ListNode current = first;
        // 进位，上一个数如果超过9，则给这个变量赋值
        int carry = 0;
        while (true) {
            // 仅当两个链表都遍历完了才算结束
            if (l1 == null && l2 == null) {
                // 结束时，要计算最后一个求和是否有进位
                if (carry > 0) {
                    current.next = new ListNode(carry);
                }
                break;
            }
            // 获取当前链表的值，并让其指向下一个节点
            int l1Val = 0;
            int l2Val = 0;
            if (l1 != null) {
                l1Val = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                l2Val = l2.val;
                l2 = l2.next;
            }
            // 对当前值求和，注意要加上上一次求和的进位
            int tmp = l1Val + l2Val + carry;
            // 进位用完后记得复位
            carry = 0;
            // 判断和是否大于9，是则取余，并对进位赋值
            // 这里也适用其他进制，如16进制
            if (tmp > 9) {
                carry = tmp / 10;
                tmp = tmp % 10;
            }
            // 对结果链表赋值，然后指针指向下一个节点
            current.next = new ListNode(tmp);
            current = current.next;
        }
        // 返回时注意不要包含表头
        return first.next;
    }

    public static void main(String[] args) {

    }
}
