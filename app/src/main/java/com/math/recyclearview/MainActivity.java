package com.math.recyclearview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Informations> informationsList=new ArrayList<>();;
    private RecyclerView recyclerView;
    private InformationAdapter adapter;
    private EditText nameEt,emailEt,paswordEt;
    Informations informations;

    //informationsList
    String name,email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();







    }

    private void init() {

        nameEt=findViewById(R.id.nameEt);

        emailEt=findViewById(R.id.emailEt);

        paswordEt=findViewById(R.id.passwordEt);




    }

    public void inserted(View view) {


        name=nameEt.getText().toString().trim();
        email=emailEt.getText().toString().trim();
        password=paswordEt.getText().toString().trim();

        if (!name.equals("") &&!email.equals("") &&!password.equals(""))
        {
            recyclerView=findViewById(R.id.recyclearView);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            adapter=new InformationAdapter(informationsList);
            recyclerView.setAdapter(adapter);

            informations = new  Informations(name,email,password);
            informationsList.add( informations);

            adapter.notifyDataSetChanged();
            nameEt.setText("");
            emailEt.setText("");
            paswordEt.setText("");
        }
        else {
            Toast.makeText(MainActivity.this,"Empty Feild.Please Fillup",Toast.LENGTH_LONG).show();
        }






    }





    public void clear(View view) {



       if(informationsList.size()==0){
           Toast.makeText(MainActivity.this,"Empty",Toast.LENGTH_LONG).show();
       }
       else{
           informationsList.clear();
           adapter.notifyDataSetChanged();
           Toast.makeText(MainActivity.this,"Clear all Data",Toast.LENGTH_LONG).show();
       }
       //

    }
}
