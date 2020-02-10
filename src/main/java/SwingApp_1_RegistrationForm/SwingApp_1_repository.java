package SwingApp_1_RegistrationForm;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SwingApp_1_repository {
    public static Connection connection;


    public static void connectDB() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/userAuthorisation",
                    "postgres","postgres1");
            System.out.println("DB userAuthorisation connected");
        } catch (ClassNotFoundException| SQLException e) {
            e.printStackTrace();
        }
    }
    public static void disconectDB() {
//        try {preparedStatement.close();
//        } catch (SQLException e) { e.printStackTrace();}
//        try {statement.close();
//        } catch (SQLException e) {e.printStackTrace(); }
        try { connection.close();
        } catch (SQLException e) { e.printStackTrace();}
    }

    public static void addUserToDB (Users user) {
        connectDB();
        try {
            //Users (IDUsers, login, password, sex)
            String sql = "INSERT INTO ? (?, ?, ?, ?)" +
                    " VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);
            preparedStatement.setString(1, "users");
            preparedStatement.setString(2, "IDUsers");
            preparedStatement.setString(3, "login");
            preparedStatement.setString(4, "password");
            preparedStatement.setString(5, "sex");
            preparedStatement.setInt(6, user.getIDUsers());
            preparedStatement.setString(7, user.getLogin());
            preparedStatement.setString(8, user.getPassword());
            preparedStatement.setString(9, user.getSex());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconectDB();
    }



    public static List<Users> getAllUsersFromDB() {
        connectDB();
        List<Users> resultDB_AllUsersList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Users";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet queryResultSet = preparedStatement.executeQuery();

            while (queryResultSet.next()) {
                int idUsers = queryResultSet.getInt("IDUsers");
                String login = queryResultSet.getString("login");
                String password = queryResultSet.getString("password");
                String sex = queryResultSet.getString("sex");

                Users user = new Users();
                user.setIDUsers(idUsers);
                user.setLogin(login);
                user.setPassword(password);
                user.setSex(sex);
                resultDB_AllUsersList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconectDB();
        return resultDB_AllUsersList;
    }

    public static void isTablesInDBCreated () {
        connectDB();
        try {
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            ResultSet resultSetUsersTable = databaseMetaData.getTables(null, null, "users", null);
            disconectDB();
            if (resultSetUsersTable.next()) {
                System.out.println("Tables: Users already created");
            }
            else {
                createAllTablesInDB();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void createAllTablesInDB (){
        connectDB();
        try {
            Statement statement=connection.createStatement();
            statement.execute("CREATE TABLE Users(IDUsers int PRIMARY KEY, login varchar(50), password varchar(50), sex varchar(50));");
            System.out.println("Created tables: Users");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        disconectDB();
    }
    public static void dropAllTablesFromDB (){
        connectDB();
        try {
            Statement statement=connection.createStatement();
            statement.execute("drop table Users;");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconectDB();
    }

}