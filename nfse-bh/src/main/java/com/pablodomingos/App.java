package com.pablodomingos;


import javax.management.InvalidAttributeValueException;

import com.pablodomingos.assinatura.AssinaturaDigital;
import com.pablodomingos.assinatura.CertificadoConfig;
import com.pablodomingos.assinatura.CertificadoConfig.CertificadoConfigBuilder;
import com.pablodomingos.assinatura.TipoCertificado;
import com.pablodomingos.classes.nfse.NFSeEnvio;
import com.pablodomingos.classes.nfse.NFSeLoteRps;
import com.pablodomingos.classes.nfse.NFSeRps;
import com.pablodomingos.classes.nfse.NFSeRpsInfo;
import com.pablodomingos.classes.nfse.NFSeServico;
import com.pablodomingos.classes.nfse.NFSePrestador;
import com.pablodomingos.classes.nfse.NFSeTomador;
import com.pablodomingos.classes.nfse.NFSeTomadorEndereco;
import com.pablodomingos.classes.nfse.enums.LoteRpsVersao;
import com.pablodomingos.classes.nfse.enums.NaturezaOperacao;
import com.pablodomingos.classes.nfse.enums.RegimeEspecialTributacao;
import com.pablodomingos.classes.nfse.enums.RpsStatus;
import com.pablodomingos.classes.nfse.NFSeValores;
import com.pablodomingos.classes.nfse.builders.LoteRpsBuilder;
import com.pablodomingos.classes.nfse.builders.PrestadorBuilder;
import com.pablodomingos.classes.nfse.builders.RpsInfoBuilder;
import com.pablodomingos.classes.nfse.builders.ServicoBuilder;
import com.pablodomingos.classes.nfse.builders.TomadorBuilder;
import com.pablodomingos.classes.nfse.builders.TomadorEnderecoBuilder;
import com.pablodomingos.classes.nfse.builders.ValoresBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    
    public static void main( String[] args ) throws InvalidAttributeValueException
    {
     
      //Endereco Tomador
      NFSeTomadorEndereco endereco = new TomadorEnderecoBuilder()
        .comLogradouro("Rua teste")
        .comNumeroEndereco("125")
        .comComplemento("Apto teste")
        .comBairro("Bairro teste")
        .comCep("30000000")
        .comCodigoMunicipio("1234")
        .comUf("MG")
        .build();
      
      //Tomador
      NFSeTomador tomador = new TomadorBuilder("00000000000000")
          .comInscricaoMunicipal("000000000000000")
          .comEmail("teste@teste.com.br")
          .comTelefone("00000000000")
          .comEndereco(endereco)
          .build();
      
      //Prestador
      NFSePrestador prestador = new PrestadorBuilder("00000000000000")
        .comInscricaoMunicipal("000000000000")
        .build();
      
      //Servico
      NFSeValores valores = new ValoresBuilder(100.00, 1.0)
        .comIssRetido(false)
        .build();

      NFSeServico servicoPrestado = new ServicoBuilder(valores, "12345")
        .comCodigoCnae(12345)
        .comCodigoMunicipio(12345)
        .comCodigoTributacaoMunicipio("12345")
        .comDiscriminacao("Servico teste")
        .build();
      
      NFSeRpsInfo rpsInfo = new RpsInfoBuilder("20170000015")
        .comId("1")
        .comNaturezaOperacao(NaturezaOperacao.TRIBUTACAO_MUNICIPIO)
        .optanteSimplesNacional(true)
        .comPrestador(prestador)
        .comRegimeEspecialTributacao(RegimeEspecialTributacao.ME_EPP_SIMPLES_NACIONAL)
        .comServico(servicoPrestado)
        .comStatus(RpsStatus.NORMAL)
        .comTomador(tomador)
        .build();
      
      //RPS
      NFSeRps rps = new NFSeRps(rpsInfo);
      
      //Lote RPS
      NFSeLoteRps loteRps = new LoteRpsBuilder("1000")
      .comCnpj("00000000000000")
      .comInscricaoMunicipal("000000000")
      .comVersao(LoteRpsVersao.V1_00)
      .addRps(rps)
      .build();
      
      //Envio
      NFSeEnvio nfseEnvio = new NFSeEnvio(loteRps);
      
      String xml = nfseEnvio.converterParaXml();
      

      CertificadoConfig config = new CertificadoConfigBuilder(TipoCertificado.A1, "12345678")
          .comCaminhoParaOCertificado("c:/certificado/certificado.pfx").build();
      
      AssinaturaDigital assinatura = new AssinaturaDigital(config);
      
      try {
        System.out.println(assinatura.assinarXML(xml));
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
    }

}
