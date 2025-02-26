package DAO;

import Module.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDao {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/doctor?useSSL=false";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "0000";

    private static final String INSERT_USERS_SQL=
            "INSERT INTO USERS (nom,email,motPass,numero,specialisation) VALUES (?, ?, ?, ?, ?)";

    private static final String SELECT_USERS_BY_ID =
            "SELECT id, nom,email,motPass,numero,specialisation FROM users WHERE id = ?";

    private static final String SELECT_ALL_USERS =
            "SELECT * FROM users";

    // Constructeur
    public UsersDao() {}

    // Méthode pour obtenir la connexion à la base de données
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;


    }

    // insert users
    public void insertUsers(Users users) throws SQLException {
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
            preparedStatement.setString(1, users.getNom());
            preparedStatement.setString(2, users.getMotdepass());
            preparedStatement.setString(3, users.getEmail());
            preparedStatement.setString(4, users.getTele());
            preparedStatement.setString(5, users.getSpecialite());
            preparedStatement.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    // select users by id
    public Users selectUsers(int id) {
        Users users = null;
        // Step 1: Établir une connexion
        try (Connection connection = getConnection();
             // Step 2:Créer une déclaration à l'aide d'un objet de connexion
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERS_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Exécuter la requête ou la requête de mise à jour
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String nom = rs.getString("nom");
                String email = rs.getString("email");
                String motPass = rs.getString("motpasse");
                String numero = rs.getString("numero");
                String specialisation = rs.getString("specialisation");

                users = new Users(nom,email,motPass,numero,specialisation);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    //Select all USERS
    public List<Users> selectAllUsers() {
        List<Users> UserAryy = new ArrayList<>();
        // Step 1: Établir une connexion
        try (Connection connection = getConnection();
             // Step 2:Créer une déclaration à l'aide d'un objet de connexion
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            // Step 3: Exécuter la requête ou la requête de mise à jour
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String email = rs.getString("email");
                String motPass = rs.getString("motPass");
                String numero = rs.getString("numero");
                String specialisation = rs.getString("specialisation");

                UserAryy.add(new Users(nom, email, motPass,numero,specialisation));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return UserAryy;
    }

    // delete Users
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(INSERT_USERS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }









    private void printSQLException(SQLException e) {

        for (Throwable e1: e) {
            if (e1 instanceof SQLException) {
                e1.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e1).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e1).getErrorCode());
                System.err.println("Message: " + e1.getMessage());
                Throwable t = e.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }


}
