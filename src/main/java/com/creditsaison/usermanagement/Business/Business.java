package com.creditsaison.usermanagement.Business;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.apache.commons.codec.binary.Base64;
import java.nio.*;
import java.util.*;

@Entity
@Table(name = "business")
public class Business {

    @Id
    private String id;

    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    private String email;

    public Business()
    {
        this.id = generateUniqueId();
    }

//    public Business(String name, String email)
//    {
//        this.id = generateUniqueId();
//        this.name = name;
//        this.email = email;
//    }

    public String generateUniqueId()
    {
        return uuidToBase64(UUID.randomUUID().toString());
    }

    public String uuidToBase64(String str) {
        Base64 base64 = new Base64();
        UUID uuid = UUID.fromString(str);
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());
        return base64.encodeBase64URLSafeString(bb.array());
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
