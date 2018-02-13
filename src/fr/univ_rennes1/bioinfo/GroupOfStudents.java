package fr.univ_rennes1.bioinfo;

import java.util.Vector;

/**
 * 
 */

/**
 * @author olivier
 *
 */
public class GroupOfStudents extends Vector<Student> {
	
	public double getMinGrade() {
		double minGrade = 20.;
		for (Student currentStudent : this) {
			minGrade = Math.min(minGrade, currentStudent.getGrade());
		}
		return minGrade;
	}
	
	public double getMaxGrade() {
		double maxGrade = 0.;
		for (Student currentStudent : this) {
			maxGrade = Math.max(maxGrade, currentStudent.getGrade());
		}
		return maxGrade;
	}
	
	public double getAverageGrade() {
		double average = 0.;
		for (Student currentStudent : this) {
			average += currentStudent.getGrade();
		}
		return average / this.size();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		
		System.out.println("Grade min: " + m1bio.getMinGrade());
		System.out.println("Grade max: " + m1bio.getMaxGrade());
		System.out.println("Average: " + m1bio.getAverageGrade());

	}

}
