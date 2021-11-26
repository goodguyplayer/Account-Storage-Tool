package com.example.passwordstoragedb.CRUD;
import java.util.List;

public interface CRUD<T>{
    List<T> get(String condition);
    List<T> getAll();
    Boolean update(T t);
    Boolean delete(T t);
    Boolean create(T t);
}