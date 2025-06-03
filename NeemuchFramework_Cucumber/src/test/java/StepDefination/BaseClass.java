package StepDefination;

import java.util.Properties;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;


import PageObjects.AddCustomerPage;
import PageObjects.Add_NewPatient;
import PageObjects.LabwithSearchPatient;
import PageObjects.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public LoginPage loginpage;
	public AddCustomerPage acust;
	public Add_NewPatient Newpatient;
	public LabwithSearchPatient searchpatient;
	public Properties configProp;
	
	
	public String randomString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;	
	}
    public String randomNumber()
    {
	String generatedNumber=RandomStringUtils.randomNumeric(10);
	return generatedNumber; 
	
    }
    public String randomAlphaNumaric()
    {
    	String generatedString=RandomStringUtils.randomAlphabetic(3);
    	String generatedNumber=RandomStringUtils.randomNumeric(13);
		return (generatedString +"@"+generatedNumber);
    	
    }
    
    public String randomtwodigitNumber() {
        Random rand = new Random();
        int number = rand.nextInt(90) + 10; // ensures 2-digit number (10–99)
        return String.valueOf(number);
    }
 
    public String randomMobile() {
        Random rand = new Random();
        int firstDigit = rand.nextInt(4) + 6; // 6 to 9
        long remaining = 100000000L + (long)(rand.nextDouble() * 900000000L); // ensures 9 digits
        return firstDigit + String.format("%09d", remaining);
    }
}
