package orangeHRM.base;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumBase implements SeleniumAPI{
	
	long timeOuts = 30;
	long maxWaitTime = 10;
	RemoteWebDriver driver = null;
	WebDriverWait wait = null;

	@Override
	public void setup(String URL) {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		wait = new WebDriverWait(driver,Duration.ofSeconds(maxWaitTime));
	}

	@Override
	public void setup(Browser browserName, String URL) {
		
		
		try {
			switch (browserName) {
			case CHROME:
				driver = new ChromeDriver();
				break;
			case FIREFOX:
				driver = new FirefoxDriver();
				break;
			case EDGE:
				driver = new EdgeDriver();
				break;
			default:
				System.err.println("Driver is not defined");
				break;
			}
		} catch (NoSuchElementException e) {
			System.err.println("Element not found =>"+e.getMessage());
		}catch(WebDriverException e) {
			System.err.println(e.getMessage());
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		driver.manage().window().maximize();
		driver.get(URL);
		wait = new WebDriverWait(driver,Duration.ofSeconds(maxWaitTime));
	}

	@Override
	public void close() {
		driver.close();
	}

	@Override
	public void quit() {
		driver.quit();
		
	}

	public WebElement element(Locators type, String value) {
		
		try {
			switch (type) {
			case ID:
				return driver.findElement(By.id(value));
			case NAME:
				return driver.findElement(By.name(value));
			case XPATH:
				return driver.findElement(By.xpath(value));
			case LINK:
				return driver.findElement(By.linkText(value));
			default:
				break;
			}
		} catch (NullPointerException e) {
			System.out.println("Element might be null =>"+e.getMessage());
			throw new NullPointerException("Element not found");
		}catch (NoSuchElementException e) {
			
			System.out.println("Element might be null =>"+e.getMessage());
		}
		return null;
	}

	@Override
	public void switchToWindow(int i) {
		
		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> list = new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(i));
	}

	// TODO: function to check if the dropdown is selected? 
	@Override
	public void selectValue(WebElement ele, String value) {
		WebElement element = isElementClickable(ele);
		new Select(element).selectByValue(value);
		
	}

	@Override
	public void selectText(WebElement ele, String text) {
		WebElement element = isElementClickable(ele);
		new Select(element).selectByVisibleText(text);
		
	}

	@Override
	public void selectIndex(WebElement ele, int position) {
		WebElement element = isElementClickable(ele);
		new Select(element).selectByIndex(position);
	}
	
	public void isDropdownSelected(WebElement ele) {
		ele.isSelected();
		
	}

	@Override
	public void click(WebElement ele) {
		WebElement element = isElementClickable(ele);
		element.click();
		
	}

	private WebElement isElementClickable(WebElement ele) {
		WebElement element = wait.withMessage("Element is not visible").
				until(ExpectedConditions.elementToBeClickable(ele));
		return element;
	}

	@Override
	public void type(WebElement ele, String input) {
		
		try {
			WebElement element = isElementClickable(ele);
			element.sendKeys(input);
		} catch (NullPointerException e) {
			System.out.println("Element might be null =>"+e.getMessage());
		}catch (NoSuchElementException e) {
			
			System.out.println("Element might be null =>"+e.getMessage());
		}
		
	}
	
	public WebElement typeEnter(WebElement ele,String input, Keys keys) {
		
		WebElement webElement = null;
		webElement = wait.until(ExpectedConditions.elementToBeClickable(ele));
		webElement.sendKeys(input,keys);
		return webElement;
		
		
	}


	public void appendText(WebElement ele, String text) {
		// TODO Auto-generated method stub
		WebElement element = isElementClickable(ele);
		element.sendKeys(text);
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}

	@Override
	public String getURL() {
		// TODO Auto-generated method stub
		return driver.getCurrentUrl();
	}

	@Override
	public Boolean isDisplayed(WebElement ele) {
		// TODO Auto-generated method stub
		return ele.isDisplayed();
	}

	


	

}
