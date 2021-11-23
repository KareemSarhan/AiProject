package code;

import java.util.*;

public class SearchProblem {
    Queue<Node> Queue= new LinkedList<>();
    Stack<Node> Stack = new Stack<>();
    //Check if node passed is goal state
    public boolean CheckGoal(Node node)
    {
        return false;
    }
    public String GetSubString(String grid, int FirstSimiColon, int LastSimiColon)
    {
        int SemicolonCount = 0;
        int subStringStart = 0;
        int subStringEnd = 0;
        for (int i = 0; i < grid.length(); i++) {
            if (grid.charAt(i) == ';')
            {
                SemicolonCount++;
                if (SemicolonCount == FirstSimiColon) {
                    subStringStart = i+1;
                }
                if (SemicolonCount == LastSimiColon) {
                    subStringEnd = i;
                    break;
                }

            }
        }
        return grid.substring(subStringStart,subStringEnd);
    }
    public String UpdateState(String grid, String position,int subStringStart,int subStringEnd)
    {

        return grid.substring(0,subStringStart)+position+grid.substring(subStringEnd);
    }
    public String RemovePill(String grid, String position,int subStringStart,int subStringEnd)
    {

        return grid.substring(0,subStringStart)+position+grid.substring(subStringEnd);
    }
    public String[] GetNeoPosition(String grid)
    {
        int SemicolonCount = 0;
        int subStringStart = 0;
        int subStringEnd = 0;
        for (int i = 0; i < grid.length(); i++) {
            if (grid.charAt(i) == ';')
            {
                SemicolonCount++;
                if (SemicolonCount == 2) {
                    subStringStart = i+1;
                }
                if (SemicolonCount == 3) {
                    subStringEnd = i;
                    break;
                }

            }
        }
        return grid.substring(subStringStart,subStringEnd).split(",");


    }
    public String[] GetGridSize(String grid)
    {
        int SemicolonCount = 0;
        int subStringEnd = 0;
        for (int i = 0; i < grid.length(); i++) {
            if (grid.charAt(i) == ';')
            {
                SemicolonCount++;
                if (SemicolonCount == 1) {
                    subStringEnd = i;
                    break;
                }

            }
        }

        return grid.substring(0,subStringEnd).split(",");
    }
    private boolean ExistInArr(String[] Key,String[] Arr)
    {
        for (int i = 0; i < Arr.length; i += 2) {
            if(Key[0].equals(Arr[i]) && Key[0].equals(Arr[i+1]))
            {
                return true;
            }
        }
        return false;
    }
    private String[] ExistInPadsArr(String[] Key,String[] Arr)
    {
        for (int i = 0; i < Arr.length; i += 2) {
            if(Key[0].equals(Arr[i]) && Key[0].equals(Arr[i+1]))
            {
                return new String[]{Arr[i+2], Arr[i + 3]};
            }
        }
        return null;
    }
    private String[] ExistAndRemoveInPillsArr(String[] Key,String[] Arr)
    {
        String[] NewPillArr = new String[Arr.length-1];
        for (int i = 0; i < Arr.length; i += 2) {
            if(Key[0].equals(Arr[i]) && Key[0].equals(Arr[i+1]))
            {
                System.arraycopy(Arr, 0, NewPillArr, 0, i);
                System.arraycopy(Arr, i + 1, NewPillArr, i, Arr.length - i - 1);
                return NewPillArr;
            }
        }
        return new String[]{};
    }

    // TODO: 11/11/2021 zwd en el hostages bymoto we byb2o agents we en da t2rebn mab7slsh low metshaleen

    public Node UpdateTimeStep(Node node)
    {
        String[] HostagesArr = GetSubString(node.GridString,7,8).split(",");
        for (int i = 0; i < HostagesArr.length; i+=3) {
            HostagesArr[i] = String.valueOf(Integer.parseInt(HostagesArr[i]) + 2);
        }
        node.GridString = UpdateState(node.GridString, String.valueOf(HostagesArr),7,8);
        return node;
    }

