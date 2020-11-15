import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Ecommerce {
	
	private WebDriver driver;
	private WebDriverWait wait;
	protected String url;
	protected By productTitlePath;
	protected By addToCartPath;
	protected By proceedToCheckoutPath;
	protected By viewCartPath;
	protected By dropdownPath;
	protected By subtotalPath;
	protected By optionTwoPath;
	protected By emptyCartPath;
	protected By emptyCartTextPath;
	protected String productTitle;
	protected String productId;
	protected String checkoutText;
	protected String subtotalText;
	protected String emptyCartText;
	protected By languageSelectorPath;
	protected By englishSelectorPath;
	protected boolean shouldChangeLanguage;
	protected boolean hasPopUp;
	protected By popUpSelectorPath;
	
	public void accessProduct() throws InterruptedException {
        this.driver = new FirefoxDriver();
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.driver.get(this.url + this.productId); 
        System.out.println("Successfully accessed product");
        
        this.driver.manage().window().maximize();
        if(this.shouldChangeLanguage) {
            this.changeLanguage();
        }
        if(this.hasPopUp) {
        	this.closePopUp();
        }

        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.productTitlePath));
        
        WebElement product = this.driver.findElement(this.productTitlePath);
		String text = product.getText();  

        System.out.println("Veryfing that the product title is: " + text);        
        Assert.assertEquals(text, this.productTitle);
        System.out.println("Product found");
	}
		
	public void addProductToCart() {
		this.driver.findElement(this.addToCartPath).click();

        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.proceedToCheckoutPath));

		String text = this.driver.findElement(this.proceedToCheckoutPath).getText();  

        System.out.println("Veryfing that we have only one item in checkout: " + text);        
        Assert.assertEquals(text, this.checkoutText);
		System.out.println("Product added to cart");
	}

	public void editCart() throws InterruptedException {
		this.driver.findElement(this.viewCartPath).click();
		
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.dropdownPath));
        WebElement dropdown = this.driver.findElement(this.dropdownPath);

        if (dropdown.getTagName().equals("select")) {
            Select sel = new Select(dropdown);
    	    sel.selectByValue("2");
        } else {
        	dropdown.click();
        	this.driver.findElement(this.optionTwoPath).click();
        }
		Thread.sleep(1000);
		String text = this.driver.findElement(this.subtotalPath).getText();  

        System.out.println("Veryfing that subtotal text is: " + text);        
        Assert.assertEquals(text, this.subtotalText);	
		System.out.println("Cart has been modified");
	}

	public void emptyCart() throws InterruptedException {
		this.driver.findElement(this.emptyCartPath).click();
		
		if (this.hasPopUp) {
	        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.popUpSelectorPath));
			this.driver.findElement(this.popUpSelectorPath).click();
		}
		
		Thread.sleep(3000);
		String text = this.driver.findElement(this.emptyCartTextPath).getText();  

        System.out.println("Veryfing that cart is empty..");        
        Assert.assertEquals(text, this.emptyCartText);			
        System.out.println("Cart has 0 elements");
        this.driver.close();
	}

	private void changeLanguage() {
        if (this.driver.findElements(this.languageSelectorPath).size() != 0) {

            Actions actions = new Actions(this.driver);        	
        	WebElement languageSelector = this.driver.findElement(this.languageSelectorPath);

        	if (!languageSelector.getText().equals("Current language English")) {
            	actions.moveToElement(languageSelector).perform();
                this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.englishSelectorPath));
            	this.driver.findElement(this.englishSelectorPath).click();
        	}
        }
	}
	
	private void closePopUp() throws InterruptedException {
		Thread.sleep(3000);
		this.driver.navigate().refresh();
	}
}
