package webServices;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Stock;

@Path("stocks")
public class StocksWS
{
	static List<Stock> stocks = null;
	
	public StocksWS() {
		if (stocks == null) {
			stocks = new ArrayList<Stock>();
		}
	}
	
	public Stock getStockByID(int id) {
		for (Stock stock : stocks) {
			if (stock.getId() == id) {
				return stock;
			}
		}
		
		return null;
	}
	
	// 1 – Добавяне на нова стока - име, количество и уникален номер (ID)
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String createStock(
		@FormParam("stockName") String name, 
		@FormParam("quantity") int quantity) 
	{
		int nextStockID;
		
		if (stocks.isEmpty()) {
			nextStockID = 1;
		}
		else {
			Stock lastStock = stocks.get( stocks.size() - 1 );
			nextStockID = lastStock.getId() + 1;
		}
		
		Stock newStock = new Stock(name, quantity, nextStockID);
		stocks.add(newStock);
		
		return newStock.toString();
	}
	
	// 2 – Изтриване на дадена стока, по зададено ID
	@DELETE
	@Path("/{stockID}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteStock(@PathParam("stockID") int id) {
		Stock stock = getStockByID(id);
		
		stocks.remove(stock);
		
		return "";
	}
	
	// 3 – Промяна на информацията на дадена стока (име или количество), по зададено ID
	@PUT
	@Path("/{stockID}")
	@Produces(MediaType.TEXT_PLAIN)
	public String updateStock(
		@PathParam("stockID") int id, 
		@FormParam("stockName") String name,
		@FormParam("quantity") int quantity) 
	{
		Stock stock = getStockByID(id);
		
		stock.setName(name);
		stock.setQuantity(quantity);
		
		return stock.toString();
	}
	
	// 4 – Преглеждане на информацията за дадена стока, по зададено ID
	@GET
	@Path("/{stockID}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getSingleStock(@PathParam("stockID") int id) {
		Stock stock = getStockByID(id);
		
		return stock.toString();
	}
	
	// 5 – Преглеждане на списъка с всички стоки в склада
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getAllStocks() {
		return stocks.toString();
	}
}