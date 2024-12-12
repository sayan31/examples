package com.examples.concurrency.synchronization.basic;

import java.util.concurrent.TimeUnit;

/**
 * This class simulates movement of vehicles in the parking area.
 */
public class Sensor implements Runnable {

	private ParkingStats stats;

	public Sensor(ParkingStats stats) {
		this.stats = stats;
	}

	/**
	 *
	 */
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			// simulates the arrival of 2 cars
			stats.carComeIn();
			stats.carComeIn();

			try {
				TimeUnit.MILLISECONDS.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// simulates the arrival of 1 bike
			stats.motoComeIn();

			try {
				TimeUnit.MILLISECONDS.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			//simulates cars and bike leaving
			stats.motoGoOut();
			stats.carGoOut();
			stats.carGoOut();
		}

	}

}
