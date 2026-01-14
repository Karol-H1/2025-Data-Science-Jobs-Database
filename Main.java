/* CS286-Fall25*/
/*main*/
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
public class Main {
/* Get skills by candidate id */
public static void salariesForSkill(String skill) {
//
String query = "{ call skill_salary(?) }";
ResultSet rs;
try (Connection conn = datajobjdbc.getConnection(); //Create a connection
CallableStatement stmt = conn.prepareCall(query)) // Define statement
{
stmt.setString(1, skill);
rs = stmt.executeQuery(); // Execute Statement
while (rs.next()) {
System.out.println(String.format("$%s - %s",
rs.getString("salary"),
rs.getString("sname")));
}
} catch (SQLException ex) {
System.out.println(ex.getMessage());
}
}
public static void main(String[] args) {
salariesForSkill("r");
}
}