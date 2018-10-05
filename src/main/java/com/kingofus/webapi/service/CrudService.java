package com.kingofus.webapi.service;

import java.util.List;

public interface CrudService<DOMAIN, Serializable> {

    public List<DOMAIN> getAll();

    public void store();

    public DOMAIN findOne(Serializable searchKey);
}
