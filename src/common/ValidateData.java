package common;

/**
 * ValidateData.java
 *
 * Version 1.0
 *
 * Date: May 22, 2017
 *
 * Copyright 
 *
 * Modification Logs:
 * DATE                 AUTHOR          DESCRIPTION
 * -----------------------------------------------------------------------
 * May 22, 2017        	KhoaPVT          Create
 */
public class ValidateData {
	public static boolean isEmptyString(String s) {
		if (s.trim() == null || (s.trim()).length() == 0)
			return true;
		return false;
	}
	
	
}
