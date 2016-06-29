package text;

import com.wwkj.dao.UserinfoDaoImpl;
import com.wwkj.utils.CommonUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by su on 16-6-4.
 */
public class test1 {

    @Test
    public void test() {
//        private int id;
//        private String name;
//        private String address_area;
//        private String address_detail;

//        String stt = "{
//                "id":123,
//                "title":"活动1",
//                "pic":"http://localhost/1.png"
//    }";

        UserinfoDaoImpl impl = new UserinfoDaoImpl();
//        System.out.println("========================");

        Map<String, Object> map = impl.UserId("sss", "1231");
//        List aa = new ArrayList<>();
//        aa.add("xxxx");
//        aa.add("ccc");
//        aa.add("ccc");
//        aa.add("ccc");
//        aa.add("ccc");

        System.out.println(map.toString());
        String jsonString = JSONObject.fromObject(map).toString();
//        String jsonString = JSONArray.fromObject(aa).toString();
        System.out.println(""+jsonString.toString());
    }
}
