package fr.univ_rennes1.bioinfo;


/**
 * 
 */

/**
 * Simple student with an unique identifier and a grade.
 * 
 * @author olivier
 *
 */
public class Student {
	
	private String ident;
	private double grade;
	
	/**
	 * creates a student with his/her identifier and grade.
	 * 
	 * @param identifier
	 * @param grade
	 */
	public Student(String identifier, double grade) {
		this.ident = identifier;
		this.grade = grade;
	}
	
	public Student(String identifier) {
		this(identifier, 10.0);
	}
	
	public String getIdentifier() {
		return this.ident;
	}
	
	public double getGrade() {
		return this.grade;
	}
	
	public void setGrade(double newGrade) {
		this.grade = newGrade;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student riri = new Student("riri", 12.5);
		Student fifi = new Student("fifi", 14.0);
		Student loulou = new Student("loulou", 18.5);
		Student geo = new Student("geo", 19.5);
		Student donald = new Student("donald", 10.5);

	}

}
