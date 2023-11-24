package com.spal.self.fbservice.services;

import com.restfb.*;
import com.restfb.types.FacebookType;
import com.restfb.types.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import java.io.File;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FbLoginService {

    @Autowired
    Environment environment;
    public FacebookClient initialiseClient() {
        FacebookClient facebookClient = new DefaultFacebookClient(environment.getProperty("facebook.accessToken"), Version.VERSION_18_0);

        User me = facebookClient.fetchObject("me", User.class);
        System.out.println(me);
        System.out.println(me.getFirstName() + " " + me.getLastName());

        //facebookClient.publish()
        return facebookClient;
    }

    public void publishContentNow(String message, List<byte[]> images, List<byte[]> videos) {

        FacebookClient facebookClient = initialiseClient();

        FacebookType response = facebookClient.publish("me/feed", FacebookType.class,
                Parameter.with("message", "Hello, Facebook!"));
        System.out.println(response);
        /*List<BinaryAttachment> imageAttachments = images
                .parallelStream()
                .map(image -> BinaryAttachment.with("", image))
                .collect(Collectors.toList());

        List<BinaryAttachment> videoAttachments = videos
                .parallelStream()
                .map(video -> BinaryAttachment.with("", video))
                .collect(Collectors.toList());

        FacebookType facebookType = facebookClient.publish("me/feed", FacebookType.class,
                Parameter.with("message", message),
                Parameter.with("attached_files", imageAttachments),
                Parameter.with("attached_files", videoAttachments));*/
    }

}
