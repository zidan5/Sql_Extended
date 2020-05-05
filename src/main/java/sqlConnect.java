import java.sql.*;
import org.springframework.jdbc.core.JdbcTemplate;

public class sqlConnect {

    private JdbcTemplate jdbcTemplateObject;

    public static void main(String[] args) {
        try  {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Umuzi", "postgres", "foxone");
            System.out.println("Java JDBC PostgreSQL Example");
            // When this class first attempts to establish a connection, it automatically loads any JDBC 4.0 drivers found within
            // the class path. Note that your application must manually load any JDBC drivers prior to version 4.0.
            Class.forName("org.postgresql.Driver");

            System.out.println("Connected to PostgreSQL database!");
            Statement statement = connection.createStatement();
            String[] queries = new String[7];

            queries[0] = "SELECT * FROM public.Customers";
            queries[1] = "SELECT Firstname FROM public.Customers";
            queries[2] = "SELECT Firstname FROM public.Customers Where CustomerID=1";
            queries[3] = "UPDATE public.Customers SET Firstname =?, Lastname=?CustomerID=?;";
            queries[4] = "DELETE FROM public.Customers Where CustomerID=?";
            queries[5] ="SELECT COUNT(DISTINCT Status) FROM public.Orders";
            queries[6]= "SELECT MAX(Amount) FROM public.Payments";


            for (String s : queries) { // loop for every single query to print them in order

                ResultSet resultSet = statement.executeQuery(s);

                while (resultSet.next()) { // result set of each query


                    for (String query : queries) {

                        if (query.contains("*")) {

                            System.out.println(
                                    resultSet.getString("customerid") + "\t"
                                            + resultSet.getString("firstname") + "\t"
                                            + resultSet.getString("lastname") + "\t"
                                            + resultSet.getString("gender") + "\t"
                                            + resultSet.getString("address") + "\t"
                                            + resultSet.getString("phone") + "\t"
                                            + resultSet.getString("email") + "\t"
                                            + resultSet.getString("city") + "\t"
                                            + resultSet.getString("country"));

                        } else if (query.length() == 38) {

                            System.out.println(resultSet.getString("Firstname"));

                        } else if (query.matches("[CustomerID=1]")) {

                            System.out.println(resultSet.getString("Firstname"));

                        } else if (query.matches("[UPDATE]")) {

                            jdbcTemplateObject.update(query, "Lerato", "Mabitso", 1);

                        } else if (query.matches("[DELETE]")) {

                            jdbcTemplateObject.update(query, 2);

                        } else if (query.matches("[COUNT]")) {

                            System.out.println(resultSet.getInt(1));
                        } else {

                            System.out.println(resultSet.getInt(1));
                        }
                    }
                }
            }

        }  catch (SQLException | ClassNotFoundException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }
}