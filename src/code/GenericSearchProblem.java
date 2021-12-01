package code;

import java.util.*;

public abstract class GenericSearchProblem {
    //Set of all actions
    static Actions[] actions = Actions.values();

    //initial State at the beginning
    static Node initialState;
    static boolean UseHeuristic = false;

    static HashSet<String> VisitedHashSet;
    public static Node InitialState(String grid) {
        initialState = new Node(grid+";");
        //count number of hostages
        int numOfHostages = GetSubString(grid, 7, 8).split(",").length / 3;
        int numOfAgents = GetSubString(grid, 4, 5).split(",").length / 2;
        initialState.AccumulativeAliveAgents = numOfAgents;
        initialState.OriginalTotalHostages = numOfHostages;
        return initialState;
    }
    public static String genericSearchProcedure(String grid,String Strategy) {
        InitialState(grid);
        System.out.println(initialState.GridString);
        Node Goal = null;
        switch(Strategy) {
            case "BF":
                UseHeuristic = false;
                Goal = BreadthFirst(initialState);
                System.out.println("Breadth First");
                System.out.println("ExpandedNodes: " + Goal.ExpandedNodes);
                break;
            case "DF":
                UseHeuristic = false;
                Goal = DepthLimited(initialState,Integer.MAX_VALUE);
                System.out.println("Depth First");
                System.out.println("ExpandedNodes: " + Goal.ExpandedNodes);
                break;
            case "ID":
                UseHeuristic = false;
                Goal = IterativeDeepening(initialState);
                System.out.println("Iterative Deepening");
                System.out.println("ExpandedNodes: " + Goal.ExpandedNodes);
                break;
            case "UC":
                UseHeuristic = false;
                Goal = UniformCost(initialState);
                System.out.println("Uniform Cost");
                System.out.println("ExpandedNodes: " + Goal.ExpandedNodes);
                break;
            case "GR1":
                UseHeuristic = true;
                Goal = Greedy1(initialState);
                System.out.println("Greedy 1");
                System.out.println("ExpandedNodes: " + Goal.ExpandedNodes);
                break;
            case "GR2":
                UseHeuristic = true;
                Goal = Greedy2(initialState);
                System.out.println("Greedy 2");
                System.out.println("ExpandedNodes: " + Goal.ExpandedNodes);
                break;
            case "AS1":
                UseHeuristic = true;
                Goal = AStar1(initialState);
                System.out.println("A* 1");
                System.out.println("ExpandedNodes: " + Goal.ExpandedNodes);
                break;
            case "AS2":
                UseHeuristic = true;
                Goal = AStar2(initialState);
                System.out.println("A* 2");
                System.out.println("ExpandedNodes: " + Goal.ExpandedNodes);
                break;

        }
        assert Goal != null;
        if (!Goal.IsSolution) {
            System.out.println("No Solution");
            return "No Solution";
        }
        System.out.println("Solution Found");
        System.out.println("Plan: " + Goal.TakenActions);
        System.out.println("DeadHostages: " + Goal.CountDeadHostages);
        System.out.println("DeadAgents: " + Goal.CountDeadAgents);
        return Goal.TakenActions+";"+Goal.CountDeadHostages+";"+Goal.CountDeadAgents+";"+Goal.ExpandedNodes;
    }
    public static int GetShortestPathToPads(Node node)
    {
        // for Pads
        String PadsString = GetSubString(node.GridString, 6, 7);
        int NeoX = Integer.parseInt(GetSubString(node.GridString, 2, 3).split(",")[0]);
        int NeoY = Integer.parseInt(GetSubString(node.GridString, 2, 3).split(",")[1]);
        if (PadsString.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        else
        {
            String[] PadsArr = PadsString.split(",");
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < PadsArr.length; i+=2) {
                int x = Integer.parseInt(PadsArr[i]);
                int y = Integer.parseInt(PadsArr[i+1]);
                int distance = Math.abs(NeoX - x) + Math.abs(NeoY - y);
                if (distance < min) {
                    min = distance;
                }
            }
            return min;
        }
    }
    public static int GetShortestPathToPills(Node node)
    {
        // for Pills
        String PillsString = GetSubString(node.GridString, 5, 6);
        int NeoX = Integer.parseInt(GetSubString(node.GridString, 2, 3).split(",")[0]);
        int NeoY = Integer.parseInt(GetSubString(node.GridString, 2, 3).split(",")[1]);
        if (PillsString.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        else
        {
            String[] PillsArr = PillsString.split(",");
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < PillsArr.length; i+=2) {
                int x = Integer.parseInt(PillsArr[i]);
                int y = Integer.parseInt(PillsArr[i+1]);
                int distance = Math.abs(NeoX - x) + Math.abs(NeoY - y);
                if (distance < min) {
                    min = distance;
                }
            }
            return min;
        }
    }
    public static int GetShortestPathToTelephoneBooth(Node node)
    {
        // for TelephoneBooth
        String TelephoneBoothString = GetSubString(node.GridString, 3, 4);
        int NeoX = Integer.parseInt(GetSubString(node.GridString, 2, 3).split(",")[0]);
        int NeoY = Integer.parseInt(GetSubString(node.GridString, 2, 3).split(",")[1]);
        if (TelephoneBoothString.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        else
        {
            String[] TelephoneBoothArr = TelephoneBoothString.split(",");
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < TelephoneBoothArr.length; i++) {
                int x = Integer.parseInt(TelephoneBoothArr[i]);
                int y = Integer.parseInt(TelephoneBoothArr[i]);
                int distance = Math.abs(NeoX - x) + Math.abs(NeoY - y);
                if (distance < min) {
                    min = distance;
                }
            }
            return min;
        }
    }

