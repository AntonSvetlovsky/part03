/*
 * Дан массив названий переменных в camelCase.
 * Преобразовать названия в snake_case.
 */

package by.epam.jonline_introduction.part03;

public class Practice030101 {

	public static void main(String[] args) {
		String[] camelCase = { "camel1Case1", "camel12Case2", "camel123Cases3Case4" };
		char letter;
		int indexSnake;
		char[] charCamelCase;
		char[] charSnakeCase;

		for (int i = 0; i < camelCase.length; i++) {
			charCamelCase = camelCase[i].toCharArray();
			charSnakeCase = new char[calculateSizeArr(charCamelCase)];
			indexSnake = -1;

			for (int j = 0; j < charCamelCase.length; j++) {
				if ((int) charCamelCase[j] >= 65 && (int) charCamelCase[j] <= 90) {
					letter = (char) (charCamelCase[j] + 'a' - 'A');
					charSnakeCase[++indexSnake] = '_';
					charSnakeCase[++indexSnake] = letter;
				} else {
					letter = charCamelCase[j];
					charSnakeCase[++indexSnake] = letter;
				}
			}

			for (int m = 0; m < charSnakeCase.length; m++) {
				System.out.print(charSnakeCase[m]);
			}
			System.out.println();
		}
	}

	public static int calculateSizeArr(char[] arr) {
		int size;
		int code;
		size = arr.length;

		for (int i = 0; i < arr.length; i++) {
			code = (int) arr[i];
			if (code >= 65 && code <= 90) {
				size++;
			}
		}

		return size;
	}
}