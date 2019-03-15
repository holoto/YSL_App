package com.ai.ysl.getapi;


import android.util.Log;

import com.ai.ysl.jsonF.YslOne;
import com.ai.ysl.jsonF.YslRepos;
import com.ai.ysl.config.staticConfig;

import java.util.List;

import retrofit2.Call;


public class simpleApi {
	public static Call<List<YslOne>> getrepos(){
		YslApi.getYsl getYsl=RetrofitHelper.getInstance().buildRetrofit(staticConfig.getRepos_url()).create(YslApi.getYsl.class);
		Call<List<YslOne>> yslOneCall=getYsl.getysl();
		return yslOneCall;
		
	}
	
	public static Call<List<YslOne>> getysl(String url,String s){
		YslApi.getYsl getYsl=RetrofitHelper.getInstance().buildRetrofit(url).create(YslApi.getYsl.class);
		Call<List<YslOne>> yslOneCall=getYsl.getysl2(s);
		return yslOneCall;
		
	}
	
	
}
