package extthread;

public class MyThread1 extends Thread {

	Object lock;

	public MyThread1(Object lock) {
		super();
		this.lock = lock;
	}

	@Override
	public void run() {
		synchronized (lock) {
			System.out.println("开始等待时间" + System.currentTimeMillis());
			try {
				lock.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("结束等待时间" + System.currentTimeMillis());
		}
	}

}
