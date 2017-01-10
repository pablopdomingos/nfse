nfse-bh
====

## API para geração, assinatura, envio, consulta e cancelamento de Nota Fiscal de Serviços Eletrônica da Prefeitura de Belo Horizonte

### Serviços ativos

- [x] Geração de NFSe
- [x] Consulta de NFSe por RPS
- [ ] Recepção de Lote de RPS
- [x] Consulta de situação de lote
- [ ] Consulta de NFSe
- [ ] Consulta de Lote de RPS
- [ ] Cancelamento de NFSe
- [x] Gera arquivo de Cadeia de Certificados
- [x] Assina XML com certificado digital A1
- [x] Assina XML com certificado digital A3

Fique à vontade para contribuir ou solicitar melhorias.

### Geração de NFSe

Esse serviço compreende a recepção do Lote de até 3 (três) RPS.

#### Exemplo de uso

```java
RpsTomadorEndereco endereco = new TomadorEnderecoBuilder()
        .comLogradouro("Rua Teste")
        .comNumeroEndereco("100")
        .comBairro("Bairro Teste")
        .comCep("32000000")
        .comCodigoMunicipio("3118601")
        .comUf("MG")
        .build();

RpsTomadorContato contato = new TomadorContatoBuilder()
        .comEmail("email@gmail.com")
        .build();

RpsTomador tomador = new TomadorBuilder("documentoCpfCnpj")
        .comNome("Nome Teste")
        .comContato(contato)
        .comEndereco(endereco)
        .build();  

RpsPrestador prestador = new PrestadorBuilder("cnpj")
        .comInscricaoMunicipal("0000000000")
        .build();

RpsValores valores = new ValoresBuilder(valorServicos, aliquota)
        .comIssRetido(false)
        .build();

RpsServico servicoPrestado = new ServicoBuilder(valores, "1.05")
        .comCodigoCnae(0000000)
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

Rps rps = new Rps(rpsInfo);

LoteRps loteRps = new LoteRpsBuilder("1000")
        .comCnpj("00000000000000")
        .comInscricaoMunicipal("00000000000")
        .comVersao(LoteRpsVersao.V1_00)
        .addRps(rps)
        .build();

RpsEnvio nfseEnvio = new RpsEnvio(loteRps);

String xml = nfseEnvio.converterParaXml();
```

### Consulta de NFSe por RPS

Esse serviço efetua a consulta de uma NFS-e a partir do número de RPS que a gerou

#### Exemplo de uso

```java
RpsPrestador prestador = new PrestadorBuilder("cnpj")
        .comInscricaoMunicipal("0000000000")
        .build();

RpsConsulta rpsConsulta = new RpsConsulta(new RpsIdentificacaoRps("92"), prestador);

String xml = rpsConsulta.converterParaXml();
```

### Assina XML com certificado digital

Esse serviço assina XML com certificado digital

#### Exemplo de uso

```java
CertificadoConfig config = new CertificadoConfigBuilder(TipoCertificado.A3_TOKEN, "senha")
        .comAmbiente(NFSeAmbiente.HOMOLOGACAO)
        .build();

AssinaturaDigital assinatura = new AssinaturaDigital(config);

String xmlAssinado = assinatura.assinarXML(xml);
```
