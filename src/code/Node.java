package code;

import java.util.Objects;

public class Node implements Cloneable {
    public String GridString;
    public String TakenActions;
    public int Damage;

    public Node(String gridString) {
        GridString = gridString;
        Damage = 0;
        TakenActions="";
    }
    public Node(String gridString, int damage) {
        GridString = gridString;
        Damage = damage;
        TakenActions="";
    }
    public Node(String gridString, int damage, String takenActions) {
        GridString = gridString;
        Damage = damage;
        TakenActions=takenActions;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return Damage == node.Damage && GridString.equals(node.GridString) && TakenActions.equals(node.TakenActions);
    }


    @Override
    public String toString() {
        return "code.Node{" +
                "GridString='" + GridString + '\'' +
                ", TakenActions='" + TakenActions + '\'' +
                ", Damage=" + Damage +
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
        return t;
    }
    public int getDamage() {
        return Damage;
    }

    public void setDamage(int damage) {
        Damage = damage;
        if(damage > 100)
            damage = 100;
        if(damage < 0)
            damage = 0;

    }
    public void ConcatAction(Actions action)
    {
        TakenActions+=action;
    }
}
