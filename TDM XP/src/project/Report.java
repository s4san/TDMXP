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

import java.io.*;

public class Report {

	//Identifiers storing project details
	private String project_Name ;
	private String project_Source ;
	private double project_Debt = 0;
	private double project_Cost = 0;
	
	//Identifiers that will be used, when storing results and for calculations
	public int no_Of_Duplications = 1;
	public int no_Of_Violations = 1;
	public int no_Of_DBAccesses = 1;	
	public int no_Of_CommentedAPIs = 1;	
	public int no_Of_UnCommentedAPIs = 1;	
	public int no_Of_Invalidations = 1;
	
	//Analysis details of the current project
	public int no_Of_Classes;	
	public int no_Of_Methods;	
	public int no_Of_GlobalVars;	
	public int no_Of_LocalVars;	
	public int no_Of_StaticVars;	
	public int no_Of_UnusedVars;	
	public int total_Vars;	
	public int no_Of_FunctionCalls;
	
	public int NLOC; // NLOC Number of Lines Of Code	
	private BufferedReader reader;

	public double get_Project_Debt() {
		return project_Debt;
	}

	public void set_Project_Debt(double debt) {
		project_Debt = debt;
	}

	public void set_Project_Cost(double cost) {
		project_Cost = cost;		
	}
		
	public String get_Project_Source() {
		return project_Source;
	}

	public String get_Project_Name() {
		return project_Name;
	}

	public double get_Project_Cost() {
		return project_Cost;
	}
	
	public void set_Project_Attributes(String name, String source) {
		project_Name = name ;
		project_Source = source ;
	}
	public void print_Initial_Analysis_Report() {
		System.out.printf("\n>>%-25s%75s","Project Name",project_Name);
		System.out.printf("\n>>%-25s%75s","Project Source",project_Source);
		System.out.printf("\n>>%-25s%75d","NLOC",NLOC);
		/*System.out.printf("\n>>%-25s%75d","No of classes",no_Of_Classes);
		System.out.printf("\n>>%-25s","No of methods");
		System.out.printf("\n>>%-25s","No of identifiers used");
			*/
	}
	
	public void print_Debt_Report()	{
		System.out.printf("\n>>%-25s%75s","Debt ",Double.toString(project_Debt)+" days");
		System.out.printf("\n>>%-25s%75s","Cost incurring ",Double.toString(project_Cost)+" Rs");
	}

	public void update_Report() throws IOException {
		File newFile = new File("src/project/Update.txt");
		reader = new BufferedReader(new FileReader(newFile));
		String line = null;
		String[] values;
		while(reader.ready()){
			line = reader.readLine();
		}
		values = line.split(" ");
		no_Of_Duplications = Integer.parseInt(values[0]);
		no_Of_Violations = Integer.parseInt(values[1]);
		no_Of_DBAccesses = Integer.parseInt(values[2]);
		no_Of_CommentedAPIs = Integer.parseInt(values[3]);
		no_Of_UnCommentedAPIs = Integer.parseInt(values[4]);
		no_Of_Invalidations = Integer.parseInt(values[5]);
		}

	
	
}

