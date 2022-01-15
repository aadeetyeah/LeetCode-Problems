class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> h1=new HashMap<>();
        Set<Integer> s1=new HashSet<>();
        for(int itr1=0;itr1<nums1.length;itr1++){
            h1.put(nums1[itr1],h1.getOrDefault(nums1[itr1],0)+1);
        }
        for(int itr1=0;itr1<nums2.length;itr1++){
            if(h1.containsKey(nums2[itr1])){
                s1.add(nums2[itr1]);
            }
        }
        int arr[]=new int[s1.size()];
        int itr1=0;
        for(Integer i : s1){
            arr[itr1]=(int)i;
            itr1++;
        }
        return arr;
    }
}