class Solution {
    public int findKthPositive(int[] arr, int k) {
        
        
        int num=1;
        int itr1=0;
        ArrayList<Integer> list=new ArrayList<>();
        while(true){
            if(list.size()>k){
                break;
            }
            if(itr1<arr.length){
                if(arr[itr1]!=num ){
                    list.add(num);
                    num++;
                    continue;
                }else{
                    num++;
                    itr1++;
                }
            }else{
                list.add(num);
                num++;
            }
            
        }
        return list.get(k-1);
    }
}