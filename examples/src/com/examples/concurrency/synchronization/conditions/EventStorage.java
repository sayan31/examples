package com.examples.concurrency.synchronization.conditions;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Queue;

public class EventStorage {
	private int maxSize;
	private Queue<LocalDate> storage;

	public EventStorage() {
		maxSize = 10;
		storage = new LinkedList<>();
	}

	/**
	 * wait() stops the thread executing the sync method 
	 * notify() wakes up all the threads waiting in the wait method
	 */
	public synchronized void set() {
		while (storage.size() == maxSize) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		storage.offer(LocalDate.now());
		System.out.printf("Set: %d", storage.size());
		notify();
	}

	public synchronized void get() {
		while (storage.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		String element = storage.poll().toString();
		System.out.printf("Get: %d: %s\n", storage.size(), element);
		notify();

	}
}
