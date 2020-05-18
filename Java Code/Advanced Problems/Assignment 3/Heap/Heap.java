package col106.assignment3.Heap;

import java.util.ArrayList;

public class Heap<T extends Comparable, E extends Comparable> implements HeapInterface <T, E> {
	/* 
	 * Do not touch the code inside the upcoming block 
	 * If anything tempered your marks will be directly cut to zero
	*/
	
	public static void main() {
		HeapDriverCode HDC = new HeapDriverCode();
		System.setOut(HDC.fileout());
	}
	/*
	 * end code
	 */
	
	// write your code here	

	public int height=0;
	public int rem = 0;
	void heigh(int si) {
		int a=si-1;
		int h=1;
		while(a>1) {
			a=a/2;
			h++;
		}
	}
		
	public void insert(T key, E value) {
		//write your code here
	//	System.out.println("Inserting: "+key+", "+value);
		jai se = new jai(key,value);
		//int pi= -1/2;
		//System.out.println(pi);
		 if(list.size()==0) {
			 list.add(se);
			 
		 }else {
			
			 list.add(se);
			 boolean t= false;
			 int a=list.size()-1;
			 while(t==false) {
				 if(a>=0) {
					 int compare = value.compareTo(list.get((a-1)/2).b);
	
					 if(compare>0) {
						
							 jai b = list.get((a-1)/2);
							 list.set((a-1)/2,se);
							 list.set(a, b);
							 if(a!=(a-1)/2) {
							 a=(a-1)/2;
					 		}else t= true;
							 
					 }else t=true;
						 
				}else t=true;
				 
			 }
			 
		 }
		
	}
	class jai{
		T a;
		E b;
		jai(T a,E b){
			this.a=a;
			this.b=b;
		}
	}
	
	public ArrayList<jai> list = new ArrayList(); 
	 
	
	public E extractMax() {
		//write your code here
		//System.out.println("Extracting Max:");
		E m=list.get(0).b;

		//System.out.println(m);
		pr=true;
		delete(list.get(0).a);
		pr=false;
		return m;
	}
boolean pr =false; 
	
	public void delete(T key) {
		//write your code here
		int i=0;
		T bc =key;
		if(key.compareTo(list.get(list.size()-1).a)==0) {
		
			list.remove(list.size()-1);
		
		}else {
			boolean p=true;
			for (i=0;i<list.size();i++) {
				if(bc.compareTo(list.get(i).a)==0){
					if(p==true) {
					list.set(i, list.get(list.size()-1));
					list.remove(list.size()-1);
					bc = list.get(i).a; 
					
					p=false;
					}
					
					if((list.get(i).b).compareTo(list.get((i-1)/2).b)>0&&i>0) {
						jai tem =list.get((i-1)/2); 
						list.set((i-1)/2,list.get(i));
						list.set(i,tem);
						if((i-1)/2==0) {
							break;
						}else {
							i=(i-1)/2-1;
						}
							
					}else {
					
						if((2*i+2)<list.size()) {
							if((list.get(2*i+2).b).compareTo(list.get(2*i+1).b)<0 && (list.get(i).b).compareTo(list.get(2*i+1).b)<0) {
								jai tem =list.get(i); 
								list.set(i,list.get(2*i+1));
								list.set(2*i+1,tem);
								i=2*i;
								
								 
							}else if((list.get(2*i+2).b).compareTo(list.get(2*i+1).b)>0 && (list.get(i).b).compareTo(list.get(2*i+2).b)<0) {
								jai tem =list.get(i); 
								list.set(i,list.get(2*i+2));
								list.set(2*i+2,tem);
								
								i=2*i+1;
								
							//	System.out.println("lla"+i+"s "+ list.get(2).b);
							}
						}else if(2*i+2==list.size()&&(list.get(i).b).compareTo(list.get(2*i+1).b)<0) {
							jai tem =list.get(i); 
						//	System.out.println("lla");
							list.set(i,list.get(2*i+1));
							list.set(2*i+1,tem);
							i=2*i;
						}
						
					}
				}
			}
		}
		
		
	}

	public void increaseKey(T key, E value) {
		//write your code here
	//	System.out.println("Updating key "+key+" to value "+value+":");
		boolean t=false;
		int i=0;
		jai hy = new jai(key,value);
		
		for (i=0;i<list.size()&&(key.compareTo(list.get(i).a)!=0);i++) {
			
		}
		if(i<list.size()&&i>=0) {
		list.set(i,hy);
		while(t==false) {
			 if(i>=0) {
				 int compare = value.compareTo(list.get((i-1)/2).b);

				 if(compare>0) {
					
						 jai b = list.get((i-1)/2);
						 list.set((i-1)/2,hy);
						 list.set(i, b);
						 i=(i-1)/2;
				 }else t=true;
					 
			}else t=true;
			 
		 }
		}

	}

	public void printHeap() {
		//write your code here
		//System.out.println("Printing heap in level order:");
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).a+", "+list.get(i).b);
		}
		
	}	
/*
	public static void main(String[] args) {
		Heap<Integer,Integer> h = new Heap();
		int[][] i = {{1,10},{2,11},{3,12},{4,4},{5,7},{6,25},{7,27}};
		for(int[] a:i) {
			h.insert(a[0], a[1]);
		}
		h.printHeap();
		h.increaseKey(4, 55);
		System.out.println();
		h.printHeap();
		System.out.println();
		h.delete(4);
		h.printHeap();
		System.out.println();
		
	}

*/
}


	/*dedso.insert(1,100);
	dedso.insert(2,10);
	dedso.insert(3,30);
	dedso.insert(4,50);
	dedso.insert(5,150);
	dedso.insert(6,1);
	dedso.insert(7,3);
	dedso.printHeap();
	dedso.delete(1);
	dedso.printHeap();
	dedso.insert(8, 500);
	dedso.printHeap();
	dedso.extractMax();
	
	dedso.printHeap();
	dedso.increaseKey(7, 70);

	dedso.insert(2,10);
	dedso.delete(2);
	dedso.printHeap();
//	System.out.println(dedso.list.get));
}*/
