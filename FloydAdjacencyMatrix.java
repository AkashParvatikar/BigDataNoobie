import java.util.Scanner;
import java.lang.Math;
public class FloydAdjacencyMatrix {
	// method to find the shortest path
    public static int[][] shortestroute(int[][] adj,int[][] route) {
        int n=adj.length;
        int[][] matrix=new int[n][n];
        
		//compute the shortest path by comparing the new path with the exisiting path
        for(int k=0;k<n;k++) {
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if(matrix[i][k]+matrix[k][j] < matrix[i][j]) {
                        matrix[i][j]=matrix[i][k]+matrix[k][j];
                        route[i][j]=route[k][j];
                    }
                }
            }            
        }
        return matrix;
    }         
    // method to generate random graph
    static int[][] getmatrix(int nodeSize,int[][] m) {
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
                // get sparse graph
                else
                    m[i][j]=Integer.MAX_VALUE;
				for(int i=0;i<nodeSize;i++)
					for(int j=0;j<nodeSize;j++)
						if(i==j+1)
							m[i][j]=m[j][i];
				/* display graph
				for(int i=0;i<nodeSize;i++)
					for(int j=0;j<nodeSize;j++) {
						System.out.print(m[i][j]+"\t");
					System.out.println();	
					} */
        return m;
    }
    
    public static void main(String[] args) {
        Scanner stdin=new Scanner(System.in);
        //initialize the graph size for values 100,1000,2000,3000,4000,5000 and 6000
        int s=1000;   
        int[][] m=new int[s][s];
        //for calculating the time stamp
        long startTime=System.currentTimeMillis();
        m=getmatrix(s,m);
        long endTime=System.currentTimeMillis();
        long time1=endTime-startTime;
        System.out.println("Time to create adjacency Matrix: "+time1/1000.00 +" seconds");
        
        long startTime2=System.currentTimeMillis();
        int[][] shortroute;
        int[][] route=new int[s][s];
        //checking for the disconnected nodes and self-loops
        for(int i=0;i<s;i++)
            for(int j=0;j<s;j++) {
                if(m[i][j]==5000)
                    route[i][j]=-1;
                else
                    route[i][j]=i;
            }
        for(int i=0;i<s;i++)
            route[i][i]=i;
        shortroute=shortestroute(m,route);
        
        long endTime2=System.currentTimeMillis();
        long time2=endTime2-startTime2;
        System.out.println("Time to generate input and compute shortest path: "+time2/1000.00+" seconds");
        //computing total time to create adjacency matrix, generate input and compute shortest path
		long totalTime=time1+time2;
        System.out.println("The total time taken is "+totalTime/1000.00+" seconds");
		
		//printing the output and shortest path
		/*for(int i=0;i<s;i++) {
			for(int j=0;j<s;j++)
				System.out.print(shortroute[i][j]+" ");
			System.out.println();
		}
		System.out.println("Enter start and end vertex: ");
		int start=stdin.nextInt();
		int end=stdin.nextInt();
		String myPath=end+ " ";
		int sum=0;
		int flag=0;
		while(path[start][end]!=start) {
			flag=1;
			myPath=path[start][end]+"->"+myPath;
			sum+=shortroute[start][end];
			end=path[start][end];
		}
		
		if(flag==0)
			sum=shortroute[start][end];
		myPath=start+"->"+myPath;
		System.out.println("Shortest Path"+myPath);
		System.out.println("Distance: "+sum); */
		
    }
}
