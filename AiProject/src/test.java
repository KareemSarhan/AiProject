import org.junit.Test;


public class test {
    //This class is used to test the methods in the other classes

    @Test
    public void testNodeConstructor()
    {
        Node n = new Node("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80",
                0);
        assertEquals(1, n.getValue());
    }


}