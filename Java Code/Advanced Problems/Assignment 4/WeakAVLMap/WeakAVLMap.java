package col106.assignment4.WeakAVLMap;
import java.util.Vector;

public class WeakAVLMap<K extends Comparable,V> implements WeakAVLMapInterface<K,V>{

	public WeakAVLMap(){
		// write your code here
		wavl=null;
	}
	
	class Node {
		K key;
		V value;
		int rank=0;
		int prank=0;
		Node left,right;
		String child="root";
		
		Node(K ke,V val){
			key=ke;
			value = val;
			rank=1;
			left=null;
			right=null;
		}
		void rankupdate(int a){
			rank=rank+a;
		}
	}
	
	public Node wavl;
	public V prev=null;
	int rotatecount=0;
	Node rotateright(Node mc) {
		Node t1 = mc.right.left;
		Node t2 = mc;
		mc = mc.right;
		mc.left = t2;
		mc.left.right=t1;
		mc.left.rank=mc.left.rank-1;
		
		
		//mc.rankupdate(1);
		
		mc.child=t2.child;
		mc.prank=t2.prank;
		
		if(mc.left.right!=null) {
			mc.left.right.child="right";
			mc.left.right.prank=mc.left.rank;
			}
		if(mc.left.left!=null) {
			mc.left.left.child="left";
			mc.left.left.prank=mc.left.rank;
		}

		if(mc.right!=null) {
				mc.right.prank=mc.rank;
				mc.right.child="right";
			}
		if(mc.left!=null) {
				mc.left.prank=mc.rank;
				mc.left.child="left";				
			}
		
		rotatecount=rotatecount+1;		
		return mc;
	}
	Node rotateleft(Node mc) {
		Node t1 = mc.left.right;
		Node t2 = mc;
		mc=mc.left;
		mc.right=t2;
		mc.right.left=t1;
		//mc.rankupdate(1);
		
		mc.right.rank=mc.right.rank-1;
		
		mc.child=t2.child;
		mc.prank=t2.prank;
		
		if(mc.right.left!=null) {
			mc.right.left.child="left";
			mc.right.left.prank=mc.right.rank;
			}
		if(mc.right.right!=null) {
			mc.right.right.child="right";
			mc.right.right.prank=mc.right.rank;
			
		}
		if(mc.left!=null) {
				mc.left.prank=mc.rank;
				mc.left.child="left";
			}
		if(mc.right!=null) {
				mc.right.prank=mc.rank;
				mc.right.child="right";				
			}
		

		rotatecount=rotatecount+1;
		return mc;
	}
Node majdoor(Node mc, K kai,V lwd) {
		
		if (mc==null) {
			
			mc= new Node(kai,lwd);
			return mc;
		}
		
		else {
			int compare = kai.compareTo(mc.key);

		//	System.out.println("lala");
			if(compare>0) {	
				

				mc.right= majdoor(mc.right,kai,lwd);		
			//	System.out.println(mc.right.rank);
				mc.right.child="right";
				mc.right.prank=mc.rank;

				if(mc.left ==null) {
												
												//case of limited hight	 rr case    if its root       lefft right case
					if(mc.right.rank==mc.rank && mc.rank==1 ) {
						mc.rank=mc.rank+1;
						if(mc.right!=null)	{
							mc.right.child="right";
							mc.right.prank=mc.rank;
						}
						if(mc.left!=null) {
							mc.left.child="left";
							mc.left.prank=mc.rank;
						}
					}
						//right right case
				    if(mc.right.right!=null) {
						if(mc.right.rank==mc.rank && mc.rank==2&&(mc.right.rank-mc.right.right.rank==1)) {
							mc = rotateright(mc);
							
						}//right left case
					}
				    else if(mc.right.left!=null) { 
						if(mc.right.rank==mc.rank &&mc.rank==2&&(mc.right.rank-mc.right.left.rank==1)) {
							mc.right=rotateleft(mc.right);
							mc=rotateright(mc);
							mc.rankupdate(1);
							if(mc.right!=null) {
								mc.right.prank=mc.rank;
								//mc.right.rank=mc.rank-2;
								if(mc.right.left!=null)	mc.right.left.prank=mc.right.rank;
								if (mc.right.right!=null)mc.right.right.prank=mc.right.rank;
							}
							if(mc.left!=null) {
								mc.left.prank=mc.rank;
								//mc.left.rank=mc.rank-2;
								if(mc.left.right!=null)	mc.left.right.prank=mc.left.rank;
								if (mc.left.left!=null)mc.left.left.prank=mc.left.rank;
									
							}
						}
					}
					
				}
				else {
				
					
					if(mc.right.rank==mc.rank && mc.rank-mc.left.rank==1 /*&&(mc.child=="right"||mc.child=="root"||(mc.child=="left"&&(mc.prank-mc.rank)==2))*/) {
						mc.rank=mc.rank+1;
						if(mc.right!=null)	{
							mc.right.child="right";
							mc.right.prank=mc.rank;
						}
						if(mc.left!=null) {
							mc.left.child="left";
							mc.left.prank=mc.rank;
						}
					}
						//right right case
					if(mc.right.right!=null) {
						if(mc.right.rank==mc.rank && mc.rank-mc.left.rank==2&&(mc.right.rank-mc.right.right.rank==1)) {
						mc = rotateright(mc);
						}//right left case
					}
					if(mc.right.left!=null) { 
						if(mc.right.rank==mc.rank &&mc.rank-mc.left.rank==2&&(mc.right.rank-mc.right.left.rank==1)/*||(mc.child=="left"&&(mc.prank-mc.rank)==1)*/) {
							mc.right=rotateleft(mc.right);
							mc=rotateright(mc);
							mc.rankupdate(1);
							if(mc.right!=null) {
								mc.right.prank=mc.rank;
								//mc.right.rank=mc.rank-2;
								if(mc.right.left!=null)	mc.right.left.prank=mc.right.rank;
								if (mc.right.right!=null)mc.right.right.prank=mc.right.rank;
							}
							if(mc.left!=null) {
								mc.left.prank=mc.rank;
								//mc.left.rank=mc.rank-2;
								if(mc.left.right!=null)	mc.left.right.prank=mc.left.rank;
								if (mc.left.left!=null)mc.left.left.prank=mc.left.rank;
									
							}
						}
					}
					
				}
			}
			else if(compare<0) {
				
				mc.left = majdoor(mc.left,kai,lwd);	
				mc.left.child="left";	
				mc.left.prank=mc.rank;
				if(mc.right ==null) {
					
					
											//case of limited hight	 rr case    if its root       lefft right case
						if(mc.left.rank==mc.rank && mc.rank==1) {
								mc.rank=mc.rank+1;
								
								if(mc.right!=null)	{
									mc.right.child="right";
									mc.right.prank=mc.rank;
								}
								if(mc.left!=null) {
									mc.left.child="left";
									mc.left.prank=mc.rank;
								}
						}
								//left left case
						 if(mc.left.left!=null) {
								if(mc.left.rank==mc.rank && mc.rank==2&&(mc.left.rank-mc.left.left.rank==1)) {
								mc = rotateleft(mc);
								}
								// left right case
						}
						if(mc.left.right!=null) { 
								if(mc.left.rank==mc.rank &&mc.rank>1&&(mc.left.rank-mc.left.right.rank==1)) {
									mc.left=rotateright(mc.left);
									mc=rotateleft(mc);
									mc.rankupdate(1);

									if(mc.right!=null) {
										mc.right.prank=mc.rank;
										//mc.right.rank=mc.rank-2;
										if(mc.right.left!=null)	mc.right.left.prank=mc.right.rank;
										if (mc.right.right!=null)mc.right.right.prank=mc.right.rank;
									}
									if(mc.left!=null) {
										mc.left.prank=mc.rank;
										//mc.left.rank=mc.rank-2;
										if(mc.left.right!=null)	mc.left.right.prank=mc.left.rank;
										if (mc.left.left!=null)mc.left.left.prank=mc.left.rank;
											
									}
								}
						}

				}else {
					if(mc.left.rank==mc.rank && mc.rank-mc.right.rank==1 /*&&(mc.child=="right"||mc.child=="root"||(mc.child=="left"&&(mc.prank-mc.rank)==2))*/) {
						mc.rank=mc.rank+1;
						if(mc.right!=null)	{
							mc.right.child="right";
							mc.right.prank=mc.rank;
						}
						if(mc.left!=null) {
							mc.left.child="left";
							mc.left.prank=mc.rank;
						}
				   }
						//left left case
				 if(mc.left.left!=null) {
						if(mc.left.rank==mc.rank && mc.rank-mc.right.rank==2&&(mc.left.rank-mc.left.left.rank==1)) {
						mc = rotateleft(mc);
						}
						
						
						// left right case
				}
				if(mc.left.right!=null) { 
						if(mc.left.rank==mc.rank &&mc.rank-mc.right.rank==2&&(mc.left.rank-mc.left.right.rank==1)) {
						mc.left=rotateright(mc.left);
						mc=rotateleft(mc);
						//System.out.println("jaiai  "+mc.key);
						mc.rankupdate(1);
						if(mc.right!=null) {
							mc.right.prank=mc.rank;
							//mc.right.rank=mc.rank-2;
							if(mc.right.left!=null)	mc.right.left.prank=mc.right.rank;
							if (mc.right.right!=null)mc.right.right.prank=mc.right.rank;
						}
						if(mc.left!=null) {
							mc.left.prank=mc.rank;
							//mc.left.rank=mc.rank-2;
							if(mc.left.right!=null)	mc.left.right.prank=mc.left.rank;
							if (mc.left.left!=null)mc.left.left.prank=mc.left.rank;
								
						}
						}
				}
					

				}
			}
			else {
				prev =mc.value;
				mc.value= lwd;
			}
			return mc;
		}
	}

	
	public V put(K key, V value){
		// write your code her 
		
		wavl  =  majdoor(wavl,key,value);
		V m=prev;
		prev=null;
		return m;
		
	}

