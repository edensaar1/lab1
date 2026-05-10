
/* in lab3 we need to separate and handle 4 cases: user succeeded to log in,
user gave invalid details/ gave invalid details and got blocked,
user is blocked for the moment
 */
public enum LoginResult {
    SUCCESS,
    INVALID_CREDENTIALS,
    USER_BLOCKED,
    USER_NOW_BLOCKED;
}
