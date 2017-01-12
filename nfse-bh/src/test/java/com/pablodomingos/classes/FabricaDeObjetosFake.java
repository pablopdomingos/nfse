package com.pablodomingos.classes;

import com.pablodomingos.classes.rps.LoteRps;
import com.pablodomingos.classes.rps.NFSeIdentificacao;
import com.pablodomingos.classes.rps.NFSeInfPedidoCancelamento;
import com.pablodomingos.classes.rps.Rps;
import com.pablodomingos.classes.rps.RpsInfo;
import com.pablodomingos.classes.rps.RpsIntermediario;
import com.pablodomingos.classes.rps.RpsPrestador;
import com.pablodomingos.classes.rps.RpsServico;
import com.pablodomingos.classes.rps.RpsTomador;
import com.pablodomingos.classes.rps.RpsTomadorContato;
import com.pablodomingos.classes.rps.RpsTomadorEndereco;
import com.pablodomingos.classes.rps.RpsValores;
import com.pablodomingos.classes.rps.builders.IdentificacaoNFSeBuilder;
import com.pablodomingos.classes.rps.builders.IntermediarioBuilder;
import com.pablodomingos.classes.rps.builders.LoteRpsBuilder;
import com.pablodomingos.classes.rps.builders.PedidoCancelamentoInfBuilder;
import com.pablodomingos.classes.rps.builders.PrestadorBuilder;
import com.pablodomingos.classes.rps.builders.RpsInfoBuilder;
import com.pablodomingos.classes.rps.builders.ServicoBuilder;
import com.pablodomingos.classes.rps.builders.TomadorBuilder;
import com.pablodomingos.classes.rps.builders.TomadorContatoBuilder;
import com.pablodomingos.classes.rps.builders.TomadorEnderecoBuilder;
import com.pablodomingos.classes.rps.builders.ValoresBuilder;
import com.pablodomingos.classes.rps.enums.CodigoCancelamento;
import com.pablodomingos.classes.rps.enums.LoteRpsVersao;
import com.pablodomingos.classes.rps.enums.NaturezaOperacao;
import com.pablodomingos.classes.rps.enums.RegimeEspecialTributacao;
import com.pablodomingos.classes.rps.enums.RpsStatus;

public class FabricaDeObjetosFake {

  public static RpsTomadorEndereco getRpsTomadorEndereco(){
    RpsTomadorEndereco endereco = new TomadorEnderecoBuilder()
        .comLogradouro("Logradouro")
        .comNumeroEndereco("1234")
        .comComplemento("Complemento")
        .comBairro("Bairro")
        .comCep("00000000")
        .comCodigoMunicipio("3118601")
        .comUf("MG")
        .build();
    
    return endereco;
  }
  
  public static RpsTomadorContato getRpsTomadorContato(){
    RpsTomadorContato contato = new TomadorContatoBuilder()
        .comTelefone("00000000000")
        .comEmail("email@gmail.com")
        .build();
    
    return contato;
  }
  
  public static RpsTomador getRpsTomador() {
    RpsTomador tomador = new TomadorBuilder("12345678909")
        .comNome("Nome Tomador")
        .comEndereco(getRpsTomadorEndereco())
        .comContato(getRpsTomadorContato())
        .build();
        
    return tomador;
  }
  
  public static RpsPrestador getRpsPrestador(){
    RpsPrestador prestador = new PrestadorBuilder("12345678901230")
        .comInscricaoMunicipal("000000000000000")
        .build();
    
    return prestador;
  }
  
  public static RpsIntermediario getRpsIntermediario(){
    RpsIntermediario intermediario = new IntermediarioBuilder("12345678901230", "Nome Intermediario")
        .comInscricaoMunicipal("000000000000000")
        .build();
    
    return intermediario;
  }
  
  public static RpsValores getRpsValores(){
    RpsValores valores = new ValoresBuilder(100.00, 1.0)
        .comValorPis(2.00)
        .comValorCofins(3.00)
        .comValorInss(4.00)
        .comValorIr(5.00)
        .comValorCsll(6.00)
        .comValorDeducoes(7.00)
        .comDescontoCondicionado(8.00)
        .comDescontoIncondicionado(9.00)
        .comOutrasRetencoes(10.00)
        .comIssRetido(false)
        .build();
    
    return valores;
  }
  
  public static RpsServico getRpsServico(){
    RpsServico servico = new ServicoBuilder(getRpsValores(), "01.01")
        .comCodigoCnae(12345)
        .comCodigoMunicipio(3106200)
        .comCodigoTributacaoMunicipio("110200188")
        .comDiscriminacao("Discriminacao teste")
        .build();
    
    return servico;
  }
  
  public static RpsInfo getRpsInfo(){
    RpsInfo rpsInfo = new RpsInfoBuilder("1")
        .comId("id")
        .comNaturezaOperacao(NaturezaOperacao.TRIBUTACAO_MUNICIPIO)
        .optanteSimplesNacional(true)
        .comPrestador(getRpsPrestador())
        .comRegimeEspecialTributacao(RegimeEspecialTributacao.ME_EPP_SIMPLES_NACIONAL)
        .comServico(getRpsServico())
        .comStatus(RpsStatus.NORMAL)
        .comTomador(getRpsTomador())
        .build();
    
    return rpsInfo;
  }
  
  public static Rps getRps(){
    return new Rps(getRpsInfo());
  }
  
  public static LoteRps getLoteRps(){
    LoteRps loteRps = new LoteRpsBuilder("1")
        .comId("id")
        .comCnpj("12345678901230")
        .comInscricaoMunicipal("000000000000000")
        .comVersao(LoteRpsVersao.V1_00)
        .addRps(getRps())
        .build();
    
    return loteRps;
  }
  
  public static NFSeIdentificacao getNFSeIdentificacao(){
    NFSeIdentificacao identificacaoNFSe = new IdentificacaoNFSeBuilder()
        
        .comCnpj("12345678901230")
        .comInscricaoMunicipal("000000000000000")
        .comCodigoMunicipioIbge("3106200")
        .comNumero("201700000000001")
        .build();
    
    return identificacaoNFSe;
  }
  
  public static NFSeInfPedidoCancelamento getNFSeInfPedidoCancelamento(){
    
    NFSeInfPedidoCancelamento pedidoCancelamentoInf = new PedidoCancelamentoInfBuilder()
        .comId("id")
        .comCodigoCancelamento(CodigoCancelamento.SERVICO_NAO_CONCLUIDO)
        .comNFSeIdentificacao(getNFSeIdentificacao())
        .build();
    
    return pedidoCancelamentoInf;
  }
  
  public static TomadorEnderecoBuilder getTomadorEnderecoBuilder(){
    return new TomadorEnderecoBuilder()
        .comLogradouro("Logradouro")
        .comNumeroEndereco("1234")
        .comComplemento("Complemento")
        .comBairro("Bairro")
        .comCep("00000000")
        .comCodigoMunicipio("3118601")
        .comUf("MG");
    
    
  }
}
