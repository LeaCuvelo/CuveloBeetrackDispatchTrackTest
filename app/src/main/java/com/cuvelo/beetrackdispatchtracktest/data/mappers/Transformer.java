package com.cuvelo.beetrackdispatchtracktest.data.mappers;

public interface Transformer<T,Y>{
    /**
     * Transform a model object into domain object
     *
     * @param object object to be transformed
     * @return transformed object
     * */
    T transform(Y object);
}