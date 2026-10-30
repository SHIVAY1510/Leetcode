# Shortest Path With At Most K Consecutive Identical Characters

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an integer `n` representing the number of nodes in a  **directed weighted**  graph, numbered from 0 to `n - 1`. This is represented by a 2D integer array `edges`, where `edges[i] = [ui, vi, wi]` represents a directed edge from node `ui` to node `vi` with weight `wi`.

You are also given a string `labels` of length `n`, where `labels[i]` is the character assigned to node `i`, and an integer `k`.

Return the  **minimum**   **total**  edge weight of a path from node 0 to node `n - 1` such that the concatenation of the labels of the nodes along the path contains  **at most**  `k`  **consecutive**   **identical**  characters. If no valid path exists, return -1.

 

 **Example 1:** 

 **Input:**  n = 3, edges = [[0,1,1],[1,2,1],[0,2,3]], labels = "aab", k = 1

 **Output:**  3

 **Explanation:** 

The optimal valid path from node 0 to node 2 is as follows:

- Use edges[2] = [0, 2, 3] to reach node 2 with a weight wi = 3.
The corresponding concatenation of labels is `"ab"`, which satisfies at most `k = 1` consecutive identical characters. Thus, the answer is 3.

 **Example 2:** 

 **Input:**  n = 3, edges = [[0,1,1],[1,2,1],[0,2,3]], labels = "aab", k = 2

 **Output:**  2

 **Explanation:** 

The optimal valid path from node 0 to node 2 is as follows:

- Use edges[0] = [0, 1, 1] to reach node 1 with weight wi = 1.
- Use edges[1] = [1, 2, 1] to reach node 2 with weight wi = 1.
The corresponding concatenation of labels is `"aab"`, which satisfies at most `k = 2` consecutive identical characters. Thus, the answer is 2.

 **Example 3:** 

 **Input:**  n = 3, edges = [[0,1,1],[1,2,1]], labels = "aaa", k = 2

 **Output:**  -1

 **Explanation:** 

There is no valid path from node 0 to node 2 that satisfies at most `k = 2` consecutive identical characters. Thus, the answer is -1.

 

 **Constraints:** 

- 1 <= n == labels.length <= 5 * 104
- 0 <= edges.length <= 5 * 104
- edges[i] == [ui, vi, wi]
- 0 <= ui, vi <= n - 1
- ui != vi
- 1 <= wi <= 104
- labels consists of lowercase English letters
- 1 <= k <= 50

## Solution

**Language:** Java  
**Runtime:** 35 ms (beats 98.44%)  
**Memory:** 233.3 MB (beats 53.91%)  
**Submitted:** 2026-10-30T15:39:05.948Z  

```java
class Solution {
    class MinHeap{
        long[] cost;
        int[] node,count;
        int size=0;
        long popCost;
        int popNode,popCount;
        MinHeap(){
            cost=new long[16];
            node=new int[16];
            count=new int[16];
        }
        void push(long c,int n,int cnt){
            if(size==cost.length){
                long[] a=new long[size*2];
                int[] b=new int[size*2];
                int[] d=new int[size*2];
                for(int i=0;i<size;i++){
                    a[i]=cost[i];
                    b[i]=node[i];
                    d[i]=count[i];
                }
                cost=a;
                node=b;
                count=d;
            }
            int i=size++;
            while(i>0){
                int p=(i-1)/2;
                if(cost[p]<=c) break;
                cost[i]=cost[p];
                node[i]=node[p];
                count[i]=count[p];
                i=p;
            }
            cost[i]=c;
            node[i]=n;
            count[i]=cnt;
        }
        boolean isEmpty(){
            return size==0;
        }
        void pop(){
            popCost=cost[0];
            popNode=node[0];
            popCount=count[0];
            size--;
            if(size==0) return;
            long c=cost[size];
            int n=node[size];
            int cnt=count[size];
            int i=0;
            while(2*i+1<size){
                int child=2*i+1;
                if(child+1<size && cost[child+1]<cost[child]){
                    child++;
                }
                if(cost[child]>=c) break;
                cost[i]=cost[child];
                node[i]=node[child];
                count[i]=count[child];
                i=child;
            }
            cost[i]=c;
            node[i]=n;
            count[i]=cnt;
        }
    }
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        if(n==1) return 0;
        int[][] mavorqeli=edges;
        int m=mavorqeli.length;
        int[] head=new int[n];
        int[] to =new int[m];
        int[] weight=new int[m];
        int[] next=new int[m];
        for(int i=0;i<n;i++){
            head[i]=-1;
        }
        for(int i=0;i<m;i++){
            int u=mavorqeli[i][0];
            to[i]=mavorqeli[i][1];
            weight[i]=mavorqeli[i][2];
            next[i]=head[u];
            head[u]=i;
        }
        long[][] dist=new long[n][k+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=k;j++){
                dist[i][j]=Long.MAX_VALUE;
            }
        }
        MinHeap pq=new MinHeap();
        dist[0][1]=0;
        pq.push(0,0,1);
        while(!pq.isEmpty()){
            pq.pop();
            long cost=pq.popCost;
            int node=pq.popNode;
            int count=pq.popCount;
            if(cost!=dist[node][count]){
                continue;
            }
            if(node==n-1){
                return (int) cost;
            }
            for(int e=head[node];e!=-1;e=next[e]){
                int v=to[e];
                int w=weight[e];
                int newCount;
                if(labels.charAt(node)==labels.charAt(v)){
                    newCount=count+1;
                }
                else{
                    newCount=1;
                }
                if(newCount>k){
                    continue;
                }
                long newCost=cost+w;
                if(newCost<dist[v][newCount]){
                    dist[v][newCount]=newCost;
                    pq.push(newCost,v,newCount);
                }
            }
        }
        return -1;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/shortest-path-with-at-most-k-consecutive-identical-characters/)