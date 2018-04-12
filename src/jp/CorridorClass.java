package jp;

public class CorridorClass extends CellClass {
    private Entity occupier;
    protected Item consumable;

    @Override
    public boolean isWalkable() {
        return true;
    }

    public boolean isOccupied(){
        return occupier!=null;
    }

    public Entity getOccupier() {
        return occupier;
    }

    public void setOccupier(Entity o){
        occupier = o;
    }

    @Override
    public char skin() {
        if(isOccupied())
            return occupier.skin();
        else
            return consumable.getSkin();
    }
}
