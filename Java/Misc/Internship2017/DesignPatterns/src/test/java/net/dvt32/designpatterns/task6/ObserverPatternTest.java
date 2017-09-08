package net.dvt32.designpatterns.task6;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ObserverPatternTest {
	
	private final ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
	
	@Before
	public void setUpOutputStream() {
		System.setOut( new PrintStream(consoleOutput) );
	}
	
	@After
	public void cleanUpOutputStream() {
		System.setOut(null);
	}

	@Test
	public void tomShouldReceiveUpdates() {
		AvailableStocks as = new AvailableStocks();
		SoldOutStocks ss = new SoldOutStocks(as);
		Tom tom = new Tom(ss);
		
		as.setStockQuantity("basketball", 5);
		as.setStockQuantity("frying pan", 3);
		as.setStockQuantity("frying pan", 0);
		as.setStockQuantity("frying pan", 2);
		
		String expectedOutput = 
			"Update received by Tom!\r\n" + 
			"- Available stocks (name = quantity): {basketball=5}\r\n" + 
			"- Soldout stock names: []\r\n" + 
			"\r\n" + 
			"Update received by Tom!\r\n" + 
			"- Available stocks (name = quantity): {basketball=5, frying pan=3}\r\n" + 
			"- Soldout stock names: []\r\n" + 
			"\r\n" + 
			"Update received by Tom!\r\n" + 
			"- Available stocks (name = quantity): {basketball=5}\r\n" + 
			"- Soldout stock names: [frying pan]\r\n" + 
			"\r\n" + 
			"Update received by Tom!\r\n" + 
			"- Available stocks (name = quantity): {basketball=5, frying pan=2}\r\n" + 
			"- Soldout stock names: []\r\n" + 
			"\r\n";
		String actualOutput = consoleOutput.toString();
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void tomAndSarrahShouldReceiveUpdates() {
		AvailableStocks as = new AvailableStocks();
		SoldOutStocks ss = new SoldOutStocks(as);
		Tom tom = new Tom(ss);
		Sarrah sarrah = new Sarrah(ss);
		
		as.setStockQuantity("basketball", 5);
		as.setStockQuantity("frying pan", 3);
		as.setStockQuantity("frying pan", 0);
		as.setStockQuantity("frying pan", 2);
		
		String expectedOutput = 
			"Update received by Tom!\r\n" + 
			"- Available stocks (name = quantity): {basketball=5}\r\n" + 
			"- Soldout stock names: []\r\n" + 
			"\r\n" + 
			"Update received by Sarrah!\r\n" + 
			"- Available stocks (name = quantity): {basketball=5}\r\n" + 
			"- Soldout stock names: []\r\n" + 
			"\r\n" + 
			"Update received by Tom!\r\n" + 
			"- Available stocks (name = quantity): {basketball=5, frying pan=3}\r\n" + 
			"- Soldout stock names: []\r\n" + 
			"\r\n" + 
			"Update received by Sarrah!\r\n" + 
			"- Available stocks (name = quantity): {basketball=5, frying pan=3}\r\n" + 
			"- Soldout stock names: []\r\n" + 
			"\r\n" + 
			"Update received by Tom!\r\n" + 
			"- Available stocks (name = quantity): {basketball=5}\r\n" + 
			"- Soldout stock names: [frying pan]\r\n" + 
			"\r\n" + 
			"Update received by Sarrah!\r\n" + 
			"- Available stocks (name = quantity): {basketball=5}\r\n" + 
			"- Soldout stock names: [frying pan]\r\n" + 
			"\r\n" + 
			"Update received by Tom!\r\n" + 
			"- Available stocks (name = quantity): {basketball=5, frying pan=2}\r\n" + 
			"- Soldout stock names: []\r\n" + 
			"\r\n" + 
			"Update received by Sarrah!\r\n" + 
			"- Available stocks (name = quantity): {basketball=5, frying pan=2}\r\n" + 
			"- Soldout stock names: []\r\n" +
			"\r\n";
		String actualOutput = consoleOutput.toString();
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void shouldPrintNothingBecauseThereAreNoSoldOutStocksObservers() {
		AvailableStocks as = new AvailableStocks();
		SoldOutStocks ss = new SoldOutStocks(as);
		as.setStockQuantity("stock", 1);
		assertTrue( consoleOutput.toString().isEmpty() );
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentException() {
		AvailableStocks as = new AvailableStocks();
		SoldOutStocks ss = new SoldOutStocks(as);
		as.setStockQuantity("stock", -1);
	}

}