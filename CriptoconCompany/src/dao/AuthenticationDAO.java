package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Authentication;
import model.Coin;
import persistence.BankConnect;

public class AuthenticationDAO {
      public void registerPassword(Authentication auth) throws SQLException{
        Connection connect = BankConnect.getConnection();
        Statement sqlExecute = connect.createStatement();
        
        try {
            String sqlData;
            
            sqlData = "insert into authentication(id, passw,recoveredkey)"
                 +"values(null,'"+auth.getPassword()+"','"+auth.getRecoveredkey()+"')";
              sqlExecute.execute(sqlData);
            
        } catch (SQLException e) {
            throw new SQLException("Erro ao Cadastrar Senha "+e.getMessage());
        } finally{
            connect.close();
            sqlExecute.close();
        }
    }
     
      public ArrayList<Authentication> searchPassw()throws SQLException{
        Connection connection = BankConnect.getConnection();
        Statement sqlExecute = connection.createStatement();
        
        try {
            String sql;
            sql = "select * from authentication";
            
            ResultSet rs = sqlExecute.executeQuery(sql);
            ArrayList<Authentication> coinArray = new ArrayList<>();
            while(rs.next()){
                
                Authentication auth = new Authentication();
                auth.setId_auth(rs.getLong("id"));
                auth.setPassword(rs.getString("passw"));
                auth.setRecoveredkey(rs.getString("recoveredkey"));
                coinArray.add(auth);
            }
            return coinArray;
            
        } catch (Exception e) {
            throw new SQLException("error fetching password: "+e.getMessage());
        }finally{
            sqlExecute.close();
            connection.close();
        }   
    }
      
       public void recoveredAuth(Authentication auth) throws SQLException {
        Connection con = BankConnect.getConnection();
        Statement stat = con.createStatement();
        try {
            String sql;
            sql = "update authentication set passw='"+auth.getPassword()+"'";
            stat.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro ao recuperar senha!"+e.getMessage());
        } finally {
            con.close();
            stat.close();
        }//fecha finally
    }//fecha método 
       
         public void deletePassw(Long id) throws SQLException {
       Connection con = BankConnect.getConnection();
       Statement stat = con.createStatement();
       try {
           String sql="delete from authentication where id='"+id+"'";
           stat.execute(sql);
       } catch (SQLException e) {
           throw new SQLException("Erro ao deletar Senha!"
                                  +e.getMessage());
       } finally {
           stat.close();
           con.close();
       }
   }
      public void updatePassw(Authentication auth) throws SQLException {
        Connection con = BankConnect.getConnection();
        Statement stat = con.createStatement();
        try {
            String sql;
            sql = "update authentication set passw='"+auth.getPassword()+"' where id="+auth.getId_auth()+"";
            stat.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro ao alterar Senha!"+e.getMessage());
        } finally {
            con.close();
            stat.close();
        }
        
        
    }
}
