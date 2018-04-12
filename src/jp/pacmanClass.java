package jp;

public class pacmanClass extends Entity {
    private int gainedPoints;
    private boolean powered;
    private char skin = '<';
    public synchronized void move(int n, int m) {
        // check for new position: (player must know grid dimension)
        try {
            // find information about new position:
            if(map[n][m].isWalkable()) {
                CorridorClass prevC = (CorridorClass)map[x][y];
                CorridorClass tmpC = (CorridorClass) map[n][m];
                if (tmpC.isOccupied()) {
                    Entity enemy = tmpC.getOccupier();
                    if (powered) {
                        enemy.alive = false;
                    } else {
                        alive = false;
                    }
                }
                // consume item if one:
                consume(tmpC);

                // update informations about position:
                x = n;
                y = m;
                prevC.setOccupier(null);
                tmpC.setOccupier(this);
            }
            else{
                return;
            }

        }catch (IndexOutOfBoundsException oobE) {
            // you reach the end of the map
        }
    }

    @Override
    public void moveDown() {
        super.moveDown();
        skin = '^';
    }

    public void moveLeft() {
        super.moveLeft();
        skin = '>';
    }

    public void moveRight() {
        super.moveRight();
        skin = '<';
    }

    public void moveUP() {
        super.moveUP();
        skin = 'v';
    }

    public EntityType getType() {
        return EntityType.pacman;
    }

    private void consume(CorridorClass c) {
        int points = c.consumable.points();
        if(points<100) gainedPoints+=points;
        else{
            powered = true;
        }
    }

    public boolean isPowered(){
        return powered;
    }

    @Override
    public char skin() {
        return skin;
    }
}
