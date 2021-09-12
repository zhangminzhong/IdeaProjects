public class Main {
    private static final ThreadLocal<Object> THREAD_LOCAL = new ThreadLocal<Object>();
    public static void main(String[] args) {
        THREAD_LOCAL.set();
        THREAD_LOCAL.get();
    }
}
