package com.chat_1vs1_v1.common;

import com.chat_1vs1_v1.user.entity.User;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class DataResponse {
    private static HttpStatus statusValue = null;

    @Getter
    private static class Data {
        private int status = statusValue.value();
        private String message;
        private Object data;

        public Data(int status, String message, Object data) {
            this.status = status;
            this.message = message;
            this.data = data;
        }

        public Data(Object data, int status) {
            this.data = data;
            this.status = status;
        }

        public Data(Object data, String message) {
            this.data = data;
            this.message = message;
        }

    }
    public static ResponseEntity<Object> setDataSearchSuccess(Object body, String message) {
        statusValue = HttpStatus.OK;
        return new ResponseEntity(new Data(body, message), HttpStatus.OK);
    }
}
