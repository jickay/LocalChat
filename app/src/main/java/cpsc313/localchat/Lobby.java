package cpsc313.localchat;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cpsc313.localchat.Adapters.MessagesAdapter;

public class Lobby extends AppCompatActivity {

    private EditText inputMessage;
    private ListView chatWindow;

    private String username;
    private ArrayList<String> messages = new ArrayList<>();

    MessagesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);

        inputMessage = (EditText) findViewById(R.id.input_message);
        chatWindow = (ListView) findViewById(R.id.chat_window);

        // Get username from login intent
        username = getIntent().getStringExtra("username");

        // Set listener for input messages
        setInputListener();

        // Set adapter for listview to display messages
        messages.add("Test");
//        adapter = new MessagesAdapter(getApplicationContext(),messages.toArray(new String[messages.size()]));
//        chatWindow.setAdapter(adapter);
    }

    private void setInputListener() {
        inputMessage.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction()==KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    String message = inputMessage.getText().toString();
                    submitMessage(username, message);
                    inputMessage.setText("");
                    return true;
                }
                return false;
            }
        });
    }

    private void submitMessage(String username, String message) {
        messages.add(message);
        Log.i("Submit",messages.toString());
        adapter = new MessagesAdapter(getApplicationContext(),messages.toArray(new String[messages.size()]));
        chatWindow.setAdapter(adapter);
        // Need to submit to database later!
    }
}

