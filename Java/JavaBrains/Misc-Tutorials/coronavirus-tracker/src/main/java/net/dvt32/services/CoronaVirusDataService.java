package net.dvt32.services;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import net.dvt32.models.LocationStats;

@Service
public class CoronaVirusDataService {
	
	private static String VIRUS_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_19-covid-Confirmed.csv";
	private List<LocationStats> allStats = new ArrayList<>();

	@PostConstruct
	@Scheduled(cron = "* * 1 * * *") // <second> <minute> <hour> <day-of-month> <month> <day-of-week>
	public void fetchVirusData() 
		throws IOException, InterruptedException 
	{
		List<LocationStats> newStats = new ArrayList<>();
		
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpRequest httpRequest = HttpRequest.newBuilder()
			.uri( URI.create(VIRUS_DATA_URL) )
			.build();
		
		HttpResponse<String> httpResponse = httpClient.send( httpRequest, HttpResponse.BodyHandlers.ofString() );
		
		StringReader csvBodyReader = new StringReader( httpResponse.body() );
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);
		for (CSVRecord record : records) {
			LocationStats locationStat = new LocationStats();
			
		    String state = record.get("Province/State");
		    String country = record.get("Country/Region");
		    String lastRecord = record.get( record.size() - 1 );
		    String previousDayRecord = record.get( record.size() - 2 );
		    int latestTotalCases = Integer.parseInt(lastRecord);
		    int previousDayTotalCases = Integer.parseInt(previousDayRecord);
		    
		    locationStat.setState(state);
		    locationStat.setCountry(country);
		    locationStat.setLatestTotalCases(latestTotalCases);
		    locationStat.setDifferenceFromPreviousDay(latestTotalCases - previousDayTotalCases);

		    newStats.add(locationStat);
		}
		
		this.allStats = newStats;
	}
	
	public List<LocationStats> getAllStats() {
		return allStats;
	}

}