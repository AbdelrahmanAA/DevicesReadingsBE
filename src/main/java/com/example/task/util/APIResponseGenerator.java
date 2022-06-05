package com.example.task.util;

import com.example.task.dto.common.APIResponse;
import com.example.task.enums.APIResponseResponseCode;
import com.example.task.enums.APIResponseResponseDesc;

public class APIResponseGenerator {

    public static APIResponse generateSuccessResponse(Object data) {
        APIResponse apiResponse = new APIResponse();
        apiResponse.setResponseData(data);
        APIResponseCodesGenerator.generateSuccessCode(apiResponse);
        return apiResponse;
    }

    public static APIResponse generateFailureResponse() {
        return generateFailureResponse(APIResponseResponseCode.FAILED,
                APIResponseResponseDesc.FAILED);
    }
    private static APIResponse generateFailureResponse(APIResponseResponseCode apiResponseResponseCode, APIResponseResponseDesc apiResponseResponseDesc) {
        APIResponse apiResponse = new APIResponse();
        APIResponseCodesGenerator.generateStatusCode(apiResponse, apiResponseResponseCode, apiResponseResponseDesc);
        return apiResponse;
    }


    public static APIResponse generateNoDataFoundFailureResponse() {
        return generateFailureResponse(APIResponseResponseCode.NO_DATA_FOUND,
                APIResponseResponseDesc.NO_DATA_FOUND);
    }


    public static APIResponse generateMissingRequiredFieldsFailureResponse() {
        return generateFailureResponse(APIResponseResponseCode.MISSING_REQUIRED_FIELDS,
                APIResponseResponseDesc.MISSING_REQUIRED_FIELDS);
    }

    public static APIResponse generateInvalidLengthFailureResponse() {
        return generateFailureResponse(APIResponseResponseCode.INVALID_LENGTH,
                APIResponseResponseDesc.INVALID_LENGTH);
    }


}
