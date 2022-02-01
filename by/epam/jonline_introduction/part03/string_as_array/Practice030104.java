/*
 * В строке найти количество чисел.
 */

package by.epam.jonline_introduction.part03.string_as_array;

public class Practice030104 {

	public static void main(String[] args) {
		String str = "Test 1 test 25 test 7001 54 test 3.14 test 55.89 test 5. ";
		char[] charArr = str.toCharArray();

		int q = 0;
		int i = 0;

		while (i < charArr.length) {
			if (isDigit(charArr[i])) {
				do {
					i++;
				} while (isDigit(charArr[i]) || charArr[i] == '.');
				q++;
			}
			i++;
		}

		System.out.println("Количество чисел в строке = " + q);
	}

	public static boolean isDigit(char ch) {
		return (int) ch >= 48 && (int) ch <= 57 ? true : false;
	}
}
