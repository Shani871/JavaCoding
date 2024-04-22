class Sk implements Runnable{
    @Override
    public void run() {
        System.out.println("Runnable Threads");

    }
}
public class RunnableThread {
    public static void main(String[] args) {
        Sk a = new Sk();
        Thread t = new Thread(a);
        t.start();
    }

}
