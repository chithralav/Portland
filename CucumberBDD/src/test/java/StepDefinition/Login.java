package StepDefinition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    WebDriver driver;
  #  @Given("User should be authenticated to the website")
    public void userShouldBeAuthenticatedToTheWebsite() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\kisho\\Eclipse\\CucumberBDD\\src\\test\\resources\\Drivers\\chromedriver.exe");
    	driver = new ChromeDriver();
        driver.get("https://candidatex:qa-is-cool@qa-task.backbasecloud.com/");
        //Alert alert = driver .switchTo().alert();
        //alert.sendKeys("candidatex\ue004qa-is-cool");
        //Alert alert;
        //alert.accept();
    }

    #@And("User should be signed up for the website")
    public void userShouldBeSignedUpForTheWebsite() {
        WebElement signup = driver.findElement(By.xpath("//a[contains(text(),'Sign up')]"));
         signup.click();
         WebElement username = driver.findElement(By.xpath("//body/app-root[1]/app-auth-page[1]/div[1]/div[1]/div[1]/div[1]/form[1]/fieldset[1]/fieldset[1]/input[1]"));
        username.sendKeys("chithratest2");
        WebElement email = driver.findElement(By.xpath("//body/app-root[1]/app-auth-page[1]/div[1]/div[1]/div[1]/div[1]/form[1]/fieldset[1]/fieldset[2]/input[1]"));
        email.sendKeys("chithratest2@gmail.com");
        WebElement password = driver.findElement(By.xpath("//body/app-root[1]/app-auth-page[1]/div[1]/div[1]/div[1]/div[1]/form[1]/fieldset[1]/fieldset[3]/input[1]"));
        password.sendKeys("chithratest2");
        WebElement signupbtn = driver.findElement(By.xpath("//button[contains(text(),'Sign up')]"));
        signupbtn.click();
    }



    @When("the user sign in")
    public void theUserSignIn() {
          System.out.println("User is successfully signed in");
    }

   # @Then("Your feed page is displayed")
    public void yourFeedPageIsDisplayed() {
        WebElement urfeed = driver.findElement(By.xpath("//a[contains(text(),'Your Feed')]"));
        if (urfeed.isDisplayed())
                    System.out.println("Your feed page is successfully displayed");
        else
            System.out.println("User not successfully logged in");
    }



}
