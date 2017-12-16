package me.codetalk.restjsontest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import me.codetalk.restjsontest.util.JsonUtil;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    // API config
    static final String API_SERVICE_HOST = "http://192.168.1.33:8080";
    static final String URI_GET_META = "/hca/api/business/common/shop/prodmeta";

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    // views
    private EditText inputSrcType;
    private EditText inputPfType;

    private RecyclerView metaListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputSrcType = findViewById(R.id.input_srctype);
        inputPfType = findViewById(R.id.input_pftype);

        Button btnReq = findViewById(R.id.btn_send_req);
        btnReq.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        if(viewId == R.id.btn_send_req) {
            String srcType = inputSrcType.getText().toString(),
                    pfType = inputPfType.getText().toString();
            if(isNull(srcType) || isNull(pfType)) {
                Toast.makeText(this, "Source or Platform type cannot be null", Toast.LENGTH_SHORT).show();
            } else {
                OkHttpClient client = new OkHttpClient();

                String metaApiUrl = API_SERVICE_HOST + URI_GET_META;
                Map<String, Object> params = new HashMap<>();
                params.put("src_type", srcType);
                params.put("pf_type", pfType);
                RequestBody requestBody = RequestBody.create(JSON, JsonUtil.toJson(params));

                Request request = new Request.Builder().url(metaApiUrl).post(requestBody).build();
                try {
                    Response response = client.newCall(request).execute();
                    String retData = response.body().string();
                    Log.i(TAG, retData);
                } catch(Exception ex) {
                    ex.printStackTrace();
                    Toast.makeText(this, "Error request, url = " + metaApiUrl, Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private boolean isNull(String s) {
        return s == null || s.length() == 0;
    }


}
