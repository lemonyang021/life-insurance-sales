package com.flywolf.li.framework.configcenter.utils;


import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class RSAKeyPair
{
  private KeyPair keypair = null;

  public RSAKeyPair(KeyPair kp)
  {
    this.keypair = kp;
  }

  public RSAPublicKey getPublicKey() {
    return ((RSAPublicKey)this.keypair.getPublic());
  }

  public RSAPrivateKey getPrivateKey() {
    return ((RSAPrivateKey)this.keypair.getPrivate());
  }
}