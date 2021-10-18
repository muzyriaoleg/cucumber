package com.bookdepository.utils;

import java.util.List;
import java.util.stream.Collectors;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.*;


public class WebElementUtils {

	public static List<String> getTextContentListByCSS(String cssSelector) {
		return Selenide.$$(By.cssSelector(cssSelector)).stream().map(
				SelenideElement::getText).collect(Collectors.toList());
	}

	public static List<String> trimElementsInList(List<String> list) {
		return list.stream().map(String::trim).collect(Collectors.toList());
	}
}
