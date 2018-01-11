package net.dvt32.javabrains;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import net.dvt32.javabrains.business.ProductServiceImpl;
import net.dvt32.javabrains.model.Product;

@WebService(
	endpointInterface="net.dvt32.javabrains.ProductCatalogInterface",
	portName="TestMartCatalogPort", 
	serviceName="TestMartCatalogService"
)
public class ProductCatalog implements ProductCatalogInterface {
	
	ProductServiceImpl productService = new ProductServiceImpl();
	
	/* (non-Javadoc)
	 * @see net.dvt32.javabrains.ProductCatalogInterface#getProductCategories()
	 */
	@Override
	public List<String> getProductCategories() {
		return productService.getProductCategories();
	}
	
	/* (non-Javadoc)
	 * @see net.dvt32.javabrains.ProductCatalogInterface#getProducts(java.lang.String)
	 */
	@Override
	public List<String> getProducts(String category) {
		return productService.getProducts(category);
	}
	
	/* (non-Javadoc)
	 * @see net.dvt32.javabrains.ProductCatalogInterface#addProduct(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean addProduct(String category, String product) {
		return productService.addProduct(category, product);
	}
	
	/* (non-Javadoc)
	 * @see net.dvt32.javabrains.ProductCatalogInterface#getProductsv2(java.lang.String)
	 */
	@Override
	public List<Product> getProductsv2(String category) {
		return productService.getProductsv2(category);
	}
	
	
}
