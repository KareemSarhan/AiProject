package tests;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import code.Matrix;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class OurTestMatrixPublic {

    String grid0 = "5,5;2;3,4;1,2;0,3,1,4;2,3;4,4,0,2,0,2,4,4;2,2,91,2,4,62";
    String grid1 = "5,5;1;1,4;1,0;0,4;0,0,2,2;3,4,4,2,4,2,3,4;0,2,32,0,1,38";
    String grid2 = "5,5;2;3,2;0,1;4,1;0,3;1,2,4,2,4,2,1,2,0,4,3,0,3,0,0,4;1,1,77,3,4,34";
    String grid3 = "5,5;1;0,4;4,4;0,3,1,4,2,1,3,0,4,1;4,0;2,4,3,4,3,4,2,4;0,2,98,1,2,98,2,2,98,3,2,98,4,2,98,2,0,1";
    String grid4 = "5,5;1;0,4;4,4;0,3,1,4,2,1,3,0,4,1;4,0;2,4,3,4,3,4,2,4;0,2,98,1,2,98,2,2,98,3,2,98,4,2,98,2,0,98,1,0,98";
    String grid5 = "5,5;2;0,4;3,4;3,1,1,1;2,3;3,0,0,1,0,1,3,0;4,2,54,4,0,85,1,0,43";
    String grid6 = "5,5;2;3,0;4,3;2,1,2,2,3,1,0,0,1,1,4,2,3,3,1,3,0,1;2,4,3,2,3,4,0,4;4,4,4,0,4,0,4,4;1,4,57,2,0,46";
    String grid7 = "5,5;3;1,3;4,0;0,1,3,2,4,3,2,4,0,4;3,4,3,0,4,2;1,4,1,2,1,2,1,4,0,3,1,0,1,0,0,3;4,4,45,3,3,12,0,2,88";
    String grid8 = "5,5;2;4,3;2,1;2,0,0,4,0,3,0,1;3,1,3,2;4,4,3,3,3,3,4,4;4,0,17,1,2,54,0,0,46,4,1,22";
    String grid9 = "5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80";
    String grid10 = "5,5;4;1,1;4,1;2,4,0,4,3,2,3,0,4,2,0,1,1,3,2,1;4,0,4,4,1,0;2,0,0,2,0,2,2,0;0,0,62,4,3,45,3,3,39,2,3,40";


    @Test(timeout = 10000)
    public void testBF0() {
        String solution = Matrix.solve(grid0, "BF", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid0, solution));
    }

    @Test(timeout = 10000)
    public void testBF1() {
        String solution = Matrix.solve(grid1, "BF", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid1, solution));
    }

    @Test(timeout = 10000)
    public void testBF2() {
        String solution = Matrix.solve(grid2, "BF", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid2, solution));
    }

    @Test(timeout = 10000)
    public void testBF3() {
        String solution = Matrix.solve(grid3, "BF", false);
        solution = solution.replace(" ", "");

        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid3, solution));
    }

    @Test(timeout = 10000)
    public void testBF4() {
        String solution = Matrix.solve(grid4, "BF", false);
        assertEquals("The output actions do not lead to a goal state.", "No Solution", solution);
    }

    @Test(timeout = 10000)
    public void testBF5() {
        String solution = Matrix.solve(grid5, "BF", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid5, solution));
    }

    @Test(timeout = 10000)
    public void testBF6() {
        String solution = Matrix.solve(grid6, "BF", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid6, solution));
    }

    @Test(timeout = 30000)
    public void testBF7() {
        String solution = Matrix.solve(grid7, "BF", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid7, solution));
    }

    @Test(timeout = 30000)
    public void testBF8() {
        String solution = Matrix.solve(grid8, "BF", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid8, solution));
    }

    @Test(timeout = 30000)
    public void testBF9() {
        String solution = Matrix.solve(grid9, "BF", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid9, solution));
    }

    @Test(timeout = 60000)
    public void testBFz10() {
        String solution = Matrix.solve(grid10, "BF", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid10, solution));
    }

    @Test(timeout = 10000)
    public void testDF0() {
        String solution = Matrix.solve(grid0, "DF", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid0, solution));
    }

    @Test(timeout = 10000)
    public void testDF1() {
        String solution = Matrix.solve(grid1, "DF", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid1, solution));
    }

    @Test(timeout = 10000)
    public void testDF2() {
        String solution = Matrix.solve(grid2, "DF", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid2, solution));
    }

    @Test(timeout = 10000)
    public void testDF3() {
        String solution = Matrix.solve(grid3, "DF", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid3, solution));
    }

    @Test(timeout = 10000)
    public void testDF4() {
        String solution = Matrix.solve(grid4, "DF", false);
        assertEquals("The output actions do not lead to a goal state.", "No Solution", solution);
    }

    @Test(timeout = 10000)
    public void testDF5() {
        String solution = Matrix.solve(grid5, "DF", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid5, solution));
    }

    @Test(timeout = 10000)
    public void testDF6() {
        String solution = Matrix.solve(grid6, "DF", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid6, solution));
    }

    @Test(timeout = 30000)
    public void testDF7() {
        String solution = Matrix.solve(grid7, "DF", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.",applyPlan(grid7, solution) );
    }

    @Test(timeout = 30000)
    public void testDF8() {
        String solution = Matrix.solve(grid8, "DF", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.",applyPlan(grid8, solution));
    }

    @Test(timeout = 30000)
    public void testDF9() {
        String solution = Matrix.solve(grid9, "DF", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid9, solution));
    }

    @Test(timeout = 60000)
    public void testDFz10() {
        String solution = Matrix.solve(grid10, "DF", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid10, solution));
    }

    @Test(timeout = 10000)
    public void testUC0() {
        String solution = Matrix.solve(grid0, "UC", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid0, solution));
    }

    @Test(timeout = 10000)
    public void testUC1() {
        String solution = Matrix.solve(grid1, "UC", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid1, solution));
    }

    @Test(timeout = 10000)
    public void testUC2() {
        String solution = Matrix.solve(grid2, "UC", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid2, solution));
    }

    @Test(timeout = 10000)
    public void testUC3() {
        String solution = Matrix.solve(grid3, "UC", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid3, solution));
    }


    @Test(timeout = 10000)
    public void testUC4() {
        String solution = Matrix.solve(grid4, "UC", false);
        assertEquals("The output actions do not lead to a goal state.", "No Solution", solution);
    }

    @Test(timeout = 10000)
    public void testUC5() {
        String solution = Matrix.solve(grid5, "UC", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid5, solution));
    }

    @Test(timeout = 30000)
    public void testUC6() {
        String solution = Matrix.solve(grid6, "UC", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid6, solution));
    }

    @Test(timeout = 400000)
    public void testUC7() {
        String solution = Matrix.solve(grid7, "UC", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.",  applyPlan(grid7, solution));
    }

    @Test(timeout = 400000)
    public void testUC8() {
        String solution = Matrix.solve(grid8, "UC", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid8, solution));
    }

    @Test(timeout = 400000)
    public void testUC9() {
        String solution = Matrix.solve(grid9, "UC", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid9, solution));
    }
    @Test(timeout = 400000)
    public void testUCz10() {
        String solution = Matrix.solve(grid10, "UC", true);
        solution = solution.replace(" ", "");
        System.out.println(solution);
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid10, solution));
    }

    @Test(timeout = 10000)
    public void testID0() {
        String solution = Matrix.solve(grid0, "ID", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid0, solution));
    }

    @Test(timeout = 10000)
    public void testID1() {
        String solution = Matrix.solve(grid1, "ID", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid1, solution));
    }

    @Test(timeout = 10000)
    public void testID2() {
        String solution = Matrix.solve(grid2, "ID", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid2, solution));
    }

    @Test(timeout = 10000)
    public void testID3() {
        String solution = Matrix.solve(grid3, "ID", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid3, solution));
    }
    @Ignore
    @Test(timeout = 1)
    public void testID4() {
        String solution = Matrix.solve(grid4, "ID", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid4, solution));
    }

    @Test(timeout = 10000)
    public void testID5() {
        String solution = Matrix.solve(grid5, "ID", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid5, solution));
    }

    @Test(timeout = 10000)
    public void testID6() {
        String solution = Matrix.solve(grid6, "ID", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid6, solution));
    }
    @Ignore
    @Test(timeout = 1)
    public void testID7() {
        String solution = Matrix.solve(grid7, "ID", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid7, solution));
    }
    @Ignore
    @Test(timeout = 1)
    public void testID8() {
        String solution = Matrix.solve(grid8, "ID", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid8, solution));
    }
    @Ignore
    @Test(timeout = 1)
    public void testID9() {
        String solution = Matrix.solve(grid9, "ID", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid9, solution));
    }
    @Test(timeout = 40000)
    public void testIDz10() {
        String solution = Matrix.solve(grid10, "ID", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid10, solution));
    }

    @Test(timeout = 10000)
    public void test1GR0() {
        String solution = Matrix.solve(grid0, "GR1", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid0, solution));
    }

    @Test(timeout = 10000)
    public void test1GR1() {
        String solution = Matrix.solve(grid1, "GR1", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid1, solution));
    }

    @Test(timeout = 10000)
    public void test1GR2() {
        String solution = Matrix.solve(grid2, "GR1", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid2, solution));
    }

    @Test(timeout = 40000)
    public void test1GR3() {
        String solution = Matrix.solve(grid3, "GR1", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid3, solution));
    }

    @Test(timeout = 10000)
    public void test1GR4() {
        String solution = Matrix.solve(grid4, "GR1", false);
        assertEquals("The output actions do not lead to a goal state.", "No Solution", solution);
    }

    @Test(timeout = 10000)
    public void test1GR5() {
        String solution = Matrix.solve(grid5, "GR1", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid5, solution));
    }

    @Test(timeout = 30000)
    public void test1GR6() {
        String solution = Matrix.solve(grid6, "GR1", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid6, solution));
    }

    @Test(timeout = 400000)
    public void test1GR7() {
        String solution = Matrix.solve(grid7, "GR1", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid7, solution));
    }

    @Test(timeout = 400000)
    public void test1GR8() {
        String solution = Matrix.solve(grid8, "GR1", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid8, solution));
    }

    @Test(timeout = 400000)
    public void test1GR9() {
        String solution = Matrix.solve(grid9, "GR1", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid9, solution));
    }
    @Test(timeout = 400000)
    public void test1GRz10() {
        String solution = Matrix.solve(grid10, "GR1", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid10, solution));
    }

    @Test(timeout = 10000)
    public void test2GR0() {
        String solution = Matrix.solve(grid0, "GR2", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid0, solution));
    }

    @Test(timeout = 10000)
    public void test2GR1() {
        String solution = Matrix.solve(grid1, "GR2", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid1, solution));
    }

    @Test(timeout = 10000)
    public void test2GR2() {
        String solution = Matrix.solve(grid2, "GR2", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid2, solution));
    }

    @Test(timeout = 10000)
    public void test2GR3() {
        String solution = Matrix.solve(grid3, "GR2", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid3, solution));
    }

    @Test(timeout = 10000)
    public void test2GR4() {
        String solution = Matrix.solve(grid4, "GR2", false);
        assertEquals("The output actions do not lead to a goal state.", "No Solution", solution);
    }

    @Test(timeout = 10000)
    public void test2GR5() {
        String solution = Matrix.solve(grid5, "GR2", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid5, solution));
    }

    @Test(timeout = 30000)
    public void test2GR6() {
        String solution = Matrix.solve(grid6, "GR2", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid6, solution));
    }

    @Test(timeout = 400000)
    public void test2GR7() {
        String solution = Matrix.solve(grid7, "GR2", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid7, solution));
    }

    @Test(timeout = 400000)
    public void test2GR8() {
        String solution = Matrix.solve(grid8, "GR2", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid8, solution));
    }

    @Test(timeout = 400000)
    public void test2GR9() {
        String solution = Matrix.solve(grid9, "GR2", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid9, solution));
    }

    @Test(timeout = 100000)
    public void test2GRz10() {
        String solution = Matrix.solve(grid10, "GR2", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid10, solution));
    }
    @Test(timeout = 10000)
    public void test1AS0() {
        String solution = Matrix.solve(grid0, "AS1", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid0, solution));
    }

    @Test(timeout = 10000)
    public void test1AS1() {
        String solution = Matrix.solve(grid1, "AS1", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid1, solution));
    }

    @Test(timeout = 10000)
    public void test1AS2() {
        String solution = Matrix.solve(grid2, "AS1", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid2, solution));
    }

    @Test(timeout = 10000)
    public void test1AS3() {
        String solution = Matrix.solve(grid3, "AS1", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid3, solution));
    }

    @Test(timeout = 10000)
    public void test1AS4() {
        String solution = Matrix.solve(grid4, "AS1", false);
        assertEquals("The output actions do not lead to a goal state.", "No Solution", solution);
    }

    @Test(timeout = 10000)
    public void test1AS5() {
        String solution = Matrix.solve(grid5, "AS1", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid5, solution));
    }

    @Test(timeout = 30000)
    public void test1AS6() {
        String solution = Matrix.solve(grid6, "AS1", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid6, solution));
    }

    @Test(timeout = 400000)
    public void test1AS7() {
        String solution = Matrix.solve(grid7, "AS1", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid7, solution));
    }

    @Test(timeout = 400000)
    public void test1AS8() {
        String solution = Matrix.solve(grid8, "AS1", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid8, solution));
    }

    @Test(timeout = 400000)
    public void test1AS9() {
        String solution = Matrix.solve(grid9, "AS1", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid9, solution));
    }

    @Test(timeout = 400000)
    public void test1ASz10() {
        String solution = Matrix.solve(grid10, "AS1", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid10, solution));
    }


    @Test(timeout = 10000)
    public void test2AS0() {
        String solution = Matrix.solve(grid0, "AS2", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid0, solution));
    }

    @Test(timeout = 10000)
    public void test2AS1() {
        String solution = Matrix.solve(grid1, "AS2", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid1, solution));
    }

    @Test(timeout = 10000)
    public void test2AS2() {
        String solution = Matrix.solve(grid2, "AS2", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid2, solution));
    }

    @Test(timeout = 10000)
    public void test2AS3() {
        String solution = Matrix.solve(grid3, "AS2", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid3, solution));
    }

    @Test(timeout = 10000)
    public void test2AS4() {
        String solution = Matrix.solve(grid4, "AS2", false);
        assertEquals("The output actions do not lead to a goal state.", "No Solution", solution);
    }

    @Test(timeout = 10000)
    public void test2AS5() {
        String solution = Matrix.solve(grid5, "AS2", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid5, solution));
    }

    @Test(timeout = 30000)
    public void test2AS6() {
        String solution = Matrix.solve(grid6, "AS2", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid6, solution));
    }

    @Test(timeout = 400000)
    public void test2AS7() {
        String solution = Matrix.solve(grid7, "AS2", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid7, solution));
    }

    @Test(timeout = 400000)
    public void test2AS8() {
        String solution = Matrix.solve(grid8, "AS2", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid8, solution));
    }

    @Test(timeout = 400000)
    public void test2AS9() {
        String solution = Matrix.solve(grid9, "AS2", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid9, solution));
    }

    @Test(timeout = 400000)
    public void test2ASz10() {
        String solution = Matrix.solve(grid10, "AS2", false);
        solution = solution.replace(" ", "");
        assertTrue("The output actions do not lead to a goal state.", applyPlan(grid10, solution));
    }


    static class TH {
        int m;
        int n;
        int TBX;
        int TBY;
        int NeoX;
        int NeoY;
        int CarryLimit;
        int CarriedCount;
        int NeoDMG;
        ArrayList<String> AgentsArrList;
        ArrayList<String> AgentHostages;
        ArrayList<String> PillArrList;
        HashMap<String,String> Pads;
        HashMap<String,Integer> HostagesAndDmgs;
        HashMap<String,Integer> CarriedHostages;
        ArrayList<String> DeadHostages;
        int CurrentKilled;
        boolean NeoDead;

        public TH(int m, int n, int TBX, int TBY, int NeoX, int NeoY, int CarryLimit,
                  ArrayList<String> AgentsArrList, ArrayList<String> PillArrList,
                  HashMap<String, String> PadsHashMap, HashMap<String, Integer> HostagesDmgsHashMap) {
            //m,n,TBX,TBY,NeoX, NeoY,CarryLimit, AgentsArrList,PillArrList,PadsHashMap,HostagesDmgsHashMap
            this.m = m;
            this.n = n;
            this.TBX = TBX;
            this.TBY = TBY;
            this.NeoX = NeoX;
            this.NeoY = NeoY;
            this.CarryLimit = CarryLimit;
            this.CarriedCount = 0;
            this.NeoDMG = 0;
            this.AgentsArrList = AgentsArrList;
            this.AgentHostages = new ArrayList<>();
            this.PillArrList = PillArrList;
            this.Pads = PadsHashMap;
            this.HostagesAndDmgs = HostagesDmgsHashMap;
            this.CarriedHostages = new HashMap<>();
            this.DeadHostages = new ArrayList<>();
            this.CurrentKilled = 0;
            this.NeoDead = false;
        }

        public String CellString(int x, int y) {
            return x+","+y;
        }

        public boolean IsNotOutsideBounds(int x, int y) {
            return x >= 0 && x <= m && y >= 0 && y <= n;
        }

        public ArrayList<String> GetSurroundingCells(int x, int y) {
            ArrayList<String> result = new ArrayList<>();
            if(IsNotOutsideBounds(x-1,y))
                result.add((x-1)+","+y);
            if(IsNotOutsideBounds(x+1,y))
                result.add((x+1)+","+y);
            if(IsNotOutsideBounds(x,y-1))
                result.add(x+","+(y-1));
            if(IsNotOutsideBounds(x,y+1))
                result.add(x+","+(y+1));
            return result;
        }

        public boolean CheckIfAgentInCell(int x, int y) {
            String CellString = CellString(x,y);
            return this.AgentsArrList.contains(CellString) || this.AgentHostages.contains(CellString)
                    || (this.HostagesAndDmgs.containsKey(CellString) && this.HostagesAndDmgs.get(CellString) > 97);
        }

        public boolean MoveUp() {
            if(CheckIfAgentInCell(NeoX - 1, NeoY)) return false;
            if(NeoX - 1 >= 0)
                NeoX--;
            updateTimeStep();
            return true;
        }

        public boolean MoveDown() {
            if(CheckIfAgentInCell(NeoX + 1, NeoY)) return false;
            if(NeoX + 1 < this.m)
                NeoX++;
            updateTimeStep();
            return true;

        }

        public boolean MoveLeft() {
            if(CheckIfAgentInCell(NeoX, NeoY - 1)) return false;
            if(NeoY - 1 >= 0)
                NeoY--;
            updateTimeStep();
            return true;

        }

        public boolean MoveRight() {
            if(CheckIfAgentInCell(NeoX, NeoY + 1)) return false;
            if(NeoY + 1 < this.n)
                NeoY++;
            updateTimeStep();
            return true;
        }

        public boolean Kill() {
            ArrayList<String> SurroundingCells = GetSurroundingCells(NeoX, NeoY);
            if(SurroundingCells.size()>0) {
                for(String Cell:SurroundingCells) {
                    if(AgentsArrList.contains(Cell)) {
                        AgentsArrList.remove(Cell);
                        this.CurrentKilled++;
                    }
                    if(AgentHostages.contains(Cell)) {
                        AgentHostages.remove(Cell);
                        this.CurrentKilled++;
                    }
                }
                NeoDMG +=20;
                if(NeoDMG == 100)
                    NeoDead = true;

                updateTimeStep();
                return true;
            }
            return false;

        }

        public boolean CarryHostage() {
            String cellString = CellString(NeoX, NeoY);
            if(CarriedCount <= CarryLimit) {
                if(HostagesAndDmgs.containsKey(cellString)) {
                    CarriedCount++;
                    CarriedHostages.put(cellString, HostagesAndDmgs.get(cellString));
                    HostagesAndDmgs.remove(cellString);
                    updateTimeStep();
                    return true;
                }
            }

            return false;
        }

        public boolean Drop() {
            if(NeoX == TBX && NeoY == TBY && CarriedCount >0) {
                CarriedCount = 0;
                CarriedHostages.clear();
                updateTimeStep();
                return true;
            }
            return false;
        }

        public boolean Fly() {
            String Cell = CellString(NeoX, NeoY);
            if(this.Pads.containsKey(Cell)) {
                String toPad = this.Pads.get(Cell);
                String [] toPadArr = toPad.split(",");
                NeoX = Integer.parseInt(toPadArr[0]);
                NeoY = Integer.parseInt(toPadArr[1]);
                updateTimeStep();
                return true;
            }
            return false;

        }

        public boolean takePill() {
            if(this.PillArrList.contains(CellString(NeoX, NeoY))) {
                NeoDMG = Math.max(NeoDMG - 20, 0);
                for(String abc: HostagesAndDmgs.keySet()) {
                    int beatles = Math.max(HostagesAndDmgs.get(abc) - 20, 0);
                    HostagesAndDmgs.put(abc,beatles);
                }
                for(String abc: CarriedHostages.keySet()) {
                    if(CarriedHostages.get(abc)<100) {
                        int beatles = Math.max(CarriedHostages.get(abc) - 20, 0);
                        CarriedHostages.put(abc,beatles);
                    }
                }
                this.PillArrList.remove(CellString(NeoX, NeoY));
                return true;
            }
            return false;
        }

        public void updateTimeStep() {

            HashMap<String,Integer> RemHostages = new HashMap<>();

            for(String Carried: CarriedHostages.keySet()) {
                int newDmg = CarriedHostages.get(Carried)+2;
                if(newDmg >= 100)  {
                    this.AddDeadHostage(Carried);
                    CarriedHostages.put(Carried,100);
                }
                else
                    CarriedHostages.put(Carried,newDmg);
            }

            for(String hostage: HostagesAndDmgs.keySet()) {
                int newDmg = HostagesAndDmgs.get(hostage)+2;
                if(newDmg >= 100) {
                    this.AddDeadHostage(hostage);
                    AgentHostages.add(hostage);
                }
                else
                    RemHostages.put(hostage,newDmg);
            }
            this.HostagesAndDmgs = RemHostages;
        }

        public void AddDeadHostage(String killed) {
            if(!this.DeadHostages.contains(killed))
                this.DeadHostages.add(killed);
        }

        public boolean GoalTest() {
            return !this.NeoDead && this.NeoDMG <100 && this.HostagesAndDmgs.size() == 0
                    && this.AgentHostages.size() == 0 && this.NeoX == this.TBX
                    && this.NeoY == this.TBY;
        }
    }


    public static boolean applyPlan(String grid, String solution) {
        String[] solutionArray  = solution.split(";");
        String plan = solutionArray[0];
        plan = plan.replace(" ", "");
        plan = plan.replace("\n", "");
        plan = plan.replace("\r", "");
        plan = plan.replace("\n\r", "");
        plan = plan.replace("\t", "");
        int DeadHostages = Integer.parseInt(solutionArray[1]);
        int Killed = Integer.parseInt(solutionArray[2]);

        String[] TakenActions = plan.split(",");
        String[] gridArray=  grid.split(";");
        String[] dimensions = gridArray[0].split(",");
        int m = Integer.parseInt(dimensions[0]);
        int n = Integer.parseInt(dimensions[1]);

        int CarryLimit = Integer.parseInt(gridArray[1]);

        String[] neo = gridArray[2].split(",");
        int NeoX = Integer.parseInt(neo[0]);
        int NeoY = Integer.parseInt(neo[1]);

        String[] booth = gridArray[3].split(",");
        int TBX = Integer.parseInt(booth[0]);
        int TBY = Integer.parseInt(booth[1]);

        String[] Agents = gridArray[4].split(",");
        ArrayList<String> AgentsArrList = new ArrayList<>();
        for(int i = 0;i< Agents.length -1; i+=2) {
            AgentsArrList.add(Agents[i]+","+Agents[i+1]);
        }

        String[] Pills = gridArray[5].split(",");
        ArrayList<String> PillArrList = new ArrayList<>();
        for(int i = 0;i< Pills.length -1; i+=2) {
            PillArrList.add(Pills[i]+","+Pills[i+1]);
        }

        String[] Pads = gridArray[6].split(",");
        HashMap<String,String> PadsHashMap = new HashMap<>();
        for(int i = 0;i< Pads.length -3; i+=4) {
            PadsHashMap.put(Pads[i]+","+Pads[i+1],Pads[i+2]+","+Pads[i+3]);
        }

        String[] Hostages = gridArray[7].split(",");
        HashMap<String,Integer> HostagesDmgsHashMap = new HashMap<>();
        for(int i = 0;i< Hostages.length -2; i+=3) {
            HostagesDmgsHashMap.put(Hostages[i]+","+Hostages[i+1],Integer.parseInt(Hostages[i+2]));
        }

        TH s = new TH(m,n,TBX,TBY,NeoX, NeoY, CarryLimit, AgentsArrList,PillArrList,PadsHashMap,HostagesDmgsHashMap);
        boolean AllGood;

        for (String action : TakenActions) {

            switch (action) {
                case "up":
                    AllGood = s.MoveUp();
                    break;
                case "down":
                    AllGood = s.MoveDown();
                    break;
                case "right":
                    AllGood = s.MoveRight();
                    break;
                case "left":
                    AllGood = s.MoveLeft();
                    break;
                case "carry":
                    AllGood = s.CarryHostage();
                    break;
                case "drop":
                    AllGood = s.Drop();
                    break;
                case "fly":
                    AllGood = s.Fly();
                    break;
                case "takePill":
                    AllGood = s.takePill();
                    break;
                case "kill":
                    AllGood = s.Kill();
                    break;
                default:
                    AllGood = false;
                    break;

            }

            if (!AllGood)
                return false;


        }
        return s.GoalTest() && s.DeadHostages.size() == DeadHostages && s.CurrentKilled == Killed ;
    }
}
