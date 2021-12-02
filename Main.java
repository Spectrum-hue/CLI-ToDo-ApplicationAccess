import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedInputStream;
import java.io.FileInputStream;


public class Main {

private static final String Date = null;
	

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		
		todo();
	}
	 
	public static void todo() throws IOException, ParseException {
		String choice = null;
		while (choice != "exit") {	
	
	
	welcome();
	completedTasks();
	incompletedTasks();
	menu();
	
	}
	
}

	
	private static void welcome() throws FileNotFoundException {
		// int hasDoneFalse = 0, hasDoneTrue = 0;
	        System.out.println("\n========= Welcome to the Todo app! ==========");
	    	System.out.println("                     _____  _____  ____   _____"  );
	    	System.out.println("                    |_   _||  _  ||  _ \\ |  _  |     ");
	    	System.out.println("                      | |  | |_| || |_|| | |_| |     ");
	    	System.out.println("                      |_|  |_____||____/ |_____| ");
	    	System.out.println("  ");
	    	}
	
	private static void completedTasks()  {
		int completed = 0;
		File myWriter = new File("complete.txt");
		Scanner Reader = null;
		try {
			Reader = new Scanner (myWriter);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (Reader.hasNextLine()) {
			String datas = Reader.nextLine();
			//System.out.println(data);
			if (datas.contains("true")) {
				completed += 1;
			
			}
		}
		System.out.print( "\n"  +"You have " + "completed " + completed + " " + "tasks");
	}
	
	private static void incompletedTasks()  {
		int wordCounter = 0;
		File mysWriter = new File("Incomplete.txt");
		Scanner mysReader = null;
		try {
			mysReader = new Scanner (mysWriter);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (mysReader.hasNextLine()) {
			String data = mysReader.nextLine();
			//System.out.println(data);
			if (data.contains("false")) {
				wordCounter += 1;
			
			}
				
	    }
		
		System.out.print( " " + "and" + " " + wordCounter + " " + "task/s is incomplete"  );
		
		}	
	
		
	public static void no() throws IOException {	
		
		System.out.println("Print out the ID");
		Scanner b = new Scanner(System.in);
		System.out.print("> ");
		String todoId = b.nextLine();
		String todolIdList = todoId;
		
		System.out.println("What is the Todo item you want to add?");
		Scanner s = new Scanner(System.in);
		System.out.print("> ");
		String todoadd = s.nextLine();
		String todolist = todoadd;
		
	SimpleDateFormat Formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	   	 
	        Date currentDate = new Date() ;
	        
			
	     System.out.println(todolist + "is + added");
		FileWriter myWriter = new FileWriter("Incomplete.txt", true);
		
		myWriter.write(todolIdList + " " + "False" + " " +  todolist + " " + currentDate  +  "\n ");
		
		myWriter.close();
		
		System.out.print("Successfull" + "\n");
	}
	public static void done() throws IOException  {	
		System.out.println("Choose the ID (will delete the project) you want to delete by entering the ID from the list: ");
		viewInComplete();
		
		        	
		           
	            File tempDB = new File("temp.txt");
				File db = new File("Incomplete.txt");
			    File e = new File("complete.txt");
				
			
				BufferedReader br = null;
				try {
					br = new BufferedReader( new FileReader( db ) );
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				BufferedWriter bw = new BufferedWriter( new FileWriter( tempDB ) );
				BufferedWriter bp = new BufferedWriter( new FileWriter( e ) );
				
				
				System.out.println("\t\t Delete a record of a task\n");
				Scanner strInput =  new Scanner(System.in);
				String record;
				String bercord;
				
				System.out.println("> ");
				String ID =  strInput.nextLine();
				
		while( ( record = br.readLine() ) != null ) {
			
			if( record.contains(ID) )
				  continue;
				
			bw.write(record);
			bw.flush();
			bw.newLine();
			
			
		}
		
		bp.close();
		br.close();
		bw.close();
		
		
		db.delete();
		
	
		tempDB.renameTo(db);
		
		FileReader fl = new FileReader("temp.txt");
        
         //FileReader will open that file from that
         //directory, if there is no file found it will
        // through an IOException

        // Creating a FileWriter object
        FileWriter ew = new FileWriter("Incomplete.txt");

       
		
	        FileWriter fw = new FileWriter("Incomplete.txt", false);

		    PrintWriter pw = new PrintWriter(fw, false);

		    pw.flush();

		    pw.close();

		    fw.close();
		  
		   
	            FileReader fr = new FileReader("temp.txt");
	           
	            // FileReader will open that file from that
	            // directory, if there is no file found it will
	            // through an IOException
	  
	            // Creating a FileWriter object
	            FileWriter iw = new FileWriter("Incomplete.txt");
	  
	            // It will create a new file with name
	            // "Incomplete", if it is already available,
	            // then it will open that instead
	  
	            // Declearing a blank string in which
	            // whole content of file is to be stored
	            String str = "";
	  
	            int i;
	  
	            // read() method will read the file character by
	            // character and print it until it end the end
	            // of the file
	  
	            // Condition check
	            // Reading the file using read() method which
	            // returns -1 at EOF while reading
	            while ((i = fr.read()) != -1) {
	  
	                // Storing every character in the string
	                str += (char)i;
	            }
	  
	            // Print and display the string that
	            // contains file data
	            System.out.println(str);
	  
	            // Writing above string data to
	            // FileWriter object
	            iw.write(str);
	  
	            // Closing the file using close() method
	            // of Reader class which closes the stream &
	            // release resources that were busy in stream
	           fr.close();
	            iw.close();
	  
	            // Display message
	            System.out.println(
	                "File reading and writing both done");
	        }
	       
	     
	public static void update() throws IOException {
		
		 BufferedReader file = new BufferedReader(new FileReader("Incomplete.txt"));
		    String ToDo_Update;
		    String  ToDo_Updates;
		    String line;
		    String input = "";
		    System.out.println("Type in the line");
		    Scanner s = new Scanner (System.in);
		    System.out.print ( "Enter an ID:" );
		    String user_ID = s . nextLine ();
		    System.out.print ( "Enter the ToDo item:" );
		    String user_ToDo = s . nextLine ();
		    System.out.print ( "Do you want to mark the project as complete or not? - Yes or No:" );
		    String status = s . nextLine ();
		    Scanner b = new Scanner (System.in);
		    System.out.print ( "Enter a new ID:" );
		    String users_ID = b.nextLine ();
		    System.out.println(users_ID);
		   
		  
		    SimpleDateFormat Formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		   	  // System.out.print("What is the Due Date? (yyyy-MM-ddTHH:mm) Example: " + myFormat.format(new Date()) + "\n->createTask>>> ");
		        Date currentDate = new Date() ;
		       
		        ToDo_Update = users_ID + " " + "False" + " " + currentDate + " " +  user_ToDo;
		        
		        
		        ToDo_Updates = users_ID + " " + "False" + " " + currentDate + " " +  user_ToDo;
		    while ((line = file.readLine()) != null)
		       if (line.contains(user_ID)) {
		    	//   Scanner b = new Scanner ( System . in );
				    System.out.print(line);
				//    String users_ID = b.nextLine ();
				//    ToDo_Updates = users_ID + " " + "False" + " " + currentDate + " " +  user_ToDo;
		    	   input += line + System.lineSeparator();
	               input = input.replace(line,ToDo_Updates);
		           // Get line by ID update txt java replace
		        

		    FileOutputStream os = new FileOutputStream("Incomplete.txt");
		    os.write(input.getBytes());

		    file.close();
		    os.close();
	
	}
	}
	
	
	public static void menu() throws IOException, ParseException {
	System.out.println("\n\n**** Type 'add', followed by a sentence, to add a todo.************");
	System.out.println("**** Type 'done', followed by the todo ID, to complete a todo. ****");
	System.out.println("**** Type 'incomplete', to see incompleted tasks.");
	System.out.println("**** Type 'complete', to see completed tasks.");		
	System.out.println("**** Type 'update' to change information. ********");
	System.out.println("**** Type 'exit', followed by the todo ID, to complete a todo. ****");
	
	String add = "add";
	String done = "done";
	String exit = "exit";
	
    Scanner s = new Scanner(System.in);
    System.out.print("> ");
    String choice = s.nextLine();
    System.out.println("You have entered: "+ choice); 
    
    
    switch(choice) {
  	case "add" -> {
  		
			no();
  	}
  	
  	case "done" -> {
  		System.out.println("\nWhat todo item have you completed?: ");
  		done();
  	} case "incomplete" -> {
  		System.out.println("\nView incompleted list"  + "\n");
  		viewInComplete();
  	
  	} case "complete" -> {
  		System.out.println("\nView completed list"  + "\n");
  		viewComplete();
  	} case "update" -> {
  		System.out.println("\nUpdate a record"  + "\n");
  		update();
  	
  	} case "exit" -> {
  		System.out.println("\nGood bye. please visit again!" + "\n");
  	    System.exit(0);	
  	}  
  	    	
    default -> 
  	 message();
  }
     todo();
  	 
  }		
	    
  //Message method.
  private static void message() throws FileNotFoundException {
  System.out.println("You have entered. You should type in the correct options." + " " + "\n");
	

    
}   
  // Incompleted tasks method
  private static void viewInComplete() throws FileNotFoundException { 
	  
	  
	  
	// Creates a FileInputStream
      FileInputStream file = new FileInputStream("Incomplete.txt");

      // Creates a BufferedInputStream
      BufferedInputStream input = new BufferedInputStream(file);
      
      

      // Reads first byte from file
      int i = 0;
	try {
		i = input .read();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

      while (i != -1) {
        System.out.print((char) i);

        // Reads next byte from the file
        try {
			i = input.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
      try {
		input.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
      private static void viewComplete() throws FileNotFoundException { 
    	  
    	  
    	  
    		// Creates a FileInputStream
    	      FileInputStream file = new FileInputStream("complete.txt");

    	      // Creates a BufferedInputStream
    	      BufferedInputStream input = new BufferedInputStream(file);
    	      
    	      

    	      // Reads first byte from file
    	      int i = 0;
    		try {
    			i = input .read();
    		} catch (IOException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}

    	      while (i != -1) {
    	        System.out.print((char) i);

    	        // Reads next byte from the file
    	        try {
    				i = input.read();
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    	      }
    	      try {
    			input.close();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    }

}
