package guide.Chapter06.DependencyInversionPrinciple.src.main.java.coding.challenge.bad;

public class ConnectToDatabase {

    public void connect(PostgreSQLJdbcUrl postgresql) {
        System.out.println("Connecting to " + postgresql.get());
    }
}
