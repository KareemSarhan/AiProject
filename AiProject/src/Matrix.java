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
     * ∗ M and N represent the width and height of the grid respectively.
     * ∗ C is the maximum number of members Neo can carry at a time.
     * ∗ NeoX and NeoY represent the x and y starting positions of Neo.
     * ∗ TelephoneX and TelephoneY represent the x and y positions of the telephone booth.
     * ∗ AgentXi
     * ,AgentYi represent the x and y position of agent i where 1 ≤ i ≤ k
     * and k is the total number of agents.
     * ∗ PillXi
     * ,PillYi represent the x and y position of pill i where 1 ≤ i ≤ g and
     * g is the total number of pills.
     * ∗ StartPadXi
     * ,StartPadYi represent the x and y position of pad i where 1 ≤
     * i ≤ l and l is the total number of pads. Moreover FinishPadXi
     * ,FinishPadYi
     * represent the x and y position of the target pad stated by StartPadXi and
     * StartPadYi
     * . For example, if StartPadX = 1, StartPadY = 2, FinishPadX
     * = 3, and FinishPadY = 4, this means that Neo can fly directly from cell
     * (1, 2) to cell (3, 4). Further, if 1, 2, 3, 4 is in the string, then the string must
     * also contain 3, 4, 1, 2. That is, Neo could fly from cell (3, 4) to cell (1, 2)
     * instantly.
     * Example Output Grid:
     * 5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80
     */
    public static String genGrid()
    {
        return "";
    }

    /**
     * uses search to try to formulate a winning plan.
     * @param grid is a string representing the grid to perform the search on.
     * @param strategy is a symbol indicating the search strategy.
     * @param visualize is a boolean parameter which, when set to true, results in your program’s side-effecting a visual presentation of the grid.
     * @return String of the following format: plan;deaths;kills;nodes
     * Where
     * – plan is a string representing the operators Neo needs to follow separated by
     * commas. The possible operator names are: up, down, left, right, carry,
     * drop, takePill, kill, and fly.
     * – deaths is a number representing the number of dead hostages in the found
     * goal state (whether they turned into agents or not).
     * – kills is a number representing the number of killed agents in the found goal
     * state (including the number of agents that were hostages before).
     * – nodes is the number of nodes chosen for expansion during the search.
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
}
