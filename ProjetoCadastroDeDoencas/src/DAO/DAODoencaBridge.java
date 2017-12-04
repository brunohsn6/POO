package DAO;

import Model.Doenca;

import java.util.ArrayList;

public interface DAODoencaBridge {

    public void inserir(Doenca doenca);
    public Doenca consultar(String nome);
    public void remover(Doenca doenca);
    public void alterar(Doenca antigo, Doenca novo, boolean status);
    public void listar();
    public ArrayList<Doenca> getDoencasDAO();

}
