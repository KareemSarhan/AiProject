import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SearchProblem {
    Queue<Node> Queue= new LinkedList<>();
    public boolean GoalTest(Node node)
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
                    subStringStart = i;
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
                    subStringStart = i;
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
        return false;
    }
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

    private Node Pill(Node node)
    {
        String pillArr = GetSubString(node.GridString,5,6);
        String pillPos = ExistAndRemoveInPillsArr(GetNeoPosition(node.GridString),pillArr.split(","));
        if () {

        }
        String[] HostagesArr = GetSubString(node.GridString,7,8).split(",");
        for (int i = 0; i < HostagesArr.length; i+=3) {
            HostagesArr[i] = String.valueOf(Integer.parseInt(HostagesArr[i]) + 20);
        }
        node.setDamage(node.getDamage()- 20);
        node.GridString = UpdateState(node.GridString, String.valueOf(HostagesArr),7,8);
        node.setGridString(UpdateState(node.GridString, Arrays.toString(GetNeoPosition(node.GridString)),2,3));

        return node;
    }

    private boolean CanCarry(Node node) {
    }

    private boolean CanDrop(Node node) {
    }

    private boolean CanKill(Node node) {
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
        String Action = node.getAction();
        Node[] nodeArr = new Node[9];
        nodeArr[0] = MoveUp(node);
        nodeArr[1] = MoveDown(node);
        nodeArr[2] = MoveLeft(node);
        nodeArr[3] = MoveRight(node);
        nodeArr[4] = Fly(node);

        if(CanPill(node))
        {

        }
        if(CanCarry(node))
        {

        }
        if(CanDrop(node))
        {

        }
        if(CanKill(node))
        {

        }

    }

}
    public void BreadthFirst(Node node)
    {
        Queue.add(node);
        while (Queue.size()>0)
        {
            TakeAction(Queue.remove());
        }
    }
    public void DepthFirst()
    {

    }
    public void IterativeDeepening()
    {

    }
    public void UniformCost()
    {

    }
    public void GreedySearch(int heuristic)
    {

    }
    public void AstarSearch(int heuristic)
    {

    }

}
