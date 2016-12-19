import java.util.*;
import java.util.Scanner;
import java.lang.Math;
public class DijkstraList {
    public static void main(String[] args) {
        //initialize different size of graph with values=100,1000
        //2000,3000,4000,5000 and 6000
        int s=1000;
        //create time stamp
        long startTime=System.currentTimeMillis();
        //create adjacency list
        AdjacencyMatrix matrix=new AdjacencyMatrix(s);
        long endTime=System.currentTimeMillis();
        long time1=endTime-startTime;
        System.out.println("Time to create adjacency matrix is: "+time1/1000.00+" seconds;");
        matrix.printMatrixFloyd();
        generatePaths(matrix.f);
        long endTime2=System.currentTimeMillis();
        long time2=endTime2-startTime;
        System.out.println("Time to generate input and compute shortest path:"+time2/1000.00+" seconds");
        
        System.out.println("Total time: "+(time1+time2)/1000.00+" seconds");
    }
    
    public static void generatePaths(Node[] fList) {
        for(int i=0;i<fList.length;i++)
            dijkstra(fList,i);
    }
    public static void dijkstra(Node[] fList, int start) {
        int n=fList.length;
        String[] paths=new String[n];
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++)
            paths[i]=new String(start+"->"+i);
        visited[start]=true;
        for(int c=1;c<=n;c++) {
            int k=-1;
            int min=Integer.MAX_VALUE;
            Node index=fList[start];
            while(index!=null) {
            {
                if(!visited[index.getVertex()] && index.getWeight()<min) {
                    min=index.getWeight();
                    k=index.getVertex();
                }
                else break;
            }
                    visited[k]=true;
                    Node id=fList[k].getNext();
                    while(id!=null) {
                        Node id1=fList[start].getNext();
                        while(id!=null) {
                            if(id1.getVertex()==id.getVertex() && id1.getWeight()>(min+id.getWeight())) {
                                id1.setWeight(min+id.getWeight());
                                paths[id1.getVertex()]=paths[k]+"->"+id1.getVertex();
                            }
                            id1=id1.getNext();
                        }
                        id=id.getNext();
                    }
                }
    }
    }
}