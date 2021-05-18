package orangehrmsite;
/*Homework – 4
https://opensource-demo.orangehrmlive.com/
( Username : Admin | Password : admin123 )
Enter username
Enter password
Click login
Verify that the text “Welcome Paul”
After Paul one symbol there so click on symbol for logout.
Verify that the below text.
LOGIN Panel
*/

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HomeWork4 {
    WebDriver driver;
    @Before
    public void goToOrangeWebsiteAndLaunch(){
        String url = "https://opensource-demo.orangehrmlive.com/";
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get(url);
    }
    @Test
    public void enterUserNameAndPassword(){
    driver.findElement(By.id("txtUsername")).sendKeys("Admin");
    driver.findElement(By.id("txtPassword")).sendKeys("admin123");
    driver.findElement(By.id("btnLogin")).click();
    driver.findElement(By.id("welcome")).click();
    String expectedWelcomeMessage = "Hey Welcome Paul";
    WebElement welcomeMessage = driver.findElement(By.id("welcome"));
    String actualWelcomeMessage = welcomeMessage.getText();
    Assert.assertEquals("Welcome Message Is Correct,User has Loggedin Successfully",expectedWelcomeMessage,actualWelcomeMessage);

    driver.findElement(By.xpath("//a[text()='Logout']")).click();
    }
    @Test
    public void verifyMessageAfterLogOUT(){
        String expectedLogoutPageText = "LOGINN Panel";
        WebElement logOutPanel = driver.findElement(By.id("logInPanelHeading"));
        String actualLogoutPanelMessage = logOutPanel.getText();
        Assert.assertEquals("User Loggedout Successfully",expectedLogoutPageText,actualLogoutPanelMessage);
    }
    @After
    public  void tearDown(){
        driver.quit();
    }

}
