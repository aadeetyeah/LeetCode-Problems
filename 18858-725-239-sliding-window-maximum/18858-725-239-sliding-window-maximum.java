class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> q = new ArrayDeque<>();
        int result[] = new int[nums.length-k +1];
        int i = 0;

        for(int itr1 = 0;itr1 < nums.length; itr1++){

            if(!q.isEmpty() && q.peek() < itr1-k+1){
                q.poll();
            }

            while(!q.isEmpty() && nums[q.peekLast()] < nums[itr1]){
                q.pollLast();
            }

            q.offer(itr1);
            if(itr1>=k-1){
                result[i++] = nums[q.peek()]; 
            }
        }
        return result;
    }
}