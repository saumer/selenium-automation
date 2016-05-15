package com.seleniumTesting.utilities;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jerem on 5/14/2016.
 */
public class JsonParsingUtils {

    public static List<UserAddress> getAndParseUserAddress(String userAddressPath)throws java.io.IOException {
        String fileString = new String(Files.readAllBytes(Paths.get(userAddressPath)), StandardCharsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();
        List<UserAddress> myObjects = Arrays.asList(mapper.readValue(fileString, UserAddress[].class));
      return myObjects;
    }
}
