package model.bo;

import java.util.ArrayList;

import model.bean.AUTDPHKM;
import model.bean.AUTMFOPM;
import model.dao.AUTDPHKMDAO;

public class AUTDPHKMBO {
	AUTDPHKMDAO autDPHKMDAO = new AUTDPHKMDAO();
	public ArrayList<AUTMFOPM> getCombo() {
		return autDPHKMDAO.getCombo();
	}
	public boolean addAUTDPHKM(AUTDPHKM autDPHKM) {
		return autDPHKMDAO.addAUTDPHKM(autDPHKM);
	}
	public String refer(String refer) {
		return autDPHKMDAO.refer(refer);
		
	}
	public boolean isDPHKM_DEPO_exist(String dPHKM_DEPO) {
		return autDPHKMDAO.isDPHKM_DEPO_exist(dPHKM_DEPO);
	}
	public boolean isDPHKM_PART_exist(String dPHKM_PART) {
		return autDPHKMDAO.isDPHKM_PART_exist(dPHKM_PART);
	}
	public boolean isAUTDPHKM_exist(String dPHKM_KKCD, String dPHKM_SSCD, String dPHKM_FORM,
			String dPHKM_DEPO, String dPHKM_PART, String dPHKM_SYCD) {
		return autDPHKMDAO.isAUTDPHKM_exist(dPHKM_KKCD, dPHKM_SSCD, dPHKM_FORM,
			 dPHKM_DEPO, dPHKM_PART, dPHKM_SYCD);
	}
}
