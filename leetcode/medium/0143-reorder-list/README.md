# Reorder List

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given the head of a singly linked-list. The list can be represented as:

```
L0 → L1 → … → Ln - 1 → Ln

```

 *Reorder the list to be on the following form:* 

```
L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

```

You may not modify the values in the list's nodes. Only nodes themselves may be changed.

 

 **Example 1:** 

```
Input: head = [1,2,3,4]
Output: [1,4,2,3]

```

 **Example 2:** 

```
Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]

```

 

 **Constraints:** 

- The number of nodes in the list is in the range [1, 5 * 104].
- 1 <= Node.val <= 1000

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 85.88%)  
**Memory:** 48.7 MB (beats 98.65%)  
**Submitted:** 2026-10-07T04:48:16.162Z  

```java
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
```

---

[View on LeetCode](https://leetcode.com/problems/reorder-list/)