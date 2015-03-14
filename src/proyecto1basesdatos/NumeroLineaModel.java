/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto1basesdatos;


import java.awt.Rectangle;

/**

 * A generic model interface which defines an underlying component with line numbers.

 * @author Greg Cope

 *

 */

public interface NumeroLineaModel {

        //Coment

	/**

	 * 

	 * @return

	 */

	public int getNumberLines();

	

	/**

	 * Returns a Rectangle defining the location in the view of the parameter line. Only the y and height fields are required by callers.

	 * @param line

	 * @return A Rectangle defining the view coordinates of the line.

	 */

	public Rectangle getLineRect(int line);



}
