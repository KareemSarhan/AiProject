package tests;

import code.Actions;
import code.Matrix;
import code.Node;
import code.GenericSearchProblem;
import org.junit.Test;


import java.util.Vector;

import static code.GenericSearchProblem.*;
import static org.junit.Assert.*;

public class SearchProblemTest {
    Matrix matrix = new Matrix();
    String grid0 = "5,5;2;4,3;2,1;2,0,0,4,0,3,0,1;3,1,3,2;4,4,3,3,3,3,4,4;4,0,17,1,2,54,0,0,46,4,1,22";
    String grid1 = "5,5;1;1,4;1,0;0,4;0,0,2,2;3,4,4,2,4,2,3,4;0,2,32,0,1,38";
    String grid2 = "8,8;1;2,4;5,3;0,4,1,4,3,0,7,7,5,6;0,1,1,3;4,4,3,1,3,1,4,4,0,7,7,0,7,0,0,7;0,2,28,4,0,30,5,5,5";
    String grid3 = "6,6;2;2,4;2,2;0,4,1,4,3,0,4,2;0,1,1,3;4,4,3,1,3,1,4,4;0,0,94,1,2,38,4,1,76,4,0,80";
    String grid4 = "7,7;3;0,0;0,6;0,3,0,4,2,3,4,5,6,6,5,4;0,2,4,3;2,0,0,5,0,5,2,0;1,0,83,2,5,38,6,4,66,2,6,20";
    String grid5 = "5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80";
    String grid6 = "6,6;2;2,2;2,4;0,1,1,0,3,0,4,1,4,3,3,4,1,4,0,3;0,2;1,3,4,2,4,2,1,3;0,0,2,0,4,2,4,0,2,4,4,98,1,1,98";
    String grid7 = "7,7;4;3,3;0,2;0,1,1,0,1,1,1,2,2,0,2,2,2,4,2,6,1,4;5,5,5,0;5,1,2,5,2,5,5,1;0,0,98,3,2,98,4,4,98,0,3,98,0,4,98,0,5,98,5,4,98";
    String grid8 = "7,7;4;5,3;2,5;0,0,0,2,0,6,2,3,5,1;1,1,2,6,6,0;4,0,1,6,1,6,4,0;0,4,33,1,4,1,4,3,11,5,4,2,5,5,69,3,1,95";
    String grid9 = "7,7;3;4,3;3,2;1,0,1,1,1,3,2,5,5,3,5,5;4,2,2,6,6,2,4,4;1,4,6,4,6,4,1,4,4,0,6,6,6,6,4,0,6,0,0,6,0,6,6,0;0,2,98,1,5,26,3,3,70,6,3,90,6,5,32";
    String grid10 = "6,6;1;2,2;2,4;0,1,1,0,3,0,4,1,4,3,3,4,1,4,0,3,1,5;0,2;1,3,4,2,4,2,1,3;0,5,90,1,2,92,4,4,2,5,5,1,1,1,98";
    String grid11 = "9,9;2;8,0;3,5;0,1,0,3,1,0,1,1,1,2,0,7,1,8,3,8,6,1,6,5;0,6,2,8;8,1,4,5,4,5,8,1;0,0,95,0,2,98,0,8,94,2,5,13,2,6,39";

    @Test
    public void getSubStringTest() {
        String s1 = "5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80";
        String s2 = "5,5";
        assertEquals(s2, GetSubString(s1, 0, 1));
    }

    @Test
    public void getSubStringTest2() {
        String s1 = "5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80";
        String s2 = "2";
        assertEquals(s2, GetSubString(s1, 1, 2));
    }

    @Test
    public void getSubStringTest3() {
        String s1 = "5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80";
        String s2 = "1,4";
        assertEquals(s2, GetSubString(s1, 3, 4));
    }

    @Test
    public void getNeoPositionTest() {
        String ActualGrid = "5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80";
        String NeoPosition = "0,4";
        assertEquals(NeoPosition, GetNeoPosition(ActualGrid));
    }

    @Test
    public void getNeoPositionTest2() {
        String ActualGrid = "5,5;2;0,40;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80";
        String NeoPosition = "0,40";
        assertEquals(NeoPosition, GetNeoPosition(ActualGrid));
    }

    @Test
    public void getGridSizeTest() {
        String ActualGrid = "5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80";
        String ExpectedResult = "5,5";
        assertEquals(ExpectedResult, GetGridSize(ActualGrid));
    }

