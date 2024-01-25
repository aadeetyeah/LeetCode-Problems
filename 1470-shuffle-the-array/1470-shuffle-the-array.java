class Solution {
    public int[] shuffle(int[] nums, int n) {
        
        int itr1 = 0;
        int itr2 = n;
        int arr[]= new int[2*n];
        
        for(int itr3 = 0;itr3<2*n;itr3++){
            if(itr3%2==0){
                arr[itr3] = nums[itr1];
                itr1++;
            }else{
                arr[itr3] = nums[itr2];
                itr2++;
            }            
        }
        return arr;
    }
}