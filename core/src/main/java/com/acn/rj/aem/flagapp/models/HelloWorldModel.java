package com.acn.rj.aem.flagapp.models;

public interface HelloWorldModel {

    default String getMessage() {
        throw new UnsupportedOperationException();
    }

}
