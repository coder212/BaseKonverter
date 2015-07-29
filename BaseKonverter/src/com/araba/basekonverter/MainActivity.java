package com.araba.basekonverter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;

public class MainActivity extends Activity {

	
	EditText biner,decimal,octal,hexa;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODOs Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main);
		
		biner=(EditText)findViewById(R.id.biner);
		octal=(EditText)findViewById(R.id.octal);
		decimal=(EditText)findViewById(R.id.decimal);
		hexa=(EditText)findViewById(R.id.hexa);
		
		biner.setOnKeyListener(new OnKeyListener() {
			
			@Override
			public boolean onKey(View view, int keycode, KeyEvent event) {
				// TODOs Auto-generated method stub
				if (keycode==KeyEvent.KEYCODE_ENTER) {
			           // the user is done typing.
					String bil_Biner = biner.getText().toString();
					try{
						int intbiner = Integer.parseInt(bil_Biner,2);
						MainActivity.this.octal.setText(Integer.toOctalString(intbiner));
						MainActivity.this.hexa.setText(Integer.toHexString(intbiner));
						MainActivity.this.decimal.setText(String.format("%d", intbiner));
					}catch (Exception e){
						e.printStackTrace();
						binerError();
					}
					

			           return true; // consume.
			        }  
				return false;
			}
				
		});
		
		octal.setOnKeyListener(new OnKeyListener() {
			
			@Override
			public boolean onKey(View view, int keycode, KeyEvent event) {
				// TODOs Auto-generated method stub
                if(keycode==KeyEvent.KEYCODE_ENTER){
					
					String bil_Octal = octal.getText().toString();
					try{
						int intoctal = Integer.parseInt(bil_Octal,8);
						MainActivity.this.biner.setText(Integer.toBinaryString(intoctal));
						MainActivity.this.hexa.setText(Integer.toHexString(intoctal));
						MainActivity.this.decimal.setText(Integer.toString(intoctal));
					}catch(Exception e){
						e.printStackTrace();
						octalError();
					}
					return true;
				}
				return false;
			}
		});
		
		decimal.setOnKeyListener(new OnKeyListener() {
			
			@Override
			public boolean onKey(View view, int keyCode, KeyEvent event) {
				// TODOs Auto-generated method stub
                if(keyCode==KeyEvent.KEYCODE_ENTER){
					
				    try{
					   int bil_Des = Integer.parseInt(decimal.getText().toString());
					   //int intbiner = Integer.parseInt(bil_Biner);
					   MainActivity.this.octal.setText(Integer.toOctalString(bil_Des));
					   MainActivity.this.hexa.setText(Integer.toHexString(bil_Des));
					   MainActivity.this.biner.setText(Integer.toBinaryString(bil_Des));
				    }catch(Exception e){
				    	e.printStackTrace();
				    	decimalError();
				    }
					return true;
				}
				return false;
			}
		});
		
		hexa.setOnKeyListener(new OnKeyListener() {
			
			@Override
			public boolean onKey(View view, int keycode, KeyEvent event) {
				// TODOs Auto-generated method stub
                if(keycode==KeyEvent.KEYCODE_ENTER){
					
					String bil_Hexa = hexa.getText().toString();
					
					try{
					    int inthex = Integer.parseInt(bil_Hexa,16);
						MainActivity.this.octal.setText(Integer.toOctalString(inthex));
						MainActivity.this.biner.setText(Integer.toBinaryString(inthex));
						MainActivity.this.decimal.setText(Integer.toString(inthex));
					}catch(Exception e){
						e.printStackTrace();
						hexaError();
					}
					return true;
				}
				return false;
			}
		});
		
		
	}
	
	private void binerError(){
		MainActivity.this.octal.setText("invalid number format");
		MainActivity.this.hexa.setText("invalid number format");
		MainActivity.this.decimal.setText("invalid number format");
	}
	
	private void octalError(){
		MainActivity.this.biner.setText("invalid number format");
		MainActivity.this.hexa.setText("invalid number format");
		MainActivity.this.decimal.setText("invalid number format");
	}
	
	private void decimalError(){
		MainActivity.this.octal.setText("invalid number format");
		MainActivity.this.hexa.setText("invalid number format");
		MainActivity.this.biner.setText("invalid number format");
	}

	private void hexaError(){
	
		MainActivity.this.octal.setText("invalid number format");
		MainActivity.this.biner.setText("invalid number format");
		MainActivity.this.decimal.setText("invalid number format");
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODOs Auto-generated method stub
		
		MenuInflater meninflater = getMenuInflater();
		meninflater.inflate(R.menu.menu, menu);
		
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODOs Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.about:
			startActivity(new Intent(MainActivity.this,AboutActivity.class));
			return true;
		
		case R.id.credits:
			startActivity(new Intent(MainActivity.this,CreditsActivity.class));
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
		
	}

}
