package fr.univ_rennes1.bioinfo;

import java.util.ArrayList;


/**
 * Represents a cluster of objects.
 * Some of these objects can be clusters.
 * 
 * @author Olivier Dameron
 *
 */
public class ClusterOfStudents {
	
	protected ArrayList<ClusterOfStudents> subClusters;
	protected ArrayList<Student> students;
	
	public ClusterOfStudents(){
		// TODO: DO SOMETHING HERE
	}
	
	public ClusterOfStudents(Student aStudent){
		// TODO: DO SOMETHING HERE
	}
	
	public ClusterOfStudents(GroupOfStudents aGroupOfStudents) {
		// TODO: DO SOMETHING HERE
	}
	
	public ClusterOfStudents(ClusterOfStudents cluster1, ClusterOfStudents cluster2) {
		// TODO: DO SOMETHING HERE
	}
	
	public double getAverageGrade() {
		// TODO: DO SOMETHING HERE
	}
	
	public double distance(ClusterOfStudents aCluster) {
		// TODO: DO SOMETHING HERE
	}
	
	
	public void clusterize() {
		// TODO: DO SOMETHING HERE
	}
	
	protected String getNewickIntermediate() {
		// TODO: DO SOMETHING HERE
	}
	
	public String getNewick() {
		// TODO: DO SOMETHING HERE
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
		
		ClusterOfStudents bioCluster = new ClusterOfStudents(m1bio);
		System.out.println("Before clustering:");
		System.out.println(bioCluster.getNewick());
		bioCluster.clusterize();
		System.out.println("");
		System.out.println("After clustering:");
		System.out.println(bioCluster.getNewick());
		
		System.out.println("");
		ClusterOfStudents bioAnonymous = new ClusterOfStudents(GroupOfStudentsLoader.loadTsvFile("/path/to/grades_final_anonymized.tsv"));
		bioAnonymous.clusterize();
		System.out.println(bioAnonymous.getNewick());
	}

}
