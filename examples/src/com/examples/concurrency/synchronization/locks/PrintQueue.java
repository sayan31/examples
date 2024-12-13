package com.examples.concurrency.synchronization.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
	private Lock queueLock;

	public PrintQueue(boolean fairMode) {
		queueLock = new ReentrantLock(fairMode);
	}

	public void printJob(Object document) {
		// Get Control of the lock object
		// If thread 1 requests ctrl with no other threads ctrling, lock() returns immediately to allow
		// thread 1 to execute.
		// If thread 2 has ctrl when thread 1 requests, thread 1 is put to sleep until thread 2 is done.
		queueLock.lock();

		// Simulate a print job
		try {
			Long duration = (long) (Math.random() * 10000);
			System.out.println(Thread.currentThread().getName() + ":PrintQueue: Printing a Job during "
					+ (duration / 1000) + " seconds");
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// free the control of the Lock object
			queueLock.unlock();
		}

		// Get Control of the lock object
		queueLock.lock();

		// Simulate a print job
		try {
			Long duration = (long) (Math.random() * 10000);
			System.out.println(Thread.currentThread().getName() + ":PrintQueue: Printing a Job during "
					+ (duration / 1000) + " seconds");
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// free the control of the Lock object
			queueLock.unlock();
		}
	}
}
