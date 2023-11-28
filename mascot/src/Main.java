
import java.awt.AWTException;
import java.io.IOException;
import java.util.Timer;

public class Main {
	
	public static Character character;
	static boolean moveCheck=true;
	

	public static void main(String[] args) throws IOException, AWTException {
		
		character=new Character();
		
		character.setVisible(true);
		
		
		character.move();
		character.timer1.schedule(character.task, 0, 1000);
		
		new Systemtray();
		
	}	
		
	//各ウィンドウを閉じたら呼び出し
	public static void closingCheck(){
		character.moveStart();
	}
	
	public static void moveStopMain(){
		//システムトレイ移動停止押したら呼び出し
		//移動停止
		if(character.timer1 != null&&moveCheck==true){
			character.timer1.cancel();
			character.timer1 = null;
			moveCheck=false;
		}
	}
	
	public static void moveStartMain(){
		//システムトレイ移動停止押したら呼び出し
		//移動開始
		
		if(character.timer1==null ) {
			character.timer1=new Timer(true);
			character.move();
			character.timer1.schedule(character.task, 0, 1000);
			moveCheck=true;
		}
	}
	
	
	    
	    
}

	