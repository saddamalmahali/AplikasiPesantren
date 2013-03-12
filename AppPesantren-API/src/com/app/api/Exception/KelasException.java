/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.api.Exception;

/**
 *
 * @author saddam
 */
public class KelasException extends Exception {

    /**
     * Creates a new instance of
     * <code>KelasException</code> without detail message.
     */
    public KelasException() {
    }

    /**
     * Constructs an instance of
     * <code>KelasException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public KelasException(String msg) {
        super(msg);
    }
}
