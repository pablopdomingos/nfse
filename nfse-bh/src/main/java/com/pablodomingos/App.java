package com.pablodomingos;

import java.math.BigInteger;
import java.time.LocalDateTime;

import com.pablodomingos.assinatura.AssinaturaDigital;
import com.pablodomingos.assinatura.ConfigCertificadoDigital;
import com.pablodomingos.assinatura.ConfigCertificadoDigital.ConfigCertificadoDigitalBuilder;
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
import com.pablodomingos.classes.nfse.NFSeRpsInfoServicoPrestador;
import com.pablodomingos.classes.nfse.NFSeRpsInfoServicoTomador;
import com.pablodomingos.classes.nfse.NFSeRpsInfoServicoTomadorContato;
import com.pablodomingos.classes.nfse.NFSeRpsInfoServicoTomadorEndereco;
import com.pablodomingos.classes.nfse.NFSeRpsInfoServicoTomadorIdentificacao;
import com.pablodomingos.classes.nfse.NFSeRpsInfoServicoTomadorIdentificacaoCpfCnpj;
import com.pablodomingos.classes.nfse.NFSeRpsInfoServicoValores;
import com.pablodomingos.classes.nfse.NFSeRpsInfoServicoValoresIssRetido;
import com.pablodomingos.classes.nfse.NFSeRpsInfoStatus;

/**
 * Hello world!
 *
 */
public class App 
{
    
    public static void main( String[] args )
    {
     
      //Tomador
      NFSeRpsInfoServicoTomadorIdentificacaoCpfCnpj cpfCnpjTomador = new NFSeRpsInfoServicoTomadorIdentificacaoCpfCnpj();
      cpfCnpjTomador.setCnpj("000000000000000");
      
      NFSeRpsInfoServicoTomadorIdentificacao identificacaoTomador = new NFSeRpsInfoServicoTomadorIdentificacao();
      identificacaoTomador.setCpfCnpj(cpfCnpjTomador);
      identificacaoTomador.setInscricaoMunicipal("000000000000000");
      
      NFSeRpsInfoServicoTomadorContato contatoTomador = new NFSeRpsInfoServicoTomadorContato();
      contatoTomador.setEmail("teste@teste.com.br");
      contatoTomador.setTelefone("00000000000");
      
      NFSeRpsInfoServicoTomadorEndereco enderecoTomador = new NFSeRpsInfoServicoTomadorEndereco();
      enderecoTomador.setEndereco("Rua teste");
      enderecoTomador.setNumero("125");
      enderecoTomador.setComplemento("Apto teste");
      enderecoTomador.setBairro("Bairro teste");
      enderecoTomador.setCep("30000000");
      enderecoTomador.setCodigoMunicipio(1234);
      enderecoTomador.setUf("MG");
      
      NFSeRpsInfoServicoTomador tomadorServico = new NFSeRpsInfoServicoTomador();
      tomadorServico.setContato(contatoTomador);
      tomadorServico.setEndereco(enderecoTomador);
      tomadorServico.setIdentificacaoTomador(identificacaoTomador);
      
      //Prestador
      NFSeRpsInfoServicoPrestador prestadorServico = new NFSeRpsInfoServicoPrestador();
      prestadorServico.setCnpj("00000000000000");
      prestadorServico.setInscricaoMunicipal("000000000000");
      
      //Servico
      NFSeRpsInfoServicoValores valoresServico = new NFSeRpsInfoServicoValores();
      valoresServico.setAliquota(1.00);
      valoresServico.setIssRetido(NFSeRpsInfoServicoValoresIssRetido.SIM);
      valoresServico.setValorServicos(100.00);
      
      NFSeRpsInfoServico servicoPrestado = new NFSeRpsInfoServico();
      servicoPrestado.setCodigoCnae(12345);
      servicoPrestado.setCodigoMunicipio(12345);
      servicoPrestado.setCodigoTributacaoMunicipio("12345");
      servicoPrestado.setDiscriminacao("Servico teste");
      servicoPrestado.setItemListaServico("12345");
      servicoPrestado.setValores(valoresServico);
      
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
      rpsInfo.setPrestador(prestadorServico);
      rpsInfo.setRegimeEspecialTributacao(NFSeRpsInfoRegimeEspecialTributacao.ME_EPP_SIMPLES_NACIONAL);
      rpsInfo.setServico(servicoPrestado);
      rpsInfo.setStatus(NFSeRpsInfoStatus.NORMAL);
      rpsInfo.setTomador(tomadorServico);
      
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
      

      ConfigCertificadoDigital config = new ConfigCertificadoDigitalBuilder(TipoCertificado.A1, "12345678").build();
      
      AssinaturaDigital assinatura = new AssinaturaDigital(config);
      
      try {
        System.out.println(assinatura.assinarXML(xml));
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
    }

}
