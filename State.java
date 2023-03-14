package AI_project2_DatNguyen;


public class State{
  private int[] state;
  private State prvState;
  private int g;
  private int h;
  public static final int[] goal = {1,2,3,8,0,4,7,6,5};
  
  public int getG() {
    return g;
  }

  public int getH() {
    return h;
  }

  public int calHeuristic() {//Method to calculate the heuristic of a state
    int heuristic=0;
    for(int i=0;i<9;i++){
      if(state[i]!=goal[i]){
        heuristic++;
      }
    }
    return heuristic;
  }

  public State(int[] state) {
    this.state = state;
    h=this.calHeuristic();
  }

  public State(int[] state, State prvState) {
    this.state = state;
    this.prvState = prvState;
    h=this.calHeuristic();
    this.g=prvState.g+1;
  }


  public boolean equals(State other){//Method to compare two state
    for(int i=0;i<this.state.length;i++){
      if(this.state[i]!=other.state[i]){
        return false;
      }
    }
    return true;
  }
  
  public void print(){//Print the state
    for(int i=0;i<state.length;i++){
      if(i%3==0){
        System.out.print("\n"+state[i]);
      }else{
        System.out.print(" "+state[i]);
      }
    }
  }

  public void printAll(){//Print the path
    if(prvState==null){
      System.out.print("Original State:");
      this.print();
      return;
    }
    this.prvState.printAll();
    System.out.println("\n");
    System.out.print("Move "+this.g);
    this.print();
  }

  public State generateUp(){//Generate a state by moving the 0 upward
    int num0 =-1;
    int[] nextState = new int[9];
    for(int i=0;i<this.state.length;i++){
      nextState[i]=this.state[i];
      if(this.state[i]==0){
        num0=i;
      };
    }
    int temp=nextState[num0];
    nextState[num0]=nextState[num0-3];
    nextState[num0-3]=temp;
    return new State(nextState,this);
  }

  public State generateDown(){//Generate a state by moving the 0 downward
    int num0 =-1;
    int[] nextState = new int[9];
    for(int i=0;i<this.state.length;i++){
      nextState[i]=this.state[i];
      if(this.state[i]==0){
        num0=i;
      };
    }
    int temp=nextState[num0];
    nextState[num0]=nextState[num0+3];
    nextState[num0+3]=temp;
    return new State(nextState,this);
  }

  public State generateLeft(){//Generate a state by moving the 0 left
    int num0 =-1;
    int[] nextState = new int[9];
    for(int i=0;i<this.state.length;i++){
      nextState[i]=this.state[i];
      if(this.state[i]==0){
        num0=i;
      };
    }
    int temp=nextState[num0];
    nextState[num0]=nextState[num0-1];
    nextState[num0-1]=temp;
    return new State(nextState,this);
  }

  public State generateRight(){//Generate a state by moving the 0 right
    int num0 =-1;
    int[] nextState = new int[9];
    for(int i=0;i<this.state.length;i++){
      nextState[i]=this.state[i];
      if(this.state[i]==0){
        num0=i;
      };
    }
    int temp=nextState[num0];
    nextState[num0]=nextState[num0+1];
    nextState[num0+1]=temp;
    return new State(nextState,this);
  }
}
