package com.android.wh_cinematv;

import com.google.gson.Gson;

public class ListaFilmes {
	String results;
	Gson gson = new Gson();
	Filme filme = gson.fromJson(results, Filme.class);

}
