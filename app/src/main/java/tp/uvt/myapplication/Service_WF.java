package tp.uvt.myapplication;


import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Service_WF extends AppCompatActivity {
    EditText editDate;
    int year, month, day;
    EditText etNom, etPrenom, etCin, etRevenu, etEmail;
    Button btnUpdate;
    CitoyenAPIInterface citoyenAPIInterface;
    private static final String TAG = "Service_WF";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service__wf);
        editDate = findViewById(R.id.editDate);

        etNom = findViewById(R.id.et_nom);
        etNom.setKeyListener(null);
        etPrenom = findViewById(R.id.et_prenom);
        etPrenom.setKeyListener(null);
        etCin = findViewById(R.id.et_cin);
        etCin.setKeyListener(null);
        etEmail = findViewById(R.id.et_adresse);
        etRevenu = findViewById(R.id.et_revenu);
        btnUpdate = findViewById(R.id.btnmodif);

        citoyenAPIInterface = APIClient.getClient().create(CitoyenAPIInterface.class);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Citoyen citoyen = new Citoyen();
                citoyen.setAdressmail(etEmail.getText().toString());
                citoyen.setCin(etCin.getText().toString());
                citoyen.setDatenaissance(editDate.getText().toString());
                citoyen.setNom(etNom.getText().toString());
                citoyen.setPrenom(etPrenom.getText().toString());
                citoyen.setRevenuannuel(etRevenu.getText().toString());


                Call<Citoyen> call = citoyenAPIInterface.update(citoyen);
                call.enqueue(new Callback<Citoyen>() {
                    @Override
                    public void onResponse(Call<Citoyen> call, Response<Citoyen> response) {
                        Log.d(TAG, "onResponse: " + response.body().toString());
                        if (response.body()!=null){
                            Toast.makeText(Service_WF.this, " Modifier avec succues ", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Citoyen> call, Throwable t) {
                     //   Log.e(TAG, "onFailure: ", "" + t.getMessage());

                    }
                });

            }
        });

        Call<Citoyen> call = citoyenAPIInterface.getCitoyenbyId();
        call.enqueue(new Callback<Citoyen>() {
            @Override
            public void onResponse(Call<Citoyen> call, Response<Citoyen> response) {
                Citoyen citoyen = response.body();
                if (citoyen != null) {
                    etNom.setText(citoyen.getNom());
                    etPrenom.setText(citoyen.getPrenom());
                    etCin.setText(citoyen.getCin());
                    etRevenu.setText(citoyen.getRevenuannuel());
                    etEmail.setText(citoyen.getAdressmail());
                    editDate.setText(citoyen.getDatenaissance());
                }
            }

            @Override
            public void onFailure(Call<Citoyen> call, Throwable t) {

            }
        });


        Calendar calendar = Calendar.getInstance();
        // year = calendar.get(Calendar.YEAR);
        //month = calendar.get(Calendar.MONTH) + 1;
        //   day = calendar.get(Calendar.DAY_OF_MONTH);
        //  editDate.setText(year + "-" + month + "-" + day);
        editDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog();
            }

            private void showDateDialog() {
                DatePickerDialog.OnDateSetListener temp = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        editDate.setText(year + "-" + month + "-" + dayOfMonth);
                    }
                };

                DatePickerDialog datePickerDialog = new DatePickerDialog(Service_WF.this, temp, year, month, day);
                datePickerDialog.show();
            }


        });
    }
}
