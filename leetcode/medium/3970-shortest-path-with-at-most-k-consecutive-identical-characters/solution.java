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