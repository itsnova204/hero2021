import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    Terminal terminal = new DefaultTerminalFactory().createTerminal();
    Screen screen = new TerminalScreen(terminal);
    private int x = 10;
    private int y = 10;

    public Game() throws IOException {
    }

    public static void run() throws IOException {
        Game g = new Game();
        draw(g);
    }

    private static void draw(Game g) throws IOException {
        g.screen.setCursorPosition(null);   // we don't need a cursor
        g.screen.startScreen();             // screens must be started
        g.screen.doResizeIfNecessary();     // resize screen if necessary

        g.screen.clear();
        g.screen.setCharacter(g.x, g.y, TextCharacter.fromCharacter('X')[0]);
        g.screen.refresh();
    }
}
