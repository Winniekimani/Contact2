package com.example.contact2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    Context context;
    ArrayList<Contact>contactArrayList;

    public ContactAdapter(Context context, ArrayList<Contact> contactArrayList) {
        this.context = context;
        this.contactArrayList = contactArrayList;
    }

    @NonNull
    @Override
    public ContactAdapter.ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.contactview,parent,false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ContactViewHolder holder, int position) {

        Contact contact=contactArrayList.get(position);
        holder.contact_name.setText(contact.getContact_name());
        holder.contact_phone.setText(contact.getContact_phone());
        Glide.with(context).load(contact.image_url).placeholder(R.drawable.test).into(holder.contact_photo);
        holder.call.setOnClickListener(view -> {

            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + contact.getContact_phone()));
            context.startActivity(intent);

        });

        holder.contact_message.setOnClickListener(view -> {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(contact.getContact_phone(), null, contact.getContact_name(), null, null);
        });
        holder.contact_email.setOnClickListener(view -> {
            Log.i("Send email", "");

            String[] TO = {"gachugusville@gmail.com"};
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setData(Uri.parse("mailto:"));
            emailIntent.setType("text/plain");


            emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

            try {
                context.startActivity(Intent.createChooser(emailIntent, "Send mail..."));

                Log.i("Finished", "");
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(context,
                        "There is no email client installed.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactArrayList.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {

        CircleImageView contact_photo;
        TextView contact_name;
        TextView contact_phone;
        ImageView call;
        ImageView contact_message;
        ImageView contact_email;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            contact_photo=itemView.findViewById(R.id.contact_photo);
            contact_name=itemView.findViewById(R.id.contact_name);
            contact_phone=itemView.findViewById(R.id.contact_phone);
            call=itemView.findViewById(R.id.call);
            contact_message=itemView.findViewById(R.id.contact_message);
            contact_email=itemView.findViewById(R.id.contact_email);
        }
    }
}
