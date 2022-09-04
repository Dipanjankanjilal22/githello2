

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base1 {
	public static WebDriver driver;
	public Properties prop;

	public void invokeBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("mozilla")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);

		if(prop==null) {
			prop = new Properties();
			try {
				FileInputStream file = new FileInputStream(System.getProperty("user.dir")
						+ "\\src\\test\\resources\\objectRepository\\projectConfig.properties");
				prop.load(file);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	

	public void openUrl(String websiteUrlKey) {
		driver.get(prop.getProperty(websiteUrlKey));

	}
	/*public void registerFreeListing(String xpathKey) {
		driver.findElement(By.xpath(prop.getProperty(xpathKey))).click();
		
	}*/
	public void enterText(String xpathKey,String data) {
		driver.findElement(By.xpath(prop.getProperty(xpathKey))).sendKeys(data);
		/*driver.findElement(By.xpath(prop.getProperty(xpathKey))).sendKeys(data);
		driver.findElement(By.xpath(prop.getProperty(xpathKey))).sendKeys(data);
		driver.findElement(By.xpath(prop.getProperty(xpathKey))).sendKeys(data);
		driver.findElement(By.xpath(prop.getProperty(xpathKey))).sendKeys(data);
		driver.findElement(By.xpath(prop.getProperty(xpathKey))).sendKeys(data);
		driver.findElement(By.xpath(prop.getProperty(xpathKey))).sendKeys(data);
		driver.findElement(By.xpath(prop.getProperty(xpathKey))).sendKeys(data);*/
		
		
	}

	public void quitBrowser() {
		driver.quit();

	}
}