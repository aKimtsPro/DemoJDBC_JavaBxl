package bstorm.akimts;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        // Class.forName( "com.mysql.cj.jdbc.Driver" );
        // Si la librairie est installée, la JVM trouvera la classe d'elle même
        // => le block static dans Driver s'executera
        // => le Driver sera enregistré dans le DriverManager

        String url = "jdbc:mysql://localhost:3306/dbslide";
        String username = "root";
        String password = "";

        String query = "SELECT first_name, last_name" +
                " FROM student"; // attention aux espaces dans les concatenations
        try (
                Connection connection = DriverManager.getConnection(url, username, password);
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery( query );
        ) {
            while( rs.next() ) {

                String prenom = rs.getString("first_name") ;
                String nom = rs.getString("last_name");

                // Alternative
//                String prenom = rs.getString(1);
//                String nom = rs.getString(2);

                System.out.println(prenom + ' ' + nom);

            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("La connexion a echoué");
        }
    }
}
