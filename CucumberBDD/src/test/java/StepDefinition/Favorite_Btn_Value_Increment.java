package StepDefinition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class Favorite_Btn_Value_Increment {
    WebDriver driver;
    @Given("The user is signed in to the website and is on Global page")
    public void the_user_is_signed_in_to_the_website_and_is_on_global_page() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\kisho\\Eclipse\\CucumberBDD\\src\\test\\resources\\Drivers\\chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.manage().window().maximize();
        driver.get("https://candidatex:qa-is-cool@qa-task.backbasecloud.com/");
      
    }

   @When("the user clicks the Favorite button on the article preview")
    public void the_user_clicks_the_favorite_button_on_the_article_preview() throws InterruptedException  {
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

   @Then("Favorite button value should be incremented by one")
    public void favorite_button_value_should_be_incremented_by_one() throws InterruptedException {
    	WebElement globalfeed = driver.findElement(By.xpath("/html/body/app-root/app-home-page/div/div/div/div[1]/div/ul/li[2]/a"));
    	globalfeed.click();
    	Thread.sleep(2000);
    	WebElement articlelist = driver.findElement(By.tagName("app-article-list"));
    	List<String> artlistbfclickvalue = new ArrayList<String>();
    	List<WebElement> articlepreviewlist =  articlelist.findElements(By.tagName("app-article-preview"));
    	for (WebElement webElement : articlepreviewlist) {
			WebElement btnbfcl = webElement.findElement(By.tagName("button"));
			artlistbfclickvalue.add(btnbfcl.getText());
			System.out.println(btnbfcl.getText());
			btnbfcl.click();
		}
    	Thread.sleep(2000);
    	WebElement articlelistafclick = driver.findElement(By.tagName("app-article-list"));
    	List<String> articlelistafclickvalue = new ArrayList<String>();
    	List<WebElement> articlepreviewlistafclick =  articlelistafclick.findElements(By.tagName("app-article-preview"));
    	for (WebElement webElement : articlepreviewlistafclick) {
			WebElement btnafclick = webElement.findElement(By.tagName("button"));
			articlelistafclickvalue.add(btnafclick.getText());
			System.out.println(btnafclick.getText());
		}
    
    	for (int i=0;i<articlepreviewlistafclick.size();i++) 
    	{
    		if	(artlistbfclickvalue.get(i).equals(articlelistafclickvalue.get(i)+1)) 
    		
    		{
    		System.out.println("Favourites value incremented by 1");
    		}
    	}
     }
}
