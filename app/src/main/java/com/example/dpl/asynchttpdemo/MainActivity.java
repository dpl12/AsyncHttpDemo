package com.example.dpl.asynchttpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        asyncHttpGet();
        asyncHttpPost();
    }
    private void asyncHttpGet(){
        AsyncHttpClient client=new AsyncHttpClient();
        String url="http://www.kuaidi100.com/query?type=shunfeng&postid=25784";
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Toast.makeText(getApplicationContext(),headers.toString(),Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(getApplicationContext(),"请求失败",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void asyncHttpPost(){
        AsyncHttpClient client=new AsyncHttpClient();
        String url="http://baike.baidu.com/api/openapi/BaikeLemmaCardApi?scope=103&format=json&appid=379020&bk_length=600";
        RequestParams params=new RequestParams();
        params.put("bk_key","顺丰");
        client.post(url,params,new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Toast.makeText(getApplicationContext(),headers.toString(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(getApplicationContext(),"请求失败",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
