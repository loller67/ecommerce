import org.openqa.selenium.By;

public class Amazon extends Ecommerce {

	public Amazon(String productId, String productTitle) {
		this.url = "https://www.amazon.com/dp/";
		this.productTitlePath = By.id("productTitle");
		this.addToCartPath = By.id("add-to-cart-button");
		this.proceedToCheckoutPath = By.id("hlb-ptc-btn-native");
		this.viewCartPath = By.id("hlb-view-cart-announce");
		this.dropdownPath = By.className("a-dropdown-label");
		this.subtotalPath = By.id("sc-subtotal-label-activecart");
		this.emptyCartPath = By.className("a-color-link");
		this.emptyCartTextPath = By.id("sc-active-cart");
		this.optionTwoPath = By.id("dropdown1_2");
		this.productTitle = productTitle;
		this.productId = productId;
		this.checkoutText = "Proceed to checkout (1 item)";
		this.subtotalText = "Subtotal (2 items):";
		this.emptyCartText = "Your Amazon Cart is empty\n"
				+ "Shop today's deals\n"
				+ "Sign in to your account\n"
				+ "Sign up now";
	}
}
