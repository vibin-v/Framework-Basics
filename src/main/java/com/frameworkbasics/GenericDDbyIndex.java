package com.frameworkbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class GenericDDbyIndex {

    static WebDriver driver;

    public static void main(String[] args) {

        driver = new ChromeDriver();

        driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
        
        By domElement = By.xpath("//div[@class='information closable']/following-sibling::p/select");

        getElement(domElement);
        doClickElement(domElement);
        doSelectionByIndex(domElement,7);

    }

    public static WebElement getElement(By locator)
    {
        return driver.findElement(locator);
        
    }

    public static void doClickElement(By locator)
    {
        driver.findElement(locator).click();
    }

    public static void doSelectionByIndex(By locator,int slectionIndex)
    {
        WebElement dropdoWebElement = driver.findElement(locator);
        Select dropdowSelect = new Select(dropdoWebElement);
        dropdowSelect.selectByIndex(slectionIndex);
    }



}
