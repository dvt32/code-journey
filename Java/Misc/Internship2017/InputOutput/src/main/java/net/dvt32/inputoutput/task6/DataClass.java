package net.dvt32.inputoutput.task6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * This program serializes/deserializes a UserDefinedObject instance.
 * 
 * This means that the object is represented 
 * as a sequence of bytes, which includes:
 * - the object data's values
 * - some information about the object's type 
 * - some information about the data types in the object
 * 
 * Internally this is done by using the ObjectInputStream and ObjectOutputStream classes.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class DataClass {
	/**
	 * A nested class, which is serializable (i.e. 
	 * it can be represented in the form described above),
	 * because it implements the Serializable interface.
	 * 
	 * The class includes two fields (id & name), a standard constructor
	 * and two standard getter/setter methods (for each field).
	 * 
	 * @author Dimitar Trifonov (dvt32)
	 */
	static class UserDefinedObject 
		implements Serializable 
	{
		private int id;
		private String name;
		
		public UserDefinedObject(int id, String name) {
			this.id = id;
			this.name = name;
		}
		
		public int getId() { return id; }
		public String getName() { return name; }
		public void setId(int id) { this.id = id; }
		public void setName(String name) { this.name = name; }
	}
	
	/**
	 * This method serializes a UserDefinedObject instance.
	 * 
	 * @param path The output path for the file, which will contain the object's info
	 * @param o The object being serialized
	 */
	public void saveObject(String path, UserDefinedObject o) 
		throws IOException
	{
		ObjectOutputStream objectOutputStream = 
			new ObjectOutputStream( new FileOutputStream(path) );
		objectOutputStream.writeObject(o);
		objectOutputStream.close();
		
		// Optional success message, which is used only for JUnit testing
		System.out.println("Object successfully serialized!");
	}
	
	/**
	 * This method deserializes a UserDefinedObject instance from a file.
	 * 
	 * @param path The path to the file with the object to be deserialized
	 * @return The deserialized object
	 */
	public UserDefinedObject getObject(String path) 
		throws IOException, ClassNotFoundException 
	{
		ObjectInputStream objectInputStream =
			new ObjectInputStream( new FileInputStream(path) );
		UserDefinedObject objectInFile = (UserDefinedObject) objectInputStream.readObject();
		objectInputStream.close();
		
		// Optional success message, which is used only for JUnit testing
		System.out.println("Object successfully deserialized!");
		
		return objectInFile;
	}
}