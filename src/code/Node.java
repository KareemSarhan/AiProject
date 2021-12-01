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
    public int AliveNotCarriedHostages;
    public int AliveCarriedHostages;
    public int AliveAgents;
    public int WillBeKilledHostages;
    public int AccumulativeAliveAgents;
    public int CarriedHostages;
    public int OriginalTotalHostages;
    public int Heuristic1;
    public int Heuristic2;
    public boolean IsSolution;
    public String Action;

    public Node(String gridString) {
        GridString = gridString;
        Damage = 0;
        TakenActions="";
        Action="";
        CountDeadHostages=0;
        CountDeadAgents=0;
        ParentNode = new Node();
    }

    public Node() {
        GridString = "";
        Damage = 0;
        TakenActions="";
        Action="";
        CountDeadHostages=0;
        OriginalTotalHostages=0;
        CountDeadAgents=0;
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

    public void UpdateNode(Actions action)
    {
        Depth++;
        Action = action.toString();
        if (TakenActions.length() == 0) {
            TakenActions += action;
        }
        else {
            TakenActions += "," + action;
        }
        Cost = CountDeadHostages*100 + CountDeadAgents - TotalCost;
        TotalCost = CountDeadHostages*100 + CountDeadAgents;

    }
}
