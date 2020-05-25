import java.io.*; 
import java.util.*;
import java.text.*;


class InverseDoesNotExistException extends Exception
{
	public InverseDoesNotExistException(String s)
	{
	// Call constructor of parent Exception
		super(s);
		}
}

class SubBlockNotFoundException extends Exception
{
	public SubBlockNotFoundException(String s)
	{
	// Call constructor of parent Exception
		super(s);
		}
}

class IncompatibleDimensionException  extends Exception
{
	public IncompatibleDimensionException (String s)
	{
	// Call constructor of parent Exception
		super(s);
		}
}

public class TwoDBlockMatrix{
    public float[][] big;	
    public TwoDBlockMatrix getSubBlock (int rows, int cols, int rowe, int cole) throws SubBlockNotFoundException{
    	TwoDBlockMatrix obj = new TwoDBlockMatrix(big);
      if(rowe-rows<=0 || cole-cols<=0 || rows>obj.big.length||rowe>obj.big.length||cols>obj.big[0].length||cole>obj.big[0].length) {
        throw new SubBlockNotFoundException("sub block not found");
      }
      else{
      
      float[][] a = new float[rowe-rows][cole-cols];
         int p = 0;
         int i = rows;
         while( i < rowe ) {
           int q=0;
           for (int j = cols; j < cole; j++){
             a[p][q] = obj.big[i-1][j-1];
             q++;
         }
         p++;
         i++;
   }
         
         TwoDBlockMatrix r = new TwoDBlockMatrix(a);
         return r;
        }
   }
 
    TwoDBlockMatrix transpose() {
    	TwoDBlockMatrix obj = new TwoDBlockMatrix(big);
      int row = obj.big.length;
      int column = obj.big[0].length;
      float[][] temp = new float[obj.big.length][obj.big[0].length];
      
          for (int i = 0; i < obj.big.length; i++) {
              temp[i] = Arrays.copyOf(obj.big[i], obj.big[i].length);
            }
          
          float[][] transpose = new float[column][row];
          int i = 0;
          while( i < row ) {
              for (int j = 0; j < column; j++) {
                  transpose[j][i] = temp[i][j];
              }
              i++;
          }
          TwoDBlockMatrix T = new TwoDBlockMatrix(transpose);
          return T;
      
    }
    
    TwoDBlockMatrix(float[][] array){
            big = array;
          
    }
   
    
    static TwoDBlockMatrix buildTwoDBlockMatrix(InputStream in) {
            
      
      
              Scanner sasti = new Scanner(in);          
              Vector<Integer> location_row = new Vector<Integer>();
              Vector<Integer> location_col = new Vector<Integer>();
              Vector<Vector<Float>> ccol = new Vector<Vector<Float>>();
              Vector<Vector<Vector<Float>>> blocks = new Vector<Vector<Vector<Float>>>();             
             
              int row =0; 
              int col=0;
              int bcount=0;
                 
              while(sasti.hasNextInt()){
      
                              location_row.add(sasti.nextInt());
                              // location_col.add(sasti.nextInt());
                              
                              boolean  tr = false;
                                   int count=0;
                                  while((sasti.hasNextFloat())){
                                    if(count==0)location_col.add(sasti.nextInt());
                                           
                                              //row bana rahe 
                                              Vector<Float> crow = new Vector<Float>(); 
                                             
                                              while(sasti.hasNextFloat()){
                                                crow.add(sasti.nextFloat());          
                                                
                                              }
                                       
                                              String temp = sasti.next();
                                            
                                              String fin = temp.substring(0,(temp.length()-1));
                                              
                                              float converter = Float.valueOf(fin);
                                              crow.add(converter);
       
                                              ccol.add(new Vector<Float>(crow));
                                            
                                              //these two if conditions give the size of the final matrix
                                              
                                                    if(col<(crow.size()+ location_col.get(bcount)-1)){
                                                      col = crow.size()+ location_col.get(bcount)-1 ;
                                                    
                                                    }
                                                 
                                               crow.removeAllElements(); 
                                               count = count+1;
                                               
                                   }  
                                   
                                    sasti.nextLine();
                                    String hash= sasti.nextLine();
                                    
                                    if(hash.length() != 1){
                                        while(hash.length() !=1){
                                          String rin = hash.substring(0,(hash.length()-1));
                                          float converterr = Float.valueOf(rin);
                                          Vector<Float> convert =new Vector<Float>();
                                          convert.add(converterr);
                                          ccol.add(convert);
                                        
                                          hash = sasti.nextLine();
                                          count++;
                                          tr = true;
      
      
                                        }
                                    }
                                    if(tr==true)count = count -1;
                                    
                                    if(row<(count + location_row.get(bcount)-1)){
                                      row =  count + location_row.get(bcount)-1;
                                    }    
                                    blocks.add(new Vector<Vector<Float>>(ccol));
      
                                    ccol.removeAllElements();
                                    bcount++;
                                 
                  }            
                  sasti.close();
                  //given blocks converted to vector form and stored in blocks
                  System.out.println(blocks);
                  int temp = col;
                  col = row;
                  row = temp;
      
                 //creating the matrix of zeros for final matrix
                  float[][] matrix = new float[col][row];
                  
               
                 //adding the given sublocks in the matrix of zeros
                 Vector<Vector<Float>> submat = new Vector<Vector<Float>>(); 
                 Vector<Float> subrow = new Vector<Float>();
                 int x,y;
                    for (int i = 0 ;i<bcount;i++ ){
                      submat = blocks.get(i);
                      for(int k=0;k<submat.size();k++){
                        subrow =submat.get(k);
                        y = location_row.get(i)+k-1;
                        for(int l =0 ; l<subrow.size() ;l++){
                            x =  location_col.get(i)+l-1;                
                            matrix[y][x] = subrow.get(l);
                        }
                      }
                    } 
                    //matrix is finally created
                    TwoDBlockMatrix F = new  TwoDBlockMatrix(matrix);
                 return F;
      
          
      }
     
