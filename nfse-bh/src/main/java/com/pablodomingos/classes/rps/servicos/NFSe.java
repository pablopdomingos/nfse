package com.pablodomingos.classes.rps.servicos;


import java.util.List;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class NFSe {

  @XStreamAlias("xmlns")
  @XStreamAsAttribute
  private String xmlns;

  public String getXmlns() {
    return xmlns;
  }

  public void setXmlns(String xmlns) {
    this.xmlns = xmlns;
  }

  public Signature getSignature() {
    return signature;
  }

  public void setSignature(Signature signature) {
    this.signature = signature;
  }

  @XStreamAlias("versao")
  @XStreamAsAttribute
  private String versao;

  @XStreamAlias("InfNfse")
  private InfNFSe infNfse;

  @XStreamAlias("Signature")
  private Signature signature;

  public InfNFSe getInfNfse() {
    return infNfse;
  }

  public void setInfNfse(InfNFSe infNfse) {
    this.infNfse = infNfse;
  }

  public String getVersao() {
    return versao;
  }

  public void setVersao(String versao) {
    this.versao = versao;
  }

  class Signature {

    @XStreamAlias("xmlns")
    @XStreamAsAttribute
    String xmlns;

    @XStreamAlias("Id")
    @XStreamAsAttribute
    String id;

    @XStreamAlias("SignedInfo")
    SignedInfo SignedInfo;
    @XStreamAlias("SignatureValue")
    String SignatureValue;
    @XStreamAlias("KeyInfo")
    KeyInfo KeyInfo;
  }

  class SignedInfo {

    @XStreamAlias("CanonicalizationMethod")
    CanonicalizationMethod CanonicalizationMethod;
    @XStreamAlias("SignatureMethod")
    SignatureMethod SignatureMethod;
    @XStreamAlias("Reference")
    Reference Reference;
  }

  class CanonicalizationMethod {
    @XStreamAlias("Algorithm")
    @XStreamAsAttribute
    String Algorithm;
  }

  class SignatureMethod {
    @XStreamAlias("Algorithm")
    @XStreamAsAttribute
    String Algorithm;
  }

  class Reference {
    @XStreamAlias("URI")
    @XStreamAsAttribute
    String uri;

    @XStreamAlias("Transforms")
    Transforms Transforms;
    @XStreamAlias("DigestMethod")
    DigestMethod DigestMethod;
    @XStreamAlias("DigestValue")
    String DigestValue;
  }

  class DigestMethod {
    @XStreamAsAttribute
    @XStreamAlias("Algorithm")
    String Algorithm;
  }

  class Transforms {
    @XStreamImplicit(itemFieldName = "Transform")
    List<Transform> Transform = new java.util.ArrayList<Transform>();
  }

  class Transform {
    @XStreamAlias("Algorithm")
    @XStreamAsAttribute
    String Algorithm;
  }

  class KeyInfo {
    @XStreamAlias("X509Data")
    X509Data X509Data;
  }

  class X509Data {
    @XStreamAlias("X509Certificate")
    String X509Certificate;
  }
}
