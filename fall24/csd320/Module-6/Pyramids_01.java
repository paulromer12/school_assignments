public class Pyramids_01 {
    public static void main(String[] args) {
  
      int row;
      int column;
  
      for(row = 1;  row <= 6; ++row){
  
        for(column = 1; column <= row; column++){
  
          System.out.print(column + " ");
        }
       
        System.out.println();
      }
    }
  }