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
public class NotExpression extends Expression implements Serializable{
    
    public NotExpression(Expression l){
        super(l,null);
    
    }
    @Override
    public boolean isTrue() throws Exception{
        boolean left= this.left.isTrue();
        return !left;
    }
    
}
