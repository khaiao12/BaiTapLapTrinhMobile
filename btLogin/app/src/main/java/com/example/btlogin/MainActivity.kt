package com.example.btlogin

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.btlogin.View.HomeScreen
import com.example.btlogin.View.ProfileScreen
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.example.btlogin.viewModel.*

class MainActivity : ComponentActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var authViewModel: AuthViewModel
    private val signIn: ActivityResultLauncher<android.content.Intent> =
        registerForActivityResult(FirebaseAuthUIActivityResultContract(), this::onSignInResult)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = Firebase.auth
        authViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)

        setContent {
            MyApp(authViewModel = authViewModel, onSignInClick = {
                launchSignInFlow()
            })
        }
    }

    override fun onStart() {
        super.onStart()
        if (auth.currentUser != null) {
            // Nếu đã đăng nhập, chuyển sang ProfileScreen
            authViewModel.setUserLoggedIn(true)
            // Giả sử lấy dữ liệu profile
            val profileData = UserProfileData(
                name = auth.currentUser?.displayName ?: "Unknown",
                email = auth.currentUser?.email ?: "Unknown",
                dateOfBirth = "N/A" // Thay bằng dữ liệu thực tế
            )
            authViewModel.setUserProfileData(profileData)
            authViewModel.setNavigateToProfile(true)
        }
    }

    private fun launchSignInFlow() {
        val signInIntent = AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(
                listOf(
                    AuthUI.IdpConfig.EmailBuilder().build(),
                    AuthUI.IdpConfig.GoogleBuilder().build(),
                )
            )
            .build()

        signIn.launch(signInIntent)
    }

    private fun onSignInResult(result: FirebaseAuthUIAuthenticationResult) {
        if (result.resultCode == RESULT_OK) {
            Log.d("SignIn", "Sign in successful!")
            authViewModel.setUserLoggedIn(true)
            authViewModel.setNavigateToProfile(true)

            // Lấy dữ liệu profile
            val profileData = UserProfileData(
                name = auth.currentUser?.displayName ?: "Unknown",
                email = auth.currentUser?.email ?: "Unknown",
                dateOfBirth = "N/A" // Thay bằng dữ liệu thực tế
            )
            authViewModel.setUserProfileData(profileData)
        } else {
            val response = result.idpResponse
            if (response?.error != null) {
                // Xử lý lỗi cụ thể
                if (response.error?.errorCode == 125) {
                    // Lỗi xung đột tài khoản
                    Toast.makeText(
                        this,
                        "Tài khoản đã tồn tại. Vui lòng đăng nhập bằng phương thức khác.",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    // Lỗi khác
                    Log.e("SignIn", "Sign in error", response.error)
                    Toast.makeText(
                        this,
                        "Đã xảy ra lỗi: ${response.error?.message}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            } else {
                // Người dùng hủy đăng nhập
                Toast.makeText(this, "Đăng nhập bị hủy", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun MyApp(authViewModel: AuthViewModel, onSignInClick: () -> Unit) {
    val isLoggedIn by authViewModel.isUserLoggedIn.observeAsState(false)
    val navigateToProfile by authViewModel.navigateToProfile.observeAsState(false)
    val profileData by authViewModel.userProfileData.observeAsState(null)

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        if (isLoggedIn && navigateToProfile && profileData != null) {
            ProfileScreen(
                name = profileData!!.name,
                email = profileData!!.email,
                dateOfBirth = profileData!!.dateOfBirth,
                onBackClick = {
                    authViewModel.setNavigateToProfile(false)
                }
            )
        } else {
            HomeScreen(onSignInClick = onSignInClick)
        }
    }
}
