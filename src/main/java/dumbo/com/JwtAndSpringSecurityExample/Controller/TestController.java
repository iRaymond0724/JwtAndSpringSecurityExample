package dumbo.com.JwtAndSpringSecurityExample.Controller;

import dumbo.com.JwtAndSpringSecurityExample.dto.validatorReq;
import dumbo.com.JwtAndSpringSecurityExample.utils.JwtUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



// 尚未添加 spring boot security
// https://www.tpisoftware.com/tpu/articleDetails/1606
@RestController()
public class TestController {

    @RequestMapping(value="/",method= RequestMethod.GET)
    public String Hello() {
        return "Hello Raymond~";
    }

    @RequestMapping(value = "/test/getJwt" , method = RequestMethod.GET)
    public String GetJwtFunc() {
        JwtUtil jwtUtil = new JwtUtil();
        return jwtUtil.addAuthentication();
    }

    @RequestMapping(value = "test/validator" , method = RequestMethod.GET)
    public String validator(@RequestBody validatorReq request) {
            System.out.println("request = " + request);
            JwtUtil jwtUtil = new JwtUtil();
            String userName = jwtUtil.validatorJwt(request.getJwt());
            return userName;
    }

}
