Nota Fiscal de Serviços
====

[![Join the chat at https://gitter.im/java-nfse/Lobby](https://badges.gitter.im/java-nfse/Lobby.svg)](https://gitter.im/java-nfse/Lobby?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
[![Build Status](https://travis-ci.org/pablopdomingos/nfse.svg?branch=master)](http://travis-ci.org/#!/pablopdomingos/nfse)
[![MIT licensed](https://img.shields.io/badge/license-MIT-blue.svg)](https://github.com/pablopdomingos/nfse/blob/master/LICENSE)

## API para geração, assinatura, envio, consulta e cancelamento de Nota Fiscal de Serviços Eletrônica da Prefeitura de Belo Horizonte

### Serviços ativos

- [x] [Geração de NFSe](https://github.com/pablopdomingos/nfse/wiki/Gera%C3%A7%C3%A3o-de-NFSe)
- [x] [Consulta de NFSe por RPS](https://github.com/pablopdomingos/nfse/wiki/Consulta-de-NFSe)
- [x] [Envio de Lote de RPS](https://github.com/pablopdomingos/nfse/wiki/Envio-de-Lote-de-RPS)
- [x] [Consulta de situação de lote](https://github.com/pablopdomingos/nfse/wiki/Consulta-Situa%C3%A7%C3%A3o-de-Lote-de-NFSe)
- [x] [Consulta de NFSe por período](https://github.com/pablopdomingos/nfse/wiki/Consulta-de-NFSe-por-per%C3%ADodo)
- [x] [Consulta de Lote de RPS](https://github.com/pablopdomingos/nfse/wiki/Consulta-de-Lote-de-RPS)
- [x] [Cancelamento de NFSe](https://github.com/pablopdomingos/nfse/wiki/Cancelamento-de-NFSe)
- [x] [Gera arquivo de Cadeia de Certificados](https://github.com/pablopdomingos/nfse/wiki/Gerar-cadeia-de-certificados-da-PBH)
- [x] [Assina XML certificado digital](https://github.com/pablopdomingos/nfse/wiki/Assinar-XML-com-certificado-digital)

Fique à vontade para contribuir ou solicitar melhorias.

### Utilização

#### Maven

```maven
<dependency>
	<groupId>com.github.pablopdomingos</groupId>
	<artifactId>nfse-bh</artifactId>
	<version>1.0.1</version>
</dependency>
```

#### Gradle

```gradle
dependencies {
  compile 'com.github.pablopdomingos:nfse-bh:1.0.1'
}
```

### Changelog

1.0.2 - Atualização URLs para os ambientes de homologação e produção

1.0.1 - Lançamento para ambiente de produção

1.0 - Lançamento Inicial (Suporte somente ao ambiente de homologação)
