import java.util.Random;

public class model {
    
    public int size;
    public int sideLength;
    public double chance;
    public tile[] tileArray;
    public color[] colorArray;

    model(int sideLength, double chance){

        size = sideLength * sideLength;
        this.sideLength = sideLength;
        this.chance = chance;
        this.generateColors();
        this.generateTileArray();

    }

    void generateColors(){
        colorArray = new color[this.size];
        Random rnd = new Random();

        float r, g, b;
        color c;

        for(int i = 0; i < size; i++){
            
            r = rnd.nextFloat((float).25, (float)1);
            g = rnd.nextFloat((float).25, (float)1);
            b = rnd.nextFloat((float).25, (float)1);
            c = new color(r, g, b);
            colorArray[i] = c;
        }
    }

    void generateTileArray(){
        //Create blank tiles
        int index = 0;
        tileArray = new tile[size];
        for(int y = 0; y < sideLength; y++){
            for(int x = 0; x < sideLength; x++){
                tileArray[index] = new tile(x, y, index, chance);
                tileArray[index].c = this.colorArray[index];
                index++;
            }
        }
        //Prep tiles
        index = 0;
        for(int y = 0; y < sideLength; y++){
            for(int x = 0; x < sideLength; x++){
                
                if(x != 0){
                    tileArray[index].tLeft = tileArray[index - 1];
                }
                if(x != sideLength - 1){
                    tileArray[index].tRight = tileArray[index + 1];
                }
                if(y != 0){
                    tileArray[index].tUp = tileArray[index - sideLength];
                }
                if(y != sideLength - 1){
                    tileArray[index].tDown = tileArray[index + sideLength];
                }

                index++;
            }
        }
    }

    void percolate(){
        for(int i = 0; i < size; i++){
            tileArray[i].breakWalls();
            System.out.print(i);
        }
        for(int i = 0; i < size; i++){
            colorArray[i] = tileArray[i].c;
        }
    }

}
