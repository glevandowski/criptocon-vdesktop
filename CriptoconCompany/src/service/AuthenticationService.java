
package service;

import dao.AuthenticationDAO;
import dao.DAOFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Authentication;


public class AuthenticationService {
     public void registerPassword(Authentication auth) throws SQLException{
        AuthenticationDAO authDAO = DAOFactory.getauthDAO();
        authDAO.registerPassword(auth);
    }
     public ArrayList<Authentication> searchPassw() throws SQLException{
        AuthenticationDAO authDao = DAOFactory.getauthDAO();
        return authDao.searchPassw();
    }
      public void updateRecoveredKey(Authentication auth) throws SQLException{
        AuthenticationDAO authDao = DAOFactory.getauthDAO();
        authDao.recoveredAuth(auth);
     }
      public void updatePassw(Authentication auth) throws SQLException{
       AuthenticationDAO authDAO = DAOFactory.getauthDAO();
        authDAO.updatePassw(auth);
     }
     public void deletePassw(long id) throws SQLException{
         AuthenticationDAO authDAO = DAOFactory.getauthDAO();
        authDAO.deletePassw(id);
     }
}
