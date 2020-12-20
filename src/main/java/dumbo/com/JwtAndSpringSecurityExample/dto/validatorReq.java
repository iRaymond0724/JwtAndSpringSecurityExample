package dumbo.com.JwtAndSpringSecurityExample.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;

@Getter
public class validatorReq {
    String jwt;
}
