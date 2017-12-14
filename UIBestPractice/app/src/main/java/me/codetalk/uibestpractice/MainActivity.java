package me.codetalk.uibestpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import me.codetalk.uibestpractice.adapter.MsgAdapter;
import me.codetalk.uibestpractice.vo.Msg;

public class MainActivity extends AppCompatActivity {

    private List<Msg> msgList = new ArrayList<>();

    private EditText inputText;

    private Button btnSend;

    private RecyclerView msgRecyclerView;

    private MsgAdapter msgAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMsgs();

        inputText = findViewById(R.id.text_msg);
        btnSend = findViewById(R.id.btn_msg_send);

        msgRecyclerView = findViewById(R.id.view_msg_recycler);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(layoutManager);
        msgAdapter = new MsgAdapter(msgList);
        msgRecyclerView.setAdapter(msgAdapter);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = inputText.getText().toString();
                if(!"".equals(content)) {
                    Msg msg = new Msg(content, Msg.TYPE_SEND);
                    msgList.add(msg);
                    msgAdapter.notifyItemInserted(msgList.size() - 1);
                    msgRecyclerView.scrollToPosition(msgList.size() - 1);

                    inputText.setText("");
                }
            }
        });

    }


    private void initMsgs() {
        msgList.add(new Msg("Hello Guy.", Msg.TYPE_RECV));
        msgList.add(new Msg("Hello, who is that ?", Msg.TYPE_SEND));
        msgList.add(new Msg("This is Tom. Nice talking to you.", Msg.TYPE_RECV));
    }


}
