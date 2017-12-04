package DAO;

import Model.Usuario;

public interface DAOUsuarioBridge extends Observador {

    public void inserir(Usuario usuario);
    public void remover (Usuario usuario);
    public Usuario consultar (String nome);
    public void alterar(Usuario antigo, Usuario novo);
    public void listar();
}
