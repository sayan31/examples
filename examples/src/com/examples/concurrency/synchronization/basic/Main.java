package com.examples.concurrency.synchronization.basic;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ParkingCash cash = new ParkingCash();
		ParkingStats stats = new ParkingStats(cash);

		System.out.printf("Parking Simulator\n");

		// Create Sensor tasks
		int numberSensors = 2 * Runtime.getRuntime().availableProcessors();
		Thread threads[] = new Thread[numberSensors];
		for (int i = 0; i < numberSensors; i++) {
			Sensor sensor = new Sensor(stats);
			Thread thread = new Thread(sensor);
			thread.start();
			threads[i] = thread;
		}

		// Wait for threads to complete
		for (int i = 0; i < numberSensors; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.printf("Number of sensors: %d\n", numberSensors);
		System.out.printf("Number of cars: %d\n", stats.getNumberCars());
		System.out.printf("Number of motorcycles: %d\n", stats.getNumberMotorcycles());
		cash.close();
	}

}
