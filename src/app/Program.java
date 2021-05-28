package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import datum.Geocalc;
//import datum.LinearT;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		Geocalc geo = new Geocalc(2000);

		// LinearT linT = new LinearT();

		List<Double> listIn = new ArrayList<>();
		double[] coord = new double[3];

		// teste 0de886b7-3412-4c81-a637-75aa8d9e33f5

		
		listIn.add(0, -19.00);
		listIn.add(1, -39.00);
		listIn.add(2, 0.00);
		listIn.add(3, -19.01);
		listIn.add(4, -39.01);
		listIn.add(5, 0.00);
		listIn.add(6, -18.99);
		listIn.add(7, -38.99);
		listIn.add(8, 0.00);
		
		

		//System.out.println(geo.ddToHorizon(listIn));
		geo.ddToHorizon(listIn);

	}

}
