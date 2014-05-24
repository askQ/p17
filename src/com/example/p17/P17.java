package com.example.p17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.net.Uri;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemLongClickListener;


public class P17 extends Activity {
	
	Gallery gallery;
	 List<Map<String, String>> list = new ArrayList<Map<String, String>>();
	 MyAdapter adapter ;
	String detail,title;
	Button button;
	String uri="content://media/external/images/media/105860";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_p17);
		gallery = (Gallery) findViewById(R.id.gallery);

		 save("tierwetle","dwrweretail",uri);
		 adapter = new MyAdapter(this);
		 gallery.setAdapter(adapter);
		 gallery.setOnItemClickListener(new OnItemClickListener(){
			          public void onItemClick(AdapterView parent, View view, int position, long id) {
			        
			            }
			        });
		 button =(Button)findViewById(R.id.button_out);
	}
	public void save(String title, String detail,String uri_s_from ){
		
		Map<String,String> map = new HashMap<String,String>();
		  map.put("Title",title);
		  map.put("detail",detail);
			 map.put("Uri_string", uri_s_from);
			 map.put("button", "vote");
		  list.add(map);
		  
	}
	public class MyAdapter extends BaseAdapter{ 
		private LayoutInflater mInflater; 
		public MyAdapter(Context context){ 
		this.mInflater = LayoutInflater.from(context); 
		}

		@Override 
		public int getCount() { 
		// TODO Auto-generated method stub 
		return list.size();

		}

		@Override 
		public Object getItem(int arg0) { 
		// TODO Auto-generated method stub 
		return null; 
		}

		@Override 
		public long getItemId(int arg0) { 
		// TODO Auto-generated method stub 
		return 0; 
		} 
		
		
		@Override 
		public View getView(final int position, View convertView, ViewGroup parent) { //ps this place i write position to final in order to get position in the button click case
		ViewHolder holder = null; 
		if (convertView == null) { 
		holder=new ViewHolder(); 
		convertView = mInflater.inflate(R.layout.listview_choice, null); 
		holder.img = (ImageView)convertView.findViewById(R.id.imageView_choice); 
		holder.title = (TextView)convertView.findViewById(R.id.textView_title); 
		holder.info = (TextView)convertView.findViewById(R.id.textView_detail); 
		holder.viewBtn = (Button)convertView.findViewById(R.id.button1); 
		convertView.setTag(holder); 
		}else { 
		holder = (ViewHolder)convertView.getTag(); 
		} 
	
		holder.title.setText((String)list.get(position).get("Title")); 
		holder.info.setText((String)list.get(position).get("detail")); 
		Uri uri = Uri.parse(list.get(position).get("Uri_string"));
		holder.img.setImageURI(uri);
		holder.viewBtn.setText((String)list.get(position).get("button")); 
		holder.viewBtn.setOnClickListener(new View.OnClickListener() {

		@Override 
		public void onClick(View v) { 
	//	  Toast.makeText(context, text, duration)
			Toast.makeText(getApplicationContext(), list.get(position).get("Uri_string"), 1).show();
		} 
		});

		return convertView; 
		}

		}
	public final class ViewHolder{ 
		public ImageView img; 
		public TextView title; 
		public TextView info; 
		public Button viewBtn; 
		}
	
}
