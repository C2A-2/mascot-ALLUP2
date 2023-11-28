
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class Menu extends JFrame implements ActionListener , MouseListener ,WindowListener{
	// フィールド宣言
	JComboBox<String> comboBox = new JComboBox<String>();
	// GUI画面の設定
	JFrame menuWindow = new JFrame("メニュー");
	
	//メニューウィンドウ重複チェック、プルダウン側用
	boolean menuWindowCheck_Pulldown;
	
	// コンストラクタ
	public Menu(){
		
		//レイアウト無効
		menuWindow.setLayout(null);
		
		// ボタンの生成
		JButton btn = new JButton("決定");
		
		// ボタン押下時の処理を設定
		btn.addActionListener(this);
		
		// プルダウンの追加
		comboBox.addItem("沼情");
		comboBox.addItem("検索");
		comboBox.addItem("電卓");
		comboBox.addItem("メモ帳");
		
		// プルダウンを画面に追加
		menuWindow.add(comboBox);
		comboBox.setBounds(50,20,100,30);
		
		// ボタンを画面に追加
		menuWindow.add(btn);
		btn.setBounds(170,20,70,30);
		
		//終了設定
		menuWindow.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		// サイズを設定
		menuWindow.setSize(300, 100);
		
		//ウィンドウ位置座標
		//menuWindow.setLocation(980,410);
		menuWindow.setLocation(500,250);
		
		// GUI画面の可視化
		menuWindow.setVisible(true);
		
		menuWindow.addMouseListener(this);
		menuWindow.addWindowListener(this);
		
		this.setType(Type.UTILITY) ;
	}
	
	
	
	// ボタンクリック時の処理
	public void actionPerformed(ActionEvent ae) {
		
		if(comboBox.getSelectedItem()=="沼情") {
			
			//メニューウィンドウ閉じる
			menuWindow.dispose();
			
			Desktop desktop = Desktop.getDesktop();
			try {
				Character.windowCheck=false;
				Main.moveStartMain();
				desktop.browse(new URI("https://www.numasen.ac.jp/department/computer/"));
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			
		}else if(comboBox.getSelectedItem()=="検索"){
			
			//メニューウィンドウ閉じる
			menuWindow.dispose();
			
			Character.windowCheck=false;
			if(Character.windowCheck==false) {
				Character.windowCheck=true;
				new Search();//.setVisible(true);
			}
			
			
		}else if(comboBox.getSelectedItem()=="電卓") {
			
			//メニューウィンドウ閉じる
			menuWindow.dispose();
			Character.windowCheck=false;
			Main.moveStartMain();
			
			try {
			      Runtime rt = Runtime.getRuntime();
			      rt.exec("calc.exe");
			    } catch (IOException ex) {
			      ex.printStackTrace();
			    }
		}else if(comboBox.getSelectedItem()=="メモ帳") {
			
			//メニューウィンドウ閉じる
			menuWindow.dispose();
			Character.windowCheck=false;
			Main.moveStartMain();
			
			 try {
			      Runtime rt = Runtime.getRuntime();
			      rt.exec("notepad.exe");
			    } catch (IOException ex) {
			      ex.printStackTrace();
			    }
			  
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
	}



	@Override
	public void windowOpened(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}



	@Override
	public void windowClosing(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		Character.windowCheck=false;
		menuWindow.dispose();
		Main.closingCheck();
	}



	@Override
	public void windowClosed(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}



	@Override
	public void windowIconified(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}



	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}



	@Override
	public void windowActivated(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}



	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

		
}
