
class NewThread implements Runnable{  // now it works as a Thread
    Thread t;
    int threadNo;
    NewThread(int threadNo){
        this.threadNo = threadNo;
        t = new Thread(this,"NewThread");
        t.start(); //it moves to run method
    }

    @Override
    public void run() {
        for (int i =0; i<5; i++){
            System.out.println("Child thread "+ threadNo +", i= "+ i);
            try {
                Thread.sleep(500); // if we remove this sleep then code will execute randomly
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

public class RunnableThread {
    public static void main(String[] args) {
        System.out.println("main started");

        NewThread nt1 = new NewThread(1); //main will execute last prints statement first then this 2 line will
        NewThread nt2 = new NewThread(2);// execute. to stop this we need to use a function called 'join'

        System.out.println("Thread 1 is alive: "+ nt1.t.isAlive());  //print TRUE
        System.out.println("Thread 2 is alive: "+ nt2.t.isAlive());

        try {
            nt1.t.join();     //it will wait until nt1 is dead
            nt2.t.join();     //it will wait until nt2 is dead
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread 1 is alive: "+ nt1.t.isAlive());   //print FALSE
        System.out.println("Thread 2 is alive: "+ nt2.t.isAlive());

        System.out.println("main end");
    }
}
