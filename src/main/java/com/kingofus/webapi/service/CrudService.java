package com.kingofus.webapi.service;

import java.util.List;

public interface CrudService<DOMAIN, Serializable> {

    List<DOMAIN> getAll();

    void store();

    DOMAIN findOne(Serializable searchKey);
}
