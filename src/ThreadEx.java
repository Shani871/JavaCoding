import static java.lang.Thread.sleep;

class A extends Thread {
    public void run() {
        System.out.println("Threading Running");
        for (int i = 0; i < 5; i++) {
            System.out.println("Shani");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class ThreadEx {
    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        a.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("Chauhan");
            sleep(1000);
        }
    }
}
