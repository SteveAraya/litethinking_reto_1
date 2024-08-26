package demoblaze;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoblazeTest {

    WebDriver driver;

    private static final By PHONES_CATEGORY_SELECTOR = By.xpath("//a[@onclick = \"byCat('phone')\"]");
    private static final By LAPTOPS_CATEGORY_SELECTOR = By.xpath("//a[@onclick = \"byCat('notebook')\"]");
    private static final By MONITORS_CATEGORY_SELECTOR = By.xpath("//a[@onclick = \"byCat('monitor')\"]");

    private static final By PHONE_SAMSUNG_SELECTOR = By.xpath("//a[text() = 'Samsung galaxy s6']");
    private static final By PHONE_NOKIA_SELECTOR = By.xpath("//a[text() = 'Nokia lumia 1520']");
    private static final By LAPTOP_SONY_SELECTOR = By.xpath("//a[text() = 'Sony vaio i5']");
    private static final By LAPTOP_MACBOOK_SELECTOR = By.xpath("//a[text() = 'MacBook air']");
    private static final By MONITOR_ASUS_SELECTOR = By.xpath("//a[text() = 'ASUS Full HD']");
    
    private static final By PRICE_CONTAINER_SELECTOR = By.xpath("//h3[@class = 'price-container']");

    @BeforeEach
    public void configDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://demoblaze.com/");
    }

    @Test
    public void validateCategories() {
        assertTrue(driver.findElement(PHONES_CATEGORY_SELECTOR).isDisplayed(), "Phones category not found.");
        assertTrue(driver.findElement(LAPTOPS_CATEGORY_SELECTOR).isDisplayed(), "Laptops category not found.");
        assertTrue(driver.findElement(MONITORS_CATEGORY_SELECTOR).isDisplayed(), "Monitors category not found.");
    }

    @Test
    public void searchPhone() throws InterruptedException {
        String samsungPrice = "$360";
        String nokiaPrice = "$820";

        WebElement phonesCategory = driver.findElement(PHONES_CATEGORY_SELECTOR);
        phonesCategory.click();

        assertTrue(driver.findElement(PHONE_SAMSUNG_SELECTOR).isDisplayed(), "Samsung phone not found.");
        WebElement phoneSumsung = driver.findElement(PHONE_SAMSUNG_SELECTOR);
        phoneSumsung.click();
        assertTrue(driver.getCurrentUrl().contains("/prod.html"), "URL not found.");
        WebElement phoneSumsungPrice = driver.findElement(PRICE_CONTAINER_SELECTOR);
        assertTrue(phoneSumsungPrice.getText().contains(samsungPrice));
        Thread.sleep(2000);
        driver.navigate().back();
        
        assertTrue(driver.findElement(PHONE_NOKIA_SELECTOR).isDisplayed(), "Nokia phone not found.");
        WebElement phoneNokia = driver.findElement(PHONE_NOKIA_SELECTOR);
        phoneNokia.click();
        assertTrue(driver.getCurrentUrl().contains("/prod.html"), "URL not found.");
        WebElement phoneNokiaPrice = driver.findElement(PRICE_CONTAINER_SELECTOR);
        assertTrue(phoneNokiaPrice.getText().contains(nokiaPrice));
        Thread.sleep(2000);
    }

    @Test
    public void searchLaptop() throws InterruptedException {
        String sonyPrice = "$790";
        String macbookPrice = "$700";

        WebElement laptopsCategory = driver.findElement(LAPTOPS_CATEGORY_SELECTOR);
        laptopsCategory.click();

        assertTrue(driver.findElement(LAPTOP_SONY_SELECTOR).isDisplayed(), "Sony laptop not found.");
        WebElement laptopSony = driver.findElement(LAPTOP_SONY_SELECTOR);
        laptopSony.click();
        assertTrue(driver.getCurrentUrl().contains("/prod.html"), "URL not found.");
        WebElement laptopSonyPrice = driver.findElement(PRICE_CONTAINER_SELECTOR);
        assertTrue(laptopSonyPrice.getText().contains(sonyPrice));
        Thread.sleep(2000);
        driver.navigate().back();
        
        assertTrue(driver.findElement(LAPTOP_MACBOOK_SELECTOR).isDisplayed(), "Macbook laptop not found.");
        WebElement laptopMacbook = driver.findElement(LAPTOP_MACBOOK_SELECTOR);
        laptopMacbook.click();
        assertTrue(driver.getCurrentUrl().contains("/prod.html"), "URL not found.");
        WebElement laptopMacbookPrice = driver.findElement(PRICE_CONTAINER_SELECTOR);
        assertTrue(laptopMacbookPrice.getText().contains(macbookPrice));
        Thread.sleep(2000);
    }

    @Test
    public void searchMonitor() throws InterruptedException {
        String asusPrice = "$230";

        WebElement monitorsCategory = driver.findElement(MONITORS_CATEGORY_SELECTOR);
        monitorsCategory.click();

        assertTrue(driver.findElement(MONITOR_ASUS_SELECTOR).isDisplayed(), "Asus monitor not found.");
        WebElement monitorAsus = driver.findElement(MONITOR_ASUS_SELECTOR);
        monitorAsus.click();
        assertTrue(driver.getCurrentUrl().contains("/prod.html"), "URL not found.");
        WebElement monitorAsusPrice = driver.findElement(PRICE_CONTAINER_SELECTOR);
        assertTrue(monitorAsusPrice.getText().contains(asusPrice));
        Thread.sleep(2000);
    }

    @AfterEach
    public void teardown(){
        driver.close();
    } 
    
}
