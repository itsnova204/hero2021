import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.security.Key;

public class Game {
    private static Screen screen;
    private static Arena arena;
    private boolean is_on;

    public Game(){
        try {
            Terminal terminal = new
                    DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);   // we don't need a
            screen.startScreen();             // screens must be
            screen.doResizeIfNecessary();     // resize screen

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

    private void draw() throws IOException {
        screen.clear();
        arena.draw(screen);
        screen.refresh();
    }

    private void processKey(KeyStroke key) throws IOException {arena.processKey(key);}
}
