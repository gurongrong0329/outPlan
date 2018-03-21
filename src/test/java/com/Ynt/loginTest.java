package com.Ynt;

import com.Ynt.common.Browsers;
import com.Ynt.common.BrowsersType;
import com.Ynt.common.ParseProperties;
import com.Ynt.page.loginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class loginTest {
    private WebDriver driver=null;
    private Browsers browsers=null;
    private ParseProperties data = new ParseProperties(System.getProperty("user.dir") + "\\config\\data\\parameter.properties");
    private loginPage page=null;
    
    @BeforeTest
    public void BeforeTest()
    {
        browsers=new Browsers(BrowsersType.chrome);
        this.driver=browsers.driver;
    }
    
    @Test
    public void login()throws InterruptedException
    {
        this.driver.get(data.getValue("url"));
        this.page=new loginPage(this.driver);
        this.page.loginYnt_ai("account","password");
        this.page.getHandle(data.getValue("titleName2"));
        Thread.sleep(2000);
    }
    
    @AfterTest
    public void AfterTest()
    {
        this.driver.quit();
    }
}
