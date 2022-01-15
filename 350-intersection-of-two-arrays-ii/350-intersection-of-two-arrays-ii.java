class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
       HashMap<Integer,Integer> h1=new HashMap<>();
        ArrayList<Integer> arr=new ArrayList<>();
        for(int itr1=0;itr1<nums1.length;itr1++){
            h1.put(nums1[itr1],h1.getOrDefault(nums1[itr1],0)+1);
        }
        
        for(int itr1=0;itr1<nums2.length;itr1++){
            if(h1.containsKey(nums2[itr1])){
                h1.put(nums2[itr1],h1.get(nums2[itr1])-1);
                arr.add(nums2[itr1]);
                if(h1.get(nums2[itr1])==0){
                    h1.remove(nums2[itr1]);
                }
            }
        }
        int arr1[]=new int[arr.size()];
        for(int itr1=0;itr1<arr.size();itr1++){
            arr1[itr1]=(int)arr.get(itr1);
        }
        return arr1;
    }
}