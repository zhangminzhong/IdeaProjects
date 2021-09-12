import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * User: zhang
 * Date: 16-10-19
 * Time: 下午1:43
 * To change this template use File | Settings | File Templates.
 */
public class Test {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test_db","root","root");
            Statement stmt = conn.createStatement();
            String sql = "select * from tb_dept1";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                System.out.println("id="+rs.getInt("id")+",name="+rs.getString("name")+",location="+rs.getString("location"));
            }
            System.out.println("end");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
