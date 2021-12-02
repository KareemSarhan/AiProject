package code;

import java.util.Arrays;
import java.util.Stack;
import java.util.Vector;

public class Matrix  extends GenericSearchProblem{
    public static void main(String[] args) {}
    /**
     * genGrid() generates a random grid. The dimensions of the grid,
     * the starting position of Neo and the telephone booth,
     * as well as the number and locations of the
     * hostages, agents, pills, and pads are to be randomly generated. You need to make
     * sure that the dimensions of the generated grid is between 5×5 and 15×15 and the
     * number of generated hostages is between 3 and 10. For every hostage,
     * random starting damage between 1 and 99 should also be generated. Also, pads come in
     * pairs. Meaning, pad P1 must be generated with another pad P2 where Neo can
     * fly from P1 to P2 and vice versa. The number of hostages Neo can carry c should
     * be randomly generated as well where c ≤ 4. The number of pills should be less
     * than or equal to the number of hostages. There are no restrictions on the
     * maximum number of agents or pads (as long as no overlapping occurs and
     * there are enough cells in the grid).
     * no overlapping occurs and there are enough cells in the grid.
     * @return String representing a grid.
     * M,N; C; NeoX,NeoY; TelephoneX,TelephoneY;
     * AgentX1,AgentY1, ...,AgentXk,AgentYk;
     * PillX1,PillY1, ...,PillXg,PillYg;
     * StartPadX1,StartPadY1,FinishPadX1,FinishPadY1,...,
     * StartPadXl,StartPadYl,FinishPadXl,FinishPadYl;
     * HostageX1,HostageY1,HostageDamage1, ...,HostageXw,HostageYw,HostageDamageW
     * where:
     * 	M and N represent the width and height of the grid respectively.
     * 	C is the maximum number of members Neo can carry at a time.
     * 	NeoX and NeoY represent the x and y starting positions of Neo.
     * 	TelephoneX and TelephoneY represent the x and y positions of the telephone booth.
     * 	AgentXi , AgentYi represent the x and y position of agent i where 1 <= i <= k
     * 	and k is the total number of agents.
     * 	PillXi, PillYi represent the x and y position of pill i where 1 <= i <= g and
     * 	g is the total number of pills.
     * 	StartPadXi, StartPadYi represent the x and y position of pad i where 1 <=
     * 	i <= l and l is the total number of pads.
     * 	Moreover, FinishPadXi, FinishPadYi represent the x and y position of the target pad stated by StartPadXi and
     * 	StartPadYi.
     *  For example, if StartPadX = 1, StartPadY = 2,
     *  FinishPadX = 3, and FinishPadY = 4, this means that Neo can fly directly from cell
     * 	(1, 2) to cell (3, 4). Further, if 1, 2, 3, 4 is in the string, then the string must
     * 	also contain 3, 4, 1, 2. That is, Neo could fly from cell (3, 4) to cell (1, 2)
     * 	instantly.
     * 	HostageXi, HostageYi represent the x and y position of hostage i where 1 <= i <= w and
     * 	w is the total number of hostages.
     * 	HostageDamageI represents the damage done to hostage i where 1 <= i <= w and w is the total
     * 	number of hostages.
     * 	For example, if HostageX = 1, HostageY = 2, HostageDamage = 3, then the hostage is
     * 	in cell (1, 2) and has 3 damage.
     * Example Output Grid:
     * 5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80
     *
     */
    public static String genGrid()
    {
        int gridX = getRandom(5,15);
        int gridY = getRandom(5,15);
        int numOfHostages = getRandom(3,10);
        int[] damagePerHostage = new int[numOfHostages];
        for (int i = 0; i < numOfHostages; i++) {
            damagePerHostage[i] = getRandom(1,99);
        }
        int carryLimit = getRandom(1,4);
        int numOfPills = getRandom(1,numOfHostages);
        Vector<int []> emptySlots = new Vector<>();
        for (int i = 0; i < gridX; i++) {
            for (int j = 0; j < gridY; j++) {
                emptySlots.add(new int[]{i,j});
            }
        }
        StringBuilder grid = new StringBuilder();
        grid.append(gridX).append(",").append(gridY);
        grid.append(";").append(carryLimit);
        int[] neoStartCell = emptySlots.remove(getRandom(0,emptySlots.size()));
        grid.append(";").append(neoStartCell[0]).append(",").append(neoStartCell[1]);
        int[] telephoneBoothCell = emptySlots.remove(getRandom(0,emptySlots.size()));
        grid.append(";").append(telephoneBoothCell[0]).append(",").append(telephoneBoothCell[1]);
        int[][] pillCells = new int[numOfPills][2];
        for (int i = 0; i < numOfPills; i++) {
            pillCells[i] = emptySlots.remove(getRandom(0,emptySlots.size()));
        }
        int[][] hostageCells = new int[numOfHostages][2];
        for (int i = 0; i < numOfHostages; i++) {
            hostageCells[i] = emptySlots.remove(getRandom(0,emptySlots.size()));
        }
        int numOfAgents = getRandom(1,(emptySlots.size()-1)/2);
        int[][] agentsCells = new int[numOfAgents][2];
        for (int i = 0; i < numOfAgents; i++) {
            agentsCells[i] = emptySlots.remove(getRandom(0,emptySlots.size()));
        }
        int numOfPads = getRandom(2,emptySlots.size()-1)/2;
        int[][] padsCells = new int[numOfPads][4];
        for (int i = 0; i < numOfPads; i++) {
            int[] padStartCell = emptySlots.remove(getRandom(0,emptySlots.size()));
            int[] padEndCell = emptySlots.remove(getRandom(0,emptySlots.size()));
            padsCells[i][0] = padStartCell[0];
            padsCells[i][1] = padStartCell[1];
            padsCells[i][2] = padEndCell[0];
            padsCells[i][3] = padEndCell[1];
        }
        grid.append(";");
        for (int i = 0; i < numOfAgents; i++) {
            grid.append(agentsCells[i][0]).append(",").append(agentsCells[i][1]);
            if (i < numOfAgents-1) {
                grid.append(",");
            }
        }
        grid.append(";");
        for (int i = 0; i < numOfPills; i++) {
            grid.append(pillCells[i][0]).append(",").append(pillCells[i][1]);
            if (i < numOfPills-1) {
                grid.append(",");
            }
        }
        grid.append(";");
        for (int i = 0; i < numOfPads; i++) {
            grid.append(padsCells[i][0]).append(",").append(padsCells[i][1]).append(",").append(padsCells[i][2]).append(",").append(padsCells[i][3]);
            if (i < numOfPads-1) {
                grid.append(",");
            }
        }
        grid.append(";");
        for (int i = 0; i < numOfHostages; i++) {
            grid.append(hostageCells[i][0]).append(",").append(hostageCells[i][1]).append(",").append(damagePerHostage[i]);
            if (i < numOfHostages-1) {
                grid.append(",");
            }
        }

        // All Prints
        System.out.println("tele" + Arrays.toString(telephoneBoothCell));
        System.out.println("agents" + Arrays.deepToString(agentsCells));
        System.out.println("pads" + Arrays.deepToString(padsCells));
        System.out.println("pills" + Arrays.deepToString(pillCells));
        System.out.println("neo" + Arrays.toString(neoStartCell));
        System.out.println("hostages" + Arrays.deepToString(hostageCells));
        System.out.println("hostagesDmg" + Arrays.toString(damagePerHostage));

        return grid.toString();
    }

