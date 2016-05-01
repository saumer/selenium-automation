package com.seleniumTesting.selenium;

/**
 * Created by Jeremy on 5/1/2016.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
//import java.io.InputStreamReader

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

public class AwsUtilitesS3 {
    public static String getStringFromS3(String bucketName, String key) {
        AmazonS3 s3Client = new AmazonS3Client(new ProfileCredentialsProvider());
        S3Object s3object = s3Client.getObject(new GetObjectRequest(
                bucketName, key));
        System.out.println("Content-Type: " +
                s3object.getObjectMetadata().getContentType());
        try {
            readTextInputStream(s3object.getObjectContent());
        } catch(IOException e) {

        }

        return "Content-Type: " +
                s3object.getObjectMetadata().getContentType();
    }

    private static void displayTextInputStream(InputStream input)
            throws IOException {
        // Read one text line at a time and display.
        BufferedReader reader = new BufferedReader(new
                InputStreamReader(input));
        while (true) {
            String line = reader.readLine();
            if (line == null) break;

            System.out.println("    " + line);
        }
        System.out.println();
    }

    private static void readTextInputStream(InputStream input)
            throws IOException {
        // Read one text line at a time and display.
        BufferedReader reader = new BufferedReader(new
                InputStreamReader(input));
        String fileContent = "";
        while (true) {
            String line = reader.readLine();
            if (line == null) break;
            fileContent = fileContent + line;
//            System.out.println("    " + line);

        }
        System.out.print(fileContent);

        System.out.println();
    }
}

