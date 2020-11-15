import org.openqa.selenium.By;

public class AliExpress extends Ecommerce {

	public AliExpress(String productId, String productTitle) {
		this.url = "https://www.aliexpress.com/item/";
		this.productTitlePath = By.className("product-title-text");
		this.addToCartPath = By.className("addcart-wrap");
		this.proceedToCheckoutPath = By.className("addcart-result-title");
		this.viewCartPath = By.xpath("//button[@ae_project_id=\"21200\"]");
		this.dropdownPath = By.xpath("//input[@aria-valuemax=\"5\"]");
		this.optionTwoPath = By.xpath("//button[@ae_button_type=\"add_button\"]");
		this.subtotalPath = By.className("charges-totle");
		this.emptyCartPath = By.xpath("//button[@ae_button_type=\"remove\"]");
		this.emptyCartTextPath = By.id("root");
		this.popUpSelectorPath = By.xpath("/html/body/div[15]/div[2]/div[2]/button[1]");
		this.productTitle = productTitle;
		this.productId = productId;
		this.checkoutText = "A new item has been added to your Shopping Cart. You now have 1 items in your Shopping Cart.";
		//aliexpress has a bug that checkout total is always zero, I am checking the subtotal text in order to be consistent with the other cases.
		this.subtotalText = "Subtotal\n"
				+ "US $0.00";
		this.emptyCartText = "Your Shopping Cart is empty\n"
				+ "Don't miss out on great deals! Start shopping or log in to view products added.";
		this.hasPopUp = true;
	}
}
