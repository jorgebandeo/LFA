package gals;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Semantico implements Constants
{
    Stack<Integer> stack = new Stack();
    Map<String, Integer> vars = new HashMap<String, Integer>();
    String variavelAtual;
    public void executeAction(int action, Token token)	throws SemanticError
    {
        Integer a, b;
        switch (action)
        { 
            case 1: //variavel atual
              variavelAtual = token.getLexeme();
              break;
            case 2://salva variavel e valor
              vars.put(variavelAtual, stack.pop());
              break;
            case 3: //função show
              System.out.print("Resultado: "+Integer.toBinaryString(vars.get(variavelAtual))+"\n");
              break;
            case 4: //adição
              b = stack.pop();
              a = stack.pop();
              stack.push(new Integer(a.intValue() + b.intValue()));    
              break;
            case 5://subtração
              b = stack.pop();
              a = stack.pop();
              stack.push(new Integer(a.intValue() - b.intValue()));
              break;            
            case 6://multiplicação
              b = stack.pop();
              a = stack.pop();
              stack.push(new Integer(a.intValue() * b.intValue()));
              break;
            case 7: //divisão
              b = stack.pop();
              a = stack.pop();
              stack.push(new Integer(a.intValue() / b.intValue()));
              break;
            case 8://exponeciação
              b = stack.pop();
              a = stack.pop();
              Double A = Math.pow(a, b);
              stack.push(A.intValue());
              break;            
            case 9: //Empilha numeros
              stack.push(Integer.parseInt(token.getLexeme(), 2));
              break;
            case 10://Empilha variavel
              stack.push(vars.get(token.getLexeme()));
              break;           
        }
    }	
}
