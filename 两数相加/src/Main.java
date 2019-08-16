/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807

 */
public class Main {

    public static void main(String[] args) {

        ListNode x1=new ListNode(2);
        ListNode l1=x1;
        x1.next=new ListNode(4);
        x1.next.next=new ListNode(3);

        ListNode x2=new ListNode(5);
        ListNode l2=x2;
        x2.next=new ListNode(6);
        x2.next.next=new ListNode(4);

        Solution solution=new Solution();
        ListNode s=solution.addTwoNumbers(l1,l2);
        while(s!=null){
            System.out.println(s.val);
            s=s.next;
        }
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        StringBuffer sb=new StringBuffer();
        int x=0;
        int y=0;
        int z=0;
        int j=0;
        while(l1!=null||l2!=null){
            x=0;
            y=0;
            if(l1!=null){
                x=l1.val;
            }
            if(l2!=null){
                y=l2.val;
            }
            z=x+y+j;
            if(z>=10){
                j=1;
                z=z%10;
                sb.append(String.valueOf(z));
            }else{
                j=0;
                sb.append(String.valueOf(z));
            }

            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }

        }
        if(j==1){
            sb.append(j);
        }
        char[] c=sb.toString().toCharArray();
        ListNode listNode=new ListNode(Integer.parseInt(String.valueOf(c[0])));
        ListNode s=listNode;
        for(int i=1;i<c.length;i++){
            listNode.next=new ListNode(Integer.parseInt(String.valueOf(c[i])));
            listNode=listNode.next;
        }
        return s;
    }
}
