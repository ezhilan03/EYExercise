package InternExercise.day19;

import java.io.FileOutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalDemo {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(2);
		es.execute(()->{
			try {
				Resource r=ResourceManager.getResource("abc.txt");
				FileOutputStream fos=r.getStream();
				fos.write("helloworld".getBytes());
				ResourceManager.closeResource();
				r=ResourceManager.getResource("abc.txt");
				fos=r.getStream();
				fos.write("next world...........".getBytes());
			}catch(Exception e) {
				e.printStackTrace();
			}
		});
		es.execute(()->{
			try {
				Resource r=ResourceManager.getResource("abc2.txt");
				FileOutputStream fos=r.getStream();
				fos.write("helloworld22222222222".getBytes());
				}catch(Exception e) {
					e.printStackTrace();
				}
		});
		
		es.shutdown();
	}
}

class ResourceManager{
	public static ThreadLocal<Resource> tlocal = new ThreadLocal<>();
	public static Resource getResource(String fileName) {
		Resource r = tlocal.get();
		if(r==null) {
			r=new Resource(fileName);
			tlocal.set(r);
		}
		return r;
	}
	public static void closeResource() {
		Resource r = tlocal.get();
		if(r!=null) {
			tlocal.remove();
		}
	}
}

class Resource{
	FileOutputStream fos;
	public Resource(String fileName) {
		System.out.println("Resource obj created");
		try {
			fos = new FileOutputStream(fileName,true);
		}catch(Exception e) {e.printStackTrace();}
	}
	public FileOutputStream getStream() {
		return fos;
	}
}