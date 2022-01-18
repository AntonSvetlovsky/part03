/*
 * Дана строка, содержащая следующий текст (xml-документ).
 * Напишите анализатор, позволяющий последовательно возвращать
 * содержимое узлов xml-документа и его тип (открывающий тег,
 * закрывающий тег, содержимое тега, тег без тела).
 * Пользоваться готовыми парсерами XML для решения данной задачи нельзя.
 */

package by.epam.jonline_introduction.part03;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Practice030302 {
	public static void main(String[] args) {
		String xmlDoc = "<notes>\n"
	        		  	+ "<note id = \"1\">\n"
	        		  		+ "<to>Вася</to>\n"
	        		  		+ "<from>Света</from>\n"
	        		  		+ "<heading>Напоминание</heading>\n"
	        		  		+ "<body>Позвони мне завтра!</body>\n"
	        		  	+ "</note>\n"
	        		  	+ "<note id = \"2\">\n"
	        		  		+ "<to>Петя</to>\n"
	        		  		+ "<from>Маша</from>\n"
	        		  		+ "<heading>Важное напоминание</heading>\n"
	        		  		+ "<body/>\n"
        		     	+ "</note>\n"
                      + "</notes>";

		parseXml(xmlDoc);
	}

	public static void parseXml(String xml) {
		String regEx = "(<[^<>]+>)|([^<>]*)";
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(xml);
		String element = "";

		while (matcher.find()) {
			element = matcher.group();

			if (element.matches("<[^/<>]+>")) {
				System.out.println("Start tag");
				System.out.println("Tag name = " + findTagName(element));
			}
			if (element.matches("</[^<>]+>")) {
				System.out.println("End tag");
				System.out.println("Tag name = " + findTagName(element));
			}
			if (hasAttributes(element)) {
				System.out.println("Attributes = " + findAttributes(element));
			}
			if (element.matches("[a-zA-Z_0-9а-яА-Я]+")) {
				System.out.println("Text = " + element);
			}
		}
	}

	public static boolean hasAttributes(String startTag) {
		String reg = "\\w+ ?= ?\"\\w+\"";
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(startTag);
		return matcher.find();
	}

	public static String findAttributes(String startTag) {
		String result = null;
		StringBuilder attributes = new StringBuilder();
		Pattern pattern = Pattern.compile("\\w+ ?= ?\"\\w+\"");
		Matcher matcher = pattern.matcher(startTag);

		while (matcher.find()) {
			attributes.append(matcher.group());
			attributes.append(" ");
		}
		result = attributes.toString();
		return result;
	}

	public static String findTagName(String tag) {
		String tagName = "";
		String reg = "\\w+";
		Pattern patternName = Pattern.compile(reg);
		Matcher matcherName = patternName.matcher(tag);
		if (matcherName.find()) {
			tagName = matcherName.group();
		}
		return tagName;
	}

}
