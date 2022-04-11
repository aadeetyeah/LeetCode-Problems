class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]==newColor){
            return image;
        }
        fillNewColor(sr,sc,image[sr][sc],newColor,image);
        return image;
    }
    
    private void fillNewColor(int sr,int sc,int currentColor,int newColor,int[][] image){
        
        if(sr<0 || sr>=image.length || sc<0 || sc>=image[0].length || image[sr][sc]!=currentColor){
            return;
        }
        image[sr][sc]=newColor;
        
        fillNewColor(sr+1,sc,currentColor,newColor,image);
        fillNewColor(sr-1,sc,currentColor,newColor,image);
        fillNewColor(sr,sc+1,currentColor,newColor,image);
        fillNewColor(sr,sc-1,currentColor,newColor,image);
        return;
    }
}