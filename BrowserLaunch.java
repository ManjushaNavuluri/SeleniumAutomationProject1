package project;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
 
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class BrowserLaunch {
	public static WebDriver driver;
	public static WebDriver driverLaunch() throws IOException {
		FileInputStream fi = new FileInputStream("C:\\Users\\2392910\\eclipse-workspace\\MiniProjectSelenium\\src\\test\\java\\project\\config.properties");
		Properties props=new Properties();
		props.load(fi);
		String browserName=props.getProperty("browser");
		if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
	        driver = new EdgeDriver();
		}else if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
		}else {
			WebDriverManager.edgedriver().setup();
	        driver = new EdgeDriver();
		}
		return driver;
	}
}