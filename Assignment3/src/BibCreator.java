/*
 * Fouad Serradj | ID : 40009794 
 * COMP249
 * Assignment # 3 
 * Due Date :  Friday November 9 11h59pm 2018
 * 
 */

import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


public class BibCreator {
	
	static final String empty ="{}" ;
	static final String Author = "author" ;
	static final String Journal = "journal" ;
	static final String Title = "title" ;
	static final String Year = "year" ;
	static final String Volume = "volume" ;
	static final String Number = "number" ;
	static final String Pages = "pages" ;
	static final String KeyWords = "keywords" ;
	static final String Doi = "doi" ;
	static final String ISSN = "ISSN" ;
	static final String Month = "month" ;

	/*
	 * Main core method
	 * Parameters : Scanner of the Latex file alongside with the index of the file
	 * 3 Parameters of Printwriter according to the created files IEEE, ACM and NJ
	 * Exception is handled in the main method 
	 * 
	 * Important : Temp.txt file is a temporary file to store and treat each article
	 */
	public static void processFilesForValidation(int i,Scanner sc, PrintWriter pw1, PrintWriter pw2, PrintWriter pw3) throws FileInvalidException {
		
		String author = "", journal="", title="", year="", volume="", number="", pages = "", keywords="", doi="", issn="", month="" ;
		String IEEEFormat = "";
		String ACMFormat = "";
		String NJFormat = "";
		int n = 0 ; // variable to store the index of the article treated, thus that will contain the empty field
		int j = 1 ;
		
		try {
			
			PrintWriter pw = new PrintWriter(new FileOutputStream("temp.txt"));
			String output ;
			sc.useDelimiter("@ARTICLE");
		
			while(sc.hasNext()) {
			String line = sc.next();
			n++ ;
			pw.println(line);
			pw.flush();
			Scanner scanner = new Scanner(new FileInputStream("temp.txt"));
				
				while(scanner.hasNextLine()) {
				
					output = scanner.nextLine();
				
				if(output.contains(Author)) {
					if(line.contains(empty)) {
						
						scanner.close();
						throw new FileInvalidException("Error : Empty field Detected \n =================================\n\n"
								+ "Empty field detected in File : Latex"+i+".bib\n"
								+ "Detected field is: "+Author+", in article number: "+(n-1)+" . Other empty fields may exist\n\n");				
					
					}
					else {
						author = output.substring(8, output.length() - 3);

					}
					
				} if(output.contains(Journal)) {
					if(output.contains(empty)) {	
						scanner.close();
						throw new FileInvalidException("Error : Empty field Detected \n =================================\n\n"
								+ "Empty field detected in File : Latex"+i+".bib\n"
								+ "Detected field is: "+Journal+", in article number: "+n+" .. Other empty fields may exist");	
						
					}else {
						journal = output.substring(9, output.length() - 3);

					}
					
				} if(output.contains(Title)) {
					if(line.contains(empty)) {		
						scanner.close();
						throw new FileInvalidException("Error : Empty field Detected \n =================================\n\n"
								+ "Empty field detected in File : Latex"+i+".bib\n"
								+ "Detected field is: "+Title+", in article: "+n+" . Other empty fields may exist");		
						
					}else {
						title = output.substring(7, output.length() - 3);

					}
					
					
				} if(output.contains(Year)) {
					if(output.contains(empty)) {
						scanner.close();
						throw new FileInvalidException("Error : Empty field Detected \n =================================\n\n"
								+ "Empty field detected in File : Latex"+i+".bib\n"
								+ "Detected field is: "+Year+", in article: "+n+" . Other empty fields may exist");		
						
					}else {
						year = output.substring(6, output.length() - 3);

					}
					
				} if(output.contains(Volume)) {
					if(output.contains(empty)) {
						scanner.close();
						throw new FileInvalidException("Error : Empty field Detected \n =================================\n\n"
								+ "Empty field detected in File : Latex"+i+".bib\n"
								+ "Detected field is: "+Volume+", in article: "+n+" . Other empty fields may exist");		
						
					}else {
						volume = output.substring(8, output.length() - 3);

					}
				} if(output.contains(Number)) {
					if(output.contains(empty)) {
						scanner.close();
						throw new FileInvalidException("Error : Empty field Detected \n =================================\n\n"
								+ "Empty field detected in File : Latex"+i+".bib\n"
								+ "Detected field is: "+Number+", in article : "+n+" . Other empty fields may exist");		
						
					}else {
						number = output.substring(8, output.length() - 3);

					}
				} if(output.contains(Pages)) {
					if(output.contains(empty)) {
						
						scanner.close();
						throw new FileInvalidException("Error : Empty field Detected \n =================================\n\n"
								+ "Empty field detected in File : Latex"+i+".bib\n"
								+ "Detected field is: "+Pages+", in article: "+n+" . Other empty fields may exist");		
						
					}else {
						pages = output.substring(7, output.length() - 3);

					}
				} if(output.contains(KeyWords)) {
					if(output.contains(empty)) {						
						scanner.close();
						throw new FileInvalidException("Error : Empty field Detected \n =================================\n\n"
								+ "Empty field detected in File : Latex"+i+".bib\n"
								+ "Detected field is: "+KeyWords+", in article : "+n+" . Other empty fields may exist");		
						
					}else {
						keywords = output.substring(10, output.length() - 3);

					}
				} if(output.contains(Doi)) {
					if(output.contains(empty)) {
						
						scanner.close();
						throw new FileInvalidException("Error : Empty field Detected \n =================================\n\n"
								+ "Empty field detected in File : Latex"+i+".bib\n"
								+ "Detected field is: "+Doi+",in article : "+n+" . Other empty fields may exist");		
						
					}else{
						doi = output.substring(5, output.length() - 3);

					}
				} if(output.contains(ISSN)) {
					if(output.contains(empty)) {
					
						scanner.close();
						throw new FileInvalidException("Error : Empty field Detected \n =================================\n\n"
								+ "Empty field detected in File : Latex"+i+".bib\n"
								+ "Detected field is: "+ISSN+",in article : "+n+" . Other empty fields may exist");		
						
					}else {
						issn = output.substring(6, output.length() - 3);

					}	
				} if(output.contains(Month)) {
					
					if(output.contains(empty)) {
						
						scanner.close();
						throw new FileInvalidException("Error : Empty field Detected \n =================================\n\n"
								+ "Empty field detected in File : Latex"+i+".bib\n"
								+ "Detected field is: "+Month+", in article : "+n+" . Other empty fields may exist");		
					}else {
						month = output.substring(7, output.length() - 3);

					}
				}
				
			}// end of the second while loop, dedicated for each line within the same article
				//condition to avoid having empty formats 
				
				if(author.length()>0 && journal.length()>0 && title.length()>0 && year.length()>0 && volume.length()>0 && number.length()>0 && pages.length()>0 && keywords.length()>0 && doi.length()>0 && issn.length()>0 && month.length()>0){
					IEEEFormat = ""+author+". "+title+", "+journal+", vol. "+volume+", no."+number+", p."+pages+", "+month+" "+year+".";
					ACMFormat = "["+j+"]   "+author+". "+year+". "+title+". "+journal+". "+volume+", "+number+"("+year+"), "+pages+". "+"DOI:https://doi.org/"+doi+"."  ;
					NJFormat = ""+author+". "+title+". "+journal+". "+volume+", "+pages+"("+year+")." ;
					pw1.println(IEEEFormat); pw1.println();
					pw2.println(ACMFormat); pw2.println();
					pw3.println(NJFormat); pw3.println();
					j++ ;
					scanner.close();
				}
			
				

			}// end of the first while loop, dedicated for each article within the same file
			
			pw1.close(); pw2.close(); pw3.close();
			pw.close();
			
		}catch(FileNotFoundException e){
			System.out.println(e.getMessage());
			
		}	
	}
	
	
	public static void main(String[] args) {

		
		Scanner kb = new Scanner(System.in);
		Scanner sc = null ;
		PrintWriter pwACM = null ; PrintWriter pwIEEE = null ; PrintWriter pwNJ = null ;
		BufferedReader bf = null ;
		int nbr_files, x = 1 ; // nbr_files is the number files to go through depending on how many files we have || x is the file counter
		boolean directory ;
		String response ; // variable to store the input user when choosing the file name
		String output ; // variable to display the content of the chosen file
		int invalidFile  = 0;
		

		System.out.println("Hey, Welcome to BibCreator");
		System.out.println("How many files are you going to go through");
		nbr_files = kb.nextInt();
		
		
		// the directory that will contain any created file
		File dir = new File("C:\\Users\\user\\eclipse-workspace\\Assignment3\\OutputDir");
		directory = dir.mkdir();

		while(x <= nbr_files && directory) {
			try 
			{
				sc = new Scanner(new FileInputStream("Latex"+x+".bib"));
				
			
				 File fIEEE = new File("OutputDir\\IEEE"+x+".json");
				 File fACM = new File("OutputDir\\ACM"+x+".json");
				 File fNJ = new File("OutputDir\\NJ"+x+".json");
				
				
				pwIEEE = new PrintWriter(new FileOutputStream(fIEEE));
				pwACM = new PrintWriter(new FileOutputStream(fACM));
				pwNJ = new PrintWriter(new FileOutputStream(fNJ));
				
				try {
					processFilesForValidation(x,sc,pwIEEE,pwACM,pwNJ);	
					}
				
				catch(FileInvalidException e) {
					
					System.out.println(e.getError());
					
				}
				
			}
			
			catch(FileNotFoundException e) 
			{
				
				System.err.println("Could not open input file Latex"+x+".bib for reading. Please check if file exists! Program will terminate after closing any opened files.");		
			}
			
				x = x + 1 ; // increment the file counter so we can move on the next file 

			}
		
		sc.close(); // closing the scanner responsible for reading from the Latex files 
		
		// clean up the empty generated files (invalid ones will be destroyed)
		for(int j = 0; j <= nbr_files ; j++) {
			
			File f1, f2, f3 ;
		
				f1 = new File("OutputDir\\ACM"+j+".json");
				f2 = new File("OutputDir\\NJ"+j+".json");
				f3 = new File("OutputDir\\IEEE"+j+".json");

				if(f1.length() == 0 || f2.length() == 0 || f3.length() == 0) {
					f1.delete(); f2.delete(); f3.delete();
					invalidFile++ ;
				}
		}
		
		
		System.out.println("\nA total of "+(invalidFile - 1)+" invalid File(s) were discovered. "+(nbr_files - invalidFile + 1)+" File(s) have been created out of valid Files\n\n");
		
		kb.nextLine();
		System.out.println("Would you please enter the name of the file you need to review :");
		response = kb.nextLine();
			
				try {
					bf = new BufferedReader(new FileReader("OutputDir\\"+response));
					
					output = bf.readLine() ;
					
					while(output != null) {
						System.out.println(output);
						output = bf.readLine();
				
					}
			}catch(FileNotFoundException e) {
				
				System.out.println("File not found. Ok mistakes happens. This time don t forget the .json at the end. Last attempt");
				response = kb.nextLine();
				try {
					bf = new BufferedReader(new FileReader("OutputDir\\"+response));
					
					output = bf.readLine() ;
					
					while(output != null) {
						System.out.println(output);
						output = bf.readLine();
				
					}
				
				}catch(FileNotFoundException e2) {
					System.out.println("Wrong file name, program will exit now. Good bye");
					System.exit(0);
					
				}catch(IOException e3) {
					System.out.println(e3.getMessage());
				}
			}
				
				catch(IOException t) {
					System.err.println(t.getMessage());
				}
		
		// ending up having a directory full of valid files 
		
			}	
	}



