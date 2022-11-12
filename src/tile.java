import java.util.Random;

public class tile{
    
    public tile tUp;
    public tile tDown;
    public tile tLeft;
    public tile tRight;

    public boolean wUp;
    public boolean wDown;
    public boolean wLeft;
    public boolean wRight;

    public boolean needsUpdate;

    public int x;
    public int y;
    public int index;
    public color c;

    public int chunkSize;
    public double chance;

    public tile(int x, int y, int index, double chance){
        this.x = x;
        this.y = y;
        this.index = index;
        this.chunkSize = 1;
        this.chance = chance;
        wUp = true;
        wDown = true;
        wLeft = true;
        wRight = true;
    }

    public void breakWalls(){
        Random rnd = new Random();

        if(rnd.nextDouble() < chance && tUp != null){
            wUp = false;
            tUp.wDown = false;
        }
        if(rnd.nextDouble() < chance && tRight != null){
            wRight = false;
            tRight.wLeft = false;
        }
        if(rnd.nextDouble() < chance && tDown != null){
            wDown = false;
            tDown.wUp = false;
        }
        if(rnd.nextDouble() < chance && tLeft != null){
            wLeft = false;
            tLeft.wRight = false;
        }
    }

    public void updateThisChunk(tile inTile){
        
        needsUpdate = false;

        
        if(!wLeft && tLeft != null && inTile != tLeft && tLeft.needsUpdate){
            tLeft.c = this.c;
            tLeft.updateThisChunk(this);
        }
        if(!wRight && tRight != null && inTile != tRight && tRight.needsUpdate){
            tRight.c = this.c;
            tRight.updateThisChunk(this);
        }
        if(!wUp && tUp != null && inTile != tUp && tUp.needsUpdate){
            tUp.c = this.c;
            tUp.updateThisChunk(this);
        }
        if(!wDown && tDown != null && inTile != tDown && tDown.needsUpdate){
            tDown.c = this.c;
            tDown.updateThisChunk(this);
        }

        needsUpdate = true;
    }

}