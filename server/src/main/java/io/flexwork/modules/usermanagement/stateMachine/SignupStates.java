package io.flexwork.modules.usermanagement.stateMachine;

public enum SignupStates {
    NEW_SIGNUP_USER,
    SIGNING_UP,
    SIGNUP_VERIFICATION,
    SIGNUP_VERIFICATION_FAILED,
    SIGNUP_VERIFICATION_SUCCESS,
    SIGNUP_COMPLETED,
    ACTIVE
}
