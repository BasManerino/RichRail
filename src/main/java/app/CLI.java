package app;

import java.util.Scanner;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import parser.RichRailCli;
import parser.RichRailLexer;
import parser.RichRailListener;
import parser.RichRailParser;

public class CLI {
	public String bootUp(String command) {

        String line = command;
        
        CharStream lineStream = CharStreams.fromString(line);
        
        // Tokenize / Lexical analysis
        Lexer lexer = new RichRailLexer(lineStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Create Parse Tree
        RichRailParser parser = new RichRailParser(tokens);
        ParseTree tree = parser.command();

        // Create ParseTreeWalker and Custom Listener
        ParseTreeWalker walker = new ParseTreeWalker();
        RichRailCli listener = new RichRailCli();

        // Walk over ParseTree using Custom Listener that listens to enter/exit events
        walker.walk(listener, tree);
        
        return listener.getFinalMessage();
	}
}
