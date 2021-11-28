package code;

import java.util.*;

public class SearchProblem {
    Queue<Node> Queue = new LinkedList<>();
    Stack<Node> Stack = new Stack<>();
    HashSet<String> VisitedHashSet = new HashSet<String>();

    public void SetHeuristic(Node node) {
        String GridString = node.GridString;
        String[] Hostages = GetSubString(GridString, 7, 8).split(",");
        int HostagesCount = Hostages.length / 3;
        String[] CarriedHostages = GetSubString(GridString, 8, 9).split(",");
        int CarriedHostagesCount = CarriedHostages.length;
        node.Heuristic = CarriedHostagesCount * 2 + HostagesCount;
    }

    public String FixString(String grid) {
        return grid.replaceAll("\n", "").replace(" ", "").replace(",,,", ",").replace(",,", "").replace(";,", ";").replace(",;", ";");
    }

    //Check if node passed is in a goal state.
    public boolean CheckGoal(Node node) {
        boolean IsNoRemainHostages = GetSubString(node.GridString, 7, 8).isEmpty();
        boolean IsNoRemainCarriedHostages = GetSubString(node.GridString, 8, 9).isEmpty();
        boolean IsAtTeleBooth = GetSubString(node.GridString, 2, 3).equals(GetSubString(node.GridString, 3, 4));
        return IsNoRemainHostages && IsNoRemainCarriedHostages && IsAtTeleBooth;
    }

    //Check if node passed is in an end state.
    public boolean CheckGameOver(Node node) {
        boolean IsNeoDead = node.Damage >= 100;
        return IsNeoDead;
    }

