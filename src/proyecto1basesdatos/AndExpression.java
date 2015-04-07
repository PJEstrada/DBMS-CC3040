
package proyecto1basesdatos;

import java.io.Serializable;

/**
 *
 * @author pablo
 */
public class AndExpression extends Expression implements Serializable {
    public AndExpression(Expression l, Expression r){
        super(l,r);
    
    }
    public Boolean isTrue() throws Exception{
        Boolean left= this.left.isTrue();
        Boolean right = this.right.isTrue();
        if(left==null || right == null){
            return null;
        }
        else{
            return left&&right;
        }
        
    }
    
}