	public V remove(K key){
		// write your code her 
		wavl=delete(key,wavl);
		V m=prev;
		prev=null;
		t=false;
		return m;
	}
	K last=null;
	boolean t=false;

	
	Node delete(K key, Node a) {
		if(a!=null) {
			int c = key.compareTo(a.key);
			if(c==0) {
				  //deleting the key
				if(t==false) {
					prev = a.value;
					t=true;
				}
						  if((a.right==null)&&(a.left==null)) {
							 last=a.key;
							  a=null;
							  return a;
						  }
						  else if ((a.right==null)&&(a.left!=null)) {
							 Node p=a;
							 Node lef=a.left;
							 a=null;
							 a=lef;
							 a.child=p.child;
							 a.prank=p.prank;
							 last=a.key;
							 return a;
	
						  }
						  else if (a.left==null) {
							 Node p=a;
							 // a=a.right;
							  
							  last=a.key;
							  a.key=a.right.key;
	  				    	  a.value=a.right.value;
	  				    	  a.child=p.child;
							  a.prank=p.prank;
	  				    	  a.right=null;
							  return a;
						  }
						  else {
							
							  Node mini =leftmos(a.right);
							  if(a.right.left!=null) {
								  a.key = mini.key;
								  a.value = mini.value;
								  a.right =delete(a.key,a.right);
								  
							  }
							  else {
								  Node as =a.left;
								  
								  a.key=a.right.key;
								  a.value=a.right.value;
								  a.right =delete(a.key,a.right);
							  }
							  
							  
								
								int r =0;
								int l =0;
								if(a.right!=null) {
				
									if(a.rank-a.right.rank==3) {
										if(a.left!=null) {
											if(a.left.right==null)r=a.left.rank;
											else r=a.left.rank-a.left.right.rank;
											
											if(a.left.left==null)l=a.left.rank;
											else l=a.left.rank-a.left.left.rank;
											// 1   /123   /223							
											if((a.prank-a.rank==1||a.prank-a.rank==2||a.child=="root") && a.rank-a.left.rank>1) {
												a.rank=a.rank-1;
												a.right.prank=a.rank;
												a.left.prank=a.rank;
												
											}
											//2 left22 node
											if((a.prank-a.rank==1||a.prank-a.rank==2||a.child=="root") && a.rank-a.left.rank==1&&l==r&&l==2&&a.rank-a.right.rank==3) {
												a.rank=a.rank-1;
												a.right.prank=a.rank;
												a.left.prank=a.rank;
												a.left.rank=a.left.rank-1;
												if(a.left.right!=null)a.left.right.prank=a.left.rank;
												if(a.left.left!=null)a.left.left.prank=a.left.rank;
											}
											if((a.prank-a.rank==1||a.prank-a.rank==2||a.child=="root") && a.rank-a.left.rank==1&&l==1&&a.rank-a.right.rank==3) {
												a=rotateleft(a);
												a.rankupdate(1);
												
												//double rotate left 12 or 11 node
											}
											if((a.prank-a.rank==1||a.prank-a.rank==2||a.child=="root") && a.rank-a.left.rank==1&&l==2&&r==1&&a.rank-a.right.rank==3) {
												Node sa = a;
												a.left=rotateright(a.left);
				
												a=rotateleft(a);
												a.child=sa.child;
												a.rank=sa.rank;
												a.prank=sa.prank;
												if(a.right!=null) {
													a.right.prank=a.rank;
													a.right.rank=a.rank-2;
													if(a.right.left!=null)	a.right.left.prank=a.right.rank;
													if (a.right.right!=null)a.right.right.prank=a.right.rank;
												}
												if(a.left!=null) {
													a.left.prank=a.rank;
													a.left.rank=a.rank-2;
													if(a.left.right!=null)	a.left.right.prank=a.left.rank;
													if (a.left.left!=null)a.left.left.prank=a.left.rank;
														
												}
												
											}
											
										}
										
									}
									
									
								}
								else {
									if(a.rank==3) {
										if(a.left!=null) {
											if(a.left.right==null)r=a.left.rank;
											else r=a.left.rank-a.left.right.rank;
											
											if(a.left.left==null)l=a.left.rank;
											else l=a.left.rank-a.left.left.rank;
											// 1   /123   /223							
											if((a.prank-a.rank==1||a.prank-a.rank==2||a.child=="root") && a.rank-a.left.rank>1) {
												a.rank=a.rank-1;
											//	a.right.prank=a.rank;
												a.left.prank=a.rank;
												
											}
											//2 left22 node
											if((a.prank-a.rank==1||a.prank-a.rank==2||a.child=="root") && a.rank-a.left.rank==1&&l==r&&l==2&&a.rank==3) {
												a.rank=a.rank-1;
												//a.right.prank=a.rank;
												a.left.prank=a.rank;
												a.left.rank=a.left.rank-1;
												if(a.left.right!=null)a.left.right.prank=a.left.rank;
												if(a.left.left!=null)a.left.left.prank=a.left.rank;
											}
											if((a.prank-a.rank==1||a.prank-a.rank==2||a.child=="root") && a.rank-a.left.rank==1&&l==1&&a.rank==3) {
												a=rotateleft(a);
												a.rankupdate(1);
												//double rotate left 12 or 11 node
											}
											if((a.prank-a.rank==1||a.prank-a.rank==2||a.child=="root") && a.rank-a.left.rank==1&&l==2&&r==1&&a.rank==3) {
												Node sa = a;
												a.left=rotateright(a.left);
												a=rotateleft(a);
				
												a.child=sa.child;
												a.rank=3;
												a.prank=sa.prank;
												
												if(a.right!=null) {
													a.right.prank=a.rank;
													a.right.rank=a.rank-2;
													if(a.right.left!=null)	a.right.left.prank=a.right.rank;
													if (a.right.right!=null)a.right.right.prank=a.right.rank;
												}
												if(a.left!=null) {
														a.left.prank=a.rank;
														a.left.rank=a.rank-2;
														if(a.left.right!=null)	a.left.right.prank=a.left.rank;
														if (a.left.left!=null)a.left.left.prank=a.left.rank;
															
												}
												
											}
											
										}
											
											
										
										
									}else if(a.left==null&&a.right==null&&a.rank==2) {
										a.rank=a.rank-1;
								}
								}
				
							  
							  
							  
							  return a;
						  }
				
			}else {
				if(c>0) {	
					a.right=delete(key,a.right);
					
					int r =0;
					int l =0;
					if(a.right!=null) {
	
						if(a.rank-a.right.rank==3) {
							if(a.left!=null) {
								if(a.left.right==null)r=a.left.rank;
								else r=a.left.rank-a.left.right.rank;
								
								if(a.left.left==null)l=a.left.rank;
								else l=a.left.rank-a.left.left.rank;
								// 1   /123   /223							
								if((a.prank-a.rank==1||a.prank-a.rank==2||a.child=="root") && a.rank-a.left.rank>1) {
									a.rank=a.rank-1;
									a.right.prank=a.rank;
									a.left.prank=a.rank;
									
								}
								//2 left22 node
							   if((a.prank-a.rank==1||a.prank-a.rank==2||a.child=="root") && a.rank-a.left.rank==1&&l==r&&l==2&&a.rank-a.right.rank==3) {
									a.rank=a.rank-1;
									a.right.prank=a.rank;
									a.left.prank=a.rank;
									a.left.rank=a.left.rank-1;
									if(a.left.right!=null)a.left.right.prank=a.left.rank;
									if(a.left.left!=null)a.left.left.prank=a.left.rank;
								}
								 if((a.prank-a.rank==1||a.prank-a.rank==2||a.child=="root") && a.rank-a.left.rank==1&&l==1&&a.rank-a.right.rank==3) {
									a=rotateleft(a);
									a.rankupdate(1);
									//double rotate left 12 or 11 node
								}
								 if((a.prank-a.rank==1||a.prank-a.rank==2||a.child=="root") && a.rank-a.left.rank==1&&l==2&&r==1&&a.rank-a.right.rank==3) {
									Node sa = a;
									a.left=rotateright(a.left);
	
									a=rotateleft(a);
									a.child=sa.child;
									a.rank=sa.rank;
									a.prank=sa.prank;
									if(a.right!=null) {
										a.right.prank=a.rank;
										a.right.rank=a.rank-2;
										if(a.right.left!=null)	a.right.left.prank=a.right.rank;
										if (a.right.right!=null)a.right.right.prank=a.right.rank;
									}
									if(a.left!=null) {
										a.left.prank=a.rank;
										a.left.rank=a.rank-2;
										if(a.left.right!=null)	a.left.right.prank=a.left.rank;
										if (a.left.left!=null)a.left.left.prank=a.left.rank;
											
									}
									
								}
								
							}
							
						}
						
						
					}
					else {
						if(a.rank==3) {
							if(a.left!=null) {
								if(a.left.right==null)r=a.left.rank;
								else r=a.left.rank-a.left.right.rank;
								
								if(a.left.left==null)l=a.left.rank;
								else l=a.left.rank-a.left.left.rank;
								// 1   /123   /223							
								if((a.prank-a.rank==1||a.prank-a.rank==2||a.child=="root") && a.rank-a.left.rank>1) {
									a.rank=a.rank-1;
								//	a.right.prank=a.rank;
									a.left.prank=a.rank;
									
								}
								//2 left22 node
								if((a.prank-a.rank==1||a.prank-a.rank==2||a.child=="root") && a.rank-a.left.rank==1&&l==r&&l==2&&a.rank==3) {
									a.rank=a.rank-1;
									//a.right.prank=a.rank;
									a.left.prank=a.rank;
									a.left.rank=a.left.rank-1;
									if(a.left.right!=null)a.left.right.prank=a.left.rank;
									if(a.left.left!=null)a.left.left.prank=a.left.rank;
								}
								if((a.prank-a.rank==1||a.prank-a.rank==2||a.child=="root") && a.rank-a.left.rank==1&&l==1&&a.rank==3) {
									a=rotateleft(a);
									a.rankupdate(1);
									//double rotate left 12 or 11 node
								}
								if((a.prank-a.rank==1||a.prank-a.rank==2||a.child=="root") && a.rank-a.left.rank==1&&l==2&&r==1&&a.rank==3) {
									Node sa = a;
									a.left=rotateright(a.left);
									a=rotateleft(a);
	
									a.child=sa.child;
									a.rank=3;
									a.prank=sa.prank;
								//	a.rankupdate(1);								
									if(a.right!=null) {
										a.right.prank=a.rank;
										a.right.rank=a.rank-2;
										if(a.right.left!=null)	a.right.left.prank=a.right.rank;
										if (a.right.right!=null)a.right.right.prank=a.right.rank;
									}
									if(a.left!=null) {
											a.left.prank=a.rank;
											a.left.rank=a.rank-2;
											if(a.left.right!=null)	a.left.right.prank=a.left.rank;
											if (a.left.left!=null)a.left.left.prank=a.left.rank;
												
									}
									
								}
								
							}
							
						}else if(a.left==null&&a.right==null&&a.rank==2) {
							a.rank=a.rank-1;
					}
					}
					return a;
				}
				else {
					a.left=delete(key,a.left);				
					int r =0;
					int l =0;
					if(a.left!=null) {
	
						if(a.rank-a.left.rank==3) {
							if(a.right!=null) {
								if(a.right.left==null)r=a.right.rank;
								else r=a.right.rank-a.right.left.rank;
								
								if(a.right.right==null)l=a.right.rank;
								else l=a.right.rank-a.right.right.rank;
								// 1   /123   /223							
								if((a.prank-a.rank==1||a.prank-a.rank==2||a.child=="root") && a.rank-a.right.rank>1&&a.rank-a.left.rank==3) {
									a.rank=a.rank-1;
									a.right.prank=a.rank;
									a.left.prank=a.rank;
									
								}
								//2 left22 node
								 if((a.prank-a.rank==1||a.prank-a.rank==2||a.child=="root") && a.rank-a.right.rank==1&&l==r&&l==2&&a.rank-a.left.rank==3) {
									a.rank=a.rank-1;
									a.left.prank=a.rank;
									a.right.prank=a.rank;
									a.right.rank=a.right.rank-1;
									if(a.right.left!=null)a.right.left.prank=a.right.rank;
									if(a.right.right==null)a.right.right.prank=a.right.rank;
								}
								if((a.prank-a.rank==1||a.prank-a.rank==2||a.child=="root") && a.rank-a.right.rank==1&&l==1&&a.rank-a.left.rank==3) {
									a=rotateright(a);
									a.rankupdate(1);
									if(a.right!=null)a.right.prank=a.rank;
									if(a.left!=null)a.left.prank=a.rank;
									//double rotate left 12 or 11 node
								}
								if((a.prank-a.rank==1||a.prank-a.rank==2||a.child=="root") && a.rank-a.right.rank==1&&l==2&&r==1&&a.rank-a.left.rank==3) {
									Node sa = a;
									a.right=rotateleft(a.right);
									a=rotateright(a);
									a.child=sa.child;
									a.rank=sa.rank;
									a.prank=sa.prank;
									if(a.right!=null) {
										a.right.prank=a.rank;
										a.right.rank=a.rank-2;
										if(a.right.left!=null)	a.right.left.prank=a.right.rank;
										if (a.right.right!=null)a.right.right.prank=a.right.rank;
									}
									if(a.left!=null) {
											a.left.prank=a.rank;
											a.left.rank=a.rank-2;
											if(a.left.right!=null)	a.left.right.prank=a.left.rank;
											if (a.left.left!=null)a.left.left.prank=a.left.rank;
												
									}
	
									if(a.left.right!=null)	a.left.right.prank=a.left.rank;
									if (a.left.left!=null)a.left.left.prank=a.left.rank;
									
								}
								
							}
							
						}
						
						
					}
					else {
						if(a.rank==3) {
							if(a.right!=null) {
								if(a.right.left==null)r=a.right.rank;
								else r=a.right.rank-a.right.left.rank;
								
								if(a.right.right==null)l=a.right.rank;
								else l=a.right.rank-a.right.right.rank;
								// 1   /123   /223							
								if((a.prank-a.rank==1||a.prank-a.rank==2||a.child=="root") && a.rank-a.right.rank>1) {
									a.rank=a.rank-1;
									a.right.prank=a.rank;
									//a.left.prank=a.rank;
									
								}
								//2 left22 node
								 if((a.prank-a.rank==1||a.prank-a.rank==2||a.child=="root") && a.rank-a.right.rank==1&&l==r&&l==2&&a.rank==3) {
									a.rank=a.rank-1;
									//a.left.prank=a.rank;
									a.right.prank=a.rank;
									a.right.rank=a.right.rank-1;
									if(a.right.left!=null)a.right.left.prank=a.right.rank;
									if(a.right.right==null)a.right.right.prank=a.right.rank;
								} if((a.prank-a.rank==1||a.prank-a.rank==2||a.child=="root") && a.rank-a.right.rank==1&&l==1&&a.rank==3) {
									a=rotateright(a);
									a.rankupdate(1);
									//double rotate left 12 or 11 node
								}
								if((a.prank-a.rank==1||a.prank-a.rank==2||a.child=="root") && a.rank-a.right.rank==1&&l==2&&r==1&&a.rank==3) {
									Node sa = a;
									a.right=rotateleft(a.right);
									a=rotateright(a);
									a.child=sa.child;
									a.rank=3;
									a.prank=sa.prank;
	
									if(a.right!=null) {
										a.right.prank=a.rank;
										a.right.rank=a.rank-2;
										if(a.right.left!=null)	a.right.left.prank=a.right.rank;
										if (a.right.right!=null)a.right.right.prank=a.right.rank;
									}
									if(a.left!=null) {
											a.left.prank=a.rank;
											a.left.rank=a.rank-2;
											if(a.left.right!=null)	a.left.right.prank=a.left.rank;
											if (a.left.left!=null)a.left.left.prank=a.left.rank;
												
									}
								}
								
							}
							
						}else if(a.right==null&&a.left==null&&a.rank==2) {
							a.rank=a.rank-1;
						}
						
					}
					
					return a;
				}
			}
		}
		else return null;
	}
	
