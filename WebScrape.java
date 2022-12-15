 //url (12/15/22) https://stockanalysis.com/trending/
// Updated by : @JamesFerr13 

/**
 *
 * Original @author Shane - shanelee.co.uk
*/

import java.io.IOException;
import java.util.Calendar;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class StockWebScrape {
    public static void main(String[] args) throws IOException {
        
    	final String url = "https://stockanalysis.com/trending/";
        
    	String mydate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
        System.out.println(mydate+"\n");

        // connect to url 
        final Document document = Jsoup.connect(url).userAgent("mozilla/17.0").get();
        
        //access table rows
        for (Element row: document.select("table.symbol-table.svelte-em1arr tr")) {
            
        	if (row.select("td:nth-of-type(1)").text().equals("")) {
                continue;
            } // ends if  
        	else {
                final String num = row.select("td:nth-of-type(1)").text();
                final String ticker = row.select("td:nth-of-type(2)").text();
                final String compName = row.select("td:nth-of-type(3)").text();
                final String markCap = row.select("td:nth-of-type(5)").text();
                final String perChange = row.select("td:nth-of-type(6)").text();
                final String volume = row.select("td:nth-of-type(7)").text();

                String outPut = num + " Ticker: " + ticker + "  \nCompanyName: " + compName + "  \nMarket Cap: " + markCap + " \n%Change: " + perChange + "\nVolume: "+volume +"\n\n";
                
                System.out.println(outPut);
 
            } //ends else 
        } //ends for loop
    } //ends class
} //ends main 
