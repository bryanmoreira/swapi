package com.bryan.swapi;
import android.os.AsyncTask;
import android.widget.TextView;
import org.json.JSONException;
import org.json.JSONObject;

public class DataGetter extends AsyncTask<String,Void,String>{
    private TextView titulo;
    private TextView diretor;

    public DataGetter (TextView titulo, TextView diretor){
        this.titulo = titulo;
        this.diretor = diretor;
    }

    @Override
    protected void onProgressUpdate(Void... values){
        super.onProgressUpdate(values);
    }

    @Override
    protected String doInBackground(String... strings){
        String url = strings[0];
        String result = NetworkToolkit.doGet(url);

        return result;
    }

    @Override
    protected void onPostExecute(String s){
        try{
            JSONObject jsonResponse = new JSONObject(s);
            JSONObject dataResponse = jsonResponse.getJSONObject("data");

            String title = dataResponse.getString("title");
            String director = dataResponse.getString("director");

            titulo.setText(title);
            diretor.setText(director);

        } catch (JSONException e){
            this.titulo.setText("Erro JSON");
            this.diretor.setText("Erro JSON");
        }
    }
}
