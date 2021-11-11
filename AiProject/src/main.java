public class main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Matrix.");
        //System.out.println(Matrix.genGrid());
        Matrix.Visualize("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80");
        Matrix.solve("5,5;2;0,4;1,4;0,1,1,1,2,1,3,1,3,3,3,4;1,0,2,4;0,3,4,3,4,3,0,3;0,0,30,3,0,80,4,4,80","BF",false);
    }
}
