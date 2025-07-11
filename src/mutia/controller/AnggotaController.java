/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mutia.controller;

import mutia.dao.AnggotaDao;
import mutia.model.Anggota;
import mutia.view.FormAnggota;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class AnggotaController {

    private FormAnggota formAnggota;
    private Anggota anggota;
    private AnggotaDao dao;

    public AnggotaController(FormAnggota formAnggota) {
        this.formAnggota = formAnggota;
        dao = new AnggotaDao();
    }

    public void bersihForm() {
        formAnggota.getTxtKode().setText("");
        formAnggota.getTxtNama().setText("");
        formAnggota.getTxtAlamat().setText("");
        fieldOption();
    }

    private void fieldOption() {
        formAnggota.getCboJekel().removeAllItems();
        formAnggota.getCboJekel().addItem("-- Select Gender --");
        formAnggota.getCboJekel().addItem("L");
        formAnggota.getCboJekel().addItem("P");
    }

    public void insert(){
        anggota = new Anggota();
        anggota.setKode(formAnggota.getTxtKode().getText());
        anggota.setNama(formAnggota.getTxtNama().getText());
        anggota.setJekel(formAnggota.getCboJekel().getSelectedItem().toString());
        anggota.setAlamat(formAnggota.getTxtAlamat().getText());
        
        try{
            dao.insert(anggota);
            JOptionPane.showMessageDialog(formAnggota, "Entry Data Ok!");
        }catch (Exception Ex){
            JOptionPane.showMessageDialog(formAnggota, Ex.getMessage());
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, Ex);
        }
    }
    
    public void update(){
        anggota = new Anggota();
        anggota.setNama(formAnggota.getTxtNama().getText());
        anggota.setJekel(formAnggota.getCboJekel().getSelectedItem().toString());
        anggota.setAlamat(formAnggota.getTxtAlamat().getText());
        anggota.setKode(formAnggota.getTxtKode().getText());
        
        try{
            dao.Update(anggota);
            JOptionPane.showMessageDialog(formAnggota, "Update Data Ok!");
        }catch (Exception Ex){
            JOptionPane.showMessageDialog(formAnggota, Ex.getMessage());
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, Ex);
        }
    }
    
    public void search(){
        try {
            String kode = formAnggota.getTxtKode().getText();
            anggota = dao.getAnggota(kode);
            
            if (anggota != null){
                formAnggota.getTxtNama().setText(anggota.getNama());
                formAnggota.getTxtAlamat().setText(anggota.getAlamat());
                formAnggota.getCboJekel().setSelectedItem(anggota.getJekel());
            }else{
                JOptionPane.showMessageDialog(formAnggota, "Data not found!");
            }
        } catch (Exception ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(){
        try {
            if(anggota!=null){   
                dao.Delete(anggota);
            }else{
                JOptionPane.showMessageDialog(formAnggota, "Data Not Found");
            }
            
        } catch (Exception ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void viewData() {
        
        try {
            DefaultTableModel model = (DefaultTableModel)
                    formAnggota.getTblAnggota().getModel();
            
            model.setNumRows(0);
            List<Anggota> list = dao.getAllAnggota();
            for (Anggota anggota : list) {
                Object[] data = {
                    anggota.getKode(),
                    anggota.getNama(),
                    anggota.getAlamat(),
                    anggota.getJekel(),
                };
                model.addRow(data);
            }
        } catch (Exception ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
