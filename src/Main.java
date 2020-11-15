import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Main {
	public static void main(String args[]) throws FileNotFoundException, IOException, InterruptedException {

	    Properties properties = new Properties();
        properties.load(new FileInputStream("src/products"));
		
	    Amazon amazon = new Amazon(properties.getProperty("amazonProductId"), properties.getProperty("amazonProductTitle"));
	    amazon.accessProduct();
	    amazon.addProductToCart();
	    amazon.editCart();
	    amazon.emptyCart();
		System.out.println("AMAZON TESTS HAVE BEEN COMPLETED SUCCESSFULLY");
		
	    Walmart walmart = new Walmart(properties.getProperty("walmartProductId"), properties.getProperty("walmartProductTitle"));
	    walmart.accessProduct();
	    walmart.addProductToCart();
	    walmart.editCart();
	    walmart.emptyCart();
		System.out.println("WALMART TESTS HAVE BEEN COMPLETED SUCCESSFULLY");

	    Ebay ebay = new Ebay(properties.getProperty("ebayProductId"), properties.getProperty("ebayProductTitle"));
	    ebay.accessProduct();
		ebay.addProductToCart();
		ebay.editCart();
		ebay.emptyCart();
		System.out.println("EBAY TESTS HAVE BEEN COMPLETED SUCCESSFULLY");
        
        AliExpress aliExpress = new AliExpress(properties.getProperty("aliExpressProductId"), properties.getProperty("aliExpressProductTitle"));
        aliExpress.accessProduct();
        aliExpress.addProductToCart();
        aliExpress.editCart();
        aliExpress.emptyCart();
		System.out.println("ALIEXPRESS TESTS HAVE BEEN COMPLETED SUCCESSFULLY");

        Etsy etsy = new Etsy(properties.getProperty("etsyProductId"), properties.getProperty("etsyProductTitle"));
        etsy.accessProduct();
        etsy.addProductToCart();
        etsy.editCart();
        etsy.emptyCart();
		System.out.println("ALIEXPRESS TESTS HAVE BEEN COMPLETED SUCCESSFULLY");
		
		System.out.println("ALL ECOMERCE TESTS HAVE BEEN COMPLETED SUCCESSFULLY");
	}
}