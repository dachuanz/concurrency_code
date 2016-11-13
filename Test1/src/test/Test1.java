package test;

/**
 * 
 * 没有使用同步锁使用wait 方法
 */
public class Test1 {
	public static void main(String[] args) {

		try {
			String newString = new String("");
			newString.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
