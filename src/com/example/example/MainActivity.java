package com.example.example;


import com.example.example3.R;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;



public class MainActivity extends Activity {
	
	
	
	final String[] items = {"���ʑ�", "���ʒ�", "���ʏ�"};	
	final String[] items2 = {"��", "��", "��"};	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final String[] data = {"�ʒm��", "����", "�����̑傫��"}; 
		
		
			 ArrayAdapter<String> adapter = new ArrayAdapter<String>(this
					   , android.R.layout.simple_list_item_1, data ) {   
				 
				 @Override
				public 	View getView(int position, View convertView, ViewGroup parent) {
					   final TextView view1 = (TextView)super.getView(position, convertView, parent);
						 
					  
					  view1.setTextSize(koko(1) );
					   return view1;
					   
					   }

				

				
			
				   };      
			   ListView listView = (ListView) findViewById(R.id.listView1);       // �A�_�v�^�[��ݒ肵�܂�
			   listView.setAdapter(adapter); 
			  
			 

	        // ���X�g�r���[�̃A�C�e�����N���b�N���ꂽ���ɌĂяo�����R�[���o�b�N���X�i�[��o�^���܂�
	        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	            
	       
	        	@Override
	            
	          public void onItemClick(AdapterView<?> parent, final View view,final int position, final long id) {
	                final ListView listView = (ListView) parent;
	                // �N���b�N���ꂽ�A�C�e�����擾���܂�
	                String item2 = (String) listView.getItemAtPosition(position);
	              
	              
	                final int size[] ={10, 20,30};
	               
	                if(item2 == "�����̑傫��"){
	                	new AlertDialog.Builder(MainActivity.this)
	        			.setTitle("�f�[�^��I�����Ă�������")
	        			.setSingleChoiceItems(items2, 0, new DialogInterface.OnClickListener() {
	        				
							public void onClick(DialogInterface dialog, int item) {	
								
								 koko(3);
								 Intent m = new Intent(MainActivity.this, MainActivity.class);
								 m.putExtra("�ʒm��", "ere");
								 startActivity(m);
								 
								
							}

							

														

							
							
	        		})
	
	        			.setNegativeButton("����", new DialogInterface.OnClickListener() {
	        			public void onClick(DialogInterface dialog, int id) {
	        				dialog.cancel();
	        			}
	        		})
	        		.show();
	                	
        				
	                }else if(item2 == "�ʒm��"){
	        			Intent inten = new Intent(MainActivity.this,SubActivity.class);
	        			startActivity(inten);
	        			
	        				
	        			
	                }else if(item2 == "����"){
	                	
	                	new AlertDialog.Builder(MainActivity.this)
	        			.setTitle("�f�[�^��I�����Ă�������")
	        			
	        			.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
	        				
							
	        				public void onClick(DialogInterface dialog, final int item) {	
	        					((TextView) view).setTextSize( size[item] );
	        					
	        					
	        			}
	        			
	        		})
	        			.setNegativeButton("����", new DialogInterface.OnClickListener() {
	        			public void onClick(DialogInterface dialog, int id) {
	        				dialog.cancel();
	        			}
	        		})
	        		.show();
	        	}			
	        	

	              
	                
	            }
	        });
	        
	        // ���X�g�r���[�̃A�C�e�����I�����ꂽ���ɌĂяo�����R�[���o�b�N���X�i�[��o�^���܂�
	        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
	            @Override
	            public void onItemSelected(AdapterView<?> parent, View view,
	                    int position, long id) {
	                ListView listView = (ListView) parent;
	                // �I�����ꂽ�A�C�e�����擾���܂�
	                String item = (String) listView.getSelectedItem();
	                if(item == "�ʒm��"){
        				Intent inten = new Intent(MainActivity.this,SubActivity.class);
        				startActivity(inten);
        			
                	
                }
	            }
	            @Override
	            public void onNothingSelected(AdapterView<?> parent) {
	            }
	        });
	      
    }


protected float koko(int i) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return 20*i;
	}


@Override
public boolean onOptionsItemSelected(MenuItem item) {
	// Handle action bar item clicks here. The action bar will
	// automatically handle clicks on the Home/Up button, so long
	// as you specify a parent activity in AndroidManifest.xml.
	int id = item.getItemId();
	if (id == R.id.action_settings) {
		return true;
	}
	return super.onOptionsItemSelected(item);
}
	




}
