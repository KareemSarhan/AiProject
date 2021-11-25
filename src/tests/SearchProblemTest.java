package tests;

import code.Actions;
import code.Node;
import code.SearchProblem;
import org.junit.Test;
import java.util.*;


import java.util.Vector;

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
        Node actual = new Node("5,5;2;1,3;1,4;0,1,1,2,2,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;12",
                20);
        Vector<Node> expectedArr = new Vector<Node>();
        //Move up
        Node expectedUp = new Node("5,5;2;0,3;1,4;0,1,1,2,2,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;12",
                20);
        expectedUp.ConcatAction(Actions.UP);
        expectedArr.add(expectedUp);
        //Move Down
        Node expectedDown = new Node("5,5;2;2,3;1,4;0,1,1,2,2,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;12",
                20);
        expectedDown.ConcatAction(Actions.DOWN);
        expectedArr.add(expectedDown);
        //Move Right
        Node expectedRight = new Node("5,5;2;1,4;1,4;0,1,1,2,2,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;12",
                20);
        expectedRight.ConcatAction(Actions.RIGHT);
        expectedArr.add(expectedRight);
        //Move Left
        Node expectedLeft = new Node("5,5;2;1,2;1,4;0,1,1,2,2,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;12",
                20);
        expectedLeft.ConcatAction(Actions.LEFT);
        expectedArr.add(expectedLeft);
        //Kill
        Node expectedKill = new Node("5,5;2;1,3;1,4;0,1,2,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;12",
                40);
        expectedKill.ConcatAction(Actions.KILL);
        expectedArr.add(expectedKill);
        //Pill
        Node expectedPill = new Node("5,5;2;1,3;1,4;0,1,1,2,2,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,10,3,0,60,4,4,60;0",
                0);
        expectedPill.ConcatAction(Actions.PILL);
        expectedArr.add(expectedPill);
        //Carry Hostage
        Node expectedCarry = new Node("5,5;2;1,3;1,4;0,1,1,2,2,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;12",
                0);
        expectedCarry.ConcatAction(Actions.CARRY);
        expectedArr.add(expectedCarry);
        //Drop Hostage
        Node expectedDrop = new Node("5,5;2;1,3;1,4;0,1,1,2,2,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;12",
                0);
        expectedDrop.ConcatAction(Actions.DROP);
        expectedArr.add(expectedDrop);
        //Fly
        Node expectedFly = new Node("5,5;2;1,3;1,4;0,1,1,2,2,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;12",
                0);
        expectedFly.ConcatAction(Actions.FLY);
        expectedArr.add(expectedFly);

        assertEquals(expectedArr , sp.TakeAction(actual));
    }
    @Test
    public void TakeActionTest1()
    {
        Node actual = new Node("5,5;2;1,3;2,1;1,2,0,3;2,3;1,3,4,3,4,3,1,3;1,4,30;",
                20);
        Vector<Node> expectedArr = new Vector<Node>();
        
        //Move Down for a pill
        Node expectedDown = new Node("5,5;2;2,3;2,1;1,2,0,3;2,3;1,3,4,3,4,3,1,3;1,4,32;",
                20);
        expectedDown.ConcatAction(Actions.DOWN);
        expectedArr.add(expectedDown);
            
               //Move Right for a hostage
               Node expectedRight = new Node("5,5;2;1,4;2,1;1,2,0,3;2,3;1,3,4,3,4,3,1,3;1,4,32;",
               20);
       expectedRight.ConcatAction(Actions.RIGHT);
       expectedArr.add(expectedRight);

    //Kill
    Node expectedKill = new Node("5,5;2;1,3;2,1;;2,3;1,3,4,3,4,3,1,3;1,4,32;",
    40);
expectedKill.ConcatAction(Actions.KILL);
expectedArr.add(expectedKill);

        //Fly
        Node expectedFly = new Node("5,5;2;4,3;2,1;1,2,0,3;2,3;1,3,4,3,4,3,1,3;1,4,32;",
        20);
        expectedFly.ConcatAction(Actions.FLY);
        expectedArr.add(expectedFly);
        
    

        assertEquals(expectedArr , sp.TakeAction(actual));
    }

    @Test
    public void TakeActionTest4()
    {
        Node actual = new Node("5,5;2;1,3;2,1;1,2,0,3;2,3;1,3,4,3,4,3,1,3;1,4,30;",
                20);
        Vector<Node> expectedArr = new Vector<Node>();
        
        //Move Down for a pill
        Node expectedDown = new Node("5,5;2;2,3;2,1;1,2,0,3;2,3;1,3,4,3,4,3,1,3;1,4,32;",
                20);
        expectedDown.ConcatAction(Actions.DOWN);
        expectedArr.add(expectedDown);
            
               //Move Right for a hostage
               Node expectedRight = new Node("5,5;2;1,4;2,1;1,2,0,3;2,3;1,3,4,3,4,3,1,3;1,4,32;",
               20);
       expectedRight.ConcatAction(Actions.RIGHT);
       expectedArr.add(expectedRight);

    //Kill
    Node expectedKill = new Node("5,5;2;1,3;2,1;;2,3;1,3,4,3,4,3,1,3;1,4,32;",
    40);
expectedKill.ConcatAction(Actions.KILL);
expectedArr.add(expectedKill);

        //Fly
        Node expectedFly = new Node("5,5;2;4,3;2,1;1,2,0,3;2,3;1,3,4,3,4,3,1,3;1,4,32;",
        20);
        expectedFly.ConcatAction(Actions.FLY);
        expectedArr.add(expectedFly);
        
    

        assertEquals(expectedArr , sp.TakeAction(actual));
    }

    @Test
    public void TakeActionTest2()
    {
        Node actual = new Node("5,5;2;2,2;4,4;0,0,1,0,4,0,0,4,3,4;2,2,3,1,1,4;1,2,4,2,4,2,1,2;0,2,80,1,3,20,2,3,10;",
                20);
        Vector<Node> expectedArr = new Vector<Node>();
        //Move up
        Node expectedUp = new Node("5,5;2;1,2;4,4;0,0,1,0,4,0,0,4,3,4;2,2,3,1,1,4;1,2,4,2,4,2,1,2;0,2,82,1,3,22,2,3,12;",
                20);
        expectedUp.ConcatAction(Actions.UP);
        expectedArr.add(expectedUp);
        //Move Down
        Node expectedDown = new Node("5,5;2;3,2;4,4;0,0,1,0,4,0,0,4,3,4;2,2,3,1,1,4;1,2,4,2,4,2,1,2;0,2,82,1,3,22,2,3,12;",
                20);
        expectedDown.ConcatAction(Actions.DOWN);
        expectedArr.add(expectedDown);
        //Move Right
        Node expectedRight = new Node("5,5;2;2,3;4,4;0,0,1,0,4,0,0,4,3,4;2,2,3,1,1,4;1,2,4,2,4,2,1,2;0,2,82,1,3,22,2,3,12;",
                20);
        expectedRight.ConcatAction(Actions.RIGHT);
        expectedArr.add(expectedRight);
        //Move Left
        Node expectedLeft = new Node("5,5;2;2,1;4,4;0,0,1,0,4,0,0,4,3,4;2,2,3,1,1,4;1,2,4,2,4,2,1,2;0,2,82,1,3,22,2,3,12;",
                20);
        expectedLeft.ConcatAction(Actions.LEFT);
        expectedArr.add(expectedLeft);
        //Kill
        Node expectedKill = new Node("5,5;2;2,2;4,4;0,0,1,0,4,0,0,4,3,4;2,2,3,1,1,4;1,2,4,2,4,2,1,2;0,2,80,1,3,20,2,3,10;",
                20);
        expectedKill.ConcatAction(Actions.KILL);
        //expectedArr.add(expectedKill);
        //Pill
        Node expectedPill = new Node("5,5;2;2,2;4,4;0,0,1,0,4,0,0,4,3,4;2,2,3,1,1,4;1,2,4,2,4,2,1,2;0,2,60,1,3,0,2,3,0;",
                0);
        expectedPill.ConcatAction(Actions.PILL);
        expectedArr.add(expectedPill);
        //Carry Hostage
        Node expectedCarry = new Node("5,5;2;2,2;4,4;0,0,1,0,4,0,0,4,3,4;2,2,3,1,1,4;1,2,4,2,4,2,1,2;0,2,80,1,3,20,2,3,10;",
                20);
        expectedCarry.ConcatAction(Actions.CARRY);
        //expectedArr.add(expectedCarry);
        //Drop Hostage
        Node expectedDrop = new Node("5,5;2;2,2;4,4;0,0,1,0,4,0,0,4,3,4;2,2,3,1,1,4;1,2,4,2,4,2,1,2;0,2,80,1,3,20,2,3,10;",
                20);
        expectedDrop.ConcatAction(Actions.DROP);
        //expectedArr.add(expectedDrop);

        assertEquals(expectedArr , sp.TakeAction(actual));

    }

    @Test
    public void TakeActionTest3()
    {
        Node actual = new Node("5,5;2;3,1;3,4;0,0,1,3,2,1,3,3;4,1;0,2,3,2,3,2,0,2;3,0,10,3,1,30;",
                20);
        Vector<Node> expectedArr = new Vector<Node>();
        //Move up
        Node expectedUp = new Node("5,5;2;2,1;3,4;0,0,1,3,2,1,3,3;4,1;0,2,3,2,3,2,0,2;3,0,12,3,1,32;",
                20);
        expectedUp.ConcatAction(Actions.UP);
        //expectedArr.add(expectedUp);
        //Move Down
        Node expectedDown = new Node("5,5;2;4,1;3,4;0,0,1,3,2,1,3,3;4,1;0,2,3,2,3,2,0,2;3,0,12,3,1,32;",
                20);
        expectedDown.ConcatAction(Actions.DOWN);
        expectedArr.add(expectedDown);
        //Move Right
        Node expectedRight = new Node("5,5;2;3,2;3,4;0,0,1,3,2,1,3,3;4,1;0,2,3,2,3,2,0,2;3,0,12,3,1,32;",
                20);
        expectedRight.ConcatAction(Actions.RIGHT);
        expectedArr.add(expectedRight);
        //Move Left
        Node expectedLeft = new Node("5,5;2;3,0;3,4;0,0,1,3,2,1,3,3;4,1;0,2,3,2,3,2,0,2;3,0,12,3,1,32;",
                20);
        expectedLeft.ConcatAction(Actions.LEFT);
        expectedArr.add(expectedLeft);
        //Kill
        Node expectedKill = new Node("5,5;2;3,1;3,4;0,0,1,3,3,3;4,1;0,2,3,2,3,2,0,2;3,0,12,3,1,32;",
                40);
        expectedKill.ConcatAction(Actions.KILL);
        expectedArr.add(expectedKill);
        //Pill
        Node expectedPill = new Node("5,5;2;3,1;3,4;0,0,1,3,2,1,3,3;4,1;0,2,3,2,3,2,0,2;3,0,0,3,1,10;",
                0);
        expectedPill.ConcatAction(Actions.PILL);
        //expectedArr.add(expectedPill);
        //Carry Hostage
        Node expectedCarry = new Node("5,5;1;3,1;3,4;0,0,1,3,2,1,3,3;4,1;0,2,3,2,3,2,0,2;3,0,12;32",
                20);
        expectedCarry.ConcatAction(Actions.CARRY);
        expectedArr.add(expectedCarry);
        //Drop Hostage
        Node expectedDrop = new Node("5,5;2;2,2;4,4;0,0,1,0,4,0,0,4,3,4;2,2,3,1,1,4;1,2,4,2,4,2,1,2;0,2,80,1,3,20,2,3,10;",
                20);
        expectedDrop.ConcatAction(Actions.DROP);
        //expectedArr.add(expectedDrop);

        assertEquals(expectedArr , sp.TakeAction(actual));

    }

    @Test
    public void CanMoveUpTest(){
        Node n = new Node("5,5;2;4,1;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(false, sp.CanMoveUp(n));
    }

    @Test
    public void CanMoveUpTest1(){
        Node n = new Node("5,5;2;4,0;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(true, sp.CanMoveUp(n));
    }

    @Test
    public void CanMoveUpTest2(){
        Node n = new Node("5,5;2;0,0;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(false, sp.CanMoveUp(n));
    }

    @Test
    public void CanMoveUpTest3(){
        Node n = new Node("5,5;2;4,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,3,4,100",
                0);
        assertEquals(false, sp.CanMoveUp(n));
    }

    @Test
    public void MoveUpTest()
    {
        Node n = new Node("5,5;2;1,4;0,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;",
            0);
        Node n1 = new Node("5,5;2;0,4;0,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;",
                0);
        n1.ConcatAction(Actions.UP);
        assertEquals(n1, sp.MoveUp(n));
    }
    @Test
    public void MoveUpBorderTest()
    {
        Node n = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;",
                0);
        Node n1 = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;",
                0);
        n1.ConcatAction(Actions.UP);

        assertEquals(n1, sp.MoveUp(n));
    }

    @Test
    public void CanMoveDownTest(){
        Node n = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(true, sp.CanMoveDown(n));
    }

    @Test
    public void CanMoveDownTest1(){
        Node n = new Node("5,5;2;2,3;1,4;0,1,1,1,2,2,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(false, sp.CanMoveDown(n));
    }

    @Test
    public void CanMoveDownTest2(){
        Node n = new Node("5,5;2;4,3;1,4;0,1,1,1,2,2,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(false, sp.CanMoveDown(n));
    }

    @Test
    public void CanMoveDownTest3(){
        Node n = new Node("5,5;2;3,4;1,4;0,1,1,1,2,2,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,100",
                0);
        assertEquals(false, sp.CanMoveDown(n));
    }

    @Test
    public void MoveDownTest()
    {
        Node n = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;",
                0);
        Node n2 = new Node("5,5;2;1,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;",
                0);
        n2.ConcatAction(Actions.DOWN);
        assertEquals(n2, sp.MoveDown(n));
//        assertEquals(n2.TakenActions,sp.MoveDown(n).TakenActions );
//        assertEquals(n2.Damage,sp.MoveDown(n).Damage );
    }
    @Test
    public void MoveDownBorderTest()
    {
        Node n = new Node("5,5;2;4,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;",
                0);
        Node n1 = new Node("5,5;2;4,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;",
                0);
        n1.ConcatAction(Actions.DOWN);
        assertEquals(n1,sp.MoveDown(n) );
    }

    @Test
    public void CanMoveLeftTest(){
        Node n = new Node("5,5;2;4,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(true,sp.CanMoveLeft(n));
    }

    @Test
    public void CanMoveLeftTest1(){
        Node n = new Node("5,5;2;3,2;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(false,sp.CanMoveLeft(n));
    }

    @Test
    public void CanMoveLeftTest2(){
        Node n = new Node("5,5;2;4,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,3,100",
                0);
        assertEquals(false,sp.CanMoveLeft(n));
    }

    @Test
    public void CanMoveLeftTest3(){
        Node n = new Node("5,5;2;1,0;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,3,100",
                0);
        assertEquals(false,sp.CanMoveLeft(n));
    }

    @Test
    public void CanMoveLeftTest4(){
        Node n = new Node("5,5;2;1,3;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,3,100",
                0);
        assertEquals(true,sp.CanMoveLeft(n));
    }

    @Test
    public void CanMoveLeftTest5(){
        Node actual = new Node("5,5;2;1,3;1,4;0,1,1,2,2,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;12",
                20);
        assertEquals(false, sp.CanMoveLeft(actual));
    }

    @Test
    public void MoveLeftTest()
    {
        Node n = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;",
                0);
        Node n1 = new Node("5,5;2;0,3;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;",
                0);
        n1.ConcatAction(Actions.LEFT);

        assertEquals(n1, sp.MoveLeft(n));
    }
    @Test
    public void MoveLeftBorderTest()
    {
        Node n = new Node("5,5;2;0,0;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;",
                0);
        Node n1 = new Node("5,5;2;0,0;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;",
                0);
        n1.ConcatAction(Actions.LEFT);
        assertEquals(n1, sp.MoveLeft(n));
    }

    @Test
    public void CanMoveRightTest(){
        Node n = new Node("5,5;2;0,0;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(false,sp.CanMoveRight(n));
    }

    @Test
    public void CanMoveRightTest1(){
        Node n = new Node("5,5;2;0,2;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(true,sp.CanMoveRight(n));
    }

    @Test
    public void CanMoveRightTest2(){
        Node n = new Node("5,5;2;4,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,100",
                0);
        assertEquals(false,sp.CanMoveRight(n));
    }

    @Test
    public void CanMoveRightTest3(){
        Node n = new Node("5,5;2;2,3;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,100",
                0);
        assertEquals(true,sp.CanMoveRight(n));
    }

    @Test
    public void CanMoveRightTest4(){
        Node n = new Node("5,5;2;4,3;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,100",
                0);
        assertEquals(false,sp.CanMoveRight(n));
    }


    @Test
    public void MoveRightTest()
    {
        Node n = new Node("5,5;2;0,3;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;",
                0);
        Node n1 = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;",
                0);
        n1.ConcatAction(Actions.RIGHT);
        assertEquals(n1, sp.MoveRight(n));
    }
    @Test
    public void MoveRightBorderTest()
    {
        Node n = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;",
                0);
        Node n1 = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;",
                0);
        n1.ConcatAction(Actions.RIGHT);
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
    public void CanKillTest3()
    {
        Node n = new Node("5,5;2;1,1;1,4;5,5,2,2,4,4,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,1,2,100",
                0);
        assertEquals(true, sp.CanKill(n));
    }
    //2 Agents to be killed
    @Test
    public void KillTest()
    {
        Node expected=new Node("5,5;2;0,0;1,4;2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;",
                20);
        Node n = new Node("5,5;2;0,0;1,4;0,1,1,0,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;'",
                0);
        expected.ConcatAction(Actions.KILL);
        assertEquals(expected, sp.Kill(n));
    }

    //2 Agents to be killed and 2 Mutants
    @Test
    public void KillTest2()
    {
        Node expected=new Node("5,5;2;0,0;1,4;2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;4,4,80;",
                20);
        Node n = new Node("5,5;2;0,0;1,4;0,1,1,0,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,1,100,1,0,100,4,4,80;",
                0);
        expected.ConcatAction(Actions.KILL);
        assertEquals(expected, sp.Kill(n));
    }
    //2 Mutants to be killed.
    @Test
    public void KillTest3()
    {
        Node expected=new Node("5,5;2;0,0;1,4;5,1,1,3,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;4,4,80;",
                20);
        Node n = new Node("5,5;2;0,0;1,4;5,1,1,3,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,1,100,1,0,100,4,4,80;",
                0);
        expected.ConcatAction(Actions.KILL);
        assertEquals(expected, sp.Kill(n));
    }


    @Test
    public void CarryTest()
    {
        Node actual = new Node("5,5;2;0,0;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,1,80,4,2,90;",
                0);
        Node expected = new Node("5,5;1;0,0;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;3,1,80,4,2,90;30;",
                0);
        expected.ConcatAction(Actions.CARRY);
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
    public void CanDropTest2()
    {
        Node actual = new Node("5,5;2;1,3;1,4;0,1,1,2,2,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;12",
                20);
        assertEquals(false, sp.CanDropHostage(actual));
    }

    @Test
    public void CanDropTest3()
    {
        Node actual = new Node("5,5;2;1,4;1,4;0,1,1,2,2,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;",
                20);
        assertEquals(false, sp.CanDropHostage(actual));
    }

    @Test
    public void TakePillTest()
    {
        Node expected =  new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,10,3,0,60,4,4,60;",
                50);
        Node actual =  new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80;",
                70);
        expected.ConcatAction(Actions.PILL);
        assertEquals(expected,s.TakePill(actual));
//        assertEquals(expected.getDamage(),s.TakePill(actual).getDamage());
    }


    @Test
    public void DropHostageTest()
    {
        Node Actual = new Node("5,5;2;4,3;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;4,3,0,3,0,3,4,3;0,0,30,3,0,80,4,4,80;3,3,2,4,1",
                0);
        Node Expected=new Node("5,5;7;4,3;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;4,3,0,3,0,3,4,3;0,0,30,3,0,80,4,4,80;",
        0);
        Expected.ConcatAction(Actions.DROP);
        assertEquals(Expected, sp.DropHostage(Actual));
    }

    @Test
    public void DropHostageTest1()
    {
        Node Actual = new Node("5,5;2;4,3;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;4,3,0,3,0,3,4,3;0,0,30,3,0,80,4,4,80;3,3,2,4,1,4,9,5,8",
                0);
        Node Expected=new Node("5,5;11;4,3;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;4,3,0,3,0,3,4,3;0,0,30,3,0,80,4,4,80;",
        0);
        Expected.ConcatAction(Actions.DROP);
        assertEquals(Expected, sp.DropHostage(Actual));
    }

    @Test
    //yng7
    public void CheckGoalTest()
    {
        Node actual = new Node("5,5;2;1,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;4,3,0,3,0,3,4,3;;",
                0);
        assertEquals(true, s.CheckGoal(actual));
    }
    @Test
    //fail neo not at the telephone booth and there are no hostages carried nor in the grid
    public void CheckGoalTest1()
    {
        Node actual = new Node("5,5;2;4,3;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;4,3,0,3,0,3,4,3;;",
                0);
        assertEquals(false, s.CheckGoal(actual));
    }
    @Test
    //fail Still Carried Hostages but at the telephone booth and no hostages in the grid.
    public void CheckGoalTest2()
    {
        Node actual = new Node("5,5;2;1,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;4,3,0,3,0,3,4,3;;",
                0);
        assertEquals(false, s.CheckGoal(actual));
    } @Test
    //fail Still  Hostages in the grid and neo at the telephone booth
    public void CheckGoalTest3() {
        Node actual = new Node("5,5;2;1,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80;",
                0);
        assertEquals(false, s.CheckGoal(actual));
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
    public void FlyTest()
    {
        Node Actual = new Node("5,5;2;4,3;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;4,3,0,3,0,3,4,3;0,0,30,3,0,80,4,4,80",
                0);
        Node Expected= new Node("5,5;2;0,3;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;4,3,0,3,0,3,4,3;0,0,30,3,0,80,4,4,80",
        0);
        assertEquals(Expected, sp.Fly(Actual));
    }

    @Test
    public void FlyTest1()
    {
        Node Actual = new Node("5,5;2;0,3;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;4,3,0,3,0,3,4,3;0,0,30,3,0,80,4,4,80",
        0);
        Node Expected= new Node("5,5;2;4,3;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;4,3,0,3,0,3,4,3;0,0,30,3,0,80,4,4,80",
        0);
        assertEquals(Expected, sp.Fly(Actual));
    }

    @Test
    public void UpdateTimeStepTest() {
        Node actual = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,70,4,4,80;",
                0);
        Node expected = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,32,3,0,72,4,4,82;",
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
        Node expected = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,32,3,0,82,4,4,82;14",
                0);
        assertEquals(expected, sp.UpdateTimeStep(actual));
    }
}