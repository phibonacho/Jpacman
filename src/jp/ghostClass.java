package jp;

public class ghostClass extends Entity {
    public synchronized void move(int n, int m) {
        // check for new position: (player must know grid dimension)
        try {
            // find information about new position:

            if(map[n][m].isWalkable()) {
                CorridorClass prevC = (CorridorClass)map[x][y];
                CorridorClass tmpC = (CorridorClass) map[n][m];
                if (tmpC.isOccupied()) {
                    Entity enemy = tmpC.getOccupier();
                    // check if other entity is friendly
                    if (enemy.getType() == EntityType.ghost) {
                        // just a ghost pal, let's chill
                        return;
                    } else {
                        // that stupid pacman:
                        pacmanClass pac = (pacmanClass)enemy;
                        // verify that it's not powered:
                        if (pac.isPowered())
                            alive = false;
                        else
                            pac.alive = false;
                    }
                }
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

    public EntityType getType() {
        return EntityType.ghost;
    }

    @Override
    public char skin() {
        return 'M';
    }
}