    private static int getRandom(int i, int i1) {
        return (int) (Math.random() * (i1 - i) + i);
    }

    /**
     * uses search to try to formulate a winning plan.
     * @param grid is a string representing the grid to perform the search on.
     * @param strategy is a symbol indicating the search strategy.
     * @param visualize is a boolean parameter which, when set to true, results in your program’s side-effecting a visual presentation of the grid.
     * @return String of the following format: plan;deaths;kills;nodes
     * Where
     * - Plan is a string representing the operators Neo needs to follow separated by
     * commas. The possible operator names are: up, down, left, right, carry,
     * drop, takePill, kill, and fly.
     * - Deaths is a number representing the number of dead hostages in the found
     * goal state (whether they turned into agents or not).
     * - Kills is a number representing the number of killed agents in the found goal
     * state (including the number of agents that were hostages before).
     * - Nodes is the number of nodes chosen for expansion during the search.
     * Example Input Grid:
     * 5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80
     * Example Output:
     * left,fly,right,carry,left,fly,down,right,drop,left,left,kill,left,left
     * up,carry,down,down,kill,up,right,right,right,right,drop;1;2;1246837
     */     
        
    public static String solve(String grid, String strategy, boolean visualize)
    {
        Node Goal = GenericSearchProblem.genericSearchProcedure(grid,strategy);
        assert Goal != null;
        if (!Goal.IsSolution) {
            System.out.println("No Solution");
            return "No Solution";
        }
        if (visualize)
        {
            Node Temp = Goal.clone();
            Stack Nodes = new Stack();
            while(Temp!=null && Temp.GridString!="")
            {
                Nodes.push(new String[]{Temp.GridString, String.valueOf(Temp.Damage), String.valueOf(Temp.Depth)});
                Temp = Temp.ParentNode;
            }
            while (!Nodes.isEmpty())
            {
                Visualize((String[]) Nodes.pop());
            }
        }

        return Goal.TakenActions+";"+Goal.CountDeadHostages+";"+Goal.CountDeadAgents+";"+Goal.ExpandedNodes;

    }

