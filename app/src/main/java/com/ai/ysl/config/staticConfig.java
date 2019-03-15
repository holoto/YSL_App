package com.ai.ysl.config;

public class staticConfig {
	
	public static String github_baseurl="https://api.github.com/";
	public static String repos_url="https://api.github.com/repos/rosuH/YSL/contents/";
	public   static long readTimeout=45000;
	public static long connectTimeout=45000;
	public static long writeTimeout=45000;
	public static long cachemaxsize=1024*1024*70;
	
	public static String getGithub_baseurl() {
		return github_baseurl;
	}
	
	public static String getRepos_url() {
		return repos_url;
	}
	
	public static void setGithub_baseurl(String github_baseurl) {
		staticConfig.github_baseurl = github_baseurl;
	}
	
	public static void setRepos_url(String repos_url) {
		staticConfig.repos_url = repos_url;
	}
	
	public static long getCachemaxsize() {
		return cachemaxsize;
	}
	
	public static long getConnectTimeout() {
		return connectTimeout;
	}
	
	public static long getReadTimeout() {
		return readTimeout;
	}
	
	public static long getWriteTimeout() {
		return writeTimeout;
	}
}
