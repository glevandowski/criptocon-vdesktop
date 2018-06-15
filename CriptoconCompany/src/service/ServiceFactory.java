/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author dudu
 */
public class ServiceFactory {
    private static CoinService coinService = new CoinService();

   public static CoinService getDevService(){
       return coinService;                        
   }
   public static AuthenticationService authService = new AuthenticationService();
   public static AuthenticationService getAuthenticationService(){
       return authService;                        
   }
}
