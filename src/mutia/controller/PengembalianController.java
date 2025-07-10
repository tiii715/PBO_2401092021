/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mutia.controller;

import mutia.dao.AnggotaDao;
import mutia.dao.BukuDao;
import mutia.dao.PeminjamanDao;
import mutia.dao.PengembalianDao;
import mutia.model.Anggota;
import mutia.model.Buku;
import mutia.model.Peminjaman;
import mutia.model.Pengembalian;
import mutia.view.FormPengembalian;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class PengembalianController {

    FormPengembalian formPengembalian;
    Pengembalian pengembalian;
    AnggotaDao anggotaDao;
    BukuDao bukuDao;
    PeminjamanDao peminjamanDao;
    PengembalianDao pengembalianDao;
    Peminjaman peminjaman;
    public PengembalianController(FormPengembalian formPengembalian) {
        this.formPengembalian = formPengembalian;
        anggotaDao = new AnggotaDao();
        bukuDao = new BukuDao();
        peminjamanDao = new PeminjamanDao();
        pengembalianDao = new PengembalianDao();
    }

    public void bersihForm() {
        isiCboAnggota();
        isiCboBuku();
        formPengembalian.getTxtTglPinjam().setText("");
        formPengembalian.getTxtTglKembali().setText("");
        formPengembalian.getTxtTglDikembalikan().setText("");
        formPengembalian.getTxtTerlambat().setText("");
        formPengembalian.getTxtDenda().setText("");
    }

    private void isiCboAnggota() {
        try {
            List<Anggota> anggotaList = anggotaDao.getAllAnggota();
            formPengembalian.getCboAnggota().removeAllItems();
            for (Anggota anggota : anggotaList) {
                formPengembalian.getCboAnggota().
                        addItem(anggota.getKode() + "-" + anggota.getNama());
            }
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void isiCboBuku() {
        try {
            List<Buku> bukuList = bukuDao.getAllBuku();
            formPengembalian.getCboBuku().removeAllItems();
            for (Buku buku : bukuList) {
                formPengembalian.getCboBuku().addItem(buku.getKode());
            }
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void searchPinjam() {
        String kodeanggota = formPengembalian.getCboAnggota()
                .getSelectedItem().toString().split("-")[0];
        String kodebuku = formPengembalian.getCboBuku()
                .getSelectedItem().toString();
        String tglpinjam = formPengembalian.getTxtTglPinjam().getText();
        try {
            peminjaman = peminjamanDao.getPeminjaman(kodeanggota, kodebuku, tglpinjam);
            if (peminjaman != null) {
                formPengembalian.getTxtTglKembali().setText(peminjaman.getTglkembali());
            } else {
                JOptionPane.showMessageDialog(formPengembalian, "Data tidak ada");
            }

        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void proses(){
       String tglkembali = formPengembalian.getTxtTglKembali().getText();
       String tglDikembalikan = formPengembalian.getTxtTglDikembalikan().getText();
        try {
            int hasil = pengembalianDao.getKurangTanggal(tglDikembalikan, tglkembali);
            pengembalian = new Pengembalian();
            pengembalian.setPeminjaman(peminjaman); 
            pengembalian.setTerlambat(hasil);
            pengembalian.setDenda(pengembalian.getDenda());
            formPengembalian.getTxtTerlambat().setText(""+hasil);
            formPengembalian.getTxtDenda().setText(""+pengembalian.getDenda());
            
        } catch (Exception ex) {
            Logger.getLogger(PengembalianController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
