package com.ai.ysl;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.ai.ysl.Boxscheme.YslList;
import com.ai.ysl.getapi.simpleApi;
import com.ai.ysl.jsonF.YslOne;
import com.ai.ysl.config.staticConfig;
import com.ai.ysl.listclicklistener.OnListFragmentInteractionListener;
import com.bumptech.glide.Glide;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.cache.CacheFactory;
import com.shuyu.gsyvideoplayer.cache.ProxyCacheManager;
import com.shuyu.gsyvideoplayer.player.IjkPlayerManager;
import com.shuyu.gsyvideoplayer.player.PlayerFactory;
import com.shuyu.gsyvideoplayer.player.SystemPlayerManager;
import com.shuyu.gsyvideoplayer.utils.GSYVideoHelper;
import com.shuyu.gsyvideoplayer.utils.GSYVideoType;
import com.shuyu.gsyvideoplayer.utils.OrientationUtils;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import io.objectbox.BoxStore;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tv.danmaku.ijk.media.exo2.Exo2PlayerManager;
import tv.danmaku.ijk.media.exo2.ExoPlayerCacheManager;


public class FullscreenActivity extends AppCompatActivity implements OnListFragmentInteractionListener
{
	
	FragmentManager fragmentManagerx=getSupportFragmentManager();
	FragmentTransaction fragmentTransactionx=fragmentManagerx.beginTransaction();
	yslFragment yslFragmentx;
	
	StandardGSYVideoPlayer videoPlayer;
	OrientationUtils orientationUtils;
	GSYVideoHelper smallVideoHelper;
	GSYVideoHelper.GSYVideoHelperBuilder gsySmallVideoHelperBuilder;
	@Override
	public void onListFragmentInteraction(YslList item) {
		Log.e("", "onListFragmentInteraction: " );
		Log.e("", "onListFragmentInteraction: " +item.getName());
	}
	@Subscribe(threadMode = ThreadMode.MAIN)
	public void setaudio(YslList yslList){
		videoPlayer.setUp(yslList.getYsllink(),false,yslList.getName());
//		if (yslList.getPicboolean()){
//			ImageView imageView=new ImageView(this);
//			Glide.with(this).asBitmap().load(yslList.getPic()).into(imageView);
//					videoPlayer.setThumbImageView(imageView);
//		}
		videoPlayer.startPlayLogic();
		
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		EventBus.getDefault().register(this);
		Log.e("onCreate", "onCreate: "+BaseApp.getBaseApplicationinstance().getYslListBox().getAll().size() );
		if (BaseApp.getBaseApplicationinstance().getYslListBox().getAll().size()<50){
			BaseApp.getBaseApplicationinstance().getYslListBox().removeAll();
			fetchdata();
			Log.e("onCreate", "onCreate: "+BaseApp.getBaseApplicationinstance().getYslListBox().getAll().size() );
		}
		
		setContentView(R.layout.activity_fullscreen);
		
		if (savedInstanceState == null) {
			yslFragmentx=yslFragment.newInstance();
			fragmentTransactionx.replace(R.id.ysllist,yslFragmentx);
			
		}else {
			yslFragmentx=(yslFragment) fragmentManagerx.getFragment(savedInstanceState,"yslFragmentx");
		}
		fragmentTransactionx.commit();
		
		GSYVideoType.enableMediaCodec();
		GSYVideoType.enableMediaCodecTexture();
		
//		PlayerFactory.setPlayManager(Exo2PlayerManager.class);//EXO模式
//		PlayerFactory.setPlayManager(SystemPlayerManager.class);//系统模式
		PlayerFactory.setPlayManager(IjkPlayerManager.class);//ijk模式
		
//		CacheFactory.setCacheManager(ExoPlayerCacheManager.class);//exo缓存模式，支持m3u8，只支持exo
		CacheFactory.setCacheManager(ProxyCacheManager.class);//代理缓存模式，支持所有模式，不支持m3u8等
		videoPlayer =  (StandardGSYVideoPlayer)findViewById(R.id.video_player);
//		smallVideoHelper = new GSYVideoHelper(this);
//		gsySmallVideoHelperBuilder = new GSYVideoHelper.GSYVideoHelperBuilder();
		
		
		
		//PlayerFactory.setPlayManager(new Exo2PlayerManager());//EXO模式
//PlayerFactory.setPlayManager(new SystemPlayerManager());//系统模式

//PlayerFactory.setPlayManager(new IjkPlayerManager());//ijk模式
//		String source1 = "";
//		videoPlayer.setUp(source1, true, "播放");
		
		//增加封面
		
//		ImageView imageView = new ImageView(this);
//		imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//		imageView.setImageResource(R.mipmap.xxx1);
//		videoPlayer.setThumbImageView(imageView);
		//增加title
		videoPlayer.getTitleTextView().setVisibility(View.VISIBLE);
		//设置返回键
//		videoPlayer.getBackButton().setVisibility(View.VISIBLE);
		//设置旋转
//		orientationUtils = new OrientationUtils(this, videoPlayer);
		//设置全屏按键功能,这是使用的是选择屏幕，而不是全屏
//		videoPlayer.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				orientationUtils.resolveByClick();
//			}
//		});
		//是否可以滑动调整
//		videoPlayer.setIsTouchWiget(true);
		//设置返回按键功能
//		videoPlayer.getBackButton().setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				onBackPressed();
//			}
//		});
//		videoPlayer.startPlayLogic();


//		JodaTimeAndroid.init(this);
		
	
	}
	@Override
	protected void onPause() {
		super.onPause();
		videoPlayer.onVideoPause();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		videoPlayer.onVideoResume();
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		EventBus.getDefault().unregister(this);
		GSYVideoManager.releaseAllVideos();
		if (orientationUtils != null)
		{
			orientationUtils.releaseListener();}
	}
	
