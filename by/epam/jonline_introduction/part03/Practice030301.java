/* Cоздать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять с текстом три различных операции:
 *  отсортировать абзацы по количеству предложений;
 *  в каждом предложении отсортировать слова по длине;
 *   отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства – по алфавиту.
 */

package by.epam.jonline_introduction.part03;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Practice030301 {
	public static void main(String[] args) {
		String str = "Полиморфизм (polymorphism) — механизм, использующий одно и то же имя метода для решения похожих, но"
				+ " несколько отличающихся задач в различных объектах при наследовании из одного суперкласса. Целью полиморфизма "
				+ "является использование одного имени при выполнении общих для суперкласса и подклассов действий.\n"

				+ "Механизм «позднего связывания» в процессе выполнения программы определяет принадлежность объекта конкретному классу и"
				+ " производит вызов метода,относящегося к классу, объект которого был использован. Механизм «позднего связывания» позволяет"
				+ " определять версию полиморфного (виртуального) метода во время выполнения программы. Другими словами, иногда невозможно"
				+ "	на этапе компиляции определить, какая версия переопределенного метода будет вызвана на этапе выполнения программы.\n"

				+ "Краеугольным камнем наследования и полиморфизма предстает следующая парадигма: «объект подкласса может использоваться "
				+ "всюду, где используется объект суперкласса». То есть при добавлении к иерархии классов нового подкласса существующий код "
				+ "с экземпляром нового подкласса будет работать точно так же, как и со всеми другими экземплярами классов в иерархии.";

		System.out.println(str);
		select(str);
	}

	public static void select(String str) {
		int a;
		String message = "Menu:\n" + "1. Sort paragraphs by number of sentences. \n"
				+ "2. Sort words by length in each sentence. \n"
				+ "3. Set a character and sort lexemes in each sentence \n"
				+ " in descending order of the number of occurrences of a given character, \n"
				+ " and in case of equality - by alphabet.\n" + "4. Exit.\n"
				+ "----------------------------------------------------------------------------\n"
				+ "Please select the action:\t";

		System.out.println(message);
		a = readFromConsole();

		switch (a) {
		case 1:
			sortParagraphsByNumberOfSentences(str);
			select(str);
			break;
		case 2:
			sortWordsByLength(str);
			select(str);
			break;
		case 3:
			sortLexemesByNumberOfChar(str);
			select(str);
			break;
		case 4:
			System.out.println("Exit");
			break;
		default:
			System.out.println("Invalid input, please try again!");
			select(str);
		}
	}

	public static int readFromConsole() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		@SuppressWarnings("unused")
		String temp;
		int input;

		System.out.print(">> ");

		while (!sc.hasNextInt()) {
			temp = sc.nextLine();
			System.out.print(">> ");
		}

		input = sc.nextInt();
		return input;
	}

	public static void sortParagraphsByNumberOfSentences(String str) {
		String result = "";
		Pattern pattern = Pattern.compile("\\n");
		String[] arr = pattern.split(str);
		String reg = "[\\.\\?\\!]\\s";

		sortStringArray(arr, reg);

		result = convertArrayToString(arr, '\n');

		System.out.println(result);
	}

	public static String[] sortStringArray(String[] arr, String reg) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j > 0 && countMatches(arr[j - 1], reg) < countMatches(arr[j], reg); j--) {
				String temp = arr[j - 1];
				arr[j - 1] = arr[j];
				arr[j] = temp;
			}
		}

		return arr;
	}

	public static String[] sortStringArray(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j > 0 && arr[j - 1].compareToIgnoreCase(arr[j]) > 0; j--) {
				String temp = arr[j - 1];
				arr[j - 1] = arr[j];
				arr[j] = temp;
			}
		}

		return arr;
	}

	public static int countMatches(String str, String reg) {
		int i;
		i = 0;
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			i++;
		}
		return i;
	}

	public static String convertArrayToString(String[] arr, char separator) {
		String result = "";

		for (int i = 0; i < arr.length; i++) {
			result = result + arr[i] + separator;
		}

		return result;
	}

	public static void sortWordsByLength(String str) {
		String result = "";
		Pattern pattern1 = Pattern.compile("[\\.\\?\\!]\\s");
		String[] arr = pattern1.split(str);

		Pattern pattern2 = Pattern.compile("[^\\wа-яА-Я]+");
		String reg = "[\\wа-яА-Я]";

		for (int i = 0; i < arr.length; i++) {
			String[] tempArr = pattern2.split(arr[i]);
			sortStringArray(tempArr, reg);
			String temp = "";
			temp = convertArrayToString(tempArr, ' ');
			temp = temp + '.';
			arr[i] = temp;
		}

		result = convertArrayToString(arr, '\n');

		System.out.println(result);
	}

	public static void sortLexemesByNumberOfChar(String str) {
		String result = "";
		Pattern pattern1 = Pattern.compile("[\\.\\?\\!]\\s");
		String[] arr = pattern1.split(str);

		Pattern pattern2 = Pattern.compile("[^\\wа-яА-Я]+");
		String reg = readCharacter();

		for (int i = 0; i < arr.length; i++) {
			String[] tempArr = pattern2.split(arr[i]);
			sortStringArray(tempArr);
			sortStringArray(tempArr, reg);
			String temp = "";
			temp = convertArrayToString(tempArr, ' ');
			temp = temp + '.';
			arr[i] = temp;
		}

		result = convertArrayToString(arr, '\n');

		System.out.println(result);
	}

	public static String readCharacter() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String temp;
		String input;
		System.out.println("Please enter a character");
		System.out.print(">> ");

		temp = sc.next();

		while (temp.length() != 1) {
			System.out.println("Incorrect entry, please try again!");
			System.out.print(">> ");
			temp = sc.next();
		}

		input = temp;

		return input;
	}
}
