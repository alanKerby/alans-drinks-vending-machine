package com.alan.alansdrinksvendingmachine.service;

import java.util.List;

public interface CRUD<T> {

    //create
    T create(T t);

    //read all
    List<T> readAll();

    //read by id
    T readByID(long id);

//    //read by name
//    T readByName(String name);

    //update by id
    T updateByID(long id, T t);

    //delete by id
    boolean deleteByID(long id);

}