     boolean has_zero(int r,int cs, int ce ){
     	TwoDBlockMatrix obj = new TwoDBlockMatrix(big);
                boolean t = true;
                int l=0;
                int c=cs;          
            while(l<(ce-cs+1)){
                if(obj.big[r][c+l]==0) t = false;    
                l++;                   
            }
            return t; 
     }
    

     public String toString(){
     	TwoDBlockMatrix obj = new TwoDBlockMatrix(big);
        int cols =obj.big[0].length;
        int rows =obj.big.length;
        float[][] temp = obj.big;
        for(int ka = 0;ka<obj.big.length;ka++){
            temp[ka] = Arrays.copyOf(obj.big[ka],obj.big[ka].length);
        }

        DecimalFormat ft = new DecimalFormat("0.##");

        int m=0;
        int n=0;
        Vector<String> complete_s =  new Vector<String>();
        String trow ="";
        String frow ="";
        String newline = System.lineSeparator();
        
        //chalo shuru kare 
        for(int i=0; i < rows;i++){
            for(int k=0;k<cols;k++){ 
                
                
                if(temp[i][k] != 0){
                                //storing location of first block
                                complete_s.add(String.valueOf(i+1)+" "+String.valueOf(k+1));
                            
                                m=k;
                                n=i+1;
                                while((m<cols)&&(temp[i][m]!=0)){
                                                                      
                                        trow = trow +ft.format(temp[i][m]) +" ";
                                        temp[i][m]=0;
                                        m++;
                                       
                                }
                            
                                frow = trow.substring(0,(trow.length())-1)+";";          //storing the row along with ;
                                complete_s.add(frow);
                            
                                trow = "";
                                frow = "";
                                
                                // has_zero(n,k,(m-1)
                                while(n<rows && has_zero(n,k,(m-1))){
                                //    System.out.println(cnt+" "+m+","+n + " ");
                                   int cnt=k;
                                   while(cnt<m){
                                            trow = trow +ft.format(temp[n][cnt]) +" ";
                                            temp[n][cnt]=0;
                                            // System.out.println(cnt+" "+m+","+n + " "+rows);

                                            cnt++;
                                        }
                                        
                                        frow = trow.substring(0,(trow.length())-1)+";";               
                                        complete_s.add(frow);
                                        
                                        trow ="";
                                        frow ="";  
                                            n++;
                                }
                                
                                complete_s.add("#");
                        } 
             }
         }
        String fina =""; 
         for(int co = 0;co<(complete_s.size()-1);co++){
             fina =fina + complete_s.get(co)+newline;
         }
         fina = fina+"#";
        // System.out.println(fina);
         
        return fina ;

     }

