/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
        isiCombo();
    }

    private void isiCombo() {
        formAnggota.getCboJekel().removeAllItems();
        formAnggota.getCboJekel().addItem("L");
        formAnggota.getCboJekel().addItem("P");
    }

    public void search() {
        try {
            String kode = formAnggota.getTxtKode().getText();
            anggota = dao.getAnggota(kode);
            if (anggota != null) {
                formAnggota.getTxtNama().setText(anggota.getNama());
                formAnggota.getTxtAlamat().setText(anggota.getAlamat());
                formAnggota.getCboJekel().setSelectedItem(
                        anggota.getJekel());
            } else {
                JOptionPane.showMessageDialog(formAnggota, "Data Tidak ada");
            }
        } catch (Exception ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete() {
        try {
            if(anggota!=null) {
                dao.delete(anggota);
                JOptionPane.showMessageDialog(formAnggota, "Delete Ok");
            }else{
                JOptionPane.showMessageDialog(
                        formAnggota, "Data Tidak ada");
            }
        } catch (Exception ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insert() {
        anggota = new Anggota();
        anggota.setKode(formAnggota.getTxtKode().getText());
        anggota.setNama(formAnggota.getTxtNama().getText());
        anggota.setAlamat(formAnggota.getTxtAlamat().getText());
        anggota.setJekel(formAnggota.getCboJekel()
                .getSelectedItem().toString());
        try {
            dao.insert(anggota);
            JOptionPane.showMessageDialog(formAnggota, "Entri Data Ok");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(formAnggota, ex.getMessage());
            Logger.getLogger(AnggotaController.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    public void viewData() {
        try {
            DefaultTableModel model = (DefaultTableModel) formAnggota.getTblAnggota().getModel();
            model.setNumRows(0);
            List<Anggota> list = dao.getAllAnggota();
            for (Anggota anggota : list) {
                Object[] data = {
                    anggota.getKode(),
                    anggota.getNama(),
                    anggota.getAlamat(),
                    anggota.getJekel(),};
                model.addRow(data);
            }
        } catch (Exception ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
