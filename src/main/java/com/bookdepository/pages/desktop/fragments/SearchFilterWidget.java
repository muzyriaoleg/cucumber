package com.bookdepository.pages.desktop.fragments;

import com.bookdepository.pages.abstractclasses.fragment.AbstractFragment;
import org.openqa.selenium.By;


public class SearchFilterWidget extends AbstractFragment {

    public Select priceRangeSelect = new Select(By.cssSelector("#filterPrice"));

    public Select availabilitySelect = new Select(By.cssSelector("#filterAvailability"));

    public Select languageSelect = new Select(By.cssSelector("#filterLang"));

    public Select formatSelect = new Select(By.cssSelector("#filterFormat"));

    public Button submitFiltersButton = new Button(By.cssSelector(".padded-btn-wrap button[type='submit']"));
}
