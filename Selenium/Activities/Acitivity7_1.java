    package activities;

    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.firefox.FirefoxDriver;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.WebDriverWait;

    import java.time.Duration;

    public class Acitivity7_1 {

        public static void main(String[] args) {
            //Create a WebDriver instance, named driver, with the FirefoxDriver().
            WebDriver driver = new FirefoxDriver();
            //Open a browser with https://training-support.net/selenium/dynamic-attributes
            driver.get("https://training-support.net/selenium/dynamic-attributes");
            driver.manage().window().maximize();
            //Get the title of the page using driver.getTitle() and print out the title.
            String title = driver.getTitle();
            System.out.println("Title of the page : "+title);
            //Find the username and password input fields. Type in the credentials:
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[starts-with(@class,'username')]")));
            WebElement userName = driver.findElement(By.xpath("//input[starts-with(@class,'username')]"));
            userName.sendKeys("admin");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[starts-with(@class,'password')]")));
            WebElement password = driver.findElement(By.xpath("//input[starts-with(@class,'password')]"));
            password.sendKeys("password");
            WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
            loginButton.click();
            //Wait for login message to appear and print the login message to the console.
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation")));
           WebElement confirmation = driver.findElement(By.id("action-confirmation"));
           System.out.println("Login message : "+confirmation.getText());
            //Finally, close the browser.
            driver.quit();

        }




    }
