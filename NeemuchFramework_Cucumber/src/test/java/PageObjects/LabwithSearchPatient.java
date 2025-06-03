package PageObjects;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LabwithSearchPatient {
	 WebDriver driver;
	    WebDriverWait wait;
	    JavascriptExecutor js=(JavascriptExecutor)driver;

	    public LabwithSearchPatient(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        PageFactory.initElements(driver, this);
	    }

     @FindBy(id = "search_string")
     WebElement searchBox;

     @FindBy(xpath = "//button[@value='Submit']")
     WebElement submitButton;
     
     @FindBy(xpath = "//*[@id=\"patientTable\"]/tbody/tr[1]/td[11]/button[1]")
     WebElement addServicesButton;

     @FindBy(xpath = "//a[@href='#m-24']")
     WebElement laboratoryModuleLink;

     @FindBy(xpath = "//span[contains(text(),'Lab Sample Collection')]")
     WebElement labSampleCollectionLink;

     @FindBy(xpath = "//*[@id=\"DataTables_Table_1\"]/tbody/tr[1]/td[13]/button")
     WebElement sampleCollectionButton;

     @FindBy(xpath = "//button[contains(text(),'Save')]")
     WebElement saveButton;

     @FindBy(xpath = "//button[contains(text(),'Approved')]")
     WebElement approveButton;

     @FindBy(xpath = "//span[contains(text(),'Test Result Entry')]")
     WebElement testResultEntryLink;
     
//Actions
     public void searchPatient(String patientName) {
         wait.until(ExpectedConditions.visibilityOf(searchBox)).clear();
         searchBox.sendKeys(patientName);
     }
public void SubmitSearch() {
	wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
}
public void clickAddServices() {
    wait.until(ExpectedConditions.elementToBeClickable(addServicesButton)).click();
}

public void openLaboratoryModule() {
    wait.until(ExpectedConditions.elementToBeClickable(laboratoryModuleLink)).click();
}

public void openLabSampleCollection() throws InterruptedException {
    wait.until(ExpectedConditions.elementToBeClickable(labSampleCollectionLink)).click();
    Thread.sleep(2000);
}

public void clickSampleCollection() throws InterruptedException {
    wait.until(ExpectedConditions.elementToBeClickable(sampleCollectionButton)).click();
    Thread.sleep(3000);
}

public void clickSaveSample() throws InterruptedException {
    wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    js.executeScript("window.scrollBy(0, 500)");
    Thread.sleep(3000);
}

public void approveSample() throws InterruptedException {
    wait.until(ExpectedConditions.elementToBeClickable(approveButton)).click();
    try {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    } catch (NoAlertPresentException e) {
        System.out.println("No alert present after approving sample.");
        Thread.sleep(2000);
    }
}

public void openTestResultEntry() {
    wait.until(ExpectedConditions.elementToBeClickable(testResultEntryLink)).click();
}
}
