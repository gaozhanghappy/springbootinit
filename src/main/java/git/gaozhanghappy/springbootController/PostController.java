package git.gaozhanghappy.springbootController;/**
 * Created by thinkpad on 2019/9/6.
 */

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author gaozhang
 * @ 2019/9/6 12:26
 */
@RestController
public class PostController {
    @GetMapping("/")
    public String getControler(){
        System.out.println("-----------------");
        return "success，你好";
    }
    @PostMapping("/post")
    @ResponseBody
    public String postController( JsonObject s){
        System.out.println(s);

        return "success";
    }
}
