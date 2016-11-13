package test;

public class Test2 {
	public static void main(String[] args) {
		try {
			String lock = new String("");
			// 同步lock 字符串
			synchronized (lock) {

				lock.wait();
			}//脱离 同步
		}
		
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
