package org.example;

import okhttp3.*;

import java.io.File;
import java.io.IOException;

public class TodoClient {

    public void request() {

        String serverUrl = "https://example.com/upload";
        File videoFile = new File("path/to/video.mp4");

        OkHttpClient client = new OkHttpClient();

        MediaType MEDIA_TYPE_MP4 = MediaType.get("video/mp4");

        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file", videoFile.getName(), RequestBody.create(videoFile, MEDIA_TYPE_MP4))
                .addFormDataPart("description", "Test mp4 upload")
                .build();

        Request request = new Request.Builder()
                .url(serverUrl)
                .post(requestBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Запрос не успешен: " +
                        response.code() + " " + response.message());
            }
            System.out.println("Ответ сервера: " + response.body().string());
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
