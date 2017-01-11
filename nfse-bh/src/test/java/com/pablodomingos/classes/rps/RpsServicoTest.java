package com.pablodomingos.classes.rps;

import javax.validation.ConstraintViolationException;

import org.junit.Test;

import com.pablodomingos.classes.FabricaDeObjetosFake;
import com.pablodomingos.classes.rps.builders.ServicoBuilder;

public class RpsServicoTest {

  @Test(expected = ConstraintViolationException.class)
  public void naoDevePermitirCodItemServicoTamanhoInvalido() throws Exception {
    try {
      new ServicoBuilder(FabricaDeObjetosFake.getRpsValores(), "01.010")
          .comDiscriminacao("Teste Discriminacao")
          .comCodigoMunicipio("3106200")
          .build();
    } catch (final ConstraintViolationException e) {
      new ServicoBuilder(FabricaDeObjetosFake.getRpsValores(), "")
          .comDiscriminacao("Teste Discriminacao")
          .comCodigoMunicipio("3106200")
          .build();
    }
  }

  @Test(expected = ConstraintViolationException.class)
  public void naoDevePermitirDiscriminacaoTamanhoInvalido() throws Exception {
    try {
      new ServicoBuilder(FabricaDeObjetosFake.getRpsValores(), "01.01")
          .comDiscriminacao("")
          .comCodigoMunicipio("3106200")
          .build();
    } catch (final ConstraintViolationException e) {
      new ServicoBuilder(FabricaDeObjetosFake.getRpsValores(), "01.01")
          .comDiscriminacao("CDNterVqoOPxtwVUXCwtnPVhJmqJzNlnJRdxXNKBRnkjvImHvEXQhJzWhLnXzhrLaDlCYKsiXgrTWVhToaKYcqTdvxEQnkTbybrnOJqFHDCpUtLacBewYgytAlromisrnSFgLYhkYPXNRtulSMGJefbenVdwKUnhWqkJrUBkEtRjikEhsKqrpsEhoydNmeuvSNhcFfzQBGjoyhvqqSAyoAAokvILMYgDJVzAjLSsVcwnWURgTdgHVVRUxHKstidTeDGRZkiwXEjeTkWKNWkRfKBJoYGYUrdNitSiOLgxLyxaBIrhRDjbPfylFvVWnhLnUIQzdNjVwXOEayluHIlWDtNuSZVnMwNxaDqPEgEYslesCURICKTaUgICisWtKASMpAISgpIfbfSmPYaqjqfWNYmXfakAuoQfBVYngdknoEIWsbFFCvjrrSFrjwNBUljNPMSHxbrjqkwFhXOsksFXfzOEWEWkeWihdpqnIvusjtPxOEVfOOUsvgbORgFTlzzKfoiDmNTWFvxvYYKOEURJHuVKzWGXUKMpbuohPxYCxtXmpDBxlaSaOeEmioNWCwJkATJqZeyqFEofiNidRgtjwwYNioVYuedlVdhdBcwmkCRTrLRFRCnBYxeMrPspCSjdyidfcZZqGbKzhTBFxDpOfhQTMZNDHAbTMWFDWpbwPQMiFefQnuWAafzjnvOUCHtZNNSIxQVSdlgEcpvNdacPQZYiqyRfEztwVkDaKUBGWFgMqGrYnLsDGOlLpIZYrhuSiwnKgSeieiFKcOATQrxNFYFyGuOGrntKthihUzQigyYyOoFbqLivuwJGUhjShCaqVIMPIVeTMzyLovoSiNokoPXSCQTGJIsBepdQXZnCpNSoaHqlNkfNCkhvxgoOJQfKwcBCKczRWpJsSdkzfokFdGkhlBOgZiAKlWbJrDUrEoGjMSFyuEMcwtVuHehPbSGpmtFCapKVTkCeRhtrBrFMfCIWnopAuyWFpEIRrjzCbMLDoMNTjyuFYIfXClMsxrUQSYZhYriBAFujEhcUnhrPtcGLRCswPhzGZYPwgzeHtSMNPqdvxxNKzAxFhfULIWAopxGkWnAMZSEfMCPVJSBciJIFBUXVtATCGLGwVRjYGBzyFkDzfjPKbjQUPHvMoSwsqOaAPrHAsWDQjchNKKQYdPhufHmydfMzbQSqwCrdmdnoEGNCvZNmHlqIyUgtEDvHbmFZOVipzWCHUuWuyxGJXNQsYKDMnSXhabJebIITXsvfCdwUYHahlXGPCAEZgKpZhwKcCALYMcyzqfsIfnHIXDUTNnjBNenCNmnLFPZCxfxhDkhwJKkLncXlMaZLesczHunkpJtDfkMRJrrKednSmDtTXKqCuRRfEGAoszaqUQteszsuPveAxHlUVpmjJQpLvUJEQednKpZNNHZKbGHmxvcxhEpWSpmDUZOnJfnfdQvPCZrLpnTBURPfepanwycpFCOETFgcIWCSQYegSESGoqvSVnYNRVCuaCfEQBMGOqnfMuWkcooFQnTMkCvFDTWOsGGssuFFbKZrbyhaPFhAmVTxYSPlxgJdTuecnCAJgHSeFEUxqFYDzwgvwCTRcJwmRVBTVdsNMVdFVjAyKUMxSfxfdNSLXimbqNrjrhXpMKZwfeNvqNDQOSeOPXdHCXRtTfXNfHLVslwBfZkjLzFbbGbHAsCxdMCIfcNTOqHwhjkbisryMyYgWhXNveorfEcFrneoYnmWDOcFSydJrUDXkPGhKSBgBnhSDiJPbduUQlplNhJxvmJguBitjgxCIwHaHUBwfFuQIxRgxGiywIvxsYNAKpLprmbgYbcphxUFhmfcPOfUgbdcYZMhpcvDKmfLEGTyjNgPXOAdABDZukbQzPgyCTljildDuHFVtGMvjKAfEbTucLBtveugeRwujWNZvBNIbfEkyBUfpsmZtUmifNQWEsPKRzWHckZeybSPYBRsUWBzEUJmFFFAVNugoSjRzYyJPnUYNCnwYDzoc")
          .comCodigoMunicipio("3106200")
          .build();
    }
  }

