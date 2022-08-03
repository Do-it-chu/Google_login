package com.wil.config.google;

import com.wil.domain.user.Role;
import com.wil.domain.user.User;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
//구글 로그인 이후 가져온 사용자의 e-mail, name, profile picture, address등을 저장하는 DTO
public class OauthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey, name, email, picture;

    @Builder
    public OauthAttributes(Map<String, Object> attributes,
                           String nameAttributeKey,
                           String name, String email, String picture){
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    public static OauthAttributes of(String registrationId,
                                     String userNameAttributeName,
                                     Map<String, Object> attributes) {

        return OauthAttributes.builder().name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .picture((String) attributes.get("picture"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .role(Role.GUEST)
                .build();
    }
}
