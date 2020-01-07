package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.listview);
        lv.setAdapter(new ImageTextAdapter(MainActivity.this));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView)((LinearLayout)view).getChildAt(1);
                Toast.makeText(MainActivity.this, tv.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    public class ImageTextAdapter extends BaseAdapter{
        int images[] = {R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5,
                R.drawable.a6, R.drawable.a7, R.drawable.a8, R.drawable.a9, R.drawable.a10,
                R.drawable.a11, R.drawable.a12, R.drawable.a13, R.drawable.a14, R.drawable.a15, R.drawable.a16};
        Context context;
        LayoutInflater layoutInflater;
        private ViewHolder viewHolder;

        public ImageTextAdapter(Context context) {
            this.context = context;
            layoutInflater = (LayoutInflater)context.getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = layoutInflater.inflate(R.layout.item, null);
                viewHolder = new ViewHolder();
                viewHolder.iv  = convertView.findViewById(R.id.imageView);
                viewHolder.tv = convertView.findViewById(R.id.textView);
                viewHolder.btn = convertView.findViewById(R.id.button);
                convertView.setTag(viewHolder);
            }else{
                viewHolder = (ViewHolder)convertView.getTag();
            }
            viewHolder.iv.setImageResource(images[position]);
            viewHolder.tv.setText("No." + (position+1));
            viewHolder.btn.setText("No." + (position+1));
            viewHolder.btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, ((Button)v).getText(), Toast.LENGTH_SHORT).show();
                }
            });
            return convertView;
        }
        public class ViewHolder{
            ImageView iv;
            TextView tv;
            Button btn;
        }
    }
}
