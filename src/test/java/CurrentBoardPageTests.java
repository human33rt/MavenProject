import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class CurrentBoardPageTests extends TestBase{
    @Test

    public void createNewList() throws InterruptedException {

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
        driver.findElement(By.id("password")).sendKeys("human33rt");
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(30000);
        //----Open 'QA 4 Auto' board
        driver.findElement(By.xpath("//div[@title='QA4 Auto']/..")).click();
        Thread.sleep(15000);
        //-----Add a new list------
        WebElement addListButton = driver.findElement(By.cssSelector(".placeholder"));
        String nameAddListButton = addListButton.getText();
        addListButton.click();
        Thread.sleep(5000);
        String str = genRandomString(7);
        //String str = "New List";
        System.out.println("Name button - " + nameAddListButton);
        if(nameAddListButton.equals("Add another list")){
            boolean exitName = false;
            System.out.println("Size-" + driver.findElements(By.xpath("//h2/../textarea")).size());
            for(WebElement element: driver.findElements(By.xpath("//h2/../textarea"))){
                System.out.println("Name - " + element.getText());
                if(element.getText().equals(str)) exitName = true;
            }
            if(exitName) str = stringWithRandomNumber(1000,str);
        }

        driver.findElement(By.cssSelector(".list-name-input"))
                .sendKeys(str);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        //System.out.println("name of the list - " + genRandomString(5));
        Thread.sleep(5000);

    }

    @Test
    public void addFirstCardInNewList() throws InterruptedException {

        //----Login to trello----
        WebElement loginIcon = driver.findElement(By
                .xpath("//a[@class='btn btn-sm btn-link text-white']"));
        Thread.sleep(5000);
        loginIcon.click();
        WebElement userField = driver.findElement(By.id("user"));
        userField.click();
        userField.clear();
        userField.sendKeys("marinaqatest2019@gmail.com");
        driver.findElement(By.id("login")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("password")).sendKeys("marinaqa");
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(30000);
        //----Open 'QA 4 Auto' board
        driver.findElement(By.xpath("//div[@title='QA4 Auto']/..")).click();
        Thread.sleep(15000);
        //-----Add a new list------
        driver.findElement(By.cssSelector(".placeholder")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".list-name-input"))
                .sendKeys("New List");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(3000);

        //----Add a first card for any new list
        driver.findElements(By.xpath("//span[@class='js-add-a-card']")).get(0).click();
        Thread.sleep(3000);
        driver.findElement(By
                .xpath("//textarea[@placeholder='Enter a title for this card…']")).sendKeys("text");
        driver.findElement(By
                .xpath("//input[@class='primary confirm mod-compact js-add-card']")).click();
        Thread.sleep(5000);


    }

    @Test
    public void CopyOfListCreated() throws InterruptedException {

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
        driver.findElement(By.id("password")).sendKeys("TRACK611");
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(20000);
        //----Open 'QA 4 Auto' board
        driver.findElement(By.xpath("//div[@class='board-tile-details-name']//div[contains(text(),'QA4 AUTO')]")).click();
        Thread.sleep(8000);
        //-----Add a new list------
        driver.findElement(By.cssSelector(".placeholder")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".list-name-input"))
                .sendKeys("New List");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@class='list-header-extras-menu dark-hover js-open-list-menu icon-sm icon-overflow-menu-horizontal']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@class='js-copy-list']")).click();
        int quantityOfLists = driver
                .findElements(By.xpath("//h2")).size();
        Assert.assertEquals(quantityOfLists,1);
        driver.findElement(By.xpath("//div[@class='list-header js-list-header u-clearfix is-menu-shown is-subscribe-shown']//div[@class='list-header-extras']")).click();
        Thread.sleep(3000);

    }

    public static String genRandomString(int num){
        String str = "";
        int number;
        Random gen = new Random();
        for(int i=0; i<num; i++){
            number = '!' + gen.nextInt('z' - '!' +1);
            str = str + (char)number;
        }
        return str;
    }

    public static String stringWithRandomNumber(int num,String str){
        Random gen = new Random();
        return str + gen.nextInt(num);
    }
}
