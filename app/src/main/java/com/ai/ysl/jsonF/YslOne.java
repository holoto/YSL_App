package com.ai.ysl.jsonF;

public class YslOne {
	
	/**
	 * name : American Coots.mp3
	 * path : American Coots/American Coots.mp3
	 * sha : 36769ad5f0ecd20bd8acd72fba4092e27f256855
	 * size : 16933108
	 * url : https://api.github.com/repos/rosuH/YSL/contents/American%20Coots/American%20Coots.mp3?ref=master
	 * html_url : https://github.com/rosuH/YSL/blob/master/American%20Coots/American%20Coots.mp3
	 * git_url : https://api.github.com/repos/rosuH/YSL/git/blobs/36769ad5f0ecd20bd8acd72fba4092e27f256855
	 * download_url : https://raw.githubusercontent.com/rosuH/YSL/master/American%20Coots/American%20Coots.mp3
	 * type : file
	 * _links : {"self":"https://api.github.com/repos/rosuH/YSL/contents/American%20Coots/American%20Coots.mp3?ref=master","git":"https://api.github.com/repos/rosuH/YSL/git/blobs/36769ad5f0ecd20bd8acd72fba4092e27f256855","html":"https://github.com/rosuH/YSL/blob/master/American%20Coots/American%20Coots.mp3"}
	 */
	
	private String name;
	private String path;
	private String sha;
	private int size;
	private String url;
	private String html_url;
	private String git_url;
	private String download_url;
	private String type;
	private LinksBean _links;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public String getSha() {
		return sha;
	}
	
	public void setSha(String sha) {
		this.sha = sha;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getHtml_url() {
		return html_url;
	}
	
	public void setHtml_url(String html_url) {
		this.html_url = html_url;
	}
	
	public String getGit_url() {
		return git_url;
	}
	
	public void setGit_url(String git_url) {
		this.git_url = git_url;
	}
	
	public String getDownload_url() {
		return download_url;
	}
	
	public void setDownload_url(String download_url) {
		this.download_url = download_url;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public LinksBean get_links() {
		return _links;
	}
	
	public void set_links(LinksBean _links) {
		this._links = _links;
	}
	
	public static class LinksBean {
		/**
		 * self : https://api.github.com/repos/rosuH/YSL/contents/American%20Coots/American%20Coots.mp3?ref=master
		 * git : https://api.github.com/repos/rosuH/YSL/git/blobs/36769ad5f0ecd20bd8acd72fba4092e27f256855
		 * html : https://github.com/rosuH/YSL/blob/master/American%20Coots/American%20Coots.mp3
		 */
		
		private String self;
		private String git;
		private String html;
		
		public String getSelf() {
			return self;
		}
		
		public void setSelf(String self) {
			this.self = self;
		}
		
		public String getGit() {
			return git;
		}
		
		public void setGit(String git) {
			this.git = git;
		}
		
		public String getHtml() {
			return html;
		}
		
		public void setHtml(String html) {
			this.html = html;
		}
	}
}
