package home;

import lombok.SneakyThrows;
import org.example.pages.home.*;
import org.example.pages.panel.SearchHeaderAndLeftBarPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePagePositiveTest extends HomeBaseTest {
    @Test
    public void SearchPositiveTest() {
        SearchPage searchPage = new SearchPage(driver);
        SearchHeaderAndLeftBarPage searchHeaderAndLeftBarPage = new SearchHeaderAndLeftBarPage(driver);

        leftBar.clickOnSearchButton();

        waitHelper.waitForElementsToBeVisible(searchPage.webElements);
        waitHelper.waitForElementsToBeVisible(searchHeaderAndLeftBarPage.webElements);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.vlume.com/search?type=title&search_text=&Audiobook=1&Ebook=1&Animation=1&Language=en,hy&Dialect=&Spelling=");

    }


    @Test
    public void AudiobooksPositiveTest() {
        AudiobooksPage audiobooksPage = new AudiobooksPage(driver);

        leftBar.clickAudiobooksButton();
        waitHelper.waitForElementsToBeVisible(audiobooksPage.webElements);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.vlume.com/audiobooks");
    }

    @Test
    public void EBooksPositiveTest() {
        EBooksPage eBooksPage = new EBooksPage(driver);

        leftBar.clickEbooksButton();
        waitHelper.waitForElementsToBeVisible(eBooksPage.webElements);

        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.vlume.com/ebooks");
    }

    @Test
    public void MyListPositiveTest() {
        MyListPage myListPage = new MyListPage(driver);

        leftBar.clickMyListButton();
        waitHelper.waitForElementsToBeVisible(myListPage.webElements);

        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.vlume.com/my-list");
    }

    @Test
    public void GiftPositiveTest() {
        GiftPage giftPage = new GiftPage(driver);

        leftBar.clickGiftButton();
        waitHelper.waitForElementsToBeVisible(giftPage.webElements);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.vlume.com/gift");
    }

    @Test
    public void AuthorsPositiveTest() {
        AuthorsPage authorsPage = new AuthorsPage(driver);
        leftBar.clickAuthorsButton();
        waitHelper.waitForElementsToBeVisible(authorsPage.webElements);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.vlume.com/authors");
    }
}
