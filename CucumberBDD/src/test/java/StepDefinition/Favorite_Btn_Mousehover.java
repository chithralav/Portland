package StepDefinition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Favorite_Btn_Mousehover {
	WebDriver driver;
	@Given("user is signed in to the website")
	public void user_is_signed_in_to_the_website() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kisho\\Eclipse\\CucumberBDD\\src\\test\\resources\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
    	driver.manage().window().maximize();
        driver.get("https://candidatex:qa-is-cool@qa-task.backbasecloud.com/");
        WebElement signin = driver.findElement(By.xpath("//a[contains(text(),'Sign in')]"));
        signin.click();
        //WebElement username = driver.findElement(By.xpath("//body/app-root[1]/app-auth-page[1]/div[1]/div[1]/div[1]/div[1]/form[1]/fieldset[1]/fieldset[1]/input[1]"));
       //username.sendKeys("chithratest2");
       WebElement email = driver.findElement(By.xpath("//body/app-root[1]/app-auth-page[1]/div[1]/div[1]/div[1]/div[1]/form[1]/fieldset[1]/fieldset[2]/input[1]"));
       email.sendKeys("chithratest2@gmail.com");
       WebElement password = driver.findElement(By.xpath("//body/app-root[1]/app-auth-page[1]/div[1]/div[1]/div[1]/div[1]/form[1]/fieldset[1]/fieldset[3]/input[1]"));
       password.sendKeys("chithratest2");
       WebElement signinbtn = driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));
       signinbtn.click();
       Thread.sleep(3000);
       WebElement urfeed = driver.findElement(By.xpath("/html/body/app-root/app-home-page/div/div/div/div[1]/div/ul/li[1]/a"));
       if (urfeed.isDisplayed())
                   {System.out.println("User is successfully signed in and Your feed page is  displayed");}
       else
           {System.out.println("User not successfully logged in");}
	}

	@When("the user is on the Global feed page and hovers over favorite button")
	public String the_user_is_on_the_global_feed_page_and_hovers_over_favorite_button() throws InterruptedException {
		WebElement globalfeed1 = driver.findElement(By.xpath("/html/body/app-root/app-home-page/div/div/div/div[1]/div/ul/li[2]/a"));
    	globalfeed1.click();
    	Thread.sleep(2000);
    	WebElement favbtn = driver.findElement(By.xpath("/html/body/app-root/app-home-page/div/div/div/div[1]/app-article-list/app-article-preview[1]/div/app-article-meta/div/app-favorite-button/button"));
    	Actions action = new Actions(driver);
    	action.moveToElement(favbtn).perform();
    	String color= favbtn.getAttribute("background-color");
    	return(color);
	}

	@Then("Favorite button background color changes")
	public void favorite_button_background_color_changes(int color) {
		System.out.println("Color of the favorite button when hovered: " );
		System.out.println(+color);
	}
}
