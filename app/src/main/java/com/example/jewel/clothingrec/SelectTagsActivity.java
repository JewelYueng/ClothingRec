package com.example.jewel.clothingrec;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
/**
 * Created by jewel on 2016/10/23.
 */
public class SelectTagsActivity extends Activity{
    private Button sendTagsBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tags);
        sendTagsBtn = (Button)findViewById(R.id.sendBtn);
        sendTagsBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent =new Intent(SelectTagsActivity.this,ShowListActivity.class);
                //用Bundle携带数据
                Bundle bundle=new Bundle();
                //传递name参数为tinyphp
                bundle.putString("name", "tinyphp");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

}
