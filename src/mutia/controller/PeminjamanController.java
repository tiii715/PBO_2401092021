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

    FormPeminjaman formPeminjaman;
    Peminjaman peminjaman;
    PeminjamanDao peminjamanDao;
    AnggotaDao anggotaDao;
    BukuDao bukuDao;

    public PeminjamanController(FormPeminjaman formPeminjaman) {
        this.formPeminjaman = formPeminjaman;
        peminjamanDao = new PeminjamanDao();
        anggotaDao = new AnggotaDao();
        bukuDao = new BukuDao();
    }

    public void insert() {
        try {
            peminjaman = new Peminjaman();
            String kodeanggota = formPeminjaman.getCboAnggota()
                    .getSelectedItem().toString().split("-")[0];
            String kodebuku = formPeminjaman.getCboBuku()
                    .getSelectedItem().toString();
            Anggota anggota = anggotaDao.getAnggota(kodeanggota);
            Buku buku = bukuDao.getBuku(kodebuku);
            peminjaman.setAnggota(anggota);
            peminjaman.setBuku(buku);
            peminjaman.setTglpinjam(formPeminjaman.getTxtTglPinjam().getText());
            peminjaman.setTglkembali(formPeminjaman.getTxtTglKembali().getText());
            peminjamanDao.insert(peminjaman);
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void search() {
        String kodeanggota = formPeminjaman.getCboAnggota()
                .getSelectedItem().toString().split("-")[0];
        String kodebuku = formPeminjaman.getCboBuku()
                .getSelectedItem().toString();
        String tglpinjam = formPeminjaman.getTxtTglPinjam().getText();
        try {
            peminjaman = peminjamanDao.getPeminjaman(kodeanggota, kodebuku, tglpinjam);
            if (peminjaman != null) {
                formPeminjaman.getTxtTglKembali().setText(peminjaman.getTglkembali());
            } else {
                JOptionPane.showMessageDialog(formPeminjaman, "Data tidak ada");
            }

        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void bersihForm() {
        isiCboAnggota();
        isiCboBuku();
        formPeminjaman.getTxtTglPinjam().setText("");
        formPeminjaman.getTxtTglKembali().setText("");
    }

    private void isiCboAnggota() {
        try {
            List<Anggota> anggotaList = anggotaDao.getAllAnggota();
            formPeminjaman.getCboAnggota().removeAllItems();
            for (Anggota anggota : anggotaList) {
                formPeminjaman.getCboAnggota().
                        addItem(anggota.getKode() + "-" + anggota.getNama());
            }
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void isiCboBuku() {
        try {
            List<Buku> bukuList = bukuDao.getAllBuku();
            formPeminjaman.getCboBuku().removeAllItems();
            for (Buku buku : bukuList) {
                formPeminjaman.getCboBuku().addItem(buku.getKode());
            }
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void viewData() {
        try {
            DefaultTableModel model = (DefaultTableModel) formPeminjaman.getTblPeminjaman().getModel();
            model.setNumRows(0);
            List<Peminjaman> list = peminjamanDao.getAll();
            for (Peminjaman peminjaman : list) {
                Object[] data = {
                    peminjaman.getAnggota().getKode(),
                    peminjaman.getAnggota().getNama(),
                    peminjaman.getBuku().getKode(),
                    peminjaman.getTglpinjam(),
                    peminjaman.getTglkembali(),};
                model.addRow(data);
            }
        } catch (Exception ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
