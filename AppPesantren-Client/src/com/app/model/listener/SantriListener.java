/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model.listener;

import com.app.api.Entitas.Santri;
import com.app.model.SantriModel;

/**
 *
 * @author saddam
 */
public interface SantriListener {
    public void onChange(SantriModel model);
    public void onInsert(Santri santri);
    public void onUpdate(Santri santri);
    public void onDelete();
}
