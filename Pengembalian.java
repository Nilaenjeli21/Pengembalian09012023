/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nila.model;

/**
 *
 * @author Nila Enjeni
 */
public class Pengembalian {
    private String cbonobp;
    private String cbokodebuku;
    private String tglpinjam;
    private String tglkembali;
    

    public Pengembalian() {
    }

    public Pengembalian(String nobp, String kodebuku, String tglpinjam, String tglkembali) {
        this.cbonobp = nobp;
        this.cbokodebuku = kodebuku;
        this.tglpinjam = tglpinjam;
        this.tglkembali = tglkembali;
        
    }
    
    
    public String getCboNobp(){
        return cbonobp;
    }
    
    public void setCboNobp (String cbonobp){
        this.cbonobp = cbonobp;
    }
    
    public String getCboKodebuku (){
        return cbokodebuku;
    }
    
    public void setCboKodebuku (String cbokodebuku){
        this.cbokodebuku=cbokodebuku;
    }
    
    public String getTglpinjam (){
        return tglpinjam;
    }
    
    public void setTglpinjam (String tglpinjam){
        this.tglpinjam=tglpinjam;
    }
    
    public String getTglkembali (){
        return tglkembali;
    }
    
    public void setTglkembali (String tglkembali){
        this.tglkembali=tglkembali;
    }
}
