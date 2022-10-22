package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class ChatWindow extends AppCompatActivity {
    ArrayList<String> chat = new ArrayList<String>();
    ChatAdapter adapter ;
    ListView lv = null;
    EditText mb = null;
    Button s = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_window);
        s = (Button) findViewById(R.id.sendbtn);
        Log.d("Chat", "Open");
        mb = (EditText) findViewById(R.id.msgBox);
        lv = (ListView) findViewById(R.id.msgList);

        ChatAdapter messageAdapter = new ChatAdapter(this, 0, chat);
        adapter = messageAdapter;
        lv.setAdapter (messageAdapter);

    }

    public void onClick(View v){
        chat.add( mb.getText().toString() );
        adapter.notifyDataSetChanged();
        Log.d("Chat", chat.get(0).toString());
        mb.setText("");
    }


    private class ChatAdapter extends ArrayAdapter<String>{

        private ArrayList<String> lst;
        private int source;
        private Context context;

        public ChatAdapter(Context ctx, int resource, ArrayList<String> l) {
            super(ctx,resource,l);
            context =ctx;
            lst = l;

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){


            LayoutInflater inflater = LayoutInflater.from(context);


            View r = null ;

            if(position%2 != 0){
                r = inflater.inflate(R.layout.chat_row_outgoing, null);
            }

            else{
                r = inflater.inflate(R.layout.chat_row_incoming, null);
            }

            TextView message = (TextView)r.findViewById(R.id.message_text);
            message.setText(   getItem(position)  );
            return r;

        }

        @Override
        public int getCount() {
            return super.getCount();
        }

        public String getItem(int position){
            return lst.get(position);
        }
    }



}