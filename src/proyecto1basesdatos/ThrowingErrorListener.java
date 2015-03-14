/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1basesdatos;

import java.util.Collections;
import java.util.List;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.ParseCancellationException;

/**
 *
 * @author pablo
 */
public class ThrowingErrorListener extends BaseErrorListener {

   //public static final ThrowingErrorListener INSTANCE = new ThrowingErrorListener();
   Frame t;
   public ThrowingErrorListener(Frame k){
       super();
       t =k;
       
   
   }
   
   @Override
   public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e)
      throws ParseCancellationException {
       
        List<String> stack = ((Parser)recognizer).getRuleInvocationStack();
        Collections.reverse(stack);
        
       Frame.jTextArea2.setText(Frame.jTextArea2.getText()+"\n"+"line "+line+":"+charPositionInLine+" at "+
            offendingSymbol+": "+msg);
        t.error=true;
        
        //System.err.println("rule stack: "+stack); 
        //System.err.println("line "+line+":"+charPositionInLine+" at "+offendingSymbol+": "+msg);
        //throw new ParseCancellationException("line " + line + ":" + charPositionInLine + " " + msg);
   }
}