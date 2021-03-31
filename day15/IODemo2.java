package InternExercise.day15;

import java.io.File;

public class IODemo2 {
	public static void main(String[] args) {
		File file = new File("D:/SMM");
		
		System.out.println("Path is "+file.getAbsolutePath());
		System.out.println("Name of the file "+file.getName());
		System.out.println(file.exists()?"Yes the file exist":"No the file do not exist");
		System.out.println(file.canWrite());
		System.out.println(file.isDirectory());
		
		//File newFile = new File("D:/SMM");
		//file.renameTo(newFile);
		
		String s[] = file.list((dir,name)->{
			return name.endsWith(".mp4");
		});
		
		for(String ss:s) {
			System.out.println(ss);
		}
		
	}
}
