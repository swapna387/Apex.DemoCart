package com.apex.ecomm.user.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.apex.ecomm.user.constant.UserConstants;
import com.apex.ecomm.user.page.AccountsPage;
import com.apex.ecomm.user.page.ForgotYourPasswordPage;
import com.apex.web.core.ApexBaseTest;
import com.apex.web.core.ApexWebDriverUtil;

public class LoginTest extends ApexBaseTest implements UserConstants {

	@Test

	public void testWithCorrectEmailPassword()

	{
		AccountsPage accountsPage = lp.doLogin(CORRECT_EMAIL, CORRECT_PASSWORD);
		String title = accountsPage.doGetTitle();

		System.out.println("the title of  accounts page is:" + title);

		Assert.assertEquals(title, "My Account");

	}

	@Test

	public void testWithInCorrectEmailCorrectPassword() {

		lp.doLogin(INCORRECT_EMAIL, CORRECT_PASSWORD);

		Assert.assertEquals(lp.doGetText(), "Warning: No match for E-Mail Address and/or Password.");

	}

	@Test

	public void testWithCorrectEmailIncorrectPassword() {

		lp.doLogin(CORRECT_EMAIL, INCORRECT_PASSWORD);

		Assert.assertEquals(lp.doGetText(), "Warning: No match for E-Mail Address and/or Password.");

	}

	@Test

	public void testWithBlankEmailPassword() {

		lp.doLogin(BLANK_EMAIL, BLANK_PASSWORD);

		Assert.assertEquals(lp.doGetText(), "Warning: No match for E-Mail Address and/or Password.");

	}

	@Test

	public void testWithBlankEmailCorrectPassword() {

		lp.doLogin(BLANK_EMAIL, CORRECT_PASSWORD);
		Assert.assertEquals(lp.doGetText(), "Warning: No match for E-Mail Address and/or Password.");

	}

	@Test

	public void testWithCorrectEmailBlankPassword() {

		lp.doLogin(CORRECT_EMAIL, BLANK_PASSWORD);
		Assert.assertEquals(lp.doGetText(), "Warning: No match for E-Mail Address and/or Password.");

	}

	@Test

	public void testForgotPassWordLink() {

		ForgotYourPasswordPage forgotPwd = lp.doClick();

		String forgotPasswordPageTitle = forgotPwd.getTitle();
		Assert.assertEquals(forgotPasswordPageTitle, "Forgot Your Password?");

	}

}
