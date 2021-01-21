import java.util.HashSet;

public class Dijkstra {

	// display the adjacent matrix: Matrix.
	public void displayMatrix(Integer[][] Matrix) {
		for (int i = 0; i < Matrix.length; i++) {
			for (int j = 0; j < Matrix[i].length; j++) {
				if (Matrix[i][j] == Integer.MAX_VALUE) {
					System.out.print(" Inf");
				} else {
					System.out.print(" " + Matrix[i][j]);
				}
			}
			System.out.println();
		}
	}

	// your code here.
	public void findShortestPath(Integer[][] adjMatrix, Integer[][] weightMatrix, int source) {
		// constants
		final int INFINITY = Integer.MAX_VALUE, NOT_DEFINED = -1;

		// to hold shortest destination and previous vertex
		int[] dist = new int[adjMatrix.length];
		int[] prev = new int[adjMatrix.length];
		boolean[] S = new boolean[adjMatrix.length];

		HashSet<Integer> V = new HashSet<>();

		// Initialize dist to infinity and prev to not defined
		for (int i = 0; i < dist.length; i++) {
			dist[i] = INFINITY;
			prev[i] = NOT_DEFINED;
			V.add(i);
		}

		dist[source] = 0;
		
		printHeader();
		print(S, dist, prev);
		
		V.remove(source);
		
		

		// while there are nodes to process
		while (!V.isEmpty()) {
			// remove vertex
			int u = extractMin(S, dist);

			S[u] = true;
			V.remove(u);
			

			for (int v = 0; v < adjMatrix.length; v++) {

				// if there is edge
				if (adjMatrix[u][v] == 1) {

					if (!S[v] && dist[v] > dist[u] + weightMatrix[u][v]) {
						dist[v] = dist[u] + weightMatrix[u][v];
						prev[v] = u;
					}

				}

			}
			
			print(S, dist, prev);
			

			if(V.size()== adjMatrix.length /2) {
				System.out.println("Program written by Daniel Oduro/213442835, Half Way to Go!");
			}
		}

	}
	
	
	public void printHeader() {
		System.out.println("S | d | pred |");
		System.out.println("-------------------------------------------------------------------");
	}
	
	public void print(boolean[] S, int[] dist, int[] pred) {
		for (int i = 0; i < S.length; i++) {
			System.out.print(S[i] ? i : " ");
			System.out.print(" ");
		}
		
		System.out.print(" | ");
		
		for (int i = 0; i < dist.length; i++) {
			if(!S[i]) {
				System.out.printf("d[%d]=%s ", i, dist[i] == Integer.MAX_VALUE ? "Inf" : dist[i]);
			}
			
		}
		
		System.out.print(" | ");
		
		for (int i = 1; i < dist.length; i++) {
			if(!S[i]) {
				System.out.print(pred[i] == -1 ? "- " : String.format("p[%d]=%d ", i, pred[i]));
			}
		}
		
		System.out.println(" |");
	}
	

	private int extractMin(boolean[] S, int[] dist) {
		int min = -1;
		for (int i = 0; i < dist.length; i++) {
			if (!S[i]) {
				if (min == -1 || dist[i] < dist[min])
					min = i;
			}
		}
		return min;

	}

}