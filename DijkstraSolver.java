
public class DijkstraSolver {

	public static void main(String[] args) {
		graph0();
		System.out.println("*****************************************************************");
		graph1();
	}

	
	public static void graph0() {
		Integer[][] //adjMatrix 
				
				
			    adjMatrix = {
							  // S, A, B, C, D, E 
			    				{0, 1, 1, 0, 0, 0}, // S
					    		{0, 0, 0, 1, 0, 0}, //A
					    		{0, 0, 0, 1, 1, 0}, //B
					    		{0, 1, 0, 0, 0, 1}, //C 		
					    		{0, 0, 0, 0, 0, 4}, //D
					    		{0, 0, 0, 0, 0, 0}, //E
					    	 		
					         };
				final int  INF= Integer.MAX_VALUE;
				Integer[][] //adjMatrix 
						
						
					   weightMatrix = {
									  // S,    A,   B,   C,   D,   E
							   			{INF,  3,  5,   INF, INF, INF}, // S
							    		{INF, INF, INF, 7,   INF, INF}, //A
							    		{INF, INF, INF, 4,    1, INF}, //B
							    		{INF, 1, INF, INF, INF, 0}, //C 		
							    		{INF, INF, INF, INF, INF, 1}, //D
							    		{INF, INF, INF, INF, INF, INF}, //E
							    	 		
							         };

				Dijkstra djk = new Dijkstra();
				System.out.println("The input graph G in adjacent Matrix is:\n");
				djk.displayMatrix(adjMatrix);
				System.out.println("\nThe weights for edges in G in adjacent Matrix is:\n");
				djk.displayMatrix(weightMatrix);
				System.out.println();
				
				// inputs: the graph, its weights, and the index for the source vertex
				djk.findShortestPath(adjMatrix, weightMatrix, 0);
	}
	
	
	
	
	
	public static void graph1() {
		Integer[][] //adjMatrix 
				
				
			    adjMatrix = {
							  // A, B, C, D, E 
					    		{0, 1, 1, 1, 0}, //A
					    		{0, 0, 0, 1, 0}, //B
					    		{0, 1, 0, 0, 1}, //C 		
					    		{0, 0, 0, 0, 1}, //D
					    		{0, 0, 0, 0, 0}, //E
					    	 		
					         };
				final int  INF= Integer.MAX_VALUE;
				Integer[][] //adjMatrix 
						
						
					   weightMatrix = {
									  // A, B, C, D, E 
							    		{INF, 10, 3, 20, INF}, //A
							    		{INF, INF, INF, 5, INF}, //B
							    		{INF, 2, INF, INF, 15}, //C 		
							    		{INF, INF, INF, INF, 11}, //D
							    		{INF, INF, INF, INF, INF}, //E
							    	 		
							         };

				Dijkstra djk = new Dijkstra();
				System.out.println("The input graph G in adjacent Matrix is:\n");
				djk.displayMatrix(adjMatrix);
				System.out.println("\nThe weights for edges in G in adjacent Matrix is:\n");
				djk.displayMatrix(weightMatrix);
				System.out.println();
				
				// inputs: the graph, its weights, and the index for the source vertex
				djk.findShortestPath(adjMatrix, weightMatrix, 0);
	}
	
	

}