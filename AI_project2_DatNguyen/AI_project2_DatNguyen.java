package AI_project2_DatNguyen;

import java.io.File;
import java.util.Scanner;


public class AI_project2_DatNguyen {
  public static void main(String[] args) {
    System.out.println("Welcome to the 8-puzzle solver!");
    System.out.println("1.Very Easy.\n2.Easy.\n3.Medium.\n4.Hard.\n5.Very Hard.");
    System.out.println("Choose which 8-puzzle you want to solve:");
    Scanner sc = new Scanner(System.in);
    int path = sc.nextInt();
    String pathname="";
    switch(path){
      case 1:
        pathname = "AI_project2_DatNguyen//very_easy.txt";
        break;
      case 2:
        pathname = "AI_project2_DatNguyen//easy.txt";
        break;
      case 3:
        pathname = "AI_project2_DatNguyen//medium.txt";
        break;
      case 4:
        pathname = "AI_project2_DatNguyen//hard.txt";
        break;
      case 5:
        pathname = "AI_project2_DatNguyen//very_hard.txt";
        break;
      default:{
        System.out.println("Error input!");
      }
    }

    System.out.println("Please indicate which searching algorithm you want to use:\n1.Breath First Search.\n2.A*");
    int searchAlgo=sc.nextInt();
    sc.close();
    int[] content = new int[9];
    try {
      File x = new File(pathname);
      sc = new Scanner(x);
      int i = 0;
      while (sc.hasNextLine()) {
        content[i] = sc.nextInt();
        i++;
      }
      sc.close();
    } catch (Exception e) {
      
    }

    State oriState = new State(content);
    switch(searchAlgo){
      case 1:
        Search.breathFirstSearch(oriState);
        break;
      case 2:
        Search.aStar(oriState);
        break;
      default:
        System.out.println("Error input!");  
    }
  }
}
