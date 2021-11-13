import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private static Screen screen;
    private int x,y;
    private boolean is_on;
    private Hero hero;

    public Game(){
        try {
            Terminal terminal = new
                    DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);   // we don't need a
            screen.startScreen();             // screens must be
            screen.doResizeIfNecessary();     // resize screen

            hero = new Hero(10, 10);

            is_on = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() throws IOException {
        while (is_on) {

            draw();
            KeyStroke key = screen.readInput();
            processKey(key);
        }
    }

    private void moveHero(Position position) {
        hero.setPosition(position);
    }

    private void draw() throws IOException {
        screen.clear();
        hero.draw(screen);
        screen.refresh();
    }

    private void processKey(KeyStroke key) throws IOException {;
        switch (key.getKeyType()){
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
                moveHero(hero.moveLeft());;
                break;
            case ArrowRight:
                System.out.println("arrow Right!");
                moveHero(hero.moveRight());;
                break;
            case Character:
                if (key.getCharacter() == 'q') screen.close();
                break;
            case EOF:
                System.out.println("Screen Closed");
                is_on = false;
            default:
                break;
        }
    }
}
