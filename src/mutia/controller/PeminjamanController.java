/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mutia.controller;

import mutia.dao.AnggotaDao;
import mutia.dao.BukuDao;
import mutia.dao.PeminjamanDao;
import mutia.model.Anggota;
import mutia.model.Buku;
import mutia.model.Peminjaman;
import mutia.view.FormAnggota;
import mutia.view.FormPeminjaman;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class PeminjamanController {

    private FormPeminjaman formPeminjaman;
    private Peminjaman peminjaman;
    private PeminjamanDao dao;
    private AnggotaDao anggotaDao;
    private BukuDao bukuDao;

    public PeminjamanController(FormPeminjaman formPeminjaman) {
        this.formPeminjaman = formPeminjaman;
        dao = new PeminjamanDao();
        anggotaDao = new AnggotaDao();
        bukuDao = new BukuDao();
    }

    public void bersihForm() {
        anggotaCodeOption();
        bukuCodeOption();
        formPeminjaman.getTxtTglPinjam().setText(" ");
        formPeminjaman.getTxtTglKembali().setText(" ");
    }

    public void insert() {
        try {
            peminjaman = new Peminjaman();

            String kodeAnggota = formPeminjaman.getoptionAnggota()
                    .getSelectedItem().toString().split("-")[0];
            String kodeBuku = formPeminjaman.getoptionBuku()
                    .getSelectedItem().toString();

            Anggota anggota = anggotaDao.getAnggota(kodeAnggota);
            Buku buku = bukuDao.getBuku(kodeBuku);

            peminjaman.setAnggota(anggota);
            peminjaman.setBuku(buku);
            peminjaman.setTglpinjam(formPeminjaman.getTxtTglPinjam().getText());
            peminjaman.setTglkembali(formPeminjaman.getTxtTglKembali().getText());
            dao.insert(peminjaman);

        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Update() {
        try {
            String kodeAnggota = formPeminjaman.getoptionAnggota()
                    .getSelectedItem().toString().split("-")[0];
            String kodeBuku = formPeminjaman.getoptionBuku()
                    .getSelectedItem().toString();
            
            Anggota anggota = anggotaDao.getAnggota(kodeAnggota);
            Buku buku = bukuDao.getBuku(kodeBuku);
            
            peminjaman = new Peminjaman();
            peminjaman.setTglkembali(formPeminjaman.getTxtTglKembali().getText());
            peminjaman.setAnggota(anggota);
            peminjaman.setBuku(buku);
            peminjaman.setTglpinjam(formPeminjaman.getTxtTglPinjam().getText());
            
            try {
                dao.Update(peminjaman);
                JOptionPane.showMessageDialog(formPeminjaman, "Update Data Ok!");
            } catch (Exception ex) {
                Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Delete() {
        try {
            if (peminjaman != null) {
                dao.Delete(peminjaman);
            } else {
                JOptionPane.showMessageDialog(formPeminjaman, "Data Not Found");
            }

        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void anggotaCodeOption() {
        try {
            List<Anggota> anggotaList = anggotaDao.getAllAnggota();
            formPeminjaman.getoptionAnggota().removeAllItems();
            for (Anggota anggota : anggotaList) {
                formPeminjaman.getoptionAnggota().addItem(anggota.getKode() + "-" + anggota.getNama());
            }
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void bukuCodeOption() {
        try {
            List<Buku> bukuList = bukuDao.getAllBuku();
            formPeminjaman.getoptionBuku().removeAllItems();
            for (Buku buku : bukuList) {
                formPeminjaman.getoptionBuku().addItem(buku.getKode());
            }
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void search() {
        try {
            String kodeAnggota = formPeminjaman.getoptionAnggota()
                    .getSelectedItem().toString().split("-")[0];
            String kodeBuku = formPeminjaman.getoptionBuku()
                    .getSelectedItem().toString();
            String tglPinjam = formPeminjaman.getTxtTglPinjam().getText();
            peminjaman = dao.getPeminjaman(kodeAnggota, kodeBuku, tglPinjam);

            if (peminjaman != null) {
                formPeminjaman.getoptionAnggota().setSelectedItem(peminjaman.getAnggota().getKode() + "-" + peminjaman.getAnggota().getNama());
                formPeminjaman.getoptionBuku().setSelectedItem(peminjaman.getBuku().getKode());
                formPeminjaman.getTxtTglPinjam().setText(peminjaman.getTglpinjam());
                formPeminjaman.getTxtTglKembali().setText(peminjaman.getTglkembali());
            } else {
                JOptionPane.showMessageDialog(formPeminjaman, "Data not found!");
            }
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void viewData() {

        try {
            DefaultTableModel model = (DefaultTableModel) formPeminjaman.getTblPeminjaman().getModel();

            model.setNumRows(0);
            List<Peminjaman> list = dao.getAllPeminjaman();
            for (Peminjaman peminjaman : list) {
                Object[] data = {
                    peminjaman.getAnggota().getKode(),
                    peminjaman.getBuku().getKode(),
                    peminjaman.getTglpinjam(),
                    peminjaman.getTglkembali()
                };
                model.addRow(data);
            }
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
