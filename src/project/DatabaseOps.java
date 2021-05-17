package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;

public class DatabaseOps implements IDatabaseOps {
    private static final String password="Test1234";
    private static final String dbUrl="jdbc:postgresql://localhost:5432/Nyat_Project";
    private static final String userName="postgres";
    private Connection connectToDB(){
        Connection conn=null;
        try{
            conn = DriverManager.getConnection(dbUrl,userName,password);
            if (conn != null)
                SmartCoolingDevice.freeze(700);
            System.out.println("Veritabanina baglanti basarili!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    public boolean authorize(String username, String password){
        Connection conn=this.connectToDB();
        String selectQuery= MessageFormat.format("SELECT \"username\",\"password\" FROM \"Users\" WHERE \"username\"=''{0}''AND \"password\"=''{1}''", username, password);
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(selectQuery);
            conn.close();
            if(!resultSet.next())
                return false;
            else{
                SmartCoolingDevice.freeze(800);
                System.out.println("Kullanici bilgileri basariyla dogrulandi!");
                return true;
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
