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
    public ListNode reverseList(ListNode head) {
        // LinkedList<Integer> v=new LinkedList<>();
        // ListNode temp=head;
        // while(temp!=null){
        //     v.add(temp.val);
        //     temp=temp.next;
        // }
        // temp=head;
        // for(int i=v.size()-1;i>=0;i--){
        //     temp.val=v.get(i);
        //     temp=temp.next;
        // }
        // return head;
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}