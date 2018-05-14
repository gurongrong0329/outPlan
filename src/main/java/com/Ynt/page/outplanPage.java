package com.Ynt.page;

import com.Ynt.common.ParseProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class outplanPage extends loginPage{
    private ParseProperties data = new ParseProperties(System.getProperty("user.dir") + "\\config\\data\\parameter.properties");
    
    public outplanPage(WebDriver driver)
    {
        super(driver);
        
    }
    private WebElement elementLocator(By element)
    {
        return this.driver.findElement(element);
    }
    public void createPlan(String planName,String scene,String file)throws InterruptedException{
        elementLocator(By.xpath(data.getValue("e_createPlan"))).click();
        Thread.sleep(1000);
        elementLocator(By.xpath(data.getValue("e_interactive"))).click();
        Thread.sleep(1000);
        elementLocator(By.xpath(data.getValue("e_ivu-input"))).sendKeys(planName);
        Thread.sleep(1000);
        elementLocator(By.xpath(data.getValue("e_nextStep"))).click();
        Thread.sleep(1000);
        elementLocator(By.xpath(data.getValue("e_ivu-select-placeholder"))).click();
        Thread.sleep(1000);
        elementLocator(By.xpath(data.getValue("e_ivu-select-item").replace("%var%",scene))).click();
        Thread.sleep(1000);
        elementLocator(By.xpath(data.getValue("e_nextStep"))).click();
        Thread.sleep(1000);
        elementLocator(By.xpath(data.getValue("e_uploadNum"))).click();
        Thread.sleep(1000);
        Runtime runtime=Runtime.getRuntime();
        try {
            runtime.exec(file); 
        }catch (IOException e){
            e.printStackTrace();
        }
        Thread.sleep(2000);
        elementLocator(By.xpath(data.getValue("e_ok"))).click();
        Thread.sleep(1000);
        elementLocator(By.xpath(data.getValue("e_nextStep"))).click();
        Thread.sleep(1000);
        elementLocator(By.xpath(data.getValue("e_backHome"))).click();
        Thread.sleep(1000);
    }
    
    public void deletePlan(String planName)throws InterruptedException{
        int i=0;
        while (true)
        {
            this.driver.navigate().refresh();
            try {
                elementLocator(By.xpath(data.getValue("e_deletePlan").replace("%var%",planName))).click();
                Thread.sleep(2000);
                elementLocator(By.xpath(data.getValue("e_commit"))).click();
                Thread.sleep(1000);
                break;
            }catch (NoSuchElementException e){
                System.out.println("正在通话.........");
                i++;
            }
            Thread.sleep(3000);
            if (i==7)
            {
                break;
            }
        }
    }
}
