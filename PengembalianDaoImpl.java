/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nila.dao;
import Nila.model.Pengembalian;
import java.util.List;
import java.util.ArrayList;
import Nila.dao.AnggotaDao;
import Nila.dao.BukuDao;
/**
 *
 * @author Nila Enjeni
 */
public class PengembalianDaoImpl implements PengembalianDao {
    List<Pengembalian> data = new ArrayList <>();

    public PengembalianDaoImpl() {
        data.add(new Pengembalian("2101091001","1112","12 Januari 2022","20 Januari 2022"));
        data.add(new Pengembalian("2101091008","1113","12 Februari 2022","20 Februari 2022"));
        data.add(new Pengembalian("2101091007","1114","12 Maret 2022","20 Maret 2022"));
    }
    
    
    @Override
    public Pengembalian save(Pengembalian pengembalian){
        data.add(pengembalian);
        return pengembalian;
    }
    
    public  Pengembalian update(int index,Pengembalian pengembalian){
        data.set(index , pengembalian);
        return pengembalian;
    }
    
    public Pengembalian delete(int index){
        return data.remove(index);
    }
    
    public Pengembalian getPengembalian(int index){
         return data.get(index);
    }
    
    public  List<Pengembalian> getAllPengembalian(){
        return data;
    }

}
