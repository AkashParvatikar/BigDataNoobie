import java.util.Scanner;
import java.lang.Integer;
public class DijkstraOneDimensional {
    //generate random graph
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
                    //get sparse graph
                    m[i][j]=Integer.MAX_VALUE;
        for(int i=0;i<nodeSize;i++)
            for(int j=0;j<nodeSize;j++)
                if(i==j+1)
                    m[i][j]=m[j][i];
        //displays the graph
        for(int i=0;i<nodeSize;i++) {
            for(int j=0;j<nodeSize;j++)
                System.out.print(m[i][j]+"\t");
            System.out.println();
        } 
        return m;            
}
    public static void main(String[] args) {
        //initializing the graph size with different executions 
        //having values=100,1000,2000,3000,4000,5000 and 6000
        int s=6000;
        int[][] m=new int[s][s];
        //calculate time stamp
        long startTime=System.currentTimeMillis();
        m=getgraph(s,m);
        
        int start=1;
        //copying the lower triangular matrix
        int[] oneD=new int[s*s];
        for(int i=0;i<s;i++)
            for(int j=0;j<s;j++) {
                int l=(i*(i-1)/2);
                oneD[l]=m[i][j];
            }
        
        long endTime=System.currentTimeMillis();
        long time1=endTime-startTime;
        System.out.println("Time to create adjacency matrix: "+time1/1000.00+" seconds");
        
        String[] path=new String[s];
        boolean[] prev=new boolean[s];
        //Dijkstra's algorithm to find shortest path from start vertex
        for(int i=0;i<s;i++)
            path[i]=new String(start+"->"+i);
        prev[start]=true;
        
        for(int j=1;j<s-1;j++) {
            int k=-1;
            int min=Integer.MAX_VALUE;
            for(int i=0;i<s;i++) {
                if (!prev[i] && oneD[i*(i-1)/2+start]<min) {
                min=oneD[i*(i-1)/2+start];
                k=i;
            }
        }
            prev[k]=true;
            for(int i=0;i<s;i++) {
                if(!prev[i] && oneD[k*(k-1)/2+start]+oneD[k*(k-1)/2+k]<oneD[k*(k-1)/2+start]) {
                    oneD[i*(i-1)/2+start]=oneD[k*(k-1)/2+start] + oneD[i*(i-1)/2+k];
                    path[i]=path[i]+"->"+"i";
                }
            }
        }  
        long endTime2=System.currentTimeMillis();
        long time2=endTime2-startTime;        
        System.out.println("Time to generate input and compute shortest path: "+time2/1000.00+" seconds");
        System.out.println("The total time taken is: "+(time1+time2)/1000.00+" seconds"); 
    }
}