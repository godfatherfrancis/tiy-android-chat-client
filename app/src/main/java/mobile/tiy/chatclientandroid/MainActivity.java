package mobile.tiy.chatclientandroid;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener {

    AndroidChatClient chatClient;
    ArrayAdapter<String> messages;

    ListView list;
    EditText text;
    Button addButton;

    // onCreate - this will initialize my view
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // list view component
        list = (ListView) findViewById(R.id.listView);
        text = (EditText) findViewById(R.id.editText);
        addButton = (Button) findViewById(R.id.button);

        // messages array list (tie to this, type of list)
        messages = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        list.setAdapter(messages);

        chatClient = new AndroidChatClient();

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        addButton.setOnClickListener(this);
        list.setOnItemLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // adding whats in our txt field to item and adding to array then clearing screen
        String incomingMessage = text.getText().toString();
        messages.add(incomingMessage);
        text.setText("");
        chatClient.sendMessage(incomingMessage);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        String sentMessage = messages.getItem(position);
        messages.remove(sentMessage);
        return true;
    }
}
