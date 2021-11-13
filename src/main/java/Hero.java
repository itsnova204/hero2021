import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

public class Hero {
    private int px,py;
    private Position position;

    public Hero(int x, int y){
        position = new Position(10,10);
    }

    public void draw(Screen screen){
        screen.setCharacter(position.getX(), position.getY(), TextCharacter.fromCharacter('X')[0]);
    }

    /*
    public void moveHero(Position position){
       position.setPosition(position);
    }
    */
    public Position moveUp() {
        return new Position(position.getX(),position.getY() - 1);
    }
    public Position moveDown() {
        return new Position(position.getX(), position.getY() + 1);
    }
    public Position moveRight() {
        return new Position(position.getX() + 1,position.getY());
    }
    public Position moveLeft() {
        return new Position(position.getX() - 1,position.getY());
    }


}
