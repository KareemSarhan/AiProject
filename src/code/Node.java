package code;

import java.util.Objects;

public class Node {
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
    public void ConcatAction(String action)
    {
        TakenActions+=action;
    }
}
