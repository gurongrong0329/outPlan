package com.Ynt.common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.Ynt.common.ParseProperties;

public class Browsers {
    public WebDriver driver = null;
    private FirefoxProfile firefoxprofile = null;
    private static DesiredCapabilities caps = null;
    private ParseProperties data = new ParseProperties(System.getProperty("user.dir") + "\\config\\data\\parameter.properties");

    public Browsers(BrowsersType browserstype) {
        switch (browserstype) {
            case firefox:
                System.setProperty("webdriver.firefox.bin", data.getValue("fireFoxPath"));
                driver = new FirefoxDriver(firefoxprofile);
                driver.manage().window().maximize();
                break;
            case ie:
                System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/tool/IEDriverServer32.exe");
                caps = DesiredCapabilities.internetExplorer();
                caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, false);
                caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                caps.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
                caps.setCapability("ignoreZoomSetting", true);
                driver = new InternetExplorerDriver(caps);
                driver.manage().window().maximize();
                break;
            case chrome:
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
                //caps = DesiredCapabilities.chrome();
                //caps.setCapability("chrome.switches",Arrays.asList("--start-maximized"));  //���browser
                //capabilities.setCapability("chrome.switches", Arrays.asList("--proxy-server=http://your-proxy-domain:4443")); //���ô���
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
        }
    }
}