    private Node Fly(Node node) {
        String flyArr = GetSubString(node.GridString,6,7);
        String[] newPos = ExistInPadsArr(GetNeoPosition(node.GridString),flyArr.split(","));
        if (!newPos.equals(null)) {
            node.setGridString(UpdateState(node.GridString,flyArr,6,7));
        }

        return node;
    }

    private Node TakePill(Node node)
    {
        String pillArr = GetSubString(node.GridString,5,6);
        String[] pillPos = ExistAndRemoveInPillsArr(GetNeoPosition(node.GridString),pillArr.split(","));
        // if () {

        // }
        String[] HostagesArr = GetSubString(node.GridString,7,8).split(",");
        for (int i = 0; i < HostagesArr.length; i+=3) {
            HostagesArr[i] = String.valueOf(Integer.parseInt(HostagesArr[i]) + 20);
        }
        node.setDamage(node.getDamage()- 20);
        node.GridString = UpdateState(node.GridString, String.valueOf(HostagesArr),7,8);
        node.setGridString(UpdateState(node.GridString, Arrays.toString(GetNeoPosition(node.GridString)),2,3));

        return node;
    }

    private Node TakeHostage(Node node)
    {
        String HostageArr = GetSubString(node.GridString,7,8);
        String[] HostagePos = ExistInPadsArr(GetNeoPosition(node.GridString),HostageArr.split(","));
        if (!HostagePos.equals(null)) {
            node.setGridString(UpdateState(node.GridString,HostageArr,7,8));
        }
        return node;
    }
     private boolean CanCarry(Node node)
     {
         String[] HostagesArr = GetSubString(node.GridString,7,8).split(",");
         for (int i = 0; i < HostagesArr.length; i+=3) {
             if (Integer.parseInt(HostagesArr[i]) > 0) {
                 return true;
             }
         }
         return false;
     }

   private boolean CanDropHostage(Node node)
   {
       String[] HostagesArr = GetSubString(node.GridString,7,8).split(",");
       for (int i = 0; i < HostagesArr.length; i+=3) {
           if (Integer.parseInt(HostagesArr[i]) > 0) {
               return true;
           }
       }
       return false;
   }
    private boolean CanFly(Node node)
    {
        String[] flyArr = GetSubString(node.GridString,6,7).split(",");
        for (int i = 0; i < flyArr.length; i+=2) {
            if (Integer.parseInt(flyArr[i]) > 0) {
                return true;
            }
        }
        return false;
    }
    private boolean CanTakePill(Node node)
    {
        String[] pillArr = GetSubString(node.GridString,5,6).split(",");
        for (int i = 0; i < pillArr.length; i+=2) {
            if (Integer.parseInt(pillArr[i]) > 0) {
                return true;
            }
        }
        return false;
    }
    private boolean CanTakeHostage(Node node)
    {
        String[] HostagesArr = GetSubString(node.GridString,7,8).split(",");
        for (int i = 0; i < HostagesArr.length; i+=3) {
            if (Integer.parseInt(HostagesArr[i]) > 0) {
                return true;
            }
        }
        return false;
    }


