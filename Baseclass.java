package task;


    import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.lang.annotation.Target;
	import java.text.SimpleDateFormat;
	import java.time.Duration;
	import java.util.Date;
	import java.util.Set;

	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxBinary;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class Baseclass {

	//public static WebDriver driver; // creating static WebDriver driver to use outside the method
	public static WebDriver driver;
	public static WebDriver chromebrowser() {
	WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	return driver;
	}
	// assigning webDriver driver as static method outside the method


	public static void urlLaunch(String Url) {
	driver.get(Url);
	driver.manage().window().maximize();
	}


	public static void implicitlyWait(int a) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(a));
	}

	public static void sendkeys(WebElement e, String value) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	e.sendKeys(value);
	}


	public static void click(WebElement b) {
	b.click();
	}

	public static String getCurrentUrl() {
	String currentUrl = driver.getCurrentUrl();
	return currentUrl;
	}

	public static void quit() {
	driver.quit();
	}

	public static String getText(WebElement a) {
	String text = a.getText();
	return text;
	}

	public static String getAttribute(WebElement b) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	String attribute = b.getAttribute("value");
	return attribute;
	}

	public static void movetoElement(WebElement c) {
	Actions a = new Actions(driver);
	a.moveToElement(c).perform();
	}

	public static void dragandDrop(WebElement source, WebElement target) {
	Actions b = new Actions(driver);
	b.dragAndDrop(source, target).perform();
	}

	public static void rightclick(WebElement d) {
	Actions c = new Actions(driver);
	c.contextClick(d).perform();
	}

	public static WebElement findElement(String locator, String value) {
	WebElement element = null;
	if(locator.equalsIgnoreCase("id")) {
	element = driver.findElement(By.id(value));
	}
	else if(locator.equalsIgnoreCase("name")) {
	element = driver.findElement(By.name(value));
	}
	else if(locator.equalsIgnoreCase("xpath")) {
	element = driver.findElement(By.xpath(value));
	}
	return element;
	}

	public static void windowHandle(int a) {
	Set<String> allId = driver.getWindowHandles();

	int count =1;
	for(String eachID : allId) {
	if(count==a) {
	driver.switchTo().window(eachID);
	break;
	}
	count++;
	}
	}

	public static void selectbyIndex(WebElement ref, int value) {
	Select s = new Select(ref);
	s.selectByIndex(value);
	}
	public static void selectbyVisibleText(WebElement ref, String value) {
	Select s = new Select(ref);
	s.selectByVisibleText(value);
	}
	public static void SelectbyValue(WebElement ref, String value) {
	Select s = new Select(ref);
	s.selectByValue(value);
	}

	public static void clear(WebElement a) {
	a.clear();

	}


	public static WebDriver browserlaunch(String bname) {
	if(bname.equalsIgnoreCase("chrome")) {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	}
	else if(bname.equalsIgnoreCase("edge")) {
	WebDriverManager.edgedriver().setup();
	driver = new EdgeDriver();
	}
	else if(bname.equalsIgnoreCase("firefox")) {
	WebDriverManager.firefoxdriver().setup();
	driver = new FirefoxDriver();
	}
	return driver;
	

	
	

	
	


	}
	
	}


