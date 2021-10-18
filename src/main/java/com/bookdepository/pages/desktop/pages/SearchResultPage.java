package com.bookdepository.pages.desktop.pages;

import com.bookdepository.constants.Constants;
import com.bookdepository.pages.abstractclasses.page.AbstractPage;
import com.bookdepository.pages.desktop.fragments.BasketModalWindow;
import com.bookdepository.pages.desktop.fragments.Button;
import com.bookdepository.pages.desktop.fragments.SearchFilterWidget;
import com.bookdepository.utils.WebElementUtils;
import org.openqa.selenium.By;

import java.util.List;


public class SearchResultPage extends AbstractPage {

    private String bookTitleXpathTemplate = "//a[contains(text(), '%s')]/../../..//div[@class='btn-wrap']";


    public BasketModalWindow basketModalWindow = new BasketModalWindow();
    public SearchFilterWidget searchWidget = new SearchFilterWidget();
    public Button addToBasketButton;

    public SearchResultPage() {
        super();
        setPageUrlPattern(Constants.SEARCH_RESULT_PAGE_URL_PATTERN);
    }

    public boolean isBookPresentInResult(List<String> listOfBooks) {
        List<String> bookTitlesList = WebElementUtils.getTextContentListByCSS(".title");
        return bookTitlesList.containsAll(listOfBooks);
    }

    public boolean onlySpecifiedBooksPresentInResult(List<String> bookList) {
        List<String> bookTitlesList = WebElementUtils.getTextContentListByCSS(".title");
        bookTitlesList.removeAll(bookList);
        return bookTitlesList.isEmpty();
    }

    public void addBookToBasket(String bookTitle) {
        addToBasketButton = new Button(By.xpath(String.format(bookTitleXpathTemplate, bookTitle)));
        addToBasketButton.press();
    }
}
