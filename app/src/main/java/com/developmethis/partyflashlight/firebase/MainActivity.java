package com.developmethis.partyflashlight.firebase;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    List<item> itemList;
    item currentItem;
    TextView name,no,price,desc,size;
    private DocumentReference mDocRef= FirebaseFirestore.getInstance().collection("Items").document("hello");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        name = (TextView)findViewById(R.id.name);
        no = (TextView)findViewById(R.id.itemno);
        desc= (TextView)findViewById(R.id.desc);
        size=(TextView)findViewById(R.id.size);
        price=(TextView)findViewById(R.id.price);

        if(itemList.size()>0){
            currentItem = itemList.get(0);
            name.setText(currentItem.getIname());
            desc.setText(currentItem.getIdesc());
            size.setText(String.valueOf(currentItem.getIsize()));
            no.setText(String.valueOf(currentItem.getIno()));
            price.setText(String.valueOf(currentItem.getIprice()));
        }

    }

    @Override
    protected void onStart() {
        super.onStart();

        mDocRef.addSnapshotListener(this,new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(DocumentSnapshot documentSnapshot, FirebaseFirestoreException e) {
                if(documentSnapshot.exists()){
                    currentItem.setIdesc(documentSnapshot.getString("Description"));
                    currentItem.setIname(documentSnapshot.getString("Item_Name"));
                    currentItem.setIsize(documentSnapshot.getString("Size"));
                    currentItem.setIno((Long)documentSnapshot.get("Item_No"));
                    currentItem.setIprice((Long)documentSnapshot.get("Price"));
                    itemList.add(currentItem);
                }
                else {
                    Toast toast = Toast.makeText(MainActivity.this,"Not Exists",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}