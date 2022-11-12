public class Percolation2 {
    public static void main(String args[]){
        controller c = new controller(90, .2);
        c.percolate();
        c.updateViewToMatchModel();
    }
}
