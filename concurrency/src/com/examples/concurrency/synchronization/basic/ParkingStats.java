package com.examples.concurrency.synchronization.basic;

public class ParkingStats {
	private long numberCars;
	private long numberMotorcycles;
	private ParkingCash cash;

	public ParkingStats(ParkingCash cash) {
		numberCars = 0;
		numberMotorcycles = 0;
		this.cash = cash;
	}

	/**
	 * Increment counter when car comes in
	 */
	public void carComeIn() {
		numberCars++;
	}

	/**
	 * Decrement counter & increment cash when car leaves.
	 */
	public void carGoOut() {
		numberCars--;
		cash.vehiclePay();
	}
	
	/**
	 * Increment counter when bike comes in
	 */
	public void motoComeIn() {
		numberMotorcycles++;
	}
	
	/**
	 * Decrement counter & increment cash when bike leaves.
	 */
	public void motoGoOut() {
		numberMotorcycles--;
		cash.vehiclePay();
	}

	public long getNumberCars() {
		return numberCars;
	}


	public long getNumberMotorcycles() {
		return numberMotorcycles;
	}
	
}
