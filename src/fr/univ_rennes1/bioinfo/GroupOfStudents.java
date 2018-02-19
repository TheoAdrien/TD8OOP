package fr.univ_rennes1.bioinfo;

import java.util.ArrayList;


/**
 * @author Olivier Dameron
 *
 */
public class GroupOfStudents extends ArrayList<Student> {
	
	public double getMinGrade() {
		// TODO: DO SOMETHING HERE and uncomment the method call in the main(...)
	}
	
	public double getMaxGrade() {
		// TODO: DO SOMETHING HERE and uncomment the method call in the main(...)
	}
	
	public double getAverageGrade() {
		// TODO: DO SOMETHING HERE and uncomment the method call in the main(...)
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Student riri = new Student("riri", 12.5);
		Student fifi = new Student("fifi", 14.0);
		Student geo = new Student("geo", 19.5);
		Student donald = new Student("donald", 10.5);
		Student loulou = new Student("loulou", 18.5);
		
		GroupOfStudents m1bio = new GroupOfStudents();
		m1bio.add(riri);
		m1bio.add(fifi);
		m1bio.add(loulou);
		m1bio.add(geo);
		m1bio.add(donald);
		
		// TODO: uncomment when needed
		//System.out.println("Grade min: " + m1bio.getMinGrade());
		//System.out.println("Grade max: " + m1bio.getMaxGrade());
		//System.out.println("Average: " + m1bio.getAverageGrade());
	}

}
