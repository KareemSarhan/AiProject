import java.util.Arrays;
import java.util.Vector;

public class Matrix {
    /**
     * Generates a random grid.
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
     * Example Output Grid:
     * 5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80
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
        return "";
    }

    /**
     * Prints a 2d representation of the grid.
     * @param grid
     */
    public static void Visualize(String grid)
    {

    }
    // TODO: 10/31/2021 Check getRandom , Check if its used correctly
    public static int getRandom(int min, int max) {
        int rand = (int) ((Math.random() * (max - min)) + min);
        return rand;
    }
}
