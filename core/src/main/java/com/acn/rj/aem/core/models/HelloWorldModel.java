package com.acn.rj.aem.core.models;

public interface HelloWorldModel {

    default String getMessage() {
        throw new UnsupportedOperationException();
    }

}
