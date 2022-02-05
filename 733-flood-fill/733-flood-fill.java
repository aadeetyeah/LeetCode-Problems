class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image[sr][sc]==newColor){
            return image;
        }
        Queue<Pair<Integer,Integer>> q1=new LinkedList<>();
        q1.add(new Pair<>(sr,sc));
        
        int srcColor=image[sr][sc];
        
        while(!q1.isEmpty()){
            Pair<Integer,Integer> p1=q1.remove();
            int dup_sr=p1.getKey();
            int dup_sc=p1.getValue();
            if(dup_sr<0 || dup_sc<0 || dup_sr>=image.length || dup_sc>=image[0].length || image[dup_sr][dup_sc]!=srcColor){
                continue;
            }
            image[dup_sr][dup_sc]=newColor;
            q1.add(new Pair<>(dup_sr-1,dup_sc));
            q1.add(new Pair<>(dup_sr+1,dup_sc));
            q1.add(new Pair<>(dup_sr,dup_sc-1));
            q1.add(new Pair<>(dup_sr,dup_sc+1));
        }
        return image;
    }
}