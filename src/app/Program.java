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
		List<Double> listIn2 = new ArrayList<>();
		

		listIn.add(0, -29.9256478361111);
		listIn.add(1, -55.7397836388889);
		listIn.add(2, 123.23441);
		listIn.add(3, -29.927036725);
		listIn.add(4, -55.7406169722222);
		listIn.add(5, 123.42144);
		listIn.add(6, -29.9273145027778);
		listIn.add(7, -55.7414503055556);
		listIn.add(8, 97.45674);
		listIn.add(9, -29.9281478361111);
		listIn.add(10, -55.7420058611111);
		listIn.add(11, 124.45674);
		listIn.add(12, -29.9298145027778);
		listIn.add(13, -55.7422836388889);
		listIn.add(14, 163.45671);
		listIn.add(15, -29.9303700583333);
		listIn.add(16, -55.7425614166667);
		listIn.add(17, 123.45671);
		listIn.add(18, -29.9312033916667);
		listIn.add(19, -55.7439503055556);
		listIn.add(20, 121.45672);
		listIn.add(21, -29.9317589472222);
		listIn.add(22, -55.7456169722222);
		listIn.add(23, 98.81442);
		listIn.add(24, -29.9323145027778);
		listIn.add(25, -55.7470058611111);
		listIn.add(26, 173.45679);

		System.out.println(geo.ddToHorizon(listIn));
		System.out.println();

		System.out.println("---------------------------------------------------------------------");

		int j = 0;
		for (int i = 0; i < (geo.ddToHorizon(listIn)).size(); i += 3) {

			listIn2.add(j, (geo.ddToHorizon(listIn)).get(i));
			listIn2.add(j + 1, (geo.ddToHorizon(listIn)).get(i + 1));
			j += 2;

		}

		System.out.println(geo.gaussArea(listIn2));
		System.out.println();

	}

}
