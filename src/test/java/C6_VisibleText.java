import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C6_VisibleText {
    public static void main(String[] args) {
        System.setProperty("Webdriver.chrome.driver", "src/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        // Add Element butonuna basin
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
        // Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButton = driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));
        if (deleteButton.isDisplayed()) {
            System.out.println("delete button is visible");
        } else {
            System.out.println("delete button is NOT visible");
        }
        // Delete tusuna basin
        deleteButton.click();
        // Add/Remove Elements ” yazisinin gorunur oldugunu test edin
        if (driver.findElement(By.xpath("//h3")).isDisplayed()) {
            System.out.println("Add/Remove Elements is visible");
        } else {
            System.out.println("Add/Remove Elements is NOT visible");
        }
    }
}
