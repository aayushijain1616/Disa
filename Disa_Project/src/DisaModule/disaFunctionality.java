package DisaModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class disaFunctionality extends initiateDisa
{
	
	String clientName = "michelle199626";
	String clientPassword = "password1";
	String expectedPageTitle = "DISA Works";
	String expectedLoginPage = "Dashboard";
	
	@Test
	public boolean disaLogin() throws Exception
	{
		boolean result = false;
		
		boolean result1 = disaMainPage();
		System.out.println("The value of result1 is: "+result1);
		
		boolean result2 = loginUsingClientUser();
		System.out.println("The value of result2 is: "+result2);
		
		
		if (result1 && result2)
		{
			result = true;
		}
		else
		{
			result = false;
		}
		
		return result;
	}
	
	
	
	
	public boolean disaMainPage()
	{
		boolean result = false;
		String actualPageTitle;
		 
		actualPageTitle = driver.getTitle();
		System.out.println("Page title: "+actualPageTitle);
		
		if (actualPageTitle.equalsIgnoreCase(expectedPageTitle))
		{
			result = true;
		}
		else
		{
			result = false;
		}
		
		return result;
	}
	
	
	
	public boolean loginUsingClientUser() throws Exception
	{
		
		boolean result = false;
		
		WebElement email = driver.findElement(By.xpath("//input[@id='username']"));
		email.sendKeys(clientName);
		
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys(clientPassword);
		
		WebElement submit = driver.findElement(By.xpath("//button[@id='btnLogin']"));
		submit.click();
		
		Thread.sleep(10000);
		
		WebElement actualPage = driver.findElement(By.xpath("//h1[@class='pull-left']"));
		String actualLoginPage = actualPage.getText();
		System.out.println("Page title text is: "+actualLoginPage);
		
		if (actualLoginPage.equalsIgnoreCase(expectedLoginPage))
		{
			result = true;
		}
		else
		{
			result = false;
		}
		
		return result;
		
	}

}
