package com.pablodomingos;

import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.management.InvalidAttributeValueException;

import com.pablodomingos.assinatura.AssinaturaDigital;
import com.pablodomingos.assinatura.CertificadoConfig;
import com.pablodomingos.assinatura.CertificadoConfig.CertificadoConfigBuilder;
import com.pablodomingos.assinatura.TipoCertificado;
import com.pablodomingos.classes.nfse.NFSeEnvio;
import com.pablodomingos.classes.nfse.NFSeLoteRps;
import com.pablodomingos.classes.nfse.NFSeRps;
import com.pablodomingos.classes.nfse.NFSeRpsInfo;
import com.pablodomingos.classes.nfse.NFSeRpsInfoIdentificacaoRps;
import com.pablodomingos.classes.nfse.NFSeRpsInfoServico;
import com.pablodomingos.classes.nfse.NFSePrestador;
import com.pablodomingos.classes.nfse.NFSeTomador;
import com.pablodomingos.classes.nfse.NFSeTomadorContato;
import com.pablodomingos.classes.nfse.NFSeTomadorEndereco;
import com.pablodomingos.classes.nfse.NFSeTomadorIdentificacao;
import com.pablodomingos.classes.nfse.enums.LoteRpsVersao;
import com.pablodomingos.classes.nfse.enums.RpsSerie;
import com.pablodomingos.classes.nfse.enums.RpsTipo;
import com.pablodomingos.classes.nfse.enums.NaturezaOperacao;
import com.pablodomingos.classes.nfse.enums.OptanteSimplesNacional;
import com.pablodomingos.classes.nfse.enums.RegimeEspecialTributacao;
import com.pablodomingos.classes.nfse.enums.RpsStatus;
import com.pablodomingos.classes.nfse.NFSeTomadorCpfCnpj;
import com.pablodomingos.classes.nfse.NFSeValores;
import com.pablodomingos.classes.nfse.builders100.TomadorBuilder100;
import com.pablodomingos.classes.nfse.builders100.ValoresBuilder100;

/**
 * Hello world!
 *
 */
public class App 
{
    
    public static void main( String[] args ) throws InvalidAttributeValueException
    {
     
      //Tomador
      NFSeTomador tomador = new TomadorBuilder100("00000000000000")
          .comInscricaoMunicipal("000000000000000")
          .comEmail("teste@teste.com.br")
          .comTelefone("00000000000")
          .comLogradouro("Rua teste")
          .comNumeroEndereco("125")
          .comComplemento("Apto teste")
          .comBairro("Bairro teste")
          .comCep("30000000")
          .comCodigoMunicipio(1234)
          .comUf("MG")
          .build();
      
      //Prestador
      NFSePrestador prestador = new NFSePrestador()
        .comCnpj("00000000000000")
        .comInscricaoMunicipal("000000000000");
      
      //Servico
      NFSeValores valores = new ValoresBuilder100(100.00, 1.0)
        .comIssRetido(false)
        .build();

      NFSeRpsInfoServico servicoPrestado = new NFSeRpsInfoServico()
        .comCodigoCnae(12345)
        .comCodigoMunicipio(12345)
        .comCodigoTributacaoMunicipio("12345")
        .comDiscriminacao("Servico teste")
        .comCodigoItemListaServico("12345")
        .comValores(valores);
      
      //Identifica��o RPS
      NFSeRpsInfoIdentificacaoRps identificacaoRps = new NFSeRpsInfoIdentificacaoRps()
        .comNumero(BigInteger.valueOf(1))
        .comSerie(RpsSerie.A)
        .comTipo(RpsTipo.RPS);
      
      NFSeRpsInfo rpsInfo = new NFSeRpsInfo();
      rpsInfo.setDataEmissao(LocalDateTime.now());
      rpsInfo.setId("1");
      rpsInfo.setIdentificacaoRps(identificacaoRps);
      rpsInfo.setNaturezaOperacao(NaturezaOperacao.TRIBUTACAO_MUNICIPIO);
      rpsInfo.setOptanteSimplesNacional(OptanteSimplesNacional.SIM);
      rpsInfo.setPrestador(prestador);
      rpsInfo.setRegimeEspecialTributacao(RegimeEspecialTributacao.ME_EPP_SIMPLES_NACIONAL);
      rpsInfo.setServico(servicoPrestado);
      rpsInfo.setStatus(RpsStatus.NORMAL);
      rpsInfo.setTomador(tomador);
      
      //RPS
      NFSeRps rps = new NFSeRps();
      rps.setRpsInfo(rpsInfo);
      
      
      //Lote RPS
      NFSeLoteRps loteRps = new NFSeLoteRps();
      loteRps.setCnpj("00000000000000");
      loteRps.setInscricaoMunicipal("000000000");
      loteRps.setNumeroLote(1L);
      loteRps.setVersao(LoteRpsVersao.V1_00);
      loteRps.addRps(rps);

      
      //Envio
      NFSeEnvio nfseEnvio = new NFSeEnvio();
      nfseEnvio.setLoteRps(loteRps);
      
      
      String xml = nfseEnvio.toXml();
      

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
