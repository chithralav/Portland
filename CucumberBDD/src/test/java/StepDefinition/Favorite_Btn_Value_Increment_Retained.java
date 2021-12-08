package StepDefinition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


public class Favorite_Btn_Value_Increment_Retained {
    WebDriver driver;
    @Given("user is signed in to the website and is on Global page")
    public void user_is_signed_in_to_the_website_and_is_on_global_page() throws InterruptedException {
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
    
    @When("user clicks the Favorite button on the article preview")
    public void user_clicks_the_favorite_button_on_the_article_preview() throws InterruptedException  {
       
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
    }
    	@When("the user clicks on Global feed to refresh the page")
    	public void the_user_clicks_on_global_feed_to_refresh_the_page() throws InterruptedException {
    	
    		WebElement globalfeed1 = driver.findElement(By.xpath("/html/body/app-root/app-home-page/div/div/div/div[1]/div/ul/li[2]/a"));
        	globalfeed1.click();
        	Thread.sleep(2000);
        	WebElement articlelistafrefresh = driver.findElement(By.tagName("app-article-list"));
        	List<String> articlelistafrefreshvalue = new ArrayList<String>();
        	List<WebElement> articlepreviewlistafrefresh =  articlelistafrefresh.findElements(By.tagName("app-article-preview"));
        	for (WebElement webElement1 : articlepreviewlistafrefresh) {
    			WebElement btnafrefresh = webElement1.findElement(By.tagName("button"));
    			articlelistafrefreshvalue.add(btnafrefresh.getText());
    			System.out.println(btnafrefresh.getText());
    			
    		}
    	}
        	
        	@Then("Favorite button incremented value should be retained")
        	public void favorite_button_incremented_value_should_be_retained() {
        		
        		for (int i=0;i<articlelistafrefreshvalue.size();i++) 
        	    {
        		if(artlistbfclickvalue.get(i).equals(articlelistafrefreshvalue.get(i)))
        		{
        			System.out.println("Favourites value not retained");
        			break;
        			}
        	     }
    	    }
        	
    }

