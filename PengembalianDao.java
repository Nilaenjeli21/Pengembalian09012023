/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nila.dao;
import Nila.model.Pengembalian;
import java.util.List;
import Nila.dao.AnggotaDao;
import Nila.dao.BukuDao;
/**
 *
 * @author Nila Enjeni
 */
public interface PengembalianDao {
  Pengembalian save (Pengembalian pengembalian);
    Pengembalian update (int index,Pengembalian pengembalian);
    Pengembalian delete (int index);
    Pengembalian getPengembalian (int index);
    List <Pengembalian> getAllPengembalian ();
  
}
