import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Andrey\\IdeaProjects\\MavenProject\\libs\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();

        driver = new ChromeDriver();
        //===========Enter to Trello====
        driver.get("https://trello.com/");
        driver.manage().window().fullscreen();
        Thread.sleep(5000);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