    /**
     * Method visualize
     * Prints a 2d table like representation of the grid with Neo representing Neo's position, TB for telephone booth, A for agents , H(dmg) for hostages with their damage, P for pads.
     * @param grid string representation of the grid
     * example input: "5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80"
     */
    public static void Visualize(String[] Vis)
    {
        String grid = Vis[0];
        String NeoDmg=Vis[1];
        String Turn =Vis[2];
        String[][] gridView = new String[Integer.parseInt(GetSubString(grid,0,1).split(",")[0])][Integer.parseInt(GetSubString(grid,0,1).split(",")[1])];
        for (int i = 0; i < gridView.length; i++) {
            for (int j = 0; j < gridView[0].length; j++) {
                gridView[i][j] = "null    ";
            }
        }
        String[] NeoPos = GetSubString(grid,2,3).split(",");
        String[] TB = GetSubString(grid,3,4).split(",");
        gridView[Integer.parseInt(TB[0])][Integer.parseInt(TB[1])] = "TB      ";
        String tempAgentsString = GetSubString(grid,4,5);
        if (!tempAgentsString.isEmpty()) {
            String[] tempAgents = tempAgentsString.split(",");

            for (int i = 0; i < tempAgents.length; i = i + 2) {
                gridView[Integer.parseInt(tempAgents[i])][Integer.parseInt(tempAgents[i + 1])] = "A       ";
            }
        }
        String PillsString = GetSubString(grid,5,6);
        if (!PillsString.isEmpty()) {
            String[] tempPills = PillsString.split(",");
            for (int i = 0; i < tempPills.length; i = i + 2) {
                gridView[Integer.parseInt(tempPills[i])][Integer.parseInt(tempPills[i + 1])] = "Pill    ";
            }
        }
        String PadsString = GetSubString(grid,6,7);
        if (!PadsString.isEmpty()) {
            String[] tempPads = PadsString.split(",");
            for (int i = 0; i < tempPads.length / 2; i = i + 4) {
                gridView[Integer.parseInt(tempPads[i])][Integer.parseInt(tempPads[i + 1])] = "P(" + tempPads[(i + 2)] + "-" + tempPads[(i + 3)] + ")  ";
                gridView[Integer.parseInt(tempPads[i + 2])][Integer.parseInt(tempPads[i + 3])] = "P(" + tempPads[i] + "-" + tempPads[(i + 1)] + ")  ";
            }
        }
        String HostagesString = GetSubString(grid,7,8);
        if (!HostagesString.isEmpty()) {
            String[] tempHostages = HostagesString.split(",");
            for (int i = 0; i < tempHostages.length; i = i + 3) {
                if (tempHostages[i+2].length()==1)
                gridView[Integer.parseInt(tempHostages[i])][Integer.parseInt(tempHostages[i + 1])] = "H(00" + (tempHostages[i + 2]) + ")  ";
                else if (tempHostages[i+2].length()==2)
                    gridView[Integer.parseInt(tempHostages[i])][Integer.parseInt(tempHostages[i + 1])] = "H(0" + (tempHostages[i + 2]) + ")  ";
                else
                    gridView[Integer.parseInt(tempHostages[i])][Integer.parseInt(tempHostages[i + 1])] = "H(" + (tempHostages[i + 2]) + ")  ";

            }
        }
        System.out.println();
        System.out.println("--------------------------------------------");
        System.out.println("NeoDmg: " + NeoDmg);
        System.out.println("Turn: " + Turn);

        if ((gridView[Integer.parseInt(NeoPos[0])][Integer.parseInt(NeoPos[1])]) == ("null    ")) {
            gridView[Integer.parseInt(NeoPos[0])][Integer.parseInt(NeoPos[1])] = "N       ";
        }
        else {
            gridView[Integer.parseInt(NeoPos[0])][Integer.parseInt(NeoPos[1])] = gridView[Integer.parseInt(NeoPos[0])][Integer.parseInt(NeoPos[1])].replaceFirst("  ", "+N");
        }
        System.out.println(Arrays.deepToString(gridView)
                .replace("],", "\n").replace(",", "")
                .replaceAll("[\\[\\]]", " "));
        String HostagesCarriedString = GetSubString(grid,8,9);
        if (!HostagesCarriedString.isEmpty()) {
            String[] tempCarriedHostages = HostagesCarriedString.split(",");
            System.out.print("CarriedHostages: ");
            for (int i = 0; i < tempCarriedHostages.length; i = i + 1) {
                System.out.print("H("+tempCarriedHostages[i]+")  ");
            }
        }
    }


}
