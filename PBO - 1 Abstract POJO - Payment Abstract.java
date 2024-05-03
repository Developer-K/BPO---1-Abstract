// Payment Abstract
public abstract class Pembayaran 
{

    private int idPembayaran;
    private double jumlahPembayaran;
    private String statusPembayaran;

    public Pembayaran(int idPembayaran, double jumlahPembayaran) 
    {
        this.idPembayaran = idPembayaran;
        this.jumlahPembayaran = jumlahPembayaran;
        this.statusPembayaran = "Belum Dibayar";
    }

    public int getIdPembayaran() {
        return idPembayaran;
    }

    public double getJumlahPembayaran() {
        return jumlahPembayaran;
    }

    public String getStatusPembayaran() {
        return statusPembayaran;
    }

    public abstract void prosesPembayaran();

    public void setStatusPembayaran(String statusPembayaran) {
        this.statusPembayaran = statusPembayaran;
    }
}

// Payment Cash
public class PembayaranTunai extends Pembayaran {

    private double nominalUangTunaiDiterima;

    public PembayaranTunai(int idPembayaran, double jumlahPembayaran, double nominalUangTunaiDiterima) {
        super(idPembayaran, jumlahPembayaran);
        this.nominalUangTunaiDiterima = nominalUangTunaiDiterima;
    }

    @Override
    public void prosesPembayaran() {
        // Simulasikan proses pembayaran tunai (misalnya, periksa nominal uang tunai yang diterima)
        System.out.println("Memproses pembayaran tunai untuk ID pembayaran: " + getIdPembayaran());
        if (nominalUangTunaiDiterima >= getJumlahPembayaran()) {
            setStatusPembayaran("Lunas");
            System.out.println("Pembayaran tunai untuk ID pembayaran: " + getIdPembayaran() + " lunas.");
        } else {
            setStatusPembayaran("Kurang Bayar");
            System.out.println("Pembayaran tunai untuk ID pembayaran: " + getIdPembayaran() + " kurang bayar.");
        }
    }

    public double getNominalUangTunaiDiterima() {
        return nominalUangTunaiDiterima;
    }
}

public class PembayaranKartu extends Pembayaran 
{

    private String nomorKartu;
    private String tanggalKedaluwarsa;
    private String cvv;

    public PembayaranKartu(int idPembayaran, double jumlahPembayaran, String nomorKartu, String tanggalKedaluwarsa, String cvv) {
        super(idPembayaran, jumlahPembayaran);
        this.nomorKartu = nomorKartu;
        this.tanggalKedaluwarsa = tanggalKedaluwarsa;
        this.cvv = cvv;
    }

    // Payment CVV
    @Override
    public void prosesPembayaran() {
        // Simulasikan proses pembayaran kartu (misalnya, hubungi gateway pembayaran)
        System.out.println("Memproses pembayaran kartu untuk ID pembayaran: " + getIdPembayaran());
        // Implementasi logika validasi dan proses pembayaran kartu
        setStatusPembayaran("Lunas");
        System.out.println("Pembayaran kartu untuk ID pembayaran: " + getIdPembayaran() + " lunas.");
    }

    public String getNomorKartu() {
        return nomorKartu;
    }

    public String getTanggalKedaluwarsa() {
        return tanggalKedaluwarsa;
    }

    public String getCvv() {
        return cvv;
    }
}
