/*
 * Подсчитать, сколько раз среди символов заданной
 * строки встречается буква “а”.
 */

package by.epam.jonline_introduction.part03.string_as_object;

public class Practice030205 {

	public static void main(String[] args) {

		String str = "test a: data, database, test aaa adata.";
		int q;

		q = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'a') {
				q++;
			}
		}

		System.out.println("Количество символов 'a' в строке = " + q);
	}
}
