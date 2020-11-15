import org.openqa.selenium.By;

public class Etsy extends Ecommerce {

	public Etsy(String productId, String productTitle) {
		this.url = "https://www.etsy.com/listing/";
		this.productTitlePath = By.xpath("//h1[@data-listing-id=\"889151300\"]");
		this.addToCartPath = By.xpath("//*[@id=\"listing-page-cart\"]/div/div[5]/div/form/button");
		this.proceedToCheckoutPath = By.xpath("/html/body/div[5]/div/div[3]/div/div/div[1]/div/div/form/div[1]/table/tbody/tr[5]");		
		this.dropdownPath = By.xpath("//*[@id=\"multi-shop-cart-list\"]/div/div/div[1]/ul/li/ul/li/div/div[2]/div/div[2]/div/div[1]/div/div/div/select");
		this.viewCartPath = this.dropdownPath;		
		this.subtotalPath = this.proceedToCheckoutPath;
		this.emptyCartPath = By.xpath("//a[@rel=\"remove\"]");
		this.emptyCartTextPath = By.className("wt-text-center-xs");
		this.productTitle = productTitle;
		this.productId = productId;
		this.checkoutText = "Total (1 item)\n"
				+ "USD 32.30";
		//etsy has a bug that shows only one item, but the total amount of money is shown correctly
		this.subtotalText = "Total (1 item)\n"
				+ "USD 64.60";
		this.emptyCartText = "Your cart is empty.";
	}
}