	@Override
	public void onBackPressed() {
		//先返回正常状态
		
		if (orientationUtils.getScreenType() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
			videoPlayer.getFullscreenButton().performClick();
			return;
		}
		//释放所有
		videoPlayer.setVideoAllCallBack(null);
		super.onBackPressed();
	}
	private void fetchdata(){
	
	
	simpleApi.getrepos().enqueue(new Callback<List<YslOne>>() {
		@Override
		public void onResponse(Call<List<YslOne>> call, Response<List<YslOne>> response) {
			Log.e("onResponse", "onResponse: "+response.code() );
			if (response.code()==200){
				Log.e("onResponse", "onResponse: "+response.body() );
				Log.e("onResponse", "onResponse: "+response.body().size() );
				Log.e("onResponse", "onResponse: "+response.body().get(2) );
				foreachdata(response.body());
			}
		}
		
		@Override
		public void onFailure(Call<List<YslOne>> call, Throwable t) {
			Log.e("onFailure", "onFailure: "+t.toString() );
			Log.e("onFailure", "onFailure: "+t.getMessage() );
			Log.e("onFailure", "onFailure: "+t.getStackTrace() );
		}
	});
	}
	private void foreachdata(List<YslOne> yslOnes){
//		writedb(yslOnes.get(10));
//		writedb(yslOnes.get(11));
		for (int i=1;i<62;i++){
			YslOne yslOne=yslOnes.get(i);
			writedb(yslOne);
		}
	}
	private void writedb(YslOne yslOne){
		final String name=yslOne.getName();
			simpleApi.getysl(staticConfig.getRepos_url(),name).enqueue(new Callback<List<YslOne>>() {
				@Override
				public void onResponse(Call<List<YslOne>> call, Response<List<YslOne>> response) {
					Log.e("onResponse", "onResponse: "+response.isSuccessful() );
					Log.e("onResponse", "onResponse: "+response.code() );
					Log.e("onResponse", "onResponse: "+response.body().size() );
					Log.e("onResponse", "onResponse: "+response.message() );
					Log.e("onResponse", "onResponse: "+response.body().toString() );
					Log.e("onResponse", "onResponse: "+response.body().get(0).getDownload_url() );
					Log.e("onResponse", "onResponse: "+response.errorBody() );
					if (response.code()==200){
						YslList yslList=new YslList();
						yslList.setName(name);
						yslList.setYsllink(response.body().get(0).getDownload_url());
						if (response.body().size()>1){
							
							yslList.setPicboolean(true);
							yslList.setPic(response.body().get(1).getDownload_url());
						}else {
							
							yslList.setPicboolean(false);
							yslList.setPic("0");
						
						
						}
						BaseApp.getBaseApplicationinstance().getYslListBox().put(yslList);
					}
				}
				
				@Override
				public void onFailure(Call<List<YslOne>> call, Throwable t) {
				
				}
			});
	}
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		
		// Trigger the initial hide() shortly after the activity has been
		// created, to briefly hint to the user that UI controls
		// are available.
	}

}
