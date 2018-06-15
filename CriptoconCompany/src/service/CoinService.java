
package service;

import dao.CoinDAO;
import dao.DAOFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Coin;


public class CoinService {
    public void registerCoin(Coin coinVO) throws SQLException{
        CoinDAO coinDAO = DAOFactory.getcoinDAO();
        coinDAO.registerCoin(coinVO);
    }
    
      public ArrayList<Coin> searchCoin(String query) throws SQLException{
        CoinDAO coinDao = DAOFactory.getcoinDAO();
        return coinDao.searchCoin(query);
    }
      public void deleteCoin(String name) throws SQLException{
         CoinDAO coinDao = DAOFactory.getcoinDAO();
        coinDao.deleteCoin(name);
     }
    public void updateCoin(Coin coin) throws SQLException{
        CoinDAO coinDao = DAOFactory.getcoinDAO();
        coinDao.updateCoin(coin);
     }
}
