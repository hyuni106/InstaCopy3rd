package kr.co.tjeit.instacopyproject3rd.util;

import android.content.Context;
import android.content.SharedPreferences;

import kr.co.tjeit.instacopyproject3rd.data.User;

/**
 * Created by the on 2017-09-06.
 */

public class ContextUtil {

    private static User loginUser = null;

    private static final String prefName = "instaCopyPref";

    private final static String loginId = "LOGIN_USER_ID";
    private final static String loginUserID = "LOGIN_USER_NICKNAME";
    private final static String loginUserName = "LOGIN_USER_NAME";
    private final static String loginUserProfileURL = "LOGIN_USER_PROFILE_URL";
    private final static String loginUserProfileComment = "LOGIN_USER_PROFILE_COMMENT";


    public static void setLoginUser(Context context, User inputUserData) {

        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);

        pref.edit().putInt(loginId, inputUserData.getId()).commit();
        pref.edit().putString(loginUserID, inputUserData.getUserId()).commit();
        pref.edit().putString(loginUserName, inputUserData.getName()).commit();
        pref.edit().putString(loginUserProfileURL, inputUserData.getProfileImgURL()).commit();
        pref.edit().putString(loginUserProfileComment, inputUserData.getProfileComment()).commit();
    }

    public static User getUserData(Context context) {

        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);

        if (pref.getInt(loginId, -1) != -1) {

            if (loginUser == null) {
                loginUser = new User();
            }

            loginUser.setId(pref.getInt(loginId, -1));
            loginUser.setUserId(pref.getString(loginUserID, ""));
            loginUser.setName(pref.getString(loginUserName, ""));
            loginUser.setProfileImgURL(pref.getString(loginUserProfileURL, ""));
            loginUser.setProfileComment(pref.getString(loginUserProfileComment, ""));

        }
        else {
            loginUser = null;
        }


        return loginUser;
    }

    public static void logoutProcess(Context context) {
//        로그아웃 처리
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        pref.edit().putInt(loginId, -1).commit();
        pref.edit().putString(loginUserID, "").commit();
        pref.edit().putString(loginUserName, "").commit();
        pref.edit().putString(loginUserProfileURL, "").commit();
        pref.edit().putString(loginUserProfileComment, "").commit();
    }


}
