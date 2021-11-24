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
        grid += ';';
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

    public String[] removeFromArray(int index, String[] array){
        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        return array;
    }

    public String UpdateNeoPos(String grid, String position, int subStringStart, int subStringEnd)
    {
        return GetSubString(grid, 0, subStringStart) +";"+position+";"+ GetSubString(grid,subStringEnd, 8);
//        return GetSubString(grid, 0, subStringStart) +";"+position+";"+ GetSubString(grid,subStringEnd, 8);
        //return grid.substring(0,subStringStart)+position+grid.substring(subStringEnd);
    }

    public String UpdateHostageState(String grid, String [] HostageArray)
    {
//        for(int i = 0 ; i <HostageArray.length;i++)
//            System.out.print(HostageArray[i]);
        String HostageNewInfo="";
        for(int i = 0 ; i < HostageArray.length-1;i++) {
            HostageNewInfo += HostageArray[i] + "" + ",";
        }

//        System.out.print(HostageNewInfo);
        HostageNewInfo += HostageArray[HostageArray.length-1] + "";
//        HostageNewInfo.substring(HostageNewInfo, 0, HostageNewInfo.length() - 1);
        return GetSubString(grid, 0, 7) +";"+HostageNewInfo;
    }


    public String GetNeoPosition(String grid)
    {

        String NeoPosition= GetSubString(grid,2,3);
        return NeoPosition;
    }
    public String GetGridSize(String grid)
    {
        String SizeMN=GetSubString(grid,0,1);

        return SizeMN;
    }
    public boolean ExistInArr(String[] Key,String[] Arr)
    {
        for (int i = 0; i < Arr.length; i += 2) {
            if(Key[0].equals(Arr[i]) && Key[0].equals(Arr[i+1]))
            {
                return true;
            }
        }
        return false;
    }
    public String[] ExistInPadsArr(String[] Key,String[] Arr)
    {
        for (int i = 0; i < Arr.length; i += 2) {
            if(Key[0].equals(Arr[i]) && Key[0].equals(Arr[i+1]))
            {
                return new String[]{Arr[i+2], Arr[i + 3]};
            }
        }
        return null;
    }
    public String[] ExistAndRemoveInPillsArr(String[] Key,String[] Arr)
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
    //loop on the hostage array and Carried hostage array and increase them by 2
    public Node UpdateTimeStep(Node node) {
        String HostageString = GetSubString(node.getGridString(), 7, 8);
        String NewHostageString = "";
        if (!HostageString.isEmpty()) {
            String[] HostageArr = HostageString.split(",");
            for (int i = 0; i < HostageArr.length; i += 3) {
                int damage = Integer.parseInt(HostageArr[i + 2]);
                damage += 2;
                if (damage >= 100) {
                    HostageArr[i + 2] = 100 + "";
                } else {
                    HostageArr[i + 2] = Integer.toString(damage);
                }
            }
            NewHostageString = String.join(",", HostageArr);
        }
        String CarriedHostageString = GetSubString(node.getGridString(), 8, 9);
        String NewCarriedHostageString = "";
        if (!CarriedHostageString.isEmpty()) {
            String[] CarriedHostageArr = CarriedHostageString.split(",");
            for (int i = 0; i < CarriedHostageArr.length; i +=1 ) {
                int damage = Integer.parseInt(CarriedHostageArr[i]);
                damage += 2;
                if (damage >= 100) {
                    CarriedHostageArr[i] =100+"";
                }
                else {
                    CarriedHostageArr[i] = Integer.toString(damage);
                }
            }
            NewCarriedHostageString = String.join(",", CarriedHostageArr);

        }

        String NewGridString = GetSubString(node.getGridString(),0,7) +";"+  NewHostageString +";"+  NewCarriedHostageString;
        Node newNode =new Node(NewGridString, node.Damage);
        return newNode;
    }

    public Node Fly(Node node) {
        String flyArr = GetSubString(node.GridString,6,7);
        String[] newPos = ExistInPadsArr(GetNeoPosition(node.GridString).split(","),flyArr.split(","));
        if (!newPos.equals(null)) {
            node.setGridString(UpdateNeoPos(node.GridString,flyArr,6,7));
        }
        return node;
    }

    //New Damage hyzeed 20
    // All agents in the neighbouring cells should die
    public Node Kill(Node node) {
        int KilledAgentsNum=0;
        String AgentStringPos = GetSubString(node.GridString,4,5);
        int NewDamage = node.getDamage()+20;
        System.out.println(NewDamage);
        String[] AgentsArr = GetSubString(node.GridString,4,5).split(",");
        for(int i = 0 ; i < AgentsArr.length;i++)
        {

        }

        node.setDamage(NewDamage);


        return node;
    }

    public Node TakePill(Node node)
    {
        String pillArr = GetSubString(node.GridString,5,6);
        String[] pillPos = ExistAndRemoveInPillsArr(GetNeoPosition(node.GridString).split(","),pillArr.split(","));
        String[] HostagesArr = GetSubString(node.GridString,7,8).split(",");
        for (int i = 2; i < HostagesArr.length; i+=3) {
            HostagesArr[i] = String.valueOf(Integer.parseInt(HostagesArr[i]) - 20);
        }

        int NewDamage = node.getDamage()-20;
        System.out.println(NewDamage);
        node.setDamage(NewDamage);
//
        node.GridString = UpdateHostageState(node.GridString, HostagesArr);
//
        return node;
    }


    public Node CarryHostage(Node node)
    {
        //String HostageString = GetSubString(node.GridString,7,8);
        String[] HostagesArr = GetSubString(node.GridString,7,8).split(",");
        for(int i=0; i<HostagesArr.length;i+=3){
            System.out.println(GetNeoPosition(node.GridString).substring(0,1));
            System.out.println(GetNeoPosition(node.GridString).substring(2,3));
            if(HostagesArr[i].equals(GetNeoPosition(node.GridString).substring(0,1)) && HostagesArr[i+1].equals(GetNeoPosition(node.GridString).substring(2,3))){
                int count = Integer.parseInt(GetSubString(node.GridString,1,2));
                count -= 1;
                String damage = HostagesArr[i+2];
                System.out.println(Arrays.toString(HostagesArr));
                removeFromArray(i,HostagesArr);
                removeFromArray(i+1,HostagesArr);
                removeFromArray(i+2,HostagesArr);
                String[] newHostagesArr = new String[0];
                for(int j=0;j<HostagesArr.length-2;j++){
                    newHostagesArr[j] = HostagesArr[j];

                }
                System.out.println(Arrays.toString(newHostagesArr));
                node.GridString = GetSubString(node.GridString,0,1) + ';'+count+';' + GetSubString(node.GridString,2,7)+Arrays.toString(HostagesArr)+';'+damage;
                HostagesArr[i+2] = null;
                System.out.println(node.GridString);
            }
        }

//        String[] HostagePos = ExistInPadsArr(GetNeoPosition(node.GridString).split(","),HostageString.split(","));
//        if (!HostagePos.equals(null)) {
//            node.setGridString(UpdateNeoPos(node.GridString,HostageString,7,8));
//        }
        return node;
    }
     public boolean CanCarryHostage(Node node)
     {
         String[] HostagesArr = GetSubString(node.GridString,7,8).split(",");
         for (int i = 0; i < HostagesArr.length; i+=3) {
             if (Integer.parseInt(HostagesArr[i]) == Integer.parseInt(GetNeoPosition(node.GridString).substring(0,1)) && Integer.parseInt(HostagesArr[i+1]) == Integer.parseInt(GetNeoPosition(node.GridString).substring(2,3))) {
                 return true;
             }
         }
         return false;
     }

   public boolean CanDropHostage(Node node)
   {
       String[] CarriedHostagesArr = GetSubString(node.GridString,8,9).split(",");
       int count = Integer.parseInt(GetSubString(node.GridString,1,2));
       if (CarriedHostagesArr.length >0 && Integer.parseInt(GetNeoPosition(node.GridString).substring(0, 1)) == Integer.parseInt(GetSubString(node.GridString, 3,4).substring(0,1)) && Integer.parseInt(GetNeoPosition(node.GridString).substring(2, 3)) == Integer.parseInt(GetSubString(node.GridString, 3,4).substring(2,3)) ) {
           count += CarriedHostagesArr.length/3;
           node.GridString = GetSubString(node.GridString,0,1) + ';'+count+';' + GetSubString(node.GridString,2,8);
           return true;
               }
       return false;
   }
    public boolean CanFly(Node node)
    {
        String[] flyArr = GetSubString(node.GridString,6,7).split(",");
        for (int i = 0; i < flyArr.length; i+=2) {
            if (Integer.parseInt(flyArr[i]) == Integer.parseInt(GetNeoPosition(node.GridString).substring(0,1)) && Integer.parseInt(flyArr[i+1]) == Integer.parseInt(GetNeoPosition(node.GridString).substring(2,3))) {
                return true;
            }
        }
        return false;
    }
    public boolean CanTakePill(Node node)
    {
        String[] pillArr = GetSubString(node.GridString,5,6).split(",");
        for (int i = 0; i < pillArr.length; i+=2) {
            if (Integer.parseInt(pillArr[i]) == Integer.parseInt(GetNeoPosition(node.GridString).substring(0,1))  && Integer.parseInt(pillArr[i+1]) == Integer.parseInt(GetNeoPosition(node.GridString).substring(2,3)) ) {
                return true;
            }
        }
        return false;
    }
    
   public Node MoveUp (Node node)
    {
        String[] position = GetNeoPosition(node.GridString).split(",");
        position[0] = String.valueOf(Integer.parseInt(position[0]) - 1);
        if (Integer.parseInt(position[0]) >= 0) {
            node.setGridString(UpdateNeoPos(node.GridString, position[0]+','+position[1],2,3));
        }
        return node;
    }
    public Node MoveDown (Node node)
    {
        String[] position = GetNeoPosition(node.GridString).split(",");
        position[0] = String.valueOf(Integer.parseInt(position[0]) + 1);
        if (Integer.parseInt(position[0]) < Integer.parseInt(GetGridSize(node.GridString).split(",")[0])) {
            node.setGridString(UpdateNeoPos(node.GridString, position[0]+','+position[1],2,3));
        }
        return node;
    }
    public Node MoveRight (Node node)
    {
        String[] position = GetNeoPosition(node.GridString).split(",");
        position[1] = String.valueOf(Integer.parseInt(position[1]) + 1);
        if (Integer.parseInt(position[1]) < Integer.parseInt(GetGridSize(node.GridString).split(",")[1])) {
            node.setGridString(UpdateNeoPos(node.GridString, position[0]+','+position[1],2,3));
        }
        return node;
    }
    public Node MoveLeft (Node node)
    {
        String[] position = GetNeoPosition(node.GridString).split(",");
        position[1] = String.valueOf(Integer.parseInt(position[1]) - 1);
        if (Integer.parseInt(position[1]) > 0) {
            node.setGridString(UpdateNeoPos(node.GridString, position[0]+','+position[1],2,3));
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

    public boolean CanKill(Node node) {
        String[] agents = GetSubString(node.GridString,4,5).split(",");
        for (int i = 0; i < agents.length; i+=2) {
            if (Integer.parseInt(agents[i]) == Integer.parseInt(GetNeoPosition(node.GridString).substring(0,1))  && Integer.parseInt(agents[i+1]) == Integer.parseInt(GetNeoPosition(node.GridString).substring(2,3)) ) {
                return true;
            }
        }
        return false;
    }
}
