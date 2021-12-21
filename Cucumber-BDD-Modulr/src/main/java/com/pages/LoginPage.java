package com.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private WebDriver driver;
	
	//1.By Locators
	private By emailId=By.xpath("//input[@name='username']");
	private By passWord=By.id("password-inp");
	private By signInButton=By.id("signInSubmitButton");
	private By fieldRequiredmsg=By.xpath("//div[@data-qa='error-message-div-display']");
	private By incorrectUsernamemsg=By.xpath("//div[@data-qa='signin-div-error-display']");
	private By forgotPasswordLink=By.id("forgotPasswordHref");
	private By requestresetButton=By.id("signInSubmitButton");
	private By emailsentHeading=By.id("emailSentHeading");
	private By resetUsername=By.xpath("//input[@data-qa='reset-access-prompt-inp-username']");
	
	//2.constructor of page class
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//3.Page Actions
	
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public void enterUsername(String username)
	{
		driver.findElement(emailId).sendKeys(username);
	}
	
	public void resetUsername(String username)
	{
		driver.findElement(resetUsername).sendKeys(username);
	}

	
	public void enterPassword(String password)
	{
		driver.findElement(passWord).sendKeys(password);
	}
	
	public void clickOnLogin()
	{
		driver.findElement(signInButton).click();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	}
	
	public AccountPage doLogin(String un, String pwd)
	{
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		driver.findElement(emailId).sendKeys(un);
		driver.findElement(passWord).sendKeys(pwd);
		driver.findElement(signInButton).click();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	    return new AccountPage(driver);
	}

	
	public String getFieldRequiredMsg()
	{
		return driver.findElement(fieldRequiredmsg).getText();
	}

	public String getIncorrectFieldErrorMsg()
	{
		return driver.findElement(incorrectUsernamemsg).getText();
	}
	
	public void clickOnForgotPassword()
	{
		WebElement element = driver.findElement(By.xpath("//*[@data-qa='forgotten-password-link']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		driver.findElement(forgotPasswordLink).click();
	}

	public void clickOnRequestReset()
	{
		driver.findElement(requestresetButton).click();
	}

	public String getAccountPageTitle() {
		return driver.getTitle();

	}

	public String getEmailSentText() {
		return driver.findElement(emailsentHeading).getText();

	}


	
}
