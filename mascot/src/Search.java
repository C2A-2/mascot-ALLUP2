
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Search extends JFrame implements ActionListener ,WindowListener/*, MouseListener*/{
	
	JFrame searchWindow = new JFrame("検索ウィンドウ");
	
	JTextField txfield = new JTextField(30);		// 最大30文字分のテキストボックス
	JButton reset_btn = new JButton("リセット");	// 初期化ボタン
	JButton submit_btn = new JButton("検索");		//検索ボタン
	
	//キーワード受け渡し用
	String keyword;
	
	public Search(){
		
		// GUI画面の設定
		searchWindow.getContentPane().setLayout(new FlowLayout());
		// テキストボックス設置
		searchWindow.getContentPane().add(txfield);
				
		// リセットボタンの設置
		searchWindow.getContentPane().add(reset_btn);
				
		// 送信ボタンの設置
		searchWindow.getContentPane().add(submit_btn);
				
		// リセットボタンの処理設定
		reset_btn.addActionListener(this);
				
		// 送信ボタンの処理設定
		submit_btn.addActionListener(this);
		
		// サイズを設定
		searchWindow.setSize(400, 100);
		
		//表示位置
		//searchWindow.setLocation(880,410);
		searchWindow.setLocation(450,250);
				
		// GUI画面の可視化
		searchWindow.setVisible(true);
		
		searchWindow.addWindowListener(this);
		
		
	}
	
	//ボタンクリック時処理
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == reset_btn) {
			// リセットボタン押下時は、テキストボックス初期化
			txfield.setText("");
		}else if(e.getSource() == submit_btn) {
			// 送信ボタン押下時
			
			keyword=txfield.getText();
			
			Character.windowCheck=false;
			
			searchWindow.dispose();
			
			new Browser(keyword);
			
		    }
		}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		searchWindow.dispose();
		Character.windowCheck=false;
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
