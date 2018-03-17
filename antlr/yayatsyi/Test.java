import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.FileInputStream;
import java.io.InputStream;

public class Test 
{
    //Seite 35
    public static void main(String[] args) throws Exception
    {
        String inputFile = null;
        if(args.length>0)
        {
            inputFile = args[0];
        }
        InputStream is = System.in;
        
        if(inputFile!=null)
        {
            is = new FileInputStream(inputFile);
        }
    
        ANTLRInputStream input = new ANTLRInputStream(is);
        
        YayatsyiGrammarLexer lexer = new YayatsyiGrammarLexer(input);
        
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        YayatsyiGrammarParser parser = new YayatsyiGrammarParser(tokens);
        
        ParseTree tree = parser.root(); //start as prog
        //System.out.println(parser.states_list);
        //System.out.println(tree.toStringTree(parser));
        
        //ParseTreeWalker walker = new ParseTreeWalker();
       //InsertSerialIDListener extractor = new InsertSerialIDListener(tokens);
        //walker.walk(extractor, tree);
        
        //System.out.println(extractor.rewriter.getText());
    }
}