/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.api.Exception;

/**
 *
 * @author saddam
 */
public class OrangTuaException extends Exception {

    /**
     * Creates a new instance of
     * <code>OrangTuaException</code> without detail message.
     */
    public OrangTuaException() {
    }

    /**
     * Constructs an instance of
     * <code>OrangTuaException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public OrangTuaException(String msg) {
        super(msg);
    }
}
