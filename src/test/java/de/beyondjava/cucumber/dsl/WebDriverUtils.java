package de.beyondjava.cucumber.dsl;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverUtils {

	public static String extractInnerHTML(WebDriver driver, WebElement textElement) throws MalformedURLException, IOException {
		// This version is not reliable enough!
//		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML;",
//				textElement);
		String source = (String)  IOUtils.toString(new URL(driver.getCurrentUrl())); 
		int start = source.indexOf("<!-- contentToTest start -->") + "<!-- contentToTest start -->".length();
		int end = source.indexOf("<!-- contentToTest end -->");
		if (end > 0) {
			return source.substring(start, end).trim();
		}
		else return null;
	}

	public static String removeVariableStuff(String original) {
		int start = 0;
		while ((start = original.indexOf("id=\"highlighter_")) > 0) {
			int end = start + "id=\"highlighter_".length();
			while (Character.isDigit(original.charAt(end)))
				end++;
			original = original.substring(0, start) + original.substring(end+1);
		}
		while ((start = original.indexOf(";jsessionid=")) > 0) {
			int end = start + ";jsessionid=".length();
			while (Character.isJavaIdentifierPart(original.charAt(end)))
				end++;
			original = original.substring(0, start) + original.substring(end+1);
		}
		while ((start = original.indexOf("name=\"javax.faces.ViewState\"")) > 0) {
			int end = start + "name=\"javax.faces.ViewState\"".length();
			while (original.charAt(end) != '>')
				end++;
			original = original.substring(0, start) + original.substring(end-1);
		}
		return original;
	}

	public static String read(String filename) throws IOException {
		List<String> lines = Files.readAllLines(Paths.get("./" + filename), Charset.forName("UTF-8"));
		StringBuffer result = new StringBuffer();
		for (String line : lines) {
			result.append(line);
			result.append("\n");
		}
		return result.toString().trim();
	}

	public static void write(String filename, String text) throws IOException {
		text = text.trim().replace("\r\n", "\n").replace("\r", "\n");
		Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "UTF-8"));
		try {
			out.write(text);
		} finally {
			out.close();
		}
	}

}
