
import java.lang.String;
import java.util.Arrays;

public class MyCalculator {
	
	
	
	String lodu(String exp) throws EmptyStackException {
		
			//base case
				String num="";
				MyStack<String> cal =new MyStack<String>();

				String sol ="101";
				
				
				int in =exp.indexOf(')');
				int fin =0;
				
				
			for(int i=in-1;i>-1;i--) {

				char r = exp.charAt(i);
				if(r==' ')continue;

				else if ((r=='*'||r=='-'||r=='+'||r=='('||r=='*')&&exp.charAt(i+1)!='-') {
					
					
					if(r=='-'&&(exp.charAt(i-1)=='+'||exp.charAt(i-1)=='*'||exp.charAt(i-1)=='('||exp.charAt(i-1)=='-')) {
						
							num=reverse(num);
							
							num=Character.toString(r)+num;

							cal.push(num);

							num="";
							continue;
						
					}
					else if(r=='('){
								if(num.contains("-")==false) {
								num=reverse(num);	
								cal.push(num);
								num="";
								//disp(cal);
								sol =bodmas(cal);
							   
							    cal.popall();
							    fin= i;

								}
								else {
		
									cal.push(num);
									num="";
								    sol =bodmas(cal);
								   // disp(cal);
								    cal.popall();
								    fin= i;
								}
							 
							    if(in!=exp.length()-1) {
							    String ne = exp.substring(0, fin);
							    String nex = exp.substring(in+1);
							    exp= ne+sol+nex;
							  // System.out.println(exp);
								in=exp.indexOf(')');
									
								i=exp.indexOf(')');
								
							   }
		
							    else if(in==exp.length()-1){
		
								   exp=sol;
								   break;
							   }
					   }
						else{
								num=reverse(num);
								cal.push(num);
								num=Character.toString(r);
								cal.push(num);
								num="";
							}
							
					
				}
				else if((r=='*'||r=='-'||r=='+'||r=='('||r=='*')&&exp.charAt(i+1)=='-') {
					num="";
					num=Character.toString(r);

					cal.push(num);
					num="";
				}
				else {
					num = num +r;
				}
			
			}
			return sol;
		
	}
	
	boolean has(String value,MyStack<String> bod) {
		boolean t= false;
		
		for(int i =0;i<bod.size();i++) {

			if (bod.get(i).contentEquals(value)) {
				t =true;
				break;
			}
		}
		return t;
	}
	String reverse(String s) {
		String lol="";
		for(int i=s.length()-1;i>-1;i--){
			lol=lol+s.charAt(i);
		}
		return lol;
	}
	 MyStack<String> rev( MyStack<String> lol){
		 MyStack<String> lo=new MyStack<String>();
		 for(int i=lol.size()-1;i>-1;i--){
				lo.push(lol.get(i));
			}
		 return lo;
	 }
	String bodmas ( MyStack<String> bod ) throws EmptyStackException  {
			bod = rev(bod);
			int i=1;
			//disp(bod);
			while(has("*",bod)) {

				if(bod.get(i).contentEquals("*")) {
					int a1 = Integer.parseInt(bod.get(i-1));
					//System.out.println(bod.get(i+1)+"jai");
					int a2 = Integer.parseInt(bod.get(i+1));
					//System.out.println(a2+"jai");
					int c = a1*a2;
					String s =Integer.toString(c);
					bod.removnad(i, s);
					
					i=i-1;
				}
				i++;
			}

			int j=1;
			while(has("-",bod)) {
				if(bod.get(j).contentEquals("-")) {
					int a1 = Integer.parseInt(bod.get(j-1));
					int a2 = Integer.parseInt(bod.get(j+1));
					int c = a1-a2;
					
					String s =Integer.toString(c);
					bod.removnad(j, s);
					j=j-1;
					
				}
				j++;
					
			}
			 j=1;

			while(has("+",bod)) {
			
				if(bod.get(j).contentEquals("+")) {
					int a1 = Integer.parseInt(bod.get(j-1));
	
					int a2 = Integer.parseInt(bod.get(j+1));
					int c = a1+a2;
					String s =Integer.toString(c);
					//System.out.println(a1+" add "+a2+" add");
					bod.removnad(j, s);
					j=j-1;
					
				}
				j++;
				
			}
			//System.out.println(bod.top());
			
			return bod.top();
		
		}
		
	int calculate(String exp)throws EmptyStackException {
		int solution=0;
		String sa= "("+exp +")";
		//System.out.println(sa);
		String s= lodu(sa);
		solution = Integer.parseInt(s);
		return solution;
	}

	

}
