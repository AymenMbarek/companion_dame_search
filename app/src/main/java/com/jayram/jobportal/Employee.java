package com.jayram.jobportal;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Employee extends AppCompatActivity {
    public EditText editename;
    public EditText editposition;
    public EditText editpcity;
    public TextView edob;
    public EditText editecountry;
    public DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        edob = findViewById(R.id.textView2);
        editename = findViewById(R.id.editText2);
        editposition = findViewById(R.id.editText4);
        editpcity = findViewById(R.id.editText8);
        editecountry = findViewById(R.id.editText9);

        Button search = findViewById(R.id.button9);
        Button enter = findViewById(R.id.button4);
        Button displayAllButton = findViewById(R.id.buttonDisplayAll);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ename = editename.getText().toString();
                String position = editposition.getText().toString();
                String dob = edob.getText().toString();
                String pcity = editpcity.getText().toString();
                String ecountry = editecountry.getText().toString();
                Map<String, Object> map = new HashMap<>();
                map.put("employee name", ename);
                map.put("position", position);
                map.put("preferred city", pcity);
                map.put("country", ecountry);
                map.put("DOB", dob);

                // Afficher un Toast pour indiquer que tout s'est bien déroulé
                Toast.makeText(Employee.this, "Employee added successfully!", Toast.LENGTH_SHORT).show();
            }
        });

        edob.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(
                        Employee.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month++;
                Log.d("Employee.this", "onDateset:mm/dd/yyyy" + month + "/" + dayOfMonth + "/" + year);
                String date = month + "/" + dayOfMonth + "/" + year;
                edob.setText(date);
            }
        };

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String position = editposition.getText().toString();
                Toast.makeText(Employee.this, "Display the details", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getBaseContext(), display.class);
                i.putExtra("pos", position);
                startActivity(i);
            }
        });

        displayAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ajoutez le code ici pour afficher tous les employés.
                // Vous pouvez lancer une nouvelle activité ou implémenter une fonction spécifique.
                Toast.makeText(Employee.this, "Displaying all employees", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Employee.this, DisplayAllEmployees.class);
                startActivity(intent);
            }
        });
    }

    public void search(View view) {
        // Cette méthode peut être supprimée ou implémentée selon vos besoins
    }

    public void enter(View view) {
        // Cette méthode peut être supprimée ou implémentée selon vos besoins
    }
}
