package io.gatm.commons

/**
 * Enum class to hold all custom error codes for api response.
 *
 * @author Minhaj
 */
public enum ApiResponseCodeEnum {

    ERROR_CODE("error.code", 1000),

    private final String key
    private final int code

    /**
     * Private constructor to populate object with key and code.
     *
     * @param key
     * @param code
     */
    private ApiResponseCodeEnum(String key, int code) {
        this.key = key
        this.code = code
    }

    /**
     * @return the key of this response enum.
     */
    public String key() {
        return this.key;
    }

    /**
     * @return error code of response
     */
    public int code() {
        return this.code
    }

    /**
     * Find the {@link ApiResponseCodeEnum} with given message key
     *
     * @param messageKey messages.properties key value
     * @return {@link ApiResponseCodeEnum}
     *
     * @throws IllegalArgumentException in case message key not found in enum
     */
    public static ApiResponseCodeEnum findKey(String messageKey) throws IllegalArgumentException{
        for (ApiResponseCodeEnum responseEnum: values()) {
            if (responseEnum.key == messageKey) {
                return responseEnum;
            }
        }

        throw new IllegalArgumentException("No matching constant for [" + messageKey + "]");
    }
}
