package net.oschina.concurrency.sync;

/**
 * 
 * @author zdc52
 *
 */
public class Account {

	private double balance;

	public double getBalance() {
		return balance;
	}

	/**
	 * 
	 * 
	 *
	 *        
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * 
	 * 
	 * ‘ˆº”
	 * 
	 */
	public void addAmount(double amount) {
		double tmp = balance;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tmp += amount;
		balance = tmp;
	}

	/**
	 * 
	 * 
	 * ºı…Ÿ
	 * 
	 */
	public void subtractAmount(double amount) {
		double tmp = balance;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tmp -= amount;
		balance = tmp;
	}

}
