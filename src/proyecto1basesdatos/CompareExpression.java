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
    public Boolean isTrue() throws Exception{
        
        switch(op){
            case "=":
                if(left.getValue()==null || right.getValue() == null){
                    return left.getValue() == right.getValue();
                }
                else if(left.getValue() instanceof Integer && right.getValue() instanceof Integer){
                    int il = (int)left.getValue();
                    int ir = (int)right.getValue();
                    return il==ir;
                    
                }
                
                else if(left.getValue() instanceof String && right.getValue() instanceof String){
                    String l = (String) left.getValue();
                    String r = (String) right.getValue();
                    return l.equalsIgnoreCase(r);
                }
                
                else if(left.getValue() instanceof Float || right.getValue() instanceof Float){
                    float l = (float) left.getValue();
                    float r = (float) right.getValue();
                    return l==r;
                
                }
                else if(left.getValue() instanceof Date&& right.getValue() instanceof Date){
                    Date l = (Date) left.getValue();
                    Date r= (Date) right.getValue();
                    int compare = l.compareTo(r);
                    if(compare ==0){return true;}
                    else{return false;}
                }
                else if(left.getValue() instanceof String && right.getValue() instanceof Date){
                    String l = left.getValue().toString();
                    String r = right.getValue().toString();
                    if(l.equalsIgnoreCase(r)){
                        return true;
                    }
                    else{return false;}
                }
                else if(left.getValue() instanceof Date && right.getValue() instanceof String){
                    String l = left.getValue().toString();
                    String r = right.getValue().toString();
                    if(l.equalsIgnoreCase(r)){
                        return true;
                    }
                    else{return false;}               
                }                
                
                else if(left.getValue() instanceof Float && right.getValue() instanceof Integer){
                    float il = (float)left.getValue();
                    int ir = (int)right.getValue();
                    return il==ir;
                                   
                }                
                else if(left.getValue() instanceof Integer && right.getValue() instanceof Float){
                    int il = (int)left.getValue();
                    float ir = (float)right.getValue();
                    return il==ir;
                                   
                }                
                
                else{
                    String s="ERROR: Tipos invalidos en valores de restriccion: "+left.getValue().toString()+", "+right.getValue().toString();
                    throw new Exception(s);
                } 
                
            case "<>":
                if(left.getValue()==null || right.getValue() == null){
                    return left.getValue() != right.getValue();
                }                
                if(left.getValue() instanceof Integer && right.getValue() instanceof Integer){
                    int il = (int)left.getValue();
                    int ir = (int)right.getValue();
                    return il!=ir;
                    
                }
                
                else if(left.getValue() instanceof String && right.getValue() instanceof String){
                    String l = (String) left.getValue();
                    String r = (String) right.getValue();
                    return !l.equalsIgnoreCase(r);
                }
                
                else if(left.getValue() instanceof Float || right.getValue() instanceof Float){
                    float l = (float) left.getValue();
                    float r = (float) right.getValue();
                    return l!=r;
                
                }
                else if(left.getValue() instanceof Date&& right.getValue() instanceof Date){
                    Date l = (Date) left.getValue();
                    Date r= (Date) right.getValue();
                    int compare = l.compareTo(r);
                    if(compare !=0){return true;}
                    else{return false;}
                
                }
                else if(left.getValue() instanceof String && right.getValue() instanceof Date){
                    String l = left.getValue().toString();
                    String r = right.getValue().toString();
                    if(l.equalsIgnoreCase(r)){
                        return false;
                    }
                    else{return true;}
                }
                else if(left.getValue() instanceof Date && right.getValue() instanceof String){
                    String l = left.getValue().toString();
                    String r = right.getValue().toString();
                    if(l.equalsIgnoreCase(r)){
                        return false;
                    }
                    else{return true;}               
                }                
                                
                else if(left.getValue() instanceof Float && right.getValue() instanceof Integer){
                    float il = (float)left.getValue();
                    int ir = (int)right.getValue();
                    return il!=ir;
                                   
                }                
                else if(left.getValue() instanceof Integer && right.getValue() instanceof Float){
                    int il = (int)left.getValue();
                    float ir = (float)right.getValue();
                    return il!=ir;
                                   
                }                  
                
                else{
                    String s="ERROR: Tipos invalidos en valores de restriccion: "+left.getValue().toString()+", "+right.getValue().toString();
                    throw new Exception(s);
                } 
          
            case ">":
                if(left.getValue()==null || right.getValue() == null){
                    return null;
                }                
                
                if(left.getValue() instanceof Integer && right.getValue() instanceof Integer){
                    int il = (int)left.getValue();
                    int ir = (int)right.getValue();
                    return il>ir;
                    
                }
                
                else if(left.getValue() instanceof String && right.getValue() instanceof String){
                    String l = (String) left.getValue();
                    String r = (String) right.getValue();
                    int compare = l.compareToIgnoreCase(r);
                    if(compare>0){return true;}
                    else if(compare<0||compare==0){return false;}
                }
                else if(left.getValue() instanceof Float || right.getValue() instanceof Float){
                    float l = (float) left.getValue();
                    float r = (float) right.getValue();
                    return l>r;
                
                }
                else if(left.getValue() instanceof Date&& right.getValue() instanceof Date){
                    Date l = (Date) left.getValue();
                    Date r= (Date) right.getValue();
                    int compare = l.compareTo(r);
                    if(compare >0){return true;}
                    else{return false;}
                
                }   
               else if(left.getValue() instanceof String && right.getValue() instanceof Date){
                    String l = left.getValue().toString();
                    String r = right.getValue().toString();
                    int compare = l.compareToIgnoreCase(r);
                    if(compare>0){
                        return true;
                    }
                    else{return false;}
                }
                else if(left.getValue() instanceof Date && right.getValue() instanceof String){
                    String l = left.getValue().toString();
                    String r = right.getValue().toString();
                    int compare = l.compareToIgnoreCase(r);
                    if(compare>0){
                        return true;
                    }
                    else{return false;}              
                }                
                                
                else if(left.getValue() instanceof Float && right.getValue() instanceof Integer){
                    float il = (float)left.getValue();
                    int ir = (int)right.getValue();
                    return il>ir;
                                   
                }                
                else if(left.getValue() instanceof Integer && right.getValue() instanceof Float){
                    int il = (int)left.getValue();
                    float ir = (float)right.getValue();
                    return il>ir;
                                   
                }                            
                else{
                    String s="ERROR: Tipos invalidos en valores de restriccion: "+left.getValue().toString()+", "+right.getValue().toString();
                    throw new Exception(s);
                } 
                break;
            case ">=":
                if(left.getValue()==null || right.getValue() == null){
                    return null;
                }                    
                if(left.getValue() instanceof Integer && right.getValue() instanceof Integer){
                    int il = (int)left.getValue();
                    int ir = (int)right.getValue();
                    return il>=ir;
                    
                }
                
                else if(left.getValue() instanceof String && right.getValue() instanceof String){
                    String l = (String) left.getValue();
                    String r = (String) right.getValue();
                    int compare = l.compareToIgnoreCase(r);
                    if(compare>0||compare==0){return true;}
                    else if(compare<0){return false;}
                }
                else if(left.getValue() instanceof Float || right.getValue() instanceof Float){
                    float l = (float) left.getValue();
                    float r = (float) right.getValue();
                    return l>=r;
                
                }
                else if(left.getValue() instanceof Date&& right.getValue() instanceof Date){
                    Date l = (Date) left.getValue();
                    Date r= (Date) right.getValue();
                    int compare = l.compareTo(r);
                    if(compare >0||compare==0){return true;}
                    else{return false;}
                
                }                  
               else if(left.getValue() instanceof String && right.getValue() instanceof Date){
                    String l = left.getValue().toString();
                    String r = right.getValue().toString();
                    int compare = l.compareToIgnoreCase(r);
                    if(compare>0||compare==0){
                        return true;
                    }
                    else{return false;}
                }
                else if(left.getValue() instanceof Date && right.getValue() instanceof String){
                    String l = left.getValue().toString();
                    String r = right.getValue().toString();
                    int compare = l.compareToIgnoreCase(r);
                    if(compare>0||compare==0){
                        return true;
                    }
                    else{return false;}              
                }                
                                
                else if(left.getValue() instanceof Float && right.getValue() instanceof Integer){
                    float il = (float)left.getValue();
                    int ir = (int)right.getValue();
                    return il>=ir;
                                   
                }                
                else if(left.getValue() instanceof Integer && right.getValue() instanceof Float){
                    int il = (int)left.getValue();
                    float ir = (float)right.getValue();
                    return il>=ir;
                                   
                }   
                else{
                    String s="ERROR: Tipos invalidos en valores de restriccion: "+left.getValue().toString()+", "+right.getValue().toString();
                    throw new Exception(s);
                }
                
                break;
            case "<":
                if(left.getValue()==null || right.getValue() == null){
                    return null;
                }                    
                
                if(left.getValue() instanceof Integer && right.getValue() instanceof Integer){
                    int il = (int)left.getValue();
                    int ir = (int)right.getValue();
                    return il<ir;
                    
                }
                
                else if(left.getValue() instanceof String && right.getValue() instanceof String){
                    String l = (String) left.getValue();
                    String r = (String) right.getValue();
                    int compare = l.compareToIgnoreCase(r);
                    if(compare<0){return true;}
                    else if(compare>0||compare==0){return false;}
                }
                else if(left.getValue() instanceof Float || right.getValue() instanceof Float){
                    float l = (float) left.getValue();
                    float r = (float) right.getValue();
                    return l<r;
                
                }
                else if(left.getValue() instanceof Date&& right.getValue() instanceof Date){
                    Date l = (Date) left.getValue();
                    Date r= (Date) right.getValue();
                    int compare = l.compareTo(r);
                    if(compare <0){return true;}
                    else{return false;}
                
                }    
                
               else if(left.getValue() instanceof String && right.getValue() instanceof Date){
                    String l = left.getValue().toString();
                    String r = right.getValue().toString();
                    int compare = l.compareToIgnoreCase(r);
                    if(compare<0){
                        return true;
                    }
                    else{return false;}
                }
                else if(left.getValue() instanceof Date && right.getValue() instanceof String){
                    String l = left.getValue().toString();
                    String r = right.getValue().toString();
                    int compare = l.compareToIgnoreCase(r);
                    if(compare<0){
                        return true;
                    }
                    else{return false;}              
                }                
                                
                else if(left.getValue() instanceof Float && right.getValue() instanceof Integer){
                    float il = (float)left.getValue();
                    int ir = (int)right.getValue();
                    return il<ir;
                                   
                }                
                else if(left.getValue() instanceof Integer && right.getValue() instanceof Float){
                    int il = (int)left.getValue();
                    float ir = (float)right.getValue();
                    return il<ir;
                                   
                } 
                
                else{
                    String s="ERROR: Tipos invalidos en valores de restriccion: "+left.getValue().toString()+", "+right.getValue().toString();
                    throw new Exception(s);
                }                  
                break;
                
            case "<=":   
                if(left.getValue()==null || right.getValue() == null){
                    return null;
                }                    
                if(left.getValue() instanceof Integer && right.getValue() instanceof Integer){
                    int il = (int)left.getValue();
                    int ir = (int)right.getValue();
                    return il<=ir;
                    
                }
                
                else if(left.getValue() instanceof String && right.getValue() instanceof String){
                    String l = (String) left.getValue();
                    String r = (String) right.getValue();
                    int compare = l.compareToIgnoreCase(r);
                    if(compare<0|| compare==0){return true;}
                    else if(compare>0){return false;}
                }
                else if(left.getValue() instanceof Float || right.getValue() instanceof Float){
                    float l = (float) left.getValue();
                    float r = (float) right.getValue();
                    return l<=r;
                
                }
                else if(left.getValue() instanceof Date&& right.getValue() instanceof Date){
                    Date l = (Date) left.getValue();
                    Date r= (Date) right.getValue();
                    int compare = l.compareTo(r);
                    if(compare <0||compare==0){return true;}
                    else{return false;}
                
                }                   
                
               else if(left.getValue() instanceof String && right.getValue() instanceof Date){
                    String l = left.getValue().toString();
                    String r = right.getValue().toString();
                    int compare = l.compareToIgnoreCase(r);
                    if(compare<0||compare==0){
                        return true;
                    }
                    else{return false;}
                }
                else if(left.getValue() instanceof Date && right.getValue() instanceof String){
                    String l = left.getValue().toString();
                    String r = right.getValue().toString();
                    int compare = l.compareToIgnoreCase(r);
                    if(compare<0||compare==0){
                        return true;
                    }
                    else{return false;}              
                }                
                                
                else if(left.getValue() instanceof Float && right.getValue() instanceof Integer){
                    float il = (float)left.getValue();
                    int ir = (int)right.getValue();
                    return il<ir;
                                   
                }                
                else if(left.getValue() instanceof Integer && right.getValue() instanceof Float){
                    int il = (int)left.getValue();
                    float ir = (float)right.getValue();
                    return il<ir;
                                   
                } 
                
                
                                               
                else{
                    String s="ERROR: Tipos invalidos en valores de restriccion: "+left.getValue().toString()+", "+right.getValue().toString();
                    throw new Exception(s);
                }                      
                break;
                
        
        }
        throw new Exception("Invalid Operand");
    }
        
}
