package com.weborders.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class OrderPage extends BasePage {

    //Product Information
    @FindBy(id = "ctl00_MainContent_fmwOrder_ddlProduct")
    private WebElement productDropdown;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    private WebElement quantity;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtUnitPrice")
    private WebElement pricePerUnit;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtDiscount")
    private WebElement discount;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtTotal")
    private WebElement total;

    @FindBy(css = "[value='Calculate']")
    private WebElement calculateButton;

    // Adress Information
    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    private WebElement customerName;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
    private WebElement street;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
    private WebElement city;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4")
    private WebElement state;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
    private WebElement zip;

    // Payment Information
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    private WebElement expirationDate;

    @FindBy(xpath = "//input[@value = 'Visa']")
    private WebElement visaCard;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
    private WebElement cardNumber;

    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    private WebElement processButton;

    public void selectProducts(String productName){
        Select select = new Select(productDropdown);
        select.selectByVisibleText(productName);
    }

    public void enterQuantity(String quantityValue) { // delete old value and enter new in one action
        quantity.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), quantityValue); // hucrede olan rakami silip istedigin rakami giriyorsun
    }

    public void enterPricePerUnit(String pricePerUnitValue) {
        pricePerUnit.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), pricePerUnitValue); // hucrede olan rakami silip istedigin rakami giriyorsun
    }

    public void enterDiscount(String discountValue) {
        discount.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), discountValue);// hucrede olan rakami silip istedigin rakami giriyorsun
    }

    public void clickToCalculate(){
        calculateButton.click();
    }

    public void enterCustomerName(String customerNameValue) {
        customerName.sendKeys(customerNameValue);
    }

    public void enterStreet(String streetValue) {
        street.sendKeys(streetValue);
    }

    public void enterCity(String cityValue) {
        city.sendKeys(cityValue);
    }

    public void enterState(String stateValue) {
        state.sendKeys(stateValue);
    }

    public void enterZip(String zipValue) {
        zip.sendKeys(zipValue);
    }

    /**
     * Method to select card type
     *
     * @param cardName Visa, MasterCard or American Express
     */
    public void selectCard(String cardName) {
        // String xpath = String.format("//label[text()='%s']/preceding-sibling::input", cardName); // Kartlari tek tek secen dynamik kod. 2.yol
        String xpath = "//label[text()='" + cardName + "']/preceding-sibling::input"; // Kartlari tek tek secen dynamik kod.
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
    }

    public void enterCardNumber(String cardNumberValue) {
        cardNumber.sendKeys(cardNumberValue);
    }

    public void enterExpirationDate(String date) {
        expirationDate.sendKeys(date);
    }

    public void clickOnProcessButton() {
        processButton.click();
    }

    public String getTotal(){
        return total.getAttribute("value");
    }

}
