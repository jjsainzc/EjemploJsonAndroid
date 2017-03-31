package com.example.ejemplojsonandroid;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.example.ejemplojsonandroid.datos.Asunto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class EjemploJson extends Activity {
	private List<Asunto> asuntos; 
	private TextView resultado;
	String json;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ejemplo_json);
		
		asuntos = new ArrayList<Asunto>();
		resultado = (TextView) findViewById(R.id.resultado);
		json = "";
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ejemplo_json, menu);
		return true;
	}
	
	public static String toPrettyFormatJson(String jsonString) 
    {
		JsonParser parser = new JsonParser();
        JsonElement json = parser.parse(jsonString);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String prettyJson = gson.toJson(json);

        return prettyJson;
    }
	
	
	public void serializar(View v) {
		Calendar calendar = Calendar.getInstance();
		Date hoy = new Date();
		
		if (asuntos != null) asuntos.clear();
		
		asuntos.add(new Asunto(hoy, "tema 1", 34));
		
		calendar.setTime(hoy);
		calendar.add(Calendar.DATE, 20);
		asuntos.add(new Asunto(calendar.getTime(), "tema 2", 34));
		
		json = new Gson().toJson(asuntos);
		Log.i("JSON", json);
		
		resultado.setText(toPrettyFormatJson(json));
	}
	
	@SuppressLint({ "NewApi", "SimpleDateFormat" })
	public void deserializar(View v) {
		StringBuilder sb = new StringBuilder();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		if (!asuntos.isEmpty()) {
			asuntos.clear();
		
			TypeToken<List<Asunto>> token = new TypeToken<List<Asunto>>() {};
			asuntos = new Gson().fromJson(json, token.getType());

			for (Asunto a : asuntos) {
				sb.append(a.getTema()).append(" ").append(sdf.format(a.getFecha())).append(" ").append(a.getTareas()).append("\n");
			}
		}
		else {
			sb.append("Serialize primero");
		}
        resultado.setText(sb.toString());
	}
	
	

}
