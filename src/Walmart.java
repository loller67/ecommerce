import org.openqa.selenium.By;

public class Walmart extends Ecommerce {

	public Walmart(String productId, String productTitle) {
		this.url = "https://www.walmart.com/ip/";
		this.productTitlePath = By.xpath("//h1[@itemprop='name']");
		this.addToCartPath = By.className("spin-button-children");
		this.proceedToCheckoutPath = By.className("order-summary-label");
		this.viewCartPath = By.xpath("//span[text()=\"View cart\"]");
		this.dropdownPath = By.xpath("//select[@data-automation-id='cart-item-qty-chooser']");
		this.subtotalPath = this.proceedToCheckoutPath;
		this.emptyCartPath = By.xpath("//button[@data-automation-id='cart-item-remove']");;
		this.emptyCartTextPath = By.className("order-summary");
		this.productTitle = productTitle;
		this.productId = productId;
		this.checkoutText = "Subtotal(1 item)";
		this.subtotalText = "Subtotal(2 items)";
		this.emptyCartText = "Subtotal$0.00\n"
				+ "Delivery$0.00\n"
				+ "Taxes and fees\n"
				+ "Taxes and fees$0.00\n"
				+ "(calculated in checkout)\n"
				+ "Estimated Total\n"
				+ "Est. total$0.00";		
	}

}
