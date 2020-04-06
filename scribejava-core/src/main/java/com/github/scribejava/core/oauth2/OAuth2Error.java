package com.github.scribejava.core.oauth2;

import java.util.EnumSet;
import java.util.Set;

import static java.util.Collections.unmodifiableSet;

public enum OAuth2Error {
    /**
     * @see <a href="https://tools.ietf.org/html/rfc6749#section-4.1.2.1">RFC 6749, 4.1.2.1 Error Response</a>
     * @see <a href="https://tools.ietf.org/html/rfc6749#section-4.2.2.1">RFC 6749, 4.2.2.1 Error Response</a>
     * @see <a href="https://tools.ietf.org/html/rfc6749#section-5.2">RFC 6749, 5.2 Error Response</a>
     * @see <a href="https://tools.ietf.org/html/rfc6750#section-6.2">RFC 6750, 6.2. OAuth Extensions Error
     * Registration</a>
     */
    INVALID_REQUEST("invalid_request"),
    /**
     * @see <a href="https://tools.ietf.org/html/rfc6749#section-4.1.2.1">RFC 6749, 4.1.2.1 Error Response</a>
     * @see <a href="https://tools.ietf.org/html/rfc6749#section-4.2.2.1">RFC 6749, 4.2.2.1 Error Response</a>
     * @see <a href="https://tools.ietf.org/html/rfc6749#section-5.2">RFC 6749, 5.2 Error Response</a>
     */
    UNAUTHORIZED_CLIENT("unauthorized_client"),
    /**
     * @see <a href="https://tools.ietf.org/html/rfc6749#section-4.1.2.1">RFC 6749, 4.1.2.1 Error Response</a>
     * @see <a href="https://tools.ietf.org/html/rfc6749#section-4.2.2.1">RFC 6749, 4.2.2.1 Error Response</a>
     */
    ACCESS_DENIED("access_denied"),
    /**
     * @see <a href="https://tools.ietf.org/html/rfc6749#section-4.1.2.1">RFC 6749, 4.1.2.1 Error Response</a>
     * @see <a href="https://tools.ietf.org/html/rfc6749#section-4.2.2.1">RFC 6749, 4.2.2.1 Error Response</a>
     */
    UNSUPPORTED_RESPONSE_TYPE("unsupported_response_type"),
    /**
     * @see <a href="https://tools.ietf.org/html/rfc6749#section-4.1.2.1">RFC 6749, 4.1.2.1 Error Response</a>
     * @see <a href="https://tools.ietf.org/html/rfc6749#section-4.2.2.1">RFC 6749, 4.2.2.1 Error Response</a>
     * @see <a href="https://tools.ietf.org/html/rfc6749#section-5.2">RFC 6749, 5.2 Error Response</a>
     */
    INVALID_SCOPE("invalid_scope"),
    /**
     * @see <a href="https://tools.ietf.org/html/rfc6749#section-4.1.2.1">RFC 6749, 4.1.2.1 Error Response</a>
     * @see <a href="https://tools.ietf.org/html/rfc6749#section-4.2.2.1">RFC 6749, 4.2.2.1 Error Response</a>
     */
    SERVER_ERROR("server_error"),
    /**
     * @see <a href="https://tools.ietf.org/html/rfc6749#section-4.1.2.1">RFC 6749, 4.1.2.1 Error Response</a>
     * @see <a href="https://tools.ietf.org/html/rfc6749#section-4.2.2.1">RFC 6749, 4.2.2.1 Error Response</a>
     */
    TEMPORARILY_UNAVAILABLE("temporarily_unavailable"),
    /**
     * @see <a href="https://tools.ietf.org/html/rfc6749#section-5.2">RFC 6749, 5.2 Error Response</a>
     */
    INVALID_CLIENT("invalid_client"),
    /**
     * @see <a href="https://tools.ietf.org/html/rfc6749#section-5.2">RFC 6749, 5.2 Error Response</a>
     */
    INVALID_GRANT("invalid_grant"),
    /**
     * @see <a href="https://tools.ietf.org/html/rfc6749#section-5.2">RFC 6749, 5.2 Error Response</a>
     */
    UNSUPPORTED_GRANT_TYPE("unsupported_grant_type"),
    /**
     * @see <a href="https://tools.ietf.org/html/rfc6750#section-6.2">RFC 6750, 6.2. OAuth Extensions Error
     * Registration</a>
     */
    INVALID_TOKEN("invalid_token"),
    /**
     * @see <a href="https://tools.ietf.org/html/rfc6750#section-6.2">RFC 6750, 6.2. OAuth Extensions Error
     * Registration</a>
     */
    INSUFFICIENT_SCOPE("insufficient_scope"),
    /**
     * @see <a href="https://tools.ietf.org/html/rfc7009#section-4.1">RFC 7009, 4.1. OAuth Extensions Error
     * Registration</a>
     */
    UNSUPPORTED_TOKEN_TYPE("unsupported_token_type"),

    /**
     * @see <a href="https://tools.ietf.org/html/rfc8628#section-3.5">rfc8628#section-3.5</a>
     */
    AUTHORIZATION_PENDING("authorization_pending"),

    /**
     * @see <a href="https://tools.ietf.org/html/rfc8628#section-3.5">rfc8628#section-3.5</a>
     */
    SLOW_DOWN("slow_down"),

    /**
     * @see <a href="https://tools.ietf.org/html/rfc8628#section-3.5">rfc8628#section-3.5</a>
     */
    EXPIRED_TOKEN("expired_token"),
    ;

    /**
     * Unlike {@link #values()} which creates a new array every time, this always
     * returns the same immutable object.
     */
    public static final Set<OAuth2Error> VALUES = unmodifiableSet(EnumSet.allOf(OAuth2Error.class));

    private final String errorString;

    OAuth2Error(String errorString) {
        this.errorString = errorString;
    }

    public static OAuth2Error parseFrom(String errorString) {
        for (OAuth2Error error : VALUES) {
            if (error.errorString.equals(errorString)) {
                return error;
            }
        }
        throw new IllegalArgumentException("there is no knowlege about '" + errorString + "' Error");
    }

    public String getErrorString() {
        return errorString;
    }
}
