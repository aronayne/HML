package utils;

public class PrintUtils {
	
	//public static PrintUtils printUtils;

	public static void exit(){
		System.exit(0);
	}
	
	public static void println(){
		System.out.println("");
	}
	
	public static void println(String str){
		System.out.println(str);
	}
	
	public static void println(Long str){
		System.out.println(str);
	}
	
	public static void println(int str){
		System.out.println(str);
	}
	
	public static void print(String str){
		System.out.print(str);
	}
	
	public static void print(int str){
		System.out.print(str);
	}

	public static void sleep(int seconds){
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static long getTime(){
		return System.currentTimeMillis();
	}

	public static void print(double value) {
		System.out.print(value);
	}
	
	public static void println(double value) {
		System.out.println(value);
	}
}
