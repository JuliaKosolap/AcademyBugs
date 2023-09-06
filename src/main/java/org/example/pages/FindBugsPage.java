package org.example.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class FindBugsPage extends BasePage {
    @FindBy(id = "sortfield")
    private WebElement sortField;

    @FindBy(xpath = "//option[@value='1']")
    private WebElement lowToHighSortItem;

    public FindBugsPage(WebDriver driver) throws MalformedURLException {
        super(driver);
    }

    public List<Double> getListOfAllProductPrices() {
        List<WebElement> pricesList = driver.findElements(By.className("ec_price_type1"));
        List<Double> list = new ArrayList<>();
        for (WebElement priceElement: pricesList
             ) {
            String text = priceElement.getText().replaceAll("[^0-9.]", "");
            double price = Double.parseDouble(text);
            list.add(price);
        }
        return list;
    }

    @Step("Sort products by prices: Low-To-High")
    public void sortProducts() {
        sortField.click();
        lowToHighSortItem.click();
    }

    public List<WebElement> getProductCards() {
        List<WebElement> elements = driver.findElements(By.className("academy-product-description-wrapper"));
    return elements;
    }

    public String getNameOfProductByPositionInList(int productNumber) {
        List<WebElement> productCards = getProductCards();
        WebElement webElement = productCards.get(productNumber - 1);
        return webElement.findElement(By.className("ec_image_link_cover")).getText();
    }

    @Step("Add product to the cart")
    public void addProductToCart(int productNumber) throws Exception {
        List<WebElement> productCards = getProductCards();
        WebElement productCard = productCards.get(productNumber - 1);
        WebElement button = productCard.findElement(By.className("ec_product_addtocart"));
        String buttonName = getButtonName(productNumber);
        if(buttonName.equals("ADD TO CART")) {
            button.click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ec_product_loader")));
        }
        else throw new Exception("Add To Cart Button is not available for this product");
    }

    public String getButtonName(int productNumber) {
        List<WebElement> productCards = getProductCards();
        WebElement webElement = productCards.get(productNumber - 1);
        String buttonName = webElement.findElement(By.className("ec_product_addtocart")).getText();
        return buttonName;
    }
}


