
package SchoolEscape.Data;
// @author Tim

import SchoolEscape.Acquaintance.IData;
import java.sql.*;



// Create highscore list implementing interface
public class Data implements IData 
{
    Connection conn = null;
    private String ip = "jdbc:mysql://207.154.205.244/matador";
    private String userName = "tim_user";
    private String password = "Tim!Er&Dejlig932!";
    
    public Data()
    {
        try 
        {
            conn = DriverManager.getConnection(ip, userName, password);

        } catch (SQLException ex)
        {
            System.out.println(ex.toString());
        }
    }
    
    @Override
    public void getHighscore()
    {
        Statement statement = null;
        ResultSet result = null;
        
        try
        {
            statement = conn.createStatement();
            result = statement.executeQuery("SELECT * FROM matador.highscore ORDER BY score DESC LIMIT 10");
            
            while (result.next())
                {
                    System.out.println(result.getString("bruger"));
                    System.out.println(result.getString("score"));
                }
        } catch (SQLException ex) 
        {
            System.out.println(ex.toString());
            
        }
        
        
    }
    @Override
    public void addHighscore(String name, int score) 
    {
        String query = "INSERT INTO highscore (bruger, score) VALUES (\'" + name + "\'," + score + ")";
        try 
        {
            Statement statement = conn.createStatement();
            statement.execute(query);

        } catch (SQLException ex){
            System.out.println(ex.toString());
        }
    } 
}
