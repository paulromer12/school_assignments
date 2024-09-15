public class Pyramids_02{

    public static void main(String [] args){
  
      int row;
      int column;
  
      for(row = 6; row >= 1; row--){
  
        for(column = 1; column <= row; ++column){
  
          System.out.print(column + " ");
        }
  
        System.out.println();
      }
    }
  }