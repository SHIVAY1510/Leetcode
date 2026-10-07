class Solution {
    public int maxArea(int[] height) {
        //   int n=height.length;
        // int maxArea=0;
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         int h=Math.min(height[i],height[j]);
        //        int width=j-i;
        //        int area=width*h;
        //         maxArea=Math.max(maxArea,area);
        //     }
        // }
        // return maxArea;
        int n=height.length;
        int maxArea=0;
        int l=0;
        int r=n-1;
        while(l<r){
        int ht=Math.min(height[l],height[r]);
        int width=r-l;
        int area=width*ht;
        maxArea=Math.max(maxArea,area);
        if(height[l]<=height[r]){
            l++;
        }
        else{
            r--;
        }
        }
        return maxArea;
    }
}