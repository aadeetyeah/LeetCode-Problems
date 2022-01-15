class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer,Integer> map =new HashMap<>();
        int num=0;
        for(int itr1=0;itr1<arr.length;itr1++){
            num=((arr[itr1]%k)+k)%k;            //for handling negative values.
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        int rem=0;
        for(Integer i : map.keySet()){
             rem=(k-i)%k;
            if(i==0 && map.get(i)%2==1){
                System.out.println(1+" "+map.get(i));
                return false;
            }else if(map.get(rem)==null || !map.get(i).equals(map.get(rem))){
                System.out.println(map.get(rem)+"----"+map.get(i));
                return false;
            }
            
        }
        return true;
    }
}