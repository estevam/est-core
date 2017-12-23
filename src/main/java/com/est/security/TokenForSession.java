/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.security;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.UUID;

/**
 *
 * @author estevam
 */
public class TokenForSession {
	public static void main(String args[]) {
		TokenForSession a = new TokenForSession();
		a.nextSessionId();
		a.ramdomUID();
	}

	private SecureRandom random = new SecureRandom();

	public void nextSessionId() {
		System.out.println(new BigInteger(130, random).toString(32));

	}

	public void ramdomUID() {
		String uuid = UUID.randomUUID().toString();
		System.out.println("uuid = " + uuid);
	}

}
