package com.example.acme.a3130assignment3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.acme.a3130assignment3.model.Contact;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class AddContact extends AppCompatActivity {

    private TextView name;
    private TextView email;
    private TextView bn;
    private TextView pb;
    private TextView address;
    private TextView province;

    private Button addContact;

    FirebaseFirestore database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        name = findViewById(R.id.nameEdit);
        email = findViewById(R.id.emailEdit);
        addContact = findViewById(R.id.addNew);
        bn = findViewById(R.id.BN);
        pb = findViewById(R.id.PB);
        address = findViewById(R.id.Address);
        province = findViewById(R.id.Province);

        database = FirebaseFirestore.getInstance();

        addContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Contact c = new Contact(name.getText().toString(),email.getText().toString(),bn.getText().toString(),pb.getText().toString(),address.getText().toString(),province.getText().toString());

                //Here instead of adding directly we are first getting a reference so we save the ID;
                // this is not necessary but it will make life easier latter when editing/deleting.
                DocumentReference ref = database.collection("contacts").document();
                c.id = ref.getId();
                ref.set(c);

                //Finishes the acitivy and return to the parent one.
                finish();
            }
        });

    }
}
