package col106.assignment3.Election;

import java.util.ArrayList;
import java.util.HashMap; 
import java.util.Map; 
import col106.assignment3.BST.BST;

public class Election implements ElectionInterface {
	/* 
	 * Do not touch the code inside the upcoming block 
	 * If anything tempered your marks will be directly cut to zero
	*/
	
	public static void main() {
		ElectionDriverCode EDC = new ElectionDriverCode();
		System.setOut(EDC.fileout());
	}	/*
	 * end code
	 */
	
	//write your code here 
	
	BST<String,Integer> id =new BST<String,Integer>();
	
	
	// series of arra is used for vote counting
	public ArrayList<String> arrad = new ArrayList();	
	public ArrayList<String[]> arrav = new ArrayList();
	public HashMap<String, String[]> map = new HashMap<>(); 
//	public ArrayList<ic> idk = new ArrayList();//for top k in constituency
	

	public void insert(String name, String candID, String state, String district, String constituency, String party, String votes){
		//write your code here 
    	String[] aaj = {name, candID, state,  district, constituency,  party, votes};
    	id.che=true;
    	id.insert(candID, Integer.parseInt(votes));
    	
    	arrad.add(candID);
    	arrav.add(aaj);
    	map.put(candID, aaj);
    	//System.out.println("Inserting: "+aaj[0]+", "+aaj[1]+", "+aaj[2]+", "+aaj[3]+", "+aaj[4]+", "+aaj[5]+", "+aaj[6]);    	
    	
	}
    
	public void updateVote(String name, String candID, String votes){
		//write your code here
		//id.che=true;
	  	//System.out.println("Updating "+name+", "+candID+", "+votes);
	  	int rep =Integer.parseInt(votes);
		id.update(candID,rep);
		
	  	int i=0;
		
		for(i=0;i<arrav.size();i++) {
			if(arrad.get(i).compareTo(candID)==0)break;
		}
	//	System.out.println(arrav.size()+" "+i);
		if (i<arrav.size()) {
		String[] ka =arrav.get(i);
		ka[6]=votes;
		arrav.set(i, ka);
	
		}
		String[] a = map.get(candID);
		a[6] = votes;
		map.replace(candID,a );
		
	
	}
	
	public void topkInConstituency(String constituency, String k){
		//write your code here

	    ArrayList<String[]> nahi = new ArrayList();
	    id.inorder(id.asmm);
		for(int i =0; i<id.ino.size();i++) {
			
			
			if(map.get(id.ino.get(i))[4].compareTo(constituency)==0) {
				nahi.add(map.get(id.ino.get(i)));
			}
			
		}
	
		for(int i=0;(i<nahi.size()&&i<Integer.parseInt(k));i++) {
			System.out.println(nahi.get(i)[0]+", "+nahi.get(i)[1]+", "+nahi.get(i)[5]);
		}
	
		//System.out.println(id.ino);
		
		id.ino.clear();
		
	}

	public ArrayList<String> cosnt = new ArrayList(); 
    
	
	
