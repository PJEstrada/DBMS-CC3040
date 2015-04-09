
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
    public Boolean isTrue() throws Exception{
        Boolean left= this.left.isTrue();
        Boolean right = this.right.isTrue();
        if(left == true && right == null){
            return true;
        }
        else if(left == null && right == true){
            return true;
        }       
        else if (left == null && right == null){
            return null;
        }
        else{
            return left||right;
        }
        
    }
    
}