    public static int CarriedHostagesWithGuaranteedDeath(Node node) {
        int count = 0;
        // for CarriedHostages
        String CarriedHostagesString = GetSubString(node.GridString, 8, 9);
        if (CarriedHostagesString.isEmpty()) {
            count = 0;
        }
        else {
            int shortestPathToPill = GetShortestPathToPills(node);
            int shortestPathToTelephoneBooth = GetShortestPathToTelephoneBooth(node);
            int shortestPathToPads = GetShortestPathToPads(node);
            String[] CarriedHostages = CarriedHostagesString.split(",");
            for (int i = 0; i < CarriedHostages.length; i++) {
                if(!CarriedHostages[i].equals("100"))
                {
                    if((shortestPathToPads > shortestPathToPill && shortestPathToPads > shortestPathToTelephoneBooth))
                    {
                        int min = Math.min(shortestPathToPill, shortestPathToTelephoneBooth);
                        if ((min)*2 >= 100-Integer.parseInt(CarriedHostages[i])) {
                            count++;
                         //   System.out.println("min: " + min + " CarriedHostages: " + CarriedHostages[i]);
                        }
                        }
                    }
                }
            }
        return count;


    }
    public static int GetShortestPathToHostage(Node node, int hostageX, int hostageY)
    {
        int NeoX = Integer.parseInt(GetSubString(node.GridString, 2, 3).split(",")[0]);
        int NeoY = Integer.parseInt(GetSubString(node.GridString, 2, 3).split(",")[1]);
        int distance = Math.abs(NeoX - hostageX) + Math.abs(NeoY - hostageY);
        return distance;
    }

    public static int HostagesWithGuaranteedDeath(Node node) {
        int count = 0;
        // for CarriedHostages
        int NeoX = Integer.parseInt(GetSubString(node.GridString, 2, 3).split(",")[0]);
        int NeoY = Integer.parseInt(GetSubString(node.GridString, 2, 3).split(",")[1]);
        String HostagesString = GetSubString(node.GridString, 7, 8);
        if (HostagesString.isEmpty()) {
            count = 0;
        }
        else {
            int shortestPathToPill = GetShortestPathToPills(node);
            int shortestPathToPads = GetShortestPathToPads(node);
            String[] Hostages = HostagesString.split(",");
            for (int i = 0; i < Hostages.length; i+=3) {
                if(!Hostages[i+2].equals("100"))
                {
                    if (!(NeoX == Integer.parseInt(Hostages[i]) && NeoY == Integer.parseInt(Hostages[i+1]))) {
                        int shortestPathToHostage = GetShortestPathToHostage(node, Integer.parseInt(Hostages[i]), Integer.parseInt(Hostages[i + 1]));
                        if ((shortestPathToPads > shortestPathToPill && shortestPathToPads > shortestPathToHostage)) {
                            int min = Math.min(shortestPathToPill, shortestPathToHostage);
                            if ((min) * 2 >= 98 - Integer.parseInt(Hostages[i + 2])) {
                              //  System.out.println("ShortestPathToHostage: " + shortestPathToHostage + " ShortestPathToPads: " + shortestPathToPads + " ShortestPathToPill: " + shortestPathToPill);
                              //  System.out.println("NeoX: " + NeoX + " NeoY: " + NeoY + " HostageX: " + Integer.parseInt(Hostages[i]) + " HostageY: " + Integer.parseInt(Hostages[i + 1]) + " HostageHealth: " + Integer.parseInt(Hostages[i + 2]));
                              //  System.out.println("min: " + min + " CarriedHostages: " + Hostages[i + 2]);
                                count++;
                            }
                        }
                    }
                }
            }
        }
        return count;


    }
    //Check if node passed is in a goal state.
    public static boolean goalTest(Node node) {
        boolean IsNoRemainHostages = GetSubString(node.GridString, 7, 8).isEmpty();
        boolean IsNoRemainCarriedHostages = GetSubString(node.GridString, 8, 9).isEmpty();
        boolean IsAtTeleBooth = GetSubString(node.GridString, 2, 3).equals(GetSubString(node.GridString, 3, 4));
        return IsNoRemainHostages && IsNoRemainCarriedHostages && IsAtTeleBooth;
    }

    //Check if node passed is in an end state.
    public static boolean CheckGameOver(Node node) {
        return node.Damage >= 100;
    }

    public static String GetSubString(String grid, int FirstSimiColon, int LastSimiColon) {
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

        return grid.substring(subStringStart, subStringEnd);
    }

    public static String UpdateNeoPos(String grid, String position, int subStringStart, int subStringEnd) {
        return GetSubString(grid, 0, subStringStart) + ";" + position + ";" + GetSubString(grid, subStringEnd, 9);
    }

    public static String GetNeoPosition(String grid) {

        return GetSubString(grid, 2, 3);
    }

    public static String GetGridSize(String grid) {

        return GetSubString(grid, 0, 1);
    }

    public static String[] ExistInPadsArr(String[] Key, String[] Arr) {
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


    public static Boolean CanMoveUp(Node node) {
        if (node.Action.equals(Actions.down.toString())) {
            return false;
        }
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
            if ((HostagesArr[j].equals("100") || HostagesArr[j].equals("99") || HostagesArr[j].equals("98")) && HostagesArr[j - 1].equals(position[1]) && HostagesArr[j - 2].equals(newPositionUp)) {
                return false;
            }
        }
        return true;
    }

