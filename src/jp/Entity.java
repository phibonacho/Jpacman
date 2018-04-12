package jp;


// this class represent the movable item on the grid:
public abstract class Entity {
    enum EntityType{pacman, ghost};
    protected boolean alive=true;
    protected static CellClass[][] map; // map where entity is placed;
    public static void setMap(CellClass[][] m){
        map = m;
    }
    protected int x, y;
    private boolean alive(){
        return alive;
    }

    public abstract void move(int n, int m);

    public void moveDown() {
        move(x+1, y+1);
    }

    public void moveLeft() {
        move(x, y-1);
    }

    public void moveRight() {
        move(x, y+1);
    }

    public void moveUP() {
        move(x-1, y);
    }
    public abstract EntityType getType();
    public abstract char skin();
}
