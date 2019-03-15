package com.ai.ysl;

import android.app.Application;
import android.content.Context;

import com.ai.ysl.Boxscheme.MyObjectBox;
import com.ai.ysl.Boxscheme.YslList;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;


import io.objectbox.Box;
import io.objectbox.BoxStore;
import io.objectbox.android.AndroidObjectBrowser;


public class BaseApp extends Application
{
	private static BaseApp baseApplicationinstance;
	private  Context contextinstance;
	private static RefWatcher refWatcher;
	public static final String TAG="ysldata";
	public static final boolean EXTRNAL_DIR=false;
	private BoxStore boxStore;
	private  Box<YslList> yslListBox;
	private final String LOG_TAG = BaseApp.class.getSimpleName();
	
	@Override
	public void onCreate() {
		super.onCreate();
		contextinstance=this;
		baseApplicationinstance=this;
//		this.initLeakCanary();
//		JodaTimeAndroid.init(this);
		
		// 初始化工具类
//		RxTool.init(this);
		
		initObjectbox();
		yslListBox=getBoxStore().boxFor(YslList.class);
		if (BuildConfig.DEBUG){
			
			new AndroidObjectBrowser(boxStore).start(this);
		}
		
		
	}
	
	public Box<YslList> getYslListBox() {
		return yslListBox;
	}
	
	private void initObjectbox(){
		boxStore= MyObjectBox.builder().androidContext(contextinstance).build();
	}
	
	public BoxStore getBoxStore() {
		return boxStore;
	}
	
	public static RefWatcher getRefWatcher(){
		return refWatcher;
	}
	private void initLeakCanary(){
		if (LeakCanary.isInAnalyzerProcess(this)) {//1
			// This process is dedicated to LeakCanary for heap analysis.
			// You should not init your app in this process.
			return;
		}
//		refWatcher=LeakCanary.install(this);
	}
	
	public static BaseApp getBaseApplicationinstance() {
		if (baseApplicationinstance==null){
			baseApplicationinstance=new BaseApp();
		}
		return baseApplicationinstance;
	}
	
	public  Context getContext(){
		
		return contextinstance;
	}
	
}
