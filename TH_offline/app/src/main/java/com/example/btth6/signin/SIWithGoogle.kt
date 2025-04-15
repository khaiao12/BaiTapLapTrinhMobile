package com.example.btth6.signin

private fun signInWithGoogle(onSuccess: () -> Unit) {
    val googleSignInClient = Goog.getClient(
        context,
        GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("YOUR_WEB_CLIENT_ID") // Thay YOUR_WEB_CLIENT_ID bằng ID của bạn
            .requestEmail()
            .build()
    )

    val signInIntent = googleSignInClient.signInIntent
    startActivityForResult(signInIntent, RC_SIGN_IN) // RC_SIGN_IN là mã yêu cầu

    // Xử lý kết quả trong onActivityResult
    // ...
}
