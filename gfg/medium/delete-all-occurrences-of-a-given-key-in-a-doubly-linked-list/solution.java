/*Structure of the doubly linked list  Node
class Node {
  public int data;
  public Node next;
  public Node prev;

  public Node(int x) {
      data = x;
      next = null;
      prev = null;
  }
};*/

class Solution {
    public Node deleteAllOccurOfX(Node head, int x) {
        // code here
      Node cur=head;
     while(cur!=null){
         if(cur.data==x){
         
           if(cur==head){
             head=cur.next;
           }
         if(cur.prev!=null){
             cur.prev.next=cur.next;
             }
             if(cur.next!=null){
                 cur.next.prev=cur.prev;
            }
         }
         cur=cur.next;
        }
        return head;
    }
}