package com.example.task.util;

import com.example.task.dto.common.APIResponse;
import com.example.task.enums.APIResponseResponseCode;
import com.example.task.enums.APIResponseResponseDesc;

public class APIResponseCodesGenerator {
    public static void generateSuccessCode(APIResponse apiResponse) {
        apiResponse.setStatusCode(APIResponseResponseCode.SUCCESS);
        apiResponse.setStatusMessage(APIResponseResponseDesc.SUCCESS);
    }

    public static void generateStatusCode(APIResponse apiResponse, APIResponseResponseCode apiResponseResponseCode, APIResponseResponseDesc apiResponseResponseDesc) {
        apiResponse.setStatusCode(apiResponseResponseCode);
        apiResponse.setStatusMessage(apiResponseResponseDesc);
    }

}
