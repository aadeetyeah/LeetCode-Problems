class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        
        int arr[] = new int[words.length];
        List<Integer> indices = new ArrayList<>();
        int ind = 0;
        for(String str : words){
            for(int itr1 = 0;itr1<str.length();itr1++){
                if(str.charAt(itr1)==x){
                    indices.add(ind);
                    break;
                }
            }
            ind++;
        }
        return indices;
    }
}