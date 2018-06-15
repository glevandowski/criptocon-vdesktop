
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Coin;
import persistence.BankConnect;

/**
 *
 * @author Mitkus e Levandowski
 */
public class CoinDAO {
    
    public void registerCoin(Coin coinVO) throws SQLException{
        Connection connect = BankConnect.getConnection();
        Statement sqlExecute = connect.createStatement();
        
        try {
            String sqlData;
            
            sqlData = "insert into coin(id,rank,symbol,name, price_brl,percent_change_1h,percent_change_24h,percent_change_7d,total_supply,max_supply,last_updated)"
                 +"values('"+coinVO.getId_coin()+"','"+coinVO.getRank()+"','"+coinVO.getSymbol()+"','"+coinVO.getName()+"','"+coinVO.getPrice_brl()+"','"+coinVO.getPercent_change_1h()+"','"+coinVO.getPercent_change_24h()+"','"+coinVO.getPercent_change_7d()+"','"+coinVO.getTotal_supply()+"','"+coinVO.getMax_supply()+"','"+coinVO.getLast_updated()+"')";
              sqlExecute.execute(sqlData);
            
        } catch (SQLException e) {
            throw new SQLException("Erro ao cadastrar Moeda "+e.getMessage());
        } finally{
            connect.close();
            sqlExecute.close();
        }
    }
        
    public ArrayList<Coin> searchCoin(String query)throws SQLException{
        Connection connection = BankConnect.getConnection();
        Statement sqlExecute = connection.createStatement();
        
        try {
            String sql;
            sql = "select * from coin "+query;
            
            ResultSet rs = sqlExecute.executeQuery(sql);
            ArrayList<Coin> coinArray = new ArrayList<>();
            while(rs.next()){
                Coin coinModel = new Coin();
              
                coinModel.setId_coin(rs.getLong("id"));
                coinModel.setRank(rs.getString("rank"));             
                coinModel.setSymbol(rs.getString("symbol"));
                coinModel.setName(rs.getString("name"));
                coinModel.setPrice_brl(rs.getString("price_brl"));
                coinModel.setPercent_change_1h(rs.getString("percent_change_1h"));
                coinModel.setPercent_change_24h(rs.getString("percent_change_24h"));
                coinModel.setPercent_change_7d(rs.getString("percent_change_7d"));
                coinModel.setTotal_supply(rs.getString("total_supply"));
                coinModel.setMax_supply(rs.getString("max_supply"));
                coinModel.setLast_updated(rs.getString("last_updated"));            
                coinArray.add(coinModel);
            }
            return coinArray;
            
        } catch (Exception e) {
            throw new SQLException("error fetching coin: "+e.getMessage());
        }finally{
            sqlExecute.close();
            connection.close();
        }   
    }  
    
    public void updateCoin(Coin c) throws SQLException {
        Connection con = BankConnect.getConnection();
        Statement stat = con.createStatement();
        try {
            String sql;
            sql = "update coin set rank='"+c.getRank()+"', symbol='"+c.getSymbol()+"', name='"+c.getName()+"' ,price_brl = '"+c.getPrice_brl()+"', percent_change_1h ='"+c.getPercent_change_1h()+"', percent_change_24h ='"+c.getPercent_change_24h()+"',percent_change_7d ='"+c.getPercent_change_7d()+"', total_supply ='"+c.getTotal_supply()+"', max_supply = '"+c.getMax_supply()+"', last_updated = '"+c.getLast_updated()+"'  where name='"+c.getName()+"'";
            stat.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro ao alterar Moeda!"+e.getMessage());
        } finally {
            con.close();
            stat.close();
        }//fecha finally
    }//fecha método 
    
public void deleteCoin(String name) throws SQLException {
       Connection con = BankConnect.getConnection();
       Statement stat = con.createStatement();
       try {
           String sql="delete from coin where name='"+name+"'";
           stat.execute(sql);
       } catch (SQLException e) {
           throw new SQLException("Erro ao deletar Moeda!"
                                  +e.getMessage());
       } finally {
           stat.close();
           con.close();
       }
   }                                 
    
}
