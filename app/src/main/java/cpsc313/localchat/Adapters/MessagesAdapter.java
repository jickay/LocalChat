package cpsc313.localchat.Adapters;

/**
 * Created by ViJack on 10/8/2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import cpsc313.localchat.R;

public class MessagesAdapter extends ArrayAdapter<String> {

    private Context context;
    private String[] allMessages;

    public MessagesAdapter(Context context, String[] messages) {
        super(context, -1, messages);
        this.context = context;
        allMessages = messages;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.chat_message, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.message);
        textView.setText(allMessages[position]);

        return rowView;
    }
}