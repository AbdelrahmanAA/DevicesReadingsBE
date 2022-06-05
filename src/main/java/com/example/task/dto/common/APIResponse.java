package com.example.task.dto.common;

import com.example.task.enums.APIResponseResponseCode;
import com.example.task.enums.APIResponseResponseDesc;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class APIResponse {
    private String statusCode;
    private String statusMessage;
    private Object responseData;
    private String errorFullTrace;
    private String errorMessage;

    public APIResponse(){}

    public APIResponse(String statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(APIResponseResponseCode statusCode) {
        this.statusCode = statusCode.getCode();
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(APIResponseResponseDesc statusMessage) {
        this.statusMessage = statusMessage.getCode();
    }
}
