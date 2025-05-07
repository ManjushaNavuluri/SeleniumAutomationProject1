package project;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
public class HRManagementTest {
	static JavascriptExecutor js;
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException, IOException {
		driver = BrowserLaunch.driverLaunch();
		js = (JavascriptExecutor) driver;
		ExcelUtils.setExcelFile("C:\\Users\\2392910\\eclipse-workspace\\MiniProjectSelenium\\testData\\Data.xlsx", "Sheet1");
		int rc=ExcelUtils.getRowCount();
		for(int i=1;i<=rc;i++) {
			String job = ExcelUtils.getCellData(i, 0);
            String locName = ExcelUtils.getCellData(i, 1);
            String city = ExcelUtils.getCellData(i, 2);
            String state = ExcelUtils.getCellData(i, 3);
            String zipCode = ExcelUtils.getCellData(i, 4);
            String country = ExcelUtils.getCellData(i, 5);
            String phoneNumber = ExcelUtils.getCellData(i, 6);
            String fax = ExcelUtils.getCellData(i, 7);
            String address = ExcelUtils.getCellData(i, 8);
            String notes = ExcelUtils.getCellData(i, 9);
            String skill = ExcelUtils.getCellData(i, 10);
            String skillDescr = ExcelUtils.getCellData(i, 11);
            testHRManagement(job, locName, country, state, zipCode, phoneNumber, fax, address, notes, city, skill, skillDescr);
		}
		driver.quit();
	}
	public static void testHRManagement(String job, String locName, String country, String state, String zipCode,String phoneNumber, String fax, String address, String notes, String city, String skill, String skillDescr) {
        String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.manage().window().maximize();
        
	    //login
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        js.executeAsyncScript("setTimeout(arguments[0], 1000);");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        js.executeAsyncScript("setTimeout(arguments[0], 1000);");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        
        //click on Admin
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span")).click();
        js.executeAsyncScript("setTimeout(arguments[0], 1000);");
        //Click on Job
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]/span")).click();
        js.executeAsyncScript("setTimeout(arguments[0], 1000);");
        //Select Job Category
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]/ul/li[4]")).click();
        js.executeAsyncScript("setTimeout(arguments[0], 1000);");
        //Click on add
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[1]/div/button")).click();
        js.executeAsyncScript("setTimeout(arguments[0], 1000);");
        //enter name
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input")).sendKeys(job);
        js.executeAsyncScript("setTimeout(arguments[0], 1000);");
        //save
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")).click();
        js.executeAsyncScript("setTimeout(arguments[0], 4000);");
	    //delete category
        js.executeAsyncScript("setTimeout(arguments[0], 1000);");
        driver.findElement(By.xpath("//div[text()='"+job+"']/following::div/button[1]")).click();
        js.executeAsyncScript("setTimeout(arguments[0], 1000);");
        
        //confirm delete
        js.executeAsyncScript("setTimeout(arguments[0], 1000);");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]")).click();
       
        //organization
        js.executeAsyncScript("setTimeout(arguments[0], 3000);");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[3]/span")).click();
      
       //location
        js.executeAsyncScript("setTimeout(arguments[0], 1000);");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[3]/ul/li[2]")).click();
        js.executeAsyncScript("setTimeout(arguments[0], 1000);");
       //add    
        js.executeAsyncScript("setTimeout(arguments[0], 1000);");
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[1]/div/button")).click();
       
       //filling all the details
        js.executeAsyncScript("setTimeout(arguments[0], 1000);");
       driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div/div/div[2]/input")).sendKeys(locName);
       js.executeAsyncScript("setTimeout(arguments[0], 1000);");
       driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input")).sendKeys(city);
       js.executeAsyncScript("setTimeout(arguments[0], 1000);");
       driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input")).sendKeys(state);
       js.executeAsyncScript("setTimeout(arguments[0], 1000);");
       driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[3]/div/div[2]/input")).sendKeys(zipCode);
       js.executeAsyncScript("setTimeout(arguments[0], 1000);");
       //select the country
       driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[4]/div/div[2]/div/div/div[2]/i")).click();
       js.executeAsyncScript("setTimeout(arguments[0], 100);");
       driver.findElement(By.xpath("//span[normalize-space()='"+country+"']")).click();
       
       driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[5]/div/div[2]/input")).sendKeys(phoneNumber);
       js.executeAsyncScript("setTimeout(arguments[0], 1000);");
       driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[6]/div/div[2]/input")).sendKeys(fax);
       js.executeAsyncScript("setTimeout(arguments[0], 1000);");
       
       driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[7]/div/div[2]/textarea")).sendKeys(address);
       js.executeAsyncScript("setTimeout(arguments[0], 1000);");
       driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[8]/div/div[2]/textarea")).sendKeys(notes);
       js.executeAsyncScript("setTimeout(arguments[0], 1000);");
       //save
       driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]")).click();
       //delete
       js.executeAsyncScript("setTimeout(arguments[0], 4000);");
       driver.findElement(By.xpath("(//*[text()='"+locName+"']/following::button)[1]")).click();
       js.executeAsyncScript("setTimeout(arguments[0], 1000);");
       //confirm delete
       driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]")).click();
       js.executeAsyncScript("setTimeout(arguments[0], 4000);");
       //qualifications
       driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[4]/span")).click();
       js.executeAsyncScript("setTimeout(arguments[0], 1000);");
       //skills
       driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[4]/ul/li[1]")).click();
       js.executeAsyncScript("setTimeout(arguments[0], 2000);");
       //add skill
       driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[1]/div/button")).click();
       js.executeAsyncScript("setTimeout(arguments[0], 2000);");
       //entering the skills and description
       driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input")).sendKeys(skill);
       js.executeAsyncScript("setTimeout(arguments[0], 1000);");
       driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/textarea")).sendKeys(skillDescr);
       js.executeAsyncScript("setTimeout(arguments[0], 1000);");
       //save
       driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]")).click();
       js.executeAsyncScript("setTimeout(arguments[0], 2000);");
       //delete the created skill
       driver.findElement(By.xpath("(//*[text()='Testing Demo']/following::button)[1]")).click();
       js.executeAsyncScript("setTimeout(arguments[0], 3000);");
       //verifying if the skill is deleted.
       driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]")).click();
       js.executeAsyncScript("setTimeout(arguments[0], 3000);");
       //logout
       driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
       js.executeAsyncScript("setTimeout(arguments[0], 2000);");
       driver.findElement(By.xpath("//a[text()='Logout']")).click();
       js.executeAsyncScript("setTimeout(arguments[0], 2000);");
       //closing the browser
       driver.quit();
       System.out.println("Performed Automation Successfully...");
	}
 
}


 