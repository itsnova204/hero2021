import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    Terminal terminal = new DefaultTerminalFactory().createTerminal();
    Screen screen = new TerminalScreen(terminal);
    int x = 10;
    int y = 10;



    public Game() throws IOException {
    }

    public static void run() throws IOException {
        Game g = new Game();

        while (true) {
            draw(g);
            KeyStroke key = g.screen.readInput();
            g.processKey(key,g);

        }
    }

    private static void draw(Game g) throws IOException {
        g.screen.setCursorPosition(null);
        g.screen.startScreen();
        g.screen.doResizeIfNecessary();

        g.screen.clear();
        g.screen.setCharacter(g.x, g.y, TextCharacter.fromCharacter('X')[0]);
        g.screen.refresh();
    }

    private static void processKey(KeyStroke key, Game g) throws IOException {
        KeyType press = key.getKeyType();

        if (key.getKeyType() == KeyType.ArrowUp){
            System.out.println("arrow Up!");
            g.y--;
        }
        if (key.getKeyType() == KeyType.ArrowDown){
            System.out.println("arrow Down!");
            g.y++;
        }
        if (key.getKeyType() == KeyType.ArrowLeft){
            System.out.println("arrow Left!");
            g.x--;
        }
        if (key.getKeyType() == KeyType.ArrowRight){
            System.out.println("arrow Right!");
            g.x++;
        }

        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q'){
            g.screen.close();
        }

        if (key.getKeyType() == KeyType.EOF){
            System.out.println("Screen Closed");
            //idk how to implement this well
        }

    }
}
