package com.example.jewel.clothingrec;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by jewel on 2016/10/25.
 */
public class TagsForPants extends Activity {
    private Button sendTagsBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tags_pants);
        sendTagsBtn = (Button)findViewById(R.id.button);
        sendTagsBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent =new Intent(TagsForPants.this,ShowListActivity.class);
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
