package com.bookdepository.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.*;


public class WebElementUtils {

	public static List<String> getTextContentListByCSS(WebDriver driver, String cssSelector) {
		return driver.findElements(By.cssSelector(cssSelector)).stream().map(
				WebElement::getText).collect(Collectors.toList());
	}

	public static List<String> trimElementsInList(List<String> list) {
		return list.stream().map(String::trim).collect(Collectors.toList());
	}
}
