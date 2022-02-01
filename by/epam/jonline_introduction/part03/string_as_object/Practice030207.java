/*
 * Вводится строка. Требуется удалить из нее повторяющиеся символы
 * и все пробелы. Например, если было введено "abc cde def",
 * то должно быть выведено "abcdef".
 */

package by.epam.jonline_introduction.part03.string_as_object;

import java.util.Scanner;

public class Practice030207 {

	public static void main(String[] args) {

		StringBuilder str = new StringBuilder();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int i;

		System.out.println("Введите строку");
		System.out.print(">> ");
		str.append(sc.nextLine());

		i = 0;
		while (i < str.length()) {
			int j = i + 1;
			while (j < (str.length() - 1)) {
				if (str.charAt(j) == str.charAt(i)) {
					str.deleteCharAt(j);
					j--;
				}
				j++;
			}
			i++;
		}

		i = 0;
		while (i < str.length()) {
			if (str.charAt(i) == ' ') {
				str.deleteCharAt(i);
			}
			i++;
		}

		if (str.charAt(str.length() - 1) == str.charAt(str.length() - 2)) {
			str.deleteCharAt(str.length() - 1);
		}

		System.out.println(str);
	}
}
