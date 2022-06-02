package ratelimiter;


public class MultiThread implements Runnable {

	static int COUNTER = 0;

	public void run() {

		for (int i = 0; i < COUNTER; i++) {

			synchronized (this) {

				if (Thread.currentThread().getName().equals("EVEN") && (COUNTER % 2 == 0)) {
					System.out.println(Thread.currentThread().getName() + " " + COUNTER);

					try {
						this.notifyAll();
						++COUNTER;
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else if (COUNTER % 2 == 1) {
					System.out.println(Thread.currentThread().getName() + " " + COUNTER);
					try {
						this.notifyAll();
						++COUNTER;
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					try {
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static void main(String[] arhs) {

		MultiThread obj = new MultiThread();
		Thread th1 = new Thread(obj);
		Thread th2 = new Thread(obj);
		th1.setName("EVEN");
		th2.setName("ODD");


		th1.start();
		th2.start();

	}

}
