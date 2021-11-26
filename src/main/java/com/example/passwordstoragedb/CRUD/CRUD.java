package com.example.passwordstoragedb.CRUD;
import java.util.List;

public interface CRUD<T>{
    List<T> get(String condition);
    List<T> getAll();
    int update(T t);
    int delete(T t);
    int create(T t);
}