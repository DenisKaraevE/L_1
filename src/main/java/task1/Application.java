package task1;

class Connection {

    private static Connection instance;

    private Connection() {}

    // всякие разные методы данного класса
    // .
    // .
    // .
    // конец всяких методов

    public static Connection getInstance() {
        if(null != instance)
            return instance;

        instance = new Connection();
        return instance;
    }

}

class SingletonService {

    public void exec() {
        Connection connection1 = Connection.getInstance();
        Connection connection2 = Connection.getInstance();

        System.out.println(connection1.toString());
        System.out.println(connection2.toString());
    }
}

class Application {

    public static void main(String[] args) {
        SingletonService service = new SingletonService();
        service.exec();
    }

}
