import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Arena {
    private int width;
    private int height;
    private Hero hero;

    public Arena(int width,int height){
        this.width = width;
        this.height = height;

        hero = new Hero(10, 10);
    }

    public void draw(Screen screen) {hero.draw(screen);}

    public void moveHero(Position position) {
        if (canHeroMove(position))
            hero.setPosition(position);
    }

    private Boolean canHeroMove(Position position){
        return position.getX() > 0 && position.getX() < width &&
               position.getY() > 0 && position.getY() < height;
    }

    public void processKey(KeyStroke key){
        switch (key.getKeyType()) {
            case ArrowUp:
                System.out.println("arrow Up!");
                moveHero(hero.moveUp());
                break;
            case ArrowDown:
                System.out.println("arrow Down!");
                moveHero(hero.moveDown());
                break;
            case ArrowLeft:
                System.out.println("arrow Left!");
                moveHero(hero.moveLeft());
                break;
            case ArrowRight:
                System.out.println("arrow Right!");
                moveHero(hero.moveRight());
                break;
            /*case Character:
                if (key.getCharacter() == 'q') screen.close();
                break;
            case EOF:
                System.out.println("Screen Closed");
                is_on = false;*/
            default:
                break;
        }
    }
}
