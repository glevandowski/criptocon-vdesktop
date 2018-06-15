package dao;

/**
 *
 * @author Levandowski e Mitkus
 */
public class DAOFactory {
    private static CoinDAO coinDAO = new CoinDAO();
    private static AuthenticationDAO authDAO = new AuthenticationDAO();
    /***
     * 
     * @return object 
     */
    public static CoinDAO getcoinDAO(){
        return coinDAO;
    }
     public static AuthenticationDAO getauthDAO(){
        return authDAO;
    }
}
