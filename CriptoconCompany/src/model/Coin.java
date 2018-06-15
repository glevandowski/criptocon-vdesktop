package model;

import java.text.DecimalFormat;

public class Coin {
    private long id_coin;
    private String rank;
    private String symbol;
    private String name;
    private String price_brl;
    private String percent_change_1h;
    private String percent_change_24h;
    private String percent_change_7d;
    private String total_supply;
    private String max_supply;
    private String last_updated;

    public Coin() {
    }

    public Coin(String rank, String symbol, String name, String price_brl, String percent_change_1h, String percent_change_24h, String percent_change_7d, String total_supply, String max_supply, String last_updated) {
        this.rank = rank;
        this.symbol = symbol;
        this.name = name;
        this.price_brl = price_brl;
        this.percent_change_1h = percent_change_1h;
        this.percent_change_24h = percent_change_24h;
        this.percent_change_7d = percent_change_7d;
        this.total_supply = total_supply;
        this.max_supply = max_supply;
        this.last_updated = last_updated;
    }

  

    public long getId_coin() {
        if(id_coin != 0){
        return id_coin;
        }else{
            return 0;
        }
    }

    public void setId_coin(long id_coin) {
        this.id_coin = id_coin;
    }

    public String getRank() {
        if(rank != null){
        return rank;
        }else{
            return " --";
        }
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSymbol() {
        if(symbol != null){
        return symbol;
        }else{
            return " --";
        }
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        if(name != null){
        return name;
        }else{
            return " --";
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice_brl() {
   try{
   if(price_brl != null){
        DecimalFormat df = new DecimalFormat();
        df.applyPattern("#,##0.0000");
        Double price = Double.parseDouble(price_brl);
        return "R$"+df.format(price);
        }else{
            return " --";
        }
   }catch(Exception ex){
       return price_brl;
   }
   
    }

    public void setPrice_brl(String price_brl) {
        this.price_brl = price_brl;
    }

    public String getPercent_change_1h() {
        if(percent_change_1h != null){
        return percent_change_1h;
        }else{
            return " --";
        }
    }

    public void setPercent_change_1h(String percent_change_1h) {
        this.percent_change_1h = percent_change_1h;
    }

    public String getPercent_change_24h() {
        if(percent_change_24h != null){
        return percent_change_24h;
        }else{
            return " --";
        }
    }

    public void setPercent_change_24h(String percent_change_24h) {
        this.percent_change_24h = percent_change_24h;
    }

    public String getPercent_change_7d() {
        if(percent_change_7d != null){
        return percent_change_7d;
        }else{
            return " --";
        }
    }

    public void setPercent_change_7d(String percent_change_7d) {
        this.percent_change_7d = percent_change_7d;
    }

    public String getTotal_supply() {
        if(total_supply != null){
        return total_supply;
        }else{
            return " --";
        }
    }

    public void setTotal_supply(String total_supply) {
        this.total_supply = total_supply;
    }

    public String getMax_supply() {
        if(max_supply != null){
        return max_supply;
        }else{
            return " --";
        }
    }

    public void setMax_supply(String max_supply) {
        this.max_supply = max_supply;
    }

    public String getLast_updated() {
        if(last_updated != null){
        return last_updated;
        }else{
            return " --";
        }
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }


    @Override
    public String toString() {
        return "Coin{" + "id_coin=" + id_coin + 
                "\n, rank=" + rank + 
                "\n, symbol=" + symbol + 
                "\n, name=" + name + 
                "\n, price_brl=" + price_brl + 
                "\n, percent_change_1h=" + percent_change_1h + 
                "\n, percent_change_24h=" + percent_change_24h + 
                "\n, percent_change_7d=" + percent_change_7d + 
                "\n, total_supply=" + total_supply + 
                "\n, max_supply=" + max_supply + 
                "\n, last_updated=" + last_updated + '}';
    } 
}

