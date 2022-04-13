class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image[sr][sc]==newColor){
            return image;
        }
        iterativeFloodFill(image,sr,sc,newColor);
        return image;
    }
    private void iterativeFloodFill(int[][] image,int sr,int sc,int newColor){
        int currentColor=image[sr][sc];
        
        int rows=image.length;
        int cols=image[0].length;
        Queue<Pair<Integer,Integer>> q1=new LinkedList<>();
        Pair<Integer,Integer> p1=new Pair<>(sr,sc);
        q1.add(p1);
        while(!q1.isEmpty()){
            Pair<Integer,Integer> tempP=q1.remove();
            int srTemp=tempP.getKey();
            int scTemp=tempP.getValue();
            
            if(srTemp>=rows || srTemp<0 || scTemp<0 || scTemp>=cols || image[srTemp][scTemp]!=currentColor){
                continue;
            }
            
            image[srTemp][scTemp]=newColor;
            q1.add(new Pair<Integer,Integer>(srTemp+1,scTemp));
            q1.add(new Pair<Integer,Integer>(srTemp-1,scTemp));
            q1.add(new Pair<Integer,Integer>(srTemp,scTemp-1));
            q1.add(new Pair<Integer,Integer>(srTemp,scTemp+1));
            
        }
        return;
    }
}