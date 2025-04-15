package com.example.btlogin.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class AuthViewModel : ViewModel() {
    val isUserLoggedIn: MutableLiveData<Boolean> = MutableLiveData(false)
    val navigateToProfile: MutableLiveData<Boolean> = MutableLiveData(false)
    val userProfileData: MutableLiveData<UserProfileData?> = MutableLiveData(null)

    fun setUserLoggedIn(isLoggedIn: Boolean) {
        isUserLoggedIn.value = isLoggedIn
    }

    fun setNavigateToProfile(navigate: Boolean) {
        navigateToProfile.value = navigate
    }

    fun setUserProfileData(profileData: UserProfileData?) {
        userProfileData.value = profileData
    }
}

data class UserProfileData(
    val name: String,
    val email: String,
    val dateOfBirth: String
)
