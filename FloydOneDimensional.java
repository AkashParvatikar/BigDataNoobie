import java.util.Scanner;
import java.lang.Math;
public class FloydOneDimensional {
    // generating random graph
    static int[][] getgraph(int nodeSize, int[][] m) {
        for(int i=0;i<nodeSize;i++)
            for(int j=0;j<nodeSize;j++)
                if(i==j)
                    m[i][j]=0;
                else if(i>j) {
                    int element=(int)(Math.random()*10);
                    if(element>0)
                        m[i][j]=element;
                    else
                        m[i][j]=element+1;
                    m[j][i]=m[i][j];
                }
                else
                    //creating sparse graph
                    m[i][j]=Integer.MAX_VALUE;
             for(int i=0;i<nodeSize;i++)
                for(int j=0;j<nodeSize;j++)
                    if(i==j+1)
                        m[i][j]=m[j][i];
             
			 // displays the graph
			 /*for(int i=0;i<nodeSize;i++)
                 for(int j=0;j<nodeSize;j++)
                     System.out.print(m[i][j]+"\t");
                 System.out.println(); */				 
         return m; 
    }
    public static void main(String[] args) {
        
        //initializing the graph size with different executions 
        //having values=100,1000,2000,3000,4000,5000 and 6000
        int s=1000;
        int d=s;
        int[][] m=new int[s][s];
        //calculating the time stamp
        long startTime=System.currentTimeMillis();
        m=getgraph(s,m);
        
        //creating the output array
        int[] oneD=new int[s*s];
        int[] next=new int[s*s];
        //copy the lower triangular matrix to one dimensional array
        for(int i=0;i<s;i++)
            for(int j=0;j<s;j++) {
                int l=(i*(i-1)/2);
                oneD[l]=m[i][j];
            }
        System.out.println();
        long endTime=System.currentTimeMillis();
        long time1=endTime-startTime;
        System.out.println("Time to create adjacency matrix is :"+time1/1000.000+" seconds");
        for(int i=0;i<d;i++) {
            for(int j=0;j<d;j++){                 
                next[(i*(i-1)/2)+j]=j;
            }
        }
        //computing Floyd's algorithm
        for(int k=0;k<d;k++) {
            for(int i=0;i<d;i++) {
                for(int j=0;j<d;j++) {
                    if(oneD[i*(i-1)/2+j]> oneD[i*(i-1)/2+k]+oneD[k*(k-1)/2+j]) {
                        oneD[i*(i-1)/2+j]=oneD[i*(i-1)/2+k]+oneD[k*(k-1)/2+j];
                        next[i*(i-1)/2+j]=next[i*(i-1)/2+k];
                    }
                }
            }
        }
        long endTime2=System.currentTimeMillis();
        long time2=endTime2-startTime;
        System.out.println("Time to generate input and shortest path is: "+time2/1000.000+" seconds");
        System.out.println("Total time: "+((time1+time2)/1000.000)+" seconds");				
    }
}