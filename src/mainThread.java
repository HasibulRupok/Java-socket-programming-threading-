public class mainThread {
    public static void main(String[] args) {
        Thread t = Thread.currentThread(); //java has only one thread class that is Thread
        System.out.println("Thread name: "+ t);

        t.setName("mainThread");
        System.out.println("Thread name after change: "+ t);

        for (int i=0; i<5; i++){
            System.out.println("i = "+i);
            try {
                Thread.sleep(500); //it pause the CPU for 500ms
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
