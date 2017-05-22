public class ArraySortSnippet {

	public static void quicksort(int[] ints, int begin, int end) {
		int i = begin;
		int j = end;
		int pivot = ints[(i + j) / 2];
		do {
			while (ints[i] < pivot) {
				i++;
			}
			while (ints[j] > pivot) {
				j--;
			}
			if (i <= j) {
				int aux = ints[i];
				ints[i] = ints[j];
				ints[j] = aux;
				i++;
				j--;
			}
		} while (i <= j);
		if (begin < j) {
			quicksort(ints, begin, j);
		}
		if (i < end) {
			quicksort(ints, i, end);
		}
	}

	public static void printArray(int[] ints) {
		for (int i = 0; i < ints.length; i++) {
			System.out.print(ints[i] + " ");
		}
	}

	public static void main(String args[]) {
		int[] ints = new int[] { 8, 1, 6, 3, 2, 11, 24, 32, 102, 1024 };
		System.out.print("Array before:");
		printArray(ints);
		System.out.println("");
		System.out.print("Array after:");
		quicksort(ints, 0, ints.length - 1);
		printArray(ints);
	}
}
