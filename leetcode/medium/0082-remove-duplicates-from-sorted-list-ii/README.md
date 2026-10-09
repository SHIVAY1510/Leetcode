# Remove Duplicates from Sorted List II

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given the `head` of a  **sorted**  linked list.

Delete all nodes that have  **duplicate**  numbers, leaving only  **distinct**  numbers from the original list.

Return the linked list  **sorted**  as well.

 

 **Example 1:** 

```
Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]

```

 **Example 2:** 

```
Input: head = [1,1,1,2,3]
Output: [2,3]

```

 

 **Constraints:** 

- The number of nodes in the list is in the range [0, 300].
- -100 <= Node.val <= 100
- The list is guaranteed to be sorted in ascending order.

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 44.8 MB (beats 86.17%)  
**Submitted:** 2026-10-09T03:25:55.861Z  

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
    public ListNode deleteDuplicates(ListNode head) {

        ListNode temp = head;
        ListNode prev = null;

        while (temp != null) {

            if (temp.next != null && temp.val == temp.next.val) {

                int val = temp.val;
                while (temp != null && temp.val == val) {
                    temp = temp.next;

                    if (prev == null) {
                        head = temp;
                    } else {
                        prev.next = temp;
                    }
                }

            } else {
                prev = temp;
                temp = temp.next;
            }
        }

        return head;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/)