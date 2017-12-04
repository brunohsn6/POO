package Controller;

import DAO.DAOUsuario;
import DAO.DAOUsuarioBridge;
import Model.Usuario;

public class ControllerUsuario {
    private DAOUsuarioBridge daoUsuario;

    public ControllerUsuario(){
        this.daoUsuario = DAOUsuarioFactory.getInstance();
    }

    public void inserirUsuario(Usuario usuario){
        this.daoUsuario.inserir(usuario);
    }

    public Usuario consultarUsuario(String nome){
        return daoUsuario.consultar(nome);
    }

    public void removerUsuario(Usuario usuario){
        this.daoUsuario.remover(usuario);
    }

    public void alterarUsuario(Usuario antigo, Usuario novo){
        this.daoUsuario.alterar(antigo, novo);
    }

    public void listar() {
        daoUsuario.listar();
    }

    public void atualizarDados() {
        daoUsuario.update();
    }
}
