package fr.univ_rennes1.bioinfo;

import java.util.ArrayList;
import java.util.Vector;

/**
 * 
 */

/**
 * @author olivier
 *
 */
public class ClusterWeighted extends Cluster{
	
	private double weight = 0.;
	private double dist = 0.;
	
	public ClusterWeighted(){
		super();
		this.weight = 0.;
		this.dist = 0.;
	}
	
	public ClusterWeighted(Student aStudent){
		super(aStudent);
		this.weight = 0.;
		this.dist = 0.;
	}
	
	public ClusterWeighted(Promo aPromo) {
		this.subClusters = new ArrayList<Cluster>(aPromo.size());
		for (Student currentStudent : aPromo) {
			this.subClusters.add(new ClusterWeighted(currentStudent));
		}
		this.students = aPromo;
		this.weight = 0.;
		this.dist = 0.;
	}
	
	public ClusterWeighted(ClusterWeighted cluster1, ClusterWeighted cluster2) {
		super(cluster1, cluster2);
		//this.weight = ((cluster1.getAverageGrade() * cluster1.students.size()) + (cluster1.getAverageGrade() * cluster2.students.size())) / (cluster1.students.size() + cluster2.students.size());
		this.weight = cluster1.distance(cluster2);
	}
	
	public void clusterize() {
		while (this.subClusters.size() > 1) {
			// find the closests subclusters
			ClusterWeighted minClust1 = (ClusterWeighted)subClusters.get(0);
			ClusterWeighted minClust2 = (ClusterWeighted)subClusters.get(1);
			double minDist = 20.;
			for (int i=0; i<this.subClusters.size(); i++) {
				for (int j = i+1; j<this.subClusters.size(); j++) {
					double dist = this.subClusters.get(i).distance(this.subClusters.get(j));
					if (dist < minDist) {
						minDist = dist;
						minClust1 = (ClusterWeighted)subClusters.get(i);
						minClust2 = (ClusterWeighted)subClusters.get(j);
					}
				}
			}
			
			// merge the closets subclusters
			this.subClusters.add(new ClusterWeighted(minClust1, minClust2));
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
				newick += currentSubCluster.getNewickIntermediate();
				//newick += ":" + Math.abs(this.getAverageGrade() - ((ClusterWeighted)currentSubCluster).weight);
				newick += ":" + (this.weight - ((ClusterWeighted)currentSubCluster).weight);
				newick += ",";
			}
			newick = newick.substring(0, newick.length()-1) + ")";
		}
		return newick;
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
		
		ClusterWeighted bigCluster = new ClusterWeighted(m1big);
		System.out.println("Before clustering:");
		System.out.println(bigCluster.getNewick());
		bigCluster.clusterize();
		System.out.println("");
		System.out.println("After clustering:");
		System.out.println(bigCluster.getNewick());
		
		System.out.println("");
		ClusterWeighted bigAnonymous = new ClusterWeighted(PromoLoader.loadTsvFile("/home/olivier/enseignement/masterBIG/master1/poo/hierarchicalClustering/notes_finales_anonymisees.tsv"));
		bigAnonymous.clusterize();
		System.out.println(bigAnonymous.getNewick());
		
		Promo od = new Promo();
		od.add(geo);
		od.add(loulou);
		od.add(donald);
		ClusterWeighted odCluster = new ClusterWeighted(od);
		odCluster.clusterize();
		System.out.println("");
		System.out.println(odCluster.getNewick());

	}

}
