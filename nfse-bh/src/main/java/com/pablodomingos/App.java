package com.pablodomingos;


import java.io.File;

import javax.management.InvalidAttributeValueException;

import org.apache.commons.io.FileUtils;

import com.pablodomingos.assinatura.AssinaturaDigital;
import com.pablodomingos.assinatura.CertificadoConfig;
import com.pablodomingos.assinatura.CertificadoConfig.CertificadoConfigBuilder;
import com.pablodomingos.assinatura.TipoCertificado;
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
import com.pablodomingos.classes.rps.enums.LoteRpsVersao;
import com.pablodomingos.classes.rps.enums.NFSeAmbiente;
import com.pablodomingos.classes.rps.enums.NaturezaOperacao;
import com.pablodomingos.classes.rps.enums.RegimeEspecialTributacao;
import com.pablodomingos.classes.rps.enums.RpsStatus;
import com.pablodomingos.util.NFSeGeraCadeiaCertificados;
import com.pablodomingos.webservices.WSEnviaLote;

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
        .comLogradouro("Rua Teste")
        .comNumeroEndereco("195")
        .comBairro("Bairro Teste")
        .comCep("32000000")
        .comCodigoMunicipio("3118601")
        .comUf("MG")
        .build();
      
      RpsTomadorContato contato = new TomadorContatoBuilder()
        .comEmail("email@gmail.com")
        .build();
      
      //Tomador
      RpsTomador tomador = new TomadorBuilder("00000000000")
          .comNome("Nome Teste")
        .comContato(contato)
        .comEndereco(endereco)
        .build();
    
      //Prestador
      RpsPrestador prestador = new PrestadorBuilder("00000000000000")
        .comInscricaoMunicipal("0000000000")
        .build();
      
      //Servico
      RpsValores valores = new ValoresBuilder(50.00, 3.0)
        .comIssRetido(false)
        .build();

      RpsServico servicoPrestado = new ServicoBuilder(valores, "1.05")
        .comCodigoCnae(2621300)
        .comCodigoMunicipio(3106200)
        .comCodigoTributacaoMunicipio("010500188")
        .comDiscriminacao("Servico informatica")
        .build();
      
      RpsInfo rpsInfo = new RpsInfoBuilder("100")
        .comNaturezaOperacao(NaturezaOperacao.TRIBUTACAO_MUNICIPIO)
        .optanteSimplesNacional(false)
        .comPrestador(prestador)
        .comServico(servicoPrestado)
        .comStatus(RpsStatus.NORMAL)
        .comTomador(tomador)
        .build();
      
      //RPS
      Rps rps = new Rps(rpsInfo);
      
      //Lote RPS
      LoteRps loteRps = new LoteRpsBuilder("1000")
        .comCnpj("00000000000000")
        .comInscricaoMunicipal("0000000000")
        .comVersao(LoteRpsVersao.V1_00)
        .addRps(rps)
        .build();
      
      //Envio
      RpsEnvio nfseEnvio = new RpsEnvio(loteRps);
      
      String xml = nfseEnvio.converterParaXml();
      try {
        
        FileUtils.writeByteArrayToFile(new File("c:/certificado/nfse-bh.cacerts"), NFSeGeraCadeiaCertificados.geraCadeiaCertificados("senha"));
        
        CertificadoConfig config = new CertificadoConfigBuilder(TipoCertificado.A1, "senha")
            .comAmbiente(NFSeAmbiente.HOMOLOGACAO).build();
        
        AssinaturaDigital assinatura = new AssinaturaDigital(config);
        //System.out.println(xml);
        
        System.out.println(WSEnviaLote.enviarLote(assinatura.assinarXML(xml), config));
        
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
    }

}
