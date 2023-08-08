/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author int.thong.nk
 */
public class Slot {
    private int slotId;
    private  String slotName;

    public Slot() {
    }

    public Slot(int slotId, String slotName) {
        this.slotId = slotId;
        this.slotName = slotName;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public String getSlotName() {
        return slotName;
    }

    public void setSlotName(String slotName) {
        this.slotName = slotName;
    }

    @Override
    public String toString() {
        return "slot{" + "slotId=" + slotId + ", slotName=" + slotName + '}';
    }
    
}
