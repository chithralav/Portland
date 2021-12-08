package StepDefinition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class Favorite_Btn_Visible_All_Articles {
    WebDriver driver;
    @Given("The user is signed in to the website with username and password")
    public void the_user_is_signed_in_to_the_website_with_username_and_password() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\kisho\\Eclipse\\CucumberBDD\\src\\test\\resources\\Drivers\\chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.manage().window().maximize();
        driver.get("https://candidatex:qa-is-cool@qa-task.backbasecloud.com/");
      
    }

   @When("the user is on the Global feed page")
    public void the_user_is_on_the_global_feed_page() throws InterruptedException  {
        WebElement signin = driver.findElement(By.xpath("//a[contains(text(),'Sign in')]"));
        signin.click();
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

   @Then("Favorite should be displayed on all the articles on the page")
    public void favorite_should_be_displayed_on_all_the_articles_on_the_page() throws InterruptedException {
    	WebElement globalfeed = driver.findElement(By.xpath("/html/body/app-root/app-home-page/div/div/div/div[1]/div/ul/li[2]/a"));
    	globalfeed.click();
    	Thread.sleep(3000);
    	WebElement articlelist = driver.findElement(By.tagName("app-article-list"));
    	List<WebElement> articlepreviewlist =  articlelist.findElements(By.tagName("app-article-preview"));
    	int noofarticle = articlepreviewlist.size();
    	int nooffavbtns= 0;
    	for (WebElement webElement : articlepreviewlist) {
    		WebElement btn = webElement.findElement(By.tagName("button"));
			if (btn.isDisplayed())
					nooffavbtns++;     
			}
    	System.out.printf("Number of articles in the page %d \n", noofarticle);
       	System.out.printf("There is one corresponding favorite button for each of the article preview on the page %d \n",  nooffavbtns);
}
}
