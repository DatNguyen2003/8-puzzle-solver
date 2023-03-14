package AI_project2_DatNguyen;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


public class Search {
  
  public static void breathFirstSearch(State oriState){
    Queue<State> open = new LinkedList<State>();//Create the OPEN set
    ArrayList<State> close = new ArrayList<State>();//Create the CLOSE set
    open.add(oriState);//Adding the ORIGINAL state to OPEN
    int[] goal = {1,2,3,8,0,4,7,6,5};
    State goalState = new State(goal);//Creating the GOAL state
    boolean done = false;
    int numStateExpand=0;
    while(!done){
      if(open.isEmpty()){
        System.out.println("Search has failed!");//When OPEN is empty, inform users that the search have failed
        break;
      }
      State head=open.poll();//Select a state from OPEN
      numStateExpand++;
      if(close.contains(head)){//Check if the state is in CLOSE
        continue;
      }
      if(head.equals(goalState)){//End the search if we have achieved the GOAL state
        close.add(head);
        break;
      }
      try {
        open.add(head.generateUp());//Generate a state by moving the 0 upward
      } catch (Exception e) {
      }
      try {
        open.add(head.generateDown());//Generate a state by moving the 0 downward
      } catch (Exception e) {
      }
      try {
        open.add(head.generateLeft());//Generate a state by moving the 0 left
      } catch (Exception e) {
      }
      try {
        open.add(head.generateRight());//Generate a state by moving the 0 right
      } catch (Exception e) {
      }
      close.add(head);//Add the state to CLOSE
      continue;
    }
    close.get(close.size()-1).printAll();//Print the path from the ORIGINAL state to the GOAL state
    System.out.println();
    System.out.println("Number of states expanded: "+numStateExpand);//Print number of states expanded
    System.out.println("Number of moves: "+close.get(close.size()-1).getG());//Print number of moves
  }


  public static void aStar(State oriState){
    PriorityQueue<State> open = new PriorityQueue<>(new Comparator<State>() { 
      public int compare(State p1, State p2) { 
          return ((p1.getH()+p1.getG()) - (p2.getH()+p2.getG())); 
      } 
    });//Create the OPEN set
    ArrayList<State> close = new ArrayList<State>();//Create the CLOSE set
    open.add(oriState);//Adding the ORIGINAL state to OPEN
    State goalState = new State(State.goal);//Creating the GOAL state
    boolean done = false;
    int numStateExpand=0;
    while(!done){
      if(open.isEmpty()){
        System.out.println("Search has failed!");//When OPEN is empty, inform users that the search have failed
        break;
      }
      State head=open.poll();//Select a state from OPEN
      numStateExpand++;
      if(close.contains(head)){//Check if the state is in CLOSE
        continue;
      }
      if(head.equals(goalState)){//End the search if we have achieved the GOAL state
        close.add(head);
        break;
      }
      try {
        open.add(head.generateUp());//Generate a state by moving the 0 upward
      } catch (Exception e) {
      }
      try {
        open.add(head.generateDown());//Generate a state by moving the 0 downward
      } catch (Exception e) {
      }
      try {
        open.add(head.generateLeft());//Generate a state by moving the 0 left
      } catch (Exception e) {
      }
      try {
        open.add(head.generateRight());//Generate a state by moving the 0 right
      } catch (Exception e) {
      }
      close.add(head);//Add the state to CLOSE
      continue;
    }
    close.get(close.size()-1).printAll();//Print the path from the ORIGINAL state to the GOAL state
    System.out.println();
    System.out.println("Number of states expanded: "+numStateExpand);//Print number of states expanded
    System.out.println("Number of moves: "+close.get(close.size()-1).getG());//Print number of moves:
  }
}
