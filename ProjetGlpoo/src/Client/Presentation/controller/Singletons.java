package Client.Presentation.controller;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Singletons {
	
	private static PrintWriter printWriterInstance;
	private static Socket socketInstance;
	private static BufferedReader bufferedReaderInstance;
	
	public static Socket getSocket() {
		if(socketInstance != null) {
			return socketInstance;
		}else {
			return null;
		}
	}
	
	public static PrintWriter getOutput() {
		if(printWriterInstance != null) {
			return printWriterInstance;
		}else {
			System.out.println("Output null");
			return null;
		}
	}
	
	static void setOutput(PrintWriter out) {
		printWriterInstance = out;
	}

}