	public void leadingPartyInState(String state){
		//write your code here
		//System.out.println("Reporting leading party in a state "+state+":");
		ArrayList<String> party = new ArrayList();
		ArrayList<Integer> count = new ArrayList();
		party.add(arrav.get(0)[5]);
		count.add(Integer.parseInt(arrav.get(0)[6]));
		for(int i =1;i<arrav.size();i++) {
			if(arrav.get(i)[2].compareTo(state)==0) {
				
				if(party.contains(arrav.get(i)[5])) {
					
					count.set(party.indexOf(arrav.get(i)[5]), count.get(party.indexOf(arrav.get(i)[5]))+ Integer.parseInt(arrav.get(i)[6]));
					
				}
				else {
					party.add(arrav.get(i)[5]);
					count.add(Integer.parseInt(arrav.get(i)[6]));
				}
			}	
		}
		String par =party.get(0);
		int max =count.get(0);
		for(int i=1;i<count.size();i++) {
			if(count.get(i)>max) {
				max=count.get(i);
				par=party.get(i);
			}
		}

		ArrayList<String> maxy = new ArrayList();
		maxy.add(par);
		for(int i=0;i<count.size();i++) {
			if(max==count.get(i)&&par!=party.get(i)) {
				maxy.add(party.get(i));
			}
		}
		if(maxy.size()>1) {
			for(int k=0;k<maxy.size();k++) {
	
				for(int i=1;i<maxy.size();i++) {
				
					if((maxy.get(i)).compareTo(maxy.get(i-1))>0) {
						String t= maxy.get(i-1);
						maxy.set(i-1, maxy.get(i));
						maxy.set(i,t);
					}
				}
			}
		}
		for(int i=0;i<maxy.size();i++) {
			System.out.println(maxy.get(i));	
		}
		
		
	}
	public void cancelVoteConstituency(String constituency){
		//write your code here
		ArrayList<String> nahi = new ArrayList();
	    id.inorder(id.asmm);
	    id.che=true;
		
	    for(int i =0; i<id.ino.size();i++) {
			
			
			if(map.get(id.ino.get(i))[4].compareTo(constituency)==0) {
			//	id.delete(id.ino.get(i));
				nahi.add(id.ino.get(i));
				map.remove(id.ino.get(i));
			}
		}
	    
		id.ino.clear();
		
		for(int i=0;i<nahi.size();i++) {
			for(int j=1;j<nahi.size()-i;j++) {
				if(nahi.get(j).compareTo(nahi.get(j-1))<0) {
				String t= nahi.get(j-1);
				nahi.set(j-1,nahi.get(j));
				nahi.set(j,t);
				
				}
			}
		}
		for(int i=0;i<nahi.size();i++) {
			id.delete(nahi.get(i));
		}
		
		for(int i=0;i<arrad.size();i++) {
			if(arrav.get(i)[4].compareTo(constituency)==0) {
				//System.out.println(arrav.get(i)[6]);
				arrav.remove(i);
				arrad.remove(i);
				i=i-1;
			}
		}
	//	System.out.println("Discarding the info of all candidates in a constituency "+constituency+":");
		
		
	}
	public void leadingPartyOverall(){
		//write your code here
		//System.out.println("Reporting leading party across all constituencies:");
		ArrayList<String> party = new ArrayList();
		ArrayList<Integer> count = new ArrayList();
		party.add(arrav.get(0)[5]);
		count.add(Integer.parseInt(arrav.get(0)[6]));
		for(int i =1;i<arrav.size();i++) {
				
				if(party.contains(arrav.get(i)[5])) {
					
					count.set(party.indexOf(arrav.get(i)[5]), count.get(party.indexOf(arrav.get(i)[5]))+ Integer.parseInt(arrav.get(i)[6]));
					
				}
				else {
					party.add(arrav.get(i)[5]);
					count.add(Integer.parseInt(arrav.get(i)[6]));
				}
				
		}
		String par =party.get(0);
		int max =count.get(0);
		for(int i=1;i<count.size();i++) {
			if(count.get(i)>max) {
				max=count.get(i);
				par=party.get(i);
			}
		}

		ArrayList<String> maxy = new ArrayList();
		maxy.add(par);
		for(int i=0;i<count.size();i++) {
			if(max==count.get(i)&&par!=party.get(i)) {
				maxy.add(party.get(i));
			}
		}
		if(maxy.size()>1) {
			for(int k=0;k<maxy.size();k++) {
	
				for(int i=1;i<maxy.size();i++) {
				
					if((maxy.get(i)).compareTo(maxy.get(i-1))<0) {
						String t= maxy.get(i-1);
						maxy.set(i-1, maxy.get(i));
						maxy.set(i,t);
					}
				}
			}
		}
		for(int i=0;i<maxy.size();i++) {
			System.out.println(maxy.get(i));	
		}
		

	}
	public void voteShareInState(String party,String state){
		//write your code here
		ArrayList<String> parcy = new ArrayList();
		ArrayList<Integer> count = new ArrayList();
		int fin=0;
		if(arrav.size()>0) {
		
			for(int i =0;i<arrav.size();i++) {
	
				if((arrav.get(i)[2]).compareTo(state)==0) {
					//System.out.println(arrav.get(i)[2]);				
						fin = fin + Integer.parseInt(arrav.get(i)[6]);
					//System.out.println(Integer.parseInt(arrav.get(i)[6]));
						if(parcy.contains(arrav.get(i)[5])) {
							int ind =parcy.indexOf(arrav.get(i)[5]);
							int pasha =count.get(ind)+ Integer.parseInt(arrav.get(i)[6]);
							count.set(ind, pasha);
							
						}
						else {
							parcy.add(arrav.get(i)[5]);
							count.add(Integer.parseInt(arrav.get(i)[6]));
						}
						
				}	
			}
		}
		int percent =0;
		//System.out.println(count.get(ind));
		if(fin!=0&&parcy.contains(party)) {
		int inde =parcy.indexOf(party);
		float perce = ((float)count.get(inde)/(float)fin)*100;
		percent = (int)perce;
		}
		//System.out.println("Reporting vote share of party "+party+" in state"+state);	
		System.out.println(percent);
		
	}
	
