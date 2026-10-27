class Solution {
    int majorityElement(int arr[]) {
        // code here
        // int n=arr.length;
        // for(int i=0;i<n;i++){
        //     int c=0;
        //     for(int j=0;j<n;j++){
        //         if(arr[i]==arr[j]){
        //             c++;
        //         }
        //     }
        //     if(c> n/2){
        //         return arr[i];
        //     }
        // }
        // return -1;
                int n=arr.length;
                int c=0;
                int candidate=0;
                for(int num:arr){
                    if(c==0){
                    candidate=num;
                }
                    if(candidate==num){
                        c++;
                    }
                    else{
                        c--;
                    }
                }
                int freq = 0;
                for(int i=0;i<n;i++){
                    if(arr[i]==candidate){
                        freq++;
                    }
                }
                if(freq>n/2){
                    return candidate;
                }
                return -1;
    }
}