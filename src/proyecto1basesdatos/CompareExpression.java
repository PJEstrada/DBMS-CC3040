/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1basesdatos;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author pablo
 */
public class CompareExpression extends Expression implements Serializable{
    String op;
    Term left;
    Term right;
    
    public CompareExpression(Term l, Term r, String op){
        left =l;
        right =r;
        this.op = op;
    }
    
    @Override
    public boolean isTrue() throws Exception{
        
        switch(op){
            case "=":
                if(left.value instanceof Integer && right.value instanceof Integer){
                    int il = (int)left.value;
                    int ir = (int)right.value;
                    return il==ir;
                    
                }
                
                else if(left.value instanceof String && right.value instanceof String){
                    String l = (String) left.value;
                    String r = (String) right.value;
                    return left.equals(right);
                }
                
                else if(left.value instanceof Float || right.value instanceof Float){
                    float l = (float) left.value;
                    float r = (float) right.value;
                    return l==r;
                
                }
                else if(left.value instanceof Date&& right.value instanceof Date){
                    Date l = (Date) left.value;
                    Date r= (Date) right.value;
                    int compare = l.compareTo(r);
                    if(compare ==0){return true;}
                    else{return false;}
                
                }
                else{
                    throw new Exception("ERROR DE TIPOS");
                }               
            case "<>":
                if(left.value instanceof Integer && right.value instanceof Integer){
                    int il = (int)left.value;
                    int ir = (int)right.value;
                    return il!=ir;
                    
                }
                
                else if(left.value instanceof String && right.value instanceof String){
                    String l = (String) left.value;
                    String r = (String) right.value;
                    return !left.equals(right);
                }
                
                else if(left.value instanceof Float || right.value instanceof Float){
                    float l = (float) left.value;
                    float r = (float) right.value;
                    return l!=r;
                
                }
                else if(left.value instanceof Date&& right.value instanceof Date){
                    Date l = (Date) left.value;
                    Date r= (Date) right.value;
                    int compare = l.compareTo(r);
                    if(compare !=0){return true;}
                    else{return false;}
                
                }
                else{
                    throw new Exception("ERROR DE TIPOS");
                } 
            case ">":
                if(left.value instanceof Integer && right.value instanceof Integer){
                    int il = (int)left.value;
                    int ir = (int)right.value;
                    return il>ir;
                    
                }
                
                else if(left.value instanceof String && right.value instanceof String){
                    String l = (String) left.value;
                    String r = (String) right.value;
                    int compare = l.compareTo(r);
                    if(compare>0){return true;}
                    else if(compare<0||compare==0){return false;}
                }
                else if(left.value instanceof Float || right.value instanceof Float){
                    float l = (float) left.value;
                    float r = (float) right.value;
                    return l>r;
                
                }
                else if(left.value instanceof Date&& right.value instanceof Date){
                    Date l = (Date) left.value;
                    Date r= (Date) right.value;
                    int compare = l.compareTo(r);
                    if(compare >0){return true;}
                    else{return false;}
                
                }                
                else{
                    throw new Exception("ERROR DE TIPOS");
                }                
            case ">=":
                if(left.value instanceof Integer && right.value instanceof Integer){
                    int il = (int)left.value;
                    int ir = (int)right.value;
                    return il>ir;
                    
                }
                
                else if(left.value instanceof String && right.value instanceof String){
                    String l = (String) left.value;
                    String r = (String) right.value;
                    int compare = l.compareTo(r);
                    if(compare>0||compare==0){return true;}
                    else if(compare<0){return false;}
                }
                else if(left.value instanceof Float || right.value instanceof Float){
                    float l = (float) left.value;
                    float r = (float) right.value;
                    return l>r;
                
                }
                else if(left.value instanceof Date&& right.value instanceof Date){
                    Date l = (Date) left.value;
                    Date r= (Date) right.value;
                    int compare = l.compareTo(r);
                    if(compare >0||compare==0){return true;}
                    else{return false;}
                
                }                  
                
                else{
                    throw new Exception("ERROR DE TIPOS");
                }                  
            case "<":
                if(left.value instanceof Integer && right.value instanceof Integer){
                    int il = (int)left.value;
                    int ir = (int)right.value;
                    return il>ir;
                    
                }
                
                else if(left.value instanceof String && right.value instanceof String){
                    String l = (String) left.value;
                    String r = (String) right.value;
                    int compare = l.compareTo(r);
                    if(compare<0){return true;}
                    else if(compare>0||compare==0){return false;}
                }
                else if(left.value instanceof Float || right.value instanceof Float){
                    float l = (float) left.value;
                    float r = (float) right.value;
                    return l>r;
                
                }
                else if(left.value instanceof Date&& right.value instanceof Date){
                    Date l = (Date) left.value;
                    Date r= (Date) right.value;
                    int compare = l.compareTo(r);
                    if(compare <0){return true;}
                    else{return false;}
                
                }                   
                
                
                else{
                    throw new Exception("ERROR DE TIPOS");
                }                  
                
                
            case "<=":     
                if(left.value instanceof Integer && right.value instanceof Integer){
                    int il = (int)left.value;
                    int ir = (int)right.value;
                    return il>ir;
                    
                }
                
                else if(left.value instanceof String && right.value instanceof String){
                    String l = (String) left.value;
                    String r = (String) right.value;
                    int compare = l.compareTo(r);
                    if(compare<0|| compare==0){return true;}
                    else if(compare>0){return false;}
                }
                else if(left.value instanceof Float || right.value instanceof Float){
                    float l = (float) left.value;
                    float r = (float) right.value;
                    return l>r;
                
                }
                else if(left.value instanceof Date&& right.value instanceof Date){
                    Date l = (Date) left.value;
                    Date r= (Date) right.value;
                    int compare = l.compareTo(r);
                    if(compare <0||compare==0){return true;}
                    else{return false;}
                
                }                   
                                
                else{
                    throw new Exception("ERROR DE TIPOS");
                }                      
                
                
        
        }
        throw new Exception("Invalid Operand");
    }
        
}
