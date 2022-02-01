/*
 * В строке вставить после каждого символа 'a' символ 'b'.
 */

package by.epam.jonline_introduction.part03.string_as_object;

public class Practice030202 {

	public static void main(String[] args) {
		StringBuilder strB = new StringBuilder("aTest a test aa aTest test.a");

		for (int i = 0; i < strB.length(); i++) {
			if (strB.charAt(i) == 'a') {
				strB.insert(i + 1, 'b');
			}
		}

		System.out.println(strB);
	}
}
