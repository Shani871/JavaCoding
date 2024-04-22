package ThreadCode;
class A extends Thread{
    public void run(){
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getPriority());
    }
}

public class ThreadPirortiy {
    public static void main(String[] args) {
        A a = new A();
        A b = new A();
        A c = new A();
        a.setName("1 Thread");
        b.setName("2 Thread");
        c.setName("3 Thread");
        b.setPriority(8);
        a.start();
        b.start();
        c.start();

    }
}

