package com.examples.concurrency.synchronization.locks;

public class Main {

	public static void main(String[] args) {
		System.out.printf("Running example with fair-mode =false\n");
		testPrintQueue(false);
		System.out.printf("Running example with fair-mode = true\n");
		testPrintQueue(true);

	}

	/**
	 * @param fairMode if true, then unlocking a section activates the thread waiting for the longest time
	 * fairMode if false, then unlocking a section activates any thread randomly  
	 */
	private static void testPrintQueue(Boolean fairMode) {
		PrintQueue printQueue = new PrintQueue(fairMode);

		Thread thread[] = new Thread[10];

		// create threads
		for (int i = 0; i < 10; i++) {
			thread[i] = new Thread(new PrintJob(printQueue), "Thread " + i);
		}

		// start threads
		for (int i = 0; i < 10; i++) {
			thread[i].start();
		}

		// wait for threads to finish
		for (int i = 0; i < 10; i++) {
			try {
				thread[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
