class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        Deque<int[]>dq=new ArrayDeque<>();
        long ans=0;
        long cost=0;
        int j=nums.length-1;
        for(int i=nums.length-1;i>=0;i--){
            int num=nums[i];
            int count=1;
            while(!dq.isEmpty()&& dq.peekLast()[0]<num){
                int[] temp=dq.pollLast();
                int nextNum=temp[0];
                int nextCount=temp[1];
                count+=nextCount;
                cost+=(long)(num-nextNum)*nextCount;
            }
            dq.offerLast(new int[]{num,count});
            while(cost>k){
                int[] temp=dq.pollFirst();
                int rightNum=temp[0];
                int rightCount=temp[1];
                cost-=rightNum-nums[j];
                j--;
                if(rightCount>1){
                    dq.offerFirst(new int[]{
                        rightNum,rightCount-1
                    });
                }
            }
            ans+=j-i+1;
        }
        return ans;
    }
}