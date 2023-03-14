import java.util.Scanner;

public class AI_project1 {
  private static int numSticks;
  private static int maxRemove;
  
  public static int comMove(int numSticks){
    if(numSticks%(maxRemove+1)==0){
      return 1;
    }else{
      return numSticks%(maxRemove+1); 
    }
  }

  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);  
    numSticks=15;maxRemove=5;
    System.out.println("Weldome to the game of NIM. Here are the game rules:\nThere are "+numSticks+" of sticks. You will complete againts the computer.\nEach turn, either player must take from 1 to "+maxRemove+" sticks for the stacks.\nThe one who take the last stick win. The computer goes first. glhf!");
    System.out.println("Game start!--------------------------------------");
    System.out.println("There are currently "+numSticks+" sticks left in the stack.");
    while(numSticks>0){
      numSticks-=comMove(numSticks);
      if(numSticks==0){
        System.out.println("You have lost");
        break;
      }
      System.out.println("After the computer turn, there are "+numSticks+" sticks left.");
      System.out.print("Your turn:");
      int input=sc.nextInt();
      while(input>numSticks || input>maxRemove || input <=0){
        System.out.println("Invalid move! Please try agian!");
        input=sc.nextInt();
      }
      numSticks-=input;
      if(numSticks==0){
        System.out.println("You have won");
        break;
      }
      System.out.println("After your turn, there are "+numSticks+" sticks left.");
    }
    sc.close();
  }
}
