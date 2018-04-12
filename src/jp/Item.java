package jp;

public class Item {
    private int points;

    public Item(int n){
        points = n;
    }

    public int points(){
        if(points!=0) {
            int tmp = points;
            points = 0;
            return tmp;
        }
        else {
            return points;
        }
    }

    public char getSkin(){
        switch(points){
            case 10:
                return '*';
            case 50:
                return 'o';
            case 100:
                return '@';
            default:
                return' ';
        }
    }
}
