public class Isomorphic {

	public int[] permutation;

	public Isomorphic(int q){
		permutation = new int[q];
		for(int p=0; p < permutation.length; p++){

			permutation[p] = -1;
		}
	}

	
	boolean edgeCheck(int l, int[][] graph1, int[][] graph2) {  
		boolean equal = true;
		for(int x = 0; x < l; x++) {
			int y = 0;
			while (y < l && equal == true) {
				if  (graph1[x][y] != graph2[permutation[x]][permutation[y]]) {
					equal = false;
				}
				y++;
			}
		}
		return equal;
	}
	
	boolean DepthFirstSearch(int l, int lev, int[][] graph1, int[][] graph2, boolean[] got) {  
		boolean check = false;
		if (lev == -1) {
			check = edgeCheck(l, graph1, graph2);
		} else {
			int i = 0;
			while (i < l && check == false) {
				if (got[i] == false) {
					got[i] = true;
					permutation[lev] = i;
					check = DepthFirstSearch(l, lev - 1, graph1, graph2, got);
					got[i] = false;
				}
				i++;
			}
		}
		return check;
	}


	void isomorphism(int[][] graph1, int[][] graph2) {
		int l = graph1.length;
		boolean[] got = new boolean[l];
		for(int j=0; j <l; j++){
			got[j] = false;
		}
		boolean isomorphic = DepthFirstSearch(l, l - 1, graph1, graph2, got);
		if (isomorphic == true) {
			System.out.println("Graphs are isomorphic");
			System.out.println("The orderings of graph1 vertices: ");
			for (int i = 0; i < l; i++) {
				System.out.print((i+1)+"  ");
			}
			System.out.println();
			System.out.println("The orderings of graph2 vertices: ");

			for (int i = 0; i < l; i++) {
				System.out.print((permutation[i]+1)+"  ");
			}
		} else {
			System.out.println("Graphs are NOT isomorphic");
		}
	}
	public static void main(String[] args) {

		//case1
	/*	int[][] graph1 = {{0, 1, 0, 0, 1, 1, 0},
			{1, 0, 1, 0, 0, 0, 1},
			{0, 1, 0, 1, 0, 0, 0},
			{0, 0, 1, 0, 0, 1, 1},
			{1, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 1, 0, 0, 1},
			{0, 1, 0, 1, 1, 1, 0}};

			int[][] graph2 = {{0, 1, 0, 1, 1, 0, 0},
					{1, 0, 0, 0, 0, 1, 1},
					{0, 0, 0, 1, 1, 1, 0},
					{1, 0, 1, 0, 0, 0, 0},
					{1, 0, 1, 0, 0, 1, 1},
					{0, 1, 1, 0, 1, 0, 0},
					{0, 1, 0, 0, 1, 0, 0}};

*/

			//case2
/*				int[][]  graph1 = {{0, 1, 1, 1, 1, 0},
				{1, 0, 0, 0, 1, 1},
				{1, 0, 0, 0, 1, 1},
				{1, 0, 0, 0, 0, 1},
				{1, 1, 1, 0, 0, 1},
				{0, 1, 1, 1, 1, 0}};

		int[][]  graph2 = {{0, 0, 0, 0, 0, 1},
				{0, 0, 0, 1, 1, 0},
				{0, 0, 0, 1, 1, 0},
				{0, 1, 1, 0, 1, 1},
				{0, 1, 1, 1, 0, 0},
				{1, 0, 0, 1, 0, 0}};
*/
			//case3
					int[][] graph1 = {{0, 0, 1, 1, 1, 1, 0},
				{0, 0, 0, 0, 1, 0, 0},
				{1, 0, 0, 0, 1, 1, 0},
				{1, 0, 0, 0, 1, 1, 0},
				{1, 1, 1, 1, 0, 0, 1},
				{1, 0, 1, 1, 0, 0, 1},
				{0, 0, 0, 0, 1, 1, 0}};

		int[][] graph2 = {{0, 0, 0, 0, 0, 0, 1},
				{0, 0, 1, 1, 0, 1, 1},
				{0, 1, 0, 0, 0, 1, 1},
				{0, 1, 0, 0, 0, 1, 1},
				{0, 0, 0, 0, 0, 1, 1},
				{0, 1, 1, 1, 1, 0, 0},
				{1, 1, 1, 1, 1, 0, 0}};

			System.out.println("Length of the graph is "+graph1.length);
			Isomorphic iso = new Isomorphic(graph1.length);
			iso.isomorphism(graph1, graph2);
	}
}
