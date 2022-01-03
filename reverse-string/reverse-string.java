class Solution {
    public void reverseString(char[] s) {
         reverse_str(s,0,s.length-1);   
    }
    public void reverse_str(char[] s,int front,int rear){
        if(front>rear){
            return;
        }
        char temp=s[front];
        s[front]=s[rear];
        s[rear]=temp;
        reverse_str(s,front+1,rear-1);
    }
}