package hy.material8database.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hy.material8database.database.Database;
import hy.material8database.models.Matakuliah;

public class MataKuliahRepository{
    private static final Connection conn;

    static {
        conn = Database.connect();
    }

    public static void addMataKuliah(Matakuliah mk) {
        String sql = "INSERT INTO matakuliah (kode_matakuliah, nama, sks, kodeJurusan) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, mk.kodeMatakuliah);
            preparedStatement.setString(2, mk.nama);
            preparedStatement.setInt(3, mk.sks);
            preparedStatement.setString(4, mk.kodeJurusan);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Matakuliah> getAllMataKuliah() {
        List<Matakuliah> result = new ArrayList<>();
        String sql = "SELECT * FROM matakuliah";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                result.add(
                    new Matakuliah(
                        resultSet.getString("nama"),
                        resultSet.getInt("sks"),
                        resultSet.getString("kodeJurusan"),
                        resultSet.getString("kode_matakuliah")
                    )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void updateMataKuliah(Matakuliah mk) {
        String sql = "UPDATE matakuliah SET nama = ?, sks = ?, kodeJurusan = ? WHERE kode_matakuliah = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, mk.nama);
            preparedStatement.setInt(2, mk.sks);
            preparedStatement.setString(3, mk.kodeJurusan);
            preparedStatement.setString(4, mk.kodeMatakuliah);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void deleteMataKuliah(Matakuliah mk) {
        String sql = "DELETE FROM matakuliah WHERE kode_matakuliah = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, mk.kodeMatakuliah);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
            