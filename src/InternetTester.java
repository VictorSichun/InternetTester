import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InternetTester {

    public static void main(String[] args) throws InterruptedException, IOException {
        Thread t = Thread.currentThread();
        String anything = "";
        String[] command = {"ping", "www.google.co.nz"};
        ProcessBuilder builder = new ProcessBuilder(command);
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        while (true){
            anything = r.readLine();
            if(anything.contains("cannot")){
                System.out.println(anything);

                System.out.println("tester: preparing the next run...");

                System.out.println("tester: restart in 3s...");
            }
            else{
                System.out.println(anything);
                System.out.println("tester: Congrats! Internet works!");
                break;
            }
            t.sleep(3000);
            p = builder.start();
            r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        }
    }
}
