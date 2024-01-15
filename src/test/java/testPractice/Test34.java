package testPractice;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

 

public class Test34 {
	
	 
	 
	WebDriver driver;
	
	String username = "demo@techfios.com";
	String password = "abc123";;
	String dashboardvalidationtext = "Dashboard- iBilling";
	String deposittext = "Transactions- iBilling";
    String Description = "brown" ;
    String amount = "100000" ;
  
	By submit_button_field = By.xpath("//*[@id=\"submit\"]");
	By amount_Field = By.xpath("//*[@id=\"amount\"]");
    By username_Field = By.xpath("//input[@id='username']");
	By password_Field = By.xpath("//input[@id='password']");
	By login_button_Field = By.xpath("//button[@name='login']");
	By transaction_button_Field = By.xpath("//*[@id=\"side-menu\"]/li[5]/a");
	By new_deposit_button_field = By.xpath("//*[@id=\"side-menu\"]/li[5]/ul/li[1]/a");
	By new_account_Field = By.xpath("//*[@id=\"account\"]");
    By description_field = By.xpath("//*[@id=\"description\"]");
	public void dropdown(WebElement element, String text) {
	Select select= new Select(element);
	select.selectByVisibleText(text);

	}

	@Before
	public void init() {
	    System.setProperty("webdriver.chrome.driver", "/Users/nabil/chromeDriver/chromedriver");
	    driver = new ChromeDriver();
	    driver.get("https://www.techfios.com/billing/?ng=admin/");
	    driver.manage().deleteAllCookies();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void Loginpage() {

	    driver.findElement(username_Field).sendKeys(username);
	    driver.findElement(password_Field).sendKeys(password);
	    driver.findElement(login_button_Field).click();

	}
	@Test
	public void  addDepposit() {
	    Loginpage();
	    
	    Assert.assertEquals(dashboardvalidationtext, driver.getTitle());
	    driver.findElement(transaction_button_Field).click();
	    driver.findElement(new_deposit_button_field).click();
	    Assert.assertEquals(deposittext, driver.getTitle());
	    dropdown(driver.findElement(new_account_Field), "Tech");
	    driver.findElement(description_field).sendKeys(Description+generatedNumber(999));
	    driver.findElement(amount_Field).sendKeys(amount);
	    driver.findElement(submit_button_field).click();	
	    validateName();
	    
	   
	    
	}
  
	
	public String validateName() {
    	
    	 String beforePath = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div[2]/div/div[2]/table/tbody/tr[";
 	    String afterPath = "]";
 	    
 	    for(int i = 1 ; i<=10 ; i++) {
 	    	
 	    	String actualName = driver.findElement(By.xpath(beforePath+i+afterPath)).getText();
 	    	 
			if(actualName.contains(Description)){
				System.out.println(actualName);
				 
			 
			
 	    };
 	    break;
		
 	    }
		return null;
 	    
	}
	public int generatedNumber(int uperbound) {
		
	Random rdn = new Random();
	return rdn.nextInt(uperbound);
			
			
		
	}
	

}
	
	//	@After
//	public void tearDown() {
//		driver.close();
//		driver.quit();
//		
//	}
	


