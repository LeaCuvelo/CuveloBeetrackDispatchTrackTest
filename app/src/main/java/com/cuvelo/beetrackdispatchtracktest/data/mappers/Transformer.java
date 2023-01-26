package com.cuvelo.beetrackdispatchtracktest.data.mappers;

public interface Transformer<T,Y>{
    /**
     * Transform from one domain to another, i.e: model to domain
     *
     * @param object object to be transformed
     * @return transformed object
     * */
    T transform(Y object);
}