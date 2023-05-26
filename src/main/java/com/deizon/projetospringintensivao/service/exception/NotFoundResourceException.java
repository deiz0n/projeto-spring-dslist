package com.deizon.projetospringintensivao.service.exception;

public class NotFoundResourceException extends RuntimeException {

    public NotFoundResourceException(Object id) {
        super("Not found id. Id: " + id);
    }
}
