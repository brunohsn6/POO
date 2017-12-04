package Controller;

import DAO.DAOSintoma;

public class DAOSintomaFactory {

    public static DAOSintoma getInstance(){

        TipoDAOSintoma tds = TipoDAOSintoma.DAOSintomaMemoria;

        if(tds == TipoDAOSintoma.DAOSintomaMemoria){
            return new DAOSintoma();
        }else if(tds == TipoDAOSintoma.DAOSintomaBD){
            throw new UnsupportedOperationException();
        }
        return null;
    }

    public enum TipoDAOSintoma{

        DAOSintomaMemoria,
        DAOSintomaBD

    }
}
