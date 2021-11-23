package tests;

import code.Node;
import code.SearchProblem;
import org.junit.Test;

import static org.junit.Assert.*;

public class SearchProblemTest {
SearchProblem sp= new SearchProblem();
    @Test
    public void getSubStringTest() {
        String s1 =  "5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80";
        String s2 = "5,5";
        assertEquals(s2, sp.GetSubString(s1,0,1));
    }
    @Test
    public void getSubStringTest2() {
        String s1 =  "5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80";
        String s2 = "2";
        assertEquals(s2, sp.GetSubString(s1,1,2));
    }

    @Test
    public void getSubStringTest3() {
        String s1 =  "5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80";
        String s2 = "1,4";
        assertEquals(s2, sp.GetSubString(s1,3,4));
    }

    @Test
    public void getNeoPositionTest() {
    }

    @Test
    public void getGridSizeTest() {
    }

    @Test
    public void NodeDamageTest()
    {
        Node n = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(0, n.getDamage());
    }
    @Test
    public void NodeActionsTest()
    {
        Node n = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(null, n.TakenActions);
    }
    @Test
    public void MoveUpTest()
    {
        Node n = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(null, n.TakenActions);
    }
    @Test
    public void MoveUpBorderTest()
    {
        Node n = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(null, n.TakenActions);
    }
    @Test
    public void MoveDownTest()
    {
        Node n = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(null, n.TakenActions);
    }
    @Test
    public void MoveDownBorderTest()
    {
        Node n = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(null, n.TakenActions);
    }
    @Test
    public void LeftUpTest()
    {
        Node n = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(null, n.TakenActions);
    }
    @Test
    public void MoveLeftBorderTest()
    {
        Node n = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(null, n.TakenActions);
    }
    @Test
    public void RightUpTest()
    {
        Node n = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(null, n.TakenActions);
    }
    @Test
    public void MoveRightBorderTest()
    {
        Node n = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(null, n.TakenActions);
    }
    @Test
    public void CanKillTest()
    {
        Node n = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(null, n.TakenActions);
    }
    @Test
    public void CanCarryTest()
    {
        Node n = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(null, n.TakenActions);
    }
    @Test
    public void CanDropTest()
    {
        Node n = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(null, n.TakenActions);
    }
    @Test
    public void TakePillTest()
    {
        Node n = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(null, n.TakenActions);
    }
    @Test
    public void RemovePillTest() {
    }
    @Test
    public void CheckGoalTest()
    {
        Node n = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(null, n.TakenActions);
    }

    @Test
    public void UpdateStateTest() {
    }

    @Test
    public void UpdateTimeStepTest() {
    }
}