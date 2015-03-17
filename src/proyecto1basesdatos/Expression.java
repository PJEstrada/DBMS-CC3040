/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1basesdatos;

import java.io.Serializable;

/**
 *
 * @author pablo
 */
public abstract class Expression implements Serializable {
    
    Expression left;
    Expression right;
    
    public Expression(){
        left=right=null;
    }
    public Expression(Expression l, Expression r){
        left = l;
        right =r;
    }
    public abstract boolean isTrue() throws Exception;
    
}