  @Test(expected = ConstraintViolationException.class)
  public void naoDevePermitirCodMunicipioTamanhoInvalido() throws Exception {
    try {
      new ServicoBuilder(FabricaDeObjetosFake.getRpsValores(), "01.01")
          .comDiscriminacao("Descricao Teste")
          .comCodigoMunicipio("")
          .build();
    } catch (final ConstraintViolationException e) {
      new ServicoBuilder(FabricaDeObjetosFake.getRpsValores(), "01.01")
          .comDiscriminacao("Descricao Teste")
          .comCodigoMunicipio("31062005")
          .build();
    }
  }

  @Test(expected = ConstraintViolationException.class)
  public void naoDevePermitirCodCnaeTamanhoInvalido() throws Exception {
    try {
      new ServicoBuilder(FabricaDeObjetosFake.getRpsValores(), "01.01")
          .comDiscriminacao("Descricao Teste")
          .comCodigoCnae("")
          .comCodigoMunicipio("3106200")
          .build();
    } catch (final ConstraintViolationException e) {
      new ServicoBuilder(FabricaDeObjetosFake.getRpsValores(), "01.01")
          .comDiscriminacao("Descricao Teste")
          .comCodigoCnae("00000000")
          .comCodigoMunicipio("3106200")
          .build();
    }
  }

  @Test(expected = ConstraintViolationException.class)
  public void naoDevePermitirCodTributacaoTamanhoInvalido() throws Exception {
    try {
      new ServicoBuilder(FabricaDeObjetosFake.getRpsValores(), "01.01")
          .comDiscriminacao("Descricao Teste")
          .comCodigoCnae("0000000")
          .comCodigoTributacaoMunicipio("")
          .comCodigoMunicipio("3106200")
          .build();
    } catch (final ConstraintViolationException e) {
      new ServicoBuilder(FabricaDeObjetosFake.getRpsValores(), "01.01")
          .comDiscriminacao("Descricao Teste")
          .comCodigoCnae("0000000")
          .comCodigoTributacaoMunicipio("000000000000000000000")
          .comCodigoMunicipio("3106200")
          .build();
    }
  }

  @Test(expected = ConstraintViolationException.class)
  public void naoDevePermitirServicoSemDiscriminacao() throws Exception {
    new ServicoBuilder(FabricaDeObjetosFake.getRpsValores(), "01.01")
        .comCodigoCnae("0000000")
        .comCodigoTributacaoMunicipio("00000000000000000000")
        .comCodigoMunicipio("3106200")
        .build();
  }

  @Test(expected = ConstraintViolationException.class)
  public void naoDevePermitirServicoSemCodMunicipio() throws Exception {
    new ServicoBuilder(FabricaDeObjetosFake.getRpsValores(), "01.01")
        .comDiscriminacao("Descricao Teste")
        .comCodigoCnae("0000000")
        .comCodigoTributacaoMunicipio("00000000000000000000")
        .build();
  }
}
