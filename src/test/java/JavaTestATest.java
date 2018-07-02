//import org.junit.Before;
//
//import static org.testng.Assert.*;
//
//public class JavaTestATest {
//    public static void main(String[] args) {
//        ThreadDemo td = new ThreadDemo();
//        new Thread(td).start();
//
//        while (true) {
//            if (td.isFlag()){
//                System.out.println("xxxxxxxxxxxxxxx");
//                break;
//            }
//        }
//    }
//}
//
//class ThreadDemo implements Runnable {
//
//    private volatile boolean flag = false;
//
//
//    public void run() {
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        flag = true;
//        System.out.println("flag= " + flag);
//    }
//
//    public boolean isFlag() {
//        return flag;
//    }
//
//    public void setFlag(boolean flag) {
//        this.flag = flag;
//    }
//
//}