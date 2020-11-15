import org.openqa.selenium.By;

public class Ebay extends Ecommerce {

	public Ebay(String productId, String productTitle) {
		this.url = "https://www.ebay.com/itm/";
		this.productTitlePath = By.id("itemTitle");
		this.addToCartPath = By.id("isCartBtn_btn");
		this.proceedToCheckoutPath = By.xpath("//*[@id=\"mainContent\"]/div/div[4]/div/div[2]/div[1]");
		this.viewCartPath = By.id("s1-11-grandeagleretail-1419466691-381887387208-qty[]-1-dropdown");
		this.dropdownPath = this.viewCartPath;
		this.subtotalPath = this.proceedToCheckoutPath;
		this.emptyCartPath = By.xpath("//button[@data-test-id='cart-remove-item']");
		this.emptyCartTextPath = By.className("font-title-3");
		this.productTitle = productTitle;
		this.productId = productId;
		this.checkoutText = "Item (1)\n"
				+ "US $11.91";
		this.subtotalText = "Items (2)\n"
				+ "US $23.82";
		this.emptyCartText = "You don't have any items in your cart.";
		this.languageSelectorPath = By.id("gh-eb-Geo-a-default");
		this.englishSelectorPath = By.id("gh-eb-Geo-a-en");
		this.shouldChangeLanguage = true;
	}
}
