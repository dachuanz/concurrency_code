package extthread;

public class Run {
public static void main(String[] args) {
	for (int i = 0; i < 5; i++) {
		MyThread1 myThread1 = new MyThread1();
		myThread1.setPriority(1);
		myThread1.start();
		MyThread2 myThread2= new MyThread2();
		myThread2.setPriority(10);
		myThread2.start();
		
	}
}
}
