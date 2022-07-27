package com.example.contact2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView contact_rc;
    ArrayList<Contact>contactArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contact_rc=findViewById(R.id.contact_rc);//adapter,layout manager


        contactArrayList= new ArrayList<>();
        contactArrayList.add(new Contact("https://lastfm.freetls.fastly.net/i/u/770x0/cc69860f1374ffe02d2ae5f06701b8c4.jpg","wagio","0746450089"));
        contactArrayList.add(new Contact("https://i.pinimg.com/750x/f9/33/ae/f933ae244533f20727d0daba173128b8.jpg","brian","0792432505"));
        contactArrayList.add(new Contact("https://i.pinimg.com/736x/6e/f7/86/6ef7863846a3f06ad581323d2454ac9e.jpg","siz","0726926288"));

        ContactAdapter contactAdapter = new ContactAdapter(this,contactArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        contact_rc.setAdapter(contactAdapter);
        contact_rc.setLayoutManager(linearLayoutManager);

    }
}