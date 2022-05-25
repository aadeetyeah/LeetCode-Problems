// { Driver Code Starts
import java.util.*;
class Disjoint{
	public static void main(String[] args){
		Scanner sc=new Scanner (System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] a=new int[n+1];
			for(int i=1;i<=n;i++)
				a[i]=i;
			int k=sc.nextInt();
			GfG g=new GfG();
			for(int i=0;i<k;i++){
				String s=sc.next();
				if(s.equals("UNION")){
					int x=sc.nextInt();
					int z=sc.nextInt();
					g.unionSet(a,x,z);
				}
				else{
					int x=sc.nextInt();
					int parent=g.find(a,x);
					System.out.print(parent+" ");
				}
			}
			System.out.println();
		}
	}
}// } Driver Code Ends


/*Complete the function below*/
class GfG
{
	int find(int A[],int X)
        {
          //add code here.
          if(A[X]==X){
              return X;
          }
          A[X]=find(A,A[X]);
          return A[X];
	}
	void unionSet(int A[],int X,int Z)
        {
         //add code here.
         
         
         int p1=find(A,X);
         int p2=find(A,Z);
         
         if(p1==p2){
             return;
         }
         A[p1]=p2;
         
         return;
	}
}