	  Node leftmos(Node a) {
		  if(a.left!=null) {
			  return leftmos(a.left);
		  }else {
			 Node b = new Node(a.key,a.value);
			  return b;
		  }
	  }
	 	

	public V get(K key){
		// write your code her 
		Node a =getkey(wavl,key);
		if (a==null) return null;
		else return a.value;
	}
	
	Node getkey(Node a,K key) {
		if(a!=null) {
		if(key.compareTo(a.key)>0) {
			if(a.right!=null) {
				return getkey(a.right,key); 
			}
			else return null;
		}
		else if(key.compareTo(a.key)<0) {
			if(a.left!=null) {
				return getkey(a.left,key);
			}
			else return null;
		}
		else return a;
		}
		else return null;
		
		
		
	}
	Vector<V> search =new Vector<V>();
	public Vector<V> searchRange(K key1, K key2){
		// write your code her 
		Vector<V> search1 =new Vector<V>();
		range(wavl,key1,key2);
		search1=new Vector<V>(search);
		search.clear();		
		if(search1.isEmpty())return null;
		else return search1;
	}
	void range(Node a,K key1,K key2){
		int c1=key1.compareTo(a.key);
		int c2=key2.compareTo(a.key);
		  if(a!=null) {
			  if(a.left!=null) {
					 range(a.left,key1,key2);
				}

			  if(c1<=0&&c2>=0) search.add(a.value);
				
			  if(a.right!=null) {
				 range(a.right,key1,key2);
			 } 
			  
		  }
		
	}

