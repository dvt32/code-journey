package net.dvt32.java.examples.functional.interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierExamples {
	
	static String getDbConnectionUrl() {
		return "jdbc://localhost:5432/users";
	}
	
	static Supplier< List<String> > getDbConnectionUrlsSupplier = () -> 
		Arrays.asList("jdbc://localhost:5432/users", "jdbc://localhost:5432/customer");
		
	public static void main(String[] args) {
		System.out.println( getDbConnectionUrl() );
		System.out.println( getDbConnectionUrlsSupplier.get() );
	}

}