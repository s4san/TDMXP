/*
 * TDM, open source software quality management tool.
 * Copyright (C) 2011-2012 Sandeep,Sreeni,Deena
 * mailto: { msandeepkumar,srini211 } AT hotmail DOT com
 *
 * TDM is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * TDM is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with TDM; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */

package project;

//Predefined package imports
import java.io.*;
//TDM based package imports
import codesmell.Analyzer;
import project.Report;
import calculation.Calculate;

public class Project {

	
	public static void main(String[] args) {
	
		//initializing globals to be used throughout the program
		Analyzer newScanner = new Analyzer();
		Report newReport = new Report();
		Calculate newDebt = new Calculate();
		
		//initial test file for testing purpose
		String filePath = "src/Samples/Point3d.java";
		
		System.out.println();
		
		System.out.println(">>TDM - CLI INTERFACE");
		
		System.out.printf("\n");
		
	
		try {
			newScanner.Analyze_All(filePath, newReport);
		} catch (IOException e) {}
		
		newReport.print_Initial_Analysis_Report();
		
		try {
			newReport.update_Report();
		} catch (IOException e) {}
		
		newDebt.debt_calculate( newReport );
		
		newReport.print_Debt_Report();
	}

}
