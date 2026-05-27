package br.com.coti.interfaces;

import java.util.List;

public interface IRepository<T> {

    void cadastrar(T entity);
    List<T> consultar();
}
