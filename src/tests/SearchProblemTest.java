package tests;

import code.Node;
import code.SearchProblem;
import org.junit.Test;

import static org.junit.Assert.*;

public class SearchProblemTest {
    SearchProblem s = new SearchProblem();
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
        String ActualGrid =  "5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80";
        String NeoPosition= "0,4";
        assertEquals(NeoPosition, sp.GetNeoPosition(ActualGrid));
    }

    @Test
    public void getNeoPositionTest2() {
        String ActualGrid =  "5,5;2;0,40;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80";
        String NeoPosition= "0,40";
        assertEquals(NeoPosition, sp.GetNeoPosition(ActualGrid));
    }

    @Test
    public void getGridSizeTest() {
        String ActualGrid =  "5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80";
        String ExpectedResult= "5,5";
        assertEquals(ExpectedResult, sp.GetGridSize(ActualGrid));
    }
    @Test
    public void getGridSizeTest2() {
        String ActualGrid =  "5,50;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80";
        String ExpectedResult= "5,50";
        assertEquals(ExpectedResult, sp.GetGridSize(ActualGrid));
    }
    @Test
    public void NodeDamageTest()
    {
        Node n = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(0, n.getDamage());
    }

    @Test
    public void NodeDamageTest1()
    {
        Node n = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                10);
        assertEquals(10, n.getDamage());
    }
    @Test
    public void TakeActionTest()
    {
        Node actual = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        Node[] expectedArr = new Node[]{};
        //loop on Node and do all the searchProblem actions

        Node MoveUpNode = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        Node MoveDownNode = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        sp.MoveUp(actual);
        Node MoveLeftNode = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        sp.MoveUp(actual);
        Node MoveRightNode = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        sp.MoveUp(actual);
        Node FlyNode = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        sp.MoveUp(actual);

        Node KillNode = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        sp.MoveUp(actual);

        Node PillNode = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        sp.MoveUp(actual);

        Node CarryNode = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        //sp.Carry(actual);

        Node DropNode = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        //sp.(actual);


    }
    @Test
    public void MoveUpTest()
    {
        Node n = new Node("5,5;2;1,4;0,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
            0);
        Node n1 = new Node("5,5;2;0,4;0,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(n1, sp.MoveUp(n));
    }
    @Test
    public void MoveUpBorderTest()
    {
        Node n = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        Node n1 = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(n1, sp.MoveUp(n));
    }
    @Test
    public void MoveDownTest()
    {
        Node n = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        Node n2 = new Node("5,5;2;1,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);

        assertEquals(n2, sp.MoveDown(n));
//        assertEquals(n2.TakenActions,sp.MoveDown(n).TakenActions );
//        assertEquals(n2.Damage,sp.MoveDown(n).Damage );
    }
    @Test
    public void MoveDownBorderTest()
    {
        Node n = new Node("5,5;2;4,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        Node n1 = new Node("5,5;2;4,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(n1,sp.MoveDown(n) );
    }
    @Test
    public void MoveLeftTest()
    {
        Node n = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        Node n1 = new Node("5,5;2;0,3;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(n1, sp.MoveLeft(n));
    }
    @Test
    public void MoveLeftBorderTest()
    {
        Node n = new Node("5,5;2;0,0;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        Node n1 = new Node("5,5;2;0,0;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(n1, sp.MoveLeft(n));
    }
    @Test
    public void MoveRightTest()
    {
        Node n = new Node("5,5;2;0,3;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        Node n1 = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(n1, sp.MoveRight(n));
    }
    @Test
    public void MoveRightBorderTest()
    {
        Node n = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        Node n1 = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(n1, sp.MoveRight(n));
    }
    @Test
    public void CanKillTest()
    {
        Node n = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(false, sp.CanKill(n));
    }

    @Test
    public void CanKillTest1()
    {
        Node n = new Node("5,5;2;0,1;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(true, sp.CanKill(n));
    }

    @Test
    public void CanKillTest2()
    {
        Node n = new Node("5,5;2;1,1;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(true, sp.CanKill(n));
    }

    @Test
    public void CarryTest()
    {
        Node actual = new Node("5,5;2;0,0;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        Node expected = new Node("5,5;1;0,0;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;3,0,80,4,4,80;30",
                0);
        assertEquals(expected, s.CarryHostage(actual));
    }
    @Test
    public void CanCarryTest()
    {
        Node n = new Node("5,5;2;1,0;4,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);

        assertEquals(false, sp.CanCarryHostage(n));
    }

    @Test
    public void CanCarryTest1()
    {
        Node n = new Node("5,5;2;0,0;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);

        assertEquals(true, sp.CanCarryHostage(n));
    }

    @Test
    public void CanCarryTest2()
    {
        Node n = new Node("5,5;2;3,0;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);

        assertEquals(true, sp.CanCarryHostage(n));
    }

    @Test
    public void CanTakePillTest()
    {
        Node n = new Node("5,5;2;1,0;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);

        assertEquals(true, sp.CanTakePill(n));
    }
    @Test
    public void CanTakePillTest1()
    {
        Node n = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);

        assertEquals(false, sp.CanTakePill(n));
    }

    @Test
    public void CanTakePillTest2()
    {
        Node n = new Node("5,5;2;2,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);

        assertEquals(true, sp.CanTakePill(n));
    }

    @Test
    public void CanDropTest()
    {
        Node n = new Node("5,5;2;1,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80;80",
                0);
        assertEquals(true, sp.CanDropHostage(n));
    }

    @Test
    public void CanDropTest1()
    {
        Node n = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;",
                0);
        assertEquals(false, sp.CanDropHostage(n));
    }


    @Test
    public void TakePillTest()
    {
        Node expected =  new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,10,3,0,60,4,4,60",
                50);
        Node actual =  new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                70);
        int ExpectedDamage=expected.getDamage();
        assertEquals(expected,s.TakePill(actual));
        assertEquals(ExpectedDamage,s.TakePill(actual).getDamage());
    }

    @Test
    public void CheckGoalTest()
    {
        Node n = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(null, n.TakenActions);
    }

    @Test
    public void CanFlyTest()
    {
        Node n = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(false, sp.CanFly(n));
    }

    @Test
    public void CanFlyTest1()
    {
        Node n = new Node("5,5;2;0,3;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(true, sp.CanFly(n));
    }

    @Test
    public void CanFlyTest2()
    {
        Node n = new Node("5,5;2;4,3;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(true, sp.CanFly(n));
    }

    @Test
    public void UpdateStateTest() {
        Node n = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        Node n1 = new Node("5,5;2;1,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(n1.GridString, sp.UpdateNeoPos(n.GridString,"1,4",2,3));
    }

    @Test
    public void UpdateTimeStepTest() {
        Node actual = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        Node expected = new Node("5,5;2;1,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,32,3,0,82,4,4,82",
                0);
        assertEquals(expected, sp.UpdateTimeStep(actual));
    }
    @Test
    public void UpdateTimeStepTest2() {
        Node actual = new Node("5,5;2;1,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;;12,18,100",
                0);
        Node expected = new Node("5,5;2;1,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;;14,20,100",
                0);
        assertEquals(expected, sp.UpdateTimeStep(actual));
    }
    @Test
    public void UpdateTimeStepTest3() {
        Node actual = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;12",
                0);
        Node expected = new Node("5,5;2;1,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,32,3,0,82,4,4,82;14",
                0);
        assertEquals(expected, sp.UpdateTimeStep(actual));
    }
}