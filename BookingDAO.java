import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class BookingDAO {
    public int getBookedCount(int busNo, Date date) throws SQLException {
        String query = "SELECT count(passenger_name) FROM booking WHERE bus_no=? and travel_date=?";
        Connection con = DbConnection.getConection();
        PreparedStatement pst = con.prepareStatement(query);
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        pst.setInt(1,busNo);
        pst.setDate(2,sqlDate);
        ResultSet rs = pst.executeQuery();
        rs.next();
        return  rs.getInt(1);
    }
    public void addBookings(Booking booking) throws SQLException {
        String query = "INSERT INTO booking VALUES(?,?,?)";
        Connection con = DbConnection.getConection();
        PreparedStatement pst = con.prepareStatement(query);
        java.sql.Date sqlDate = new java.sql.Date(booking.getDate().getTime());
        pst.setString(1,booking.getPassengerName());
        pst.setInt(2,booking.getBusNo());
        pst.setDate(3,sqlDate);
        pst.executeUpdate();
    }
}
