public class DBSingletonDemo {

    public static void main(String[] args) {
        DBSingleton instance = DBSingleton.getInstance();
        System.out.println(instance);
        DBSingleton aninstance = DBSingleton.getInstance();
        System.out.println(aninstance);


    }
}