    @Test
    public void getGridSizeTest2() {
        String ActualGrid = "5,50;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80";
        String ExpectedResult = "5,50";
        assertEquals(ExpectedResult, GetGridSize(ActualGrid));
    }

    @Test
    public void NodeDamageTest() {
        Node n = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(0, n.getDamage());
    }

    @Test
    public void NodeDamageTest1() {
        Node n = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                10);
        assertEquals(10, n.getDamage());
    }

    @Test
    public void TakeActionCansTest() {
        Node actual = new Node("5,5;2;1,3;1,4;0,1,1,2,2,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;12",
                20);
        Node expectedNode = actual.clone();
        Vector<Node> expectedArr = new Vector<Node>();
        //Move up
        Node expectedUp = new Node("5,5;2;0,3;1,4;0,1,1,2,2,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;12",
                20);
        expectedUp.ConcatAction(Actions.up);
        expectedArr.add(expectedUp);
        //Move Down
        Node expectedDown = new Node("5,5;2;2,3;1,4;0,1,1,2,2,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;12",
                20);
        expectedDown.ConcatAction(Actions.down);
        expectedArr.add(expectedDown);
        //Move Right
        Node expectedRight = new Node("5,5;2;1,4;1,4;0,1,1,2,2,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;12",
                20);
        expectedRight.ConcatAction(Actions.right);
        expectedArr.add(expectedRight);
        //Move Left
        Node expectedLeft = new Node("5,5;2;1,2;1,4;0,1,1,2,2,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;12",
                20);
        expectedLeft.ConcatAction(Actions.left);
        expectedArr.add(expectedLeft);
        //Kill
        Node expectedKill = new Node("5,5;2;1,3;1,4;0,1,2,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;12",
                40);
        expectedKill.ConcatAction(Actions.kill);
        expectedArr.add(expectedKill);
        //Pill
        Node expectedPill = new Node("5,5;2;1,3;1,4;0,1,1,2,2,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,10,3,0,60,4,4,60;0",
                0);
        expectedPill.ConcatAction(Actions.takePill);
        expectedArr.add(expectedPill);
        //Carry Hostage
        Node expectedCarry = new Node("5,5;2;1,3;1,4;0,1,1,2,2,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;12",
                0);
        expectedCarry.ConcatAction(Actions.carry);
        expectedArr.add(expectedCarry);
        //Drop Hostage
        Node expectedDrop = new Node("5,5;2;1,3;1,4;0,1,1,2,2,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;12",
                0);
        expectedDrop.ConcatAction(Actions.drop);
        expectedArr.add(expectedDrop);
        //Fly
        Node expectedFly = new Node("5,5;2;1,3;1,4;0,1,1,2,2,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;12",
                0);
        expectedFly.ConcatAction(Actions.fly);
        expectedArr.add(expectedFly);

        assertEquals(expectedNode,actual);
    }

    @Test
    public void TakeActionTest1() {
        Node actual = new Node("5,5;2;1,3;2,1;1,2,0,3;2,3;1,3,4,3,4,3,1,3;1,4,30;",
                20);
        Vector<Node> expectedArr = new Vector<Node>();

        //Move Down for a pill
        Node expectedDown = new Node("5,5;2;2,3;2,1;1,2,0,3;2,3;1,3,4,3,4,3,1,3;1,4,32;",
                20);
        expectedDown.ConcatAction(Actions.down);
        expectedArr.add(expectedDown);

        //Move Right for a hostage
        Node expectedRight = new Node("5,5;2;1,4;2,1;1,2,0,3;2,3;1,3,4,3,4,3,1,3;1,4,32;",
                20);
        expectedRight.ConcatAction(Actions.right);
        expectedArr.add(expectedRight);

        //Kill
        Node expectedKill = new Node("5,5;2;1,3;2,1;;2,3;1,3,4,3,4,3,1,3;1,4,32;",
                40);
        expectedKill.ConcatAction(Actions.kill);
        expectedKill.CountDeadAgents=2;
        expectedArr.add(expectedKill);

        //Fly
        Node expectedFly = new Node("5,5;2;4,3;2,1;1,2,0,3;2,3;1,3,4,3,4,3,1,3;1,4,32;",
                20);
        expectedFly.ConcatAction(Actions.fly);
        expectedArr.add(expectedFly);


        assertEquals(expectedArr, TakeAction(actual));
    }

    @Test
    public void TakeActionsTest2() {
        // size;carry;neo;TB;agents;pills;pads;hostages,damage;
        Node actual = new Node("5,5;2;1,3;1,3;2,3;1,2;0,3,4,3,4,3,0,3;;30",
                20);
        Vector<Node> expectedArr = new Vector<Node>();

        //Move up
        Node expectedUp = new Node("5,5;2;0,3;1,3;2,3;1,2;0,3,4,3,4,3,0,3;;32",
                20);
        expectedUp.ConcatAction(Actions.up);
        expectedArr.add(expectedUp);

        //Move Right for a hostage
        Node expectedRight = new Node("5,5;2;1,4;1,3;2,3;1,2;0,3,4,3,4,3,0,3;;32",
                20);
        expectedRight.ConcatAction(Actions.right);
        expectedArr.add(expectedRight);

        //Move Left
        Node expectedLeft = new Node("5,5;2;1,2;1,3;2,3;1,2;0,3,4,3,4,3,0,3;;32",
                20);
        expectedLeft.ConcatAction(Actions.left);
        expectedArr.add(expectedLeft);

        //Kill
        Node expectedKill = new Node("5,5;2;1,3;1,3;;1,2;0,3,4,3,4,3,0,3;;32",
                40);
        expectedKill.ConcatAction(Actions.kill);
        expectedKill.CountDeadAgents=1;
        expectedArr.add(expectedKill);

        //Drop Hostage
        Node expectedDrop = new Node("5,5;3;1,3;1,3;2,3;1,2;0,3,4,3,4,3,0,3;;",
                20);
        expectedDrop.ConcatAction(Actions.drop);
        expectedArr.add(expectedDrop);

        assertEquals(expectedArr, TakeAction(actual));
    }

    @Test
    public void TakeActionsTest3() {
        Node actual = new Node("5,5;2;2,2;4,4;0,0,1,0,4,0,0,4,3,4;2,2,3,1,1,4;1,2,4,2,4,2,1,2;0,2,80,1,3,20,2,3,10;",
                20);
        Vector<Node> expectedArr = new Vector<Node>();
        //Move up
        Node expectedUp = new Node("5,5;2;1,2;4,4;0,0,1,0,4,0,0,4,3,4;2,2,3,1,1,4;1,2,4,2,4,2,1,2;0,2,82,1,3,22,2,3,12;",
                20);
        expectedUp.ConcatAction(Actions.up);
        expectedArr.add(expectedUp);
        //Move Down
        Node expectedDown = new Node("5,5;2;3,2;4,4;0,0,1,0,4,0,0,4,3,4;2,2,3,1,1,4;1,2,4,2,4,2,1,2;0,2,82,1,3,22,2,3,12;",
                20);
        expectedDown.ConcatAction(Actions.down);
        expectedArr.add(expectedDown);
        //Move Right
        Node expectedRight = new Node("5,5;2;2,3;4,4;0,0,1,0,4,0,0,4,3,4;2,2,3,1,1,4;1,2,4,2,4,2,1,2;0,2,82,1,3,22,2,3,12;",
                20);
        expectedRight.ConcatAction(Actions.right);
        expectedArr.add(expectedRight);
        //Move Left
        Node expectedLeft = new Node("5,5;2;2,1;4,4;0,0,1,0,4,0,0,4,3,4;2,2,3,1,1,4;1,2,4,2,4,2,1,2;0,2,82,1,3,22,2,3,12;",
                20);
        expectedLeft.ConcatAction(Actions.left);
        expectedArr.add(expectedLeft);
        //Kill
        Node expectedKill = new Node("5,5;2;2,2;4,4;0,0,1,0,4,0,0,4,3,4;2,2,3,1,1,4;1,2,4,2,4,2,1,2;0,2,80,1,3,20,2,3,10;",
                20);
        expectedKill.ConcatAction(Actions.kill);
        //expectedArr.add(expectedKill);
        //Pill
        Node expectedPill = new Node("5,5;2;2,2;4,4;0,0,1,0,4,0,0,4,3,4;3,1,1,4;1,2,4,2,4,2,1,2;0,2,60,1,3,0,2,3,0;",
                0);
        expectedPill.ConcatAction(Actions.takePill);
        expectedArr.add(expectedPill);
        //Carry Hostage
        Node expectedCarry = new Node("5,5;2;2,2;4,4;0,0,1,0,4,0,0,4,3,4;2,2,3,1,1,4;1,2,4,2,4,2,1,2;0,2,80,1,3,20,2,3,10;",
                20);
        expectedCarry.ConcatAction(Actions.carry);
        //expectedArr.add(expectedCarry);
        //Drop Hostage
        Node expectedDrop = new Node("5,5;2;2,2;4,4;0,0,1,0,4,0,0,4,3,4;2,2,3,1,1,4;1,2,4,2,4,2,1,2;0,2,80,1,3,20,2,3,10;",
                20);
        expectedDrop.ConcatAction(Actions.drop);
        //expectedArr.add(expectedDrop);

        assertEquals(expectedArr, TakeAction(actual));
    }

    @Test
    public void TakeActionsTest4() {
        Node actual = new Node("5,5;2;3,1;3,4;0,0,1,3,2,1,3,3;4,1;0,2,3,2,3,2,0,2;3,0,10,3,1,30;",
                20);
        Vector<Node> expectedArr = new Vector<Node>();
        //Move up
        Node expectedUp = new Node("5,5;2;2,1;3,4;0,0,1,3,2,1,3,3;4,1;0,2,3,2,3,2,0,2;3,0,12,3,1,32;",
                20);
        expectedUp.ConcatAction(Actions.up);
        //expectedArr.add(expectedUp);
        //Move Down
        Node expectedDown = new Node("5,5;2;4,1;3,4;0,0,1,3,2,1,3,3;4,1;0,2,3,2,3,2,0,2;3,0,12,3,1,32;",
                20);
        expectedDown.ConcatAction(Actions.down);
        expectedArr.add(expectedDown);
        //Move Right
        Node expectedRight = new Node("5,5;2;3,2;3,4;0,0,1,3,2,1,3,3;4,1;0,2,3,2,3,2,0,2;3,0,12,3,1,32;",
                20);
        expectedRight.ConcatAction(Actions.right);
        expectedArr.add(expectedRight);
        //Move Left
        Node expectedLeft = new Node("5,5;2;3,0;3,4;0,0,1,3,2,1,3,3;4,1;0,2,3,2,3,2,0,2;3,0,12,3,1,32;",
                20);
        expectedLeft.ConcatAction(Actions.left);
        expectedArr.add(expectedLeft);
        //Kill
        Node expectedKill = new Node("5,5;2;3,1;3,4;0,0,1,3,3,3;4,1;0,2,3,2,3,2,0,2;3,0,12,3,1,32;",
                40);
        expectedKill.ConcatAction(Actions.kill);
        expectedKill.CountDeadAgents = 1;
        expectedArr.add(expectedKill);
        //Pill
        Node expectedPill = new Node("5,5;2;3,1;3,4;0,0,1,3,2,1,3,3;4,1;0,2,3,2,3,2,0,2;3,0,0,3,1,10;",
                0);
        expectedPill.ConcatAction(Actions.takePill);
        //expectedArr.add(expectedPill);
        //Carry Hostage
        Node expectedCarry = new Node("5,5;1;3,1;3,4;0,0,1,3,2,1,3,3;4,1;0,2,3,2,3,2,0,2;3,0,12;32",
                20);
        expectedCarry.ConcatAction(Actions.carry);
        expectedArr.add(expectedCarry);
        //Drop Hostage
        Node expectedDrop = new Node("5,5;2;2,2;4,4;0,0,1,0,4,0,0,4,3,4;2,2,3,1,1,4;1,2,4,2,4,2,1,2;0,2,80,1,3,20,2,3,10;",
                20);
        expectedDrop.ConcatAction(Actions.drop);
        //expectedArr.add(expectedDrop);

        assertEquals(expectedArr, TakeAction(actual));
    }

    @Test
    public void TakeActionTest5() {
        Node actual = new Node("5,5;2;2,2;0,0;1,2,2,1,2,3,3,2,4,2;;0,3,4,3,4,3,0,3;0,1,90,2,2,98,1,3,20;",
                20);
        Vector<Node> expectedArr = new Vector<Node>();
        //Move up
        Node expectedUp = new Node("5,5;2;2,2;0,0;1,2,2,1,2,3,3,2;4,2;;0,3,4,3,4,3,0,3;0,1,90,2,2,98,1,3,20;",
                20);
        expectedUp.ConcatAction(Actions.up);
        //expectedArr.add(expectedUp);
        //Move Down
        Node expectedDown = new Node("5,5;2;2,2;0,0;1,2,2,1,2,3,3,2;4,2;;0,3,4,3,4,3,0,3;0,1,90,2,2,98,1,3,20;",
                20);
        expectedDown.ConcatAction(Actions.down);
        //expectedArr.add(expectedDown);
        //Move Right
        Node expectedRight = new Node("5,5;2;2,2;0,0;1,2,2,1,2,3,3,2;4,2;;0,3,4,3,4,3,0,3;0,1,90,2,2,98,1,3,20;",
                20);
        expectedRight.ConcatAction(Actions.right);
        //expectedArr.add(expectedRight);
        //Move Left
        Node expectedLeft = new Node("5,5;2;2,2;0,0;1,2,2,1,2,3,3,2;4,2;;0,3,4,3,4,3,0,3;0,1,90,2,2,98,1,3,20;",
                20);
        //expectedLeft.ConcatAction(Actions.LEFT);
        //expectedArr.add(expectedLeft);
        //Kill
        Node expectedKill = new Node("5,5;2;2,2;0,0;4,2;;0,3,4,3,4,3,0,3;0,1,92,2,2,100,1,3,22;",
                40);
        expectedKill.ConcatAction(Actions.kill);
        expectedKill.CountDeadAgents = 4;
        expectedKill.CountDeadHostages= 1;
        expectedArr.add(expectedKill);
        //Pill
        Node expectedPill = new Node("5,5;2;2,2;0,0;1,2,2,1,2,3,3,2;4,2;;0,3,4,3,4,3,0,3;0,1,90,2,2,98,1,3,20;",
                0);
        expectedPill.ConcatAction(Actions.takePill);
        //expectedArr.add(expectedPill);
        //Carry Hostage
        Node expectedCarry = new Node("5,5;1;2,2;0,0;1,2,2,1,2,3,3,2,4,2;;0,3,4,3,4,3,0,3;0,1,92,1,3,22;100",
                20);
        expectedCarry.ConcatAction(Actions.carry);
        expectedCarry.CountDeadHostages = 1;
        expectedArr.add(expectedCarry);
        //Drop Hostage
        Node expectedDrop = new Node("5,5;2;2,2;4,4;0,0,1,0,4,0,0,4,3,4;2,2,3,1,1,4;1,2,4,2,4,2,1,2;0,2,80,1,3,20,2,3,10;",
                20);
        expectedDrop.ConcatAction(Actions.drop);
        //expectedArr.add(expectedDrop);

        assertEquals(expectedArr, TakeAction(actual));
    }

    @Test
    public void CanMoveUpTest() {
        Node n = new Node("5,5;2;4,1;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(false, CanMoveUp(n));
    }

    @Test
    public void CanMoveUpTest1() {
        Node n = new Node("5,5;2;4,0;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(true, CanMoveUp(n));
    }

    @Test
    public void CanMoveUpTest2() {
        Node n = new Node("5,5;2;0,0;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(false, CanMoveUp(n));
    }

    @Test
    public void CanMoveUpTest3() {
        Node n = new Node("5,5;2;4,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,3,4,100",
                0);
        assertEquals(false, CanMoveUp(n));
    }

    @Test
    public void MoveUpTest() {
        Node n = new Node("5,5;2;1,4;0,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;",
                0);
        Node n1 = new Node("5,5;2;0,4;0,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;",
                0);
        n1.ConcatAction(Actions.up);
        assertEquals(n1, MoveUp(n));
    }

    @Test
    public void MoveUpBorderTest() {
        Node n = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;",
                0);
        Node n1 = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;",
                0);
        n1.ConcatAction(Actions.up);

        assertEquals(n1, MoveUp(n));
    }

    @Test
    public void CanMoveDownTest() {
        Node n = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(true, CanMoveDown(n));
    }

    @Test
    public void CanMoveDownTest1() {
        Node n = new Node("5,5;2;2,3;1,4;0,1,1,1,2,2,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(false, CanMoveDown(n));
    }

    @Test
    public void CanMoveDownTest2() {
        Node n = new Node("5,5;2;4,3;1,4;0,1,1,1,2,2,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(false, CanMoveDown(n));
    }

    @Test
    public void CanMoveDownTest3() {
        Node n = new Node("5,5;2;3,4;1,4;0,1,1,1,2,2,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,100",
                0);
        assertEquals(false, CanMoveDown(n));
    }

    @Test
    public void MoveDownTest() {
        Node n = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;",
                0);
        Node n2 = new Node("5,5;2;1,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;",
                0);
        n2.ConcatAction(Actions.down);
        assertEquals(n2, MoveDown(n));
//        assertEquals(n2.TakenActions,sp.MoveDown(n).TakenActions );
//        assertEquals(n2.Damage,sp.MoveDown(n).Damage );
    }

    @Test
    public void MoveDownBorderTest() {
        Node n = new Node("5,5;2;4,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;",
                0);
        Node n1 = new Node("5,5;2;4,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;",
                0);
        n1.ConcatAction(Actions.down);
        assertEquals(n1, MoveDown(n));
    }

    @Test
    public void CanMoveLeftTest() {
        Node n = new Node("5,5;2;4,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(true, CanMoveLeft(n));
    }

    @Test
    public void CanMoveLeftTest1() {
        Node n = new Node("5,5;2;3,2;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(false, CanMoveLeft(n));
    }

    @Test
    public void CanMoveLeftTest2() {
        Node n = new Node("5,5;2;4,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,3,100",
                0);
        assertEquals(false, CanMoveLeft(n));
    }

    @Test
    public void CanMoveLeftTest3() {
        Node n = new Node("5,5;2;1,0;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,3,100",
                0);
        assertEquals(false, CanMoveLeft(n));
    }

    @Test
    public void CanMoveLeftTest4() {
        Node n = new Node("5,5;2;1,3;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,3,100",
                0);
        assertEquals(true, CanMoveLeft(n));
    }

    @Test
    public void CanMoveLeftTest5() {
        Node actual = new Node("5,5;2;1,3;1,4;0,1,1,2,2,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;12",
                20);
        assertEquals(false, CanMoveLeft(actual));
    }

    @Test
    public void MoveLeftTest() {
        Node n = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;",
                0);
        Node n1 = new Node("5,5;2;0,3;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;",
                0);
        n1.ConcatAction(Actions.left);

        assertEquals(n1, MoveLeft(n));
    }

    @Test
    public void MoveLeftBorderTest() {
        Node n = new Node("5,5;2;0,0;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;",
                0);
        Node n1 = new Node("5,5;2;0,0;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;",
                0);
        n1.ConcatAction(Actions.left);
        assertEquals(n1, MoveLeft(n));
    }

    @Test
    public void CanMoveRightTest() {
        Node n = new Node("5,5;2;0,0;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(false, CanMoveRight(n));
    }

    @Test
    public void CanMoveRightTest1() {
        Node n = new Node("5,5;2;0,2;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(true, CanMoveRight(n));
    }

    @Test
    public void CanMoveRightTest2() {
        Node n = new Node("5,5;2;4,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,100",
                0);
        assertEquals(false, CanMoveRight(n));
    }

    @Test
    public void CanMoveRightTest3() {
        Node n = new Node("5,5;2;2,3;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,100",
                0);
        assertEquals(true, CanMoveRight(n));
    }

    @Test
    public void CanMoveRightTest4() {
        Node n = new Node("5,5;2;4,3;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,100",
                0);
        assertEquals(false, CanMoveRight(n));
    }


    @Test
    public void MoveRightTest() {
        Node n = new Node("5,5;2;0,3;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;",
                0);
        Node n1 = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;",
                0);
        n1.ConcatAction(Actions.right);
        assertEquals(n1, MoveRight(n));
    }

    @Test
    public void MoveRightBorderTest() {
        Node n = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;",
                0);
        Node n1 = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;",
                0);
        n1.ConcatAction(Actions.right);
        assertEquals(n1, MoveRight(n));
    }

    @Test
    public void CanKillTest() {
        Node n = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(false, CanKill(n));
    }

    @Test
    public void CanKillTest1() {
        Node n = new Node("5,5;2;0,1;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(true, CanKill(n));
    }

    @Test
    public void CanKillTest2() {
        Node n = new Node("5,5;2;1,1;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(true, CanKill(n));
    }

    @Test
    public void CanKillTest3() {
        Node n = new Node("5,5;2;1,1;1,4;5,5,2,2,4,4,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,1,2,100",
                0);
        assertEquals(true, CanKill(n));
    }

    //2 Agents to be killed
    @Test
    public void KillTest() {
        Node expected = new Node("5,5;2;1,3;2,1;;2,3;1,3,4,3,4,3,1,3;1,4,30;",
                20);
        Node actual = new Node("5,5;2;1,3;2,1;1,2,0,3;2,3;1,3,4,3,4,3,1,3;1,4,30;",
                0);
        expected.ConcatAction(Actions.kill);
        expected.CountDeadAgents =2;
        assertEquals(expected, Kill(actual));
    }


    //2 Agents to be killed and 2 Mutants
    @Test
    public void KillTest2() {
        Node expected = new Node("5,5;2;0,0;1,4;2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;4,4,80;",
                20);
        Node n = new Node("5,5;2;0,0;1,4;0,1,1,0,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,1,100,1,0,100,4,4,80;",
                0);
        n.CountDeadHostages=2;
        expected.ConcatAction(Actions.kill);
        expected.CountDeadAgents =4;
        expected.CountDeadHostages=2;
        assertEquals(expected, Kill(n));
    }

    //2 Mutants to be killed.
    @Test
    public void KillTest3() {
        Node expected = new Node("5,5;2;0,0;1,4;5,1,1,3,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;4,4,80;",
                20);
        Node n = new Node("5,5;2;0,0;1,4;5,1,1,3,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,1,100,1,0,100,4,4,80;",
                0);
        n.CountDeadHostages=2;
        expected.ConcatAction(Actions.kill);
        expected.CountDeadHostages=2;
        expected.CountDeadAgents=2;
        assertEquals(expected, Kill(n));
    }

    @Test
    public void KillTest22() {
        Node expected = new Node("5,5;2;1,3;2,1;;2,3;1,3,4,3,4,3,1,3;1,4,30;",
                20);
        Node actual = new Node("5,5;2;1,3;2,1;1,2,0,3;2,3;1,3,4,3,4,3,1,3;1,4,30;",
                0);
        expected.ConcatAction(Actions.kill);
        expected.CountDeadAgents = 2;
        assertEquals(expected, Kill(actual));
    }

    @Test
    public void CarryTest() {
        Node actual = new Node("5,5;2;0,0;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,1,80,4,2,90;",
                0);
        Node expected = new Node("5,5;1;0,0;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;3,1,80,4,2,90;30;",
                0);
        expected.ConcatAction(Actions.carry);
        assertEquals(expected, CarryHostage(actual));
    }

    @Test
    public void CanCarryTest() {
        Node n = new Node("5,5;2;1,0;4,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);

        assertEquals(false, CanCarryHostage(n));
    }

    @Test
    public void CanCarryTest1() {
        Node n = new Node("5,5;2;0,0;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);

        assertEquals(true, CanCarryHostage(n));
    }

    @Test
    public void CanCarryTest2() {
        Node n = new Node("5,5;2;3,0;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);

        assertEquals(true, CanCarryHostage(n));
    }

    @Test
    public void CanTakePillTest() {
        Node n = new Node("5,5;2;1,0;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);

        assertEquals(true, CanTakePill(n));
    }

    @Test
    public void CanTakePillTest1() {
        Node n = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);

        assertEquals(false, CanTakePill(n));
    }

    @Test
    public void CanTakePillTest2() {


        Node n = new Node("5,5;2;2,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);

        assertEquals(true, CanTakePill(n));
    }

    @Test
    public void CanDropTest() {
        Node n = new Node("5,5;2;1,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80;80",
                0);
        assertEquals(true, CanDropHostage(n));
    }

    @Test
    public void CanDropTest1() {
        Node n = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;",
                0);
        assertEquals(false, CanDropHostage(n));
    }

    @Test
    public void CanDropTest2() {
        Node actual = new Node("5,5;2;1,3;1,4;0,1,1,2,2,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;12",
                20);
        assertEquals(false, CanDropHostage(actual));
    }

    @Test
    public void CanDropTest3() {
        Node actual = new Node("5,5;2;1,4;1,4;0,1,1,2,2,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;",
                20);
        assertEquals(false, CanDropHostage(actual));
    }

    @Test
    public void TakePillTest() {
        Node expected = new Node("5,5;2;2,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0;0,3,4,3,4,3,0,3;0,0,10,3,0,60,4,4,0;",
                0);
        Node actual = new Node("5,5;2;2,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,0;",
                0);
        expected.ConcatAction(Actions.takePill);
        assertEquals(expected, TakePill(actual));
//        assertEquals(expected.getDamage(),TakePill(actual).getDamage());
    }

    @Test
    public void TakePillTest1() {
        Node expected = new Node("5,5;2;2,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0;0,3,4,3,4,3,0,3;0,0,10,3,0,60,4,4,0;100,10",
                0);
        Node actual = new Node("5,5;2;2,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,0;100,30",
                20);
        expected.ConcatAction(Actions.takePill);
        assertEquals(expected, TakePill(actual));
    }


    @Test
    public void DropHostageTest() {
        Node Actual = new Node("5,5;2;4,3;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;4,3,0,3,0,3,4,3;0,0,30,3,0,80,4,4,80;3,3,2,4,1",
                0);
        Node Expected = new Node("5,5;7;4,3;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;4,3,0,3,0,3,4,3;0,0,30,3,0,80,4,4,80;",
                0);
        Expected.ConcatAction(Actions.drop);
        assertEquals(Expected, DropHostage(Actual));
    }

    @Test
    public void DropHostageTest1() {
        Node Actual = new Node("5,5;2;4,3;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;4,3,0,3,0,3,4,3;0,0,30,3,0,80,4,4,80;3,3,2,4,1,4,9,5,8",
                0);
        Node Expected = new Node("5,5;11;4,3;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;4,3,0,3,0,3,4,3;0,0,30,3,0,80,4,4,80;",
                0);
        Expected.ConcatAction(Actions.drop);
        assertEquals(Expected, DropHostage(Actual));
    }

    @Test
    //yng7
    public void CheckGoalTest() {
        Node actual = new Node("5,5;2;1,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;4,3,0,3,0,3,4,3;;",
                0);
        assertEquals(true, goalTest(actual));
    }

    @Test
    //fail neo not at the telephone booth and there are no hostages carried nor in the grid
    public void CheckGoalTest1() {
        Node actual = new Node("5,5;2;4,3;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;4,3,0,3,0,3,4,3;;",
                0);
        assertEquals(false, goalTest(actual));
    }

    @Test
    //fail Still Carried Hostages but at the telephone booth and no hostages in the grid.
    public void CheckGoalTest2() {
        Node actual = new Node("5,5;2;1,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;4,3,0,3,0,3,4,3;;80",
                0);
        assertEquals(false, goalTest(actual));
    }

    @Test
    //fail Still  Hostages in the grid and neo at the telephone booth
    public void CheckGoalTest3() {
        Node actual = new Node("5,5;2;1,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80;",
                0);
        assertEquals(false, goalTest(actual));
    }

    @Test
    public void CanFlyTest() {
        Node n = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;",
                0);
        assertEquals(false, CanFly(n));
    }

    @Test
    public void CanFlyTest1() {
        Node n = new Node("5,5;2;0,3;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;",
                0);
        assertEquals(true, CanFly(n));
    }

    @Test
    public void CanFlyTest2() {
        Node n = new Node("5,5;2;4,3;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;",
                0);
        assertEquals(true, CanFly(n));
    }

    @Test
    public void FlyTest() {
        Node Actual = new Node("5,5;2;4,3;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;4,3,0,3,0,3,4,3;0,0,30,3,0,80,4,4,80;",
                0);
        Node Expected = new Node("5,5;2;0,3;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;4,3,0,3,0,3,4,3;0,0,30,3,0,80,4,4,80;",
                0);
        Expected.ConcatAction(Actions.fly);
        assertEquals(Expected, Fly(Actual));
    }

    @Test
    public void FlyTest1() {
        Node Actual = new Node("5,5;2;0,3;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;4,3,0,3,0,3,4,3;0,0,30,3,0,80,4,4,80;",
                0);
        Node Expected = new Node("5,5;2;4,3;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;4,3,0,3,0,3,4,3;0,0,30,3,0,80,4,4,80;",
                0);
        Expected.ConcatAction(Actions.fly);
        assertEquals(Expected, Fly(Actual));
    }

    @Test
    public void UpdateTimeStepTest() {
        Node actual = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,70,4,4,80;",
                0);
        Node expected = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,32,3,0,72,4,4,82;",
                0);
        assertEquals(expected, UpdateTimeStep(actual));
    }

    @Test
    public void UpdateTimeStepTest2() {
        Node actual = new Node("5,5;2;1,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;;12,18,100",
                0);
        Node expected = new Node("5,5;2;1,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;;14,20,100",
                0);
        expected.CountDeadHostages=1;
        assertEquals(expected, UpdateTimeStep(actual));
    }

    @Test
    public void UpdateTimeStepTest3() {
        Node actual = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;12",
                0);
        Node expected = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,32,3,0,82,4,4,82;14",
                0);
        assertEquals(expected, UpdateTimeStep(actual));
    }

}