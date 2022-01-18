/*
 *  Проверить, является ли заданное слово палиндромом.
 */

package by.epam.jonline_introduction.part03;

import java.util.Scanner;

public class Practice030203 {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		StringBuilder str;
		StringBuilder strTemp;

		System.out.println("Введите слово для проверки");
		System.out.print(">> ");
		str = new StringBuilder(sc.next());

		strTemp = new StringBuilder(str);
		strTemp.reverse();

		if (str.compareTo(strTemp) == 0) {
			System.out.println("Слово является палиндромом.");
		} else {
			System.out.println("Слово не является палиндромом.");
		}

	}
}
