package serialization;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
public class SerializationDemo {
	        String basepath = "C:\\Users\\User\\Desktop\\";
			String fileName = "oldapproach.txt";
			String fileName2 = "serialapp.txt";
			public static void main(String[] args) 
			{
				SerializationDemo obj = new SerializationDemo();
				try {
					//obj.oldApproach();
					
					String filePath = obj.basepath+""+obj.fileName2;
					
					Account a = new Account(20, "Ramesh", 7000);
					Account b = new Account(21, "Ganesh", 6000);
					Account c = new Account(22, "Gowri", 4000);
					Account d = new Account(23, "veeresh", 3000);
					Account e = new Account(24, "Guna", 5000);
					
					List<Account> accList = new LinkedList<>();
					accList.add(a);
					accList.add(b);
					accList.add(c);
					accList.add(d);
					accList.add(e);
					
					File serFile = new File(filePath);
					obj.saveSerializableAccount(serFile,accList);
					
					
					obj.readSerializableAccount(serFile);
				
				} catch (Exception e) {
					System.out.println(e);
				}
				
			}
			
			
			public void saveSerializableAccount(File serfile,List<Account> accList) throws Exception
			{
				
				FileOutputStream fos = new FileOutputStream(serfile);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(accList);  
				oos.close();
				
			}
			
			public void readSerializableAccount(File serfile) throws Exception
			{
				 FileInputStream fis = new FileInputStream(serfile);
				 ObjectInputStream ois = new ObjectInputStream(fis);
				List<Account> list = new LinkedList<>();
				 list = (List<Account>) ois.readObject();
				 
				 for (Account acc : list) {
					 if(acc.getBalance()>=500 && acc.getBalance()<=10000) {
						 	System.out.print(acc.getAccountHolderName());
						 	System.out.print(acc.getBalance());
					 		System.out.print(acc.fundTransfer(200));
					 }
					 
				}
			}
			
			
			
			public void oldApproach() throws Exception// working with data
			{
				File f = new File(basepath+""+fileName);
				PrintWriter pw = new PrintWriter(new FileWriter(f,true));
				
				Account a = new Account(101, "Ramesh", 2000);
				// cannot work with Object
				//pw.append(a); // error
				pw.append(a.getAccountNumber()+" - "+a.getAccountHolderName()+" - "+a.getBalance());
				pw.close();
			}
	}



