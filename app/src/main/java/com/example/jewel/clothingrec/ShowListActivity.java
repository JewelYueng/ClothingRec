package com.example.jewel.clothingrec;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by jewel on 16/8/16.
 */
public class ShowListActivity extends Activity implements AbsListView.OnItemClickListener,AbsListView.OnScrollListener{
    private ListView matchList;
    private ArrayAdapter<String> arr_adapter;
    private SimpleAdapter sim_adapter;
    private List<Map<String,Object>> datalist;
    private  Context list;
    private SuitCase cases[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.showlist);
        matchList = (ListView) findViewById(R.id.listView);
        list = this;
        datalist = new ArrayList<Map<String,Object>>();
        cases = new SuitCase[6];
//
        sim_adapter = new SimpleAdapter(this,getData(),R.layout.listitem,new String[]{"pic","percent","detail"},new int[]{R.id.pic,R.id.percent,R.id.matchDetail});
        matchList.setAdapter(sim_adapter);
        matchList.setOnItemClickListener(this);
        matchList.setOnScrollListener(this);
    }
    private List<Map<String,Object>> getData(){
        cases[0] = new SuitCase("同一色系的搭配降低不违和感，搭配指数为20%",20,R.mipmap.img3);
        cases[1] = new SuitCase("同一色系的搭配降低不违和感，毛织衫搭配针织短裤，提高干爽度",30,R.mipmap.img2);
        cases[2] = new SuitCase("白T恤搭配黑裤子是屡次不爽的搭配，如果嫌单调可以选择黑色系带波点的裤子",40,R.mipmap.img1);
        cases[3] = new SuitCase("上身条纹，下身搭配简单的半身裙，不会显得村姑反而更加清爽",50,R.mipmap.img5);
        cases[4] = new SuitCase("针织毛衣，在冬天还可以搭配针织半身裙，看起来就很暖和",60,R.mipmap.img6);
        cases[5] = new SuitCase("白色衬衫，搭配浅色系半身裙，显得高雅",70,R.mipmap.img7);
        for (int i = 0;i < 6;i++){
            String percent = cases[i].getPer() + "%";
            String detail = cases[i].getDetail() + "";
            int id = cases[i].getPic();
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("pic",id);
            map.put("percent",percent);
            map.put("detail",detail);
            datalist.add(map) ;
        }
        return datalist;
    }
    @Override
    public void onItemClick(AdapterView<?>parent, View view,int position,long id){
//        String text = matchList.getItemAtPosition(position).toString();

//        用Bundle对象储存点击的项目的参数
        Bundle bundle = new Bundle();
        TextView detailView = (TextView)view.findViewById(R.id.matchDetail);
        String detail = detailView.getText().toString();
        TextView percentView = (TextView)view.findViewById(R.id.percent);
        String perStr = percentView.getText().toString();
        ImageView picView = (ImageView)view.findViewById(R.id.pic);
        String pic = picView.getDrawable().toString();
        bundle.putString("detail",detail);
        bundle.putString("percent",perStr);
        bundle.putInt("picId",R.mipmap.img1);

        Toast.makeText(this,"position="+position+",text="+pic,Toast.LENGTH_LONG).show();

        Intent intent = new Intent(list,ItemDetailActivity.class);
        intent.putExtra("info",bundle);
        startActivityForResult(intent,position);
    }
    @Override
    public void onScroll( AbsListView view,int firstVisibleItem,int visibleItemCount,int totalItemCount){

    }
    @Override
    public void onScrollStateChanged( AbsListView view,int state){

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