	public int rotateCount(){
		// write your code her 
		return rotatecount;
	}

	public int getHeight(){
		// write your code her 
		
		int h= hight(wavl,0);
		return h;
		
	}

	public int hight (Node m,int a) {
		  if(m==null) return a;
		  else {
			int lh=  hight(m.left,a+1);
			int rh= hight(m.right,a+1);
			if(lh>rh)return lh;
			else return rh;
		  }
	  }

	Vector<K> bfs =new Vector<K>();
	public Vector<K> BFS(){
		// write your code her
		bfs.clear();

		Vector<K> bf =new Vector<K>();
		printBST();
		bf= new Vector<K>(bfs);
		printBST();
		bfs.clear();
		return bf;
	}
	
    public void printBST () {
		//write your code here
    	Node x = wavl;
    	int h = high(x,0);
    	if(h>0) {
    		
    		//System.out.println(wavl.key+", "+wavl.rank);
        	bfs.add(wavl.key);
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
		   
		   //System.out.println((m.left).key+", "+m.left.rank);
		   bfs.add((m.left).key);
	   }
		
	   if(m.right!=null) {
		   //System.out.println((m.right).key+", "+(m.right).rank);
		   bfs.add((m.right).key);
	   }
	 
	   }
	   
   }
	/*	
		public static void main(String[] args) {
			WeakAVLMap<Integer,Integer> dedso =new WeakAVLMap();
			dedso.put(2,41);

			dedso.put(69,72);
			dedso.put(83,55);

			dedso.remove(83);	

			dedso.put(5,100);
			dedso.put(109,14);
			dedso.put(3245,1435);

			dedso.put(345,643);

			dedso.put(13,6435);		
			dedso.BFS();
			System.out.println(dedso.rotatecount); 
			System.out.println(); 
			dedso.remove(2);
			System.out.println(dedso.rotatecount); 
			dedso.BFS();
			dedso.put(1,6435);
	
			
			
			
		}
*/
}

