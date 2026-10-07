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
    public void reorderList(ListNode head) {
    //  ArrayList<Integer> ar=new ArrayList<>();
    //   ListNode temp=head;
    //  while(temp!=null){
    //     ar.add(temp);
    //     temp=temp.next;
    //  }
    //  int l=0;
    //  int r=ar.size()-1;
    //  while(temp!=null){
    //     temp.val=ar.get(l);
    //     temp=temp.next;
    //     if(temp==null){
    //         break;
    //     }
    //     temp.val=ar.get(r);
    //     temp=temp.next;
    //     l++;
    //     r--;
    // }
    // ArrayList<ListNode> ar=new ArrayList<>();
    // ListNode temp=head;
    // while(temp!=null){
    //     ar.add(temp);
    //     temp=temp.next;
    // }
    // int l=0;
    // int r=ar.size()-1;
    // while(l<r){
    //     ar.get(l).next=ar.get(r);
    //     l++;
    //     if(l==r){
    //         break;
    //     }
    //     ar.get(r).next=ar.get(l);
    //     r--;
    // }
    // ar.get(l).next=null;   
    ListNode slow=head;
    ListNode fast=head;
    while(fast.next!=null&&fast.next.next!=null){
        slow=slow.next;
        fast=fast.next.next;
    }
    ListNode temp=slow.next;
    slow.next=null;
    ListNode prev=null;
    ListNode fwd=null;
    while(temp!=null){
        fwd=temp.next;
        temp.next=prev;
        prev=temp;
        temp=fwd;
    }
    temp=head;
    while(prev!=null){
        ListNode p1=temp.next;
        ListNode p2=prev.next;
        temp.next=prev;
        prev.next=p1;
        temp=p1;
        prev=p2;
    }
    }
}