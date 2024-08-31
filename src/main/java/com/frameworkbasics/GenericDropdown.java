package com.frameworkbasics;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class GenericDropdown {

    static WebDriver driver;
    
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized","force-device-scale-factor=0.85");
        
        driver = new ChromeDriver(options);


        driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));

        By allCountySQA = By.xpath("//div[@class='information closable']/following-sibling::p/select");
        //By allCountyHRM = By.id("Form_getForm_Country");

        getElement(allCountySQA).click();
        doHighlightElement(allCountySQA);
        
        doSelectByVisibleText(allCountySQA, "Albania");

 
    }

    public static WebElement getElement(By locator)
    {
        return driver.findElement(locator);
    }

    public static void doSelectByVisibleText(By locator,String selectOption)
    {
        WebElement dropDownOptions = driver.findElement(locator);
        Select allOptions = new Select(dropDownOptions);
        allOptions.selectByVisibleText(selectOption);
    }

    public static void doHighlightElement(By locator)
    {
        WebElement pageElement = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='2px solid red'",pageElement);
    }

}
