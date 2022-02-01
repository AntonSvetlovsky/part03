/*
 * Замените в строке все вхождения 'word' на 'letter'.
 */

package by.epam.jonline_introduction.part03.string_as_array;

import java.util.Arrays;

public class Practice030102 {

	public static void main(String[] args) {
		String str = "Little word. Big word.";
		String newStr;
		String trgtStr = "word";
		String repStr = "letter";
		char[] charArr = str.toCharArray();
		char[] trgtCharArr = trgtStr.toCharArray();
		char[] repCharArr = repStr.toCharArray();
		char[] newCharArr = new char[calculateSize(charArr, trgtCharArr, repCharArr)];
		int index = 0;

		for (int i = 0; i < charArr.length; i++) {
			if (isMatch(charArr, i, trgtCharArr)) {
				for (int j = 0; j < repCharArr.length; j++) {
					newCharArr[index] = repCharArr[j];
					index++;
				}
				i += 3;
			} else {
				newCharArr[index] = charArr[i];
				index++;
			}
		}

		newStr = new String(newCharArr);
		System.out.println(newStr);
		System.out.println(Arrays.toString(newCharArr));
	}

	public static boolean isMatch(char[] charArr, int index, char[] trgtArr) {
		char firstChar = trgtArr[0];
		char[] temp = new char[4];
		if (charArr[index] == firstChar) {
			for (int i = 0; i < temp.length; i++) {
				temp[i] = charArr[index];
				index++;
			}
		}
		return Arrays.equals(trgtArr, temp);
	}

	public static int calculateSize(char[] charArr, char[] trgtArr, char[] repArr) {
		int x = repArr.length - trgtArr.length;
		int size = charArr.length;
		for (int i = 0; i < charArr.length; i++) {
			if (isMatch(charArr, i, trgtArr)) {
				size += x;
			}
		}
		return size;
	}
}
