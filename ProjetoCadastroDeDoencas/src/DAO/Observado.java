package DAO;

import Controller.DAOUsuarioFactory;

public class Observado {
    public void notificar(boolean status){
        DAOUsuario usuarios = DAOUsuarioFactory.getInstance();
        if(status == true){
            usuarios.update();
        }
    }
}
