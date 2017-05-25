package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.AUTDPHKM;
import model.bean.AUTMFOPM;

/**
 * AUTDPHKMForm.java
 *
 * Version 1.0
 *
 * Date: May 18, 2017
 *
 * Copyright 
 *
 * Modification Logs:
 * DATE                 AUTHOR          DESCRIPTION
 * -----------------------------------------------------------------------
 * May 18, 2017        	KhoaPVT          Create
 */
public class AUTDPHKMForm extends ActionForm{
	private String[] dPHKM_KKCD = {"", "", "", "" ,"", "", "", "", "", "", ""};
	private String[] dPHKM_SSCD = {"", "", "", "" ,"", "", "", "", "", "", ""};
	private String[] tOKIM_RYAK = {"", "", "", "" ,"", "", "", "", "", "", ""};
	private String[] dPHKM_FORM = {"", "", "", "" ,"", "", "", "", "", "", ""};
	private String[] dPHKM_DEPO = {"", "", "", "" ,"", "", "", "", "", "", ""};
	private String[] mFOPM_NAME = {"", "", "", "" ,"", "", "", "", "", "", ""};
	private String[] dPHKM_PART = {"", "", "", "" ,"", "", "", "", "", "", ""};
	private String[] dPHKM_SYCD = {"", "", "", "" ,"", "", "", "", "", "", ""};
	private AUTDPHKM autDPHKM;
	private String submit;
	private String thongBao;
	private Integer[] number = {1,2,3,4,5,6,7,8,9,10};
	private ArrayList<AUTMFOPM> combo;
	private int id;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getdPHKM_KKCD(int index) {
		return dPHKM_KKCD[index];
	}

	public void setdPHKM_KKCD(int index, String dPHKM_KKCD) {
		this.dPHKM_KKCD[index] = dPHKM_KKCD;
	}

	public String getdPHKM_SSCD(int index) {
		return dPHKM_SSCD[index];
	}

	public void setdPHKM_SSCD(int index ,String dPHKM_SSCD) {
		this.dPHKM_SSCD[index] = dPHKM_SSCD;
	}

	public String getdPHKM_FORM(int index) {
		return dPHKM_FORM[index];
	}

	public void setdPHKM_FORM(int index ,String dPHKM_FORM) {
		this.dPHKM_FORM[index] = dPHKM_FORM;
	}

	public String[] getdPHKM_DEPO() {
		return dPHKM_DEPO;
	}
	public String getdPHKM_DEPO(int index) {
		return dPHKM_DEPO[index];
	}

	public void setdPHKM_DEPO(int index ,String dPHKM_DEPO) {
		this.dPHKM_DEPO[index] = dPHKM_DEPO;
	}

	public String getdPHKM_PART(int index) {
		return dPHKM_PART[index];
	}

	public void setdPHKM_PART(int index ,String dPHKM_PART) {
		this.dPHKM_PART[index] = dPHKM_PART;
	}

	public String getdPHKM_SYCD(int index) {
		return dPHKM_SYCD[index];
	}

	public void setdPHKM_SYCD(int index ,String dPHKM_SYCD) {
		this.dPHKM_SYCD[index] = dPHKM_SYCD;
	}
	public AUTDPHKM getAutDPHKM() {
		return autDPHKM;
	}
	public void setAutDPHKM(AUTDPHKM autDPHKM) {
		this.autDPHKM = autDPHKM;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public String getThongBao() {
		return thongBao;
	}
	public void setThongBao(String thongBao) {
		this.thongBao = thongBao;
	}
	public Integer[] getNumber() {
		return number;
	}
	public void setNumber(Integer[] number) {
		this.number = number;
	}
	public ArrayList<AUTMFOPM> getCombo() {
		return combo;
	}
	public void setCombo(ArrayList<AUTMFOPM> combo) {
		this.combo = combo;
	}

	public String getmFOPM_NAME(int index) {
		return mFOPM_NAME[index];
	}

	public void setmFOPM_NAME(int index,String mFOPM_NAME) {
		this.mFOPM_NAME[index] = mFOPM_NAME;
	}

	public String gettOKIM_RYAK(int index) {
		return tOKIM_RYAK[index];
	}

	public void settOKIM_RYAK(int index ,String tOKIM_RYAK) {
		this.tOKIM_RYAK[index] = tOKIM_RYAK;
	}


	
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
}
