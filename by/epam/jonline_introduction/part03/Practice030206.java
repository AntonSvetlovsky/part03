/*
 *Из заданной строки получить новую,
 * повторив каждый символ дважды.
 */

package by.epam.jonline_introduction.part03;

public class Practice030206 {
	public static void main(String[] args) {
		StringBuilder str1 = new StringBuilder();
		StringBuilder str2 = new StringBuilder();

		str1.append("Test !");

		for (int i = 0; i < str1.length(); i++) {
			str2.append(str1.charAt(i));
			str2.append(str1.charAt(i));
		}

		System.out.println(str2);
	}
}
