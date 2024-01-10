package com.jayram.jobportal;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayAllEmployees extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_all_employees);

        // Obtenez la référence du TextView dans votre mise en page pour afficher les employés
        TextView employeeTextView = findViewById(R.id.employeeTextView);

        // Exemple : Obtenez la liste des employés à partir d'une source de données (peut être une base de données, une API, etc.)
        String[] employees = getEmployeeList();

        // Affichez la liste des employés dans le TextView
        displayEmployeeList(employeeTextView, employees);
    }

    // Exemple de méthode pour obtenir une liste d'employés (à remplacer par votre propre logique)
    private String[] getEmployeeList() {
        return new String[]{"Employee 1", "Employee 2", "Employee 3", "Employee 4"};
    }

    // Méthode pour afficher la liste des employés dans un TextView
    private void displayEmployeeList(TextView textView, String[] employees) {
        if (employees != null && employees.length > 0) {
            for (String employee : employees) {
                textView.append(employee + "\n");
            }
        } else {
            textView.setText("No employees found.");
        }
    }
}
