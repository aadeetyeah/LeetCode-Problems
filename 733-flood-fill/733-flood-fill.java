class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]==newColor){
            return image;
        }
        floodFillAlgo(image,sr,sc,newColor,image[sr][sc]);
        return image;
    }
    
    private void floodFillAlgo(int[][] image,int sr,int sc,int newColor,int srcColor){
        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length || image[sr][sc]!=srcColor){
            return;
        }
        image[sr][sc]=newColor;
        floodFillAlgo(image,sr-1,sc,newColor,srcColor);
        floodFillAlgo(image,sr+1,sc,newColor,srcColor);
        floodFillAlgo(image,sr,sc-1,newColor,srcColor);
        floodFillAlgo(image,sr,sc+1,newColor,srcColor);
        return;
    }
}