     TwoDBlockMatrix multiply(TwoDBlockMatrix other) throws IncompatibleDimensionException{  
      	TwoDBlockMatrix obj = new TwoDBlockMatrix(big);

      int r1 = obj.big.length;
      int c1 = obj.big[0].length;
      int r2 = other.big.length;
      int c2 = other.big[0].length;

      if(c1 == r2) {
    	  float[][] step = new float[obj.big.length][obj.big[0].length];
          float[][] step1 = new float[other.big.length][other.big[0].length];
          float[][] m = new float[r1][c2];
          int it = 0;
          for (it = 0; it <obj.big.length;it++) {
              step[it] = Arrays.copyOf(obj.big[it], obj.big[it].length);
              
            }
          
          
          
          for (int i = 0; i < other.big.length; i++) {
              step1[i] = Arrays.copyOf(other.big[i], other.big[i].length);
            }
          
            
          for(int i = 0; i < r1;i++ ) {
              for (int j = 0; j < c2; j++) {
                 m[i][j] = 0;
                 for (int k = 0; k < r2; k++) {
                    m[i][j] += step[i][k] * step1[k][j];
                 }
              }
              
           }
          
      TwoDBlockMatrix M = new TwoDBlockMatrix(m);
      return M;
      }
      else {
    	  throw new IncompatibleDimensionException("Enter Proper Dimension Matrices");
      }
   }
  
   static float determinant(float D[][], float n) { 
    int p = 0;  
    if (n == 1) 
      return D[0][0]; 
  
    float [][]temp = new float[D.length][D.length]; 
  
    int check = 1;  
    int f = 0;
    while( f < n) {
      int i = 0, j = 0; 
      int row = 0;
    while ( row < (int)n){ 
      for (int col = 0; col < (int)n; col++){ 
        if (row != 0 && col != f) { 
          temp[i][j++] = D[row][col]; 
          if (j == (int)n - 1) { 
            j = 0; 
            i++; 
            }
          }
        }
      row++; 
    } 
      p += check * D[0][f] * determinant(temp, n - 1); 
      check = -check; 
      f++;
    } 
  
    return p; 
  } 
  
   void adjoint(float Disco[][],float[][] adj) { 
     	TwoDBlockMatrix obj = new TwoDBlockMatrix(big);
    int Ne = obj.big.length;
  
    if (Disco.length == 1) { 
      adj[0][0] = 1; 
      return; 
    } 
  
      int check = 1; 
    float [][]step = new float[Disco.length][Disco.length]; 
  
  
    int i = 0; 
    while (i < Disco.length) { 
      for (int j = 0; j < Disco.length; j++) {
        int i_ = 0, j_ = 0;
        for (int row = 0; row < Disco.length; row++){ 
          int col = 0;
          while ( col <  Disco.length){ 
            if (row != i && col != j) { 
              step[i_][j_++] = Disco[row][col]; 
              if (j_ ==  Disco.length - 1){ 
                j_ = 0; 
                i_++; 
              } 
            } 
            col++;
          } 
        }	
        check = ((i + j) % 2 == 0)? 1: -1; 
   
        adj[j][i] = (check)*(determinant(step,Ne-1)); 
      } 
      i++;
    } 
  } 
  
  TwoDBlockMatrix inverse() throws InverseDoesNotExistException{ 
    	TwoDBlockMatrix obj = new TwoDBlockMatrix(big);
    int N = obj.big.length;
    int M = obj.big[0].length;
  
    float det = determinant(obj.big, N);
    if(N==M && det!=0) {
    
    float [][]inverse = new float[obj.big.length][obj.big.length];
    
  
    float [][]adj = new float[N][N]; 
    adjoint(obj.big, adj);
    
    for (int i = 0; i < N; i++)
      for (int j = 0; j < N; j++) 
        inverse[i][j] = adj[i][j]/(float)det; 
  
    TwoDBlockMatrix I = new TwoDBlockMatrix(inverse);
    return I; 
  } 
    else {
      throw new InverseDoesNotExistException("Inverse does not exist");
    }
  }
  

  
  
  

}