    public String GetAbsoluteGrid(String grid) {

        String NewGrid = GetSubString(grid, 0, 7);
        String Hostages = GetSubString(grid, 7, 8);
        if (Hostages.isEmpty()) {
            return NewGrid + ";";
        }
        String[] HostageArr = GetSubString(grid, 7, 8).split(",");
        String[] NewHostageArr = new String[HostageArr.length];
        for (int i = 0; i < HostageArr.length; i += 3) {
            NewHostageArr[i] = HostageArr[i];
            NewHostageArr[i + 1] = HostageArr[i + 1];
            if (HostageArr[i + 2].equals("100") || HostageArr[i + 2].equals("99") || HostageArr[i + 2].equals("98")) {
                NewHostageArr[i + 2] = "T";
            } else {
                NewHostageArr[i + 2] = "F";
            }
            NewHostageArr[i + 2] = NewHostageArr[i + 2];
        }
        NewGrid += ";" + String.join(",", NewHostageArr);
        return NewGrid;
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

    public String UpdateNeoPos(String grid, String position, int subStringStart, int subStringEnd) {
        return GetSubString(grid, 0, subStringStart) + ";" + position + ";" + GetSubString(grid, subStringEnd, 9);
    }

    public String GetNeoPosition(String grid) {

        String NeoPosition = GetSubString(grid, 2, 3);
        return NeoPosition;
    }

    public String GetGridSize(String grid) {
        String SizeMN = GetSubString(grid, 0, 1);

        return SizeMN;
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
            if ((HostagesArr[j].equals("100") || HostagesArr[j].equals("99") || HostagesArr[j].equals("98")) && HostagesArr[j - 1].equals(position[1]) && HostagesArr[j - 2].equals(newPositionUp)) {
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
            if ((HostagesArr[j].equals("100") || HostagesArr[j].equals("99") || HostagesArr[j].equals("98")) && HostagesArr[j - 1].equals(position[1]) && HostagesArr[j - 2].equals(newPositionDown)) {
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
            if ((HostagesArr[j].equals("100") || HostagesArr[j].equals("99") || HostagesArr[j].equals("98")) && HostagesArr[j - 1].equals(newPositionRight) && HostagesArr[j - 2].equals(position[0])) {
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
            if ((HostagesArr[j].equals("100") || HostagesArr[j].equals("99") || HostagesArr[j].equals("98")) && HostagesArr[j - 1].equals(newPositionLeft) && HostagesArr[j - 2].equals(position[0])) {
                return false;
            }
        }
        return true;
    }

    public boolean CanCarryHostage(Node node) {
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

    public boolean CanTakePill(Node node) {
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

    public boolean CanDropHostage(Node node) {
        String CarriedHostagesString = GetSubString(node.GridString, 8, 9);
        if (CarriedHostagesString.isEmpty())
            return false;
        String[] CarriedHostagesArr = CarriedHostagesString.split(",");
        String hostages = Arrays.toString(CarriedHostagesArr);
        String h = hostages.substring(1, hostages.length() - 1).replaceAll("\\s+", "");
        return h.length() > 0 && !CarriedHostagesArr[0].equals(" ") && Integer.parseInt(GetNeoPosition(node.GridString).substring(0, 1)) == Integer.parseInt(GetSubString(node.GridString, 3, 4).substring(0, 1)) && Integer.parseInt(GetNeoPosition(node.GridString).substring(2, 3)) == Integer.parseInt(GetSubString(node.GridString, 3, 4).substring(2, 3));
    }

    public boolean CanFly(Node node) {
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

    public Node UpdateTimeStep(Node node) {
        node.GridString = node.GridString.replace("]", "").replace("[", "").replace(" ", "");
        int NewDeadHostage = 0;
        String HostageString = GetSubString(node.getGridString(), 7, 8);
        String NewHostageString = "";
        if (!HostageString.isEmpty()) {
            String[] HostageArr = HostageString.split(",");
            for (int i = 0; i < HostageArr.length; i += 3) {
                int damage = Integer.parseInt(HostageArr[i + 2]);
                damage += 2;
                if (damage == 102)
                    HostageArr[i + 2] = 100 + "";
                else if (damage >= 100) {
                    HostageArr[i + 2] = 100 + "";
                    NewDeadHostage++;
                } else {
                    HostageArr[i + 2] = Integer.toString(damage);
                }
            }
            NewHostageString = Arrays.toString(HostageArr).replace("[", "").replace("]", "").replace(" ", "");
        }
        String CarriedHostageString = GetSubString(node.getGridString(), 8, 9);
        String NewCarriedHostageString = "";
        if (!CarriedHostageString.isEmpty()) {
            String[] CarriedHostageArr = CarriedHostageString.split(",");
            for (int i = 0; i < CarriedHostageArr.length; i += 1) {
                int damage = Integer.parseInt(CarriedHostageArr[i]);
                damage += 2;
                if (damage == 102)
                    CarriedHostageArr[i] = 100 + "";
                else if (damage >= 100) {
                    CarriedHostageArr[i] = 100 + "";
                    NewDeadHostage++;
                } else {
                    CarriedHostageArr[i] = Integer.toString(damage);
                }
            }
            NewCarriedHostageString = Arrays.toString(CarriedHostageArr).replace("[", "").replace("]", "").replace(" ", "");

        }

        String NewGridString = GetSubString(node.getGridString(), 0, 7) + ";" + NewHostageString + ";" + NewCarriedHostageString;
        node.GridString = NewGridString;
        node.CountDeadHostages = NewDeadHostage + node.CountDeadHostages;
        return node;
    }

    public Node MoveUp(Node node) {
        String[] position = GetNeoPosition(node.GridString).split(",");
        position[0] = String.valueOf(Integer.parseInt(position[0]) - 1);
        if (Integer.parseInt(position[0]) >= 0) {
            node.setGridString(UpdateNeoPos(node.GridString, position[0] + ',' + position[1], 2, 3));
        }
        node.ConcatAction(Actions.up);
        SetHeuristic(node);
        return node;
    }

    public Node MoveDown(Node node) {
        String[] position = GetNeoPosition(node.GridString).split(",");
        position[0] = String.valueOf(Integer.parseInt(position[0]) + 1);
        if (Integer.parseInt(position[0]) < Integer.parseInt(GetGridSize(node.GridString).split(",")[0])) {
            node.setGridString(UpdateNeoPos(node.GridString, position[0] + ',' + position[1], 2, 3));
        }
        node.ConcatAction(Actions.down);
        SetHeuristic(node);
        return node;
    }

    public Node MoveRight(Node node) {
        String[] position = GetNeoPosition(node.GridString).split(",");
        position[1] = String.valueOf(Integer.parseInt(position[1]) + 1);
        if (Integer.parseInt(position[1]) < Integer.parseInt(GetGridSize(node.GridString).split(",")[1])) {
            node.setGridString(UpdateNeoPos(node.GridString, position[0] + ',' + position[1], 2, 3));
        }
        node.ConcatAction(Actions.right);
        SetHeuristic(node);
        return node;
    }

    public Node MoveLeft(Node node) {
        String[] position = GetNeoPosition(node.GridString).split(",");
        position[1] = String.valueOf(Integer.parseInt(position[1]) - 1);
        if (Integer.parseInt(position[1]) >= 0) {
            node.setGridString(UpdateNeoPos(node.GridString, position[0] + ',' + position[1], 2, 3));
        }
        node.ConcatAction(Actions.left);
        SetHeuristic(node);
        return node;
    }

    //All agents in the neighbouring cells should die
    public Node Kill(Node node) {
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
        String NewHostageString = Arrays.toString(HostageArr).replace(", , , ", "").replace("[", "").replace("]", "").replace(" ", "");
        String NewGrid = GetSubString(node.GridString, 0, 4) + ";" + NewAgentsString + ";" + GetSubString(node.GridString, 5, 7) + ";" + NewHostageString + ";" + GetSubString(node.GridString, 8, 9);
        node.GridString = NewGrid.replace(";,;", ";;");
        node.Damage = NewDamage;
        node.CountDeadAgents = NewDeadAgents;
        SetHeuristic(node);
        node.ConcatAction(Actions.kill);
        return node;
    }

    public Node Fly(Node node) {
        String NewNeoPos = "";
        String flyArr = GetSubString(node.GridString, 6, 7);
        String[] newPos = ExistInPadsArr(GetNeoPosition(node.GridString).split(","), flyArr.split(","));
        NewNeoPos = newPos[0] + "," + newPos[1];
        node.setGridString(UpdateNeoPos(node.GridString, NewNeoPos, 2, 3));
        SetHeuristic(node);
        node.ConcatAction(Actions.fly);
        return node;
    }

    //loop on the hostage array and Carried hostage array and increase them by 2
    public Node TakePill(Node node) {
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
        String NewGrid = GetSubString(node.GridString, 0, 5) + ";" + newPills.toString().replace("[", "").replace("]", "") + ";" + GetSubString(node.GridString, 6, 7) + ";" + newHostages + ";" + newCarried;
        node.GridString = NewGrid;
        node.Damage = NewNeoDamage;
        SetHeuristic(node);
        node.ConcatAction(Actions.takePill);
        return node;
    }

    public Node CarryHostage(Node node) {
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
        for (int i = 0; i < CarriedHostagesArr.length; i++) {
            newCarriedHostages[i] = CarriedHostagesArr[i];
        }
        String newHostages = "";
        for (int i = 0; i < HostagesArr.length; i += 3) {
            if (HostagesArr[i].equals(GetNeoPosition(node.GridString).substring(0, 1)) && HostagesArr[i + 1].equals(GetNeoPosition(node.GridString).substring(2, 3))) {
                count = Integer.parseInt(GetSubString(node.GridString, 1, 2));
                count -= 1;
                damage = HostagesArr[i + 2];
                HostagesArr[i] = "";
                HostagesArr[i + 1] = "";
                HostagesArr[i + 2] = "";
                newHostages = Arrays.toString(HostagesArr).replace(", , , ", "");
                break;
            }
        }
        newCarriedHostages[newCarriedHostages.length - 1] = damage;
        String GridString = GetSubString(node.GridString, 0, 1) + ';' + count + ';' + GetSubString(node.GridString, 2, 7) + ";" + newHostages.replace("[", "").replace("]", "").replace(" ", "") + ';' + Arrays.toString(newCarriedHostages).replace("]", "").replace("[", "") + ";";
        node.GridString = GridString.replace(" ", "");
        SetHeuristic(node);
        node.ConcatAction(Actions.carry);
        return node;
    }

    public Node DropHostage(Node node) {
        int CarriedHostagesCount = GetSubString(node.GridString, 8, 9).split(",").length;
        int CarryLimit = Integer.parseInt(GetSubString(node.GridString, 1, 2)) + CarriedHostagesCount;
        node.setGridString(GetSubString(node.GridString, 0, 1) + ";" + CarryLimit + ";" + GetSubString(node.GridString, 2, 8) + ";");
        node.ConcatAction(Actions.drop);
        return node;
    }

    public Vector<Node> TakeAction(Node node) {
        node.GridString = node.GridString.replace("]", "").replace("[", "").replace("[,", "").replace(" ", "");
        Vector<Node> nodeArr = new Vector<Node>();
        if (VisitedHashSet.contains(GetAbsoluteGrid(node.GridString))) {
            return nodeArr;
        }
        VisitedHashSet.add(GetAbsoluteGrid(node.GridString));

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
    // breadth first search for the goal state

    public Node BreadthFirst(Node node) {
        int ExpandedNodes = 0;
        Queue.add(node);
        while (Queue.size() > 0) {
            //loop over TakeAction output and add them to Queue
            Node ActionNode = Queue.poll();
            if (CheckGameOver(ActionNode)) {
                continue;
            }
            if (CheckGoal(ActionNode)) {
                ActionNode.ExpandedNodes = ExpandedNodes;
                ActionNode.IsSolution = true;
                return ActionNode;
            }
            Vector<Node> nodeArr = TakeAction(ActionNode);
            ExpandedNodes++;
            for (int i = 0; i < nodeArr.size(); i++) {
                if (nodeArr.get(i) != null) {
                    Queue.add(nodeArr.get(i));
                }
            }
        }
        Node EmptyNode = new Node();
        EmptyNode.ExpandedNodes = ExpandedNodes;
        return EmptyNode;
    }

    //Depth first search for the goal state if DepthLimit is Integer.Max.
    //Limited Depth search for the goal state
    public Node DepthLimited(Node node, int DepthLimit) {
        int ExpandedNodes = 0;
        Stack.add(node);
        while (Stack.size() > 0) {
            //loop over TakeAction output and add them to Queue
            Node ActionNode = Stack.pop();
            if (CheckGameOver(ActionNode)) {
                continue;
            }
            if (CheckGoal(ActionNode)) {
                ActionNode.ExpandedNodes = ExpandedNodes;
                ActionNode.IsSolution = true;
                return ActionNode;
            }
            if (ActionNode.Depth < DepthLimit) {
                Vector<Node> nodeArr = TakeAction(ActionNode);
                ExpandedNodes++;
                for (int i = 0; i < nodeArr.size(); i++) {
                    if (nodeArr.get(i) != null) {
                        Stack.add(nodeArr.get(i));
                    }
                }
            }
        }
        Node EmptyNode = new Node();
        EmptyNode.ExpandedNodes = ExpandedNodes;
        return EmptyNode;
    }
    //Iterative Deepening search for the goal state

    public Node IterativeDeepening(Node node) {
        int ExpandedNodes = 0;
        int DepthLimit = 1;
        while (true) {
            VisitedHashSet.clear();
            Stack.clear();
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

    public Node UniformCost(Node node) {
        int ExpandedNodes = 0;
        PriorityQueue<Node> PriorityQueue = new PriorityQueue<Node>(20,
                new Comparator<Node>() {

                    //override compare method
                    public int compare(Node i, Node j) {
                        if (i.TotalCost > j.TotalCost) {
                            return 1;
                        } else if (i.TotalCost < j.TotalCost) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                }

        );
        PriorityQueue.add(node);
        while (PriorityQueue.size() > 0) {
            //loop over TakeAction output and add them to Queue
            Node ActionNode = PriorityQueue.poll();
            if (CheckGameOver(ActionNode)) {
                continue;
            }
            if (CheckGoal(ActionNode)) {
                ActionNode.ExpandedNodes = ExpandedNodes;
                ActionNode.IsSolution = true;
                return ActionNode;
            }
            Vector<Node> nodeArr = TakeAction(ActionNode);
            ExpandedNodes++;
            for (int i = 0; i < nodeArr.size(); i++) {
                if (nodeArr.get(i) != null) {
                    PriorityQueue.add(nodeArr.get(i));
                }
            }
        }
        Node EmptyNode = new Node();
        EmptyNode.ExpandedNodes = ExpandedNodes;
        return EmptyNode;
    }
    //GreedySearch for the goal state

    public Node Greedy1(Node node) {
        int ExpandedNodes = 0;
        PriorityQueue<Node> PriorityQueue = new PriorityQueue<Node>(20,
                new Comparator<Node>() {

                    //override compare method
                    public int compare(Node i, Node j) {
                        if (i.Heuristic > j.Heuristic) {
                            return 1;
                        } else if (i.Heuristic < j.Heuristic) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                }

        );
        PriorityQueue.add(node);
        while (PriorityQueue.size() > 0) {
            //loop over TakeAction output and add them to Queue
            Node ActionNode = PriorityQueue.poll();
            if (CheckGameOver(ActionNode)) {
                continue;
            }
            if (CheckGoal(ActionNode)) {
                ActionNode.ExpandedNodes = ExpandedNodes;
                ActionNode.IsSolution = true;
                return ActionNode;
            }
            Vector<Node> nodeArr = TakeAction(ActionNode);
            ExpandedNodes++;
            for (int i = 0; i < nodeArr.size(); i++) {
                if (nodeArr.get(i) != null) {
                    PriorityQueue.add(nodeArr.get(i));
                }
            }
        }
        Node EmptyNode = new Node();
        EmptyNode.ExpandedNodes = ExpandedNodes;
        return EmptyNode;
    }
    //BestCost for the goal state

    public Node Greedy2(Node node) {
        int ExpandedNodes = 0;
        PriorityQueue<Node> PriorityQueue = new PriorityQueue<Node>(20,
                new Comparator<Node>() {

                    //override compare method
                    public int compare(Node i, Node j) {
                        if (i.Cost > j.Cost) {
                            return 1;
                        } else if (i.Cost < j.Cost) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                }

        );
        PriorityQueue.add(node);
        while (PriorityQueue.size() > 0) {
            //loop over TakeAction output and add them to Queue
            Node ActionNode = PriorityQueue.poll();
            if (CheckGameOver(ActionNode)) {
                continue;
            }
            if (CheckGoal(ActionNode)) {
                ActionNode.ExpandedNodes = ExpandedNodes;
                ActionNode.IsSolution = true;
                return ActionNode;
            }
            Vector<Node> nodeArr = TakeAction(ActionNode);
            ExpandedNodes++;
            for (int i = 0; i < nodeArr.size(); i++) {
                if (nodeArr.get(i) != null) {
                    PriorityQueue.add(nodeArr.get(i));
                }
            }
        }
        Node EmptyNode = new Node();
        EmptyNode.ExpandedNodes = ExpandedNodes;
        return EmptyNode;
    }
    //A star Search for the goal state

    public Node AStar1(Node node) {
        int ExpandedNodes = 0;
        PriorityQueue<Node> PriorityQueue = new PriorityQueue<Node>(20,
                new Comparator<Node>() {

                    //override compare method
                    public int compare(Node i, Node j) {
                        if (i.Heuristic + i.TotalCost > j.Heuristic + j.TotalCost) {
                            return 1;
                        } else if (i.Heuristic + i.TotalCost < j.Heuristic + j.TotalCost) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                }

        );
        PriorityQueue.add(node);
        while (PriorityQueue.size() > 0) {
            //loop over TakeAction output and add them to Queue
            Node ActionNode = PriorityQueue.poll();
            if (CheckGameOver(ActionNode)) {
                continue;
            }
            if (CheckGoal(ActionNode)) {
                ActionNode.ExpandedNodes = ExpandedNodes;
                ActionNode.IsSolution = true;
                return ActionNode;
            }
            Vector<Node> nodeArr = TakeAction(ActionNode);
            ExpandedNodes++;
            for (int i = 0; i < nodeArr.size(); i++) {
                if (nodeArr.get(i) != null) {
                    PriorityQueue.add(nodeArr.get(i));
                }
            }
        }
        Node EmptyNode = new Node();
        EmptyNode.ExpandedNodes = ExpandedNodes;
        return EmptyNode;
    }

    public Node AStar2(Node node) {
        int ExpandedNodes = 0;
        PriorityQueue<Node> PriorityQueue = new PriorityQueue<Node>(20,
                new Comparator<Node>() {

                    //override compare method
                    public int compare(Node i, Node j) {
                        if (i.Heuristic + i.Cost > j.Heuristic + j.Cost) {
                            return 1;
                        } else if (i.Heuristic + i.Cost < j.Heuristic + j.Cost) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                }

        );
        PriorityQueue.add(node);
        while (PriorityQueue.size() > 0) {
            //loop over TakeAction output and add them to Queue
            Node ActionNode = PriorityQueue.poll();
            if (CheckGameOver(ActionNode)) {
                continue;
            }
            if (CheckGoal(ActionNode)) {
                ActionNode.ExpandedNodes = ExpandedNodes;
                ActionNode.IsSolution = true;
                return ActionNode;
            }
            Vector<Node> nodeArr = TakeAction(ActionNode);
            ExpandedNodes++;
            for (int i = 0; i < nodeArr.size(); i++) {
                if (nodeArr.get(i) != null) {
                    PriorityQueue.add(nodeArr.get(i));
                }
            }
        }
        Node EmptyNode = new Node();
        EmptyNode.ExpandedNodes = ExpandedNodes;
        return EmptyNode;
    }

}
