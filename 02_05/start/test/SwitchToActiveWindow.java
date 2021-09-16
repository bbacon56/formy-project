import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchToActiveWindow {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/switch-window");

        WebElement newTabButton = driver.findElement(By.id("new-tab-button"));
        newTabButton.click();

        // sets first handle on page that driver is currently focused on ie first page opened
        String originalHandle = driver.getWindowHandle();

        // iterates through handles currently open and switches to new window
        for(String handle1: driver.getWindowHandles()) {
            driver.switchTo().window(handle1);
        }

        Thread.sleep(1000);
        // switches back to original window
        driver.switchTo().window(originalHandle);

        Thread.sleep(1000);
        driver.quit();
    }
}
