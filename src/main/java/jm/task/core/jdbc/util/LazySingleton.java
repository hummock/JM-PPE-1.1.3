package jm.task.core.jdbc.util;

public class LazySingleton {
    private static LazySingleton instance = null;
    private LazySingleton() {}
    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized(LazySingleton.class) {
                instance = new LazySingleton();
            }
        }
        return instance;
    }
}
