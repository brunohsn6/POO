package DAO;

import Model.Sintoma;

public interface DAOSintomaBridge {
    public void inserir(Sintoma sintoma);
    public void remover(Sintoma sintoma);
    public Sintoma consultar(String sintoma);
    public void listar();
    public void alterar(Sintoma antigo, Sintoma novo);
    public boolean check();
}