   public Node MoveUp (Node node)
    {
        String[] position = GetNeoPosition(node.GridString);
        position[1] = String.valueOf(Integer.parseInt(position[1]) - 1);
        if (Integer.parseInt(position[1]) > 0) {
            node.setGridString(UpdateState(node.GridString, Arrays.toString(position),2,3));
        }
        return node;
    }
    public Node MoveDown (Node node)
    {
        String[] position = GetNeoPosition(node.GridString);
        position[1] = String.valueOf(Integer.parseInt(position[1]) + 1);
        if (Integer.parseInt(position[1]) < Integer.parseInt(GetGridSize(node.GridString)[1])) {
            node.setGridString(UpdateState(node.GridString, Arrays.toString(position),2,3));
        }
        return node;
    }
    public Node MoveRight (Node node)
    {
        String[] position = GetNeoPosition(node.GridString);
        position[0] = String.valueOf(Integer.parseInt(position[0]) + 1);
        if (Integer.parseInt(position[0]) < Integer.parseInt(GetGridSize(node.GridString)[0])) {
            node.setGridString(UpdateState(node.GridString, Arrays.toString(position),2,3));
        }
        return node;
    }
    public Node MoveLeft (Node node)
    {
        String[] position = GetNeoPosition(node.GridString);
        position[0] = String.valueOf(Integer.parseInt(position[0]) - 1);
        if (Integer.parseInt(position[0]) > 0) {
            node.setGridString(UpdateState(node.GridString, Arrays.toString(position),2,3));
        }
        return node;
    }

    public Node[] TakeAction(Node node)
    {
        String Action = node.TakenActions;
        Node[] nodeArr = new Node[9];
        nodeArr[0] = MoveUp(node);
        nodeArr[1] = MoveDown(node);
        nodeArr[2] = MoveLeft(node);
        nodeArr[3] = MoveRight(node);
        nodeArr[4] = Fly(node);

        // if(Pill(node))
        // {

        // }
        // if(CanCarry(node))
        // {

        // }
        // if(CanDrop(node))
        // {

        // }
        // if(CanKill(node))
        // {

        // }
        return null;

    }
    // breadth first search for the goal state
    public void BreadthFirst(Node node)
    {
        Queue.add(node);
        while (Queue.size()>0) {
            //loop over TakeAction output and add them to Queue
            Node[] nodeArr = TakeAction(Queue.poll());
            for (int i = 0; i < nodeArr.length; i++) {
                if (nodeArr[i] != null) {
                    Queue.add(nodeArr[i]);
                }
            }
        }
    }
    // Depth first search for the goal state.
    //check if the node is the goal state with CheckGoal.
    public void DepthFirst(Node node)
    {
        Stack.add(node);
        while (Stack.size()>0) {
            //loop over TakeAction output and add them to Queue
            Node[] nodeArr = TakeAction(Stack.pop());
            for (int i = 0; i < nodeArr.length; i++) {
                if (nodeArr[i] != null) {
                    if (CheckGoal(nodeArr[i])) {
                        System.out.println("Goal Found");
                        return;
                    }
                    Stack.add(nodeArr[i]);
                }
            }
        }
    }
    //Iterative Deepening search for the goal state
    public void IterativeDeepening(Node node)
    {
        int depth = 0;
        Stack.add(node);
        while (Stack.size()>0) {
            //loop over TakeAction output and add them to Queue
            Node[] nodeArr = TakeAction(Stack.pop());
            for (int i = 0; i < nodeArr.length; i++) {
                if (nodeArr[i] != null) {
                    if (CheckGoal(nodeArr[i])) {
                        System.out.println("Goal Found");
                        return;
                    }
                    Stack.add(nodeArr[i]);
                }
            }
            depth++;
        }
    }
    //UniformCostSearch for the goal state
    public void UniformCostSearch(Node node)
    {
        PriorityQueue<Node> PriorityQueue = new PriorityQueue<>();
        PriorityQueue.add(node);
        while (PriorityQueue.size()>0) {
            //loop over TakeAction output and add them to Queue
            Node[] nodeArr = TakeAction(PriorityQueue.poll());
            for (int i = 0; i < nodeArr.length; i++) {
                if (nodeArr[i] != null) {
                    if (CheckGoal(nodeArr[i])) {
                        System.out.println("Goal Found");
                        return;
                    }
                    PriorityQueue.add(nodeArr[i]);
                }
            }
        }
    }
    //GreedySearch for the goal state
    public void GreedySearch(Node node)
    {

    }
    //A star Search for the goal state
    public void AstarSearch(){}
    public void PrintResults() {

    }

}
