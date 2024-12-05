package example;


import java.sql.*;

public class JDBCConnection {
    public static void main(String[] args) throws SQLException {

        String host = "localhost";
        String port = "3306";

        //connect to database with java sql package drivermanager
        Connection connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/automation", "root", "Spsns@468@318@104");

        //set the entry point to DB using statement creation
        Statement statement = connection.createStatement();

        //get the values from table in DB and store it in result set
        ResultSet resultSet = statement.executeQuery("select * from employeeinfo where name = 'Selenium';");

        //by default result set is with 0 index and values get from are stored from 1st index move result set to index 1
        resultSet.next();

        //get the values
        System.out.println(resultSet.getString("name"));
        System.out.println(resultSet.getString("location"));
    }
}
