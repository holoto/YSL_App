package com.ai.ysl.getapi;

import java.util.concurrent.TimeUnit;
import com.ai.ysl.config.staticConfig;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
	
	private RetrofitHelper() {
	
	}
	
	private OkHttpClient initOkHttpClient() {
		return new OkHttpClient.Builder()
				.connectTimeout(staticConfig.connectTimeout, TimeUnit.MILLISECONDS)
				.readTimeout(staticConfig.readTimeout, TimeUnit.MILLISECONDS)
				.writeTimeout(staticConfig.writeTimeout, TimeUnit.MILLISECONDS)
//                .addInterceptor(InterceptorUtils.HeaderInterceptor())
//                .addInterceptor(InterceptorUtils.LogInterceptor()) //添加日志拦截器
				.build();
	}
	
	public static RetrofitHelper getInstance() {
		return SingletonHolder.instance;
	}
	
	public Retrofit buildRetrofit(String baseUrl) {
		OkHttpClient okHttpClient = initOkHttpClient();
		return new Retrofit.Builder()
				.baseUrl(baseUrl)
				.addConverterFactory(GsonConverterFactory.create()) //添加Gson转换器
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) //添加RxJava转换器
				.client(okHttpClient)
				.build();
	}
	
	private static class SingletonHolder {
		private static RetrofitHelper instance = new RetrofitHelper();
	}
}
