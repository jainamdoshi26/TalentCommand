package newTestScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateCompany {
	
	public void CreateNewCompany(WebDriver driver) throws InterruptedException
	{

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
	    
//	    Click on Add Company button.
	    
	    driver.findElement(By.xpath("//div//input[@value='Add Company']")).click();

	    Thread.sleep(1000);

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

	}

}
