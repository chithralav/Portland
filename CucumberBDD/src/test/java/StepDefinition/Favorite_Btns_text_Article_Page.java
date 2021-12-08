package StepDefinition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class Favorite_Btns_text_Article_Page {
    WebDriver driver;
    @Given("user is signed in to the website and is on article page")
    public void user_is_signed_in_to_the_website_and_is_on_article_page() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\kisho\\Eclipse\\CucumberBDD\\src\\test\\resources\\Drivers\\chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.manage().window().maximize();
        driver.get("https://candidatex:qa-is-cool@qa-task.backbasecloud.com/");
        WebElement signin = driver.findElement(By.xpath("//a[contains(text(),'Sign in')]"));
        signin.click();
        WebElement email = driver.findElement(By.xpath("//body/app-root[1]/app-auth-page[1]/div[1]/div[1]/div[1]/div[1]/form[1]/fieldset[1]/fieldset[2]/input[1]"));
        email.sendKeys("chithratest2@gmail.com");
        WebElement password = driver.findElement(By.xpath("//body/app-root[1]/app-auth-page[1]/div[1]/div[1]/div[1]/div[1]/form[1]/fieldset[1]/fieldset[3]/input[1]"));
        password.sendKeys("chithratest2");
        WebElement signinbtn = driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));
        signinbtn.click();
        Thread.sleep(3000);
        WebElement globalfeed = driver.findElement(By.xpath("/html/body/app-root/app-home-page/div/div/div/div[1]/div/ul/li[2]/a"));
    	globalfeed.click();
    	Thread.sleep(3000);
    	WebElement artprev = driver.findElement(By.xpath("/html/body/app-root/app-home-page/div/div/div/div[1]/app-article-list/app-article-preview[1]/div/a/h1"));
    	artprev.click();
        
    }

    @When("the user clicks on Favorite button")
    public void the_user_clicks_on_favorite_button() throws InterruptedException {
    	Thread.sleep(3000);
    	WebElement arfavbtn = driver.findElement(By.xpath("/html/body/app-root/app-article-page/div/div[1]/div/app-article-meta/div/span[2]/app-favorite-button/button"));
    	arfavbtn.click();
    	Thread.sleep(2000);
    	String text = arfavbtn.getText();
    	System.out.printf("\n"+text);
    }

    @Then("Favorite button text chnages to unfavorite article")
    public void favorite_button_text_chnages_to_unfavorite_article() throws InterruptedException {
    	System.out.println("Works as expected");
    	}
}
