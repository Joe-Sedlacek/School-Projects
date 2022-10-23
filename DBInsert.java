
    /**
     * This code illustrates:
     * - creating a connection to a MySQL database
     * - inserting rows using a prepared statement
     * - retrieving and printing the data in the table to verify the inserts
     *
     * 
     */
import java.sql.*;
import java.util.ArrayList;

    public class DBInsert extends GetCSVData{
        // this method inserts two rows of data using a prepared statement


        public static void doInsert(Connection conn) throws SQLException {


            String cmd = "INSERT INTO symbols (symbol, name, country, IPOyear, sector, industry) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(cmd);
            //somehow get the csv data over

            try {
                ArrayList<String> arr = GetCSVData.getCSV();


                for (int i = 1; i <= arr.size(); i++) {
                    String row = arr.get(i);
                    String[] inputRow = row.split(",", -1);
                    System.out.println(inputRow.length);
                    for (int k = 0; k < 6; k++) {
                        if (inputRow[k].equals("")) {
                            stmt.setNull(k + 1, Types.VARCHAR);
                        } else {

                            stmt.setString(k + 1, inputRow[k]);
                            System.out.println(inputRow[k]);
                        }


                    }
                    stmt.executeUpdate();
                }
                stmt.close();

            } catch (Exception ex) {
                System.out.println(ex);
            }







        }
        // retrieve all the data from symbols and print it
        public static void doSelect(Connection conn) throws SQLException {
            String query = "SELECT * FROM symbols";
            Statement stmt = conn.createStatement();
// execute the query and get a ResultSet
            ResultSet rs = stmt.executeQuery(query);
            System.out.format("\n%-10s %-32s %-10s %-5s %-20s %-20s\n",
                    "symbol", "name", "country", "IPOyear", "sector",
                    "industry" );
// loop through the resultset, retrieving data and printing
            while(rs.next()){
                String symbol = rs.getString(1);
                String name   = rs.getString(2);
                String country = rs.getString(3); //make condition for if null...split...if length = 0...set null
                Date  IPOyear = rs.getDate(4);
                String sector = rs.getString(5);
                String industry = rs.getString(6);
                System.out.format("%-10s %-32s %-10s %-5s %-20s %-20s\n",
                        symbol, name, country, IPOyear, sector,
                        industry );
            }
        }
        public static void main (String args []){
// Attempt to connect to the database
            try {  // note the details of the connection process
                String dbURL = "jdbc:mysql://falcon.cs.wfu.edu/sedljr20_stockData";
                Connection connection =
                        DriverManager.getConnection(dbURL,"sedljr20", "!06602193!");
// do example INSERTs
                doInsert(connection);
// do example SELECT
                doSelect(connection);
            } catch (SQLException ex) {
// handle exceptions
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: "     + ex.getSQLState());
                System.out.println("VendorError: "  + ex.getErrorCode());
            } // end catch
        }
    }

