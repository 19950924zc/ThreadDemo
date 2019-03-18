package cn.zc.thread;
//����̶߳����
public class MultiThread {

	private static int num = 0;

	public static synchronized void printNum(String arg) {
		try {
			if (arg.equals("a")) {
				num = 100;
				System.out.println("arg a, set num over!");
				Thread.sleep(10000);
			}else {
				num=200;
				 System.out.println("arg b, set num over!");
			}
			 System.out.println("arg " + arg + ", num = " + num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	 public static void main(String[] args) {
	        // ������ͬ�Ķ���
	        final MultiThread m1 = new MultiThread();
	        final MultiThread m2 = new MultiThread();
	        
	        Thread t1 = new Thread(new Runnable() {
	            @Override
	            public void run() {
	                m1.printNum("a");
	            }
	        });
	        
	        Thread t2 = new Thread(new Runnable() {
	            @Override
	            public void run() {
	                m1.printNum("b");
	            }
	        });
	        
	        t1.start();
	        t2.start();
	    }
}
