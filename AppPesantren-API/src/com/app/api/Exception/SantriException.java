/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.api.Exception;

/**
 *
 * @author saddam
 */
public class SantriException extends Exception {

    /**
     * Creates a new instance of
     * <code>SantriException</code> without detail message.
     */
    public SantriException() {
    }

    /**
     * Constructs an instance of
     * <code>SantriException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public SantriException(String msg) {
        super(msg);
    }
}
