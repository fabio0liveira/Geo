package datum;

/**
 * This class creates an object type ellipsoid. It can be GRS80 or GRS67
 * ellipsoid.
 * 
 * @author Fabio Cardoso de Oliveira
 * 
 * @version 1.1
 * 
 */

public class Elips {

	protected static Double a;
	protected static Double b;
	protected static String name;

	public Elips(int n) {

		switch (n) {

		case 2000: // GRS80 ELLIPSOID
			Elips.a = 6378136.9999999995638601115234255;
			Elips.b = 6356752.314140347;
			Elips.name = "GRS80";
			break;

		case 69: // GRS67 ELLIPSOID
			Elips.a = 6378160.0000;
			Elips.b = 6356774.7192;
			Elips.name = "GRS67";
			break;

		}

	}

	public static double flat() { // FLATTENING.
		return (a - b) / a;
	}

	public static double firstEcc2() { // FIRST ECCENTRICITY SQUARED.

		return ((a * a) - (b * b)) / (a * a);

	}

	public static double firstEcc() { // FIRST ECCENTRICITY.

		return Math.sqrt(firstEcc2());

	}

	public static double secondEcc2() { // SECOND ECCENTRICITY SQUARED.

		return (a * a) - (b * b) / (b * b);

	}

	public static double secondEcc() { // SECOND ECCENTRICITY.
		return Math.sqrt(secondEcc2());

	}

}
