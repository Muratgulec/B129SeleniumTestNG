package techproed.utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
public class Driver {

    /*
Driver class'indaki temel mantik extends yontemiyle degil yani TestBase class'ina extent etmek yerine
Driver class'indan static methodlar kullanarak driver olustururuz.
 */
    static WebDriver driver;
    public static WebDriver getDriver() {

        /*
        Driver'i her çağırdığında yeni bir pencere açılmasının önüne geçmek için;
        if bloğu içinde Eğer driver'a değer atanmamışsa(driver doluysa) değer ata, Eğer değer atanmışsa Driver'i aynı
        sayfada RETURN et. Bunun sadece yapmamız gereken if(driver==null) kullanmak
       */

        if (driver == null) {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        }
        return driver;
    }
    public static void closeDriver(){
        driver.close();
    }


}