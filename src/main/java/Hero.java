import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

public class Hero {
    private int px,py;

    public Hero(int x, int y){
        px=x;
        py=y;
    }

    public int getX(){
        return px;
    }
    public int getY(){
        return py;
    }

    public void draw(Screen screen){
        screen.setCharacter(px, py, TextCharacter.fromCharacter('X')[0]);
    }

    public void moveUp(){
        py--;
    }
    public void moveDown(){
        py++;
    }
    public void moveRight(){
        px++;
    }
    public void moveLeft(){
        px--;
    }

}
