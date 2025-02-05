import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BusDAO {
    public void displayInfo() throws SQLException {
        Connection con = DbConnection.getConection();
        String query = "SELECT * FROM bus";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next())
        {
            System.out.println("--------------------------------------------------");
            System.out.println("Bus No: " + rs.getInt(1));
            if(rs.getBoolean(2))
            {
                System.out.println("AC: YES");
            }
            else {
                System.out.println("AC: NO");
            }
            System.out.println("Capacity " + rs.getInt(3));
        }
        System.out.println("--------------------------------------------------");
    }

    public int getCapacity(int id) throws SQLException {
        Connection con = DbConnection.getConection();
        String query = "SELECT capacity FROM bus WHERE id = " + id;
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        rs.next();
        return rs.getInt(1);
    }
}
