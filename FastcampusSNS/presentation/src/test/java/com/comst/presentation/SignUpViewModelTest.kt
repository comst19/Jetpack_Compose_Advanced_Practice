package com.comst.presentation

import com.comst.domain.usecase.login.SignUpUseCase
import com.comst.presentation.login.SignUpSideEffect
import com.comst.presentation.login.SignUpViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test


private val testId = "comst19"
private val testPassword = "1234"
private val testUsername = "comst19"
class SignUpViewModelTest {

    // given - 객체 생성
    lateinit var signUpUseCase: SignUpUseCase
    lateinit var viewModel: SignUpViewModel

    @Before
    fun setup(){
        signUpUseCase = FakeSignUpUseCase()
        viewModel = SignUpViewModel(signUpUseCase)
    }

    @Test
    fun 입력된_아이디_상태_테스트(){

        Assert.assertEquals(viewModel.container.stateFlow.value.id, "")

        // when - 액션, 텍스트입력
        viewModel.onIdChange(testId)

        // then - 검증
        Assert.assertEquals(viewModel.container.stateFlow.value.id, testId)

        Assert.assertEquals(viewModel.container.stateFlow.value.password, "")
        viewModel.onPasswordChange(testPassword)
        Assert.assertEquals(viewModel.container.stateFlow.value.password, testPassword)

    }

    @Test
    fun 입력된_패스워드_테스트(){

        Assert.assertEquals(viewModel.container.stateFlow.value.password, "")
        viewModel.onPasswordChange(testPassword)
        Assert.assertEquals(viewModel.container.stateFlow.value.password, testPassword)
    }

    @Test
    fun 회원가입_버튼_클릭_실패_테스트() = runTest{
        val vm = SignUpViewModel(signUpUseCase)
        vm.onIdChange(testId)
        vm.onPasswordChange(testPassword)
        //vm.onRepeatPasswordChange(testPassword)
        vm.onSignUpClick()
        val sideEffect = vm.container.sideEffectFlow.first()
        //Assert.assertTrue(sideEffect is SignUpSideEffect.Toast)
        Assert.assertEquals((sideEffect as? SignUpSideEffect.Toast)?.message,"패스워드를 다시 확인해주세요.")
    }

    @Test
    fun 회원가입_버튼_클릭_성공_테스트() = runTest{
        val vm = SignUpViewModel(signUpUseCase)
        vm.onIdChange(testId)
        vm.onUsernameChange(testUsername)
        vm.onPasswordChange(testPassword)
        vm.onRepeatPasswordChange(testPassword)
        vm.onSignUpClick()
        val sideEffect = vm.container.sideEffectFlow.first()
        Assert.assertTrue(sideEffect is SignUpSideEffect.NavigateToLoginScreen)
    }

    class FakeSignUpUseCase:SignUpUseCase{
        override suspend fun invoke(
            id: String,
            username: String,
            password: String
        ): Result<Boolean> = kotlin.runCatching{
            id == testId && username == testUsername && password == testPassword
            //true
        }

    }
}