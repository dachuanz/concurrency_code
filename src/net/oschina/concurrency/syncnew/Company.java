package net.oschina.concurrency.syncnew;
/**
 * 
 * @author zdc52
 *
 */
public class Company implements Runnable {

	
	private Account account;
	
	
	public Company(Account account) {
		this.account=account;
	}
	
	
	public void run() {
		for (int i=0; i<100; i++){
			account.addAmount(1000);
		}
	}

}
