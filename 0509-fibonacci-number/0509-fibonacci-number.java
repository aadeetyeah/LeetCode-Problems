class Solution {
    public int fib(int n) {
        return fib(n,new HashMap<Integer,Integer>());
    }
    
    private int fib(int num, Map<Integer,Integer> cache){
        if(num==0 || num==1){
            return num;
        }
        if(cache.containsKey(num)){
            return cache.get(num);
        }
        int result= fib(num-1,cache)+fib(num-2,cache);
        cache.put(num,result);
        return result;
    }
}