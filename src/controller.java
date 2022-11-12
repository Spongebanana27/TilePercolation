public class controller {

    model m;
    view v;

    controller(int sideLength, double chance){

        m = new model(sideLength, chance);
        v = new view(sideLength, m.colorArray);
        
    }

    void percolate(){
        m.percolate();
    }

    void updateViewToMatchModel(){
        v.updateView(m.colorArray);
    }
}
