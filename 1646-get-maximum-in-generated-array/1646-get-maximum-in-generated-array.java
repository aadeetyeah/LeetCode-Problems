class Solution {
    public int getMaximumGenerated(int n) {
        int arr[]=new int[n+1];
        
        arr[0]=0;
        if(n==0){
            return arr[n];    
        }
        
        arr[1]=1;
        if(n==1){
            return arr[n];
        }
        
        int size=arr.length/2;
        
        for(int itr1=1;itr1<=size;itr1++){
            int index1=2*itr1;
            int index2=(2*itr1)+1;
            
            if(index1>=arr.length){
                break;
            }
            arr[index1]=arr[itr1];
            
            if(index2>=arr.length){
                break;
            }
            arr[index2]=arr[itr1]+arr[itr1+1];
        }
        
        Arrays.sort(arr);
        return arr[n];
    }
}