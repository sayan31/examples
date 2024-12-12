package com.examples.concurrency.synchronization.basic;

public class ParkingStats {
	private long numberCars;
	private long numberMotorcycles;
	private final Object controlCars, controlMotorcycles;
	private ParkingCash cash;

	public ParkingStats(ParkingCash cash) {
		numberCars = 0;
		numberMotorcycles = 0;
		this.cash = cash;
		this.controlCars = new Object();
		this.controlMotorcycles = new Object();
	}

	/**
	 * Increment counter when car comes in
	 */
	public void carComeIn() {
		synchronized (controlCars) {
			numberCars++;
		}
	}

	/**
	 * Decrement counter & increment cash when car leaves.
	 */
	public void carGoOut() {
		synchronized (controlCars) {
			numberCars--;
		}
		cash.vehiclePay();
	}
	
	/**
	 * Increment counter when bike comes in
	 */
	public void motoComeIn() {
		synchronized (controlMotorcycles) {
			numberMotorcycles++;
		}
	}
	
	/**
	 * Decrement counter & increment cash when bike leaves.
	 */
	public void motoGoOut() {
		synchronized (controlMotorcycles) {
			numberMotorcycles--;
		}
		cash.vehiclePay();
	}

	public long getNumberCars() {
		return numberCars;
	}


	public long getNumberMotorcycles() {
		return numberMotorcycles;
	}
	
}
