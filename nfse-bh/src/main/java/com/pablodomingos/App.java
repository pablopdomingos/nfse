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
import com.pablodomingos.classes.nfse.NFSeLoteRpsVersao;
import com.pablodomingos.classes.nfse.NFSeRps;
import com.pablodomingos.classes.nfse.NFSeRpsInfo;
import com.pablodomingos.classes.nfse.NFSeRpsInfoIdentificacaoRps;
import com.pablodomingos.classes.nfse.NFSeRpsInfoIdentificacaoRpsSerie;
import com.pablodomingos.classes.nfse.NFSeRpsInfoIdentificacaoRpsTipo;
import com.pablodomingos.classes.nfse.NFSeRpsInfoNaturezaOperacao;
import com.pablodomingos.classes.nfse.NFSeRpsInfoOptanteSimplesNacional;
import com.pablodomingos.classes.nfse.NFSeRpsInfoRegimeEspecialTributacao;
import com.pablodomingos.classes.nfse.NFSeRpsInfoServico;
import com.pablodomingos.classes.nfse.Prestador;
import com.pablodomingos.classes.nfse.Tomador;
import com.pablodomingos.classes.nfse.TomadorContato;
import com.pablodomingos.classes.nfse.TomadorEndereco;
import com.pablodomingos.classes.nfse.TomadorIdentificacao;
import com.pablodomingos.classes.nfse.TomadorCpfCnpj;
import com.pablodomingos.classes.nfse.NFSeRpsInfoServicoValores;
import com.pablodomingos.classes.nfse.NFSeRpsInfoServicoValoresIssRetido;
import com.pablodomingos.classes.nfse.NFSeRpsInfoStatus;

/**
 * Hello world!
 *
 */
public class App 
{
    
    public static void main( String[] args ) throws InvalidAttributeValueException
    {
     
      //Tomador
      TomadorCpfCnpj cpfCnpjTomador = new TomadorCpfCnpj()
        .comDocumento("000000000000000");

      TomadorIdentificacao identificacaoTomador = new TomadorIdentificacao()
        .comCpfCnpj(cpfCnpjTomador)
        .comInscricaoMunicipal("000000000000000");
      
      TomadorContato contatoTomador = new TomadorContato()
        .comEmail("teste@teste.com.br")
        .comTelefone("00000000000");
      
      TomadorEndereco enderecoTomador = new TomadorEndereco()
        .comEndereco("Rua teste")
        .comNumero("125")
        .comComplemento("Apto teste")
        .comBairro("Bairro teste")
        .comCep("30000000")
        .comCodigoMunicipio(1234)
        .comUf("MG");
      
      Tomador tomador = new Tomador()
        .comNome("Nome teste")
        .comContato(contatoTomador)
        .comEndereco(enderecoTomador)
        .comIdentificacaoTomador(identificacaoTomador);
      
      //Prestador
      Prestador prestador = new Prestador()
        .comCnpj("00000000000000")
        .comInscricaoMunicipal("000000000000");
      
      //Servico
      NFSeRpsInfoServicoValores valores = new NFSeRpsInfoServicoValores()
          .comAliquota(1.0)
          .comIssRetido(true)
          .comValorServicos(100.00);

      NFSeRpsInfoServico servicoPrestado = new NFSeRpsInfoServico()
        .comCodigoCnae(12345)
        .comCodigoMunicipio(12345)
        .comCodigoTributacaoMunicipio("12345")
        .comDiscriminacao("Servico teste")
        .comCodigoItemListaServico("12345")
        .comValores(valores);
      
      //Identifica��o RPS
      NFSeRpsInfoIdentificacaoRps identificacaoRps = new NFSeRpsInfoIdentificacaoRps();
      identificacaoRps.setNumero(BigInteger.valueOf(1));
      identificacaoRps.setSerie(NFSeRpsInfoIdentificacaoRpsSerie.A);
      identificacaoRps.setTipo(NFSeRpsInfoIdentificacaoRpsTipo.RPS);
      
      NFSeRpsInfo rpsInfo = new NFSeRpsInfo();
      rpsInfo.setDataEmissao(LocalDateTime.now());
      rpsInfo.setId("1");
      rpsInfo.setIdentificacaoRps(identificacaoRps);
      rpsInfo.setNaturezaOperacao(NFSeRpsInfoNaturezaOperacao.TRIBUTACAO_MUNICIPIO);
      rpsInfo.setOptanteSimplesNacional(NFSeRpsInfoOptanteSimplesNacional.SIM);
      rpsInfo.setPrestador(prestador);
      rpsInfo.setRegimeEspecialTributacao(NFSeRpsInfoRegimeEspecialTributacao.ME_EPP_SIMPLES_NACIONAL);
      rpsInfo.setServico(servicoPrestado);
      rpsInfo.setStatus(NFSeRpsInfoStatus.NORMAL);
      rpsInfo.setTomador(tomador);
      
      //RPS
      NFSeRps rps = new NFSeRps();
      rps.setRpsInfo(rpsInfo);
      
      
      //Lote RPS
      NFSeLoteRps loteRps = new NFSeLoteRps();
      loteRps.setCnpj("00000000000000");
      loteRps.setInscricaoMunicipal("000000000");
      loteRps.setNumeroLote(1L);
      loteRps.setVersao(NFSeLoteRpsVersao.V1_00);
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
