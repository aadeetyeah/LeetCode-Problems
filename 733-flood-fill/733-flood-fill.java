class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image[sr][sc]==newColor){
            return image;
        }
        fillNewColor(sr,sc,image[sr][sc],newColor,image);
        return image;
    }
    
    private void fillNewColor(int sr,int sc,int currColor,int newColor,int[][] image){
        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length || image[sr][sc]!=currColor ){
            return;
        }
        image[sr][sc]=newColor;
        fillNewColor(sr+1,sc,currColor,newColor,image);
        fillNewColor(sr-1,sc,currColor,newColor,image);
        fillNewColor(sr,sc+1,currColor,newColor,image);
        fillNewColor(sr,sc-1,currColor,newColor,image);
        return;
        
    }
}