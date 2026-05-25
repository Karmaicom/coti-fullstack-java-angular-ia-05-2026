package br.com.cotiinformatica.interfaces;

public interface IRepository<T> {

    /**
     * Metodo para inserir dados de uma entidade no banco de dados
     * @param entity
     * @throws Exception
     */
    void inserir(T entity) throws Exception;

}
