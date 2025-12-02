import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class App {
    public static void main(String[] args) {
        // Vulnerable: Hardcoded credentials
        String username = "admin";
        String password = "password123";

        // Vulnerable: SQL Injection (using concatenation)
        String userInput = "1 OR 1=1"; // Simulating user input
        String query = "SELECT * FROM users WHERE id = " + userInput;

        try {
            // Vulnerable: No SSL, no secure handling
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb", username, password);
            Statement stmt = conn.createStatement();
            stmt.executeQuery(query);

            // Vulnerable: Empty catch block
        } catch (Exception e) {
        }

        // Vulnerable: Weak random usage
        double randomValue = Math.random();
        System.out.println("Random value: " + randomValue);

        // Vulnerable: Hardcoded secret in code
        String apiKey = "12345-SECRET-API-KEY";
        System.out.println("API Key: " + apiKey);

        // Buggy: Empty method
        doNothing();
    }

    private static void doNothing() {
        // This method intentionally left empty (code smell)
    }
}
