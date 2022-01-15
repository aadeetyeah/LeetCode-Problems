class Solution {
    public boolean canArrange(int[] arr, int k) {
            HashMap<Integer,Integer> h1=new HashMap<>();
        int temp=0;
        for(int itr1=0;itr1<arr.length;itr1++){
            temp=((arr[itr1]%k)+k)%k;
            h1.put(temp,h1.getOrDefault(temp,0)+1);
        }
        int key;
        int val;
        int rem;
        for(Map.Entry<Integer,Integer> e1 : h1.entrySet()){
            key=e1.getKey();
            val=e1.getValue();
            rem=(k-key)%k;
            if(key==0 && h1.get(0)%2==1){
                return false;
            }else if(h1.get(rem)==null || h1.get(rem)!=val){
                return false;
            }
        }
        return true;
    
    }
}