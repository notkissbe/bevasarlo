package hu.notkissbe.bevasarlo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    HashMap<String, String> products = new HashMap<>();
    EditText name;
    EditText amount;
    Button add;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        ListAdapter adapter = new ListAdapter(this, new ArrayList<>(products.keySet()), new ArrayList<>(products.values()));
        listView.setAdapter(adapter);
        add.setOnClickListener(v -> {
            String nameText = name.getText().toString();
            String amountText = amount.getText().toString();
            if (!nameText.isEmpty() && !amountText.isEmpty()) {
                products.put(nameText, amountText);
                adapter.items.add(nameText);
                adapter.amounts.add(amountText);
                adapter.notifyDataSetChanged();
            }
            name.setText("");
            amount.setText("");

        });
        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            adapter.removeItem(position);
            return true;
        });
        listView.setOnItemClickListener((parent, view, position, id) -> {

        });


    }
    private void init(){
        name = findViewById(R.id.name);
        amount = findViewById(R.id.amount);
        add = findViewById(R.id.add);
        listView = findViewById(R.id.list);
    }
}

