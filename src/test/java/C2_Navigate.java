import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C2_Navigate {
    public static void main(String[] args) {
        System.setProperty("Webdriver.chrome.driver", "src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // 2. Youtube ana sayfasina gidelim . https://www.youtube.com/
        driver.get("https://www.youtube.com/");
        System.out.println(driver.getTitle());
        //3. Amazon soyfasina gidelim. https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");
        System.out.println(driver.getTitle());
        //4. Tekrar YouTube’sayfasina donelim
        driver.navigate().back();
        System.out.println(driver.getTitle());
        //5. Yeniden Amazon sayfasina gidelim
        driver.navigate().forward();
        System.out.println(driver.getTitle());
        //6. Sayfayi Refresh(yenile) yapalim
        driver.navigate().refresh();
        System.out.println(driver.getTitle());
        //7. Sayfayi kapatalim / Tum sayfalari kapatalim
        driver.quit();
    }
}
