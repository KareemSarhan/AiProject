package code;

public class Node implements Cloneable {
    public String GridString;
    public String TakenActions;
    public int Damage;
    public int CountDeadHostages;
    public int CountDeadAgents;
    public int ExpandedNodes;
    public Node ParentNode;
    public int Depth;
    public int TotalCost;
    public int Cost;
    public int Heuristic;
    public boolean IsSolution;

    public Node(String gridString) {
        GridString = gridString;
        Damage = 0;
        TakenActions="";
        CountDeadHostages=0;
        CountDeadAgents=0;
    }
    public Node(String gridString, int damage) {
        GridString = gridString;
        Damage = damage;
        TakenActions="";
        CountDeadHostages=0;
        CountDeadAgents=0;
    }

    public Node() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Damage == node.Damage && CountDeadHostages == node.CountDeadHostages && CountDeadAgents == node.CountDeadAgents && GridString.equals(node.GridString) && TakenActions.equals(node.TakenActions);
    }

    @Override
    public String toString() {
        return "Node{" +
                "GridString='" + GridString + '\'' +
                ", TakenActions='" + TakenActions + '\'' +
                ", Damage=" + Damage +
                ", CountDeadHostages=" + CountDeadHostages +
                ", CountDeadAgents=" + CountDeadAgents +
                ", ExpandedNodes=" + ExpandedNodes +
                ", ParentNode=" + ParentNode +
                '}';
    }

    public String getGridString() {
        return GridString;
    }

    public void setGridString(String gridString) {
        GridString = gridString;
    }
    public Node clone()
    {
        Node t = null;
        try {
            t = (Node)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        assert t != null;
        t.ParentNode = this;
        return t;
    }
    public int getDamage() {
        return Damage;
    }

    public void ConcatAction(Actions action)
    {
        Depth++;
        if (TakenActions.length() == 0)
            TakenActions+=action;
        else
            TakenActions+=","+action;
        /*
        switch (action)
        {
            case up:
            case down:
            case left:
            case right:
                TotalCost+=3;
                Cost+=3;
                break;
            case carry:
            case takePill:
            case drop:
                TotalCost+=0;
                Cost+=0;
                break;
            case fly:
                TotalCost+=2;
                Cost+=2;
                break;
            case kill:
                TotalCost+=5;
                Cost+=5;
                break;
        }
        */
        int temp = TotalCost;
        TotalCost = CountDeadHostages*100 + CountDeadAgents;
        Cost = TotalCost - temp;
    }
}
