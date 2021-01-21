
public class Solver {
	public static void main(String[] args) {
		final int SIZE = 1000000; // 1 million
		final int Instances = 20;
		int[][] TwoDimArray = new int[Instances][SIZE];

		Sort s = new Sort();

		for (int i = 0; i < Instances; i++) {
			s.initializeArray(TwoDimArray[i], SIZE);
			s.randomizeArray(TwoDimArray[i], SIZE);
		}

		final long startTime = System.nanoTime();
		for (int i = 0; i < Instances; i++) {
			//s.insertionSort(TwoDimArray[i], SIZE);
			//s.heapSort(TwoDimArray[i], SIZE);
			s.randomizedQuicksort(TwoDimArray[i], SIZE);
			//s.quicksort(TwoDimArray[i], SIZE);
		}

		final long duration = (System.nanoTime() - startTime) / 1000000;
		System.out.println("Duration in seconds:" + (duration / 1000.0));

	}
}