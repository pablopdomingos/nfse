package com.pablodomingos.transformers;

import com.pablodomingos.classes.rps.enums.*;
import org.simpleframework.xml.transform.RegistryMatcher;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class NFRegistryMatcher extends RegistryMatcher {

    public NFRegistryMatcher() {
        super.bind(CodigoCancelamento.class, new NFCodigoCancelamentoTransformer());
        super.bind(ExigibilidadeIss.class, new NFExigibilidadeIssTransformer());
        super.bind(IncentivadorCultural.class, new NFIncentivadorCulturalTransformer());
        super.bind(IssRetido.class, new NFIssRetidoTransformer());
        super.bind(LocalDateTime.class, new NFLocalDateTimeTransformer());
        super.bind(LocalDate.class, new NFLocalDateTransformer());
        super.bind(LoteRpsVersao.class, new NFLoteRpsVersaoTransformer());
        super.bind(NaturezaOperacao.class, new NFNaturezaOperacaoTransformer());
        super.bind(OptanteSimplesNacional.class, new NFOptanteSimplesNacionalTransformer());
        super.bind(RegimeEspecialTributacao.class, new NFRegimeEspecialTributacaoTransformer());
        super.bind(RpsStatus.class, new NFRpsStatusTransformer());
        super.bind(RpsTipo.class, new NFRpsTipoTransformer());
        super.bind(NFSeAmbiente.class, new NFSeAmbienteTransformer());
        super.bind(SituacaoLoteRps.class, new NFSituacaoLoteRpsTransformer());
        super.bind(UfEstados.class, new NFUfEstadosTransformer());
    }
}