/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model.listener;

import com.app.api.Entitas.OrangTua;
import com.app.model.OrangTuaModel;

/**
 *
 * @author saddam
 */
public interface OrangTuaListener {
    public void onChange(OrangTuaModel model);
    public void onInsert(OrangTua orangTua);
    public void onUpdate(OrangTua orangTua);
    public void onDelete();
}
