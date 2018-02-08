package newTestScript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConnectToDriver 
{
	WebDriver driver;

	public WebDriver ConnectChrome() 
	{
		
	System.setProperty("webdriver.chrome.driver","E:\\MyNewProject\\drivers\\chromedriver_win32\\chromedriver.exe");
	driver= new ChromeDriver();
	return driver;
	
	}
	public WebDriver ConnectFirefo() 
	{
		
		System.setProperty("webdriver.chrome.driver","E:\\MyNewProject\\drivers\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		return driver;
			
	}
	public WebDriver ConnectIE() 
	{
		
		System.setProperty("webdriver.chrome.driver","E:\\MyNewProject\\drivers\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		return driver;
		
	}
}
