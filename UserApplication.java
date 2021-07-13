package serialization;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class UserApplication {
     public static void main(String[] args) {
					
					String path = "C:\\Users\\User\\Desktop\\newfile";
							;
					String path2="C:\\Users\\User\\Desktop\\newfile\\file2";
					
					try {
						File f = new File(path);
						File f2 = new File(path2);
						while(true) {
						System.out.println("\n1. Read a File");
						System.out.println("\n2. Append in File");
						System.out.println("\n3. Search a string in File");
						
						int choice = new Scanner(System.in).nextInt();
						
						switch(choice) {
						case 1:
							new UserApplication().readFile(f);
							break;
						case 2:
							new UserApplication().printFile(f2);
							break;
						case 3:
							System.out.println("Enter String ");
							String str = new Scanner(System.in).nextLine();
							new UserApplication().SearchString(f,str);
							break;
						default : System.exit(0);
						}
					}
				} catch (Exception e) {
							System.out.println(e);
					}
					
				}
				
				
				public void printFile(File f2)throws Exception
				{
					System.out.println(" Printing ....");
					PrintWriter pw = new PrintWriter(f2);
					pw.append("Hello Minato!");
					pw.close();
					System.out.println("---Done ---");
				}
				
				public void readFile(File f)throws IOException
				{
					BufferedReader br = new BufferedReader(new FileReader(f));
					
					String line = null;
					
					while((line = br.readLine())!=null)
					{
						System.out.println(line);
					}
				}
				private void SearchString(File f,String str)throws IOException {
					
					int lineno=0;
					
					BufferedReader br = new BufferedReader(new FileReader(f));
					String line = null;
					
					System.out.println("The String \""+str+"\" Found at Line No(s):\n { ");
					while((line = br.readLine())!=null)
					{
						String[] words=str.split(" ");  
				          for (String word : words) 
				          {
				        	  lineno++;
				        	  if(line.contains(str)) {
				        		  System.out.print(lineno+", ");
						}
				          }
					}
					System.out.print("\n }");
			}
	}

	
	

