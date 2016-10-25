package com.example.jewel.clothingrec;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.print.PrinterId;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by jewel on 16/8/16.
 */
public class ItemDetailActivity extends Activity {
    private Button shareBtn,backBtn;
    private TextView detailView,perView;
    private ImageView picView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listdetail);

        shareBtn = (Button) findViewById(R.id.shareBtn);
        backBtn = (Button) findViewById(R.id.backBtn);
        detailView = (TextView) findViewById(R.id.detailDe);
        perView  =(TextView)findViewById(R.id.perDetail);
        picView = (ImageView)findViewById(R.id.imageView);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getBundleExtra("info");
        String per = bundle.getString("percent");
        String detail = bundle.getString("detail");
        String pic  =bundle.getString("picStr");
        int imageId = bundle.getInt("picId");

        detailView.setText(detail);
        perView.setText(per);
        picView.setImageResource(imageId);


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
