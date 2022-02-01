/*
 * В строке найти количество цифр.
 */

package by.epam.jonline_introduction.part03.string_as_array;

public class Practice030103 {

	public static void main(String[] args) {
		String str = "Test 1 test 25 test 7001 54 test";
		char[] charArr = str.toCharArray();
		int q = 0;

		for (int i = 0; i < charArr.length; i++) {
			if ((int) charArr[i] >= 48 && (int) charArr[i] <= 57) {
				q++;
			}
		}

		System.out.println("Количество цифр в строке = " + q);
	}
}
