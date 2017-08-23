import java.util.Comparator;

class Student {
	String name;
	int age;

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return name + ": " + age;
	}
}

class Test {

	// 9  2  3  4  5  6  7  8  1
	public static <T extends Comparable<T>> void bubbleSort(T[] array) {
		boolean swapped = true;
		for (int i = 1, len = array.length; swapped && i < len; ++i) {
			swapped = false;
			for (int j = 0; j < len - i; ++j) {
				if (array[j].compareTo(array[j + 1]) > 0) {
					T temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					swapped = true;
				}
			}
			if (swapped) {
				swapped = false;
				for (int j = len - i - 1; j > 0; --j) {
					if (array[j].compareTo(array[j - 1]) < 0) {
						T temp = array[j];
						array[j] = array[j - 1];
						array[j - 1] = temp;
						swapped = true;
					}
				}
			}
		}
	}

	public static <T> void bubbleSort(T[] array, Comparator<T> comp) {
		boolean swapped = true;
		for (int i = 1, len = array.length; swapped && i < len; ++i) {
			swapped = false;
			for (int j = 0; j < len - i; ++j) {
				if (comp.compare(array[j], array[j + 1]) > 0) {
					T temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					swapped = true;
				}
			}
			if (swapped) {
				swapped = false;
				for (int j = len - i - 1; j > 0; --j) {
					if (comp.compare(array[j], array[j - 1]) < 0) {
						T temp = array[j];
						array[j] = array[j - 1];
						array[j - 1] = temp;
						swapped = true;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Integer[] x = { 65, 23, 12, 99, 76, 85, 43, 30, 9, 80 };
		bubbleSort(x);
		for (int y : x) {
			System.out.print(y + "\t");
		}
		System.out.println();

		Student[] stus = {
			new Student("Wang", 35),
			new Student("Lee", 20),
			new Student("Zhang", 31),
			new Student("An", 18)
		};
		bubbleSort(stus, (s1, s2) -> {
			return s2.name.compareTo(s1.name);
		});
		for (Student s : stus) {
			System.out.println(s);
		}
	}
}