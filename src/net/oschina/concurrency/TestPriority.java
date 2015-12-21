package net.oschina.concurrency;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.State;

public class TestPriority {
	/**
	 * * Thread.setPriority()可能根本不做任何事情，这跟你的操作系统和虚拟机版本有关
* 线程优先级对于不同的线程调度器可能有不同的含义，可能并不是你直观的推测。特别地，优先级并不一定是指CPU的分享。在UNIX系统，优先级或多或少可以认为是CPU的分配，但Windows不是这样
* 线程的优先级通常是全局的和局部的优先级设定的组合。Java的setPriority()方法只应用于局部的优先级。换句话说，你不能在整个可能的范围 内设定优先级。（这通常是一种保护的方式，你大概不希望鼠标指针的线程或者处理音频数据的线程被其它随机的用户线程所抢占）
* 不同的系统有不同的线程优先级的取值范围，
* 但是Java定义了10个级别（1-10）。
* 这样就有可能出现几个线程在一个操作系统里有不同的优先级，
* 在另外一个操作系统里却有相同的优先级（并因此可能有意想不到的行为）
* 操作系统可能（并通常这么做）根据线程的优先级给线程添加一些专有的行为
* （例如”only give a quantum boost if the priority is below X“）。这里再重复一次
* ，优先级的定义有部分在不同系统间有差别。
* 大多数操作系统的线程调度器实际上执行的是在战略的角度上对线程的优先级做临时操作
* （例如当一个线程接收到它所等待的一个事件或者I/O），通常操作系统知道最多，试图手工控制优先级可能只会干扰这个系统。
* 你的应用程序通常不知道有哪些其它进程运行的线程，所以对于整个系统来说，
* 变更一个线程的优先级所带来的影响是难于预测的。例如你可能发现，你有一个预期 
* 为偶尔在后台运行的低优先级的线程几乎没有运行，原因是一个病毒监控程序在一个稍微高一点的优先级（但仍然低于普通的优先级）上运行，并且无法预计你程序 的性能，它会根据你的客户使用的防病毒程序不同而不同。
	 * @param args
	 */
	public static void main(String[] args) {

		// Thread priority infomation 
		System.out.printf("Minimum Priority: %s\n",Thread.MIN_PRIORITY);
		System.out.printf("Normal Priority: %s\n",Thread.NORM_PRIORITY);
		System.out.printf("Maximun Priority: %s\n",Thread.MAX_PRIORITY);
		
		Thread threads[];
		Thread.State status[];
		
		
		threads=new Thread[10];
		status=new Thread.State[10];
		for (int i=0; i<10; i++){
			threads[i]=new Thread(new Calculator(i));
			if ((i%2)==0){
				threads[i].setPriority(Thread.MAX_PRIORITY);
			} else {
				threads[i].setPriority(Thread.MIN_PRIORITY);
			}
			threads[i].setName("Thread "+i);
		}
		
		
		
		try (FileWriter file = new FileWriter("log.txt");PrintWriter pw = new PrintWriter(file);){
			
			for (int i=0; i<10; i++){
				pw.println("Main : Status of Thread "+i+" : "+threads[i].getState());
				status[i]=threads[i].getState();
			}

			for (int i=0; i<10; i++){
				threads[i].start();
			}
			
			boolean finish=false;
			while (!finish) {
				for (int i=0; i<10; i++){
					if (threads[i].getState()!=status[i]) {
						writeThreadInfo(pw, threads[i],status[i]);
						status[i]=threads[i].getState();
					}
				}
				
				finish=true;
				for (int i=0; i<10; i++){
					finish=finish &&(threads[i].getState()==State.TERMINATED);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	private static void writeThreadInfo(PrintWriter pw, Thread thread, State state) {
		pw.printf("Main : Id %d - %s\n",thread.getId(),thread.getName());
		pw.printf("Main : Priority: %d\n",thread.getPriority());
		pw.printf("Main : Old State: %s\n",state);
		pw.printf("Main : New State: %s\n",thread.getState());
		pw.printf("Main : ************************************\n");
	}

}
