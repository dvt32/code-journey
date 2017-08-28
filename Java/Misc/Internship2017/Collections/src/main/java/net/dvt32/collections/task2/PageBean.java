package net.dvt32.collections.task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This program takes an input list 
 * and splits it into pages with a specified size (number of elements per page).
 * 
 * @author Dimitar Trifonov (dvt32)
 *
 * @param <T> the type of elements in the input list
 */
public class PageBean<T> {
	private int pageSize;
	private Map< Integer, List<T> > pages;
	private int currentPageNumber;
	
	/**
	 * Constructor, which adds all the elements from the input list
	 * to an internal HashMap. The HashMap's key is the page's number (starts with 1)
	 * and its value is a sublist with the next 'pageSize' number of elements from the input list.
	 * 
	 * When a page is full, we move on to the next page (the key's number is incremented).
	 * In case the last page couldn't be filled, because there weren't enough elements in the input list, 
	 * we still consider it a valid page and add it to the map.
	 * 
	 * When we first start the program, we move to the next (first) page and print its value.
	 * 
	 * Lastly, after all of the above, we are prompted to enter the method names "next" or "previous" 
	 * to navigate the pages manually. To stop the reading, we just have to enter something else.
	 * 
	 * @param pageSize The max number of elements on each page
	 * @param elements The input list, containing all elements
	 * @param <T> the type of the list's elements (could be any object type)
	 * @param scanner The Scanner object used for reading input from the console
	 */
	public PageBean(int pageSize, List<T> elements, Scanner scanner) {
		this.pageSize = pageSize;
		pages = new HashMap< Integer, List<T> >();
		currentPageNumber = 0;
		
		// Fill HashMap with "page number - contents on page" pairs
		List<T> page = new ArrayList<T>(pageSize);
		int pageNumber = 1;
		for (int i = 0; i < elements.size(); ++i) {
			page.add( elements.get(i) );
			if (page.size() == pageSize) {
				pages.put(pageNumber, page);
				page = new ArrayList<T>(pageSize);
				pageNumber++;
			}
		}
		
		// In case the last page wasn't filled completely, we still consider it a valid page.
		if (page.size() > 0) {
			pages.put(pageNumber, page);
		}
		
		// When we first start the program, we move to the next (first) page and print its value.
		System.out.println( this.next() );
		
		// Lastly, we now have to enter the method names "next" or "previous" to navigate the pages manually.
		readMethodNamesFromConsoleWithScanner(scanner);
	}
	
	/*
	 * Getter/setter methods
	 */
	public int getCurrentPageNumber() {
		return currentPageNumber;
	}
	
	public void setCurrentPageNumber(int currentPageNumber) {
		this.currentPageNumber = currentPageNumber;
	}
	
	/**
	 * This method returns the next page from the map 
	 * and increments the current page number.
	 * 
	 * If there is no next page, an exception is thrown instead.
	 * 
	 * @return The next page
	 */
	public List<T> next() {
		if (this.hasNext()) {
			setCurrentPageNumber( getCurrentPageNumber() + 1 );
			List<T> nextPage = pages.get( getCurrentPageNumber() );
			return nextPage;
		}
		else {
			throw new NoSuchElementException("There is no next page!");
		}
	}
	
	/**
	 * This method returns the previous page from the map 
	 * and decrements the current page number.
	 * 
	 * If there is no previous page, an exception is thrown instead.
	 * 
	 * @return The previous page
	 */
	public List<T> previous() {
		if (this.hasPrevious()) {
			setCurrentPageNumber( getCurrentPageNumber() -1 );
			List<T> previousPage = pages.get( getCurrentPageNumber() );
			return previousPage;
		}
		else {
			throw new NoSuchElementException("There is no previous page!");
		}
	}
	
	/**
	 * This method checks if there's a next page in the map.
	 * 
	 * containsKey() is used (rather than get != null), 
	 * because null values are allowed in the map.
	 * 
	 * @return true if there's a next page, false otherwise
	 */
	public boolean hasNext() {
		int currentPageNumber = getCurrentPageNumber();
		return pages.containsKey( currentPageNumber+1 );
	}
	
	/**
	 * This method checks if there's a previous page in the map.
	 * 
	 * containsKey() is used (rather than get != null), 
	 * because null values are allowed in the map.
	 * 
	 * @return true if there's a previous page, false otherwise
	 */
	public boolean hasPrevious() {
		int currentPageNumber = getCurrentPageNumber();
		return pages.containsKey( currentPageNumber-1 );
	}
	
	/**
	 * This method returns the first page from the map 
	 * and sets the current page number to 1.
	 * 
	 * @return The first page
	 */
	public List<T> firstPage() {
		setCurrentPageNumber(1);
		List<T> firstPage = pages.get(1);
		return firstPage;
	}
	
	/**
	 * This method returns the last page from the map 
	 * and sets the current page number to to last page's number.
	 * 
	 * @return The last page
	 */
	public List<T> lastPage() {
		setCurrentPageNumber( pages.size() );
		List<T> lastPage = pages.get( pages.size() );
		return lastPage;
	}
	
	/**
	 * This method reads method names from the console (allowed method names 
	 * are "next" and "previous") and calls those methods
	 * until the user enters something else, which will terminate the method.
	 * 
	 * @param scanner The Scanner object used for reading
	 */
	public void readMethodNamesFromConsoleWithScanner(Scanner scanner) {
		while ( scanner.hasNextLine() ) {
			String input = scanner.nextLine();
			if (input.equals("next")) {
				System.out.println( this.next() );
			}
			else if (input.equals("previous")) {
				System.out.println( this.previous() );
			}
			else {
				break;
			}
		}
		
		scanner.close();
	}
	
	// Additional helper method, which prints all the pages from the internal map.
	/*
	public void printPages() {
		for (Integer pageNumber : pages.keySet() ) {
			System.out.println("Page " + pageNumber + ": " + pages.get(pageNumber) );
		}
	}
	*/
}