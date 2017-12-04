package Controller;

import DAO.DAOUsuario;

public class DAOUsuarioFactory {


    public static DAOUsuario getInstance(){

        TipoDAOUsuario tdu = TipoDAOUsuario.DAOUsuarioMemoria;

        //ler a configuração aqui
        if(tdu == TipoDAOUsuario.DAOUsuarioMemoria){
            return new DAOUsuario();
        }
        else if(tdu == TipoDAOUsuario.DAOUsuarioBD){
            throw new UnsupportedOperationException();
        }
        return null;

    }

    public enum TipoDAOUsuario{

        DAOUsuarioMemoria,
        DAOUsuarioBD
    }
}
