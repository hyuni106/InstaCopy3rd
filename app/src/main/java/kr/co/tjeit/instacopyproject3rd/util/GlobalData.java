package kr.co.tjeit.instacopyproject3rd.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import kr.co.tjeit.instacopyproject3rd.data.Post;
import kr.co.tjeit.instacopyproject3rd.data.Reply;
import kr.co.tjeit.instacopyproject3rd.data.User;

/**
 * Created by the on 2017-09-06.
 */

public class GlobalData {

//    실제 사용은 서버에서 받아올 예정. 아래에 기록된 건 테스트용 더미 데이터입니다.

    public static List<User> userList = new ArrayList<>();
    public static List<Post> postingList = new ArrayList<>();

    public static void initGlobalData() {
        userList.clear();
        userList.add(new User(1, "sh", "수현", "tempURL", "조장"));
        userList.add(new User(2, "hc", "현철", "tempURL", "보스"));
        userList.add(new User(3, "dy", "동윤", "tempURL", "중간보스"));
        userList.add(new User(4, "sy", "석영", "tempURL", "부하"));
    }


}
