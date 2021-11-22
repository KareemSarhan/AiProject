package code;

public class Node {
    String GridString;
    public String TakenActions;
    int Damage;

    public Node(String gridString) {
        GridString = gridString;
        Damage = 0;
    }
    public Node(String gridString, int damage) {
        GridString = gridString;
        Damage = damage;
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