import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C1_FirstClass {
    public static void main(String[] args) {

        System.setProperty("Webdriver.chrome.driver", "src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        // Sayfa basligini(title) yazdirin
        System.out.println(driver.getTitle());
        // Sayfa basliginin “Amazon” icerdigini test edin
        if (driver.getTitle().contains("Amozon")) {
            System.out.println("title contains Amazon");
        } else {
            System.out.println("title does NOT contain Amazon");
        }
        // Sayfa adresini(url) yazdirin
        System.out.println(driver.getCurrentUrl());
        // Sayfa url’inin “amazon” icerdigini test edin.
        if (driver.getCurrentUrl().contains("amazon")) {
            System.out.println("Current Url contains amazon");
        } else {
            System.out.println("Current Url does NOT contain amazon");
        }
        // Sayfa handle degerini yazdirin
        System.out.println(driver.getWindowHandle());
        // Sayfa HTML kodlarinda “alisveris” kelimesi gectigini test edin
        if (driver.getPageSource().contains("Shopping ")) {
            System.out.println("the source contains Shopping");
        } else {
            System.out.println("the source does NOT contain Shopping");
        }
        // Sayfayi kapatin.
        driver.close();

    }
}
