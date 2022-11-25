import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C7_CssLocators {
    public static void main(String[] args) {
        System.setProperty("Webdriver.chrome.driver", "src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // a. Verilen web sayfasına gidin. http://a.testaddressbook.com/sign_in
        driver.get("http://a.testaddressbook.com/sign_in");
        // b. Locate email textbox
        WebElement emailTextbox = driver.findElement(By.cssSelector("input[type='email']"));
        // c. Locate password textbox ve
        WebElement passwordTextbox = driver.findElement(By.cssSelector("input[id='session_password']"));
        //   input[id='session_password'] == #session_password   ---> only for id
        // d. Locate signin button
        WebElement signinButton = driver.findElement(By.cssSelector("input[name='commit']"));
        // e. Asagidaki kullanıcı adını ve şifreyi girin ve sign in düğmesini tıklayın
            // i. Username : testtechproed@gmail.com
            // ii. Password : Test1234!
        emailTextbox.sendKeys("testtechproed@gmail.com");
        passwordTextbox.sendKeys("Test1234!");
        signinButton.click();
        driver.close();
    }
}
