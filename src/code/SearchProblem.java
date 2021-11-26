package code;

import java.util.*;
import java.util.List;

public class SearchProblem {
    Queue<Node> Queue = new LinkedList<>();
    Stack<Node> Stack = new Stack<>();

    //Check if node passed is in a goal state.
    public boolean CheckGoal(Node node) {
        boolean IsNoRemainHostages = GetSubString(node.GridString, 7, 8).isEmpty();
        boolean IsNoRemainCarriedHostages = GetSubString(node.GridString, 8, 9).isEmpty();
        boolean IsAtTeleBooth = GetSubString(node.GridString, 2, 3).equals(GetSubString(node.GridString, 3, 4));
        if (IsNoRemainHostages && IsNoRemainCarriedHostages && IsAtTeleBooth)
            return true;
        return false;
    }

    //Check if node passed is in an end state.
    public boolean CheckGameOver(Node node) {
        boolean IsNeoDead = node.Damage >= 100;
        if (IsNeoDead)
            return true;
        return false;
    }

    public String GetSubString(String grid, int FirstSimiColon, int LastSimiColon) {
        grid += ';';
        int SemicolonCount = 0;
        int subStringStart = 0;
        int subStringEnd = 0;
        for (int i = 0; i < grid.length(); i++) {
            if (grid.charAt(i) == ';') {
                SemicolonCount++;
                if (SemicolonCount == FirstSimiColon) {
                    subStringStart = i + 1;
                }
                if (SemicolonCount == LastSimiColon) {
                    subStringEnd = i;
                    break;
                }

            }
        }

        String Output = grid.substring(subStringStart, subStringEnd);
        return Output;
    }

