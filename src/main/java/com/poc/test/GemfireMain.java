/**
 * 
 */
package com.poc.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.gemfire.GemfireTemplate;

/**
 * @author NAYAKDUR
 *
 */
public class GemfireMain {

	/**
	 * 
	 */
	public GemfireMain() {
		// TODO Auto-generated constructor stub
	}


public void listenSocket() throws IOException{
//Create socket connection
	Socket socket = null;
	PrintWriter out = null;
	 BufferedReader in = null;
   try{
     socket = new Socket("11.160.3.58", 2003);
     out = new PrintWriter(socket.getOutputStream(), 
                 true);
     in = new BufferedReader(new InputStreamReader(
                socket.getInputStream()));
   } catch (UnknownHostException e) {
     System.out.println("Unknown host: kq6py");
   } catch  (IOException e) {
     System.out.println("No I/O");
   }finally {
	   out.close();
	   in.close();
	   socket.close();
   }
   System.out.println("Success");
}
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Thread thread = new Thread(new Runnable() {			
			public void run() {
				// TODO Auto-generated method stub
				ClassPathXmlApplicationContext appCtx = new ClassPathXmlApplicationContext("gemfire-config.xml");
				String arr[] =appCtx.getBeanDefinitionNames();
				GemfireTemplate gemfireTemplate = (GemfireTemplate) appCtx.getBean("gemfireTemplate");
//				gemfireTemplate.getRegion().put(Thread.currentThread().getId(), Thread.currentThread().getName());
				System.out.println("");
				gemfireTemplate.getRegion().put("Durga", "Nayak");
				System.out.println(gemfireTemplate.getRegion().getAttributes());
				System.out.println(gemfireTemplate.getRegion().get("Durga"));

//				gemfireTemplate.getRegion().put("Ankush", "Bankush");
//				gemfireTemplate.getRegion().remove("Durga");
//				gemfireTemplate.getRegion().remove("Ankush");
//				//String object = (String) gemfireTemplate.getRegion().get(Thread.currentThread().getId());
//				//String object = (String) gemfireTemplate.getRegion().get("Durga");
//				//System.out.println(">>>>>>>>>>>>>" + object);
//				Set<Entry<Object, Object>> entrySet = gemfireTemplate.getRegion().entrySet();
//				for (Entry<Object, Object> entry:entrySet) {
//					System.out.println(entry.getKey());
//					System.out.println(entry.getValue());
//				}
			}
		});
		thread.start();
//		GemfireMain gemfireMain = new GemfireMain();
//		gemfireMain.listenSocket();
	}

}
