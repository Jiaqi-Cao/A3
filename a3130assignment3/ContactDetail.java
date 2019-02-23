package com.example.acme.a3130assignment3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.acme.a3130assignment3.model.Contact;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class ContactDetail extends AppCompatActivity {

    private TextView name;
    private TextView email;
    private Button delete;
    private Button update;
    private TextView bn;
    private TextView pb;
    private TextView address;
    private TextView province;

    private FirebaseFirestore database;
    private Intent intent;
    private Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_detail);

        name = findViewById(R.id.nameEdit);
        email = findViewById(R.id.emailEdit);
        delete = findViewById(R.id.deleteButton);
        update = findViewById(R.id.updateButton);
        bn = findViewById(R.id.BN);
        pb = findViewById(R.id.PB);
        address = findViewById(R.id.Address);
        province = findViewById(R.id.Province);

        database = FirebaseFirestore.getInstance();

        intent = getIntent();

        contact = (Contact)intent.getSerializableExtra("contact");
        name.setText(contact.name);
        email.setText(contact.email);
        bn.setText(contact.bn);
        pb.setText(contact.pb);
        address.setText(contact.address);
        province.setText(contact.province);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateContact();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteContact();
            }
        });



    }

    //TODO: add the logic for updating an entry
    private void updateContact()
    {
        DocumentReference ref = database.collection("contacts").document(contact.id);
        ref.update("name", name.getText().toString());
        ref.update("email", email.getText().toString());
        ref.update("address", address.getText().toString());
        ref.update("bn", bn.getText().toString());
        ref.update("pb", pb.getText().toString());
        ref.update("province", province.getText().toString());

        finish();
    }

    //TODO: add the logic for deleting an entry
    private void deleteContact()
    {

        //finishes the activity
        DocumentReference ref = database.collection("contacts").document(contact.id);
        ref.delete();
        finish();

    }
}
