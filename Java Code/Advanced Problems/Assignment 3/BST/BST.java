
package col106.assignment3.BST;

import java.util.ArrayList;


public class BST<T extends Comparable , E extends Comparable> implements BSTInterface<T, E>  {
	/* 
	 * Do not touch the code inside the upcoming block 
	 * If anything tempered your marks will be directly cut to zero
	*/
	
	public static void main() {
		BSTDriverCode BDC = new BSTDriverCode();
		System.setOut(BDC.fileout());
	}
	/*
	 * end code
	 * start writing your code from here
	 */

	//write your code here 
    public Node asmm;
	
	public BST(){
		asmm=null;
	}

	public class Node { 
       
		public T key; 
        public E value;
        Node left, right; 
  
        public Node(T kya,E item) { 
          value = item; 
          key = kya;
            left = right = null; 
        }
        
    }
	

	public boolean che =false;
	
	public void insert(T key, E value) {
		//write your code here
		if(che==false) {
	//	System.out.println("Inserting: "+key+", "+value);
		}
    asmm = majdoor(asmm,key,value); 

		//System.out.println(asmm.value);
    }
 
	Node majdoor(Node mc,T lwd, E kaise) {
		
		
		if (mc==null) {
			
			mc= new Node(lwd,kaise);
			return mc;
		}
		else {
			int compare = kaise.compareTo(mc.value);

		//	System.out.println("lala");
			if(compare>0) {	
				
				mc.right= majdoor(mc.right,lwd,kaise);
			}
			else {
				
				mc.left = majdoor(mc.left,lwd,kaise);	
			}
			return mc;
		}
	}
        public void update(T key, E value) {
		//write your code here
        	if(che==false) {
         // 	System.out.println("Updating key "+key+" to value "+value+":");
        	}
        	che =true;
        delete(key);
        insert(key,value);
        che=false;
    }

    public void delete(T key) {
		//write your code here
    	if(che==false) {
    	//System.out.println("Deleting element with key "+key+":");
    	}
    	asmm=find(key,asmm);
    }

    public void printBST () {
		//write your code here
    	if(che==false) {
    //	System.out.println("Printing BST in level order:");
    	}
    	Node x = asmm;
    	int h = high(x,0);
    	if(h>0) {
    		
    		System.out.println(asmm.key+", "+asmm.value);
        	
    		if(h>1) {
    		
    			for(int i=1;i<h;i++) {
    				rec(i+1,x);
    			}
    			
    		}
    	}
    	
    }
    

  public int high(Node m,int a) {
	  if(m==null) return a;
	  else {
		int lh=  high(m.left,a+1);
		int rh= high(m.right,a+1);
		if(lh>rh)return lh;
		else return rh;
	  }
	 
	  
  }
  
  public void rec(int h,Node n) {
	   Node m =n;
	   if(h>2) {
		   if(m.left!=null)rec(h-1,m.left);
		   
		   if(m.right!=null)rec(h-1,m.right);
	   }else {
	   if(m.left!=null) {
		   
			System.out.println((m.left).key+", "+(m.left).value);
		   
	   }
		
	   if(m.right!=null) {
		   System.out.println((m.right).key+", "+(m.right).value);
		   
	   }
	 
	   }
	   
   }
  Node leftmos(Node a) {
	  if(a.left!=null) {
		  return leftmos(a.left);
	  }else {
		 Node b = new Node(a.key,a.value);
		  return b;
	  }
  }
 
  Node find(T key,Node mera) {
		
	  if(mera!=null) {
		  int a = (mera.key).compareTo(key);

		  if(a==0) {
			
			  //deleting the key
					  if((mera.right==null)&&(mera.left==null)) {
						  mera=null;
						  return mera;
							
					  }
					  else if ((mera.right==null)&&(mera.left!=null)) {
						 Node lef=mera.left;
						 mera.left=null;
						 mera=null;
						 mera=lef;
						 return mera;
					  }
					  else if ((mera.left==null)) {
						  mera=mera.right;
						  return mera;
					  }
					  else {
						
						  Node mini =leftmos(mera.right);
						  if(mera.right.left!=null) {
						  mera.key = mini.key;
						  mera.value = mini.value;
						  mera.right =find(mera.key,mera.right);
						  }
						  else {
							  Node as =mera.left;
							  mera=mera.right;
							  if(as!=null) {
							  mera.left=as;
							  }
						  }
						  return mera;
					  }
					  
					  
		  }else {
			 
			  if(mera.left!=null){
					
				  mera.left= find(key,mera.left);
				}
			  if(mera.right!=null) {	
					
					mera.right= find(key,mera.right);
				}
			  
			  return mera;
				
		  }
	  }else return mera;
  }
  public T kt;
  public E ke;
  // getting key from the value
  public  void tkey(Node a,E value) {
	  if(a.value==value) {
		kt = a.key;
	  }else {
		  if(a.left!=null){
				
		  tkey(a.left,value);
		  }
		  if(a.right!=null){
				tkey(a.right,value);
		  }
	  }
  }
  //geting value from the key 
  public  void tval(Node a,T value) {
	  if(a.key==value) {
		ke = a.value;
	  }else {
		  if(a.left!=null){
				
		  tval(a.left,value);
		  }
		  if(a.right!=null){
				tval(a.right,value);
		  }
	  }
  }
  
  // sorting by key
  public ArrayList<E> list = new ArrayList(); 
//for election 
  
  public void getBST () {
		//write your code here
  	maped.clear();
  //	System.out.println("Printing BST in level order:");
  	Node x = asmm;
  	int h = high(x,0);
  	if(h>0) {
  		
  		maped.add(asmm.key);
      	
  		if(h>1) {
  		
  			for(int i=1;i<h;i++) {
  				getrec(i+1,x);
  			}
  			
  		}
  	}
  	
  }

	public ArrayList<T> maped = new ArrayList(); 

	  public void getrec(int h,Node n) {
		   Node m =n;
		   if(h>2) {
			   if(m.left!=null)getrec(h-1,m.left);
			   
			   if(m.right!=null)getrec(h-1,m.right);
		   }else {
		   if(m.left!=null) {
			   
				maped.add((m.left).key);
			   
		   }
			
		   if(m.right!=null) {
				maped.add((m.right).key);
			   
		   }
		 
		   }
		   
	   }
	  
	  //inorder traversal

	  public ArrayList<T> ino = new ArrayList(); 
	  public void inorder(Node a) {
		  if(a!=null) {
			 
			 

			  if(a.right!=null) {
				 inorder(a.right);
			 }
			  ino.add(a.key);
				 
			  if(a.left!=null) {
				  inorder(a.left);
			}
			  
			  
			  
		  }
	  }

}
/*
public static void main(String[] args) {
	BST<Integer,Integer> dedso =new BST();

	dedso.printBST();
	dedso.insert(1,15);
	dedso.insert(2,5);
	dedso.insert(3,1);

	dedso.insert(4,6);

	dedso.insert(5,20);

	dedso.insert(6,16);
	dedso.insert(7,25);

	dedso.insert(8,21);
	dedso.insert(9,26);
	dedso.delete(5);
	
	//dedso.insert(8,21);
	//dedso.insert(9,18);
	
//	dedso.printBST();
	dedso.printBST();
	dedso.update(9, 300);

	dedso.printBST();
	//dedso.update(75, 1400);

//	dedso.printBST();
}
*/