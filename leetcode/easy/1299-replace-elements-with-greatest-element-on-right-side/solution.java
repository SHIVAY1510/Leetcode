class Solution {
    public int[] replaceElements(int[] arr) {
    //    int n=arr.length;
    //     for(int i=0;i<n;i++){
    //         int max=-1;
    //         for(int j=i+1;j<n;j++){
    //             if(arr[j]>max){
    //                 max=arr[j];
    //             }
    //         }
    //         arr[i]=max;
    //     }
    //     return arr;
    int n=arr.length;
    int max=-1;
    for(int i=n-1;i>=0;i--){
        int curr=arr[i];
        arr[i]=max;
        if(curr>max){
            max=curr;
        }
    }
    return arr;
    }
}