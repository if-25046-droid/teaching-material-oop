package hy.material8database.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hy.material8database.database.Database;
import hy.material8database.models.Jurusan;

public class JurusanRepository {
    private static final Connection conn;

    static {
        conn = Database.connect();
    }


    public static void addJurusan(Jurusan J) {
        String sql = "INSERT INTO Jurusan (nama, kodeJurusan) VALUES (?, ?)";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, J.nama);
            preparedStatement.setString(2, J.kodeJurusan);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Jurusan> getAllJurusan() {
        List<Jurusan> result = new ArrayList<>();
        String sql = "SELECT * FROM Jurusan";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                result.add(
                    new Jurusan(
                        resultSet.getString("nama"),
                        resultSet.getString("kodeJurusan")
                    )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void updateMataKuliah(Jurusan J) {
        String sql = "UPDATE Jurusan SET nama = ? WHERE kodeJurusan = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, J.nama);
            preparedStatement.setString(2, J.kodeJurusan);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteMataKuliah(Jurusan J) {
        String sql = "DELETE FROM Jurusan WHERE kode_Jurusan = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, J.kodeJurusan);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
}
        
