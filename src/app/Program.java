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

		listIn.add(0, -19.00);
		listIn.add(1, -38.00);
		listIn.add(2, 100.10);
		

		System.out.println(geo.ddToHorizon(listIn));

	}

}
