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

package calculation;

import project.Report;
import calculation.Configuration;

public class Calculate {

		Report currentReport = new Report();
		Configuration currentConfiguration = new Configuration();
		
		double Duplications = 0;
		double Violations = 0;
	    double DBAccesses = 0;
		double CommentedAPIs;
		double UnCommentedAPIs = 0;
		double Invalidations = 0;
		double debt;
		double cost;
		
		
		public int debt_Validate_Constants( Report currentReport )	{
						
			if(currentReport.no_Of_DBAccesses!= 0){
				DBAccesses =  currentReport.no_Of_DBAccesses;
			}	else {
				System.out.println("Value missing...Please run the DBAccess module");
				return 0;
			}
			if(currentReport.no_Of_Duplications!= 0){
				Duplications = currentReport.no_Of_Duplications;
			}	else {
				System.out.println("Value missing...Please run the Duplication module"); 
				return 0;
			}
			if(currentReport.no_Of_Violations!= 0){
				Violations = currentReport.no_Of_Violations;
			}	else {
				System.out.println("Value missing...Please run the Violation module"); 
				return 0;
			}
			if(currentReport.no_Of_UnCommentedAPIs!= 0){
				UnCommentedAPIs = currentReport.no_Of_UnCommentedAPIs;
			}	else {
				System.out.println("Value missing...Please run the Comment module"); 
				return 0;
			}
			if(currentReport.no_Of_Invalidations!= 0){
				Invalidations = currentReport.no_Of_Invalidations;
			}	else {
				System.out.println("Value missing...Please run the Smells module"); 
				return 0;
			}
			
			return 1;
		}
		
		public void debt_calculate( Report currentReport )	{
		
		if(debt_Validate_Constants( currentReport )!=0)	{	
			//debt calculation
			debt = ( Duplications * currentConfiguration.Duplication_Cost) +
				( Violations * currentConfiguration.Violation_Cost) +
				( DBAccesses * currentConfiguration.DBAccess_Cost) +
				( UnCommentedAPIs * currentConfiguration.Comment_Cost) +
				( Invalidations * currentConfiguration.Invalidation_Cost);
		   //cost calculation
			cost = debt * currentConfiguration.Cost_Per_Day;
			
		currentReport.set_Project_Debt(debt);
		currentReport.set_Project_Cost(cost);
		}
		
	    }
		
}
