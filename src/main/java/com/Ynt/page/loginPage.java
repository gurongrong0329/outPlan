package com.Ynt.page;

import com.Ynt.common.ParseProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class loginPage {
    public WebDriver driver;
    private ParseProperties data = new ParseProperties(System.getProperty("user.dir") + "\\config\\data\\parameter.properties");
    
    public loginPage(WebDriver driver)
    {
        this.driver=driver;
    }
    
    private WebElement elementLocator(By element)
    {
        return this.driver.findElement(element);
    }
    
    public void loginYnt_ai(String account,String password) throws InterruptedException
    {
        this.elementLocator(By.xpath(data.getValue("e_login"))).click();
        this.elementLocator(By.id(data.getValue("e_username"))).sendKeys(data.getValue(account));
        Thread.sleep(1000);
        this.elementLocator(By.id(data.getValue("e_password"))).sendKeys(data.getValue(password));
        Thread.sleep(1000);
        this.elementLocator(By.xpath(data.getValue("e_loginSubmit"))).click();
        //Actions action=new Actions(this.driver);
        //action.clickAndHold(this.elementLocator(By.xpath(data.getValue("e_productCenter")))).perform();
        //Thread.sleep(1000);
        this.elementLocator(By.xpath(data.getValue("e_outplan"))).click();
        Thread.sleep(2000);
        this.elementLocator(By.xpath(data.getValue("e_freeUse"))).click();
        Thread.sleep(2000);
    }
    public void getHandle(String titleName)
    {
        Set<String> handles=this.driver.getWindowHandles();
        for (String handle:handles) {
            String getTitle=this.driver.switchTo().window(handle).getTitle();
            System.out.println(getTitle);
            if(titleName.equals(getTitle))
            {
                break;
            }
        }
    }
    public outplanPage outPlanModel(){
        this.elementLocator(By.xpath(data.getValue("e_outplanModel"))).click();
        return new outplanPage(this.driver);
    }
}
