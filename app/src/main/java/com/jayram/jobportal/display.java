package com.jayram.jobportal;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

public class display extends AppCompatActivity {
    private TextView textview;

    protected void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_display);
        textview=findViewById(R.id.textView5);
        String position = getIntent().getStringExtra("pos");

        JSONArray documents = new JSONArray();

        Toast.makeText(display.this, "The search is successful", Toast.LENGTH_SHORT).show();
        String data = "";
        for (int i = 0; i < documents.length(); i++) {
            Employer e;
            e = new Employer();
            try {
                JSONObject jsonObject = documents.getJSONObject(i);
                e.setEditdocumentid(jsonObject.getString("id"));
                String documentid = e.getEditdocumentid();
                String name = jsonObject.getString("name");
                String cname = jsonObject.getString("company name");
                String phone = jsonObject.getString("phone");
                String city = jsonObject.getString("city");
                String country = jsonObject.getString("country");
                String vac = jsonObject.getString("vacancy");

                data+="Document ID: "+documentid+"\n Employer name: "+name+"\n Company name: "+cname+
                        "\n Phone: "+phone+"\n City: "+city+"\n Country :"+country+"\n Vacancy: "+vac+"\n";
            } catch (Exception ex){}
        }
        textview.setText(data);
    }
}