package com.ai.ysl.getapi;

import com.ai.ysl.jsonF.YslOne;
import com.ai.ysl.jsonF.YslRepos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Url;

public class YslApi {
	public interface getYslContent{
		@Headers( "Content-Type: application/json" )
		@GET("repos/{owner}/{repo}/contents/")
		Call<YslRepos> getrepos(@Path("owner") String owner,@Path("repo") String repository);


	}
	public interface getYsl{
//		@Headers( {"Content-Type: application/json","Authorization: Token "+"61307b7d9c007892675e31117e2e67d43cb8523e","User-Agent: holoto"} )
@Headers( {"Content-Type: application/json",
		"User-Agent: Paw/3.1.7 (Macintosh; OS X/10.14.0) GCDHTTPRequest",
} )
		@GET("?access_token=61307b7d9c007892675e31117e2e67d43cb8523e")
		Call<List<YslOne>> getysl();
		
		@Headers( {"Content-Type: application/json",
				"User-Agent: Paw/3.1.7 (Macintosh; OS X/10.14.0) GCDHTTPRequest",
		} )
		@GET("{yslname}?access_token=61307b7d9c007892675e31117e2e67d43cb8523e")
		Call<List<YslOne>> getysl2(@Path("yslname") String yslname);
	}

}
	
