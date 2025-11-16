package com.threads.userDaemon;

public class DaemonDemo {

	public static void main(String[] args) {

		Runnable task1 = new MyRunner();
		Thread daemon = new Thread(task1, "daemon-thread-1");
		daemon.setDaemon(true);
		daemon.start();

		Runnable task2 = () -> {
			String thread = Thread.currentThread().getName();
			for (int i = 1; i <= 10; i++) {
				System.out.printf("[Thread: %s] 5 * %2d = %2d\n", thread, i, 5 * i);

				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Thread user = new Thread(task2, "user-thread-1");
		user.start();
	}
}

class MyRunner implements Runnable {

	@Override
	public void run() {
		String thread = Thread.currentThread().getName();
		for (int i = 1; i <= 10; i++) {
			System.out.printf("[Thread: %s] 5 * %2d = %2d\n", thread, i, 5 * i);

			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
