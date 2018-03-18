package com.cz.calclator3;


import java.util.ArrayList;
import java.util.List;



import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements OnClickListener {

	private TextView tv;
	private List<Item> items = new ArrayList<Item>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tv = (TextView) findViewById(R.id.tvScreen);
		
		findViewById(R.id.btn0).setOnClickListener(this);
		findViewById(R.id.btn1).setOnClickListener(this);
		findViewById(R.id.btn2).setOnClickListener(this);
		findViewById(R.id.btn3).setOnClickListener(this);
		findViewById(R.id.btn4).setOnClickListener(this);
		findViewById(R.id.btn5).setOnClickListener(this);
		findViewById(R.id.btn6).setOnClickListener(this);
		findViewById(R.id.btn7).setOnClickListener(this);
		findViewById(R.id.btn8).setOnClickListener(this);
		findViewById(R.id.btn9).setOnClickListener(this);
		findViewById(R.id.btnAdd).setOnClickListener(this);
		findViewById(R.id.btnSub).setOnClickListener(this);
		findViewById(R.id.btnX).setOnClickListener(this);
		findViewById(R.id.btnDiv).setOnClickListener(this);
		findViewById(R.id.btnClear).setOnClickListener(this);
		findViewById(R.id.btnResult).setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.btn0:
			tv.append("0");
			break;
		case R.id.btn1:
			tv.append("1");
			break;
		case R.id.btn2:
			tv.append("2");
			break;
		case R.id.btn3:
			tv.append("3");
			break;
		case R.id.btn4:
			tv.append("4");
			break;
		case R.id.btn5:
			tv.append("5");
			break;

		case R.id.btn6:
			tv.append("6");
			break;
		case R.id.btn7:
			tv.append("7");
			break;
		case R.id.btn8:
			tv.append("8");
			break;
		case R.id.btn9:
			tv.append("9");
			break;
		case R.id.btnAdd:

			items.add(new Item(Double.parseDouble(tv.getText().toString()),Type.NUM));
			checkCalc();
			items.add(new Item(0, Type.ADD));
			tv.setText("");
			break;
		case R.id.btnSub:
			items.add(new Item(Double.parseDouble(tv.getText().toString()),Type.NUM));
			checkCalc();
			items.add(new Item(0, Type.SUB));
			tv.setText("");
			break;
		case R.id.btnX:
			items.add(new Item(Double.parseDouble(tv.getText().toString()),Type.NUM));
			checkCalc();
			items.add(new Item(0, Type.X));
			tv.setText("");
			break;
		case R.id.btnDiv:
			items.add(new Item(Double.parseDouble(tv.getText().toString()),Type.NUM));
			checkCalc();
			items.add(new Item(0, Type.DIV));
			tv.setText("");
			break;
		case R.id.btnClear:
			items.clear();
			tv.setText("");
			break;
		case R.id.btnResult:
			items.add(new Item(Double.parseDouble(tv.getText().toString()),Type.NUM));
			checkCalc();
			tv.setText(items.get(0).value+"");
			items.clear();
			break;
		}
	}

	public void checkCalc(){
		if(items.size()>=3){

			double a = items.get(0).value;
			double b = items.get(2).value;
			int opt = items.get(1).type;
			items.clear();
			switch (opt) {
			case Type.ADD:
				items.add(new Item(a+b, Type.NUM));
				break;

			case Type.SUB:
				items.add(new Item(a-b, Type.NUM));
				break;
			case Type.X:
				items.add(new Item(a*b, Type.NUM));
				break;
			case Type.DIV:
				items.add(new Item(a/b, Type.NUM));
				break;
			}
		}
	}

//	private int onClickBack  = 0;

	
	//后退功能
	private long lastClickTime = 0;
	
	@Override
	public void onBackPressed() {
			//super.onBackPressed();
//		if(onClickBack<1){
//			Toast.makeText(this, "再按一次后退键，退出Calclator", Toast.LENGTH_SHORT).show();
//			onClickBack++;
//		}else{
//			finish();
//		}
		
		if(lastClickTime<=0){
			Toast.makeText(this, "再按一次后退键，退出Calclator", Toast.LENGTH_SHORT).show();
			lastClickTime = System.currentTimeMillis();
		}else{
			
			long currentClickTime = System.currentTimeMillis();
			
			if(currentClickTime-lastClickTime<1000){
				finish();
			}else
			{
				Toast.makeText(this, "再按一次后退键，退出Calclator", Toast.LENGTH_SHORT).show();
				lastClickTime = currentClickTime;
			}
		}
	}

}