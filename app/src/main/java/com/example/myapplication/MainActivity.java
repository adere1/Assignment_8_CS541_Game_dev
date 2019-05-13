package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    //JSONParser jParser = new JSONParser();
    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
    String url = "http://192.168.1.179/selectdata.php";
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private String[] myDataset;

    private List<Person> persons;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        StrictMode.setThreadPolicy(policy);


        final Button b = findViewById(R.id.button);
        final Button b1 = findViewById(R.id.save);
        final TextView  t1 = findViewById(R.id.textView2);
        final TextView t2 = findViewById(R.id.textView3);
        final RelativeLayout r = findViewById(R.id.addlayout);
        final EditText e3 = findViewById(R.id.cname);
        final EditText e4 = findViewById(R.id.position);
        final EditText e5 = findViewById(R.id.applicationdate);
        final EditText e6 = findViewById(R.id.followupdate);

        //final EditText e1 = findViewById(R.id.edit);


      /*  recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        myDataset = new String [2];
        myDataset[0] = "abc";
        myDataset[1] = "pqr";
        mAdapter = new MyAdapter(myDataset);
        recyclerView.setAdapter(mAdapter);*/


        //super.onCreate(savedInstanceState);




        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                URL currentUrl = null;
                try {
                    currentUrl = new URL(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();

                }
                HttpURLConnection urlConnection = null;
                InputStream in;
                BufferedReader streamReader = null;
                StringBuilder responseStrBuilder = new StringBuilder();
                String inputStr;
                try {
                    urlConnection = (HttpURLConnection) currentUrl.openConnection();
                    String data = URLEncoder.encode("cname", "UTF-8")
                            + "=" + URLEncoder.encode(e3.getText().toString(), "UTF-8");

                    data += "&" + URLEncoder.encode("position", "UTF-8") + "="
                            + URLEncoder.encode(e4.getText().toString(), "UTF-8");

                    data += "&" + URLEncoder.encode("applicationdate", "UTF-8") + "="
                            + URLEncoder.encode(e5.getText().toString(), "UTF-8");

                    data += "&" + URLEncoder.encode("followupdate", "UTF-8") + "="
                            + URLEncoder.encode(e6.getText().toString(), "UTF-8");

                    data += "&" + URLEncoder.encode("getreq", "UTF-8") + "="
                            + URLEncoder.encode("false", "UTF-8");

                    urlConnection.setDoOutput(true);

                    OutputStreamWriter wr = new OutputStreamWriter(urlConnection.getOutputStream());
                    wr.write(data);
                    wr.flush();
                }catch(Exception e){
                    Log.e("log_tag", "Error in http connection "+e.toString());

                }

            }
        });



        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1.setVisibility(View.INVISIBLE);
                t2.setVisibility(View.INVISIBLE);
                b.setVisibility(View.INVISIBLE);
                r.setVisibility(View.VISIBLE);

               // e1.setVisibility(View.INVISIBLE);




                URL currentUrl = null;
                try {
                    currentUrl = new URL(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();

                }
                HttpURLConnection urlConnection = null;
                InputStream in;
                BufferedReader streamReader = null;
                StringBuilder responseStrBuilder = new StringBuilder();
                String inputStr;
                try {

                    //String name = editText.getText().toString();
                    urlConnection = (HttpURLConnection) currentUrl.openConnection();
                    String data = URLEncoder.encode("name", "UTF-8")
                            + "=" + URLEncoder.encode("Aditya", "UTF-8");

                    data += "&" + URLEncoder.encode("getreq", "UTF-8") + "="
                            + URLEncoder.encode("true", "UTF-8");
                    urlConnection.setDoOutput(true);

                    OutputStreamWriter wr = new OutputStreamWriter(urlConnection.getOutputStream());
                    Log.d("-----","-----------------------------------------");
                    wr.write(data);
                    wr.flush();
                    in = new BufferedInputStream(urlConnection.getInputStream());
                    streamReader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
                    while ((inputStr = streamReader.readLine()) != null) {
                        responseStrBuilder.append(inputStr);
                    }
                    //editText2.setText(responseStrBuilder.toString().split(name)[1]);
                    try {
                        int length = responseStrBuilder.toString().length();
                        String abc = responseStrBuilder.toString().substring("Aditya".length() + 1, length);
                        JSONObject no = new JSONObject(abc);

                        //Log.d("--------------",responseStrBuilder.toString()+"");


                        //editText2.setText(no1.getString("notedata"));
                        //Log.i("MyData", no1.getString("job_description"));
                        //Log.d("-----------------------","------------------------------");

                        /*for(int i =0;i<no.length();i++) {
                            Log.i("Dtaa", no.getString(String.valueOf(i)));
                        }*/
                        //Log.d(name,responseStrBuilder.toString());
                        //Log.d("-----------------------","------------------------------");
                        persons = new ArrayList<>();
                       for(int i=0;i<4;i++) {
                           JSONObject no1 = new JSONObject(no.getString(String.valueOf(i)));

                           persons.add(new Person(no1.getString("cname"), no1.getString("job_description"), R.drawable.job, no1.getString("status"), no1.getString("app_date"),no1.getString("follow_up")));
                       }
                        /*setContentView(R.layout.recyclerview_activity);
                        rv=(RecyclerView)findViewById(R.id.rv);
                        LinearLayoutManager llm = new LinearLayoutManager(MainActivity.this);
                        rv.setLayoutManager(llm);
                        rv.setHasFixedSize(true);
                        */
                        //initializeData();


                        //persons.add(new Person("Lavery Maiss", "25 years old", R.drawable.del));
                        //persons.add(new Person("Lillie Watts", "35 years old", R.drawable.liquid));


                        initializeAdapter();
                    }catch (Exception e){
                        //editText2.setText("No Data Present");
                        //button1.setVisibility(View.INVISIBLE);
                        Log.d("-----------------------","------------------------------");
                    }


                }catch(Exception e){
                    Log.e("log_tag", "Error in http connection "+e.toString());
                    //Toast.makeText(getApplicationContext(), "Connection fail", Toast.LENGTH_SHORT).show();
                }






            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


   /* private void initializeData(){
        persons = new ArrayList<>();
        persons.add(new Person("Emma Wilson", "23 years old", R.drawable.bqe));
        persons.add(new Person("Lavery Maiss", "25 years old", R.drawable.del));
        persons.add(new Person("Lillie Watts", "35 years old", R.drawable.liquid));
    }*/

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(persons);
        rv.setAdapter(adapter);
    }
}




