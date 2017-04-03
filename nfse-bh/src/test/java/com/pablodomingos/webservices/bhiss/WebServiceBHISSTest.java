package com.pablodomingos.webservices.bhiss;

import com.pablodomingos.assinatura.TipoCertificado;
import com.pablodomingos.classes.FabricaDeObjetosFake;
import com.pablodomingos.classes.rps.LoteRps;
import com.pablodomingos.classes.rps.builders.LoteRpsBuilder;
import com.pablodomingos.classes.rps.enums.NFSeModelo;
import com.pablodomingos.classes.rps.servicos.LoteRpsConsultaSituacao;
import com.pablodomingos.classes.rps.servicos.LoteRpsEnvio;
import com.pablodomingos.classes.rps.servicos.RpsEnvio;
import com.pablodomingos.config.CertificadoConfig;
import com.pablodomingos.util.FabricaDeBuildersFake;
import com.pablodomingos.util.NFSeGeraCadeiaCertificados;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.rpc.ServiceException;
import java.io.File;
import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public class WebServiceBHISSTest {
//    @Test
//    public void consultaWebServiceCorretamente() throws IOException {
//        String situacaoLoteRetornado = null;
//        CertificadoConfig certificadoConfig = new CertificadoConfig(
//            new CertificadoConfig.CertificadoConfigBuilder(TipoCertificado.A1, "MAQ2017")
//            .comCaminhoCertificadoCliente("/tmp/nfe.pfx")
//            .comCaminhoCadeiaDeCertificados("/tmp/homologacao.cacerts"));
//        LoteRpsConsultaSituacao consultaSituacaoLote = new LoteRpsConsultaSituacao("AP1057893n16X103sfhF4RPm", FabricaDeObjetosFake.getRpsPrestador());
//        String xml = consultaSituacaoLote.converterParaXml();
//        System.out.println("xml = " + xml);
//        try {
//            situacaoLoteRetornado = WebServiceBHISS.consultarSituacaoLoteRps(xml, certificadoConfig);
//            System.out.println("situacaoLoteRetornado = " + situacaoLoteRetornado);
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        } catch (KeyStoreException e) {
//            e.printStackTrace();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (CertificateException e) {
//            e.printStackTrace();
//        }
//        Assert.assertNotNull(situacaoLoteRetornado);
//    }

    @Test
    public void geraWebServiceCorretamente() throws IOException {
//        try {
//            FileUtils.writeByteArrayToFile(new File("/tmp/nfse-bh.cacerts"), NFSeGeraCadeiaCertificados.geraCadeiaCertificados("senha"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        String situacaoLoteRetornado = null;
        CertificadoConfig certificadoConfig = new CertificadoConfig(
                new CertificadoConfig.CertificadoConfigBuilder(TipoCertificado.A1, "MAQ2017")
                        .comCaminhoCertificadoCliente("/tmp/nfe.pfx")
                        .comCaminhoCadeiaDeCertificados("/tmp/nfse-bh.cacerts"));

//        situacaoLoteRetornado = <?xml version='1.0' encoding='UTF-8'?><GerarNfseResposta xmlns="http://www.abrasf.org.br/nfse.xsd"><ListaMensagemRetorno><MensagemRetorno><Codigo>E181</Codigo><Mensagem>O documento XML de entrada do servi�o esta fora do padrao especificado. (ParseError at [row,col]:[2,1]
//        Message: Esperado nome GerarNfseEnvio, mas foi encontrado EnviarLoteRpsEnvio)</Mensagem></MensagemRetorno></ListaMensagemRetorno></GerarNfseResposta>
//        LoteRpsEnvio loteRpsEnvio = new LoteRpsEnvio(new LoteRps(FabricaDeBuildersFake.getLoteRpsBuilder()));
        LoteRpsBuilder loteRpsBuilder = FabricaDeBuildersFake.getLoteRpsBuilder();
        RpsEnvio loteRpsEnvio = new RpsEnvio(new LoteRps(loteRpsBuilder));
        String xml = loteRpsEnvio.converterParaXml();
        System.out.println("xml = " + xml);
        try {
            situacaoLoteRetornado = WebServiceBHISS.gerarNfse(xml, certificadoConfig);
            System.out.println("situacaoLoteRetornado = " + situacaoLoteRetornado);
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(situacaoLoteRetornado);
    }
}
