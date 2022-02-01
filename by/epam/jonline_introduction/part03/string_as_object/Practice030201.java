/*
 * Дан текст (строка). Найдите наибольшее количество
 * подряд идущих пробелов в нем.
 */

package by.epam.jonline_introduction.part03.string_as_object;

public class Practice030201 {

	public static void main(String[] args) {
		String str = " test.   test      !     test ,        .  ";
		int max = 0;
		int temp = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				temp++;
			} else {
				if (temp > max) {
					max = temp;
				}
				temp = 0;
			}
		}

		System.out.println("Наибольшее количествово подряд идущих пробелов = " + max);
	}
}
