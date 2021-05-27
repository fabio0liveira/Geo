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
		 listIn.add(3, -19.20);
		 listIn.add(4, -38.40);
		 listIn.add(5, 101.50);
		 listIn.add(6, -19.15);
		 listIn.add(7, -38.45);
		 listIn.add(8, 102.00);
		 
		 System.out.println(geo.ddToHorizon(listIn));
		 

	}

}
