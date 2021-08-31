package Activity;
public class Car 
{
	String color;
	String transmission;
	int make;
	int tyres;
	int doors;

	//Constructor
	Car() 
	{
		tyres = 4;
		doors = 4;
	}

	public void displayCharacterstics(){
		System.out.println("Car Color is " + color);
		System.out.println("Car Transmission is " + transmission);
		System.out.println("Car Make is " + make);
		System.out.println("Car has tyres " + tyres);
		System.out.println("Car has doors " + doors);
	}

	public void accelerate() {
		System.out.println("Car is moving forward.");
	}

	public void brake() {
		System.out.println("Car has stopped.");
	}
}