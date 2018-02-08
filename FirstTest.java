package newTestScript;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
//import com.gargoylesoftware.htmlunit.javascript.host.Iterator;
//import com.gargoylesoftware.htmlunit.javascript.host.Set;


public class FirstTest {

	public static void main(String[] args) throws InterruptedException, Exception 
	{
		//TODO Auto-generated method stub
		//System.out.print("Hi");
		//WebDriverWait wait = new WebDriverWait(driver,30);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-bind='click: $root.login']")));
		
		System.setProperty("webdriver.chrome.driver","E:\\MyNewProject\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://talentcommand.com/login/");
	    
		driver.switchTo().frame(0);
	    
		driver.findElement(By.xpath("//input[@data-bind='value: Email']")).sendKeys("admin");
	    driver.findElement(By.xpath("//input[@data-bind='value: Password']")).sendKeys("Talent2017!");
	    driver.findElement(By.xpath("//button[@data-bind='click: $root.login']")).click();
	       
	    Actions actions = new Actions(driver);
	    
	    WebDriverWait wait = new WebDriverWait(driver, 20);
	    
	   	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Administration') and @class='drop-toggle']")));
	   	Thread.sleep(10000);
	    actions.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Administration') and @class='drop-toggle']"))).click().perform();
	    Thread.sleep(2000);
	    actions.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Administration') and @class='drop-toggle']/following::li[1]/a[contains(text(),'Company')]"))).click().perform();
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//button[contains(text(),'New Company') and @class='btn btn-primary']")));
	   	
	    Thread.sleep(10000);
	    
	    driver.findElement(By.xpath("//div//button[contains(text(),'New Company') and @class='btn btn-primary']")).click();
	    
	    Thread.sleep(5000);
	    
	    driver.findElement(By.xpath("//div//input[@name='accountNumber']")).sendKeys("TalentCommand");
	    driver.findElement(By.xpath("//div//input[@name='regionID']")).sendKeys("Talent123");
	    driver.findElement(By.xpath("//div//input[@name='companyName']")).sendKeys("TalentCommand");
	    driver.findElement(By.xpath("//div//select[@name='OnboardingType']//option[2]")).click();
	    driver.findElement(By.xpath("//div//button[@class='multiselect dropdown-toggle btn btn-default']")).click();
	    driver.findElement(By.xpath("//ul//li[3]//a//label[contains(text(),'Support User')]")).click();
	    
	    driver.findElement(By.xpath("//div//input[@value='Add Company']")).click();

	    Thread.sleep(1500);

	    if(driver.findElements(By.xpath("//span[text()='Client ID already exist']")).size()!=0) 
	    {
	    	driver.findElement(By.xpath("//div//input[@value='Cancel']")).click();
	    	System.out.println("It is allready created!");
	    }
	    
	    Thread.sleep(1000);
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//label//input[@aria-controls='navigationItems']")));
	    
	    driver.findElement(By.xpath("//div//label//input[@aria-controls='navigationItems']")).sendKeys("TalentCommand");
	    
	    if(driver.findElement(By.xpath("//div[@id='navigationItems_wrapper']//table//tbody//tr//td[text()='Talent123']")).isDisplayed()) 
	    {
	    	System.out.println("Company found in the grid.");
	    }
	    else
	    {
	    	System.out.println("Somthing went wrong");
	    }
	    
	    actions.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Administration') and @class='drop-toggle']"))).click().perform();
	    Thread.sleep(2000);
	    actions.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Administration') and @class='drop-toggle']/following::li/a[contains(text(),'User') and @href='/User']"))).click().perform();
	    
//	    Company Name dropdown
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//a//span[@class='select2-chosen']")));
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//div//a//span[@class='select2-chosen']")).click();
	    System.out.println("Company Dropdown working fine");

//	    Search Company			
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//div//input[@id='s2id_autogen1_search']")).sendKeys("TalentCommand");;
	    driver.findElement(By.xpath("//div[@class='select2-result-label']")).click();
	    System.out.println("Select Company working fine");
	    
//	    New User
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//div//button[@id='new-user']")).click();
	    System.out.println("New user button working fine");

//	    Legal First Name
	    driver.findElement(By.xpath("//div//input[@data-bind='value: Person().FirstName']")).sendKeys("Alex");
	    System.out.println("First Name working fine");

//	    Last Name	
	    driver.findElement(By.xpath("//div//input[@data-bind='value:Person().LastName']")).sendKeys("Johnson");
	    System.out.println("Last Name working fine");

//	    SSN Name
	    driver.findElement(By.xpath("//div//input[@id='SSN-number']")).sendKeys("162589568");
	    System.out.println("SSN working fine");

//	    Date of Birth
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//input[@id='date-of-birth']")).click();
	    //driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")).click();
	    driver.findElement(By.xpath("//select[@class='ui-datepicker-year']//option[@value='1995']")).click();
	    driver.findElement(By.xpath("//select[@class='ui-datepicker-month']//option[2]")).click();
	    driver.findElement(By.xpath("//a[@class='ui-state-default' and contains(text(),'26')]")).click();
	    System.out.println("Date of Birth working fine");
	    
	    File src=new File("C:\\Desktop");
	    
	    FileInputStream fls=new FileInputStream(src);	
	    
	    XSSFWorkbook wb=new XSSFWorkbook(fls);
	    
	    XSSFSheet sheet1=wb.getSheetAt(0);
	    
	    String data0=sheet1.getRow(0).getCell(0).getStringCellValue();
	    
	    System.out.println("The data of 1st cell:"+data0);

	}

}
