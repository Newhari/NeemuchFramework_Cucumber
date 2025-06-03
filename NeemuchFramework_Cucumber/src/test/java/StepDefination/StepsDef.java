package StepDefination;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.Add_NewPatient;
import PageObjects.LabwithSearchPatient;
import PageObjects.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsDef extends BaseClass {

    private static Logger logger = Logger.getLogger(StepsDef.class);
    private Properties configProp;

    @Before
    public void setup() throws IOException {
        // Configure logger
        PropertyConfigurator.configure("Log4j.properties");
        logger.setLevel(Level.DEBUG);
        logger.info("Initializing setup...");

        // Load config properties
        configProp = new Properties();
        try (FileInputStream configPropFile = new FileInputStream("config.properties")) {
            configProp.load(configPropFile);
        }

        // Setup browser-specific options
        ChromeOptions chromeOptions = new ChromeOptions();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        InternetExplorerOptions ieOptions = new InternetExplorerOptions();

        HashMap<String, Integer> contentSettings = new HashMap<>();
        HashMap<String, Object> profile = new HashMap<>();
        HashMap<String, Object> prefs = new HashMap<>();
        contentSettings.put("notifications", 2); // Block notifications
        profile.put("managed_default_content_settings", contentSettings);
        prefs.put("profile", profile);
        chromeOptions.setExperimentalOption("prefs", prefs);

        String browser = configProp.getProperty("browser");

        switch (browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", 
                    "D:\\Hari prasad_Documents\\Automation_code\\eclipse\\NeemuchFramework_Cucumber\\src\\test\\resources\\drivers\\Chromedriver\\chromedriver.exe");
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", 
                    "D:\\Hari prasad_Documents\\Automation_code\\eclipse\\NeemuchFramework_Cucumber\\src\\test\\resources\\drivers\\firefoxdrivers\\geckodriver.exe");
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "ie":
                System.setProperty("webdriver.ie.driver", 
                    "D:\\Hari prasad_Documents\\Automation_code\\eclipse\\NeemuchFramework_Cucumber\\src\\test\\resources\\drivers\\Edgedriver\\msedgedriver.exe");
                driver = new InternetExplorerDriver(ieOptions);
                break;

            default:
                logger.error("Unsupported browser: " + browser);
                throw new IllegalArgumentException("Unsupported browser specified in config.properties");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("User launches the Chrome browser")
    public void user_launch_chrome_browser() {
        logger.info("Launching browser...");
        loginpage = new LoginPage(driver);
    }

    @When("User opens the URL {string}")
    public void user_opens_url(String url) {
        logger.info("Opening URL: " + url);
        driver.get(url);
        driver.manage().window().maximize();
    }

    @When("User enters the username {string}")
    public void user_enters_username(String username) {
        logger.info("Entering username...");
        loginpage.setUserName(username);
    }

    @When("User enters the password {string}")
    public void user_enters_password(String password) {
        logger.info("Entering password...");
        loginpage.setPassword(password);
    }

    @When("User enters the captcha {string}")
    public void user_enters_captcha(String captcha) {
        logger.info("Entering captcha...");
        loginpage.setCaptchaText(captcha);
    }

    @When("User clicks the login button")
    public void user_clicks_on_the_login_button() {
        logger.info("Clicking login button...");
        loginpage.setLoginButton();
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
    }

    @Then("User should see the notification alert")
    public void user_should_see_notification_alert() {
        logger.info("Notification alert handled.");
        System.out.println("Notification alert handled successfully.");
    }

    @When("User clicks on the profile icon")
    public void user_clicks_on_profile_icon() {
        logger.info("Clicking profile icon...");
        loginpage.sepProfile();
        new WebDriverWait(driver, Duration.ofSeconds(5))
            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Logout']")));
    }

    @Then("User clicks on the Logout button")
    public void user_clicks_on_logout_button() {
        logger.info("Clicking logout...");
        loginpage.setLogout();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    // ------------------- Patient Steps ------------------------

    @When("User clicks on the Lab Patient List")
    public void user_clicks_on_the_lab_patient_list() {
        logger.info("Navigating to Lab Patient List...");
        Newpatient = new Add_NewPatient(driver);
        Newpatient.openLabPatientList();
    }

    @When("User clicks on the Add button")
    public void user_clicks_on_the_add_button() {
        logger.info("Clicking Add button...");
        Newpatient.setAddbutton();
    }

    @When("User enters the patient information")
    public void user_enters_the_patient_information() {
        logger.info("Entering patient details...");
        Newpatient.setFirstName(randomString().toUpperCase());
        Newpatient.setLastName(randomString().toUpperCase());
        Newpatient.setAge(randomtwodigitNumber());
        Newpatient.setMobile(randomMobile());
        Newpatient.setPassword(randomAlphaNumaric());
        Newpatient.setEmail((randomString() + "@gmail.com").toLowerCase());
        Newpatient.selectGender("Male");
        Newpatient.selectState("Karnataka");
        Newpatient.selectLocation("Urban");
        Newpatient.selectDistrict("Bangalore Rural");
        Newpatient.setAddress("123, MG Road, Bangalore");
    }

    @When("User clicks on the Submit button")
    public void user_clicks_on_the_submit_button() {
        logger.info("Submitting patient form...");
        Newpatient.setSubmit();
    }

    // ------------------- Search & Lab Module ------------------------

    @When("User enters the patient name in the search text field")
    public void user_enters_the_patient_name_in_the_search_text_field() {
        logger.info("Searching patient...");
        searchpatient = new LabwithSearchPatient(driver);
        searchpatient.searchPatient("ramavath hariprasad");
    }

    @When("User clicks on the Search button")
    public void user_clicks_on_the_search_button() {
        logger.info("Clicking search button...");
        searchpatient.SubmitSearch();
    }

    @When("User clicks on the Add Services button")
    public void user_clicks_on_the_add_services_button() {
        logger.info("Clicking Add Services...");
        searchpatient.clickAddServices();
    }

    @When("User opens the Laboratory module")
    public void user_opens_the_laboratory_module() {
        logger.info("Opening Laboratory module...");
        searchpatient.openLaboratoryModule();
    }

    @When("User opens the Lab Sample Collection section")
    public void user_opens_the_lab_sample_collection_section() throws InterruptedException {
        logger.info("Opening Lab Sample Collection...");
        searchpatient.openLabSampleCollection();
    }

    @When("User clicks on the Sample Collection option")
    public void user_clicks_on_the_sample_collection_option() throws InterruptedException {
        logger.info("Clicking Sample Collection option...");
        searchpatient.openLabSampleCollection();
    }

    @When("User clicks on the Save Sample button")
    public void user_clicks_on_the_save_sample_button() throws InterruptedException {
        logger.info("Saving Sample...");
        searchpatient.clickSaveSample();
    }

    @When("User clicks on the Approve Sample button")
    public void user_clicks_on_the_approve_sample_button() throws InterruptedException {
        logger.info("Approving Sample...");
        searchpatient.approveSample();
    }

    @When("User opens the Test Result Entry screen")
    public void user_opens_the_test_result_entry_screen() {
        logger.info("Opening Test Result Entry...");
        searchpatient.openTestResultEntry();
    }
}

