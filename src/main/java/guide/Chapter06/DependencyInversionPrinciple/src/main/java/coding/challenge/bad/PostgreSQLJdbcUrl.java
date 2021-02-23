package guide.Chapter06.DependencyInversionPrinciple.src.main.java.coding.challenge.bad;

public class PostgreSQLJdbcUrl {

    private final String dbName;

    public PostgreSQLJdbcUrl(String dbName) {
        this.dbName = dbName;
    }

    public String get() {
        return "jdbc:postgresql:// ... " + this.dbName;
    }
}
