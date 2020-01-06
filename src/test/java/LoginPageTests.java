import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase{
    @Test
    public void loginToTrelloPositive() throws InterruptedException {

        //----Login to trello----
        WebElement loginIcon = driver.findElement(By
                .xpath("//a[@class='btn btn-sm btn-link text-white']"));
        Thread.sleep(5000);
        loginIcon.click();
        WebElement userField = driver.findElement(By.id("user"));
        userField.click();
        userField.clear();
        userField.sendKeys("okadr721@yande.ru");
        driver.findElement(By.id("login")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("password")).sendKeys("human33rt");
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(30000);
    }

    @Test
    public void loginIncorrectPassNegative() throws InterruptedException {
        //----Login to trello----
        WebElement loginIcon = driver.findElement(By
                .xpath("//a[@class='btn btn-sm btn-link text-white']"));
        Thread.sleep(5000);
        loginIcon.click();
        WebElement userField = driver.findElement(By.id("user"));
        userField.click();
        userField.clear();
        userField.sendKeys("okadr721@yandex.ru");
        driver.findElement(By.id("login")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("password")).sendKeys("marinaqaa");
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(10000);
        System.out.println("Error message: " + driver.findElement(By.xpath("//div[@id = 'login-error']/span")).getText());

    }

}