//test case 5
/*	
dedso.put(30886, 3);
dedso.put(47793, 3);
dedso.put(60492, 3);
dedso.put(2362, 3);
dedso.put(20059, 3);
dedso.put(89172, 3);

dedso.remove(89172);
dedso.put(33069, 3);
dedso.remove(47793);		
dedso.remove(2362);		
dedso.remove(30886);
dedso.remove(33069);
dedso.put(99932, 3);
dedso.put(10012, 3);
dedso.put(26652, 3);
dedso.put(9441, 3);
//	dedso.put(99932, 3);
dedso.remove(8117);
dedso.put(55306, 3);
dedso.remove(55306);
dedso.put(92379, 3);
dedso.remove(9441);
dedso.remove(60492);
dedso.put(53275, 3);


//System.out.println(		dedso.BFS());
dedso.put(22404, 255);
dedso.remove(22404);
dedso.remove(53275);
dedso.remove(26652);
dedso.put(38082, 255);		

dedso.remove(10012);
dedso.remove(38082);
dedso.put(86708, 255);
dedso.put(90071, 255);
dedso.remove(20059);
dedso.put(11340,44);		
dedso.remove(92379);
dedso.put(75321,44);		
dedso.remove(86708);
dedso.put(96658,44);
dedso.remove(99932);		
dedso.put(41222,44);		
dedso.remove(75321);
dedso.remove(88819);
dedso.put(11340,44);			
dedso.put(21860,44);	
dedso.put(23205,44);	
dedso.remove(11340);
dedso.put(2021,22);

dedso.put(21648,22);

dedso.put(90071,22);

dedso.put(73788,22);
dedso.printBST();
System.out.println(	"lal  "+	dedso.rotatecount);	
System.out.println();
dedso.remove(23205);
dedso.printBST();
System.out.println(	"lal  "+	dedso.rotatecount);	
dedso.remove(73788);
dedso.put(9188,22);		
dedso.put(53414,22);

dedso.put(7556,22);


dedso.put(9188, 255);
dedso.put(53414, 255);
dedso.put(7556, 255);
//dedso.put(99932, 255);
System.out.println();	
dedso.printBST();

System.out.println(	"lal  "+	dedso.rotatecount);		
		
//System.out.println(dedso.remove(4));
//System.out.println(dedso.searchRange(120, 130));
//dedso.remove(15);
//dedso.put(14,1);

//dedso.put(14,6);


//dedso.put(6,16);
//dedso.put(7,25);

//dedso.put(8,21);
//dedso.put(9,26);
//dedso.delete(5);

//dedso.insert(8,21);
//dedso.insert(9,18);

//dedso.printBST();

//dedso.printBST();

//int a = dedso.getHeight();
//System.out.print(dedso.BFS());
//dedso.update(9, 300);

//dedso.printBST();
//dedso.update(75, 1400);

//	dedso.printBST();
*/
//	System.out.println(dedso.get(1));		

