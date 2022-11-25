import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C8_ReviewTest {
    public static void main(String[] args) {
        System.setProperty("Webdriver.chrome.driver", "src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        // Browseri tam sayfa yapin
        driver.manage().window().maximize();
        // Sayfayi “refresh” yapin
        driver.navigate().refresh();
        // Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        if (driver.getTitle().contains("Spend less")) {
            System.out.println("Title contains Spend less");
        } else {
            System.out.println("Title does NOT contain Spend less");
        }
        // Gift Cards sekmesine basin
        driver.findElement(By.linkText("Gift Cards")).click();
        // Birthday butonuna basin
        driver.findElement(By.xpath("//a[@aria-label='Birthday gift cards']")).click();
        // Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("(//img[@alt='Amazon.com eGift Card'])[1]")).click();
        // Gift card details’den 25$’i secin
        driver.findElement(By.cssSelector("#gc-mini-picker-amount-1")).click();
        // Urun ucretinin 25.00$ oldugunu test edin
        String priceText = driver.findElement(By.xpath("//span[@class='a-color-price a-text-bold']")).getText();
        // System.out.println(priceText);

        if (priceText.equals("$25.00")) {
            System.out.println("The price is $25.00");
        } else {
            System.out.println("The price is NOT $25.00");
        }
        // Sayfayi kapatin
        driver.quit();
    }
}
