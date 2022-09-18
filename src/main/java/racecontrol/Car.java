/**
 * 
 */
package racecontrol;

import java.util.ArrayList;

/**
 * @author adolfob
 */

public class Car {

	private String brand;

	private String model;

	private String garageName;
	
	private Garage garage;

	private int distance;

	private int velocity;

	private final int MAX_SPEED = 250;

	public Car() {
	}

	public Car(String brand, String model) {
		this.brand = brand;
		this.model = model;
	}

	public Car(String brand, String model, String garageName) {
		this.brand = brand;
		this.model = model;
		this.garageName = garageName;
	}
	
	public Car(String brand, String model, String garageName, Garage garage) {
		this.brand = brand;
		this.model = model;
		this.garageName = garageName;
		this.garage = garage;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getGarageName() {
		return garageName;
	}

	public void setGarageName(String garageName) {
		this.garageName = garageName;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getVelocity() {
		// d = v * t
		
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}
	
	

	public Garage getGarage() {
		return this.garage;
	}

	public void setGarage(Garage garage) {
		this.garage = garage;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", model=" + model + ", Escuderia=" + garageName + ", distance=" + distance
				+ ", velocity=" + velocity + " Km/h" + "]";
	}

	/**
	 * New Car
	 */

	public void ramdomCars(int quantity) {
		int contador = 0;
		String marca[] = { "Alfa Romeo", "Isuzu", "Ferrari", "Skoda", "Mazda", "Nissan", "Renault", "Toyota" };
		String modelo[] = { "F8", "Aveo", "Giulia", "CX-30", "Captur" };

		System.out.println("===========================");
		System.out.println("==== Generando Coches: ====");
		System.out.println("===========================");

		for (int i = 0; i < quantity; i++) {

			int ramdomg = Utils.ramdomNuber(0, Utils.garages.size() - 1);
			int ramdomb = Utils.ramdomNuber(0, marca.length);
			int ramdomm = Utils.ramdomNuber(0, modelo.length);

			this.brand = marca[ramdomb];
			this.model = modelo[ramdomm];
			this.garageName = Utils.garages.get(ramdomg).getName();

			Garage garage = Utils.garages.get(ramdomg);

			Car car = new Car(brand, model, garageName, garage);
			garage.addCar(car);
			System.out.println(contador++ + ". Marca: " + car.getBrand() + ", Modelo: " + car.getModel() + ", Garage: "
					+ car.getGarageName());
		}

	}

	/**
	 * Print list of cars in garages
	 * 
	 * @return
	 */
	public void printListfOfCars() {
		int contador = 1;
		for (Garage garage : Utils.garages) {

			for (Car car : garage.getCars()) {
				System.out.println(contador++ + ". Marca: " + car.getBrand() + ", Modelo: " + car.getModel() + ", Garage: "
						+ car.getGarageName());
			}

		}

	}
	
	/**
	 * Return car list
	 * @return
	 */
	
	public ArrayList<Car> carsList() {
		ArrayList<Car> cars = new ArrayList<Car>();
		
		for (Garage garage : Utils.garages) {

			for (Car car : garage.getCars()) {
				cars.add(car);
			}

		}
		return cars;

	}
	
	/**
	 * Acelerar o desaelerar coche.
	 */
	
	public int acelerateCar() {
		int r = Utils.ramdomNuber(0, 2);
		boolean opt[] = { true, false};
		
		if(opt[r]) {
			return this.velocity - 10;
		}else {
			return this.velocity + 10;
		}
		
	}

	
	
	

}