//testcase 2	
/*System.out.println(dedso.put(109,14));		
System.out.println(dedso.put(3245,1435));
System.out.println(dedso.put(345,643));
System.out.println(dedso.get(345));
System.out.println(		dedso.get(3245));
System.out.println(		dedso.get(109));
System.out.println(		dedso.put(109, 24));
System.out.println(		dedso.get(109));
System.out.println(		dedso.remove(345));
System.out.println(		dedso.get(345));
System.out.println(		dedso.put(1, 239));
System.out.println(		dedso.get(1));
System.out.println(		dedso.get(2));
System.out.println(		dedso.remove(2));
System.out.println(		dedso.put(19,109));
System.out.println(		dedso.get(19));

*/
	//testcase3
/*	System.out.println(		dedso.	put(4,48));
	System.out.println(		dedso.put(96,49));
	System.out.println(		dedso.get(4));
	System.out.println(		dedso.searchRange(4,96));
	System.out.println(		dedso.searchRange(4,95));
	System.out.println(	dedso.put(92, 89));
	System.out.println(	dedso.remove(4));
	System.out.println(	dedso.put(6, 10));
	System.out.println(	dedso.put(58, 66));
	System.out.println(	dedso.put(50, 31));
	System.out.println(	dedso.remove(50));			
	System.out.println(	dedso.put(8, 82));			
	System.out.println(	dedso.get(8));
	System.out.println(	dedso.put(58, 1));
	System.out.println(	dedso.get(58));	
	System.out.println(		dedso.searchRange(50,100));			
	System.out.println(		dedso.searchRange(1,100));
	System.out.println(		dedso.put(61,103));
	System.out.println(		dedso.searchRange(54,62));
	*/
/*	
	*/