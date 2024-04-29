package com.LLD.pattern.structural.bridge;


public abstract  class AbstractCorolla {
    protected AbstractCorollaImpl corollaImpl;

    public   AbstractCorolla(AbstractCorollaImpl corollaImpl) {
        this.corollaImpl = corollaImpl;
    }

    abstract void listSafetyEquipment();

    abstract boolean isCarRightHanded();


    public AbstractCorollaImpl corollaImpl() {
        return corollaImpl;
    }

    public AbstractCorolla setCorollaImpl(AbstractCorollaImpl corollaImpl) {
        this.corollaImpl = corollaImpl;
        return this;
    }
}
