# Palindrome Linked List

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given the `head` of a singly linked list, return `true` *if it is a  **palindrome**  or* `false` *otherwise*.

 

 **Example 1:** 

```
Input: head = [1,2,2,1]
Output: true

```

 **Example 2:** 

```
Input: head = [1,2]
Output: false

```

 

 **Constraints:** 

- The number of nodes in the list is in the range [1, 105].
- 0 <= Node.val <= 9

 

 **Follow up:**  Could you do it in `O(n)` time and `O(1)` space?

## Solution

**Language:** Java  
**Runtime:** 3 ms (beats 99.84%)  
**Memory:** 94.3 MB (beats 66.37%)  
**Submitted:** 2026-10-07T04:51:54.413Z  

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
```

---

[View on LeetCode](https://leetcode.com/problems/palindrome-linked-list/)