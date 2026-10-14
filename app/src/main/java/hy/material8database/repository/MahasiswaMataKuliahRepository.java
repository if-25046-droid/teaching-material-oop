package hy.material8database.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import hy.material8database.database.Database;

public class MahasiswaMataKuliahRepository {
    private static final Connection conn;

    static {
        conn = Database.connect();
    }

    public static void ambilMatakuliah(String nim, String kodeMatakuliah){
        String sql = "INSERT INTO mahasiswa_matakuliah (nim, kode_matakuliah) VALUES (?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nim);
            ps.setString(2, kodeMatakuliah);
            ps.executeUpdate();
            System.out.println("Matakuliah berhasil diambil!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
