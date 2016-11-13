package extthread;

public class MyThread2 extends Thread {

	Object lock;

	public MyThread2(Object lock) {
		super();
		this.lock = lock;
	}

	@Override
	public void run() {
		synchronized (lock) {
			System.out.println("begin notify" + System.currentTimeMillis());

			lock.notify();

			System.out.println("end notify" + System.currentTimeMillis());
		}
	}

}
