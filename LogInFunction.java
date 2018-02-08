package newTestScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInFunction 
{
		
	public void OpenCreateCompany() throws InterruptedException
	{
		// Creating a object to call ConnectToDriver class.

		WebDriver driver;
		ConnectToDriver connect=new ConnectToDriver();
		driver=connect.ConnectChrome();
		
		//Opening and LogIn to the site.
		driver.manage().window().maximize();
		
		driver.get("https://talentcommand.com/login/");
	    driver.switchTo().frame(0);
	    driver.findElement(By.xpath("//input[@data-bind='value: Email']")).sendKeys("admin");
	    driver.findElement(By.xpath("//input[@data-bind='value: Password']")).sendKeys("Talent2017!");
	    driver.findElement(By.xpath("//button[@data-bind='click: $root.login']")).click();
	    
	    CreateCompany Obj=new CreateCompany();
	    Obj.CreateNewCompany(driver);
	   	    
	}

}
