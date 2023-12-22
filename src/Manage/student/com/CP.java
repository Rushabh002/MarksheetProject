package Manage.student.com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CP {
    static Connection con;
    static Statement statement;

    public static Connection CreateC(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/student_manage";
            String user = "root";
            String password = "Rushabhjay002@";
            con = DriverManager.getConnection(url,user,password);
            statement= con.createStatement();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
            return con;
    }
    public static void Closedatabase(){
        try {
            if(statement!=null){
                statement.close();
            }
            if(con!=null){
                con.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
