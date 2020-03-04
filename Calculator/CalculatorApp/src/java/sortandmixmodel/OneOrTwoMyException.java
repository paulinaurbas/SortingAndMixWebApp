/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortandmixmodel;

/**
 * My own exception
 * Moved from package exception to model package
 * @author Paulina Urbas
 * @version 2.0
 */
public class OneOrTwoMyException extends java.lang.Exception{

    /**
     * 
     * @param message message to user
     * @author Paulina Urbas
     * @version 2.0
     */
  
    public OneOrTwoMyException (String message)
    {
        super(message);
    }
}