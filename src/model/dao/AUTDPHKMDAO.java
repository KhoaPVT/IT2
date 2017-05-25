package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.AUTDPHKM;
import model.bean.AUTMFOPM;

public class AUTDPHKMDAO {

	//Start ket noi voi Database
		String url = "jdbc:sqlserver://localhost:1433;databaseName=IT2";
		String userName = "sa";
		String password = "12345678";
		Connection connection;
		public boolean connect(){
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				connection = DriverManager.getConnection(url, userName, password);
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				return false;
			}
		}
		//End
	public ArrayList<AUTMFOPM> getCombo() {
		connect();
		String sql=	"SELECT MFOPM_TRCD FROM AUTMFOPM";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<AUTMFOPM> combo = new ArrayList<AUTMFOPM>();
		AUTMFOPM autMFOPM;
		try {
				while(rs.next()){
					autMFOPM = new AUTMFOPM();
					autMFOPM.setmFOPM_TRCD(rs.getString("MFOPM_TRCD"));
					combo.add(autMFOPM);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return combo;
	}
	
	public boolean isDPHKM_DEPO_exist(String dPHKM_DEPO){
		connect();
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs =stmt.executeQuery("SELECT MFOPM_DEPO from AUTMFOPM WHERE MFOPM_DEPO = '"+dPHKM_DEPO+"'");
			 if(rs.next()){
				 return true;
			 }
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean isDPHKM_PART_exist(String dPHKM_PART){
		connect();
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs =stmt.executeQuery("SELECT ITMCM_PART from AUTITMCM  WHERE ITMCM_PART = '"+dPHKM_PART+"'");
			 if(rs.next()){
				 return true;
			 }
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean isAUTDPHKM_exist(String dPHKM_KKCD, String dPHKM_SSCD, String dPHKM_FORM, String dPHKM_PART, String dPHKM_SYCD, String dPHKM_DEPO){
		connect();
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs =stmt.executeQuery("SELECT * from AUTDPHKM  WHERE DPHKM_KKCD='"+dPHKM_KKCD+"'AND DPHKM_SSCD='"+dPHKM_SSCD+"'AND DPHKM_FORM='"
					+dPHKM_FORM+"'AND DPHKM_PART='"+dPHKM_PART+"'AND DPHKM_SYCD='"+dPHKM_SYCD+"'AND DPHKM_DEPO = '"+dPHKM_DEPO+"'");
			 if(rs.next()){
				 return true;
			 }
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean addAUTDPHKM(AUTDPHKM autDPHKM) {
		connect();
		String sql = "INSERT INTO AUTDPHKM (DPHKM_KKCD, DPHKM_SSCD, DPHKM_FORM, DPHKM_DEPO, DPHKM_PART, DPHKM_SYCD) VALUES (?,?,?,?,?,?)";
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, autDPHKM.getdPHKM_KKCD());
			pstm.setString(2, autDPHKM.getdPHKM_SSCD());
			pstm.setString(3, autDPHKM.getdPHKM_FORM());
			pstm.setString(4, autDPHKM.getdPHKM_DEPO());
			pstm.setString(5, autDPHKM.getdPHKM_PART());
			pstm.setString(6, autDPHKM.getdPHKM_SYCD());
			pstm.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public String refer(String refer) {
		connect();
		String sql=	"SELECT MFOPM_NAME FROM AUTMFOPM WHERE MFOPM_DEPO = '"+refer+"'";
		String result = null;
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while(rs.next()){
				result = rs.getString("MFOPM_NAME");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
