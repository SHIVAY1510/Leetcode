class Solution {
    public void quickSort(int[] arr, int low, int high) {
        // code here
        if(low<high){
            int p1=partition(arr,low,high);
            quickSort(arr,low,p1-1);
            quickSort(arr,p1+1,high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        // code here
        int p=arr[high];
        int i=low-1;
        for(int j=low;j<high;j++){
            if(arr[j]<p){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp=arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=temp;
        return i+1;
    }
}