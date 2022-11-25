import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C9_RelativeLocators {
    public static void main(String[] args) {
        System.setProperty("Webdriver.chrome.driver", "src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
        // https://www.diemol.com/selenium-4-demo/relative-locators-demo.html adresine gidin
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");
        // Berlin’i 3 farkli relative locator ile locate edin
        WebElement boston = driver.findElement(By.cssSelector("#pid6_thumb"));
        WebElement nYC = driver.findElement(By.cssSelector("#pid3_thumb"));
        WebElement bayArea = driver.findElement(By.cssSelector("#pid8_thumb"));
        WebElement berlin = driver.findElement(By.cssSelector("#pid7_thumb"));

        WebElement berlin1 = driver.findElement(with(By.id("pid7_thumb")).toLeftOf(bayArea));
        WebElement berlin2 = driver.findElement(with(By.className("ui-li-thumb")).toRightOf(boston));
        WebElement berlin3 = driver.findElement(with(By.id("pid7_thumb")).below(nYC));
        // Relative locator’larin dogru calistigini test edin
        String berlinSrcDomAttribute = berlin.getDomAttribute("src");
        System.out.println(berlinSrcDomAttribute);
        String berlin1SrcDomAttribute = berlin1.getDomAttribute("src");
        System.out.println(berlin1SrcDomAttribute);
        String berlin2SrcDomAttribute = berlin2.getDomAttribute("src");
        System.out.println(berlin2SrcDomAttribute);
        String berlin3SrcDomAttribute = berlin3.getDomAttribute("src");
        System.out.println(berlin3SrcDomAttribute);
        if (berlinSrcDomAttribute.contains(berlin1SrcDomAttribute)) {
            System.out.println("berlin1 relative locator is correct");
        } else {
            System.out.println("berlin1 relative locator is NOT correct");
        }

        if (berlinSrcDomAttribute.contains(berlin2SrcDomAttribute)) {
            System.out.println("berlin2 relative locator is correct");
        } else {
            System.out.println("berlin2 relative locator is NOT correct");
        }

        if (berlinSrcDomAttribute.contains(berlin3SrcDomAttribute)) {
            System.out.println("berlin3 relative locator is correct");
        } else {
            System.out.println("berlin3 relative locator is NOT correct");
        }
    }
}
