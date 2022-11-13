public class Percolation {
    public static void main(String args[]){

        int sideLength = 90;
        double chance = .25;

        model m = new model(sideLength, chance);
        view v = new view(sideLength, m.colorArray);

        m.percolate();
        v.updateView(m.colorArray);
    }
}
