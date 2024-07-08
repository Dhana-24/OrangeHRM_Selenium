package orangeHRM.base;

import org.openqa.selenium.WebElement;

public interface SeleniumAPI {
	
	/**
	 * This method will launch the chrome browser with the given url
	 * @author Dhana
	 * @param URL
	 * @exception NullPointerException, URLMalfunction
	 */
	//TODO:
	void setup(String URL);
	
	/**
	 * This method will launch the chrome browser with the given url
	 * @author Dhana
	 * @param URL
	 * @param browserName
	 * 
	 */
	
	void setup(Browser browserName,String URL);
	
	void close();
	
	void quit();
	
	/**
	 * This method is used to find any webelement with in the page
	 * @param type - element type eg - id, name or linkText
	 * @param value - element value
	 * @return WebElement
	 */
	WebElement element(Locators type, String value);
	
	void switchToWindow(int i);
	
	void selectValue(WebElement element, String value);
	
	void selectText(WebElement element, String text);
	
	void selectIndex(WebElement element, int position);
	
	void click(WebElement ele);
	
	
	void appendText(WebElement ele,String text);
	
	String getTitle();
	
	String getURL();
	
	Boolean isDisplayed(WebElement ele);

	void type(WebElement element, String input);
	
	

}
