package com.frameworkbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class GenericDDbyValue {

    static WebDriver driver;

    public static void main(String[] args) {
        
        driver = new ChromeDriver();

        driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");

        By domElement = By.xpath("//div[@class='information closable']/following-sibling::p/select");

        getElement(domElement).click();

        doSelectByValue(domElement, "AND");



    }

    public static WebElement getElement(By locator)
    {
        return driver.findElement(locator);
    }

    public static void doSelectByValue(By locator,String dropValue)
    {
        WebElement dropElement = driver.findElement(locator);

        Select selectOption = new Select(dropElement);

        selectOption.selectByValue(dropValue);
    }
}
