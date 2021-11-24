package code;

import java.util.Arrays;
import java.util.Vector;

public class Matrix {
    public static void main(String[] args) {
        System.out.println("Welcome to the code.Matrix.");
        //System.out.println(code.Matrix.genGrid());
        // code.Matrix.printGrid("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80");
        //code.Matrix.solve("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80","BF",false);
    }
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
     * HostageX1,HostageY1,HostageDamage1, ...,HostageXw,HostageYw,HostageDamagew
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
     * 	HostageDamagei represents the damage done to hostage i where 1 <= i <= w and w is the total
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
        String grid = "";
        grid += gridX+","+gridY;
        grid += ";" + carryLimit;
        int[] neoStartCell = emptySlots.remove(getRandom(0,emptySlots.size()));
        grid += ";" + neoStartCell[0]+","+neoStartCell[1];
        int[] telephoneBoothCell = emptySlots.remove(getRandom(0,emptySlots.size()));
        grid += ";" + telephoneBoothCell[0]+","+telephoneBoothCell[1];
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
        // TODO: 10/31/2021 Check if next line is right
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
        grid +=";";
        for (int i = 0; i < numOfAgents; i++) {
            grid += agentsCells[i][0] + "," +agentsCells[i][1] ;
            if (i < numOfAgents-1) {grid +=  ",";
            }
        }
        grid +=";";
        for (int i = 0; i < numOfPills; i++) {
            grid += pillCells[i][0] + "," +pillCells[i][1] ;
            if (i < numOfPills-1) {grid +=  ",";
            }
        }
        grid +=";";
        for (int i = 0; i < numOfPads; i++) {
            grid += padsCells[i][0] + "," +padsCells[i][1] + "," +padsCells[i][2] + "," +padsCells[i][3] ;
            if (i < numOfPads-1) {grid +=  ",";
            }
        }
        grid +=";";
        for (int i = 0; i < numOfHostages; i++) {
            grid += hostageCells[i][0] + "," +hostageCells[i][1] + "," +damagePerHostage[i] ;
            if (i < numOfHostages-1) {grid +=  ",";
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

        return grid;
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
        grid += ";";
        Node Head = new Node(grid);
        SearchProblem Search = new SearchProblem();
        switch(strategy) {
            case "BF":
                Search.BreadthFirst(Head);
                break;
            case "DF":


                break;
        }
        return "";
    }

    /**
     * Method visualize
     * Prints a 2d table like representation of the grid with Neo representing Neo's position, TB for telephone booth, A for agents , H(dmg) for hostages with thier damage, P for pads.
     * @param grid string representation of the grid
     * example input: "5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80"
     */
    public static void Visualize(String grid)
    {
        String[] gridArr = grid.split(";");
        Vector<String[]> gridVec = new Vector<>();
        for (int i = 0; i < gridArr.length; i++) {
            String[] tempVec = gridArr[i].split(",");
            gridVec.add(tempVec);
        }
        String[][] gridView = new String[Integer.parseInt(gridVec.get(0)[0])][Integer.parseInt(gridVec.get(0)[1])];
        gridView[Integer.parseInt(gridVec.get(2)[0])][Integer.parseInt(gridVec.get(2)[1])] = "Neo";
        gridView[Integer.parseInt(gridVec.get(3)[0])][Integer.parseInt(gridVec.get(3)[1])] = "TB";
        gridView[Integer.parseInt(gridVec.get(3)[0])][Integer.parseInt(gridVec.get(3)[1])] = "TB";
        String[] tempAgents = gridVec.get(4);

        for (int i = 0; i < tempAgents.length; i = i +2) {
            gridView[Integer.parseInt(tempAgents[i])][Integer.parseInt(tempAgents[i+1])] = "A";
        }
        String[] tempPills = gridVec.get(5);
        for (int i = 0; i < tempPills.length; i = i +2) {
            gridView[Integer.parseInt(tempPills[i])][Integer.parseInt(tempPills[i+1])] = "P";
        }
        String[] tempPads = gridVec.get(6);
        System.out.println(Arrays.toString(tempPads));
        for (int i = 0; i < tempPads.length/2; i = i +4) {
            gridView[Integer.parseInt(tempPads[i])][Integer.parseInt(tempPads[i+1])] = "Pad (" + tempPads[(i+2)] +","+tempPads[(i+3)]+")";
            gridView[Integer.parseInt(tempPads[i+2])][Integer.parseInt(tempPads[i+3])] = "Pad (" + tempPads[i] +","+tempPads[(i+1)]+")";
        }
        String[] tempHostages = gridVec.get(7);
        for (int i = 0; i < tempPads.length; i = i +3) {
            gridView[Integer.parseInt(tempHostages[i])][Integer.parseInt(tempHostages[i+1])] = "H (" +(tempHostages[i+2])+")";
        }
        /*
        Different views
        System.out.println(Arrays.deepToString(gridView));
        System.out.println(Arrays.deepToString(gridView).replace("], ", "]\n"));
        */
        System.out.println();
        System.out.println(Arrays.deepToString(gridView)
                .replace("],", "\n").replace(",", "\t")
                .replaceAll("[\\[\\]]", " "));
    }


}
