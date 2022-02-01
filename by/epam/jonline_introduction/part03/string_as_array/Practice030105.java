/*
 * Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов
 * заменить на одиночные пробелы. Крайние пробелы в строке удалить.
 */

package by.epam.jonline_introduction.part03.string_as_array;

public class Practice030105 {

	public static void main(String[] args) {
		String str = "    Test test   test.       Test   test. ";
		char[] charArr = str.toCharArray();
		char[] charArrTemp1 = new char[charArr.length + 1];
		char[] charArrTemp2;

		int i = 0;
		int index = 0;

		while (i < charArr.length) {
			if (charArr[i] != ' ') {
				do {
					charArrTemp1[index] = charArr[i];
					i++;
					index++;
				} while (i < charArr.length && charArr[i] != ' ');
				charArrTemp1[index] = ' ';
				index++;
			}
			i++;
		}

		charArrTemp2 = new char[index - 1];

		for (int j = 0; j < charArrTemp2.length; j++) {
			charArrTemp2[j] = charArrTemp1[j];
		}

		str = new String(charArrTemp2);
		System.out.println(str);
	}
}
