package extthread;
/**
 * 
 * @author ibm
 *
 */
public class Run {
	public static void main(String[] args) throws InterruptedException {
		Object object = new Object();
		ThreadA a = new ThreadA(object);
		a.start();
		Thread.sleep(50);
		ThreadB b = new ThreadB(object);
		b.start();

	}
}
