
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
    public boolean isTrue() throws Exception{
        boolean left= this.left.isTrue();
        boolean right = this.right.isTrue();
        return left&&right;
    }
    
}
