/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.infstory.notification;

import android.app.Activity;
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import org.json.JSONObject;
import org.json.JSONException;

import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class MainTest {
    // support library fragments
    private FragmentActivity fragmentActivity;
    private android.support.v4.app.Fragment supportFragment;

    // native fragments
    private Activity activity;
    private Fragment fragment;

    @Mock
    private JSONObject json;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        supportFragment = new android.support.v4.app.Fragment();
        fragmentActivity = Robolectric.buildActivity(FragmentActivity.class).create().get();
        fragmentActivity.getSupportFragmentManager().beginTransaction().add(supportFragment, null).commit();

        fragment = new Fragment();
        activity = Robolectric.buildActivity(Activity.class).create().get();
        activity.getFragmentManager().beginTransaction().add(fragment, null).commit();
    }

    @Test
    public void itToString() {
        try {
            json.put("name", "android");
            verify(json).put("name", "android");
        } catch (JSONException e) {
        }
    }
}