	public void printElectionLevelOrder() {
		//write your code here
	//	System.out.println("Printing Election Data:");
		id.getBST();
		String[] k= new String[7];
		
		for(int i=0;i<id.maped.size();i++) {
			k = map.get(id.maped.get(i));
			//Arrays.deepToString(k);
			System.out.println(k[0]+", "+k[1]+", "+k[2]+", "+k[3]+", "+k[4]+", "+k[5]+", "+k[6]);
		}
	
	}
	
	
}

/*
public static void main(String[] args) {
	Election dedso =new Election();
	dedso.insert("Cand1", "1", "S1", "D1", "C1", "P1", "1200");
	dedso.insert("Cand2", "100", "S1", "D1", "C1", "P2", "1000");	
	dedso.insert("Cand3", "101", "S1", "D1", "C1", "P3", "1500");
	dedso.insert("Cand4", "102", "S1", "D1", "C1", "P4", "2000");
	dedso.insert("Cand5", "105", "S1", "D1", "C1", "P5", "500");

	dedso.insert("Cand6", "2", "S1", "D2", "C2", "P2", "4000");

	dedso.insert("Cand7", "3", "S2", "D3", "C3", "P3", "2100");

	dedso.insert("Cand8", "4", "S3", "D4", "C4", "P4", "800");

	dedso.insert("Cand9", "5", "S3", "D5", "C5", "P6", "1600");
	//dedso.insert("Cand5", "1055", "S2", "D1", "C2", "kal", "45560");
//	dedso.insert("Cand5", "1055", "S1", "D1", "C2", "P5", "560");
//
//	dedso.insert("Cand5", "1005", "S1", "D1", "C2", "P5", "554");

	//dedso.printElectionLevelOrder();
	//dedso.id.printBST();
	//HashMap<String, String[]> map = new HashMap<>(); 
	//String[] h= {"Cand3", "101", "S1", "D1", "C1", "P3", "1500"};
	//map.put("Cand1", h);
	//System.out.println(Arrays.deepToString(map.get("Cand1")));
	//dedso.printElectionLevelOrder();
//	System.out.println();
//	dedso.topkInConstituency("C1", "3");
	//dedso.cancelVoteConstituency("C2");
//	dedso.printElectionLevelOrder();
	
	dedso.topkInConstituency("C1", "3");
	//dedso.topkInConstituency("C1", "4");
	//dedso.leadingPartyInState("S1");
	dedso.printElectionLevelOrder();
	
	dedso .updateVote("Cand1", "1", "2500");

	dedso .updateVote("Cand8", "4", "1400");
//	System.out.println();
	dedso.printElectionLevelOrder();
	
	//dedso.leadingPartyOverall();
	//System.out.println(dedso.id.ino);
}*/


