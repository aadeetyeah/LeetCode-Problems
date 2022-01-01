class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1=new HashSet<>();
        Set<Integer> result=new HashSet<>();
        for(int itr1=0;itr1<nums1.length;itr1++){
            s1.add(nums1[itr1]);
        }
        for(int itr1=0;itr1<nums2.length;itr1++){
            if(s1.contains(nums2[itr1])){
                result.add(nums2[itr1]);
            }
        }
        int itr1=0;
        int arr[]= new int[result.size()];
            for(Integer i1 : result){
                arr[itr1]=(int)i1;
                itr1++;
            }
        return arr;
    }
}