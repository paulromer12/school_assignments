public class Pyramids_04{

    public static void main(String [] args){
  
      int row;
      int column;
      int space;
  
      for(row = 6; row >= 1; --row){
  
        for(space = 6; space > row; --space){
  
          System.out.print("  ");
        }
  
        for(column = 1; column <= row; ++column){
  
          System.out.print(column + " ");
        }
  
        System.out.println();
      }
    }
  }