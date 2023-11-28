
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Character extends JFrame implements MouseMotionListener, MouseListener {
	ImageIcon left1 = new ImageIcon("R1.png");
	JLabel label = new JLabel(left1);
	ImageIcon left2 = new ImageIcon("R2.png");
	ImageIcon left3 = new ImageIcon("R3.png");
	ImageIcon right1 = new ImageIcon("R1R.png");
	ImageIcon right2 = new ImageIcon("R2R.png");
	ImageIcon right3 = new ImageIcon("R3R.png");
	ImageIcon dragg1 = new ImageIcon("ojousama.png");
	ImageIcon dragg2 = new ImageIcon("gorunai.png");
	ImageIcon pause = new ImageIcon("desktop.png");
	
	
	
	
	
	//JLabel label = new JLabel("こんにちわ");
	//JFrame frame = new JFrame();
	//Timer timer1;
	Timer timer1= new Timer(true);
	TimerTask task;
	
	//座標初期位置
	int x=1080,y=480;
	
	//移動距離
	int w=10,z=5;
	
	int dx,dy;
	
	//画面端最大値、最小値定数
	final int xMin=-50;
	final int xMax=1140;
	final int yMin=0;
	final int yMax=480;
	
	//画像切り替えチェック
	//boolean check=true;
	int check=0;
	
	//プルダウンメニューチェック
	static boolean windowCheck=false;
	
	
	//マウスカーソル乗る判定用
	int i=0;
	
	//ドラッグ時表示切替用
	int dragged=0;
	

	

	public Character() {
		
		//終了設定
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//画面のウィンドウサイズ指定
		setSize(1920, 1080);
		getContentPane().setLayout(null);
		
		//label指定
		label.setBounds(x, y, 111, 200);
		// 枠を外す。
        setUndecorated(true);
        // 背景色を透明にする。
        setBackground(new Color(0, 0, 0, 0));
        // タスクバーのアイコンを非表示
        setType(Type.UTILITY) ;
		
        //ラベル追加
		getContentPane().add(label); //引数label
		
		addMouseMotionListener(this);
		addMouseListener(this);
	}
	
	public void move() {
		task = new TimerTask() {
        public void run(){
        	
        	//チェック
        	check++;
        	if(3<check) {
        		check=0;
        	}
        	
        	//画像切り替え
        	for(int I=0;I<5;I++) {
        		//移動距離計算
        		x-=w;
        		y-=z;
        		//画面端判定
        		if((x>=xMin && x<=xMax) && (y>=yMin && y<=yMax)) {
        			//左右どちらの移動か判定
        			if(w>=1) {
        				switch(check) {
        		        	case 1:
        		        		drow1();
        		        		break;
        		        	case 3:
        		        		drow3();
        		        		break;
        		        	//初期表示は0なのでデフォルト、0と2の描画を兼ねる
        		        	default:
        		        		drow2();
        		        		break;
        				}
        			}else {
        				switch(check) {
	    		        	case 1:
	    		        		drow4();
	    		        		break;
	    		        	case 3:
	    		        		drow6();
	    		        		break;
	    		        	//初期表示は0なのでデフォルト、0と2の描画を兼ねる
	    		        	default:
	    		        		drow5();
	    		        		break;
        				}
        			}
        		}else if(x<=xMin || x>=xMax){
	    			w=w*-1;
	    		}else {
	    			z=z*-1;
	    		}
        	}
        	
        }
    
		};

	}
	
	//画像表示1
	public void drow1() {
		label.setIcon(left1);
		label.setBounds(x, y, 200, 200);
	}
	
	//画像表示2
	public void drow2() {
		label.setIcon(left2);
		label.setBounds(x, y, 200, 200);
		}
	
	//画像表示3
	public void drow3() {
		label.setIcon(left3);
		label.setBounds(x, y, 200, 200);
	}
	
	//画像表示4
	public void drow4() {
		label.setIcon(right1);
		label.setBounds(x, y, 200, 200);
	}
	
	//画像表示5
	public void drow5() {
		label.setIcon(right2);
		label.setBounds(x, y, 200, 200);
	}
	
	//画像表示6
	public void drow6() {
		label.setIcon(right3);
		label.setBounds(x, y, 200, 200);
	}
		
	//移動停止
	public void moveStop() {
		if(timer1 != null){
			timer1.cancel();
			timer1 = null;
		}
	}
	
	//移動開始
	public void moveStart() {
		if(timer1==null&&windowCheck==false&&Main.moveCheck==true) {
			timer1=new Timer(true);
			move();
			timer1.schedule(task, 0, 1000);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		//コンポーネント上でクリックして離す
		
		moveStop();
		
		if(windowCheck==false) {
			windowCheck=true;
			new Menu();
		}
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		//コンポーネント上でクリックする
		
		dx=e.getXOnScreen()-label.getX();
		dy=e.getYOnScreen()-label.getY();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		//マウスクリックが離されると呼出し
		x=e.getX();
		y=e.getY();
		
		label.setIcon(left1);
		
		//画面外にドラッグした場合の処理
		if(x<xMin || x>xMax || y<yMin || y>yMax) {
			if((x<xMin && y<yMin) || (x>xMax && y<yMin) || (x<xMin && y>yMax) || (x>xMax && y>yMax)) {//x軸y軸両方範囲外（右上右下左上左下）
				System.out.print("x軸y軸両方範囲外");
				if(x<xMin && y<yMin) {//右上左上か右下左下の判定
					//左上
					x=xMin;
					y=yMin;
				}else if(x>xMax && y<yMin) {
					//右上
					x=xMax;
					y=yMin;
				}else if(x<xMin && y>yMax) {
					//左下
					x=xMin;
					y=yMax;
				}else {
					//右下
					x=xMax;
					y=yMax;
				}
			}else if(x<xMin || x>xMax){//x軸のみ超えているかどうか
				if(x<xMin) {//x軸のどっちが超えてるか判定
					//x軸左
					x=xMin;
				}else {
					//x軸右
					x=xMax;
				}
			}else if(y<yMin) {//y軸のどっちが超えているか判定
				//y軸上
				y=yMin;
			}else {
				//y軸下
				y=yMax;
			}
		
		}
		
		moveStart();
				
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		//コンポーネントにマウスが入る
		
		//起動時カーソルは乗る判定が入るので1回目は除外する
		i++;
		if(1!=i) {
			label.setIcon(pause);
		}
		
		moveStop();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		//コンポーネントからマウスが出る
		
		label.setIcon(left1);
		
		moveStart();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		//クリックしてドラッグする
		
		moveStop();
		 
		 x=e.getXOnScreen()-dx;
		 y=e.getYOnScreen()-dy;
		 
		 //表示切替
		 if(dragged<19) {
			 label.setIcon(dragg1);
			 label.setLocation(x,y);
			 dragged++;
		 }else {
			 label.setIcon(dragg2);
			 label.setLocation(e.getPoint());
			 label.setLocation(x,y);
			 dragged++;
			 if(dragged==40) {
				 dragged=0;
			 }
		 }
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	
}
