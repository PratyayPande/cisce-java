package col106.assignment4.HashMap;
import java.util.Vector;

public class HashMap<V> implements HashMapInterface<V> {

	public HashMap(int size) {
		// write your code here
		capa =size;
		for(int i=0;i<capa;i++) {
			table.add(null);
			kes.add(null);
		}
	}

	int capa = 0;
	Vector<V> table =new Vector<V>();
	Vector<String> kes =new Vector<String>();
	

	int hash(String k) {
		int ini =-11111;
		if(k.isBlank()) {
			ini=0;
		}else {
			int s= k.length();
			 ini = k.charAt(s-1)%(capa);
			for(int i=s-2;i>=0;i--) {
				ini= ((k.charAt(i)%(capa))+(41%(capa)*ini)%(capa))%(capa);
	//			ini=( k.charAt(i)%(capa)+((41%capa)*ini%(capa))%capa)%(capa);
			}
		}
		//int hashcode=-1;	
		int	hashcode=ini;
		
	//	System.out.println(hashcode);
		
		return hashcode;
	}
	public V put(String key, V value){
		// write your code here
		V val=null;
		if(kes.contains(key)) {
			
			int i =kes.indexOf(key);
			val=table.get(i);
			table.set(i,value);
			
		}else {
			
			int index=hash(key);
			int count =0;
				for(int i=0;index+i<capa;i++) {
					index=index+i;
					count++;
					if(index<capa) {
						if(table.get(index)==null) {
							table.set(index,value);	
							kes.set(index,key);
							count=0;
							break;
						}
					}	
				}
				
				if(count!=0) {
					for(int i=0;i<capa-count;i++) {
						if(table.get(i)==null) {
							table.set(i,value);	
							kes.set(i,key);
							
							break;
						}	
					}
				}
			
		}	
		
		return val;
	}

	public V get(String key){
		// write your code here
		if(kes.contains(key)) {
			int i=kes.indexOf(key);
			
			return table.get(i);
        }
        else return null;
	}

	public boolean remove(String key){
		// write your code here
		boolean che = false;
		if(kes.contains(key)) {
			int i=kes.indexOf(key);

				che =true;

				table.set(i,null);
				kes.set(i,null);
				int count =1;
				for(int m=1;m+i<capa;m++) {
					count++;	
					if(kes.get(m+i)!=null) {
						int index=hash(kes.get(m+i));
						
						if(index<m+i&&i>=index) {
							kes.set(i,kes.get(m+i));
							table.set(i,table.get(m+i));
							kes.set(m+i,null);
							table.set(m+i,null);
							i=m+i;
						}
					}	
					else {
							count =0;
							break;
							}
				}
				
				if(count!=capa||count!=0) {
					
					for(int m=0;m<i;m++) {
						if(kes.get(m)!=null) {
							int index=hash(kes.get(m));
					
							
							if(index>m&&i>=index) {
								kes.set(i,kes.get(m));
								table.set(i,table.get(m));
								kes.set(m,null);
								table.set(m,null);
								i=m;
							}
							if(index<m&&i>=index&&m>i) {
								kes.set(i,kes.get(m));
								table.set(i,table.get(m));
								kes.set(m,null);
								table.set(m,null);
								i=m;
							}
						}	
						else {
								count =0;
								break;
						}
						
					}
					
				}
				
			
		}
		
		return che;
	}

	public boolean contains(String key){
		// write your code here
		
		return kes.contains(key);
	}

	public Vector<String> getKeysInOrder(){
		// write your code here
		Vector<String> ne = new Vector<String>();
		if(capa>0) {
			for(int i=0;i<capa;i++) {
				String a=kes.get(i);
				if(a!=null) {
					ne.add(a);
				}
			}
			
		}
		return ne;
	}
	
/*
public static void main(String[] args) {
	HashMap<Integer> dedso =new HashMap(191);
	
	dedso.put("djxrt", 1);
	dedso.put("qocbq",2);
	dedso.put("afgqj",1);
	dedso.put("bpgln",1);
	dedso.put("wvidq",2);
	//dedso.put("",1);
	dedso.remove("qocbq");
	//dedso.put("orange",1);

	System.out.println(dedso.getKeysInOrder());	
	
}
	
	*/
	
}
/*
dedso.put("abc", 1);
dedso.put("pqr",2);
dedso.put("xyz",1);
dedso.put("xyz",2);
dedso.put("pqr",4);
dedso.get("pqr");
dedso.remove("pqr");
dedso.remove("abc");
dedso.remove("xyz");
System.out.println(dedso.get("abcd"));
System.out.println(dedso.getKeysInOrder());
*/