package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import model.bean.AUTDPHKM;
import model.bean.AUTMFOPM;
import model.dao.AUTDPHKMDAO;

public class AUTDPHKMDAOTest extends TestCase{

	protected AUTDPHKMDAO autDPHKMDAO;
	protected AUTMFOPM autMFOPM;
	protected AUTDPHKM autDPHKM;
	protected ArrayList<AUTMFOPM> comboExpected;
	protected ArrayList<AUTMFOPM> comboActual;
	protected String dPHKM_DEPO;
	protected String dPHKM_PART;
	protected String dPHKM_KKCD;
	protected String dPHKM_SSCD;
	protected String dPHKM_FORM;
	protected String dPHKM_SYCD;
	protected String refer;
	protected String resultExpected;
	protected String resultActual;
	protected boolean resultAddActual;
	protected boolean isDPHKM_DEPO_existActual;
	protected boolean isDPHKM_PART_existActual;
	protected boolean isAUTDPHKM_existActual;
	
	/**
     * Called when before test
     * 
     * @throws java.lang.Exception
     */
	@Before
	public void setUp() throws Exception {
		autDPHKMDAO = new AUTDPHKMDAO();
		
		// Create result for function getCombo
		comboExpected = new ArrayList<AUTMFOPM>();
		autMFOPM = new AUTMFOPM();
		autMFOPM.setmFOPM_TRCD("01");
		comboExpected.add(autMFOPM);
		autMFOPM.setmFOPM_TRCD("02");
		comboExpected.add(autMFOPM);
		autMFOPM.setmFOPM_TRCD("03");
		comboExpected.add(autMFOPM);
		autMFOPM.setmFOPM_TRCD("04");
		comboExpected.add(autMFOPM);
		autMFOPM.setmFOPM_TRCD("05");
		comboExpected.add(autMFOPM);
		
		comboActual = autDPHKMDAO.getCombo();
		
		// Create result for function refer
		resultExpected = "出荷デポ名1         ";
		resultExpected = "出荷デポ名2         ";
		resultExpected = "出荷デポ名3         ";
		resultExpected = "出荷デポ名4         ";
		resultExpected = "出荷デポ名5         ";
		
		resultActual = autDPHKMDAO.refer("1");
		resultActual = autDPHKMDAO.refer("2");
		resultActual = autDPHKMDAO.refer("3");
		resultActual = autDPHKMDAO.refer("4");
		resultActual = autDPHKMDAO.refer("5");
		
		// Create result for function addAUTDPHKM
		resultAddActual = autDPHKMDAO.addAUTDPHKM(new AUTDPHKM("1", "1", "1", "1", "1", "1"));
		resultAddActual = autDPHKMDAO.addAUTDPHKM(new AUTDPHKM("2", "2", "2", "2", "2", "2"));
		
		// Create result for function isDPHKM_DEPO_exist
		isDPHKM_DEPO_existActual = autDPHKMDAO.isDPHKM_DEPO_exist("1");
		isDPHKM_DEPO_existActual = autDPHKMDAO.isDPHKM_DEPO_exist("6");
		
		// Create result for function isDPHKM_PART_exist
		isDPHKM_PART_existActual = autDPHKMDAO.isDPHKM_PART_exist("1");
		isDPHKM_PART_existActual = autDPHKMDAO.isDPHKM_PART_exist("6");
		
		// Create result for function isAUTDPHKM_exist
		isAUTDPHKM_existActual = autDPHKMDAO.isAUTDPHKM_exist("1", "1", "1", "1", "1", "1");
		isAUTDPHKM_existActual = autDPHKMDAO.isAUTDPHKM_exist("2", "2", "2", "2", "2", "2");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetCombo() {
		assertEquals(comboExpected.get(0).getmFOPM_TRCD(),comboActual.get(0).getmFOPM_TRCD());
		assertEquals(comboExpected.get(1).getmFOPM_TRCD(),comboActual.get(1).getmFOPM_TRCD());
		assertEquals(comboExpected.get(2).getmFOPM_TRCD(),comboActual.get(2).getmFOPM_TRCD());
		assertEquals(comboExpected.get(3).getmFOPM_TRCD(),comboActual.get(3).getmFOPM_TRCD());
		assertEquals(comboExpected.get(4).getmFOPM_TRCD(),comboActual.get(4).getmFOPM_TRCD());
	}
	
	@Test
	public void testRefer() {
		assertEquals(resultExpected,resultActual);
	}
	
	@Test
	public void testAddAUTDPHKM() {
		assertFalse(resultAddActual);
		assertTrue(resultAddActual);
	}
	
	@Test
	public void testIsDPHKM_DEPO_exist() {
		assertTrue(isDPHKM_DEPO_existActual);
		assertFalse(isDPHKM_DEPO_existActual);
	}
	
	@Test
	public void testIsDPHKM_PART_exist() {
		assertTrue(isDPHKM_PART_existActual);
		assertFalse(isDPHKM_PART_existActual);
	}
	
	@Test
	public void testIsAUTDPHKM_exist() {
		assertTrue(isAUTDPHKM_existActual);
		assertFalse(isAUTDPHKM_existActual);
	}


}
