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
    public boolean isPalindrome(ListNode head) {
    //  ListNode  cur=head;
    //  ArrayList<Integer> ar=new ArrayList<>();
    //  while(cur!=null){
    //     ar.add(cur.val);
    //     cur=cur.next;
    //  }
    //  int left=0;
    //  int right=ar.size()-1;
    //  while(left<right){
    //     if(!ar.get(left).equals (ar.get(right))){
    //         return false;
    //     }
    //     left++;
    //     right--;
    //  }
    //  return true;
    ListNode cur=head;
    ListNode slow= head;
    ListNode fast=head;
    while(fast!=null && fast.next!=null){
        slow=slow.next;
        fast=fast.next.next;
    }
    ListNode prev=null;
    ListNode temp=slow;
    ListNode t=null;
    while(temp!=null){
        t=temp.next;
        temp.next=prev;
        prev=temp;
        temp=t;
    }
    ListNode p1=head;
    ListNode p2=prev;
    while(p2!=null){
     if(p1.val!=p2.val){
        return false;
     }   
     p1=p1.next;
     p2=p2.next;
    }
    return true;
    }
}