package extthread;

/**
 * 
 * @author ibm
 *
 */

public class ThreadA extends Thread {
	@Override
	public void run() {
		synchronized (lock) {
			if (MyList.size() != 5) {
				System.out.println("wait begin " + System.currentTimeMillis());
				try {
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("wait end " + System.currentTimeMillis());
			}
		}
	}

	Object lock;

	public ThreadA(Object lock) {
		super();
		this.lock = lock;
	}
}
