
    /**
     * This code:
     * - retrieves the stock symbol data from a .csv file; it is retrieved as
     a sequence of lines of text
     * - splits the single big string into an ArrayList<String>
     * - prints the first 5 lines
     *
     * 
     */
import java.io.*;
import java.net.*;
import java.util.ArrayList;
    public class GetCSVData {
        public static ArrayList<String> getCSV() throws Exception {
            ArrayList<String> result = new ArrayList<>();
            URL url = new URL("http://sjt.sites.wfu.edu/stock_symbols.csv");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()))) {
                for( String line; (line = reader.readLine()) != null; ) {
                    result.add(line);
                }
            }
            return result;
        }
        public static void main(String[] args) throws Exception
        {
            ArrayList<String> listOfLines = getCSV();

// print the first five lines, each of which is a String
            for(int index=0; index< 30; index++) {
                System.out.println(listOfLines.get(index));
            }
        }
    }

