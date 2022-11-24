import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C4_Locators1 {
    public static void main(String[] args) {
        System.setProperty("Webdriver.chrome.driver", "src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // a. http://a.testaddressbook.com adresine gidiniz.
        driver.get("http://a.testaddressbook.com");
        //b. Sign in butonuna basin
        driver.findElement(By.id("sign-in")).click();
        //c. email textbox,password textbox, and signin button elementlerini locate edin
        WebElement emailBox = driver.findElement(By.xpath("//input[@id='session_email']"));
        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='session_password']"));
        WebElement signinBox = driver.findElement(By.name("commit"));
        //d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign i n)buttonunu tıklayın:
            //i. Username : testtechproed@gmail.com
            //ii. Password : Test1234!
        emailBox.sendKeys("testtechproed@gmail.com");
        passwordBox.sendKeys("Test1234!");
        signinBox.click();
        //e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
            if (driver.findElement(By.linkText("Sign out")).isDisplayed()) {
                System.out.println("userId is testtechproed@gmail.com");
            } else {
                System.out.println("userId is NOT testtechproed@gmail.com");
            }

        //f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
        if (driver.findElement(By.linkText("Addresses")).isDisplayed()) {
            System.out.println("Addresses sign is displayed");
        } else {
            System.out.println("Addresses sign is NOT displayed");
        }
        if (driver.findElement(By.linkText("Sign out")).isDisplayed()) {
            System.out.println("Sign out sign is displayed");
        } else {
            System.out.println("Sign out sign is NOT displayed");
        }

        //3. Sayfada kac tane link oldugunu bulun.
        List<WebElement> linkList = driver.findElements(By.xpath("//a"));
        System.out.println(linkList.size());

    }
}
