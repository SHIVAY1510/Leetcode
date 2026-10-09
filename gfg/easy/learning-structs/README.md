# Create a Linked List Node Using Struct

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Define a Node struct to represent a node of a singly linked list. The struct must contain:

- data: an integer that stores the value of the node.
- next: a pointer to the next node in the linked list..

For the last node, next should point to NULL. The provided driver code uses the Node struct to create a linked list from the given values and calculates its length.

 **Examples:** 

```
Input: list = [1, 2, 3, 4, 5]
Output: 5
Explanation: The linked list is 1 → 2 → 3 → 4 → 5 → NULL, so it contains 5 nodes.
```

```
Input: list = [10]
Output: 1
Explanation: The linked list contains a single node, 10 → NULL, so it contains 1 node.
```

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-09T10:14:13.138Z  

```cpp
struct Node {
    // code here
    int data;
    Node* next;
    Node(){
        data=0;
        next=nullptr;
    }
    Node(int x){
        data=x;
        next=nullptr;
    }
};
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/learning-structs/1)