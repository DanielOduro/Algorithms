import java.util.Random;

public class Sort {

	// swap the ith element with the jth elements.
	private void swap(int[] a, int i, int j) {
		int temp;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	// initialize the array a with elements from 0 to size-1.
	public void initializeArray(int[] a, int size) {
		for (int i = 0; i < size; i++) {
			a[i] = i;
		}
	}

	// display the elements in the array a, rowSize elements per row.
	public void displayArray(int[] a, int size) {
		int rowSize = 100;
		for (int i = 0; i < size; i++) {
			if (i % rowSize == 0) {
				System.out.println();
			}
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	// randomly swap two elements in a for SWAPTIMES times.
	public void randomizeArray(int[] a, int size) {
		final int SWAPTIMES = 10000;
		Random r = new Random();
		int j, k;
		for (int i = 0; i < SWAPTIMES; i++) {
			j = r.nextInt(size);
			k = r.nextInt(size);
			this.swap(a, j, k);
		}

	}

	// selectionSort
	public void selectionSort(int a[], int size) {
		int i, j, min, minIndex;
		for (j = 0; j < size - 1; j++) {// select jth element.
			minIndex = j;
			min = a[j];
			for (i = j + 1; i < size; i++) {
				if (a[i] < min) {
					minIndex = i;
					min = a[i];
				}
			}
			this.swap(a, j, minIndex);
		}
	}

	// insertion sort
	public void insertionSort(int a[], int size) {
		// 1: for j <- 2 to length[A]
		for (int i = 1; i < a.length; i++) {

			// 3: i <- j-1
			int j = i;

			// key <- A[j]
			int temp = a[j];

			// 4: while i>0 and A[i] > key
			while (j > 0 && a[j - 1] > temp) {
				// 5: A[i+1] <- A[i]
				a[j] = a[j - 1];

				// 6: i <- i-1
				j--;
			}

			// A[i+1] <- key
			a[j] = temp;
		}
	}

	public void heapSort(int a[], int size) {
		// 1: BuildMaxHeap(A)
		buildMaxHeap(a);

		// System.out.println("\nProgram written by Daniel Oduro/213442835, about to
		// sort the array!");

		// System.out.println("\nHEAP-SORT...");

		// 2: for i <- length[A] downto 2
		for (int i = a.length - 1; i >= 1; i--) {

			// System.out.print("\nheap-sort working on element with array index: " + i);
			// 3: do exchange A[1] <-> A[i]
			int temp = a[i];
			a[i] = a[0];
			a[0] = temp;
			size--;

			// 4: heapSize[A] <- heapSize[A] - 1
			maxHeapify(a, 0, size);

			// 5: MaxHeapify(A, 1)
			// displayArray(a, a.length);

		}
	}

	public void buildMaxHeap(int a[]) {
		// System.out.println("\nBUILDING A HEAP...");
		// 1: heapSize[A] <- length[A]
		int heapSize = a.length;

		// 2: for i <- floorOf(length[A]/2) downto 1
		for (int i = (a.length - 1) / 2; i >= 0; i--) {

			// 3: do MaxHeapify(A, i)
			maxHeapify(a, i, heapSize);

			// System.out.print("\nmax heapify on element with array index: " + i);
			// displayArray(a, heapSize);
		}
	}

	public void maxHeapify(int a[], int i, int HSize) {
		// 1: l <- LEFT(i)
		int l = 2 * i + 1;

		// 2: r <- RIGHT(i)
		int r = l + 1;

		int largest;
		// 3: if l <= heapSize[A] and A[l] > A[i]
		if (l < HSize && a[l] > a[i])
			largest = l; // 4: then largest <- l
		else
			largest = i; // 5: else largest <- i

		// 6: if r <= heapSize[A] and A[r] > A[largest]
		if (r < HSize && a[r] > a[largest])
			largest = r; // 7: then largest <- r

		// 8: if largest != i
		if (largest != i) {
			// 9: then exchange A[i] <-> A[largest]
			int temp = a[i];
			a[i] = a[largest];
			a[largest] = temp;

			// 10: MaxHeapify(A, largest)
			maxHeapify(a, largest, HSize);
		}

	}

	// Quicksort
	public void quicksort(int a[], int size) {
		// call reurcsive helper
		quicksort(a, 0, size - 1);
	}

	// quicksort recursive helper
	private void quicksort(int[] array, int low, int high) {
		if (low < high) {
			int p = partition(array, low, high); // create partition

			// call quicksort for left and right partition
			quicksort(array, low, p);
			quicksort(array, p + 1, high);
		}
	}

	// partition for the array with first element as pivot
	private int partition(int[] array, int low, int high) {

		// first element as pivot
		int pivot = array[low];

		// left and right pointers
		int i = low - 1;
		int j = high + 1;

		while (true) {

			// move right pointer to correct position
			do {
				j--;
			} while (array[j] > pivot);

			// move left pointer to correct position
			do {
				i++;
			} while (array[i] < pivot);

			// swap if they havent crossed each other
			if (i < j) {
				swap(array, i, j);
			}

			else // partition complete
				return j;
		}
	}

	// randomized quick sort
	public void randomizedQuicksort(int a[], int size) {
		Random random = new Random();
		randomizedQuicksort(a, 0, size - 1, random);
	}
	
	// randomized quicksort helper
	private void randomizedQuicksort(int[] array, int low, int high, Random random) {
		if (low < high) {
			int p = randomPartition(array, low, high, random); //create partition
			// call quicksort for left and right position
			randomizedQuicksort(array, low, p , random);
			randomizedQuicksort(array, p + 1, high, random);
		}
	}

	private int randomPartition(int[] array, int low, int high, Random random) {
		// generate a random index and swap first and random index pivot element
		int randIndex = low + random.nextInt(high - low + 1);
		swap(array, low, randIndex);
		// first element as pivot
		int pivot = array[low];
		// left and right pointers
		int i = low - 1;
		int j = high + 1;

		while (true) {
			// move right pointer to correct position
			do {j--;
			} while (array[j] > pivot);

			// move left pointer to correct position
			do {i++;
			} while (array[i] < pivot);

			// swap if they havent crossed each other
			if (i < j)
				swap(array, i, j);
			else // partition complete
				return j;
		}
	}

}