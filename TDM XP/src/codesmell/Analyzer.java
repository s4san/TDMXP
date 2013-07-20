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

package codesmell;

//Predefined package imports
import java.io.*;
//TDM based package imports
import project.Report;

public class Analyzer {


	private BufferedReader reader;

	public void Analyze_All( String filePath, Report newReport ) throws IOException {
		
			String name;
			String source;
			String input;
			int LOC = 0 ;
			File newFile = new File(filePath);
			reader = new BufferedReader(new FileReader(newFile));
	
			//Checking for file existence
			if(!newFile.exists())	{
				System.out.println(">>FILE not found ... Terminating");
				System.exit(0);
			}
			
			/* Retrieving file properties*/
				name = newFile.getName();
				source = newFile.getAbsolutePath();
			//Setting project properties to report file
			newReport.set_Project_Attributes( name , source );
			
			//Initial Analysis of project file
			/*Pattern pattern = pattern.compile("(public|protected|private|static|\s) +[\w\<\>\[\]]+\s+(\w+) *\([^\)]*\) *(\{?|[^;])" );
			Matcher matcher;*/
			while( reader.ready() )	{
				input = reader.readLine();
				LOC += 1;
				if(input.matches("(.*)class(.*)")){
				}
				/*matcher = pattern.matcher(input);
				if(matcher.matches()){
					no_Of_Methods += 1;
				}*/
			}
			newReport.NLOC = LOC ;	
			/*newReport.no_Of_Classes = no_Of_Classes;*/
	}

}
