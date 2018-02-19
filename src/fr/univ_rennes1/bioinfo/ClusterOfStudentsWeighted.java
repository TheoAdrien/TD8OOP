package fr.univ_rennes1.bioinfo;

import java.util.ArrayList;

/**
 * 
 */

/**
 * @author olivier
 *
 */
public class ClusterOfStudentsWeighted extends ClusterOfStudents{
	
	private double weight = 0.;
	private double dist = 0.;
	
	public ClusterOfStudentsWeighted(){
		// TODO: DO SOMETHING HERE
	}
	
	public ClusterOfStudentsWeighted(Student aStudent){
		// TODO: DO SOMETHING HERE
	}
	
	public ClusterOfStudentsWeighted(GroupOfStudents aGroupOfStudents) {
		// TODO: DO SOMETHING HERE
	}
	
	public ClusterOfStudentsWeighted(ClusterOfStudentsWeighted cluster1, ClusterOfStudentsWeighted cluster2) {
		// TODO: DO SOMETHING HERE
	}
	
	public void clusterize() {
		// TODO: DO SOMETHING HERE
	}
	
	protected String getNewickIntermediate() {
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
		
		// TODO: uncomment when needed
		//ClusterOfStudentsWeighted bioCluster = new ClusterOfStudentsWeighted(m1bio);
		//System.out.println("Before clustering:");
		//System.out.println(bioCluster.getNewick());
		//bioCluster.clusterize();
		//System.out.println("");
		//System.out.println("After clustering:");
		//System.out.println(bioCluster.getNewick());
		
		// TODO: uncomment when needed
		//System.out.println("");
		//ClusterOfStudentsWeighted bioAnonymous = new ClusterOfStudentsWeighted(GroupOfStudentsLoader.loadTsvFile("/path/to/grades_final_anonymized.tsv"));
		//bioAnonymous.clusterize();
		//System.out.println(bioAnonymous.getNewick());
		
		// TODO: uncomment when needed
		//GroupOfStudents od = new GroupOfStudents();
		//od.add(geo);
		//od.add(loulou);
		//od.add(donald);
		//ClusterOfStudentsWeighted odCluster = new ClusterOfStudentsWeighted(od);
		//odCluster.clusterize();
		//System.out.println("");
		//System.out.println(odCluster.getNewick());

	}

}
