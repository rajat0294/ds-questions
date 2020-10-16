package practice;


public class ShutdownhookTest
{
    public static void main(String[] args) throws InterruptedException {
        Runtime.getRuntime().addShutdownHook(new Thread()
        {
            public void run()
            {
                System.out.println("Shutdown Hook is running !");
            }
        });
        try {
            Thread.sleep(30000);
        }catch (InterruptedException e){

        }
    }
}
