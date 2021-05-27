package datum;
/**
 * @author: Fabio Cardoso de Oliveira
 * 
 * @version 1.1
 */

import java.util.ArrayList;
import java.util.List;

public class LinearT {

	/**
	 * rotX, rotY, rotZ - Linear transformations for a 3D cartesian dextrogyre
	 * system.
	 * 
	 * The method receives a list of elements{x,y,z,x,y,z,...} and the angle of
	 * rotation teta, with negative angles for clockwise rotation and positive
	 * angles for counter clockwise rotation. rotX is the rotation arround de X axi,
	 * rotY rotation arround Y axi and rotZ arround Z axi. For translation enter the
	 * dx, dy and dz values too. For a 2D system transformation just use rotZ
	 * passing 0 value to Z coordinate.
	 * 
	 */

	public List<Double> rotX(List<Double> listIn, double teta) {

		double sinT = Math.sin(Math.toRadians(teta));
		double cosT = Math.cos(Math.toRadians(teta));
		List<Double> listOut = new ArrayList<>();

		for (int i = 0; i < listIn.size(); i += 3) {

			listOut.add(i, listIn.get(i));
			listOut.add(i + 1, listIn.get(i + 1) * cosT + (listIn.get(i + 2) * sinT));
			listOut.add(i + 2, (-1 * listIn.get(i + 1) * sinT) + (listIn.get(i + 2) * cosT));

		}

		return listOut;

	}

	public List<Double> rotX(List<Double> listIn, double teta, double dx, double dy, double dz) {

		double sinT = Math.sin(Math.toRadians(teta));
		double cosT = Math.cos(Math.toRadians(teta));
		List<Double> listOut = new ArrayList<>();

		for (int i = 0; i < listIn.size(); i += 3) {

			listOut.add(i, listIn.get(i) + dx);
			listOut.add(i + 1, listIn.get(i + 1) * cosT + (listIn.get(i + 2) * sinT) + dy);
			listOut.add(i + 2, (-1 * listIn.get(i + 1) * sinT) + (listIn.get(i + 2) * cosT) + dz);

		}

		return listOut;

	}

	public List<Double> rotY(List<Double> listIn, double teta) {

		double sinT = Math.sin(Math.toRadians(teta));
		double cosT = Math.cos(Math.toRadians(teta));
		List<Double> listOut = new ArrayList<>();

		for (int i = 0; i < listIn.size(); i += 3) {

			listOut.add(i, listIn.get(i) * cosT - (listIn.get(i + 2) * sinT));
			listOut.add(i + 1, listIn.get(i + 1));
			listOut.add(i + 2, (listIn.get(i) * sinT) + (listIn.get(i + 2) * cosT));

		}

		return listOut;

	}

	public List<Double> rotY(List<Double> listIn, double teta, double dx, double dy, double dz) {

		double sinT = Math.sin(Math.toRadians(teta));
		double cosT = Math.cos(Math.toRadians(teta));
		List<Double> listOut = new ArrayList<>();

		for (int i = 0; i < listIn.size(); i += 3) {

			listOut.add(i, listIn.get(i) * cosT - (listIn.get(i + 2) * sinT) + dx);
			listOut.add(i + 1, listIn.get(i + 1) + dy);
			listOut.add(i + 2, (listIn.get(i) * sinT) + (listIn.get(i + 2) * cosT) + dz);

		}

		return listOut;

	}

	public List<Double> rotZ(List<Double> listIn, double teta) {

		double sinT = Math.sin(Math.toRadians(teta));
		double cosT = Math.cos(Math.toRadians(teta));
		List<Double> listOut = new ArrayList<>();

		for (int i = 0; i < listIn.size(); i += 3) {

			listOut.add(i, listIn.get(i) * cosT + (listIn.get(i + 1) * sinT));
			listOut.add(i + 1, (-1 * listIn.get(i) * sinT) + (listIn.get(i + 1) * cosT));
			listOut.add(i + 2, listIn.get(i + 2));

		}

		return listOut;

	}

	public List<Double> rotZ(List<Double> listIn, double teta, double dx, double dy, double dz) {

		double sinT = Math.sin(Math.toRadians(teta));
		double cosT = Math.cos(Math.toRadians(teta));
		List<Double> listOut = new ArrayList<>();

		for (int i = 0; i < listIn.size(); i += 3) {

			listOut.add(i, listIn.get(i) * cosT + (listIn.get(i + 1) * sinT) + dx);
			listOut.add(i + 1, (-1 * listIn.get(i) * sinT) + (listIn.get(i + 1) * cosT) + dy);
			listOut.add(i + 2, listIn.get(i + 2) + dz);

		}

		return listOut;

	}

}
