package PageObjects;



import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import StepDefination.BaseClass;


public class Add_NewPatient extends BaseClass {
    WebDriver driver;
    WebDriverWait wait;

    public Add_NewPatient(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "//span[contains(text(),'Lab Patient List')]")
    WebElement labPatientListLink;

    @FindBy(xpath = "//button[contains(@class,'btn btn-blue')]")
    WebElement Addbutton;

    @FindBy(xpath = "//input[@formcontrolname='first_name']")
    WebElement txtFirstName;

    @FindBy(xpath = "//input[@formcontrolname='last_name']")
    WebElement txtLastName;

    @FindBy(xpath = "//input[@formcontrolname='age']")
    WebElement txtAge;

    @FindBy(xpath = "//input[@formcontrolname='mobile']")
    WebElement txtMobile;

    @FindBy(xpath = "//input[@formcontrolname='password']")
    WebElement txtPassword;

    @FindBy(xpath = "//input[@formcontrolname='email']")
    WebElement txtEmail;

    @FindBy(xpath = "//select[@formcontrolname='gender_id']")
    WebElement selGender;

    @FindBy(xpath = "//select[@formcontrolname='state_id']")
    WebElement selState;

    @FindBy(xpath = "//select[@formcontrolname='location_type_id']")
    WebElement selLocation;

    @FindBy(xpath = "//select[@formcontrolname='district_id']")
    WebElement selDistrict;

    @FindBy(xpath = "//input[@formcontrolname='address']")
    WebElement txtAddress;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement clkSubmit;

    public void openLabPatientList() {
        wait.until(ExpectedConditions.elementToBeClickable(labPatientListLink)).click();
    }

    public void setAddbutton() {
        wait.until(ExpectedConditions.elementToBeClickable(Addbutton)).click();
    }

    public void setFirstName(String fName) {
        txtFirstName.sendKeys(fName);
    }

    public void setLastName(String lName) {
        txtLastName.sendKeys(lName);
    }

    public void setAge(String age) {
        txtAge.sendKeys(age);
    }

    public void setMobile(String mobile) {
        txtMobile.sendKeys(mobile);
    }

    public void setPassword(String password) {
        txtPassword.sendKeys(password);
    }

    public void setEmail(String email) {
        txtEmail.sendKeys(email);
    }

    public void selectGender(String genderText) {
        new Select(selGender).selectByVisibleText(genderText);
    }

    public void selectState(String stateText) {
        new Select(selState).selectByVisibleText(stateText);
    }

    public void selectLocation(String locationText) {
        new Select(selLocation).selectByVisibleText(locationText);
    }

    public void selectDistrict(String districtText) {
        new Select(selDistrict).selectByVisibleText(districtText);
    }

    public void setAddress(String address) {
        txtAddress.sendKeys(address);
    }

    public void setSubmit() {
        clkSubmit.click();
    }
}