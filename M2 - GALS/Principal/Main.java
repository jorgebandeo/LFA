package Principal;

import gals.*;
import java.io.IOException;
public class Main {
     public static void main(String[] args) throws IOException, AnalysisError{
         
         try
         {
            Lexico lexico = new Lexico("A = 10; B = 11; B = 111 + A * B; show(B);");

            
            Sintatico sintatico = new Sintatico();
            Semantico semantico = new Semantico();

            sintatico.parse(lexico, semantico);
        }
            catch ( LexicalError | SyntaticError | SemanticError e )
            {
                System.out.println("Comando não identificado.");
            }
  }
}
