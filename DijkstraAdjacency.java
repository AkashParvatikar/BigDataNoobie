import java.lang.Integer;
import java.util.Scanner;
public class DjikstraAdjacency {
    //generating random graph
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
                //generating sparse graph
                else 
                    m[i][j]=Integer.MAX_VALUE;
        for(int i=0;i<nodeSize;i++)
            for(int j=0;j<nodeSize;j++)
                if(i==j+1)
                    m[i][j]=m[j][i];
        //Section to print the graph
		 for(int i=0;i<nodeSize;i++) {
			 for(int j=0;j<nodeSize;j++)
				 System.out.print(m[i][j]+"\t");
			 System.out.println(); } 
        return m;
    }
    public static void main(String[] args) {
        int max=Integer.MAX_VALUE;
        //initialize the graph size with values=100,1000,2000,3000,4000,5000 and 6000
        int s=1000;
        int[][] m=new int[s][s];
        //calculate time stamp
        long startTime=System.currentTimeMillis();
        m=getgraph(s,m);
        long endTime=System.currentTimeMillis();
        long time1=endTime-startTime;
        System.out.println("Time to create adjacency matrix: "+time1/1000.00+" seconds");
        int d=m.length;
        int i;
        int reference_node=1;
        int vnear=0;
        int e;
        int F=0;
        int touch[]=new int[d+1];
        int length[]=new int[d+1];
        //initialize v0 to be the last vertex on current shortest path
        //from v0 for all vertices
        for(i=1;i<d;i++) {
            touch[i]=0;
            reference_node=touch[i];
            length[i]=m[0][i];
        }
        //add all n-1 vertices to Y and repeat n-1 times
        for(int j=1;j<d;j++) {
            int min=Integer.MAX_VALUE;
            for(i=1;i<d;i++) {
                if((0<=(length[i])) && (length[i]<min)) {
                    min=length[i];
                    vnear=i;
                }
            }
            /* System.out.println("shortest distance between node"+(refernce_node)
            +"and node"+vnear+" is"+min); */
            e=m[vnear][touch[vnear]];
            F=F+e;
            for(int k=1;k<d;k++) {
                if((length[vnear]+m[vnear][k])<length[k]) {
                    length[k]=length[vnear]+m[vnear][k];
                    touch[k]=vnear;
                }
            }
            length[vnear]=-1;
        }
        long endTime2=System.currentTimeMillis();
        long time2=endTime2-startTime;
        System.out.println("Time to generate input and compute shortest path: "+time2/1000.00+" seconds");        
        System.out.println("Total Time taken is: "+((time1+time2)/1000.00)+" seconds");
    }
}