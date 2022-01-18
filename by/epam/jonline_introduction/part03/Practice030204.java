/*
 * С помощью функции копирования и операции конкатенации составить
 * из частей слова “информатика” слово “торт”.
 */

package by.epam.jonline_introduction.part03;

public class Practice030204 {
	public static void main(String[] args) {
		String resource;
		String target;
		String result;
		int i;

		resource = "информатика";
		target = "торт";
		i = 0;
		result = "";

		while (i < target.length()) {
			int j = 0;
			while (j < resource.length()) {
				if (resource.charAt(j) == target.charAt(i)) {
					result = result + resource.charAt(j);
					break;
				}
				j++;
			}
			i++;
		}

		System.out.println(result);
	}
}
