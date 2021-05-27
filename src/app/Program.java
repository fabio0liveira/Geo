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

		coord[0] = -6.00;
		coord[1] = 19;
		coord[2] = 45.7;
		listIn.add(0, geo.dmsTodd(coord));
		coord[0] = -35.00;
		coord[1] = 28;
		coord[2] = 24.327;
		listIn.add(1, geo.dmsTodd(coord));
		listIn.add(2, 90.424);

		coord[0] = -6.00;
		coord[1] = 19;
		coord[2] = 48.674;
		listIn.add(3, geo.dmsTodd(coord));
		coord[0] = -35.00;
		coord[1] = 28;
		coord[2] = 23.011;
		listIn.add(4, geo.dmsTodd(coord));
		listIn.add(5, 91.692);

		coord[0] = -6.00;
		coord[1] = 19;
		coord[2] = 49.991;
		listIn.add(6, geo.dmsTodd(coord));
		coord[0] = -35.00;
		coord[1] = 28;
		coord[2] = 25.985;
		listIn.add(7, geo.dmsTodd(coord));
		listIn.add(8, 88.631);

		coord[0] = -6.00;
		coord[1] = 19;
		coord[2] = 47.015;
		listIn.add(9, geo.dmsTodd(coord));
		coord[0] = -35.00;
		coord[1] = 28;
		coord[2] = 27.301;
		listIn.add(10, geo.dmsTodd(coord));
		listIn.add(11, 85.488);

		System.out.println(geo.ddToHorizon(listIn));
		System.out.println(geo.gaussArea(geo.ddToHorizon(listIn))/10000);

	}

}
