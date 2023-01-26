/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nila.controller;
import Nila.view.FormPengembalian;
import Nila.dao.PengembalianDao;
import Nila.model.Pengembalian;
import Nila.dao.PengembalianDaoImpl;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import Nila.dao.BukuDao;
import Nila.dao.AnggotaDao;
import java.util.List;
import Nila.model.Anggota;
import Nila.model.Buku;
import Nila.dao.AnggotaDaoImpl;
import Nila.dao.BukuDaoImpl;
/**
 *
 * @author Nila Enjeni
 */
public class PengembalianController {
     private FormPengembalian formPengembalian;
    private PengembalianDao pengembalianDao;
    private Pengembalian pengembalian;
    private AnggotaDao anggotaDao;
    private BukuDao bukuDao;
    
    public PengembalianController (FormPengembalian formPengembalian){
        this.formPengembalian = formPengembalian;
        pengembalianDao = new PengembalianDaoImpl();
        anggotaDao = new AnggotaDaoImpl();
        bukuDao = new BukuDaoImpl();
}

     public void savePengembalian(){
        pengembalian = new Pengembalian();
        pengembalian.setCboNobp( formPengembalian.getCboNobp().getSelectedItem().toString().split("-")[0]);
        pengembalian.setCboKodebuku( formPengembalian.getCboBuku().getSelectedItem().toString());
        pengembalian.setTglpinjam( formPengembalian.getTxtTglpinjam().getText());
        pengembalian.setTglkembali( formPengembalian.getTxtTglkembali().getText());
        pengembalianDao.save(pengembalian);
        javax.swing.JOptionPane.showMessageDialog(formPengembalian,"Entri Ok");
    }
    public void getPengembalian(){
        int index = formPengembalian.getTblPengembalian().getSelectedRow();
        pengembalian = pengembalianDao.getPengembalian(index);
        if (pengembalian != null){
            List<Anggota> listAnggota = anggotaDao.getAllAnggota();
            for (Anggota anggota:listAnggota){
                if (pengembalian.getCboNobp()== anggota.getNobp()){
                    formPengembalian.getCboNobp().setSelectedItem(anggota.getNobp()+"-" +anggota.getNama());
                    break;
                }
            }
            formPengembalian.getCboBuku().setSelectedItem(pengembalian.getCboKodebuku());
            formPengembalian.getTxtTglpinjam().setText(pengembalian.getTglpinjam());
            formPengembalian.getTxtTglkembali().setText(pengembalian.getTglkembali());
        }
    }
    public void updatePeminjaman(){
        int index = formPengembalian.getTblPengembalian().getSelectedRow();
        pengembalian = pengembalianDao.getPengembalian(index);
        pengembalian.setCboNobp( formPengembalian.getCboNobp().getSelectedItem().toString().split("-")[0]);
        pengembalian.setCboKodebuku( formPengembalian.getCboBuku().getSelectedItem().toString().split("-")[0]);
        pengembalian.setTglpinjam( formPengembalian.getTxtTglpinjam().getText());
        pengembalian.setTglkembali( formPengembalian.getTxtTglkembali().getText());
        pengembalianDao.update(index,pengembalian);
        javax.swing.JOptionPane.showMessageDialog(formPengembalian,"Update Ok");
    }
    public void deletePeminjaman(){
         int index = formPengembalian.getTblPengembalian().getSelectedRow();
         pengembalianDao.delete(index);
         javax.swing.JOptionPane.showMessageDialog(formPengembalian,"Delete Ok");
    }
    public void tampilData(){
        DefaultTableModel tabelModel = 
                (DefaultTableModel)formPengembalian.getTblPengembalian().getModel();
        tabelModel.setRowCount(0);
        java.util.List<Pengembalian> list = pengembalianDao.getAllPengembalian();
        for (Pengembalian pengembalian : list){
            Object[] data = {
                pengembalian.getCboNobp(),
                pengembalian.getCboKodebuku(),
                pengembalian.getTglpinjam(),
                pengembalian.getTglkembali()
            };
            tabelModel.addRow(data);
        }
    }

}
