/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
    ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode jump=dummy,first=head,second=head;
        while(true) {
            int i=0;
            while(second != null && i< k-1)
            {
                second=second.next;
                i++;
            }
            if(i==k-1 && second != null) {
                ListNode pre=second.next,cur=first,next;
                for(int j=-0;j<k;j++)
                {
                    next=cur.next;
                    cur.next=pre;
                    pre=cur;
                    cur=next;
                }
                jump.next=pre;
                jump=first;
                first=second=jump.next;
            }
            else
                return dummy.next;
        }
    }
}