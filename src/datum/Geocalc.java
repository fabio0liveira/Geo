package datum;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements methods for use on geodesic calculations.
 * 
 * @author Fabio Cardoso de Oliveira
 * 
 * @version 1.2
 * 
 */

public class Geocalc extends Elips {

	public Geocalc(int n) {
		super(n);

	}

	// RADIUS OF CURVATURE. MERIDIAN SECCTION (M).

	public double radFirstMerid(double fi) {

		double sin2 = Math.pow(Math.sin(Math.toRadians(fi)), 2.00);
		double e2 = firstEcc2();

		return a * (1 - e2) / Math.pow((1 - (e2 * sin2)), 1.50);
	}

	// RADIUS OF CURVATURE. FIRST VERTICAL SECCTION (N).

	public double radFirstNorm(double fi) {

		double sin2 = Math.pow(Math.sin(Math.toRadians(fi)), 2.00);
		double e2 = firstEcc2();

		return a / Math.pow((1 - (e2 * sin2)), 0.5);
	}

	// ECEF COORDINATES X,Y,Z.

	public List<Double> coordEcef(double fi, double lambda, double h) {

		List<Double> list = new ArrayList<>();

		double e2 = firstEcc2();
		double n = radFirstNorm(fi);
		double cosFi = Math.cos(Math.toRadians(fi));
		double sinFi = Math.sin(Math.toRadians(fi));
		double cosLambda = Math.cos(Math.toRadians(lambda));
		double sinLambda = Math.sin(Math.toRadians(lambda));

		list.add(0, (n + h) * cosFi * cosLambda);

		list.add(1, (n + h) * cosFi * sinLambda);

		list.add(2, ((n * (1 - e2)) + h) * sinFi);

		return list;

	}

	// CONVERSION GRS80 TO GRS67. IBGE CONVERSION PARAMETERS.

	public List<Double> grs80To67(double fi, double lambda, double h) {

		List<Double> list = new ArrayList<>();

		list.add(0, coordEcef(fi, lambda, h).get(0) + 67.35);
		list.add(1, coordEcef(fi, lambda, h).get(1) - 03.88);
		list.add(2, coordEcef(fi, lambda, h).get(2) + 38.22);

		return list;

	}

	// CONVERSION GRS67 TO GRS80. IBGE CONVERSION PARAMETERS.

	public List<Double> grs67To80(double fi, double lambda, double h) {

		List<Double> list = new ArrayList<>();

		list.add(0, coordEcef(fi, lambda, h).get(0) - 67.35);
		list.add(1, coordEcef(fi, lambda, h).get(1) + 03.88);
		list.add(2, coordEcef(fi, lambda, h).get(2) - 38.22);

		return list;

	}

	// CALCULATES MERIDIAN CONVERGENCE. UTM PROJECTION.

	public double meridianConv(double fi, double lambda) {

		double mC = 0.00;
		double factor;

		// GETS UTM ZONE AND CALCULATES CENTRAL MERIDIAN VALUE.
		// !!! cálculos aproximados. melhorar.

		if (lambda >= 0) {
			mC = (((lambda / 6) - ((lambda / 6) % 1)) * 6) + 3;
		}
		if (lambda < 0) {
			mC = (((lambda / 6) - ((lambda / 6) % 1)) * 6) - 3;
		}

		if (lambda < mC && fi < 0.00) { // SOUTH HEMISPHERE
			factor = 1; // WEST FROM C.M
		} else {
			factor = -1; // EAST FROM C.M
		}
		if (lambda < mC && fi > 0.00) { // NORTH HEMISPHERE
			factor = -1; // WEST FROM C.M
		} else {
			factor = 1; // EAST FROM C.M
		}

		return (Math.abs(lambda) - Math.abs(mC)) * (Math.abs(Math.sin(Math.toRadians(fi)))) * factor;

	}

	// PRINTS GENERAL ELLIPSOID PARAMETERS

	public String toString() {

		return "Ellipsoid-> " + Elips.name + "; Semimajor axis-> " + String.format("%.3f", Elips.a)
				+ "; Semiminor axis-> " + String.format("%.3f", Elips.b);
	}

	// CONVERT FROM DD TO DMS

	public Double[] ddTodms(double coord) {

		double sign = 1;
		double dd;
		Double[] dms = new Double[3];

		if (coord < 0) {
			sign = -1;
		}

		if (coord >= 0) {
			sign = 1;
		}

		dd = Math.abs(coord);

		dms[0] = ((dd) - (dd % 1)) * sign;
		dms[1] = ((dd % 1) * 60) - (((dd % 1) * 60) % 1);
		dms[2] = (((dd % 1) * 60) % 1) * 60;

		return dms;

	}

	// CONVERT FROM DMS TO DD

	public double dmsTodd(double[] coord) {

		double sign = 1;

		if (coord[0] < 0) {
			sign = -1;
		}

		return (Math.abs(coord[0]) + (coord[1] / 60) + (coord[2] / 3600)) * sign;

	}

}
