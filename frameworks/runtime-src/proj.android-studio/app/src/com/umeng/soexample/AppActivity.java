/****************************************************************************
Copyright (c) 2015 Chukong Technologies Inc.
 
http://www.cocos2d-x.org

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
****************************************************************************/
package com.umeng.soexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.umeng.analytics.UMGameAnalytics;
import com.umeng.analytics.game.UMGameAgent;
import com.umeng.message.PushAgent;
import com.umeng.push.CCUMPushController;
import com.umeng.social.CCUMSocialController;
import org.cocos2dx.lib.Cocos2dxActivity;

public class AppActivity extends Cocos2dxActivity {
    private Activity mActivity = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("cocos2d-x","AppActivity onCreate");
        mActivity = this;
        CCUMSocialController.initSocialSDK(mActivity);
        CCUMPushController.initPushSDK(mActivity);
        UMGameAnalytics.init(this);
        PushAgent.getInstance(this).onAppStart();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        // 授权回调
        CCUMSocialController.onActivityResult(requestCode, resultCode, data);

        super.onActivityResult(requestCode, resultCode, data);
    }
    @Override
    public void onResume() {
        super.onResume();
        // 集成游戏统计分析,初始化 Session
        UMGameAgent.onResume(this);
    }
    @Override
    public void onPause() {
        super.onPause();
        // //集成游戏统计分析, 结束 Session
        UMGameAgent.onPause(this);
    }
}
