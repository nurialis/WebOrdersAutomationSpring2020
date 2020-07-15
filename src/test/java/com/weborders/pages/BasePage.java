package com.weborders.pages;

import com.weborders.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage { // abstract something is not final or concreate devami LoginPage de cunku
    // we are not suppose to create object in the abstract class
    // this class will never be instantiated

    //explicit wait
    //will be used inside every page class
    //since this variable is protected
    //it will not be visible in test classes
    protected static WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20); // explicit wait

    @FindBy (linkText = "View all orders")
    private WebElement viewAllOrders;

    @FindBy(linkText = "View all products")
    private WebElement viewAllProducts;

    @FindBy(linkText = "Order")
    private WebElement order;

    public BasePage() {
        //we put this line to be able to use @FindBy, @FindBys.. annotations
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void clickOnViewAllOrders(){
        System.out.println("Clicking on 'View All Orders' "); // Optional calismadigi zaman nerede calistimadigini gosterir
        wait.until(ExpectedConditions.elementToBeClickable(viewAllOrders)); // Vytrack web siteso cok yavas orada bunu kullanabilirsin
        viewAllOrders.click();
    }

    public void clickOnViewAllProducts(){
        System.out.println("Clicking on 'View All Products' "); // Optional calismadigi zaman nerede calistimadigini gosterir
        wait.until(ExpectedConditions.elementToBeClickable(viewAllProducts)); // Vytrack web siteso cok yavas orada bunu kullanabilirsin
        viewAllProducts.click();
    }

    public void clickOnOrder(){
        System.out.println("Clicking on 'Order' "); // Optional calismadigi zaman nerede calistimadigini gosterir
        wait.until(ExpectedConditions.elementToBeClickable(order)).click();
    }
}
