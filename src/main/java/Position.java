public class Position {
    private int x,y;

    public Position(int x, int y){
        setX(x);
        setY(y);
    }

    public void setPosition(Position position){
        setX(position.getX());
        setY(position.getY());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
