package net.dvt32.javabrains;

import javax.xml.ws.Endpoint;

public class TestMartPublisher {
	
	public static void main(String[] args) {
		
		Endpoint.publish( "http://localhost:1337/productcatalog", new ProductCatalog() );
		
	}
	
}
