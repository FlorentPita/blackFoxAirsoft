package appli.beta.blackfox;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Gallerie extends Activity {
	Integer[] pics = {
			R.drawable.bloblo,
			R.drawable.blurp,
			R.drawable.biblop,
			R.drawable.blop,
			R.drawable.blablu


	};
	
	@Override
	public void onDestroy(){
		super.onDestroy();
		System.runFinalizersOnExit(true);
		System.exit(0);
	}
	
	ImageView imageView;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gallerie);

		Gallery ga = (Gallery)findViewById(R.id.Gallery01);
		ga.setAdapter(new ImageAdapter(this));

		imageView = (ImageView)findViewById(R.id.ImageView01);
		ga.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Toast.makeText(getBaseContext(),"Vous avez selectionné l'image numero: " + (arg2+1),Toast.LENGTH_SHORT).show();
				imageView.setImageResource(pics[arg2]);

			}

		});

	}


	public class ImageAdapter extends BaseAdapter {

		private Context ctx;
		int imageBackground;

		public ImageAdapter(Context c) {
			ctx = c;
		}

		@Override
		public int getCount() {
			return pics.length;
		}

		@Override
		public Object getItem(int arg0) {
			return arg0;
		}

		@Override
		public long getItemId(int arg0) {
			return arg0;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			ImageView iv = new ImageView(ctx);
			iv.setImageResource(pics[arg0]);
			iv.setScaleType(ImageView.ScaleType.FIT_XY);
			iv.setLayoutParams(new Gallery.LayoutParams(150,120));
			iv.setBackgroundResource(imageBackground);
			return iv;
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.presentation, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			Intent intentPropos = new Intent(this,Apropos.class);
			this.startActivityForResult(intentPropos,10);
		}
		
		else if(id== R.id.action_quit){
			finish();

		}
		
		return super.onOptionsItemSelected(item);
	}
}