    public String[] removeFromArray(String elementToBeDeleted, String[] arr) {
        String[] newArr = null;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == elementToBeDeleted) {
                newArr = new String[arr.length - 1];
                for (int index = 0; index < i; index++) {
                    newArr[index] = arr[index];
                }
                for (int j = i; j < arr.length - 1; j++) {
                    newArr[j] = arr[j + 1];
                }
                break;
            }
        }
        return newArr;
    }

    public String[] RemoveElement(String[] array, int index) {
        String[] NewArray = new String[array.length - 1];
        int newArrayIdx = 0;
        if (index >= array.length)
            return array;
        for (int i = 0; i < array.length; i++) {
            if (i == index)
                i++;
            if (i != index) {
                NewArray[newArrayIdx] = array[i];
                newArrayIdx++;
            }
        }
        return NewArray;
    }

    public String UpdateNeoPos(String grid, String position, int subStringStart, int subStringEnd) {
        return GetSubString(grid, 0, subStringStart) + ";" + position + ";" + GetSubString(grid, subStringEnd, 9);
    }

    public String UpdateHostageState(String grid, String[] HostageArray) {
        String HostageNewInfo = "";
        for (int i = 0; i < HostageArray.length - 1; i++) {
            HostageNewInfo += HostageArray[i] + "" + ",";
        }
        HostageNewInfo += HostageArray[HostageArray.length - 1] + "";
        return GetSubString(grid, 0, 7) + ";" + HostageNewInfo + ";" + GetSubString(grid, 8, 9);
    }


    public String GetNeoPosition(String grid) {

        String NeoPosition = GetSubString(grid, 2, 3);
        return NeoPosition;
    }

    public String GetGridSize(String grid) {
        String SizeMN = GetSubString(grid, 0, 1);

        return SizeMN;
    }

    public boolean ExistInArr(String[] Key, String[] Arr) {
        for (int i = 0; i < Arr.length; i += 2) {
            if (Key[0].equals(Arr[i]) && Key[0].equals(Arr[i + 1])) {
                return true;
            }
        }
        return false;
    }

    public String[] ExistInPadsArr(String[] Key, String[] Arr) {
        for (int i = 0; i < Arr.length; i += 2) {
            if ((Key[0].equals(Arr[i]) && Key[1].equals(Arr[i + 1]))) {
                if (Key[0].equals(Arr[i + 2]) && Key[1].equals(Arr[i + 3])) {
                    return new String[]{Arr[i + 4], Arr[i + 5]};
                }
                return new String[]{Arr[i + 2], Arr[i + 3]};
            }
        }
        return null;
    }

    public String[] ExistAndRemoveInPillsArr(String[] Key, String[] Arr) {
        String[] NewPillArr = new String[Arr.length - 1];
        for (int i = 0; i < Arr.length; i += 2) {
            if (Key[0].equals(Arr[i]) && Key[0].equals(Arr[i + 1])) {
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
            for (int i = 0; i < CarriedHostageArr.length; i += 1) {
                int damage = Integer.parseInt(CarriedHostageArr[i]);
                damage += 2;
                if (damage >= 100) {
                    CarriedHostageArr[i] = 100 + "";
                } else {
                    CarriedHostageArr[i] = Integer.toString(damage);
                }
            }
            NewCarriedHostageString = String.join(",", CarriedHostageArr);

        }

        String NewGridString = GetSubString(node.getGridString(), 0, 7) + ";" + NewHostageString + ";" + NewCarriedHostageString;
        Node newNode = new Node(NewGridString, node.Damage, node.TakenActions);

        return newNode;
    }

    public Node Fly(Node node) {
        String NewNeoPos = "";
        String flyArr = GetSubString(node.GridString, 6, 7);
        String[] newPos = ExistInPadsArr(GetNeoPosition(node.GridString).split(","), flyArr.split(","));
        NewNeoPos = newPos[0] + "," + newPos[1];
        node.setGridString(UpdateNeoPos(node.GridString, NewNeoPos, 2, 3));
        node.ConcatAction(Actions.FLY);
        return node;
    }

    //New Damage hyzeed 20
    //All agents in the neighbouring cells should die
    public Node Kill(Node node) {
        int NewDamage = node.getDamage() + 20;
        if (NewDamage > 100) {
            NewDamage = 100;
        }
        int NeoX = Integer.parseInt(GetNeoPosition(node.GridString).split(",")[0]);
        int NeoY = Integer.parseInt(GetNeoPosition(node.GridString).split(",")[1]);
        Vector<String> AgentsArr = new Vector<>();
        String AgentsString = GetSubString(node.GridString, 4, 5);
        if (!AgentsString.isEmpty()) {
            Collections.addAll(AgentsArr, AgentsString.split(","));
        }
        Vector<String> HostageArr = new Vector<>();
        String HostageString = GetSubString(node.GridString, 7, 8);
        if (!HostageString.isEmpty()) {
            Collections.addAll(HostageArr, HostageString.split(","));
        }
        for (int i = 0; i < AgentsArr.size(); i += 2) {
            if ((Integer.parseInt(AgentsArr.get(i)) == NeoX - 1 && Integer.parseInt(AgentsArr.get(i + 1)) == NeoY)) {
                AgentsArr.remove(i);
                AgentsArr.remove(i);
                i -= 2;
            } else if ((Integer.parseInt(AgentsArr.get(i)) == NeoX + 1 && Integer.parseInt(AgentsArr.get(i + 1)) == NeoY)) {
                AgentsArr.remove(i);
                AgentsArr.remove(i);
                i -= 2;
            } else if ((Integer.parseInt(AgentsArr.get(i)) == NeoX && Integer.parseInt(AgentsArr.get(i + 1)) == NeoY + 1)) {
                AgentsArr.remove(i);
                AgentsArr.remove(i);
                i -= 2;
            } else if ((Integer.parseInt(AgentsArr.get(i)) == NeoX && Integer.parseInt(AgentsArr.get(i + 1)) == NeoY - 1)) {
                AgentsArr.remove(i);
                AgentsArr.remove(i);
                i -= 2;
            }

        }
        for (int i = 0; i < HostageArr.size(); i += 3) {
            if ((Integer.parseInt(HostageArr.get(i + 2)) == 100)) {
                if ((Integer.parseInt(HostageArr.get(i)) == NeoX - 1 && Integer.parseInt(HostageArr.get(i + 1)) == NeoY)) {
                    HostageArr.remove(i);
                    HostageArr.remove(i);
                    HostageArr.remove(i);
                    i -= 3;
                } else if ((Integer.parseInt(HostageArr.get(i)) == NeoX + 1 && Integer.parseInt(HostageArr.get(i + 1)) == NeoY)) {
                    HostageArr.remove(i);
                    HostageArr.remove(i);
                    HostageArr.remove(i);
                    i -= 3;
                } else if ((Integer.parseInt(HostageArr.get(i)) == NeoX && Integer.parseInt(HostageArr.get(i + 1)) == NeoY + 1)) {
                    HostageArr.remove(i);
                    HostageArr.remove(i);
                    HostageArr.remove(i);
                    i -= 3;
                } else if ((Integer.parseInt(HostageArr.get(i)) == NeoX && Integer.parseInt(HostageArr.get(i + 1)) == NeoY - 1)) {
                    HostageArr.remove(i);
                    HostageArr.remove(i);
                    HostageArr.remove(i);
                    i -= 3;
                }
            }
        }
        String NewAgentsString = String.join(",", AgentsArr);
        String NewHostageString = String.join(",", HostageArr);
        String NewGrid = String.join(",", GetSubString(node.GridString, 0, 4)) + ";" + NewAgentsString + ";" + String.join(",", GetSubString(node.GridString, 5, 7) + ";" + NewHostageString + ";" + GetSubString(node.GridString, 8, 9));
        node.ConcatAction(Actions.KILL);
        return new Node(NewGrid, NewDamage, node.TakenActions);
    }

    public Node TakePill(Node node) {
        String pillArr = GetSubString(node.GridString, 5, 6);
        String[] pillPos = ExistAndRemoveInPillsArr(GetNeoPosition(node.GridString).split(","), pillArr.split(","));
        String[] HostagesArr = GetSubString(node.GridString, 7, 8).split(",");
        for (int i = 2; i < HostagesArr.length; i += 3) {
            int HostageDamage = Integer.parseInt(HostagesArr[i]) - 20;
            if (HostageDamage < 0) {
                HostageDamage = 0;
            }
            HostagesArr[i] = String.valueOf(HostageDamage);
        }
        int NewDamage = node.getDamage() - 20;
        if (NewDamage < 0) {
            NewDamage = 0;
        }
        node.setDamage(NewDamage);
        node.GridString = UpdateHostageState(node.GridString, HostagesArr);
        node.ConcatAction(Actions.PILL);
        return node;
    }


    public Node CarryHostage(Node node) {
        String[] HostagesArr = GetSubString(node.GridString, 7, 8).split(",");
        for (int i = 0; i < HostagesArr.length; i += 3) {
            List<String> Hostages = new ArrayList<>(Arrays.asList(HostagesArr));
            if (HostagesArr[i].equals(GetNeoPosition(node.GridString).substring(0, 1)) && HostagesArr[i + 1].equals(GetNeoPosition(node.GridString).substring(2, 3))) {
                int count = Integer.parseInt(GetSubString(node.GridString, 1, 2));
                count -= 1;
                String damage = HostagesArr[i + 2];
                Hostages.remove(i);
                Hostages.remove(i);
                Hostages.remove(i);
                String h = Hostages.toString();
                String newHostages = h.substring(1, h.length() - 1).replaceAll("\\s+", "");
                node.GridString = GetSubString(node.GridString, 0, 1) + ';' + count + ';' + GetSubString(node.GridString, 2, 7) + ";" + newHostages + ';' + damage + ";";
            }
        }
        node.ConcatAction(Actions.CARRY);
        return node;
    }

    public boolean CanCarryHostage(Node node) {
        String HostagesString = GetSubString(node.GridString,7,8);
        if(HostagesString.isEmpty())
            return false;
        String[] HostagesArr = HostagesString.split(",");
        for (int i = 0; i < HostagesArr.length; i += 3) {
            if (Integer.parseInt(HostagesArr[i]) == Integer.parseInt(GetNeoPosition(node.GridString).substring(0, 1)) && Integer.parseInt(HostagesArr[i + 1]) == Integer.parseInt(GetNeoPosition(node.GridString).substring(2, 3))) {
                return true;
            }
        }
        return false;
    }
    public boolean CanTakePill(Node node)
    {
        String pillsString = GetSubString(node.GridString,5,6);
        if(pillsString.isEmpty())
            return false;
        String[] pillArr = pillsString.split(",");
        for (int i = 0; i < pillArr.length; i+=2) {
            if (Integer.parseInt(pillArr[i]) == Integer.parseInt(GetNeoPosition(node.GridString).substring(0,1))  && Integer.parseInt(pillArr[i+1]) == Integer.parseInt(GetNeoPosition(node.GridString).substring(2,3)) ) {
                return true;
            }
        }
        return false;
    }
    public boolean CanDropHostage(Node node) {
        String CarriedHostagesString = GetSubString(node.GridString,8,9);
        if(CarriedHostagesString.isEmpty())
            return false;
        String[] CarriedHostagesArr = CarriedHostagesString.split(",");
        String hostages = Arrays.toString(CarriedHostagesArr);
        String h = hostages.substring(1, hostages.length() - 1).replaceAll("\\s+", "");
        if (h.length() > 0 && !CarriedHostagesArr[0].equals(" ") && Integer.parseInt(GetNeoPosition(node.GridString).substring(0, 1)) == Integer.parseInt(GetSubString(node.GridString, 3, 4).substring(0, 1)) && Integer.parseInt(GetNeoPosition(node.GridString).substring(2, 3)) == Integer.parseInt(GetSubString(node.GridString, 3, 4).substring(2, 3))) {
            return true;
        }
        return false;
    }

    public boolean CanFly(Node node) {
        String FlyString = GetSubString(node.GridString,6,7);
        if(FlyString.isEmpty())
            return false;
        String[] flyArr = FlyString.split(",");
        for (int i = 0; i < flyArr.length; i += 2) {
            if (Integer.parseInt(flyArr[i]) == Integer.parseInt(GetNeoPosition(node.GridString).substring(0, 1)) && Integer.parseInt(flyArr[i + 1]) == Integer.parseInt(GetNeoPosition(node.GridString).substring(2, 3))) {
                return true;
            }
        }
        return false;
    }
    

    public Boolean CanMoveUp(Node node) {
        String[] position = GetNeoPosition(node.GridString).split(",");
        String newPositionUp = String.valueOf(Integer.parseInt(position[0]) - 1);
        String[] AgentsArr = GetSubString(node.GridString, 4, 5).split(",");
        String[] HostagesArr = GetSubString(node.GridString, 7, 8).split(",");
        if (Integer.parseInt(newPositionUp) < 0)
            return false;
        for (int i = 0; i < AgentsArr.length; i += 2) {
            if (AgentsArr[i].equals(newPositionUp) && AgentsArr[i + 1].equals(position[1])) {
                return false;
            }
        }
        for (int j = 2; j < HostagesArr.length; j += 3) {
            if (HostagesArr[j].equals("100") && HostagesArr[j - 1].equals(position[1]) && HostagesArr[j - 2].equals(newPositionUp)) {
                return false;
            }
        }
        return true;
    }

    public Boolean CanMoveDown(Node node) {
        String[] position = GetNeoPosition(node.GridString).split(",");
        String newPositionDown = String.valueOf(Integer.parseInt(position[0]) + 1);
        String[] AgentsArr = GetSubString(node.GridString, 4, 5).split(",");
        String[] HostagesArr = GetSubString(node.GridString, 7, 8).split(",");
        if (Integer.parseInt(newPositionDown) >= Integer.parseInt(GetSubString(node.GridString, 0, 1).split(",")[0]))
            return false;
        for (int i = 0; i < AgentsArr.length; i += 2) {
            if (AgentsArr[i].equals(newPositionDown) && AgentsArr[i + 1].equals(position[1])) {
                return false;
            }
        }
        for (int j = 2; j < HostagesArr.length; j += 3) {
            if (HostagesArr[j].equals("100") && HostagesArr[j - 1].equals(position[1]) && HostagesArr[j - 2].equals(newPositionDown)) {
                return false;
            }
        }
        return true;
    }

    public Boolean CanMoveRight(Node node) {
        String[] position = GetNeoPosition(node.GridString).split(",");
        String newPositionRight = String.valueOf(Integer.parseInt(position[1]) + 1);
        String[] AgentsArr = GetSubString(node.GridString, 4, 5).split(",");
        String[] HostagesArr = GetSubString(node.GridString, 7, 8).split(",");
        if (Integer.parseInt(newPositionRight) >= Integer.parseInt(GetSubString(node.GridString, 0, 1).split(",")[1])) {
            return false;
        }
        for (int i = 1; i < AgentsArr.length; i += 2) {
            if (AgentsArr[i].equals(newPositionRight) && AgentsArr[i - 1].equals(position[0])) {
                return false;
            }
        }
        for (int j = 2; j < HostagesArr.length; j += 3) {
            if (HostagesArr[j].equals("100") && HostagesArr[j - 1].equals(newPositionRight) && HostagesArr[j - 2].equals(position[0])) {
                return false;
            }
        }
        return true;
    }

    public Boolean CanMoveLeft(Node node) {
        String[] position = GetNeoPosition(node.GridString).split(",");
        String newPositionLeft = String.valueOf(Integer.parseInt(position[1]) - 1);
        String[] AgentsArr = GetSubString(node.GridString, 4, 5).split(",");
        String[] HostagesArr = GetSubString(node.GridString, 7, 8).split(",");
        if (Integer.parseInt(newPositionLeft) < 0)
            return false;
        for (int i = 1; i < AgentsArr.length; i += 2) {
            if (AgentsArr[i].equals(newPositionLeft) && AgentsArr[i - 1].equals(position[0])) {
                return false;
            }
        }
        for (int j = 2; j < HostagesArr.length; j += 3) {
            if (HostagesArr[j].equals("100") && HostagesArr[j - 1].equals(newPositionLeft) && HostagesArr[j - 2].equals(position[0])) {
                return false;
            }
        }
        return true;
    }

    public Node MoveUp(Node node) {
        String[] position = GetNeoPosition(node.GridString).split(",");
        position[0] = String.valueOf(Integer.parseInt(position[0]) - 1);
        if (Integer.parseInt(position[0]) >= 0) {
            node.setGridString(UpdateNeoPos(node.GridString, position[0] + ',' + position[1], 2, 3));
        }
        node.ConcatAction(Actions.UP);
        return node;
    }

    public Node MoveDown(Node node) {
        String[] position = GetNeoPosition(node.GridString).split(",");
        position[0] = String.valueOf(Integer.parseInt(position[0]) + 1);
        if (Integer.parseInt(position[0]) < Integer.parseInt(GetGridSize(node.GridString).split(",")[0])) {
            node.setGridString(UpdateNeoPos(node.GridString, position[0] + ',' + position[1], 2, 3));
        }
        node.ConcatAction(Actions.DOWN);
        return node;
    }

    public Node MoveRight(Node node) {
        String[] position = GetNeoPosition(node.GridString).split(",");
        position[1] = String.valueOf(Integer.parseInt(position[1]) + 1);
        if (Integer.parseInt(position[1]) < Integer.parseInt(GetGridSize(node.GridString).split(",")[1])) {
            node.setGridString(UpdateNeoPos(node.GridString, position[0] + ',' + position[1], 2, 3));
        }
        node.ConcatAction(Actions.RIGHT);
        return node;
    }

    public Node MoveLeft(Node node) {
        String[] position = GetNeoPosition(node.GridString).split(",");
        position[1] = String.valueOf(Integer.parseInt(position[1]) - 1);
        if (Integer.parseInt(position[1]) >= 0) {
            node.setGridString(UpdateNeoPos(node.GridString, position[0] + ',' + position[1], 2, 3));
        }
        node.ConcatAction(Actions.LEFT);
        return node;
    }

    public Vector<Node> TakeAction(Node node) {
        Vector<Node> nodeArr = new Vector<Node>();
        if (CanMoveUp(node)) {
            nodeArr.add(UpdateTimeStep(MoveUp(node.clone())));
        }
        if (CanMoveDown(node)) {
            nodeArr.add(UpdateTimeStep(MoveDown(node.clone())));
        }
        if (CanMoveRight(node)) {
            nodeArr.add(UpdateTimeStep(MoveRight(node.clone())));
        }
        if (CanMoveLeft(node)) {
            nodeArr.add(UpdateTimeStep(MoveLeft(node.clone())));
        }
        if (CanKill(node)) {
            nodeArr.add(UpdateTimeStep(Kill(node.clone())));
        }
        if (CanCarryHostage(node)) {
            nodeArr.add(UpdateTimeStep(CarryHostage(node.clone())));
        }
        if (CanDropHostage(node)) {
            nodeArr.add(UpdateTimeStep(DropHostage(node.clone())));
        }
        if (CanFly(node)) {
            nodeArr.add(UpdateTimeStep(Fly(node.clone())));
        }
        if (CanTakePill(node)) {
            nodeArr.add(TakePill(node.clone()));
        }
        return nodeArr;
    }

    //removes all the carried hostages from the node which is saved at the last part of the grid string and resets CarryLimit
    public Node DropHostage(Node node) {
        int CarriedHostagesCount = GetSubString(node.GridString, 8, 9).split(",").length;
        int CarryLimit = Integer.parseInt(GetSubString(node.GridString, 1, 2)) + CarriedHostagesCount;
        node.ConcatAction(Actions.DROP);
        node.setGridString(String.join(",", GetSubString(node.GridString, 0, 1)) + ";" + CarryLimit + ";" + String.join(",", GetSubString(node.GridString, 2, 8) + ";"));
        return node;
    }

    // breadth first search for the goal state
    public Node BreadthFirst(Node node) {
        Queue.add(node);
        while (Queue.size() > 0) {
            //loop over TakeAction output and add them to Queue
            Node ActionNode = Queue.poll();
            if (CheckGameOver(ActionNode)) {
                continue;
            }
            if (CheckGoal(ActionNode)) {
                System.out.println("Goal Found");
                return ActionNode;
            }
            Vector<Node> nodeArr = TakeAction(ActionNode);
            for (int i = 0; i < nodeArr.size(); i++) {
                if (nodeArr.get(i) != null) {
                    Queue.add(nodeArr.get(i));
                }
            }
        }
        return null;
    }

    //Depth first search for the goal state.
    //check if the node is the goal state with CheckGoal.
    public void DepthFirst(Node node) {
        Stack.add(node);
        while (Stack.size() > 0) {
            //loop over TakeAction output and add them to Queue
            Node[] nodeArr = TakeAction(Stack.pop()).toArray(new Node[0]);
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
    public void IterativeDeepening(Node node) {
        int depth = 0;
        Stack.add(node);
        while (Stack.size() > 0) {
            //loop over TakeAction output and add them to Queue
            Node[] nodeArr = TakeAction(Stack.pop()).toArray(new Node[0]);
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
    public void UniformCostSearch(Node node) {
        PriorityQueue<Node> PriorityQueue = new PriorityQueue<>();
        PriorityQueue.add(node);
        while (PriorityQueue.size() > 0) {
            //loop over TakeAction output and add them to Queue
            Node[] nodeArr = TakeAction(PriorityQueue.poll()).toArray(new Node[0]);
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
    public void GreedySearch(Node node) {

    }

    //A star Search for the goal state
    public void AstarSearch() {
    }

    public void PrintResults() {

    }

    public boolean CanKill(Node node) {
        String agentsString = GetSubString(node.GridString, 4, 5);
        String[] agents = new String[]{};
        if (!agentsString.isEmpty()) {
            agents = agentsString.split(",");
        }

        String HostagesString = GetSubString(node.GridString, 7, 8);
        String[] Hostages = new String[]{};
        if (!HostagesString.isEmpty()) {
            Hostages = HostagesString.split(",");
        }
        int NeoX = Integer.parseInt(GetNeoPosition(node.GridString).substring(0, 1));
        int NeoY = Integer.parseInt(GetNeoPosition(node.GridString).substring(2, 3));
        for (int i = 0; i < agents.length; i += 2) {
            int AgentX = Integer.parseInt(agents[i]);
            int AgentY = Integer.parseInt(agents[i + 1]);

            if (AgentX + 1 == NeoX && AgentY == NeoY) {
                return true;
            }
            if (AgentX - 1 == NeoX && AgentY == NeoY) {
                return true;
            }
            if (AgentX == NeoX && AgentY + 1 == NeoY) {
                return true;
            }
            if (AgentX == NeoX && AgentY - 1 == NeoY) {
                return true;
            }
        }
        for (int i = 0; i < Hostages.length; i += 3) {
            int HostageX = Integer.parseInt(Hostages[i]);
            int HostagesY = Integer.parseInt(Hostages[i + 1]);
            int HostageDamage = Integer.parseInt(Hostages[i + 2]);
            if (HostageDamage == 100) {
                if (HostageX + 1 == NeoX && HostagesY == NeoY ) {
                    return true;
                }
                if (HostageX - 1 == NeoX && HostagesY == NeoY ) {
                    return true;
                }
                if (HostageX == NeoX && HostagesY + 1 == NeoY ) {
                    return true;
                }
                if (HostageX == NeoX && HostagesY - 1 == NeoY ) {
                    return true;
                }
            }
        }
        return false;
    }
}
