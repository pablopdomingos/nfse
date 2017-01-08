package com.pablodomingos;


import javax.management.InvalidAttributeValueException;

import com.pablodomingos.assinatura.AssinaturaDigital;
import com.pablodomingos.assinatura.CertificadoConfig;
import com.pablodomingos.assinatura.CertificadoConfig.CertificadoConfigBuilder;
import com.pablodomingos.assinatura.TipoCertificado;
import com.pablodomingos.classes.enums.LoteRpsVersao;
import com.pablodomingos.classes.enums.NaturezaOperacao;
import com.pablodomingos.classes.enums.RegimeEspecialTributacao;
import com.pablodomingos.classes.enums.RpsStatus;
import com.pablodomingos.classes.rps.RpsEnvio;
import com.pablodomingos.classes.rps.LoteRps;
import com.pablodomingos.classes.rps.RpsPrestador;
import com.pablodomingos.classes.rps.Rps;
import com.pablodomingos.classes.rps.RpsInfo;
import com.pablodomingos.classes.rps.RpsServico;
import com.pablodomingos.classes.rps.RpsTomador;
import com.pablodomingos.classes.rps.RpsTomadorContato;
import com.pablodomingos.classes.rps.RpsTomadorEndereco;
import com.pablodomingos.classes.rps.RpsValores;
import com.pablodomingos.classes.rps.builders.LoteRpsBuilder;
import com.pablodomingos.classes.rps.builders.PrestadorBuilder;
import com.pablodomingos.classes.rps.builders.RpsInfoBuilder;
import com.pablodomingos.classes.rps.builders.ServicoBuilder;
import com.pablodomingos.classes.rps.builders.TomadorBuilder;
import com.pablodomingos.classes.rps.builders.TomadorContatoBuilder;
import com.pablodomingos.classes.rps.builders.TomadorEnderecoBuilder;
import com.pablodomingos.classes.rps.builders.ValoresBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    
    public static void main( String[] args ) throws InvalidAttributeValueException
    {
     
      //Endereco Tomador
      RpsTomadorEndereco endereco = new TomadorEnderecoBuilder()
        .comLogradouro("Rua Antonio Jose Costa")
        .comNumeroEndereco("195")
        .comComplemento("Apto teste")
        .comBairro("Darcy Ribeiro")
        .comCep("32060528")
        .comCodigoMunicipio("3118601")
        .comUf("MG")
        .build();
      
      RpsTomadorContato contato = new TomadorContatoBuilder()
        .comTelefone("2222222222")
        .comEmail("claudio1dhcp@gmail.com")
        .build();
      
      //Tomador
      RpsTomador tomador = new TomadorBuilder("56856504691")
          .comNome("Claudio")
        .comContato(contato)
        .comEndereco(endereco)
        .build();
    
      //Prestador
      RpsPrestador prestador = new PrestadorBuilder("17773455000142")
        .comInscricaoMunicipal("04812760010")
        .build();
      
      //Servico
      RpsValores valores = new ValoresBuilder(10.00, 2.0)
        .comIssRetido(false)
        .build();

      RpsServico servicoPrestado = new ServicoBuilder(valores, "11.02")
        .comCodigoCnae(12312)
        .comCodigoMunicipio(3106200)
        .comCodigoTributacaoMunicipio("110200188")
        .comDiscriminacao("Mes referencia: 11/2016|Honda XRE300 - OWJ9928 (Panico, Historico, Rastreamento, Bloqueio) - R$ 40,00|Honda CG 150 Fan - PWN3011 (Panico, Historico, Rastreamento, Bloqueio) - R$ 40,00")
        .build();
      
      RpsInfo rpsInfo = new RpsInfoBuilder("20170000015")
        .comNaturezaOperacao(NaturezaOperacao.TRIBUTACAO_MUNICIPIO)
        .optanteSimplesNacional(true)
        .comPrestador(prestador)
        .comRegimeEspecialTributacao(RegimeEspecialTributacao.ME_EPP_SIMPLES_NACIONAL)
        .comServico(servicoPrestado)
        .comStatus(RpsStatus.NORMAL)
        .comTomador(tomador)
        .build();
      
      //RPS
      Rps rps = new Rps(rpsInfo);
      
      //Lote RPS
      LoteRps loteRps = new LoteRpsBuilder("1000")
        .comCnpj("17773455000142")
        .comInscricaoMunicipal("04812760010")
        .comVersao(LoteRpsVersao.V1_00)
        .addRps(rps)
        .build();
      
      //Envio
      RpsEnvio nfseEnvio = new RpsEnvio(loteRps);
      
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
