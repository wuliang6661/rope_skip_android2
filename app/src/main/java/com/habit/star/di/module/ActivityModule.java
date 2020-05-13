package com.habit.star.di.module;

import android.app.Activity;

import com.habit.star.di.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sundongdong on 2017/2/24.
 */

@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityScope
    public Activity provideActivity() {
        return mActivity;
    }
}
