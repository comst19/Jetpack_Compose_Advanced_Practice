package com.comst.hltextensionapp

import com.comst.annotations.InstallBinding
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@InstallBinding(component = SingletonComponent::class)
class AuthenticatorImpl @Inject constructor(): Authenticator