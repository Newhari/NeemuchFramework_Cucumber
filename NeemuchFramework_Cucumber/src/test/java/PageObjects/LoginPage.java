package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	//Locators
		@FindBy(id="username")
		WebElement txtUsername;
		
		@FindBy(id="password")
		WebElement txtPassword;
		
		@FindBy(id="captchaText")
		WebElement txtCaptcha;
		
		@FindBy(xpath="//span[contains(text(),'Login')]")
		WebElement clklgnButton;
		
		@FindBy(xpath="//img[@class='img-fluid']")
		WebElement clickProfile;
		
		@FindBy(xpath="//*[@id=\"sidenavAccordion\"]/ul/li[2]/div/a[3]")
		WebElement clickLogout;
		
		
		public void setUserName(String user) 
		{
			txtUsername.sendKeys(user);
		}
		
		public void setPassword(String Pass)
		{
			txtPassword.sendKeys(Pass);
		}
		
		public void setCaptchaText(String Captcha)
		{
			txtCaptcha.sendKeys(Captcha);
		}
		
		public boolean setLoginButton()
		{
			clklgnButton.click();
			return false;
		}
		
		public void sepProfile() {
			
		clickProfile.click();
	   }
		
		public void setLogout() {
			clickLogout.click();
		}
		}
