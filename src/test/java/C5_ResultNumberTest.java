import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C5_ResultNumberTest {
    public static void main(String[] args) {
        System.getProperty("Webdriver.chrome.driver", "");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // a. google web sayfasına gidin. https://www.amazon.com
        driver.get("https://www.amazon.com");
        // b. Search(ara) “city bike”
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("city bike" + Keys.ENTER);
        // c. Amazon 'da görüntülenen ilgili sonuçların sayısını yazdırın
        WebElement resultText= driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        List<String> resultTestList = List.of(resultText.getText().split(" "));
        String number = resultTestList.get(2).replaceAll(" ", "");
        System.out.println(number);

        // d. Sonra karşınıza çıkan ilk sonucun resmine tıklayın.
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();

        //  Different XPath options
        //      (//img[@class='s-image'])[1]
        //      img[@class='s-image']
        //      //img
        //      //*[@class='s-image']
        //      //img[@*='s-image']
        //      //img[@class]

        //      img[.='s-image']
        //      *[.='s-image']
        //      *[text()='exact text']
        //      img[@class='s-image']

        // driver.close();
    }
}
