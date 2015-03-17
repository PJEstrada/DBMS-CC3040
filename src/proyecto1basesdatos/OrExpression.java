
package proyecto1basesdatos;

import java.io.Serializable;

/**
 *
 * @author pablo
 */
public class OrExpression extends Expression implements Serializable{
    
    public OrExpression(Expression l, Expression r){
        super(l,r);
    
    }
    @Override
    public boolean isTrue() throws Exception{
        boolean left= this.left.isTrue();
        boolean right = this.right.isTrue();
        return left||right;
    }
    
}
