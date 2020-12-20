package dumbo.com.JwtAndSpringSecurityExample.utils;

import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.springframework.stereotype.Component;

public class JwtUtil {
    static final long EXPIRATIONTIME = 432_000_000;     // 5天
    static final String TOKEN_PREFIX = "Bearer";        // Token前缀
    static final String HEADER_STRING = "Authorization";// 存放Token的Header Key
    static final Key key = MacProvider.generateKey();	//給定一組密鑰，用來解密以及加密使用

    // JWT產生方法
    public String addAuthentication() {

        // 生成JWT
        String jws = Jwts.builder()
                // 在Payload放入自定義的聲明方法如下
                //.claim("XXXXX",XXXXX)
                // 在Payload放入sub保留聲明
                .setSubject("小胖胖")
                // 在Payload放入exp保留聲明
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))

                .signWith(key).compact();
        // 把JWT傳回response
        return jws;
    }

    public String validatorJwt(String jwt) {
        if (!jwt.isEmpty()) {
            // 解析 Token
            try {
                Claims claims = Jwts.parser()
                        // 驗證
                        .setSigningKey(key)
                        // 去掉 Bearer
                        .parseClaimsJws(jwt)
                        .getBody();

                // 拿用户名
                String user = claims.getSubject();

               return user;
            } catch (JwtException ex) {
                System.out.println(ex);
            }

        }
        return "error";
    }
}
