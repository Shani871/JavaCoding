public class BankTrans implements Runnable {

    private int amount = 0;

    @Override
    public synchronized void run() {
        if(Thread.currentThread().getName().equals("withdraw")){
            System.out.println("Entering to withdraw amount");
            //Trying to withdraw 5000
            if(this.amount >= 5000){
                this.amount -= 5000;
            }else{
                try {
                    System.out.println("Insufficient balance and waiting for deposit....");
                    wait();
                    this.amount -= 5000;
                    System.out.println("Amount withdraw completed successfully :)");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }else{
            //Depositing 10000 in user account;
            System.out.println("Entering to deposit amount");
            this.amount += 10000;
            System.out.println("Amount deposited and notifying....");
            notify();
        }
    }

    public static void main(String[] args) {
        BankTrans obj = new BankTrans();
        Thread withDraw = new Thread(obj, "withdraw");
        Thread deposit = new Thread(obj, "deposit");
        withDraw.start();
        deposit.start();
    }
}