    public static Boolean CanMoveDown(Node node) {
        if (node.Action.equals(Actions.up.toString())) {
            return false;
        }
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
            if ((HostagesArr[j].equals("100") || HostagesArr[j].equals("99") || HostagesArr[j].equals("98")) && HostagesArr[j - 1].equals(position[1]) && HostagesArr[j - 2].equals(newPositionDown)) {
                return false;
            }
        }
        return true;
    }

    public static Boolean CanMoveRight(Node node) {
        if (node.Action.equals(Actions.left.toString())) {
            return false;
        }
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
            if ((HostagesArr[j].equals("100") || HostagesArr[j].equals("99") || HostagesArr[j].equals("98")) && HostagesArr[j - 1].equals(newPositionRight) && HostagesArr[j - 2].equals(position[0])) {
                return false;
            }
        }
        return true;
    }

    public static Boolean CanMoveLeft(Node node) {
        if (node.Action.equals(Actions.right.toString())) {
            return false;
        }
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
            if ((HostagesArr[j].equals("100") || HostagesArr[j].equals("99") || HostagesArr[j].equals("98")) && HostagesArr[j - 1].equals(newPositionLeft) && HostagesArr[j - 2].equals(position[0])) {
                return false;
            }
        }
        return true;
    }

    public static boolean CanCarryHostage(Node node) {
        if (node.Action.equals(Actions.carry.toString())||node.Action.equals(Actions.drop.toString())||node.Action.equals(Actions.fly.toString())||node.Action.equals(Actions.kill.toString())||node.Action.equals(Actions.takePill.toString())) {
            return false;
        }
        String HostagesString = GetSubString(node.GridString, 7, 8);
        int count = Integer.parseInt(GetSubString(node.GridString, 1, 2));
        if (count == 0)
            return false;
        if (HostagesString.isEmpty())
            return false;
        String[] HostagesArr = HostagesString.split(",");
        for (int i = 0; i < HostagesArr.length; i += 3) {
            if (Integer.parseInt(HostagesArr[i]) == Integer.parseInt(GetNeoPosition(node.GridString).substring(0, 1)) && Integer.parseInt(HostagesArr[i + 1]) == Integer.parseInt(GetNeoPosition(node.GridString).substring(2, 3))) {
                return true;
            }
        }
        return false;
    }

    public static boolean CanTakePill(Node node) {
        if (node.Action.equals(Actions.carry.toString())||node.Action.equals(Actions.drop.toString())||node.Action.equals(Actions.fly.toString())||node.Action.equals(Actions.kill.toString())||node.Action.equals(Actions.takePill.toString())) {
            return false;
        }
        String pillsString = GetSubString(node.GridString, 5, 6);
        if (pillsString.isEmpty())
            return false;
        String[] pillArr = pillsString.split(",");
        for (int i = 0; i < pillArr.length; i += 2) {
            if (Integer.parseInt(pillArr[i]) == Integer.parseInt(GetNeoPosition(node.GridString).substring(0, 1)) && Integer.parseInt(pillArr[i + 1]) == Integer.parseInt(GetNeoPosition(node.GridString).substring(2, 3))) {
                return true;
            }
        }
        return false;
    }

    public static boolean CanDropHostage(Node node) {
        if (node.Action.equals(Actions.carry.toString())||node.Action.equals(Actions.drop.toString())||node.Action.equals(Actions.fly.toString())||node.Action.equals(Actions.kill.toString())||node.Action.equals(Actions.takePill.toString())) {
            return false;
        }
        String CarriedHostagesString = GetSubString(node.GridString, 8, 9);
        if (CarriedHostagesString.isEmpty())
            return false;
        String[] CarriedHostagesArr = CarriedHostagesString.split(",");
        String hostages = Arrays.toString(CarriedHostagesArr);
        String h = hostages.substring(1, hostages.length() - 1).replaceAll("\\s+", "");
        return h.length() > 0 && !CarriedHostagesArr[0].equals(" ") && Integer.parseInt(GetNeoPosition(node.GridString).substring(0, 1)) == Integer.parseInt(GetSubString(node.GridString, 3, 4).substring(0, 1)) && Integer.parseInt(GetNeoPosition(node.GridString).substring(2, 3)) == Integer.parseInt(GetSubString(node.GridString, 3, 4).substring(2, 3));
    }

    public static boolean CanFly(Node node) {
        if (node.Action.equals(Actions.carry.toString())||node.Action.equals(Actions.drop.toString())||node.Action.equals(Actions.fly.toString())||node.Action.equals(Actions.kill.toString())||node.Action.equals(Actions.takePill.toString())) {
            return false;
        }
        String FlyString = GetSubString(node.GridString, 6, 7);
        if (FlyString.isEmpty())
            return false;
        String[] flyArr = FlyString.split(",");
        for (int i = 0; i < flyArr.length; i += 2) {
            if (Integer.parseInt(flyArr[i]) == Integer.parseInt(GetNeoPosition(node.GridString).substring(0, 1)) && Integer.parseInt(flyArr[i + 1]) == Integer.parseInt(GetNeoPosition(node.GridString).substring(2, 3))) {
                return true;
            }
        }
        return false;
    }

    public static boolean CanKill(Node node) {
        if (node.Action.equals(Actions.kill.toString())) {
            return false;
        }
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

            if (!agents[i].isEmpty()) {
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
        }
        for (int i = 0; i < Hostages.length; i += 3) {
            int HostageX = Integer.parseInt(Hostages[i]);
            int HostagesY = Integer.parseInt(Hostages[i + 1]);
            int HostageDamage = Integer.parseInt(Hostages[i + 2]);
            if ((HostageX == NeoX && HostagesY == NeoY) && HostageDamage >= 98) {
                return false;
            }
            if (HostageDamage == 100) {
                if (HostageX + 1 == NeoX && HostagesY == NeoY) {
                    return true;
                }
                if (HostageX - 1 == NeoX && HostagesY == NeoY) {
                    return true;
                }
                if (HostageX == NeoX && HostagesY + 1 == NeoY) {
                    return true;
                }
                if (HostageX == NeoX && HostagesY - 1 == NeoY) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Node UpdateTimeStep(Node node) {
        node.GridString = node.GridString.replace("]", "").replace("[", "").replace(" ", "");
        int NewDeadHostage = 0;
        String HostageString = GetSubString(node.getGridString(), 7, 8);
        String NewHostageString = "";
        int aliveNotCarriedHostage = 0;
        if (!HostageString.isEmpty()) {
            String[] HostageArr = HostageString.split(",");
            for (int i = 0; i < HostageArr.length; i += 3) {
                int damage = Integer.parseInt(HostageArr[i + 2]);
                damage += 2;
                if (damage == 102) {
                    HostageArr[i + 2] = 100 + "";
                }
                else if (damage >= 100) {
                    HostageArr[i + 2] = 100 + "";
                    NewDeadHostage++;
                } else {
                    aliveNotCarriedHostage++;
                    HostageArr[i + 2] = Integer.toString(damage);
                }
            }
            NewHostageString = Arrays.toString(HostageArr).replace("[", "").replace("]", "").replace(" ", "");
        }
        String CarriedHostageString = GetSubString(node.getGridString(), 8, 9);
        String NewCarriedHostageString = "";
        int aliveCarriedHostage = 0;
        if (!CarriedHostageString.isEmpty()) {
            String[] CarriedHostageArr = CarriedHostageString.split(",");
            for (int i = 0; i < CarriedHostageArr.length; i += 1) {
                int damage = Integer.parseInt(CarriedHostageArr[i]);
                damage += 2;
                if (damage == 102) {
                    CarriedHostageArr[i] = 100 + "";
                }
                else if (damage >= 100) {
                    CarriedHostageArr[i] = 100 + "";
                    NewDeadHostage++;
                } else {
                    aliveCarriedHostage++;
                    CarriedHostageArr[i] = Integer.toString(damage);
                }
            }
            NewCarriedHostageString = Arrays.toString(CarriedHostageArr).replace("[", "").replace("]", "").replace(" ", "");

        }
        node.AliveNotCarriedHostages=aliveNotCarriedHostage;
        node.GridString = GetSubString(node.getGridString(), 0, 7) + ";" + NewHostageString + ";" + NewCarriedHostageString;
        node.CountDeadHostages = NewDeadHostage + node.CountDeadHostages;
        node.AccumulativeAliveAgents += NewDeadHostage;
        node.AliveCarriedHostages=aliveCarriedHostage;

        return node;
    }

    public static Node MoveUp(Node node) {
        String[] position = GetNeoPosition(node.GridString).split(",");
        position[0] = String.valueOf(Integer.parseInt(position[0]) - 1);
        if (Integer.parseInt(position[0]) >= 0) {
            node.setGridString(UpdateNeoPos(node.GridString, position[0] + ',' + position[1], 2, 3));
        }
        node.UpdateNode(Actions.up);
        if (UseHeuristic) {
            node.Heuristic1 = CarriedHostagesWithGuaranteedDeath(node)*100;
            node.Heuristic2 = HostagesWithGuaranteedDeath(node)*100;
            if (node.Heuristic1 > 0) {
                
              //  System.out.println("Heuristic1: " + node.Heuristic1);
            }
        }
        return node;
    }

    public static Node MoveDown(Node node) {
        String[] position = GetNeoPosition(node.GridString).split(",");
        position[0] = String.valueOf(Integer.parseInt(position[0]) + 1);
        if (Integer.parseInt(position[0]) < Integer.parseInt(GetGridSize(node.GridString).split(",")[0])) {
            node.setGridString(UpdateNeoPos(node.GridString, position[0] + ',' + position[1], 2, 3));
        }
        node.UpdateNode(Actions.down);
        if (UseHeuristic) {
            node.Heuristic1 = CarriedHostagesWithGuaranteedDeath(node)*100;
            node.Heuristic2 = HostagesWithGuaranteedDeath(node)*100;
            if (node.Heuristic1 > 0) {
                
                //System.out.println("Heuristic1: " + node.Heuristic1);
            }
        }
        return node;
    }

    public static Node MoveRight(Node node) {
        String[] position = GetNeoPosition(node.GridString).split(",");
        position[1] = String.valueOf(Integer.parseInt(position[1]) + 1);
        if (Integer.parseInt(position[1]) < Integer.parseInt(GetGridSize(node.GridString).split(",")[1])) {
            node.setGridString(UpdateNeoPos(node.GridString, position[0] + ',' + position[1], 2, 3));
        }

        node.UpdateNode(Actions.right);
        if (UseHeuristic) {
            node.Heuristic1 = CarriedHostagesWithGuaranteedDeath(node)*100;
            node.Heuristic2 = HostagesWithGuaranteedDeath(node)*100;
            if (node.Heuristic1 > 0) {
                
                //System.out.println("Heuristic1: " + node.Heuristic1);
            }
        }
        return node;
    }

    public static Node MoveLeft(Node node) {
        String[] position = GetNeoPosition(node.GridString).split(",");
        position[1] = String.valueOf(Integer.parseInt(position[1]) - 1);
        if (Integer.parseInt(position[1]) >= 0) {
            node.setGridString(UpdateNeoPos(node.GridString, position[0] + ',' + position[1], 2, 3));
        }
        node.UpdateNode(Actions.left);
        if (UseHeuristic) {
            node.Heuristic1 = CarriedHostagesWithGuaranteedDeath(node)*100;
            node.Heuristic2 = HostagesWithGuaranteedDeath(node)*100;
            if (node.Heuristic1 > 0) {
                
                //System.out.println("Heuristic1: " + node.Heuristic1);
            }
        }
        return node;
    }

    //All agents in the neighbouring cells should die
    public static Node Kill(Node node) {
        int NewDamage = node.getDamage() + 20;
        int NewDeadAgents = node.CountDeadAgents;
        if (NewDamage > 100) {
            NewDamage = 100;
        }
        int NeoX = Integer.parseInt(GetNeoPosition(node.GridString).split(",")[0]);
        int NeoY = Integer.parseInt(GetNeoPosition(node.GridString).split(",")[1]);
        String[] AgentsArr = new String[]{};
        String AgentsString = GetSubString(node.GridString, 4, 5);
        if (!AgentsString.isEmpty()) {
            AgentsArr = AgentsString.split(",");
        }
        int AliveAgents = 0;
        for (int i = 0; i < AgentsArr.length; i += 2) {
            //if(!AgentsArr[i].isEmpty()) {
            if ((Integer.parseInt(AgentsArr[i]) == NeoX - 1 && Integer.parseInt(AgentsArr[i + 1]) == NeoY)) {
                AgentsArr[i] = "";
                AgentsArr[i + 1] = "";
                NewDeadAgents++;
            } else if ((Integer.parseInt(AgentsArr[i]) == NeoX + 1 && Integer.parseInt(AgentsArr[i + 1]) == NeoY)) {
                AgentsArr[i] = "";
                AgentsArr[i + 1] = "";
                NewDeadAgents++;
            } else if ((Integer.parseInt(AgentsArr[i]) == NeoX && Integer.parseInt(AgentsArr[i + 1]) == NeoY + 1)) {
                AgentsArr[i] = "";
                AgentsArr[i + 1] = "";
                NewDeadAgents++;
            } else if ((Integer.parseInt(AgentsArr[i]) == NeoX && Integer.parseInt(AgentsArr[i + 1]) == NeoY - 1)) {
                AgentsArr[i] = "";
                AgentsArr[i + 1] = "";
                NewDeadAgents++;
            }
            //}

        }
        String[] HostageArr = new String[]{};
        String HostageString = GetSubString(node.GridString, 7, 8);
        if (!HostageString.isEmpty()) {
            HostageArr = HostageString.split(",");
        }
        for (int i = 0; i < HostageArr.length; i += 3) {
            if ((HostageArr[i + 2].equals("100"))) {
                if ((Integer.parseInt(HostageArr[i]) == NeoX - 1 && Integer.parseInt(HostageArr[i + 1]) == NeoY)) {
                    HostageArr[i] = "";
                    HostageArr[i + 1] = "";
                    HostageArr[i + 2] = "";
                    NewDeadAgents++;
                } else if ((Integer.parseInt(HostageArr[i]) == NeoX + 1 && Integer.parseInt(HostageArr[i + 1]) == NeoY)) {
                    HostageArr[i] = "";
                    HostageArr[i + 1] = "";
                    HostageArr[i + 2] = "";
                    i -= 3;
                    NewDeadAgents++;
                } else if ((Integer.parseInt(HostageArr[i]) == NeoX && Integer.parseInt(HostageArr[i + 1]) == NeoY + 1)) {
                    HostageArr[i] = "";
                    HostageArr[i + 1] = "";
                    HostageArr[i + 2] = "";
                    i -= 3;
                    NewDeadAgents++;
                } else if ((Integer.parseInt(HostageArr[i]) == NeoX && Integer.parseInt(HostageArr[i + 1]) == NeoY - 1)) {
                    HostageArr[i] = "";
                    HostageArr[i + 1] = "";
                    HostageArr[i + 2] = "";
                    i -= 3;
                    NewDeadAgents++;
                }
            }
        }
        String NewAgentsString = Arrays.toString(AgentsArr).replace("[", "").replace("]", "").replace(" ", "").replace(",,", "");
        String NewHostageString = Arrays.toString(HostageArr).replace(", , , ", "").replace("[", "").replace("]", "").replace(" ", "").replace(",,", "");
        String NewGrid = GetSubString(node.GridString, 0, 4) + ";" + NewAgentsString + ";" + GetSubString(node.GridString, 5, 7) + ";" + NewHostageString + ";" + GetSubString(node.GridString, 8, 9);
        node.GridString = NewGrid.replace(";,;", ";;").replace(";,,;", ";;").replace(",;", ";").replace(",,", "").replace(" ", "");
        node.Damage = NewDamage;
        node.CountDeadAgents = NewDeadAgents;
        node.AliveAgents = AliveAgents;
        node.UpdateNode(Actions.kill);
        if (UseHeuristic) {
            node.Heuristic1 = CarriedHostagesWithGuaranteedDeath(node)*100;
            node.Heuristic2 = HostagesWithGuaranteedDeath(node)*100;
            if (node.Heuristic1 > 0) {
                
                //ln("Heuristic1: " + node.Heuristic1);
            }
        }
        return node;
    }

    public static Node Fly(Node node) {
        String NewNeoPos;
        String flyArr = GetSubString(node.GridString, 6, 7);
        String[] newPos = ExistInPadsArr(GetNeoPosition(node.GridString).split(","), flyArr.split(","));
        assert newPos != null;
        NewNeoPos = newPos[0] + "," + newPos[1];
        node.setGridString(UpdateNeoPos(node.GridString, NewNeoPos, 2, 3));
        node.UpdateNode(Actions.fly);
        if (UseHeuristic) {
            node.Heuristic1 = CarriedHostagesWithGuaranteedDeath(node)*100;
            node.Heuristic2 = HostagesWithGuaranteedDeath(node)*100;
            if (node.Heuristic1 > 0) {
                
              //  System.out.println("Heuristic1: " + node.Heuristic1);
            }
        }
        return node;
    }

    //loop on the hostage array and Carried hostage array and increase them by 2
    public static Node TakePill(Node node) {
        String CarriedHostageString = GetSubString(node.GridString, 8, 9);
        String[] CarriedHostagesArr = new String[]{};
        if (!CarriedHostageString.isEmpty()) {
            CarriedHostagesArr = CarriedHostageString.split(",");
        }
        String HostagesString = GetSubString(node.GridString, 7, 8);
        String[] HostagesArr = new String[]{};
        if (!HostagesString.isEmpty()) {
            HostagesArr = HostagesString.split(",");
        }
        int NewNeoDamage = node.Damage - 20;
        if (NewNeoDamage < 0) {
            NewNeoDamage = 0;
        }
        for (int i = 0; i < HostagesArr.length; i += 3) {
            int HostageDamage = Integer.parseInt(HostagesArr[i + 2]);
            if (HostageDamage < 100) {
                HostageDamage = HostageDamage - 20;
                if (HostageDamage < 0) {
                    HostageDamage = 0;
                }
                HostagesArr[i + 2] = HostageDamage + "";
            }
        }
        for (int i = 0; i < CarriedHostagesArr.length; i += 1) {
            int CarriedHostageDamage = Integer.parseInt(CarriedHostagesArr[i]);
            if (CarriedHostageDamage < 100) {
                CarriedHostageDamage = CarriedHostageDamage - 20;
                if (CarriedHostageDamage < 0) {
                    CarriedHostageDamage = 0;
                }
                CarriedHostagesArr[i] = CarriedHostageDamage + "";
            }
        }
        String PillString = GetSubString(node.GridString, 5, 6);
        String[] PillsArr = PillString.split(",");
        int NeoX = Integer.parseInt(GetSubString(node.GridString, 2, 3).split(",")[0]);
        int NeoY = Integer.parseInt(GetSubString(node.GridString, 2, 3).split(",")[1]);
        Vector<String> newPills = new Vector<>();
        for (int i = 0; i < PillsArr.length; i += 2) {
            if (!(Integer.parseInt(PillsArr[i]) == NeoX && Integer.parseInt(PillsArr[i + 1]) == NeoY)) {
                newPills.add(PillsArr[i]);
                newPills.add(PillsArr[i + 1]);
                break;
            }
        }
        String newHostages = Arrays.toString(HostagesArr).replace("[", "").replace("]", "").replace(" ", "").replace(",,,", "");
        String newCarried = Arrays.toString(CarriedHostagesArr).replace("[", "").replace("]", "").replace(" ", "");
        node.GridString = GetSubString(node.GridString, 0, 5) + ";" + newPills.toString().replace("[", "").replace("]", "").replace(" ","") + ";" + GetSubString(node.GridString, 6, 7) + ";" + newHostages + ";" + newCarried;
        node.Damage = NewNeoDamage;
        node.UpdateNode(Actions.takePill);
        if (UseHeuristic) {
            
            node.Heuristic1 = CarriedHostagesWithGuaranteedDeath(node)*100;
            node.Heuristic2 = HostagesWithGuaranteedDeath(node)*100;
            if (node.Heuristic1 > 0) {
                //
               // System.out.print(node.Heuristic1);
            }
        }
        return node;
    }

    public static Node CarryHostage(Node node) {
        String[] HostagesArr = GetSubString(node.GridString, 7, 8).split(",");
        int count = 0;
        String CarriedHostageString = GetSubString(node.GridString, 8, 9);
        String[] CarriedHostagesArr = new String[0];
        String[] newCarriedHostages = new String[1];
        if (!CarriedHostageString.isEmpty()) {
            CarriedHostagesArr = CarriedHostageString.split(",");
            newCarriedHostages = new String[CarriedHostagesArr.length + 1];
        }

        String damage = "";
        System.arraycopy(CarriedHostagesArr, 0, newCarriedHostages, 0, CarriedHostagesArr.length);
        String newHostages = "";
        for (int i = 0; i < HostagesArr.length; i += 3) {
            if (HostagesArr[i].equals(GetNeoPosition(node.GridString).substring(0, 1)) && HostagesArr[i + 1].equals(GetNeoPosition(node.GridString).substring(2, 3))) {
                count = Integer.parseInt(GetSubString(node.GridString, 1, 2));
                count -= 1;
                damage = HostagesArr[i + 2];
                HostagesArr[i] = "";
                HostagesArr[i + 1] = "";
                HostagesArr[i + 2] = "";
                newHostages = Arrays.toString(HostagesArr).replace(", , , ", "").replace(",,","");
                break;
            }
        }
        newCarriedHostages[newCarriedHostages.length - 1] = damage;
        String GridString = GetSubString(node.GridString, 0, 1) + ';' + count + ';' + GetSubString(node.GridString, 2, 7) + ";" + newHostages.replace(",,","").replace("[", "").replace("]", "").replace(" ", "") + ';' + Arrays.toString(newCarriedHostages).replace("]", "").replace("[", "") ;
        node.GridString = GridString.replace(" ", "");
        node.CarriedHostages =  newCarriedHostages.length;
        node.UpdateNode(Actions.carry);
        if (UseHeuristic) {
            node.Heuristic1 = CarriedHostagesWithGuaranteedDeath(node)*100;
            node.Heuristic2 = HostagesWithGuaranteedDeath(node)*100;
            if (node.Heuristic1 > 0) {
                
              //  System.out.println("Heuristic1: " + node.Heuristic1);
            }
        }
        return node;
    }

    public static Node DropHostage(Node node) {
        int CarriedHostagesCount = GetSubString(node.GridString, 8, 9).split(",").length;
        int CarryLimit = Integer.parseInt(GetSubString(node.GridString, 1, 2)) + CarriedHostagesCount;
        node.setGridString(GetSubString(node.GridString, 0, 1) + ";" + CarryLimit + ";" + GetSubString(node.GridString, 2, 8) + ";");
        node.CarriedHostages= 0;
        node.UpdateNode(Actions.drop);
        if (UseHeuristic) {
            node.Heuristic1 = CarriedHostagesWithGuaranteedDeath(node)*100;
            node.Heuristic2 = HostagesWithGuaranteedDeath(node)*100;
            if (node.Heuristic1 > 0) {
                
             //   System.out.println("Heuristic1: " + node.Heuristic1);
            }
        }
        return node;
    }

    public static Vector<Node> TakeAction(Node node) {
        node.GridString = node.GridString.replace("]", "").replace("[", "").replace("[,", "").replace(" ", "").replace(",,", "");
        Vector<Node> nodeArr = new Vector<>();
        if (VisitedHashSet.contains(node.GridString)) {
            return nodeArr;
        }
        VisitedHashSet.add(node.GridString);

        if (CanCarryHostage(node)) {
            nodeArr.add(UpdateTimeStep(CarryHostage(node.clone())));
        }
        if (CanDropHostage(node)) {
            nodeArr.add(UpdateTimeStep(DropHostage(node.clone())));
        }
        if (CanTakePill(node)) {
            nodeArr.add(TakePill(node.clone()));
        }
        if (CanKill(node)) {
            nodeArr.add(UpdateTimeStep(Kill(node.clone())));
        }
        if (CanFly(node)) {
            nodeArr.add(UpdateTimeStep(Fly(node.clone())));
        }
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
        return nodeArr;
    }

    //removes all the carried hostages from the node which is saved at the last part of the grid string and resets CarryLimit
    // breadth first search for the goal state

    public static Node BreadthFirst(Node node) {
        VisitedHashSet = new HashSet<>();
        Queue<Node> Queue = new LinkedList<>();
        int ExpandedNodes = 0;
        Queue.add(node);
        while (Queue.size() > 0) {
            //loop over TakeAction output and add them to Queue
            Node ActionNode = Queue.poll();
            if (CheckGameOver(ActionNode)) {
                continue;
            }
            if (goalTest(ActionNode)) {
                ActionNode.ExpandedNodes = ExpandedNodes;
                ActionNode.IsSolution = true;
                return ActionNode;
            }
            Vector<Node> nodeArr = TakeAction(ActionNode);
            ExpandedNodes++;
            for (Node value : nodeArr) {
                if (value != null) {
                    Queue.add(value);
                }
            }
        }
        Node EmptyNode = new Node();
        EmptyNode.ExpandedNodes = ExpandedNodes;
        return EmptyNode;
    }

    //Depth first search for the goal state if DepthLimit is Integer.Max.
    //Limited Depth search for the goal state
    public static Node DepthLimited(Node node, int DepthLimit) {
        VisitedHashSet = new HashSet<>();
        Stack<Node> Stack = new Stack<>();
        int ExpandedNodes = 0;
        Stack.add(node);
        while (Stack.size() > 0) {
            //loop over TakeAction output and add them to Queue
            Node ActionNode = Stack.pop();
            if (CheckGameOver(ActionNode)) {
                continue;
            }
            if (goalTest(ActionNode)) {
                ActionNode.ExpandedNodes = ExpandedNodes;
                ActionNode.IsSolution = true;
                return ActionNode;
            }
            if (ActionNode.Depth < DepthLimit) {
                Vector<Node> nodeArr = TakeAction(ActionNode);
                ExpandedNodes++;
                for (Node value : nodeArr) {
                    if (value != null) {
                        Stack.add(value);
                    }
                }
            }
        }
        Node EmptyNode = new Node();
        EmptyNode.ExpandedNodes = ExpandedNodes;
        return EmptyNode;
    }
    //Iterative Deepening search for the goal state

    public static Node IterativeDeepening(Node node) {
        VisitedHashSet = new HashSet<>();
        int ExpandedNodes = 0;
        int DepthLimit = 0;
        while (true) {
            VisitedHashSet.clear();
            Node ActionNode = DepthLimited(node.clone(), DepthLimit);
            ExpandedNodes += ActionNode.ExpandedNodes;
            if (ActionNode.IsSolution) {
                ActionNode.ExpandedNodes = ExpandedNodes;
                return ActionNode;
            }
            DepthLimit++;
        }
    }
    //UniformCost Search for the goal state

    public static Node UniformCost(Node node) {
        VisitedHashSet = new HashSet<>();
        int ExpandedNodes = 0;
        //override compare method
        PriorityQueue<Node> PriorityQueue = new PriorityQueue<>(20,
                Comparator.comparingInt(i -> i.TotalCost)

        );
        PriorityQueue.add(node);
        while (PriorityQueue.size() > 0) {
            //loop over TakeAction output and add them to Queue
            Node ActionNode = PriorityQueue.poll();
            if (CheckGameOver(ActionNode)) {
                continue;
            }
            if (goalTest(ActionNode)) {
                ActionNode.ExpandedNodes = ExpandedNodes;
                ActionNode.IsSolution = true;
                return ActionNode;
            }
            Vector<Node> nodeArr = TakeAction(ActionNode);
            ExpandedNodes++;
            for (Node value : nodeArr) {
                if (value != null) {
                    PriorityQueue.add(value);
                }
            }
        }
        Node EmptyNode = new Node();
        EmptyNode.ExpandedNodes = ExpandedNodes;
        return EmptyNode;
    }
    //GreedySearch for the goal state

    public static Node Greedy1(Node node) {
        VisitedHashSet = new HashSet<>();
        int ExpandedNodes = 0;
        //override compare method
        PriorityQueue<Node> PriorityQueue = new PriorityQueue<>(20,
                Comparator.comparingInt(i -> i.Cost)

        );
        PriorityQueue.add(node);
        while (PriorityQueue.size() > 0) {
            //loop over TakeAction output and add them to Queue
            Node ActionNode = PriorityQueue.poll();
            if (CheckGameOver(ActionNode)) {
                continue;
            }
            if (goalTest(ActionNode)) {
                ActionNode.ExpandedNodes = ExpandedNodes;
                ActionNode.IsSolution = true;
                return ActionNode;
            }
            Vector<Node> nodeArr = TakeAction(ActionNode);
            ExpandedNodes++;
            for (Node value : nodeArr) {
                if (value != null) {
                    PriorityQueue.add(value);
                }
            }
        }
        Node EmptyNode = new Node();
        EmptyNode.ExpandedNodes = ExpandedNodes;
        return EmptyNode;
    }
    //BestCost for the goal state

    public static Node Greedy2(Node node) {
        VisitedHashSet = new HashSet<>();
        int ExpandedNodes = 0;
        //override compare method
        PriorityQueue<Node> PriorityQueue = new PriorityQueue<>(20,
                Comparator.comparingInt(i -> i.Heuristic1)

        );
        PriorityQueue.add(node);
        while (PriorityQueue.size() > 0) {
            //loop over TakeAction output and add them to Queue
            Node ActionNode = PriorityQueue.poll();
            if (CheckGameOver(ActionNode)) {
                continue;
            }
            if (goalTest(ActionNode)) {
                ActionNode.ExpandedNodes = ExpandedNodes;
                ActionNode.IsSolution = true;
                return ActionNode;
            }
            Vector<Node> nodeArr = TakeAction(ActionNode);
            ExpandedNodes++;
            for (Node value : nodeArr) {
                if (value != null) {
                    PriorityQueue.add(value);
                }
            }
        }
        Node EmptyNode = new Node();
        EmptyNode.ExpandedNodes = ExpandedNodes;
        return EmptyNode;
    }

    public static Node Greedy3(Node node) {
        VisitedHashSet = new HashSet<>();
        int ExpandedNodes = 0;
        //override compare method
        PriorityQueue<Node> PriorityQueue = new PriorityQueue<>(20,
                Comparator.comparingInt(i -> i.Heuristic1)

        );
        PriorityQueue.add(node);
        while (PriorityQueue.size() > 0) {
            //loop over TakeAction output and add them to Queue
            Node ActionNode = PriorityQueue.poll();
            if (CheckGameOver(ActionNode)) {
                continue;
            }
            if (goalTest(ActionNode)) {
                ActionNode.ExpandedNodes = ExpandedNodes;
                ActionNode.IsSolution = true;
                return ActionNode;
            }
            Vector<Node> nodeArr = TakeAction(ActionNode);
            ExpandedNodes++;
            for (Node value : nodeArr) {
                if (value != null) {
                    PriorityQueue.add(value);
                }
            }
        }
        Node EmptyNode = new Node();
        EmptyNode.ExpandedNodes = ExpandedNodes;
        return EmptyNode;
    }

    //A* Search for the goal state
    public static Node AStar1(Node node) {
        VisitedHashSet = new HashSet<>();
        int ExpandedNodes = 0;
        //override compare method
        PriorityQueue<Node> PriorityQueue = new PriorityQueue<>(20,
                Comparator.comparingInt(i -> i.Heuristic1 + i.TotalCost)

        );
        PriorityQueue.add(node);
        while (PriorityQueue.size() > 0) {
            //loop over TakeAction output and add them to Queue
            Node ActionNode = PriorityQueue.poll();
            if (CheckGameOver(ActionNode)) {
                continue;
            }
            if (goalTest(ActionNode)) {
                ActionNode.ExpandedNodes = ExpandedNodes;
                ActionNode.IsSolution = true;
                return ActionNode;
            }
            Vector<Node> nodeArr = TakeAction(ActionNode);
            ExpandedNodes++;
            for (Node value : nodeArr) {
                if (value != null) {
                    PriorityQueue.add(value);
                }
            }
        }
        Node EmptyNode = new Node();
        EmptyNode.ExpandedNodes = ExpandedNodes;
        return EmptyNode;
    }

    public static Node AStar2(Node node) {
        VisitedHashSet = new HashSet<>();
        int ExpandedNodes = 0;
        //override compare method
        PriorityQueue<Node> PriorityQueue = new PriorityQueue<>(20,
                Comparator.comparingInt(i -> i.Heuristic2 + i.Cost)

        );
        PriorityQueue.add(node);
        while (PriorityQueue.size() > 0) {
            //loop over TakeAction output and add them to Queue
            Node ActionNode = PriorityQueue.poll();
            if (CheckGameOver(ActionNode)) {
                continue;
            }
            if (goalTest(ActionNode)) {
                ActionNode.ExpandedNodes = ExpandedNodes;
                ActionNode.IsSolution = true;
                return ActionNode;
            }
            Vector<Node> nodeArr = TakeAction(ActionNode);
            ExpandedNodes++;
            for (Node value : nodeArr) {
                if (value != null) {
                    PriorityQueue.add(value);
                }
            }
        }
        Node EmptyNode = new Node();
        EmptyNode.ExpandedNodes = ExpandedNodes;
        return EmptyNode;
    }

}
