package fr.univ_rennes1.bioinfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Represents a cluster of objects.
 * Some of these objects can be clusters.
 * 
 * @author olivier
 *
 */
public class Cluster {
	
	protected List<Cluster> subClusters;
	protected Vector<Student> students;
	
	public Cluster(){
		this.subClusters = new ArrayList<Cluster>(0);
		this.students = new Vector<Student>();
	}
	
	public Cluster(Student aStudent){
		this.subClusters = new ArrayList<Cluster>(0);
		this.students = new Vector<Student>(1);
		this.students.add(aStudent);
	}
	
	public Cluster(Promo aPromo) {
		this.subClusters = new ArrayList<Cluster>(aPromo.size());
		for (Student currentStudent : aPromo) {
			this.subClusters.add(new Cluster(currentStudent));
		}
		this.students = aPromo;
	}
	
	public Cluster(Cluster cluster1, Cluster cluster2) {
		this.subClusters = new ArrayList<Cluster>(2);
		this.subClusters.add(cluster1);
		this.subClusters.add(cluster2);
		
		this.students = new Vector<Student>(cluster1.students);
		this.students.addAll(cluster2.students);
	}
	
	public double getAverageGrade() {
		double average = 0.;
		for (Student currentStudent : this.students) {
			average += currentStudent.getGrade();
		}
		return average / this.students.size();
	}
	
	public double distance(Cluster aCluster) {
		double dist = 0.;
		for (Student source : this.students) {
			for (Student dest : aCluster.students) {
				//dist += source.distance(dest);
				dist += Math.abs(source.getGrade() - dest.getGrade());
			}
		}
		return dist / (this.students.size() * aCluster.students.size());
	}
	
	/*
	public void clusterize() {
		while (this.subClusters.size() > 1) {
			// find the closests subclusters
			int minIndex1 = 0;
			int minIndex2 = 1;
			double minDist = 20.;
			for (int i=0; i<this.subClusters.size(); i++) {
				for (int j = i+1; j<this.subClusters.size(); j++) {
					double dist = this.subClusters.get(i).distance(this.subClusters.get(j));
					if (dist < minDist) {
						minDist = dist;
						minIndex1 = i;
						minIndex2 = j;
					}
				}
			}
			
			// merge the closets subclusters
			this.subClusters.add(new Cluster(this.subClusters.get(minIndex1), this.subClusters.get(minIndex2)));
			this.subClusters.remove(minIndex2);
			this.subClusters.remove(minIndex1);
		}
	}
	*/
	
	public void clusterize() {
		while (this.subClusters.size() > 1) {
			// find the closests subclusters
			Cluster minClust1 = subClusters.get(0);
			Cluster minClust2 = subClusters.get(1);
			double minDist = 20.;
			for (int i=0; i<this.subClusters.size(); i++) {
				for (int j = i+1; j<this.subClusters.size(); j++) {
					double dist = this.subClusters.get(i).distance(this.subClusters.get(j));
					if (dist < minDist) {
						minDist = dist;
						minClust1 = subClusters.get(i);
						minClust2 = subClusters.get(j);
					}
				}
			}
			
			// merge the closets subclusters
			this.subClusters.add(new Cluster(minClust1, minClust2));
			this.subClusters.remove(minClust1);
			this.subClusters.remove(minClust2);
		}
	}
	
	protected String getNewickIntermediate() {
		String newick = "";
		if (this.subClusters.size() == 0) {
			//newick = this.students.get(0).getIdentifier() + ":" + this.students.get(0).getGrade();
			newick = this.students.get(0).getIdentifier();
		}
		else if (this.subClusters.size() == 1) {
			newick = this.subClusters.get(0).getNewickIntermediate();
		}
		else {
			newick = "(";
			for (Cluster currentSubCluster : this.subClusters) {
				newick += currentSubCluster.getNewickIntermediate() + ",";
			}
			newick = newick.substring(0, newick.length()-1) + ")";
		}
		return newick;
	}
	
	public String getNewick() {
		return this.getNewickIntermediate() + ";";
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
		
		Promo m1big = new Promo();
		m1big.add(riri);
		m1big.add(fifi);
		m1big.add(loulou);
		m1big.add(geo);
		m1big.add(donald);
		
		Cluster bigCluster = new Cluster(m1big);
		System.out.println("Before clustering:");
		System.out.println(bigCluster.getNewick());
		bigCluster.clusterize();
		System.out.println("");
		System.out.println("After clustering:");
		System.out.println(bigCluster.getNewick());
		
		System.out.println("");
		Cluster bigAnonymous = new Cluster(PromoLoader.loadTsvFile("/home/olivier/enseignement/masterBIG/master1/poo/hierarchicalClustering/notes_finales_anonymisees.tsv"));
		bigAnonymous.clusterize();
		System.out.println(bigAnonymous.getNewick());
	}

}
