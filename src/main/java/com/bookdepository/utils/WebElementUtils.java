package com.bookdepository.utils;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;


public class WebElementUtils {

    public static List<String> getTextContentListByCSS(String cssSelector) {
        return Selenide.$$(By.cssSelector(cssSelector)).texts();
    }

    public static List<String> trimElementsInList(List<String> list) {
        return list.stream().map(String::trim).collect(Collectors.toList());
    }
}
