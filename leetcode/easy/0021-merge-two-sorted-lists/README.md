# Merge Two Sorted Lists

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

You are given the heads of two sorted linked lists `list1` and `list2`.

Merge the two lists into one  **sorted**  list. The list should be made by splicing together the nodes of the first two lists.

Return  *the head of the merged linked list*.

 

 **Example 1:** 

```
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

```

 **Example 2:** 

```
Input: list1 = [], list2 = []
Output: []

```

 **Example 3:** 

```
Input: list1 = [], list2 = [0]
Output: [0]

```

 

 **Constraints:** 

- The number of nodes in both lists is in the range [0, 50].
- -100 <= Node.val <= 100
- Both list1 and list2 are sorted in non-decreasing order.

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 44.5 MB (beats 20.26%)  
**Submitted:** 2026-10-07T04:30:52.550Z  

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // ArrayList<Integer>ar=new ArrayList<>();
        // while(list1!=null){
        //     ar.add(list1.val);
        //     list1=list1.next;
        // } 
        // while(list2!=null){
        //     ar.add(list2.val);
        //     list2=list2.next;
        // }
        // Collections.sort(ar);
        // ListNode dummy=new ListNode(0);
        // ListNode cur=dummy;
        // for(int i=0;i<ar.size();i++){
        //     cur.next=new ListNode(ar.get(i));
        //     cur=cur.next;
        // }
        // return dummy.next;
        ListNode dummy= new ListNode(0);
        ListNode cur=dummy;
        while(list1!=null&&list2!=null){
            if(list1.val<=list2.val){
                cur.next=list1;
                list1=list1.next;
            }
            else{
                cur.next=list2;
                list2=list2.next;
            }
            cur=cur.next;
        }
        if(list1!=null){
            cur.next=list1;
        }
        else{
            cur.next=list2;
        }
        return dummy.next;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/merge-two-sorted-lists/)